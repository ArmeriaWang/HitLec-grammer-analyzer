package wang.armeria.whkcc;

import wang.armeria.common.Utils;
import wang.armeria.ast.ASTree;
import wang.armeria.token.Position;
import wang.armeria.token.Token;
import wang.armeria.token.TokenType;

import java.io.*;

/**
 * 包含抽象语法树AST的语法分析器类，采用单例模式
 */
public class WhkccLexer implements Whkcc.Lexer {

    private final BufferedReader reader;
    private final ASTree tree;
    private Object yylval;
    private Position yylpos;
    private static final File inputFile = new File("src/main/java/wang/armeria/whkcc/test_simple.lx");
    private static WhkccLexer singleInstance = null;

    private WhkccLexer(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is);
        reader = new BufferedReader(isr);
        tree = new ASTree();
        tree.addTerminalNode(Whkcc.SymbolKind.S_YYACCEPT, new Position(1, 0), null);
    }

    /**
     * 获取本类的唯一实例
     * @return 本类的唯一实例
     */
    public static WhkccLexer getWhkccLexer() {
        if (singleInstance == null) {
            try {
                singleInstance = new WhkccLexer(new FileInputStream(inputFile));
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
        return singleInstance;
    }

    @Override
    public void yyerror(String s) {
        System.err.println(s);
        System.err.println("Position at " + tree.getLatestPosition());
    }

    @Override
    public Object getLVal() {
        return yylval;
    }

    /**
     * 获取最后读入的token的程序位置
     * @return 最后读入的token的程序位置
     */
    public Position getLPosition() {
        return yylpos;
    }

    @Override
    public int yylex() throws IOException {
        while (true) {
            String line1 = reader.readLine();
            if (line1 == null) {
                return YYEOF;
            }
            String line2 = reader.readLine();
            if (line2 == null) {
                return YYerror;
            }

            Token token;
            try {
                token = Token.parseToken(line1, line2);
            } catch (IllegalArgumentException e) {
                return YYerror;
            }
            if (token.getTokenType() == TokenType.COMMENT) {
                continue;
            }
            yylval = token.getValue();
            yylpos = token.getPosition();
            return Utils.tokenType2LexerId(token.getTokenType());
        }
    }

    /**
     * 向AST中添加终结符节点
     * @param symbolKind 符号类型
     * @param position 程序位置
     * @param value 符号语义值（字面值、标识符需要非null值，其他类型传入null）
     */
    public void addTerminalNode(Whkcc.SymbolKind symbolKind, Position position, Object value) {
        tree.addTerminalNode(symbolKind, position, value);
    }

    /**
     * 向AST中添加非终结符节点
     * @param symbolKind 符号类型
     * @param reduceSymbolsNum 需要规约的符号数
     */
    public void addNonTerminalNode(Whkcc.SymbolKind symbolKind, int reduceSymbolsNum) {
        tree.addNonTerminalNode(symbolKind, reduceSymbolsNum);
    }

    /**
     * 按格式打印AST。仅当全部解析完成后才能调用
     * @throws RuntimeException 根节点为null
     */
    public void printASTree() {
        tree.printTree();
    }

}
