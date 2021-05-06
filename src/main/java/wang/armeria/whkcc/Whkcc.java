/* A Bison parser, made by GNU Bison 3.7.6.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java

   Copyright (C) 2007-2015, 2018-2021 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

package wang.armeria.whkcc;



import java.text.MessageFormat;
/* "%code imports" blocks.  */
/* "Whkcc.y":9  */

  import java.io.IOException;
  import wang.armeria.ast.ASTreeNode;
  import wang.armeria.token.Position;

/* "Whkcc.java":50  */

/**
 * A Bison parser, automatically generated from <tt>Whkcc.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
public class Whkcc
{
  /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "3.7.6";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";



  /**
   * True if verbose error messages are enabled.
   */
  private boolean yyErrorVerbose = true;

  /**
   * Whether verbose error messages are enabled.
   */
  public final boolean getErrorVerbose() { return yyErrorVerbose; }

  /**
   * Set the verbosity of error messages.
   * @param verbose True to request verbose error messages.
   */
  public final void setErrorVerbose(boolean verbose)
  { yyErrorVerbose = verbose; }




  public enum SymbolKind
  {
    S_YYEOF(0),                    /* "end of file"  */
    S_YYerror(1),                  /* error  */
    S_YYUNDEF(2),                  /* "invalid token"  */
    S_DT_INTEGER(3),               /* DT_INTEGER  */
    S_DT_BOOLEAN(4),               /* DT_BOOLEAN  */
    S_DT_FLOAT(5),                 /* DT_FLOAT  */
    S_STRUCT(6),                   /* STRUCT  */
    S_WHILE(7),                    /* WHILE  */
    S_IF(8),                       /* IF  */
    S_ELSE(9),                     /* ELSE  */
    S_RETURN(10),                  /* RETURN  */
    S_FUNCTION(11),                /* FUNCTION  */
    S_CONST_INTEGER(12),           /* CONST_INTEGER  */
    S_CONST_FLOAT(13),             /* CONST_FLOAT  */
    S_CONST_STRING(14),            /* CONST_STRING  */
    S_CONST_BOOLEAN(15),           /* CONST_BOOLEAN  */
    S_ID(16),                      /* ID  */
    S_SEMICOLON(17),               /* SEMICOLON  */
    S_COMMA(18),                   /* COMMA  */
    S_DOT(19),                     /* DOT  */
    S_ROUND_LEFT(20),              /* ROUND_LEFT  */
    S_ROUND_RIGHT(21),             /* ROUND_RIGHT  */
    S_SQUARE_LEFT(22),             /* SQUARE_LEFT  */
    S_SQUARE_RIGHT(23),            /* SQUARE_RIGHT  */
    S_BEGIN(24),                   /* BEGIN  */
    S_END(25),                     /* END  */
    S_ASSIGN(26),                  /* ASSIGN  */
    S_LOR(27),                     /* LOR  */
    S_LAND(28),                    /* LAND  */
    S_BOR(29),                     /* BOR  */
    S_BXOR(30),                    /* BXOR  */
    S_APSAND(31),                  /* APSAND  */
    S_EQ(32),                      /* EQ  */
    S_NE(33),                      /* NE  */
    S_LE(34),                      /* LE  */
    S_GE(35),                      /* GE  */
    S_LT(36),                      /* LT  */
    S_GT(37),                      /* GT  */
    S_PLUS(38),                    /* PLUS  */
    S_MINUS(39),                   /* MINUS  */
    S_STAR(40),                    /* STAR  */
    S_DIVIDE(41),                  /* DIVIDE  */
    S_MOD(42),                     /* MOD  */
    S_GET_ADDR(43),                /* GET_ADDR  */
    S_POSITIVE(44),                /* POSITIVE  */
    S_NEGATIVE(45),                /* NEGATIVE  */
    S_YYACCEPT(46),                /* $accept  */
    S_PROGRAM(47),                 /* PROGRAM  */
    S_TOP_STATEMENTS(48),          /* TOP_STATEMENTS  */
    S_STATEMENTS_BLOCK(49),        /* STATEMENTS_BLOCK  */
    S_STATEMENTS(50),              /* STATEMENTS  */
    S_STATEMENT(51),               /* STATEMENT  */
    S_EXP_R(52),                   /* EXP_R  */
    S_EXP_L(53),                   /* EXP_L  */
    S_NUMBER(54),                  /* NUMBER  */
    S_STATEMENT_IF(55),            /* STATEMENT_IF  */
    S_STATEMENT_ELSE(56),          /* STATEMENT_ELSE  */
    S_STATEMENT_WHILE(57),         /* STATEMENT_WHILE  */
    S_WHILE_BODY(58),              /* WHILE_BODY  */
    S_STATEMENT_VAR_DEF(59),       /* STATEMENT_VAR_DEF  */
    S_DECLARE_MORE(60),            /* DECLARE_MORE  */
    S_DECLARE_NON_INITIALIZE(61),  /* DECLARE_NON_INITIALIZE  */
    S_DECLARE_INITIALIZE(62),      /* DECLARE_INITIALIZE  */
    S_STATEMENT_ASSIGN(63),        /* STATEMENT_ASSIGN  */
    S_STATEMENT_STRUCT_DEF(64),    /* STATEMENT_STRUCT_DEF  */
    S_MORE_STRUCT_MEMBER_DEF(65),  /* MORE_STRUCT_MEMBER_DEF  */
    S_STRUCT_MEMBER_DEF(66),       /* STRUCT_MEMBER_DEF  */
    S_DECLARE_MORE_NON_INITIALIZE(67), /* DECLARE_MORE_NON_INITIALIZE  */
    S_STATEMENT_RETURN(68),        /* STATEMENT_RETURN  */
    S_FUNC_CALL(69),               /* FUNC_CALL  */
    S_SEND_FUNC_ARGS(70),          /* SEND_FUNC_ARGS  */
    S_STATEMENT_FUNC_DEF(71),      /* STATEMENT_FUNC_DEF  */
    S_RECV_FUNC_ARGS(72),          /* RECV_FUNC_ARGS  */
    S_SINGLE_RECV_FUNC_ARG(73),    /* SINGLE_RECV_FUNC_ARG  */
    S_DT_STRUCT(74),               /* DT_STRUCT  */
    S_DT_POINTER(75),              /* DT_POINTER  */
    S_VAR_DEF_TYPE(76),            /* VAR_DEF_TYPE  */
    S_FUNC_DEF_TYPE(77);           /* FUNC_DEF_TYPE  */


    private final int yycode_;

    SymbolKind (int n) {
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
      SymbolKind.S_DT_STRUCT,
      SymbolKind.S_DT_POINTER,
      SymbolKind.S_VAR_DEF_TYPE,
      SymbolKind.S_FUNC_DEF_TYPE
    };

    static final SymbolKind get(int code) {
      return values_[code];
    }

    public final int getCode() {
      return this.yycode_;
    }

    /* Return YYSTR after stripping away unnecessary quotes and
       backslashes, so that it's suitable for yyerror.  The heuristic is
       that double-quoting is unnecessary unless the string contains an
       apostrophe, a comma, or backslash (other than backslash-backslash).
       YYSTR is taken from yytname.  */
    private static String yytnamerr_(String yystr)
    {
      if (yystr.charAt (0) == '"')
        {
          StringBuffer yyr = new StringBuffer();
          strip_quotes: for (int i = 1; i < yystr.length(); i++)
            switch (yystr.charAt(i))
              {
              case '\'':
              case ',':
                break strip_quotes;

              case '\\':
                if (yystr.charAt(++i) != '\\')
                  break strip_quotes;
                /* Fall through.  */
              default:
                yyr.append(yystr.charAt(i));
                break;

              case '"':
                return yyr.toString();
              }
        }
      return yystr;
    }

    /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
       First, the terminals, then, starting at \a YYNTOKENS_, nonterminals.  */
    private static final String[] yytname_ = yytname_init();
  private static final String[] yytname_init()
  {
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
  "STATEMENTS", "STATEMENT", "EXP_R", "EXP_L", "NUMBER", "STATEMENT_IF",
  "STATEMENT_ELSE", "STATEMENT_WHILE", "WHILE_BODY", "STATEMENT_VAR_DEF",
  "DECLARE_MORE", "DECLARE_NON_INITIALIZE", "DECLARE_INITIALIZE",
  "STATEMENT_ASSIGN", "STATEMENT_STRUCT_DEF", "MORE_STRUCT_MEMBER_DEF",
  "STRUCT_MEMBER_DEF", "DECLARE_MORE_NON_INITIALIZE", "STATEMENT_RETURN",
  "FUNC_CALL", "SEND_FUNC_ARGS", "STATEMENT_FUNC_DEF", "RECV_FUNC_ARGS",
  "SINGLE_RECV_FUNC_ARG", "DT_STRUCT", "DT_POINTER", "VAR_DEF_TYPE",
  "FUNC_DEF_TYPE", null
    };
  }

    /* The user-facing name of this symbol.  */
    public final String getName() {
      return yytnamerr_(yytname_[yycode_]);
    }

  };


  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>Whkcc</tt>.
   */
  public interface Lexer {
    /* Token kinds.  */
    /** Token "end of file", to be returned by the scanner.  */
    static final int YYEOF = 0;
    /** Token error, to be returned by the scanner.  */
    static final int YYerror = 256;
    /** Token "invalid token", to be returned by the scanner.  */
    static final int YYUNDEF = 257;
    /** Token DT_INTEGER, to be returned by the scanner.  */
    static final int DT_INTEGER = 258;
    /** Token DT_BOOLEAN, to be returned by the scanner.  */
    static final int DT_BOOLEAN = 259;
    /** Token DT_FLOAT, to be returned by the scanner.  */
    static final int DT_FLOAT = 260;
    /** Token STRUCT, to be returned by the scanner.  */
    static final int STRUCT = 261;
    /** Token WHILE, to be returned by the scanner.  */
    static final int WHILE = 262;
    /** Token IF, to be returned by the scanner.  */
    static final int IF = 263;
    /** Token ELSE, to be returned by the scanner.  */
    static final int ELSE = 264;
    /** Token RETURN, to be returned by the scanner.  */
    static final int RETURN = 265;
    /** Token FUNCTION, to be returned by the scanner.  */
    static final int FUNCTION = 266;
    /** Token CONST_INTEGER, to be returned by the scanner.  */
    static final int CONST_INTEGER = 267;
    /** Token CONST_FLOAT, to be returned by the scanner.  */
    static final int CONST_FLOAT = 268;
    /** Token CONST_STRING, to be returned by the scanner.  */
    static final int CONST_STRING = 269;
    /** Token CONST_BOOLEAN, to be returned by the scanner.  */
    static final int CONST_BOOLEAN = 270;
    /** Token ID, to be returned by the scanner.  */
    static final int ID = 271;
    /** Token SEMICOLON, to be returned by the scanner.  */
    static final int SEMICOLON = 272;
    /** Token COMMA, to be returned by the scanner.  */
    static final int COMMA = 273;
    /** Token DOT, to be returned by the scanner.  */
    static final int DOT = 274;
    /** Token ROUND_LEFT, to be returned by the scanner.  */
    static final int ROUND_LEFT = 275;
    /** Token ROUND_RIGHT, to be returned by the scanner.  */
    static final int ROUND_RIGHT = 276;
    /** Token SQUARE_LEFT, to be returned by the scanner.  */
    static final int SQUARE_LEFT = 277;
    /** Token SQUARE_RIGHT, to be returned by the scanner.  */
    static final int SQUARE_RIGHT = 278;
    /** Token BEGIN, to be returned by the scanner.  */
    static final int BEGIN = 279;
    /** Token END, to be returned by the scanner.  */
    static final int END = 280;
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 281;
    /** Token LOR, to be returned by the scanner.  */
    static final int LOR = 282;
    /** Token LAND, to be returned by the scanner.  */
    static final int LAND = 283;
    /** Token BOR, to be returned by the scanner.  */
    static final int BOR = 284;
    /** Token BXOR, to be returned by the scanner.  */
    static final int BXOR = 285;
    /** Token APSAND, to be returned by the scanner.  */
    static final int APSAND = 286;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 287;
    /** Token NE, to be returned by the scanner.  */
    static final int NE = 288;
    /** Token LE, to be returned by the scanner.  */
    static final int LE = 289;
    /** Token GE, to be returned by the scanner.  */
    static final int GE = 290;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 291;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 292;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 293;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 294;
    /** Token STAR, to be returned by the scanner.  */
    static final int STAR = 295;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 296;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 297;
    /** Token GET_ADDR, to be returned by the scanner.  */
    static final int GET_ADDR = 298;
    /** Token POSITIVE, to be returned by the scanner.  */
    static final int POSITIVE = 299;
    /** Token NEGATIVE, to be returned by the scanner.  */
    static final int NEGATIVE = 300;

    /** Deprecated, use YYEOF instead.  */
    public static final int EOF = YYEOF;


    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.
     */
    Object getLVal();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token.
     */
    int yylex() throws java.io.IOException;

    /**
     * Emit an errorin a user-defined way.
     *
     *
     * @param msg The string for the error message.
     */
     void yyerror(String msg);


  }


  /**
   * The object doing lexical analysis for us.
   */
  private Lexer yylexer;





  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public Whkcc (Lexer yylexer)
  {

    this.yylexer = yylexer;

  }



  private int yynerrs = 0;

  /**
   * The number of syntax errors so far.
   */
  public final int getNumberOfErrors () { return yynerrs; }

  /**
   * Print an error message via the lexer.
   *
   * @param msg The error message.
   */
  public final void yyerror(String msg) {
      yylexer.yyerror(msg);
  }



  private final class YYStack {
    private int[] stateStack = new int[16];
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value) {
      height++;
      if (size == height)
        {
          int[] newStateStack = new int[size * 2];
          System.arraycopy (stateStack, 0, newStateStack, 0, height);
          stateStack = newStateStack;

          Object[] newValueStack = new Object[size * 2];
          System.arraycopy (valueStack, 0, newValueStack, 0, height);
          valueStack = newValueStack;

          size *= 2;
        }

      stateStack[height] = state;
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (0 < num) {
        java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out) {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
          out.print (' ');
          out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).
   */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).
   */
  public static final int YYABORT = 1;



  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.
   */
  public static final int YYERROR = 2;

  /**
   * Internal return codes that are not supported for user semantic
   * actions.
   */
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;


  private int yyerrstatus_ = 0;


  /**
   * Whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.
   */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  /** Compute post-reduction state.
   * @param yystate   the current state
   * @param yysym     the nonterminal to push on the stack
   */
  private int yyLRGotoState (int yystate, int yysym)
  {
    int yyr = yypgoto_[yysym - YYNTOKENS_] + yystate;
    if (0 <= yyr && yyr <= YYLAST_ && yycheck_[yyr] == yystate)
      return yytable_[yyr];
    else
      return yydefgoto_[yysym - YYNTOKENS_];
  }

  private int yyaction(int yyn, YYStack yystack, int yylen)
  {
    /* If YYLEN is nonzero, implement the default value of the action:
       '$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    Object yyval = (0 < yylen) ? yystack.valueAt(yylen - 1) : yystack.valueAt(0);

    switch (yyn)
      {
          case 2: /* PROGRAM: TOP_STATEMENTS  */
  if (yyn == 2)
    /* "Whkcc.y":275  */
                         {wl.addNonTerminalNode(SymbolKind.S_PROGRAM, 1);};
  break;


  case 3: /* TOP_STATEMENTS: STATEMENT_VAR_DEF TOP_STATEMENTS  */
  if (yyn == 3)
    /* "Whkcc.y":279  */
                                           {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 2);};
  break;


  case 4: /* TOP_STATEMENTS: STATEMENT_FUNC_DEF TOP_STATEMENTS  */
  if (yyn == 4)
    /* "Whkcc.y":280  */
                                            {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 2);};
  break;


  case 5: /* TOP_STATEMENTS: STATEMENT_STRUCT_DEF TOP_STATEMENTS  */
  if (yyn == 5)
    /* "Whkcc.y":281  */
                                              {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 2);};
  break;


  case 6: /* TOP_STATEMENTS: %empty  */
  if (yyn == 6)
    /* "Whkcc.y":282  */
          {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 0);};
  break;


  case 7: /* STATEMENTS_BLOCK: BEGIN STATEMENTS END  */
  if (yyn == 7)
    /* "Whkcc.y":286  */
                               {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS_BLOCK, 3);};
  break;


  case 8: /* STATEMENTS_BLOCK: BEGIN END  */
  if (yyn == 8)
    /* "Whkcc.y":287  */
                    {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS_BLOCK, 2);};
  break;


  case 9: /* STATEMENTS: STATEMENT STATEMENTS  */
  if (yyn == 9)
    /* "Whkcc.y":291  */
                               {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS, 2);};
  break;


  case 10: /* STATEMENTS: STATEMENT  */
  if (yyn == 10)
    /* "Whkcc.y":292  */
                    {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS, 1);};
  break;


  case 11: /* STATEMENT: STATEMENT_VAR_DEF  */
  if (yyn == 11)
    /* "Whkcc.y":296  */
                            {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 12: /* STATEMENT: STATEMENT_ASSIGN  */
  if (yyn == 12)
    /* "Whkcc.y":297  */
                           {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 13: /* STATEMENT: STATEMENT_IF  */
  if (yyn == 13)
    /* "Whkcc.y":298  */
                       {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 14: /* STATEMENT: STATEMENT_WHILE  */
  if (yyn == 14)
    /* "Whkcc.y":299  */
                          {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 15: /* STATEMENT: STATEMENT_STRUCT_DEF  */
  if (yyn == 15)
    /* "Whkcc.y":300  */
                               {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 16: /* STATEMENT: STATEMENT_RETURN  */
  if (yyn == 16)
    /* "Whkcc.y":301  */
                           {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 17: /* STATEMENT: FUNC_CALL SEMICOLON  */
  if (yyn == 17)
    /* "Whkcc.y":302  */
                              {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 2);};
  break;


  case 18: /* STATEMENT: SEMICOLON  */
  if (yyn == 18)
    /* "Whkcc.y":303  */
                    {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);};
  break;


  case 19: /* EXP_R: EXP_R LT EXP_R  */
  if (yyn == 19)
    /* "Whkcc.y":307  */
                         {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 20: /* EXP_R: EXP_R LE EXP_R  */
  if (yyn == 20)
    /* "Whkcc.y":308  */
                         {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 21: /* EXP_R: EXP_R GT EXP_R  */
  if (yyn == 21)
    /* "Whkcc.y":309  */
                         {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 22: /* EXP_R: EXP_R GE EXP_R  */
  if (yyn == 22)
    /* "Whkcc.y":310  */
                         {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 23: /* EXP_R: EXP_R NE EXP_R  */
  if (yyn == 23)
    /* "Whkcc.y":311  */
                         {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 24: /* EXP_R: EXP_R EQ EXP_R  */
  if (yyn == 24)
    /* "Whkcc.y":312  */
                         {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 25: /* EXP_R: EXP_R PLUS EXP_R  */
  if (yyn == 25)
    /* "Whkcc.y":313  */
                           {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 26: /* EXP_R: EXP_R MINUS EXP_R  */
  if (yyn == 26)
    /* "Whkcc.y":314  */
                            {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 27: /* EXP_R: EXP_R STAR EXP_R  */
  if (yyn == 27)
    /* "Whkcc.y":315  */
                           {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 28: /* EXP_R: EXP_R DIVIDE EXP_R  */
  if (yyn == 28)
    /* "Whkcc.y":316  */
                             {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 29: /* EXP_R: EXP_R MOD EXP_R  */
  if (yyn == 29)
    /* "Whkcc.y":317  */
                          {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 30: /* EXP_R: EXP_R LOR EXP_R  */
  if (yyn == 30)
    /* "Whkcc.y":318  */
                          {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 31: /* EXP_R: EXP_R LAND EXP_R  */
  if (yyn == 31)
    /* "Whkcc.y":319  */
                           {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 32: /* EXP_R: EXP_R BOR EXP_R  */
  if (yyn == 32)
    /* "Whkcc.y":320  */
                          {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 33: /* EXP_R: EXP_R BXOR EXP_R  */
  if (yyn == 33)
    /* "Whkcc.y":321  */
                           {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 34: /* EXP_R: EXP_R APSAND EXP_R  */
  if (yyn == 34)
    /* "Whkcc.y":322  */
                             {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 35: /* EXP_R: PLUS EXP_R  */
  if (yyn == 35)
    /* "Whkcc.y":323  */
                                    {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 2);};
  break;


  case 36: /* EXP_R: MINUS EXP_R  */
  if (yyn == 36)
    /* "Whkcc.y":324  */
                                     {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 2);};
  break;


  case 37: /* EXP_R: ROUND_LEFT EXP_R ROUND_RIGHT  */
  if (yyn == 37)
    /* "Whkcc.y":325  */
                                        {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 38: /* EXP_R: ID  */
  if (yyn == 38)
    /* "Whkcc.y":326  */
             {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);};
  break;


  case 39: /* EXP_R: ID SQUARE_LEFT EXP_R SQUARE_RIGHT  */
  if (yyn == 39)
    /* "Whkcc.y":327  */
                                            {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 4);};
  break;


  case 40: /* EXP_R: ID SQUARE_LEFT EXP_R SQUARE_RIGHT DOT ID  */
  if (yyn == 40)
    /* "Whkcc.y":328  */
                                                   {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 6);};
  break;


  case 41: /* EXP_R: ID DOT ID  */
  if (yyn == 41)
    /* "Whkcc.y":329  */
                    {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);};
  break;


  case 42: /* EXP_R: APSAND EXP_L  */
  if (yyn == 42)
    /* "Whkcc.y":330  */
                                      {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 2);};
  break;


  case 43: /* EXP_R: CONST_STRING  */
  if (yyn == 43)
    /* "Whkcc.y":331  */
                       {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);};
  break;


  case 44: /* EXP_R: NUMBER  */
  if (yyn == 44)
    /* "Whkcc.y":332  */
                 {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);};
  break;


  case 45: /* EXP_R: FUNC_CALL  */
  if (yyn == 45)
    /* "Whkcc.y":333  */
                    {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);};
  break;


  case 47: /* EXP_L: ID  */
  if (yyn == 47)
    /* "Whkcc.y":337  */
             {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 1);};
  break;


  case 48: /* EXP_L: ID SQUARE_LEFT EXP_R SQUARE_RIGHT  */
  if (yyn == 48)
    /* "Whkcc.y":338  */
                                            {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 4);};
  break;


  case 49: /* EXP_L: ID SQUARE_LEFT EXP_R SQUARE_RIGHT DOT ID  */
  if (yyn == 49)
    /* "Whkcc.y":339  */
                                                   {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 6);};
  break;


  case 50: /* EXP_L: ID DOT ID  */
  if (yyn == 50)
    /* "Whkcc.y":340  */
                    {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 3);};
  break;


  case 51: /* NUMBER: CONST_INTEGER  */
  if (yyn == 51)
    /* "Whkcc.y":344  */
                        {wl.addNonTerminalNode(SymbolKind.S_NUMBER, 1);};
  break;


  case 52: /* NUMBER: CONST_BOOLEAN  */
  if (yyn == 52)
    /* "Whkcc.y":345  */
                        {wl.addNonTerminalNode(SymbolKind.S_NUMBER, 1);};
  break;


  case 53: /* NUMBER: CONST_FLOAT  */
  if (yyn == 53)
    /* "Whkcc.y":346  */
                      {wl.addNonTerminalNode(SymbolKind.S_NUMBER, 1);};
  break;


  case 54: /* STATEMENT_IF: IF ROUND_LEFT EXP_R ROUND_RIGHT STATEMENTS_BLOCK STATEMENT_ELSE  */
  if (yyn == 54)
    /* "Whkcc.y":350  */
                                                                          {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_IF, 6);};
  break;


  case 55: /* STATEMENT_ELSE: ELSE STATEMENTS_BLOCK  */
  if (yyn == 55)
    /* "Whkcc.y":354  */
                                {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ELSE, 2);};
  break;


  case 56: /* STATEMENT_ELSE: ELSE STATEMENT_IF  */
  if (yyn == 56)
    /* "Whkcc.y":355  */
                            {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ELSE, 2);};
  break;


  case 57: /* STATEMENT_ELSE: %empty  */
  if (yyn == 57)
    /* "Whkcc.y":356  */
          {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ELSE, 0);};
  break;


  case 58: /* STATEMENT_WHILE: WHILE ROUND_LEFT EXP_R ROUND_RIGHT WHILE_BODY  */
  if (yyn == 58)
    /* "Whkcc.y":360  */
                                                        {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_WHILE, 5);};
  break;


  case 59: /* WHILE_BODY: STATEMENTS_BLOCK  */
  if (yyn == 59)
    /* "Whkcc.y":364  */
                           {wl.addNonTerminalNode(SymbolKind.S_WHILE_BODY, 1);};
  break;


  case 60: /* WHILE_BODY: STATEMENT  */
  if (yyn == 60)
    /* "Whkcc.y":365  */
                    {wl.addNonTerminalNode(SymbolKind.S_WHILE_BODY, 1);};
  break;


  case 61: /* STATEMENT_VAR_DEF: VAR_DEF_TYPE DECLARE_INITIALIZE DECLARE_MORE  */
  if (yyn == 61)
    /* "Whkcc.y":369  */
                                                       {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_VAR_DEF, 3);};
  break;


  case 62: /* STATEMENT_VAR_DEF: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE  */
  if (yyn == 62)
    /* "Whkcc.y":370  */
                                                           {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_VAR_DEF, 3);};
  break;


  case 63: /* DECLARE_MORE: SEMICOLON  */
  if (yyn == 63)
    /* "Whkcc.y":374  */
                    {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE, 1);};
  break;


  case 64: /* DECLARE_MORE: COMMA DECLARE_INITIALIZE DECLARE_MORE  */
  if (yyn == 64)
    /* "Whkcc.y":375  */
                                                {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE, 3);};
  break;


  case 65: /* DECLARE_MORE: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE  */
  if (yyn == 65)
    /* "Whkcc.y":376  */
                                                    {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE, 3);};
  break;


  case 66: /* DECLARE_NON_INITIALIZE: ID  */
  if (yyn == 66)
    /* "Whkcc.y":380  */
             {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 1);};
  break;


  case 67: /* DECLARE_NON_INITIALIZE: STAR ID  */
  if (yyn == 67)
    /* "Whkcc.y":381  */
                  {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 2);};
  break;


  case 68: /* DECLARE_NON_INITIALIZE: ID SQUARE_LEFT CONST_INTEGER SQUARE_RIGHT  */
  if (yyn == 68)
    /* "Whkcc.y":382  */
                                                    {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 4);};
  break;


  case 69: /* DECLARE_NON_INITIALIZE: STAR ID SQUARE_LEFT CONST_INTEGER SQUARE_RIGHT  */
  if (yyn == 69)
    /* "Whkcc.y":383  */
                                                         {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 5);};
  break;


  case 70: /* DECLARE_INITIALIZE: ID ASSIGN EXP_R  */
  if (yyn == 70)
    /* "Whkcc.y":387  */
                          {wl.addNonTerminalNode(SymbolKind.S_DECLARE_INITIALIZE, 3);};
  break;


  case 71: /* DECLARE_INITIALIZE: STAR ID ASSIGN EXP_R  */
  if (yyn == 71)
    /* "Whkcc.y":388  */
                               {wl.addNonTerminalNode(SymbolKind.S_DECLARE_INITIALIZE, 4);};
  break;


  case 72: /* STATEMENT_ASSIGN: EXP_L ASSIGN EXP_R SEMICOLON  */
  if (yyn == 72)
    /* "Whkcc.y":392  */
                                       {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ASSIGN, 4);};
  break;


  case 73: /* STATEMENT_STRUCT_DEF: STRUCT ID BEGIN STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF END SEMICOLON  */
  if (yyn == 73)
    /* "Whkcc.y":396  */
                                                                                 {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_STRUCT_DEF, 7);};
  break;


  case 74: /* MORE_STRUCT_MEMBER_DEF: STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF  */
  if (yyn == 74)
    /* "Whkcc.y":400  */
                                                   {wl.addNonTerminalNode(SymbolKind.S_MORE_STRUCT_MEMBER_DEF, 2);};
  break;


  case 75: /* MORE_STRUCT_MEMBER_DEF: %empty  */
  if (yyn == 75)
    /* "Whkcc.y":401  */
          {wl.addNonTerminalNode(SymbolKind.S_MORE_STRUCT_MEMBER_DEF, 0);};
  break;


  case 76: /* STRUCT_MEMBER_DEF: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE SEMICOLON  */
  if (yyn == 76)
    /* "Whkcc.y":405  */
                                                                                    {wl.addNonTerminalNode(SymbolKind.S_STRUCT_MEMBER_DEF, 4);};
  break;


  case 77: /* DECLARE_MORE_NON_INITIALIZE: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE  */
  if (yyn == 77)
    /* "Whkcc.y":409  */
                                                                   {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE_NON_INITIALIZE, 3);};
  break;


  case 78: /* DECLARE_MORE_NON_INITIALIZE: %empty  */
  if (yyn == 78)
    /* "Whkcc.y":410  */
          {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE_NON_INITIALIZE, 0);};
  break;


  case 79: /* STATEMENT_RETURN: RETURN EXP_R SEMICOLON  */
  if (yyn == 79)
    /* "Whkcc.y":414  */
                                 {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_RETURN, 3);};
  break;


  case 80: /* FUNC_CALL: ID ROUND_LEFT EXP_R SEND_FUNC_ARGS ROUND_RIGHT  */
  if (yyn == 80)
    /* "Whkcc.y":418  */
                                                         {wl.addNonTerminalNode(SymbolKind.S_FUNC_CALL, 5);};
  break;


  case 81: /* FUNC_CALL: ID ROUND_LEFT ROUND_RIGHT  */
  if (yyn == 81)
    /* "Whkcc.y":419  */
                                    {wl.addNonTerminalNode(SymbolKind.S_FUNC_CALL, 3);};
  break;


  case 82: /* SEND_FUNC_ARGS: COMMA EXP_R SEND_FUNC_ARGS  */
  if (yyn == 82)
    /* "Whkcc.y":423  */
                                     {wl.addNonTerminalNode(SymbolKind.S_SEND_FUNC_ARGS, 3);};
  break;


  case 83: /* SEND_FUNC_ARGS: %empty  */
  if (yyn == 83)
    /* "Whkcc.y":424  */
          {wl.addNonTerminalNode(SymbolKind.S_SEND_FUNC_ARGS, 0);};
  break;


  case 84: /* STATEMENT_FUNC_DEF: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT ROUND_RIGHT STATEMENTS_BLOCK  */
  if (yyn == 84)
    /* "Whkcc.y":428  */
                                                                            {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_FUNC_DEF, 6);};
  break;


  case 85: /* STATEMENT_FUNC_DEF: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS ROUND_RIGHT STATEMENTS_BLOCK  */
  if (yyn == 85)
    /* "Whkcc.y":429  */
                                                                                                                {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_FUNC_DEF, 8);};
  break;


  case 86: /* RECV_FUNC_ARGS: COMMA SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS  */
  if (yyn == 86)
    /* "Whkcc.y":433  */
                                                    {wl.addNonTerminalNode(SymbolKind.S_RECV_FUNC_ARGS, 3);};
  break;


  case 87: /* RECV_FUNC_ARGS: %empty  */
  if (yyn == 87)
    /* "Whkcc.y":434  */
          {wl.addNonTerminalNode(SymbolKind.S_RECV_FUNC_ARGS, 0);};
  break;


  case 88: /* SINGLE_RECV_FUNC_ARG: FUNC_DEF_TYPE ID  */
  if (yyn == 88)
    /* "Whkcc.y":438  */
                           {wl.addNonTerminalNode(SymbolKind.S_SINGLE_RECV_FUNC_ARG, 2);};
  break;


  case 89: /* SINGLE_RECV_FUNC_ARG: FUNC_DEF_TYPE ID SQUARE_LEFT SQUARE_RIGHT  */
  if (yyn == 89)
    /* "Whkcc.y":439  */
                                                    {wl.addNonTerminalNode(SymbolKind.S_SINGLE_RECV_FUNC_ARG, 4);};
  break;


  case 90: /* DT_STRUCT: STRUCT ID  */
  if (yyn == 90)
    /* "Whkcc.y":443  */
                    {wl.addNonTerminalNode(SymbolKind.S_DT_STRUCT, 2);};
  break;


  case 91: /* DT_POINTER: VAR_DEF_TYPE STAR  */
  if (yyn == 91)
    /* "Whkcc.y":447  */
                            {wl.addNonTerminalNode(SymbolKind.S_DT_POINTER, 2);};
  break;


  case 92: /* VAR_DEF_TYPE: DT_INTEGER  */
  if (yyn == 92)
    /* "Whkcc.y":451  */
                     {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);};
  break;


  case 93: /* VAR_DEF_TYPE: DT_FLOAT  */
  if (yyn == 93)
    /* "Whkcc.y":452  */
                   {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);};
  break;


  case 94: /* VAR_DEF_TYPE: DT_BOOLEAN  */
  if (yyn == 94)
    /* "Whkcc.y":453  */
                     {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);};
  break;


  case 95: /* VAR_DEF_TYPE: DT_STRUCT  */
  if (yyn == 95)
    /* "Whkcc.y":454  */
                    {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);};
  break;


  case 96: /* FUNC_DEF_TYPE: DT_INTEGER  */
  if (yyn == 96)
    /* "Whkcc.y":458  */
                     {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);};
  break;


  case 97: /* FUNC_DEF_TYPE: DT_FLOAT  */
  if (yyn == 97)
    /* "Whkcc.y":459  */
                   {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);};
  break;


  case 98: /* FUNC_DEF_TYPE: DT_BOOLEAN  */
  if (yyn == 98)
    /* "Whkcc.y":460  */
                     {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);};
  break;


  case 99: /* FUNC_DEF_TYPE: DT_POINTER  */
  if (yyn == 99)
    /* "Whkcc.y":461  */
                     {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);};
  break;



