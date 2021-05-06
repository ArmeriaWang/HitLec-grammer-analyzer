package wang.armeria.common;

import wang.armeria.token.TokenType;
import wang.armeria.whkcc.Whkcc;

public class Utils {

    public static int tokenType2LexerId(TokenType tokenType) {
        switch (tokenType) {
            case DT_BOOLEAN:
                return Whkcc.Lexer.DT_BOOLEAN;
            case DT_FLOAT:
                return Whkcc.Lexer.DT_FLOAT;
            case DT_INTEGER:
                return Whkcc.Lexer.DT_INTEGER;
            case KW_WHILE:
                return Whkcc.Lexer.WHILE;
            case KW_IF:
                return Whkcc.Lexer.IF;
            case KW_ELSE:
                return Whkcc.Lexer.ELSE;
            case KW_RETURN:
                return Whkcc.Lexer.RETURN;
            case KW_STRUCT:
                return Whkcc.Lexer.STRUCT;
            case KW_FUNCTION:
                return Whkcc.Lexer.FUNCTION;
            case CONST_INTEGER:
                return Whkcc.Lexer.CONST_INTEGER;
            case CONST_BOOLEAN:
                return Whkcc.Lexer.CONST_BOOLEAN;
            case CONST_FLOAT:
                return Whkcc.Lexer.CONST_FLOAT;
            case CONST_STRING:
                return Whkcc.Lexer.CONST_STRING;
            case COMMA:
                return Whkcc.Lexer.COMMA;
            case SEMICOLON:
                return Whkcc.Lexer.SEMICOLON;
            case EQUAL:
                return Whkcc.Lexer.EQ;
            case LESS_EQUAL:
                return Whkcc.Lexer.LE;
            case GREATER_EQUAL:
                return Whkcc.Lexer.GE;
            case LESS:
                return Whkcc.Lexer.LT;
            case GREATER:
                return Whkcc.Lexer.GT;
            case NOT_EQUAL:
                return Whkcc.Lexer.NE;
            case PLUS:
                return Whkcc.Lexer.PLUS;
            case MINUS:
                return Whkcc.Lexer.MINUS;
            case STAR:
                return Whkcc.Lexer.STAR;
            case DIVIDE:
                return Whkcc.Lexer.DIVIDE;
            case ROUND_LEFT:
                return Whkcc.Lexer.ROUND_LEFT;
            case ROUND_RIGHT:
                return Whkcc.Lexer.ROUND_RIGHT;
            case SQUARE_LEFT:
                return Whkcc.Lexer.SQUARE_LEFT;
            case SQUARE_RIGHT:
                return Whkcc.Lexer.SQUARE_RIGHT;
            case BEGIN:
                return Whkcc.Lexer.BEGIN;
            case END:
                return Whkcc.Lexer.END;
            case DOT:
                return Whkcc.Lexer.DOT;
            case MOD:
                return Whkcc.Lexer.MOD;
            case LOGIC_AND:
                return Whkcc.Lexer.LAND;
            case LOGIC_OR:
                return Whkcc.Lexer.LOR;
            case AMPERSAND:
                return Whkcc.Lexer.APSAND;
            case BIT_OR:
                return Whkcc.Lexer.BOR;
            case BIT_XOR:
                return Whkcc.Lexer.BXOR;
            case ASSIGNMENT:
                return Whkcc.Lexer.ASSIGN;
            case IDENTIFIER:
                return Whkcc.Lexer.ID;
            default:
                return Whkcc.Lexer.YYerror;
        }
    }

    public static Whkcc.SymbolKind lexerId2SymbolKind(int lexerId) {
        return Whkcc.SymbolKind.values()[lexerId - 255];
    }

}
