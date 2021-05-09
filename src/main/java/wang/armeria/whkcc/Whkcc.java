package wang.armeria.whkcc;

import java.text.MessageFormat;
import java.io.IOException;

import wang.armeria.token.Position;


/**
 * 基于LALR(1)文法的语法分析系统，分析对象为类C语言文法
 */
public class Whkcc {

    private boolean yyErrorVerbose = true;

    /**
     * 符号类型
     */
    public enum SymbolKind {
        S_YYEOF(0),
        S_YYerror(1),
        S_YYUNDEF(2),
        S_DT_INTEGER(3),
        S_DT_BOOLEAN(4),
        S_DT_FLOAT(5),
        S_STRUCT(6),
        S_WHILE(7),
        S_IF(8),
        S_ELSE(9),
        S_RETURN(10),
        S_FUNCTION(11),
        S_CONST_INTEGER(12),
        S_CONST_FLOAT(13),
        S_CONST_STRING(14),
        S_CONST_BOOLEAN(15),
        S_ID(16),
        S_SEMICOLON(17),
        S_COMMA(18),
        S_DOT(19),
        S_ROUND_LEFT(20),
        S_ROUND_RIGHT(21),
        S_SQUARE_LEFT(22),
        S_SQUARE_RIGHT(23),
        S_BEGIN(24),
        S_END(25),
        S_ASSIGN(26),
        S_LOR(27),
        S_LAND(28),
        S_BOR(29),
        S_BXOR(30),
        S_APSAND(31),
        S_EQ(32),
        S_NE(33),
        S_LE(34),
        S_GE(35),
        S_LT(36),
        S_GT(37),
        S_PLUS(38),
        S_MINUS(39),
        S_STAR(40),
        S_DIVIDE(41),
        S_MOD(42),
        S_GET_ADDR(43),
        S_POSITIVE(44),
        S_NEGATIVE(45),
        S_YYACCEPT(46),
        S_PROGRAM(47),
        S_TOP_STATEMENTS(48),
        S_STATEMENTS_BLOCK(49),
        S_STATEMENTS(50),
        S_STATEMENT(51),
        S_EXP_R(52),
        S_EXP_L(53),
        S_HD_ARRAY(54),
        S_MORE_ARRAY_DIM(55),
        S_NUMBER(56),
        S_STATEMENT_IF(57),
        S_STATEMENT_ELSE(58),
        S_STATEMENT_WHILE(59),
        S_WHILE_BODY(60),
        S_STATEMENT_VAR_DEF(61),
        S_DECLARE_MORE(62),
        S_DECLARE_NON_INITIALIZE(63),
        S_DECLARE_INITIALIZE(64),
        S_STATEMENT_ASSIGN(65),
        S_STATEMENT_STRUCT_DEF(66),
        S_MORE_STRUCT_MEMBER_DEF(67),
        S_STRUCT_MEMBER_DEF(68),
        S_DECLARE_MORE_NON_INITIALIZE(69),
        S_STATEMENT_RETURN(70),
        S_FUNC_CALL(71),
        S_SEND_FUNC_ARGS(72),
        S_STATEMENT_FUNC_DEF(73),
        S_RECV_FUNC_ARGS(74),
        S_SINGLE_RECV_FUNC_ARG(75),
        S_RECV_HD_ARRAY(76),
        S_MORE_RECV_HD_ARRAY_DIM(77),
        S_DT_STRUCT(78),
        S_DT_POINTER(79),
        S_VAR_DEF_TYPE(80),
        S_FUNC_DEF_TYPE(81);

        private final int yycode_;

        SymbolKind(int n) {
            this.yycode_ = n;
        }

