package wang.armeria.whkcc;

import wang.armeria.common.Utils;
import wang.armeria.ast.ASTree;
import wang.armeria.token.Position;
import wang.armeria.token.Token;
import wang.armeria.token.TokenType;

import java.io.*;

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
    }

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
        System.out.println("Position at: " + tree.getLatestPosition());
    }

    @Override
    public Object getLVal() {
        return yylval;
    }

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

            Token token = Token.parseToken(line1, line2);
            if (token.getTokenType() == TokenType.COMMENT) {
                continue;
            }
            yylval = token.getValue();
            yylpos = token.getPosition();
            return Utils.tokenType2LexerId(token.getTokenType());
        }
    }


    public void addTerminalNode(Whkcc.SymbolKind symbolKind, Position position, Object value) {
        tree.addTerminalNode(symbolKind, position, value);
    }

    public void addNonTerminalNode(Whkcc.SymbolKind symbolKind, int reduceSymbolsNum) {
        tree.addNonTerminalNode(symbolKind, reduceSymbolsNum);
    }

    public void printASTree() {
        tree.printTree();
    }

}