/* "Whkcc.java":1308  */

        default: break;
      }

    yystack.pop(yylen);
    yylen = 0;
    /* Shift the result of the reduction.  */
    int yystate = yyLRGotoState(yystack.stateAt(0), yyr1_[yyn]);
    yystack.push(yystate, yyval);
    return YYNEWSTATE;
  }




  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse() throws java.io.IOException

  {


    /* Lookahead token kind.  */
    int yychar = YYEMPTY_;
    /* Lookahead symbol kind.  */
    SymbolKind yytoken = null;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;
    YYStack yystack = new YYStack ();
    int label = YYNEWSTATE;



    /* Semantic value of the lookahead.  */
    Object yylval = null;

    yyerrstatus_ = 0;
    yynerrs = 0;

    /* Initialize the stack.  */
    yystack.push (yystate, yylval);



    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
           pushed when we come here.  */
      case YYNEWSTATE:

        /* Accept?  */
        if (yystate == YYFINAL_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyPactValueIsDefault (yyn))
          {
            label = YYDEFAULT;
            break;
          }

        /* Read a lookahead token.  */
        if (yychar == YYEMPTY_)
          {

            yychar = yylexer.yylex ();
            yylval = yylexer.getLVal();

          }

        /* Convert token to internal form.  */
        yytoken = yytranslate_ (yychar);

        if (yytoken == SymbolKind.S_YYerror)
          {
            // The scanner already issued an error message, process directly
            // to error recovery.  But do not keep the error token as
            // lookahead, it is too special and may lead us to an endless
            // loop in error recovery. */
            yychar = Lexer.YYUNDEF;
            yytoken = SymbolKind.S_YYUNDEF;
            label = YYERRLAB1;
          }
        else
          {
            /* If the proper action on seeing token YYTOKEN is to reduce or to
               detect an error, take that action.  */
            yyn += yytoken.getCode();
            if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode())
              label = YYDEFAULT;

            /* <= 0 means reduce or error.  */
            else if ((yyn = yytable_[yyn]) <= 0)
              {
                if (yyTableValueIsError (yyn))
                  label = YYERRLAB;
                else
                  {
                    yyn = -yyn;
                    label = YYREDUCE;
                  }
              }

            else
              {
                /* Shift the lookahead token.  */
                /* Discard the token being shifted.  */
                yychar = YYEMPTY_;

                /* Count tokens shifted since error; after three, turn off error
                   status.  */
                if (yyerrstatus_ > 0)
                  --yyerrstatus_;

                yystate = yyn;
                yystack.push (yystate, yylval);
                label = YYNEWSTATE;
              }
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction(yyn, yystack, yylen);
        yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs;
            if (yychar == YYEMPTY_)
              yytoken = null;
            yyreportSyntaxError (new Context (yystack, yytoken));
          }

        if (yyerrstatus_ == 3)
          {
            /* If just tried and failed to reuse lookahead token after an
               error, discard it.  */

            if (yychar <= Lexer.YYEOF)
              {
                /* Return failure if at end of input.  */
                if (yychar == Lexer.YYEOF)
                  return false;
              }
            else
              yychar = YYEMPTY_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `-------------------------------------------------*/
      case YYERROR:
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

        // Pop stack until we find a state that shifts the error token.
        for (;;)
          {
            yyn = yypact_[yystate];
            if (!yyPactValueIsDefault (yyn))
              {
                yyn += SymbolKind.S_YYerror.getCode();
                if (0 <= yyn && yyn <= YYLAST_
                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode())
                  {
                    yyn = yytable_[yyn];
                    if (0 < yyn)
                      break;
                  }
              }

            /* Pop the current state because it cannot handle the
             * error token.  */
            if (yystack.height == 0)
              return false;


            yystack.pop ();
            yystate = yystack.stateAt (0);
          }

        if (label == YYABORT)
          /* Leave the switch.  */
          break;



        /* Shift the error token.  */

        yystate = yyn;
        yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
}




  /**
   * Information needed to get the list of expected tokens and to forge
   * a syntax error diagnostic.
   */
  public static final class Context
  {
    Context (YYStack stack, SymbolKind token)
    {
      yystack = stack;
      yytoken = token;
    }

    private YYStack yystack;


    /**
     * The symbol kind of the lookahead token.
     */
    public final SymbolKind getToken ()
    {
      return yytoken;
    }

    private SymbolKind yytoken;
    static final int NTOKENS = Whkcc.YYNTOKENS_;

    /**
     * Put in YYARG at most YYARGN of the expected tokens given the
     * current YYCTX, and return the number of tokens stored in YYARG.  If
     * YYARG is null, return the number of expected tokens (guaranteed to
     * be less than YYNTOKENS).
     */
    int getExpectedTokens (SymbolKind yyarg[], int yyargn)
    {
      return getExpectedTokens (yyarg, 0, yyargn);
    }

    int getExpectedTokens (SymbolKind yyarg[], int yyoffset, int yyargn)
    {
      int yycount = yyoffset;
      int yyn = yypact_[this.yystack.stateAt (0)];
      if (!yyPactValueIsDefault (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative
             indexes in YYCHECK.  In other words, skip the first
             -YYN actions for this state because they are default
             actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST_ - yyn + 1;
          int yyxend = yychecklim < NTOKENS ? yychecklim : NTOKENS;
          for (int yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck_[yyx + yyn] == yyx && yyx != SymbolKind.S_YYerror.getCode()
                && !yyTableValueIsError(yytable_[yyx + yyn]))
              {
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


  private int yysyntaxErrorArguments (Context yyctx, SymbolKind[] yyarg, int yyargn)
  {
    /* There are many possibilities here to consider:
       - If this state is a consistent state with a default action,
         then the only way this function was invoked is if the
         default action is an error action.  In that case, don't
         check for expected tokens because there are none.
       - The only way there can be no lookahead present (in tok) is
         if this state is a consistent state with a default action.
         Thus, detecting the absence of a lookahead is sufficient to
         determine that there is no unexpected or expected token to
         report.  In that case, just report a simple "syntax error".
       - Don't assume there isn't a lookahead just because this
         state is a consistent state with a default action.  There
         might have been a previous inconsistent state, consistent
         state with a non-default action, or user semantic action
         that manipulated yychar.  (However, yychar is currently out
         of scope during semantic actions.)
       - Of course, the expected token list depends on states to
         have correct lookahead information, and it depends on the
         parser not to perform extra reductions after fetching a
         lookahead from the scanner and before detecting a syntax
         error.  Thus, state merging (from LALR or IELR) and default
         reductions corrupt the expected token list.  However, the
         list is correct for canonical LR with one exception: it
         will still contain any token that will not be accepted due
         to an error action in a later state.
    */
    int yycount = 0;
    if (yyctx.getToken() != null)
      {
        if (yyarg != null)
          yyarg[yycount] = yyctx.getToken();
        yycount += 1;
        yycount += yyctx.getExpectedTokens(yyarg, 1, yyargn);
      }
    return yycount;
  }


  /**
   * Build and emit a "syntax error" message in a user-defined way.
   *
   * @param ctx  The context of the error.
   */
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
              case 0: yyformat = "syntax error"; break;
              case 1: yyformat = "syntax error, unexpected {0}"; break;
              case 2: yyformat = "syntax error, unexpected {0}, expecting {1}"; break;
              case 3: yyformat = "syntax error, unexpected {0}, expecting {1} or {2}"; break;
              case 4: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3}"; break;
              case 5: yyformat = "syntax error, unexpected {0}, expecting {1} or {2} or {3} or {4}"; break;
          }
          yyerror(new MessageFormat(yyformat).format(yystr));
      } else {
          yyerror("syntax error");
      }
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yyPactValueIsDefault (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code>
   * value indicates a syntax error.
   * @param yyvalue the value to check
   */
  private static boolean yyTableValueIsError (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  private static final short yypact_ninf_ = -129;
  private static final short yytable_ninf_ = -99;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
     102,  -129,  -129,  -129,   -12,    77,    24,  -129,   102,   102,
     102,  -129,   -15,    27,    40,    45,    59,    61,  -129,    46,
      79,  -129,  -129,  -129,  -129,    32,    83,     1,     1,   162,
    -129,  -129,    94,   108,    78,    37,  -129,   -15,  -129,  -129,
     162,    10,    97,    98,  -129,  -129,  -129,  -129,    47,    78,
     155,    78,    78,   318,  -129,  -129,   183,    78,     1,     1,
     175,   162,   179,   194,   198,   195,   202,   206,  -129,   207,
      58,    78,   200,    43,  -129,  -129,  -129,    78,    78,    78,
      78,    78,    78,    78,    78,    78,    78,    78,    78,    78,
      78,    78,    78,   221,   318,  -129,  -129,   208,  -129,   223,
      10,   229,   201,  -129,    77,   203,   225,  -129,  -129,   146,
     282,  -129,   232,    78,   333,   347,   360,   372,   383,   105,
     105,   -26,   -26,   -26,   -26,   157,   157,  -129,  -129,  -129,
    -129,  -129,   198,  -129,   246,   247,    78,   150,  -129,  -129,
     243,   186,   267,  -129,  -129,  -129,  -129,  -129,  -129,   252,
     202,   195,   272,    78,   249,   277,  -129,   302,  -129,    78,
      78,    95,  -129,  -129,    78,  -129,  -129,  -129,  -129,   146,
    -129,   281,   279,   222,   244,  -129,   121,  -129,  -129,   283,
     284,   195,  -129,  -129,  -129,  -129,  -129,   293,     3,  -129,
    -129,  -129
    };
  }

/* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
   Performed when YYTABLE does not specify something else to do.  Zero
   means the default is an error.  */
  private static final byte[] yydefact_ = yydefact_init();
  private static final byte[] yydefact_init()
  {
    return new byte[]
    {
       6,    92,    94,    93,     0,     0,     0,     2,     6,     6,
       6,    95,     0,    90,    92,    94,    93,     0,    99,     0,
       0,     1,     3,     5,     4,    66,     0,     0,     0,     0,
      90,    91,     0,     0,     0,    67,    63,     0,    62,    61,
      75,     0,     0,     0,    51,    53,    43,    52,    38,     0,
      46,     0,     0,    70,    44,    45,     0,     0,     0,     0,
       0,    75,    66,     0,    78,     0,    87,     0,    68,     0,
       0,     0,     0,    47,    42,    35,    36,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,    71,    65,    64,     0,    74,    67,
       0,     0,    46,    84,     0,     0,    88,    41,    81,    83,
       0,    37,     0,     0,    30,    31,    32,    33,    34,    24,
      23,    20,    22,    19,    21,    25,    26,    27,    28,    29,
      69,    73,    78,    76,     0,     0,     0,    47,    18,     8,
       0,    10,     0,    13,    14,    11,    12,    15,    16,     0,
      87,     0,     0,     0,     0,    39,    50,     0,    77,     0,
       0,     0,     7,     9,     0,    17,    86,    85,    89,    83,
      80,     0,    48,     0,     0,    79,     0,    82,    40,     0,
      46,     0,    72,    49,    59,    60,    58,    57,     0,    54,
      55,    56
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
    -129,  -129,   205,  -128,   163,   123,   -49,   256,  -129,   119,
    -129,  -129,  -129,   -96,   -11,   -32,   289,  -129,   -95,   266,
     299,   294,  -129,   -92,   258,  -129,   278,   325,  -129,  -129,
      15,   425
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short[] yydefgoto_ = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
       0,     6,     7,   103,   140,   141,    53,   142,    54,   143,
     189,   144,   186,     8,    38,    27,    28,   146,     9,    60,
      61,   101,   148,    55,   154,    10,   105,    66,    11,    18,
      12,    67
    };
  }

/* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
   positive, shift that token.  If negative, reduce the rule whose
   number is the opposite.  If YYTABLE_NINF, syntax error.  */
  private static final short[] yytable_ = yytable_init();
  private static final short[] yytable_init()
  {
    return new short[]
    {
      72,    25,    75,    76,    13,    58,   145,   147,    94,    64,
     149,   135,    88,    89,    90,    91,    92,    39,    36,    37,
      19,   109,   110,   167,    21,    26,    62,   102,   114,   115,
     116,   117,   118,   119,   120,   121,   122,   123,   124,   125,
     126,   127,   128,   129,    41,   145,   147,    95,    96,   149,
      63,    29,   184,   187,    33,    41,   -96,    19,    34,    56,
     190,   -98,   112,    57,   157,   113,    69,    70,   132,    71,
      44,    45,    46,    47,    48,   -97,    41,    30,    49,   108,
      14,    15,    16,    17,   145,   147,    31,   161,   149,    50,
      44,    45,    46,    47,    48,    32,    51,    52,    49,    35,
      14,    15,    16,    17,   169,     1,     2,     3,     4,    50,
     173,   174,   175,     5,    42,   176,    51,    52,    65,    19,
      43,    68,    77,    78,    79,    80,    81,    82,    83,    84,
      85,    86,    87,    88,    89,    90,    91,    92,   182,    84,
      85,    86,    87,    88,    89,    90,    91,    92,    77,    78,
      79,    80,    81,    82,    83,    84,    85,    86,    87,    88,
      89,    90,    91,    92,   153,     1,     2,     3,    17,   112,
      70,    73,   113,    77,    78,    79,    80,    81,    82,    83,
      84,    85,    86,    87,    88,    89,    90,    91,    92,     1,
       2,     3,     4,   134,   135,    93,   136,    90,    91,    92,
      97,    33,   137,   138,     1,     2,     3,     4,   134,   135,
      99,   136,   -46,    22,    23,    24,   100,   137,   138,   102,
     104,   111,   106,   107,   151,   131,   139,    77,    78,    79,
      80,    81,    82,    83,    84,    85,    86,    87,    88,    89,
      90,    91,    92,   180,   130,    56,   133,   152,   156,    77,
      78,    79,    80,    81,    82,    83,    84,    85,    86,    87,
      88,    89,    90,    91,    92,   181,   159,   160,   162,   165,
     170,    77,    78,    79,    80,    81,    82,    83,    84,    85,
      86,    87,    88,    89,    90,    91,    92,     1,     2,     3,
       4,   134,   135,   164,   136,   168,   171,   178,   179,   183,
     137,   138,   188,   185,   163,   155,    74,   191,   102,    77,
      78,    79,    80,    81,    82,    83,    84,    85,    86,    87,
      88,    89,    90,    91,    92,   172,    59,    98,    40,    77,
      78,    79,    80,    81,    82,    83,    84,    85,    86,    87,
      88,    89,    90,    91,    92,    77,    78,    79,    80,    81,
      82,    83,    84,    85,    86,    87,    88,    89,    90,    91,
      92,    78,    79,    80,    81,    82,    83,    84,    85,    86,
      87,    88,    89,    90,    91,    92,    79,    80,    81,    82,
      83,    84,    85,    86,    87,    88,    89,    90,    91,    92,
      80,    81,    82,    83,    84,    85,    86,    87,    88,    89,
      90,    91,    92,    81,    82,    83,    84,    85,    86,    87,
      88,    89,    90,    91,    92,    82,    83,    84,    85,    86,
      87,    88,    89,    90,    91,    92,   158,   177,   166,   150,
      20
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      49,    16,    51,    52,    16,    37,   102,   102,    57,    41,
     102,     8,    38,    39,    40,    41,    42,    28,    17,    18,
       5,    70,    71,   151,     0,    40,    16,    24,    77,    78,
      79,    80,    81,    82,    83,    84,    85,    86,    87,    88,
      89,    90,    91,    92,    29,   141,   141,    58,    59,   141,
      40,    24,   180,   181,    22,    40,    16,    42,    26,    22,
     188,    16,    19,    26,   113,    22,    19,    20,   100,    22,
      12,    13,    14,    15,    16,    16,    61,    16,    20,    21,
       3,     4,     5,     6,   180,   180,    40,   136,   180,    31,
      12,    13,    14,    15,    16,    16,    38,    39,    20,    16,
       3,     4,     5,     6,   153,     3,     4,     5,     6,    31,
     159,   160,    17,    11,    20,   164,    38,    39,    21,   104,
      12,    23,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    17,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    27,    28,
      29,    30,    31,    32,    33,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    18,     3,     4,     5,     6,    19,
      20,    16,    22,    27,    28,    29,    30,    31,    32,    33,
      34,    35,    36,    37,    38,    39,    40,    41,    42,     3,
       4,     5,     6,     7,     8,    12,    10,    40,    41,    42,
      25,    22,    16,    17,     3,     4,     5,     6,     7,     8,
      16,    10,    26,     8,     9,    10,    18,    16,    17,    24,
      18,    21,    16,    16,    21,    17,    25,    27,    28,    29,
      30,    31,    32,    33,    34,    35,    36,    37,    38,    39,
      40,    41,    42,    21,    23,    22,    17,    22,    16,    27,
      28,    29,    30,    31,    32,    33,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    21,    20,    20,    25,    17,
      21,    27,    28,    29,    30,    31,    32,    33,    34,    35,
      36,    37,    38,    39,    40,    41,    42,     3,     4,     5,
       6,     7,     8,    26,    10,    23,    19,    16,    19,    16,
      16,    17,     9,   180,   141,    23,    50,   188,    24,    27,
      28,    29,    30,    31,    32,    33,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    23,    37,    61,    29,    27,
      28,    29,    30,    31,    32,    33,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    27,    28,    29,    30,    31,
      32,    33,    34,    35,    36,    37,    38,    39,    40,    41,
      42,    28,    29,    30,    31,    32,    33,    34,    35,    36,
      37,    38,    39,    40,    41,    42,    29,    30,    31,    32,
      33,    34,    35,    36,    37,    38,    39,    40,    41,    42,
      30,    31,    32,    33,    34,    35,    36,    37,    38,    39,
      40,    41,    42,    31,    32,    33,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    32,    33,    34,    35,    36,
      37,    38,    39,    40,    41,    42,   132,   169,   150,   104,
       5
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     5,     6,    11,    47,    48,    59,    64,
      71,    74,    76,    16,     3,     4,     5,     6,    75,    76,
      77,     0,    48,    48,    48,    16,    40,    61,    62,    24,
      16,    40,    16,    22,    26,    16,    17,    18,    60,    60,
      66,    76,    20,    12,    12,    13,    14,    15,    16,    20,
      31,    38,    39,    52,    54,    69,    22,    26,    61,    62,
      65,    66,    16,    40,    61,    21,    73,    77,    23,    19,
      20,    22,    52,    16,    53,    52,    52,    27,    28,    29,
      30,    31,    32,    33,    34,    35,    36,    37,    38,    39,
      40,    41,    42,    12,    52,    60,    60,    25,    65,    16,
      18,    67,    24,    49,    18,    72,    16,    16,    21,    52,
      52,    21,    19,    22,    52,    52,    52,    52,    52,    52,
      52,    52,    52,    52,    52,    52,    52,    52,    52,    52,
      23,    17,    61,    17,     7,     8,    10,    16,    17,    25,
      50,    51,    53,    55,    57,    59,    63,    64,    68,    69,
      73,    21,    22,    18,    70,    23,    16,    52,    67,    20,
      20,    52,    25,    50,    26,    17,    72,    49,    23,    52,
      21,    19,    23,    52,    52,    17,    52,    70,    16,    19,
      21,    21,    17,    16,    49,    51,    58,    49,     9,    56,
      49,    55
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    46,    47,    48,    48,    48,    48,    49,    49,    50,
      50,    51,    51,    51,    51,    51,    51,    51,    51,    52,
      52,    52,    52,    52,    52,    52,    52,    52,    52,    52,
      52,    52,    52,    52,    52,    52,    52,    52,    52,    52,
      52,    52,    52,    52,    52,    52,    53,    53,    53,    53,
      53,    54,    54,    54,    55,    56,    56,    56,    57,    58,
      58,    59,    59,    60,    60,    60,    61,    61,    61,    61,
      62,    62,    63,    64,    65,    65,    66,    67,    67,    68,
      69,    69,    70,    70,    71,    71,    72,    72,    73,    73,
      74,    75,    76,    76,    76,    76,    77,    77,    77,    77
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     2,     2,     2,     0,     3,     2,     2,
       1,     1,     1,     1,     1,     1,     1,     2,     1,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     3,     3,     3,     3,     2,     2,     3,     1,     4,
       6,     3,     2,     1,     1,     1,     0,     1,     4,     6,
       3,     1,     1,     1,     6,     2,     2,     0,     5,     1,
       1,     3,     3,     1,     3,     3,     1,     2,     4,     5,
       3,     4,     4,     7,     2,     0,     4,     3,     0,     3,
       5,     3,     3,     0,     6,     8,     3,     0,     2,     4,
       2,     2,     1,     1,     1,     1,     1,     1,     1,     1
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
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
  private static final byte[] yytranslate_table_init()
  {
    return new byte[]
    {
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45
    };
  }


  private static final int YYLAST_ = 430;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 21;
  private static final int YYNTOKENS_ = 46;

/* Unqualified %code blocks.  */
/* "Whkcc.y":15  */

    /**
     * Parse input from the scanner that was specified at object construction
     * time.  Return whether the end of the input was reached successfully.
     *
     * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
     * imply that there were no syntax errors.
     */
    public boolean parseMe() throws java.io.IOException {


        /* Lookahead token kind.  */
        int yychar = YYEMPTY_;
        /* Lookahead symbol kind.  */
        SymbolKind yytoken = null;

        /* State.  */
        int yyn = 0;
        int yylen = 0;
        int yystate = 0;
        Position yylpos = null;
        YYStack yystack = new YYStack();
        int label = YYNEWSTATE;



        /* Semantic value of the lookahead.  */
        Object yylval = null;

        yyerrstatus_ = 0;
        yynerrs = 0;

        /* Initialize the stack.  */
        yystack.push(yystate, yylval);


        for (; ; )
            switch (label) {
          /* New state.  Unlike in the C/C++ skeletons, the state is already
             pushed when we come here.  */
                case YYNEWSTATE:

                    /* Accept?  */
                    if (yystate == YYFINAL_)
                        return true;

                    /* Take a decision.  First try without lookahead.  */
                    yyn = yypact_[yystate];
                    if (yyPactValueIsDefault(yyn)) {
                        label = YYDEFAULT;
                        break;
                    }

                    /* Read a lookahead token.  */
                    if (yychar == YYEMPTY_) {

                        yychar = yylexer.yylex();
                        yylval = yylexer.getLVal();
                        yylpos = wl.getLPosition();

                    }

                    /* Convert token to internal form.  */
                    yytoken = yytranslate_(yychar);

                    if (yytoken == SymbolKind.S_YYerror) {
                        // The scanner already issued an error message, process directly
                        // to error recovery.  But do not keep the error token as
                        // lookahead, it is too special and may lead us to an endless
                        // loop in error recovery. */
                        yychar = Lexer.YYUNDEF;
                        yytoken = SymbolKind.S_YYUNDEF;
                        label = YYERRLAB1;
                    } else {
              /* If the proper action on seeing token YYTOKEN is to reduce or to
                 detect an error, take that action.  */
                        yyn += yytoken.getCode();
                        if (yyn < 0 || YYLAST_ < yyn || yycheck_[yyn] != yytoken.getCode())
                            label = YYDEFAULT;

                            /* <= 0 means reduce or error.  */
                        else if ((yyn = yytable_[yyn]) <= 0) {
                            if (yyTableValueIsError(yyn))
                                label = YYERRLAB;
                            else {
                                yyn = -yyn;
                                label = YYREDUCE;
                            }
                        } else {
                            /* Shift the lookahead token.  */
                            /* Discard the token being shifted.  */
                            yychar = YYEMPTY_;

                  /* Count tokens shifted since error; after three, turn off error
                     status.  */
                            if (yyerrstatus_ > 0)
                                --yyerrstatus_;

                            yystate = yyn;
                            yystack.push(yystate, yylval);
                            wl.addTerminalNode(yytoken, yylpos, yylval);
                            label = YYNEWSTATE;
                        }
                    }
                    break;

        /*-----------------------------------------------------------.
        | yydefault -- do the default action for the current state.  |
        `-----------------------------------------------------------*/
                case YYDEFAULT:
                    yyn = yydefact_[yystate];
                    if (yyn == 0)
                        label = YYERRLAB;
                    else
                        label = YYREDUCE;
                    break;

        /*-----------------------------.
        | yyreduce -- Do a reduction.  |
        `-----------------------------*/
                case YYREDUCE:
                    yylen = yyr2_[yyn];
                    label = yyaction(yyn, yystack, yylen);
                    yystate = yystack.stateAt(0);
                    break;

        /*------------------------------------.
        | yyerrlab -- here on detecting error |
        `------------------------------------*/
                case YYERRLAB:
                    /* If not already recovering from an error, report this error.  */
                    if (yyerrstatus_ == 0) {
                        ++yynerrs;
                        if (yychar == YYEMPTY_)
                            yytoken = null;
                        yyreportSyntaxError(new Context(yystack, yytoken));
                    }

                    if (yyerrstatus_ == 3) {
              /* If just tried and failed to reuse lookahead token after an
                 error, discard it.  */

                        if (yychar <= Lexer.YYEOF) {
                            /* Return failure if at end of input.  */
                            if (yychar == Lexer.YYEOF)
                                return false;
                        } else
                            yychar = YYEMPTY_;
                    }

          /* Else will try to reuse lookahead token after shifting the error
             token.  */
                    label = YYERRLAB1;
                    break;

        /*-------------------------------------------------.
        | errorlab -- error raised explicitly by YYERROR.  |
        `-------------------------------------------------*/
                case YYERROR:
          /* Do not reclaim the symbols of the rule which action triggered
             this YYERROR.  */
                    yystack.pop(yylen);
                    yylen = 0;
                    yystate = yystack.stateAt(0);
                    label = YYERRLAB1;
                    break;

        /*-------------------------------------------------------------.
        | yyerrlab1 -- common code for both syntax error and YYERROR.  |
        `-------------------------------------------------------------*/
                case YYERRLAB1:
                    yyerrstatus_ = 3;       /* Each real token shifted decrements this.  */

                    // Pop stack until we find a state that shifts the error token.
                    for (; ; ) {
                        yyn = yypact_[yystate];
                        if (!yyPactValueIsDefault(yyn)) {
                            yyn += SymbolKind.S_YYerror.getCode();
                            if (0 <= yyn && yyn <= YYLAST_
                                    && yycheck_[yyn] == SymbolKind.S_YYerror.getCode()) {
                                yyn = yytable_[yyn];
                                if (0 < yyn)
                                    break;
                            }
                        }

                        /* Pop the current state because it cannot handle the
                         * error token.  */
                        if (yystack.height == 0)
                            return false;


                        yystack.pop();
                        yystate = yystack.stateAt(0);
                    }

                    if (label == YYABORT)
                        /* Leave the switch.  */
                        break;



                    /* Shift the error token.  */

                    yystate = yyn;
                    yystack.push(yyn, yylval);
                    wl.addTerminalNode(yytoken, yylpos, yylval);
                    label = YYNEWSTATE;
                    break;

                /* Accept.  */
                case YYACCEPT:
                    return true;

                /* Abort.  */
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

/* "Whkcc.java":2280  */

}
/* "Whkcc.y":465  */