        private static final SymbolKind[] values_ = {
                SymbolKind.S_YYEOF,
                SymbolKind.S_YYerror,
                SymbolKind.S_YYUNDEF,
                SymbolKind.S_DT_INTEGER,
                SymbolKind.S_DT_BOOLEAN,
                SymbolKind.S_DT_FLOAT,
                SymbolKind.S_STRUCT,
                SymbolKind.S_WHILE,
                SymbolKind.S_IF,
                SymbolKind.S_ELSE,
                SymbolKind.S_RETURN,
                SymbolKind.S_FUNCTION,
                SymbolKind.S_CONST_INTEGER,
                SymbolKind.S_CONST_FLOAT,
                SymbolKind.S_CONST_STRING,
                SymbolKind.S_CONST_BOOLEAN,
                SymbolKind.S_ID,
                SymbolKind.S_SEMICOLON,
                SymbolKind.S_COMMA,
                SymbolKind.S_DOT,
                SymbolKind.S_ROUND_LEFT,
                SymbolKind.S_ROUND_RIGHT,
                SymbolKind.S_SQUARE_LEFT,
                SymbolKind.S_SQUARE_RIGHT,
                SymbolKind.S_BEGIN,
                SymbolKind.S_END,
                SymbolKind.S_ASSIGN,
                SymbolKind.S_LOR,
                SymbolKind.S_LAND,
                SymbolKind.S_BOR,
                SymbolKind.S_BXOR,
                SymbolKind.S_APSAND,
                SymbolKind.S_EQ,
                SymbolKind.S_NE,
                SymbolKind.S_LE,
                SymbolKind.S_GE,
                SymbolKind.S_LT,
                SymbolKind.S_GT,
                SymbolKind.S_PLUS,
                SymbolKind.S_MINUS,
                SymbolKind.S_STAR,
                SymbolKind.S_DIVIDE,
                SymbolKind.S_MOD,
                SymbolKind.S_GET_ADDR,
                SymbolKind.S_POSITIVE,
                SymbolKind.S_NEGATIVE,
                SymbolKind.S_YYACCEPT,
                SymbolKind.S_PROGRAM,
                SymbolKind.S_TOP_STATEMENTS,
                SymbolKind.S_STATEMENTS_BLOCK,
                SymbolKind.S_STATEMENTS,
                SymbolKind.S_STATEMENT,
                SymbolKind.S_EXP_R,
                SymbolKind.S_EXP_L,
                SymbolKind.S_HD_ARRAY,
                SymbolKind.S_MORE_ARRAY_DIM,
                SymbolKind.S_NUMBER,
                SymbolKind.S_STATEMENT_IF,
                SymbolKind.S_STATEMENT_ELSE,
                SymbolKind.S_STATEMENT_WHILE,
                SymbolKind.S_WHILE_BODY,
                SymbolKind.S_STATEMENT_VAR_DEF,
                SymbolKind.S_DECLARE_MORE,
                SymbolKind.S_DECLARE_NON_INITIALIZE,
                SymbolKind.S_DECLARE_INITIALIZE,
                SymbolKind.S_STATEMENT_ASSIGN,
                SymbolKind.S_STATEMENT_STRUCT_DEF,
                SymbolKind.S_MORE_STRUCT_MEMBER_DEF,
                SymbolKind.S_STRUCT_MEMBER_DEF,
                SymbolKind.S_DECLARE_MORE_NON_INITIALIZE,
                SymbolKind.S_STATEMENT_RETURN,
                SymbolKind.S_FUNC_CALL,
                SymbolKind.S_SEND_FUNC_ARGS,
                SymbolKind.S_STATEMENT_FUNC_DEF,
                SymbolKind.S_RECV_FUNC_ARGS,
                SymbolKind.S_SINGLE_RECV_FUNC_ARG,
                SymbolKind.S_RECV_HD_ARRAY,
                SymbolKind.S_MORE_RECV_HD_ARRAY_DIM,
                SymbolKind.S_DT_STRUCT,
                SymbolKind.S_DT_POINTER,
                SymbolKind.S_VAR_DEF_TYPE,
                SymbolKind.S_FUNC_DEF_TYPE
        };

        static final SymbolKind get(int code) {
            return values_[code];
        }

        /**
         * 获取本符号的编号
         *
         * @return 本符号的编号
         */
        public final int getCode() {
            return this.yycode_;
        }

        private static String yytnamerr_(String yystr) {
            if (yystr.charAt(0) == '"') {
                StringBuffer yyr = new StringBuffer();
                strip_quotes:
                for (int i = 1; i < yystr.length(); i++)
                    switch (yystr.charAt(i)) {
                        case '\'':
                        case ',':
                            break strip_quotes;

                        case '\\':
                            if (yystr.charAt(++i) != '\\')
                                break strip_quotes;

                        default:
                            yyr.append(yystr.charAt(i));
                            break;

                        case '"':
                            return yyr.toString();
                    }
            }
            return yystr;
        }

        private static final String[] yytname_ = yytname_init();

        private static final String[] yytname_init() {
            return new String[]
                    {
                            "\"end of file\"", "error", "\"invalid token\"", "DT_INTEGER",
                            "DT_BOOLEAN", "DT_FLOAT", "STRUCT", "WHILE", "IF", "ELSE", "RETURN",
                            "FUNCTION", "CONST_INTEGER", "CONST_FLOAT", "CONST_STRING",
                            "CONST_BOOLEAN", "ID", "SEMICOLON", "COMMA", "DOT", "ROUND_LEFT",
                            "ROUND_RIGHT", "SQUARE_LEFT", "SQUARE_RIGHT", "BEGIN", "END", "ASSIGN",
                            "LOR", "LAND", "BOR", "BXOR", "APSAND", "EQ", "NE", "LE", "GE", "LT",
                            "GT", "PLUS", "MINUS", "STAR", "DIVIDE", "MOD", "GET_ADDR", "POSITIVE",
                            "NEGATIVE", "$accept", "PROGRAM", "TOP_STATEMENTS", "STATEMENTS_BLOCK",
                            "STATEMENTS", "STATEMENT", "EXP_R", "EXP_L", "HD_ARRAY",
                            "MORE_ARRAY_DIM", "NUMBER", "STATEMENT_IF", "STATEMENT_ELSE",
                            "STATEMENT_WHILE", "WHILE_BODY", "STATEMENT_VAR_DEF", "DECLARE_MORE",
                            "DECLARE_NON_INITIALIZE", "DECLARE_INITIALIZE", "STATEMENT_ASSIGN",
                            "STATEMENT_STRUCT_DEF", "MORE_STRUCT_MEMBER_DEF", "STRUCT_MEMBER_DEF",
                            "DECLARE_MORE_NON_INITIALIZE", "STATEMENT_RETURN", "FUNC_CALL",
                            "SEND_FUNC_ARGS", "STATEMENT_FUNC_DEF", "RECV_FUNC_ARGS",
                            "SINGLE_RECV_FUNC_ARG", "RECV_HD_ARRAY", "MORE_RECV_HD_ARRAY_DIM",
                            "DT_STRUCT", "DT_POINTER", "VAR_DEF_TYPE", "FUNC_DEF_TYPE", null
                    };
        }

        /* 本符号面向用户的名称  */
        public final String getName() {
            return yytnamerr_(yytname_[yycode_]);
        }

    }

    /**
     * 面向用户的语法分析器类
     */
    public interface Lexer {

       int YYEOF = 0;
       int YYerror = 256;
       int YYUNDEF = 257;
       int DT_INTEGER = 258;
       int DT_BOOLEAN = 259;
       int DT_FLOAT = 260;
       int STRUCT = 261;
       int WHILE = 262;
       int IF = 263;
       int ELSE = 264;
       int RETURN = 265;
       int FUNCTION = 266;
       int CONST_INTEGER = 267;
       int CONST_FLOAT = 268;
       int CONST_STRING = 269;
       int CONST_BOOLEAN = 270;
       int ID = 271;
       int SEMICOLON = 272;
       int COMMA = 273;
       int DOT = 274;
       int ROUND_LEFT = 275;
       int ROUND_RIGHT = 276;
       int SQUARE_LEFT = 277;
       int SQUARE_RIGHT = 278;
       int BEGIN = 279;
       int END = 280;
       int ASSIGN = 281;
       int LOR = 282;
       int LAND = 283;
       int BOR = 284;
       int BXOR = 285;
       int APSAND = 286;
       int EQ = 287;
       int NE = 288;
       int LE = 289;
       int GE = 290;
       int LT = 291;
       int GT = 292;
       int PLUS = 293;
       int MINUS = 294;
       int STAR = 295;
       int DIVIDE = 296;
       int MOD = 297;
       int GET_ADDR = 298;
       int POSITIVE = 299;
       int NEGATIVE = 300;

        /**
         * 获取最后扫描到的token的语义值
         *
         * @return 最后扫描到的token的语义值
         */
        Object getLVal();

        /**
         * 获取下一个token的类型，并准备好该token的语义值
         *
         * @return 下一个token的类型
         * @throws java.io.IOException 发生I/O错误
         */
        int yylex() throws java.io.IOException;

        /**
         * 打印错误信息
         *
         * @param msg 错误信息
         */
        void yyerror(String msg);

    }

    private Lexer yylexer;

    /**
     * 新建语法分析系统实例
     *
     * @param yylexer 面向用户的语法分析器类
     */
    public Whkcc(Lexer yylexer) {

        this.yylexer = yylexer;

    }

    /**
     * 通过语法分析器打印错误信息
     *
     * @param msg 错误信息
     */
    public final void yyerror(String msg) {
        yylexer.yyerror(msg);
    }

    private final class YYStack {
        private int[] stateStack = new int[16];
        private Object[] valueStack = new Object[16];

        public int size = 16;
        public int height = -1;

        public final void push(int state, Object value) {
            height++;
            if (size == height) {
                int[] newStateStack = new int[size * 2];
                System.arraycopy(stateStack, 0, newStateStack, 0, height);
                stateStack = newStateStack;

                Object[] newValueStack = new Object[size * 2];
                System.arraycopy(valueStack, 0, newValueStack, 0, height);
                valueStack = newValueStack;

                size *= 2;
            }

            stateStack[height] = state;
            valueStack[height] = value;
        }

        public final void pop() {
            pop(1);
        }

        public final void pop(int num) {
            if (0 < num) {
                java.util.Arrays.fill(valueStack, height - num + 1, height + 1, null);
            }
            height -= num;
        }

        public final int stateAt(int i) {
            return stateStack[height - i];
        }

        public final Object valueAt(int i) {
            return valueStack[height - i];
        }

        public void print(java.io.PrintStream out) {
            out.print("Stack now");

            for (int i = 0; i <= height; i++) {
                out.print(' ');
                out.print(stateStack[i]);
            }
            out.println();
        }
    }

    /**
     * 信号常量：语法树解析成功 (<code>true</code>).
     */
    public static final int YYACCEPT = 0;

    /**
     * 信号常量：解析失败，终止解析 (<code>false</code>).
     */
    public static final int YYABORT = 1;

    private static final int YYERRLAB = 3;
    private static final int YYNEWSTATE = 4;
    private static final int YYDEFAULT = 5;
    private static final int YYREDUCE = 6;
    private static final int YYERRTOKEN = 7;
    private static final int YYRETURN = 8;

    private int yyerrstatus_ = 0;

    private int yyLRGotoState(int yystate, int yysym) {
        int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
        if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
            return yytable_[yyr];
        else
            return yydefgoto_[yysym - YYNTOKENS_];
    }

    private int yyaction(int yyn, YYStack yystack, int yylen) {

        Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

        if (yyn >= 2 && yyn <= 102) {
            wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);
        }

        yystack.pop(yylen);

        int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
        yystack.push(yystate, yyval);
        return YYNEWSTATE;
    }

    /**
     * 获取所期望的token列表和构造语法错误诊断所需的信息
     */
    public static final class Context {
        Context(YYStack stack, SymbolKind token) {
            yystack = stack;
            yytoken = token;
        }

        private YYStack yystack;

        /**
         * 获取当前lookahead token的类别
         *
         * @return 当前lookahead token的类别
         */
        public final SymbolKind getToken() {
            return yytoken;
        }

        private SymbolKind yytoken;
        static final int NTOKENS = Whkcc.YYNTOKENS_;

        int getExpectedTokens(SymbolKind yyarg[], int yyoffset, int yyargn) {
            int yycount = yyoffset;
            int yyn = yypact_[this.yystack.stateAt(0)];
            if (!yyPactValueIsDefault(yyn)) {

                int yyxbegin = yyn < 0 ? -yyn : 0;
                int yychecklim = YYLAST_ - yyn + 1;
                int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
                for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
                    if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                            && !yyTableValueIsError(yytable_[yyx + yyn])) {
                        if (yyarg == null)
                            yycount += 1;
                        else if (yycount == yyargn)
                            return 0; // FIXME: this is incorrect.
                        else
                            yyarg[yycount++] = SymbolKind.get(yyx);
                    }
            }
            if (yyarg != null && yycount == yyoffset && yyoffset < yyargn)
                yyarg[yycount] = null;
            return yycount - yyoffset;
        }
    }

    private int yysyntaxErrorArguments(Context yyctx, SymbolKind[] yyarg, int yyargn) {

        int yycount = 0;
        if (yyctx.getToken() != null) {
            if (yyarg != null)
                yyarg[yycount] = yyctx.getToken();
            yycount += 1;
            yycount += yyctx.getExpectedTokens(yyarg, 1, yyargn);
        }
        return yycount;
    }

    private void yyreportSyntaxError(Context yyctx) {
        if (yyErrorVerbose) {
            final int argmax = 5;
            SymbolKind[] yyarg = new SymbolKind[argmax];
            int yycount = yysyntaxErrorArguments(yyctx, yyarg, argmax);
            String[] yystr = new String[yycount];
            for (int yyi = 0; yyi < yycount; ++yyi) {
                yystr[yyi] = yyarg[yyi].getName();
            }
            String yyformat;
            switch (yycount) {
                default:
                case 0:
                    yyformat = "syntax error";
                    break;
                case 1:
                    yyformat = "syntax error, unexpected {0}";
                    break;
                case 2:
                    yyformat = "syntax error, unexpected {0}, expecting {1}";
                    break;
                case 3:
                    yyformat = "syntax error, unexpected {0}, expecting {1} or {2}";
                    break;
                case 4:
                    yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3}";
                    break;
                case 5:
                    yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3} or {4}";
                    break;
            }
            yyerror(new MessageFormat(yyformat).format(yystr));
        } else {
            yyerror("syntax error");
        }
    }

    private static boolean yyPactValueIsDefault(int yyvalue) {
        return yyvalue == yypact_ninf_;
    }

    private static boolean yyTableValueIsError(int yyvalue) {
        return yyvalue == yytable_ninf_;
    }

    private static final short yypact_ninf_ = -170;
    private static final short yytable_ninf_ = -102;

    private static final short[] yypact_ = yypact_init();

    private static final short[] yypact_init() {
        return new short[]
                {
                        80, -170, -170, -170, -2, 103, 16, -170, 80, 80,
                        80, -170, -9, 0, 13, 17, 46, 48, -170, -18,
                        53, -170, -170, -170, -170, 1, 60, -170, 72, 72,
                        108, -170, -170, 58, 150, 150, 8, -170, -170, -9,
                        -170, -170, 108, -8, 7, -170, -170, -170, -170, 51,
                        150, 71, 150, 150, 335, -170, 74, -170, -170, 411,
                        150, 72, 72, 69, 108, 82, 100, 99, 110, 118,
                        119, 71, 117, 253, 55, -170, -170, -170, 125, 150,
                        150, 150, 150, 150, 150, 150, 150, 150, 150, 150,
                        150, 150, 150, 150, 150, 71, 411, -170, -170, 122,
                        -170, 82, -8, 123, 254, -170, 103, 131, 132, -170,
                        -170, -170, 214, -170, 150, -170, 426, 440, 453, 465,
                        476, 173, 173, 59, 59, 59, 59, 85, 85, -170,
                        -170, -170, -170, -170, 99, -170, 137, 138, 150, -170,
                        -170, 134, 168, 141, -170, -170, -170, -170, -170, -170,
                        143, 118, 110, 130, 150, 156, 355, -170, 150, 150,
                        163, -170, -170, 150, -170, -170, -170, 157, 375, 214,
                        -170, 125, 275, 297, -170, 189, 150, -170, 157, -170,
                        -170, 337, 110, -170, 395, -170, -170, -170, -170, 174,
                        157, 12, -170, -170, -170, -170
                };
    }

    private static final byte[] yydefact_ = yydefact_init();

    private static final byte[] yydefact_init() {
        return new byte[]
                {
                        6, 95, 97, 96, 0, 0, 0, 2, 6, 6,
                        6, 98, 0, 93, 95, 97, 96, 0, 102, 0,
                        0, 1, 3, 5, 4, 65, 0, 67, 0, 0,
                        0, 93, 94, 0, 0, 0, 66, 68, 62, 0,
                        61, 60, 74, 0, 0, 50, 52, 40, 51, 43,
                        0, 0, 0, 0, 0, 38, 45, 41, 42, 69,
                        0, 0, 0, 0, 74, 65, 0, 77, 0, 86,
                        0, 0, 0, 0, 43, 39, 35, 36, 49, 0,
                        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 0, 0, 70, 64, 63, 0,
                        73, 66, 0, 0, 0, 83, 0, 0, 87, 88,
                        44, 80, 82, 37, 0, 47, 30, 31, 32, 33,
                        34, 24, 23, 20, 22, 19, 21, 25, 26, 27,
                        28, 29, 46, 72, 77, 75, 0, 0, 0, 18,
                        8, 0, 10, 0, 13, 14, 11, 12, 15, 16,
                        0, 86, 0, 0, 0, 0, 0, 76, 0, 0,
                        0, 7, 9, 0, 17, 85, 84, 92, 0, 82,
                        79, 49, 0, 0, 78, 0, 0, 89, 92, 81,
                        48, 0, 0, 71, 0, 90, 58, 59, 57, 56,
                        92, 0, 53, 91, 54, 55
                };
    }

    private static final short[] yypgoto_ = yypgoto_init();

    private static final short[] yypgoto_init() {
        return new short[]
                {
                        -170, -170, 112, -86, 40, 5, -35, -32, 49, 62,
                        -170, 43, -170, -170, -170, -101, 6, -37, 148, -170,
                        -100, 171, 206, 104, -170, -99, 68, -170, 88, 159,
                        -170, -169, -170, -170, -4, 235
                };
    }

    private static final short[] yydefgoto_ = yydefgoto_init();

    private static final short[] yydefgoto_init() {
        return new short[]
                {
                        0, 6, 7, 105, 141, 142, 54, 55, 56, 115,
                        57, 144, 192, 145, 188, 8, 40, 28, 29, 147,
                        9, 63, 64, 103, 149, 58, 155, 10, 107, 69,
                        109, 177, 11, 18, 12, 70
                };
    }

    private static final short[] yytable_ = yytable_init();

    private static final short[] yytable_init() {
        return new short[]
                {
                        59, 19, 61, 146, 148, 150, 67, 25, 65, 185,
                        14, 15, 16, 17, 13, 73, 21, 76, 77, 75,
                        137, 193, 32, 34, 30, 96, 43, 35, 68, -99,
                        34, 26, 66, -101, 60, 41, 104, 112, 43, 110,
                        19, 146, 148, 150, 116, 117, 118, 119, 120, 121,
                        122, 123, 124, 125, 126, 127, 128, 129, 130, 131,
                        43, 27, -100, 132, 31, 134, 166, 97, 98, 33,
                        71, 72, 143, 34, 71, 37, 36, 34, 44, 156,
                        146, 148, 150, 1, 2, 3, 4, 74, 27, 38,
                        39, 5, 27, 95, 99, 186, 189, 90, 91, 92,
                        93, 94, 19, 160, 34, 194, 14, 15, 16, 17,
                        143, 1, 2, 3, 17, 37, 101, 102, 168, 169,
                        22, 23, 24, 172, 173, 92, 93, 94, 175, 45,
                        46, 47, 48, 49, 104, 108, 106, 50, 111, 133,
                        135, 184, 45, 46, 47, 48, 49, 114, 51, 143,
                        50, 27, 152, 167, 153, 52, 53, 158, 159, 161,
                        164, 51, 45, 46, 47, 48, 49, 163, 52, 53,
                        50, 1, 2, 3, 4, 136, 137, 170, 138, 176,
                        174, 51, 162, 191, 49, 139, 187, 62, 52, 53,
                        79, 80, 81, 82, 83, 84, 85, 86, 87, 88,
                        89, 90, 91, 92, 93, 94, 183, 86, 87, 88,
                        89, 90, 91, 92, 93, 94, 79, 80, 81, 82,
                        83, 84, 85, 86, 87, 88, 89, 90, 91, 92,
                        93, 94, 154, 180, 195, 100, 42, 179, 157, 165,
                        20, 79, 80, 81, 82, 83, 84, 85, 86, 87,
                        88, 89, 90, 91, 92, 93, 94, 1, 2, 3,
                        4, 136, 137, 0, 138, 151, 0, 0, 0, 0,
                        49, 139, 0, 0, 113, 0, 0, 0, 0, 140,
                        79, 80, 81, 82, 83, 84, 85, 86, 87, 88,
                        89, 90, 91, 92, 93, 94, 181, 0, 0, 0,
                        0, 0, 79, 80, 81, 82, 83, 84, 85, 86,
                        87, 88, 89, 90, 91, 92, 93, 94, 182, 0,
                        0, 0, 0, 0, 79, 80, 81, 82, 83, 84,
                        85, 86, 87, 88, 89, 90, 91, 92, 93, 94,
                        1, 2, 3, 4, 136, 137, 0, 138, 0, 0,
                        0, 0, 0, 49, 139, 0, 0, 0, 78, 0,
                        0, 104, 79, 80, 81, 82, 83, 84, 85, 86,
                        87, 88, 89, 90, 91, 92, 93, 94, 171, 0,
                        0, 0, 79, 80, 81, 82, 83, 84, 85, 86,
                        87, 88, 89, 90, 91, 92, 93, 94, 178, 0,
                        0, 0, 79, 80, 81, 82, 83, 84, 85, 86,
                        87, 88, 89, 90, 91, 92, 93, 94, 190, 0,
                        0, 0, 79, 80, 81, 82, 83, 84, 85, 86,
                        87, 88, 89, 90, 91, 92, 93, 94, 79, 80,
                        81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                        91, 92, 93, 94, 80, 81, 82, 83, 84, 85,
                        86, 87, 88, 89, 90, 91, 92, 93, 94, 81,
                        82, 83, 84, 85, 86, 87, 88, 89, 90, 91,
                        92, 93, 94, 82, 83, 84, 85, 86, 87, 88,
                        89, 90, 91, 92, 93, 94, 83, 84, 85, 86,
                        87, 88, 89, 90, 91, 92, 93, 94, 84, 85,
                        86, 87, 88, 89, 90, 91, 92, 93, 94
                };
    }

    private static final short[] yycheck_ = yycheck_init();

    private static final short[] yycheck_init() {
        return new short[]
                {
                        35, 5, 39, 104, 104, 104, 43, 16, 16, 178,
                        3, 4, 5, 6, 16, 50, 0, 52, 53, 51,
                        8, 190, 40, 22, 24, 60, 30, 26, 21, 16,
                        22, 40, 40, 16, 26, 29, 24, 72, 42, 71,
                        44, 142, 142, 142, 79, 80, 81, 82, 83, 84,
                        85, 86, 87, 88, 89, 90, 91, 92, 93, 94,
                        64, 12, 16, 95, 16, 102, 152, 61, 62, 16,
                        19, 20, 104, 22, 19, 26, 16, 22, 20, 114,
                        181, 181, 181, 3, 4, 5, 6, 16, 39, 17,
                        18, 11, 43, 19, 25, 181, 182, 38, 39, 40,
                        41, 42, 106, 138, 22, 191, 3, 4, 5, 6,
                        142, 3, 4, 5, 6, 66, 16, 18, 153, 154,
                        8, 9, 10, 158, 159, 40, 41, 42, 163, 12,
                        13, 14, 15, 16, 24, 16, 18, 20, 21, 17,
                        17, 176, 12, 13, 14, 15, 16, 22, 31, 181,
                        20, 102, 21, 23, 22, 38, 39, 20, 20, 25,
                        17, 31, 12, 13, 14, 15, 16, 26, 38, 39,
                        20, 3, 4, 5, 6, 7, 8, 21, 10, 22,
                        17, 31, 142, 9, 16, 17, 181, 39, 38, 39,
                        27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                        37, 38, 39, 40, 41, 42, 17, 34, 35, 36,
                        37, 38, 39, 40, 41, 42, 27, 28, 29, 30,
                        31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                        41, 42, 18, 171, 191, 64, 30, 169, 134, 151,
                        5, 27, 28, 29, 30, 31, 32, 33, 34, 35,
                        36, 37, 38, 39, 40, 41, 42, 3, 4, 5,
                        6, 7, 8, -1, 10, 106, -1, -1, -1, -1,
                        16, 17, -1, -1, 21, -1, -1, -1, -1, 25,
                        27, 28, 29, 30, 31, 32, 33, 34, 35, 36,
                        37, 38, 39, 40, 41, 42, 21, -1, -1, -1,
                        -1, -1, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 21, -1,
                        -1, -1, -1, -1, 27, 28, 29, 30, 31, 32,
                        33, 34, 35, 36, 37, 38, 39, 40, 41, 42,
                        3, 4, 5, 6, 7, 8, -1, 10, -1, -1,
                        -1, -1, -1, 16, 17, -1, -1, -1, 23, -1,
                        -1, 24, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 23, -1,
                        -1, -1, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 23, -1,
                        -1, -1, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 23, -1,
                        -1, -1, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 27, 28,
                        29, 30, 31, 32, 33, 34, 35, 36, 37, 38,
                        39, 40, 41, 42, 28, 29, 30, 31, 32, 33,
                        34, 35, 36, 37, 38, 39, 40, 41, 42, 29,
                        30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
                        40, 41, 42, 30, 31, 32, 33, 34, 35, 36,
                        37, 38, 39, 40, 41, 42, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 32, 33,
                        34, 35, 36, 37, 38, 39, 40, 41, 42
                };
    }

    private static final byte[] yystos_ = yystos_init();

    private static final byte[] yystos_init() {
        return new byte[]
                {
                        0, 3, 4, 5, 6, 11, 47, 48, 61, 66,
                        73, 78, 80, 16, 3, 4, 5, 6, 79, 80,
                        81, 0, 48, 48, 48, 16, 40, 54, 63, 64,
                        24, 16, 40, 16, 22, 26, 16, 54, 17, 18,
                        62, 62, 68, 80, 20, 12, 13, 14, 15, 16,
                        20, 31, 38, 39, 52, 53, 54, 56, 71, 52,
                        26, 63, 64, 67, 68, 16, 40, 63, 21, 75,
                        81, 19, 20, 52, 16, 53, 52, 52, 23, 27,
                        28, 29, 30, 31, 32, 33, 34, 35, 36, 37,
                        38, 39, 40, 41, 42, 19, 52, 62, 62, 25,
                        67, 16, 18, 69, 24, 49, 18, 74, 16, 76,
                        53, 21, 52, 21, 22, 55, 52, 52, 52, 52,
                        52, 52, 52, 52, 52, 52, 52, 52, 52, 52,
                        52, 52, 53, 17, 63, 17, 7, 8, 10, 17,
                        25, 50, 51, 53, 57, 59, 61, 65, 66, 70,
                        71, 75, 21, 22, 18, 72, 52, 69, 20, 20,
                        52, 25, 50, 26, 17, 74, 49, 23, 52, 52,
                        21, 23, 52, 52, 17, 52, 22, 77, 23, 72,
                        55, 21, 21, 17, 52, 77, 49, 51, 60, 49,
                        23, 9, 58, 77, 49, 57
                };
    }

    private static final byte[] yyr1_ = yyr1_init();

    private static final byte[] yyr1_init() {
        return new byte[]
                {
                        0, 46, 47, 48, 48, 48, 48, 49, 49, 50,
                        50, 51, 51, 51, 51, 51, 51, 51, 51, 52,
                        52, 52, 52, 52, 52, 52, 52, 52, 52, 52,
                        52, 52, 52, 52, 52, 52, 52, 52, 52, 52,
                        52, 52, 52, 53, 53, 53, 53, 54, 55, 55,
                        56, 56, 56, 57, 58, 58, 58, 59, 60, 60,
                        61, 61, 62, 62, 62, 63, 63, 63, 63, 64,
                        64, 65, 66, 67, 67, 68, 69, 69, 70, 71,
                        71, 72, 72, 73, 73, 74, 74, 75, 75, 76,
                        76, 77, 77, 78, 79, 80, 80, 80, 80, 81,
                        81, 81, 81
                };
    }

    private static final byte[] yyr2_ = yyr2_init();

    private static final byte[] yyr2_init() {
        return new byte[]
                {
                        0, 2, 1, 2, 2, 2, 0, 3, 2, 2,
                        1, 1, 1, 1, 1, 1, 1, 2, 1, 3,
                        3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
                        3, 3, 3, 3, 3, 2, 2, 3, 1, 2,
                        1, 1, 1, 1, 3, 1, 3, 5, 4, 0,
                        1, 1, 1, 6, 2, 2, 0, 5, 1, 1,
                        3, 3, 1, 3, 3, 1, 2, 1, 2, 3,
                        4, 4, 7, 2, 0, 4, 3, 0, 3, 5,
                        3, 3, 0, 6, 8, 3, 0, 2, 2, 4,
                        5, 4, 0, 2, 2, 1, 1, 1, 1, 1,
                        1, 1, 1
                };
    }

    private static final SymbolKind yytranslate_(int t) {
        // Last valid token kind.
        int code_max = 300;
        if (t <= 0)
            return SymbolKind.S_YYEOF;
        else if (t <= code_max)
            return SymbolKind.get(yytranslate_table_[t]);
        else
            return SymbolKind.S_YYUNDEF;
    }

    private static final byte[] yytranslate_table_ = yytranslate_table_init();

    private static final byte[] yytranslate_table_init() {
        return new byte[]
                {
                        0, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
                        2, 2, 2, 2, 2, 2, 1, 2, 3, 4,
                        5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                        15, 16, 17, 18, 19, 20, 21, 22, 23, 24,
                        25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
                        35, 36, 37, 38, 39, 40, 41, 42, 43, 44,
                        45
                };
    }

    private static final int YYLAST_ = 518;
    private static final int YYEMPTY_ = -2;
    private static final int YYFINAL_ = 21;
    private static final int YYNTOKENS_ = 46;

    /**
     * 读入词法分析器输出的程序token列表并解析其抽象语法树
     *
     * @return <code>true</code> 没有出现语法错误，解析成功
     * @throws java.io.IOException 发生I/O错误
     */
    public boolean parseMe() throws java.io.IOException {

        int yychar = YYEMPTY_;
        SymbolKind yytoken = null;

        int yyn = 0;
        int yylen = 0;
        int yystate = 0;
        Position yylpos = null;
        YYStack yystack = new YYStack();
        int label = YYNEWSTATE;

        Object yylval = null;

        yyerrstatus_ = 0;

        yystack.push(yystate, yylval);

        for (; ; )
            switch (label) {
                case YYNEWSTATE:

                    if (yystate == YYFINAL_)
                        return true;

                    yyn = yypact_[yystate];
                    if (yyPactValueIsDefault(yyn)) {
                        label = YYDEFAULT;
                        break;
                    }

                    if (yychar == YYEMPTY_) {
                        yychar = yylexer.yylex();
                        yylval = yylexer.getLVal();
                        yylpos = wl.getLPosition();
                    }

                    yytoken = yytranslate_(yychar);

                    if (yytoken == SymbolKind.S_YYerror) {

                        yychar = Lexer.YYUNDEF;
                        yytoken = SymbolKind.S_YYUNDEF;
                        label = YYERRTOKEN;
                    } else {
                        yyn += yytoken.getCode();
                        if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode())
                            label = YYDEFAULT;

                        else if ((yyn = yytable_[yyn]) <= 0) {
                            if (yyTableValueIsError(yyn))
                                label = YYERRLAB;
                            else {
                                yyn = -yyn;
                                label = YYREDUCE;
                            }
                        } else {
                            yychar = YYEMPTY_;

                            if (yyerrstatus_ > 0)
                                --yyerrstatus_;

                            yystate = yyn;
                            yystack.push(yystate, yylval);
                            wl.addTerminalNode(yytoken, yylpos, yylval);
                            label = YYNEWSTATE;
                        }
                    }
                    break;

                case YYDEFAULT:
                    yyn = yydefact_[yystate];
                    if (yyn == 0)
                        label = YYERRLAB;
                    else
                        label = YYREDUCE;
                    break;

                case YYREDUCE:
                    yylen = yyr2_[yyn];
                    label = yyaction(yyn, yystack, yylen);
                    yystate = yystack.stateAt(0);
                    break;

                case YYERRLAB:
                    if (yychar == YYEMPTY_)
                        yytoken = null;
                    yyreportSyntaxError(new Context(yystack, yytoken));
                    label = YYABORT;
                    break;

                case YYERRTOKEN:
                    System.err.println("Invalid token at position " + yylpos);
                    label = YYABORT;
                    break;

                case YYABORT:
                    return false;
            }
    }

    private static final WhkccLexer wl = WhkccLexer.getWhkccLexer();

    public static void main(String[] args) throws IOException {
        Whkcc p = new Whkcc(wl);
        if (!p.parseMe()) {
            System.exit(1);
        }
        wl.printASTree();
    }

}
