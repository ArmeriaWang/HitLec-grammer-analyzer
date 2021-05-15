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
import wang.armeria.token.Position;

/* "Whkcc.java":49  */

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
    S_PLACEHOLDER(26),             /* PLACEHOLDER  */
    S_ASSIGN(27),                  /* ASSIGN  */
    S_LOR(28),                     /* LOR  */
    S_LAND(29),                    /* LAND  */
    S_LNOT(30),                    /* LNOT  */
    S_BOR(31),                     /* BOR  */
    S_BXOR(32),                    /* BXOR  */
    S_APSAND(33),                  /* APSAND  */
    S_EQ(34),                      /* EQ  */
    S_NE(35),                      /* NE  */
    S_LE(36),                      /* LE  */
    S_GE(37),                      /* GE  */
    S_LT(38),                      /* LT  */
    S_GT(39),                      /* GT  */
    S_PLUS(40),                    /* PLUS  */
    S_MINUS(41),                   /* MINUS  */
    S_STAR(42),                    /* STAR  */
    S_DIVIDE(43),                  /* DIVIDE  */
    S_MOD(44),                     /* MOD  */
    S_GET_ADDR(45),                /* GET_ADDR  */
    S_DEREF(46),                   /* DEREF  */
    S_POSITIVE(47),                /* POSITIVE  */
    S_NEGATIVE(48),                /* NEGATIVE  */
    S_YYACCEPT(49),                /* $accept  */
    S_PROGRAM(50),                 /* PROGRAM  */
    S_TOP_STATEMENTS(51),          /* TOP_STATEMENTS  */
    S_STATEMENTS_BLOCK(52),        /* STATEMENTS_BLOCK  */
    S_STATEMENTS(53),              /* STATEMENTS  */
    S_STATEMENT(54),               /* STATEMENT  */
    S_EXP_R(55),                   /* EXP_R  */
    S_EXP_L(56),                   /* EXP_L  */
    S_HD_ARRAY(57),                /* HD_ARRAY  */
    S_STATEMENT_EXP_R(58),         /* STATEMENT_EXP_R  */
    S_NUMBER(59),                  /* NUMBER  */
    S_STATEMENT_IF(60),            /* STATEMENT_IF  */
    S_STATEMENT_ELSE(61),          /* STATEMENT_ELSE  */
    S_STATEMENT_WHILE(62),         /* STATEMENT_WHILE  */
    S_WHILE_BODY(63),              /* WHILE_BODY  */
    S_STATEMENT_VAR_DEF(64),       /* STATEMENT_VAR_DEF  */
    S_DECLARE_MORE(65),            /* DECLARE_MORE  */
    S_DECLARE_NON_INITIALIZE(66),  /* DECLARE_NON_INITIALIZE  */
    S_DECLARE_INITIALIZE(67),      /* DECLARE_INITIALIZE  */
    S_STATEMENT_ASSIGN(68),        /* STATEMENT_ASSIGN  */
    S_STATEMENT_STRUCT_DEF(69),    /* STATEMENT_STRUCT_DEF  */
    S_MORE_STRUCT_MEMBER_DEF(70),  /* MORE_STRUCT_MEMBER_DEF  */
    S_STRUCT_MEMBER_DEF(71),       /* STRUCT_MEMBER_DEF  */
    S_DECLARE_MORE_NON_INITIALIZE(72), /* DECLARE_MORE_NON_INITIALIZE  */
    S_STATEMENT_RETURN(73),        /* STATEMENT_RETURN  */
    S_FUNC_CALL(74),               /* FUNC_CALL  */
    S_SEND_FUNC_ARGS(75),          /* SEND_FUNC_ARGS  */
    S_STATEMENT_FUNC_DEF(76),      /* STATEMENT_FUNC_DEF  */
    S_RECV_FUNC_ARGS(77),          /* RECV_FUNC_ARGS  */
    S_SINGLE_RECV_FUNC_ARG(78),    /* SINGLE_RECV_FUNC_ARG  */
    S_RECV_HD_ARRAY(79),           /* RECV_HD_ARRAY  */
    S_DT_STRUCT(80),               /* DT_STRUCT  */
    S_DT_POINTER(81),              /* DT_POINTER  */
    S_VAR_DEF_TYPE(82),            /* VAR_DEF_TYPE  */
    S_FUNC_DEF_TYPE(83);           /* FUNC_DEF_TYPE  */


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
      SymbolKind.S_PLACEHOLDER,
      SymbolKind.S_ASSIGN,
      SymbolKind.S_LOR,
      SymbolKind.S_LAND,
      SymbolKind.S_LNOT,
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
      SymbolKind.S_DEREF,
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
      SymbolKind.S_STATEMENT_EXP_R,
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
  "ROUND_RIGHT", "SQUARE_LEFT", "SQUARE_RIGHT", "BEGIN", "END",
  "PLACEHOLDER", "ASSIGN", "LOR", "LAND", "LNOT", "BOR", "BXOR", "APSAND",
  "EQ", "NE", "LE", "GE", "LT", "GT", "PLUS", "MINUS", "STAR", "DIVIDE",
  "MOD", "GET_ADDR", "DEREF", "POSITIVE", "NEGATIVE", "$accept", "PROGRAM",
  "TOP_STATEMENTS", "STATEMENTS_BLOCK", "STATEMENTS", "STATEMENT", "EXP_R",
  "EXP_L", "HD_ARRAY", "STATEMENT_EXP_R", "NUMBER", "STATEMENT_IF",
  "STATEMENT_ELSE", "STATEMENT_WHILE", "WHILE_BODY", "STATEMENT_VAR_DEF",
  "DECLARE_MORE", "DECLARE_NON_INITIALIZE", "DECLARE_INITIALIZE",
  "STATEMENT_ASSIGN", "STATEMENT_STRUCT_DEF", "MORE_STRUCT_MEMBER_DEF",
  "STRUCT_MEMBER_DEF", "DECLARE_MORE_NON_INITIALIZE", "STATEMENT_RETURN",
  "FUNC_CALL", "SEND_FUNC_ARGS", "STATEMENT_FUNC_DEF", "RECV_FUNC_ARGS",
  "SINGLE_RECV_FUNC_ARG", "RECV_HD_ARRAY", "DT_STRUCT", "DT_POINTER",
  "VAR_DEF_TYPE", "FUNC_DEF_TYPE", null
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
    /** Token PLACEHOLDER, to be returned by the scanner.  */
    static final int PLACEHOLDER = 281;
    /** Token ASSIGN, to be returned by the scanner.  */
    static final int ASSIGN = 282;
    /** Token LOR, to be returned by the scanner.  */
    static final int LOR = 283;
    /** Token LAND, to be returned by the scanner.  */
    static final int LAND = 284;
    /** Token LNOT, to be returned by the scanner.  */
    static final int LNOT = 285;
    /** Token BOR, to be returned by the scanner.  */
    static final int BOR = 286;
    /** Token BXOR, to be returned by the scanner.  */
    static final int BXOR = 287;
    /** Token APSAND, to be returned by the scanner.  */
    static final int APSAND = 288;
    /** Token EQ, to be returned by the scanner.  */
    static final int EQ = 289;
    /** Token NE, to be returned by the scanner.  */
    static final int NE = 290;
    /** Token LE, to be returned by the scanner.  */
    static final int LE = 291;
    /** Token GE, to be returned by the scanner.  */
    static final int GE = 292;
    /** Token LT, to be returned by the scanner.  */
    static final int LT = 293;
    /** Token GT, to be returned by the scanner.  */
    static final int GT = 294;
    /** Token PLUS, to be returned by the scanner.  */
    static final int PLUS = 295;
    /** Token MINUS, to be returned by the scanner.  */
    static final int MINUS = 296;
    /** Token STAR, to be returned by the scanner.  */
    static final int STAR = 297;
    /** Token DIVIDE, to be returned by the scanner.  */
    static final int DIVIDE = 298;
    /** Token MOD, to be returned by the scanner.  */
    static final int MOD = 299;
    /** Token GET_ADDR, to be returned by the scanner.  */
    static final int GET_ADDR = 300;
    /** Token DEREF, to be returned by the scanner.  */
    static final int DEREF = 301;
    /** Token POSITIVE, to be returned by the scanner.  */
    static final int POSITIVE = 302;
    /** Token NEGATIVE, to be returned by the scanner.  */
    static final int NEGATIVE = 303;

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
    /* "Whkcc.y":168  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 3: /* TOP_STATEMENTS: STATEMENT_VAR_DEF TOP_STATEMENTS  */
  if (yyn == 3)
    /* "Whkcc.y":172  */
                                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 4: /* TOP_STATEMENTS: STATEMENT_FUNC_DEF TOP_STATEMENTS  */
  if (yyn == 4)
    /* "Whkcc.y":173  */
                                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 5: /* TOP_STATEMENTS: STATEMENT_STRUCT_DEF TOP_STATEMENTS  */
  if (yyn == 5)
    /* "Whkcc.y":174  */
                                              {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 6: /* TOP_STATEMENTS: %empty  */
  if (yyn == 6)
    /* "Whkcc.y":175  */
          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 7: /* STATEMENTS_BLOCK: BEGIN STATEMENTS END  */
  if (yyn == 7)
    /* "Whkcc.y":179  */
                               {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 8: /* STATEMENTS_BLOCK: BEGIN END  */
  if (yyn == 8)
    /* "Whkcc.y":180  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 9: /* STATEMENTS: STATEMENT STATEMENTS  */
  if (yyn == 9)
    /* "Whkcc.y":184  */
                               {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 10: /* STATEMENTS: STATEMENT  */
  if (yyn == 10)
    /* "Whkcc.y":185  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 11: /* STATEMENT: STATEMENT_VAR_DEF  */
  if (yyn == 11)
    /* "Whkcc.y":189  */
                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 12: /* STATEMENT: STATEMENT_ASSIGN  */
  if (yyn == 12)
    /* "Whkcc.y":190  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 13: /* STATEMENT: STATEMENT_IF  */
  if (yyn == 13)
    /* "Whkcc.y":191  */
                       {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 14: /* STATEMENT: STATEMENT_WHILE  */
  if (yyn == 14)
    /* "Whkcc.y":192  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 15: /* STATEMENT: STATEMENT_STRUCT_DEF  */
  if (yyn == 15)
    /* "Whkcc.y":193  */
                               {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 16: /* STATEMENT: STATEMENT_RETURN  */
  if (yyn == 16)
    /* "Whkcc.y":194  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 17: /* STATEMENT: STATEMENT_EXP_R  */
  if (yyn == 17)
    /* "Whkcc.y":195  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 18: /* STATEMENT: SEMICOLON  */
  if (yyn == 18)
    /* "Whkcc.y":196  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 19: /* EXP_R: EXP_R LT EXP_R  */
  if (yyn == 19)
    /* "Whkcc.y":200  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 20: /* EXP_R: EXP_R LE EXP_R  */
  if (yyn == 20)
    /* "Whkcc.y":201  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 21: /* EXP_R: EXP_R GT EXP_R  */
  if (yyn == 21)
    /* "Whkcc.y":202  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 22: /* EXP_R: EXP_R GE EXP_R  */
  if (yyn == 22)
    /* "Whkcc.y":203  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 23: /* EXP_R: EXP_R NE EXP_R  */
  if (yyn == 23)
    /* "Whkcc.y":204  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 24: /* EXP_R: EXP_R EQ EXP_R  */
  if (yyn == 24)
    /* "Whkcc.y":205  */
                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 25: /* EXP_R: EXP_R PLUS EXP_R  */
  if (yyn == 25)
    /* "Whkcc.y":206  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 26: /* EXP_R: EXP_R MINUS EXP_R  */
  if (yyn == 26)
    /* "Whkcc.y":207  */
                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 27: /* EXP_R: EXP_R STAR EXP_R  */
  if (yyn == 27)
    /* "Whkcc.y":208  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 28: /* EXP_R: EXP_R DIVIDE EXP_R  */
  if (yyn == 28)
    /* "Whkcc.y":209  */
                             {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 29: /* EXP_R: EXP_R MOD EXP_R  */
  if (yyn == 29)
    /* "Whkcc.y":210  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 30: /* EXP_R: EXP_R LOR EXP_R  */
  if (yyn == 30)
    /* "Whkcc.y":211  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 31: /* EXP_R: EXP_R LAND EXP_R  */
  if (yyn == 31)
    /* "Whkcc.y":212  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 32: /* EXP_R: LNOT EXP_R  */
  if (yyn == 32)
    /* "Whkcc.y":213  */
                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 33: /* EXP_R: EXP_R BOR EXP_R  */
  if (yyn == 33)
    /* "Whkcc.y":214  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 34: /* EXP_R: EXP_R BXOR EXP_R  */
  if (yyn == 34)
    /* "Whkcc.y":215  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 35: /* EXP_R: EXP_R APSAND EXP_R  */
  if (yyn == 35)
    /* "Whkcc.y":216  */
                             {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 36: /* EXP_R: PLUS EXP_R  */
  if (yyn == 36)
    /* "Whkcc.y":217  */
                                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 37: /* EXP_R: MINUS EXP_R  */
  if (yyn == 37)
    /* "Whkcc.y":218  */
                                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 38: /* EXP_R: ROUND_LEFT EXP_R ROUND_RIGHT  */
  if (yyn == 38)
    /* "Whkcc.y":219  */
                                        {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 39: /* EXP_R: EXP_L  */
  if (yyn == 39)
    /* "Whkcc.y":220  */
                {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 40: /* EXP_R: APSAND EXP_L  */
  if (yyn == 40)
    /* "Whkcc.y":221  */
                                      {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 41: /* EXP_R: STAR EXP_L  */
  if (yyn == 41)
    /* "Whkcc.y":222  */
                                 {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 42: /* EXP_R: NUMBER  */
  if (yyn == 42)
    /* "Whkcc.y":223  */
                 {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 43: /* EXP_R: FUNC_CALL  */
  if (yyn == 43)
    /* "Whkcc.y":224  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 44: /* EXP_L: ID  */
  if (yyn == 44)
    /* "Whkcc.y":228  */
             {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 45: /* EXP_L: EXP_L DOT ID  */
  if (yyn == 45)
    /* "Whkcc.y":229  */
                       {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 46: /* EXP_L: HD_ARRAY  */
  if (yyn == 46)
    /* "Whkcc.y":230  */
                   {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 47: /* EXP_L: EXP_L DOT HD_ARRAY  */
  if (yyn == 47)
    /* "Whkcc.y":231  */
                             {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 48: /* HD_ARRAY: ID SQUARE_LEFT EXP_R SQUARE_RIGHT  */
  if (yyn == 48)
    /* "Whkcc.y":235  */
                                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 49: /* HD_ARRAY: HD_ARRAY SQUARE_LEFT EXP_R SQUARE_RIGHT  */
  if (yyn == 49)
    /* "Whkcc.y":236  */
                                                  {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 50: /* STATEMENT_EXP_R: EXP_R SEMICOLON  */
  if (yyn == 50)
    /* "Whkcc.y":240  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 51: /* NUMBER: CONST_INTEGER  */
  if (yyn == 51)
    /* "Whkcc.y":244  */
                        {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 52: /* NUMBER: CONST_BOOLEAN  */
  if (yyn == 52)
    /* "Whkcc.y":245  */
                        {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 53: /* NUMBER: CONST_FLOAT  */
  if (yyn == 53)
    /* "Whkcc.y":246  */
                      {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 54: /* STATEMENT_IF: IF ROUND_LEFT EXP_R ROUND_RIGHT STATEMENTS_BLOCK STATEMENT_ELSE  */
  if (yyn == 54)
    /* "Whkcc.y":250  */
                                                                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 55: /* STATEMENT_ELSE: ELSE STATEMENTS_BLOCK  */
  if (yyn == 55)
    /* "Whkcc.y":254  */
                                {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 56: /* STATEMENT_ELSE: ELSE STATEMENT_IF  */
  if (yyn == 56)
    /* "Whkcc.y":255  */
                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 57: /* STATEMENT_ELSE: %empty  */
  if (yyn == 57)
    /* "Whkcc.y":256  */
          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 58: /* STATEMENT_WHILE: WHILE ROUND_LEFT EXP_R ROUND_RIGHT WHILE_BODY  */
  if (yyn == 58)
    /* "Whkcc.y":260  */
                                                        {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 59: /* WHILE_BODY: STATEMENTS_BLOCK  */
  if (yyn == 59)
    /* "Whkcc.y":264  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 60: /* WHILE_BODY: STATEMENT  */
  if (yyn == 60)
    /* "Whkcc.y":265  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 61: /* STATEMENT_VAR_DEF: VAR_DEF_TYPE DECLARE_INITIALIZE DECLARE_MORE  */
  if (yyn == 61)
    /* "Whkcc.y":269  */
                                                       {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 62: /* STATEMENT_VAR_DEF: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE  */
  if (yyn == 62)
    /* "Whkcc.y":270  */
                                                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 63: /* DECLARE_MORE: SEMICOLON  */
  if (yyn == 63)
    /* "Whkcc.y":274  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 64: /* DECLARE_MORE: COMMA DECLARE_INITIALIZE DECLARE_MORE  */
  if (yyn == 64)
    /* "Whkcc.y":275  */
                                                {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 65: /* DECLARE_MORE: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE  */
  if (yyn == 65)
    /* "Whkcc.y":276  */
                                                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 66: /* DECLARE_NON_INITIALIZE: ID  */
  if (yyn == 66)
    /* "Whkcc.y":280  */
             {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 67: /* DECLARE_NON_INITIALIZE: STAR ID  */
  if (yyn == 67)
    /* "Whkcc.y":281  */
                  {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 68: /* DECLARE_NON_INITIALIZE: HD_ARRAY  */
  if (yyn == 68)
    /* "Whkcc.y":282  */
                   {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 69: /* DECLARE_NON_INITIALIZE: STAR HD_ARRAY  */
  if (yyn == 69)
    /* "Whkcc.y":283  */
                        {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 70: /* DECLARE_INITIALIZE: ID ASSIGN EXP_R  */
  if (yyn == 70)
    /* "Whkcc.y":287  */
                          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 71: /* DECLARE_INITIALIZE: STAR ID ASSIGN EXP_R  */
  if (yyn == 71)
    /* "Whkcc.y":288  */
                               {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 72: /* STATEMENT_ASSIGN: EXP_L ASSIGN EXP_R SEMICOLON  */
  if (yyn == 72)
    /* "Whkcc.y":292  */
                                       {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 73: /* STATEMENT_STRUCT_DEF: STRUCT ID BEGIN STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF END SEMICOLON  */
  if (yyn == 73)
    /* "Whkcc.y":296  */
                                                                                 {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 74: /* MORE_STRUCT_MEMBER_DEF: STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF  */
  if (yyn == 74)
    /* "Whkcc.y":300  */
                                                   {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 75: /* MORE_STRUCT_MEMBER_DEF: %empty  */
  if (yyn == 75)
    /* "Whkcc.y":301  */
          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 76: /* STRUCT_MEMBER_DEF: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE SEMICOLON  */
  if (yyn == 76)
    /* "Whkcc.y":305  */
                                                                                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 77: /* DECLARE_MORE_NON_INITIALIZE: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE  */
  if (yyn == 77)
    /* "Whkcc.y":309  */
                                                                   {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 78: /* DECLARE_MORE_NON_INITIALIZE: %empty  */
  if (yyn == 78)
    /* "Whkcc.y":310  */
          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 79: /* STATEMENT_RETURN: RETURN EXP_R SEMICOLON  */
  if (yyn == 79)
    /* "Whkcc.y":314  */
                                 {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 80: /* FUNC_CALL: ID ROUND_LEFT EXP_R SEND_FUNC_ARGS ROUND_RIGHT  */
  if (yyn == 80)
    /* "Whkcc.y":318  */
                                                         {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 81: /* FUNC_CALL: ID ROUND_LEFT ROUND_RIGHT  */
  if (yyn == 81)
    /* "Whkcc.y":319  */
                                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 82: /* SEND_FUNC_ARGS: COMMA EXP_R SEND_FUNC_ARGS  */
  if (yyn == 82)
    /* "Whkcc.y":323  */
                                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 83: /* SEND_FUNC_ARGS: %empty  */
  if (yyn == 83)
    /* "Whkcc.y":324  */
          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 84: /* STATEMENT_FUNC_DEF: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT ROUND_RIGHT STATEMENTS_BLOCK  */
  if (yyn == 84)
    /* "Whkcc.y":328  */
                                                                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 85: /* STATEMENT_FUNC_DEF: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS ROUND_RIGHT STATEMENTS_BLOCK  */
  if (yyn == 85)
    /* "Whkcc.y":329  */
                                                                                                                {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 86: /* RECV_FUNC_ARGS: COMMA SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS  */
  if (yyn == 86)
    /* "Whkcc.y":333  */
                                                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 87: /* RECV_FUNC_ARGS: %empty  */
  if (yyn == 87)
    /* "Whkcc.y":334  */
          {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 88: /* SINGLE_RECV_FUNC_ARG: FUNC_DEF_TYPE ID  */
  if (yyn == 88)
    /* "Whkcc.y":338  */
                           {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 89: /* SINGLE_RECV_FUNC_ARG: FUNC_DEF_TYPE RECV_HD_ARRAY  */
  if (yyn == 89)
    /* "Whkcc.y":339  */
                                      {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 90: /* RECV_HD_ARRAY: ID SQUARE_LEFT SQUARE_RIGHT PLACEHOLDER  */
  if (yyn == 90)
    /* "Whkcc.y":343  */
                                                  {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 91: /* RECV_HD_ARRAY: ID SQUARE_LEFT EXP_R SQUARE_RIGHT PLACEHOLDER  */
  if (yyn == 91)
    /* "Whkcc.y":344  */
                                                        {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 92: /* DT_STRUCT: STRUCT ID  */
  if (yyn == 92)
    /* "Whkcc.y":348  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 93: /* DT_POINTER: VAR_DEF_TYPE STAR  */
  if (yyn == 93)
    /* "Whkcc.y":352  */
                            {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 94: /* VAR_DEF_TYPE: DT_INTEGER  */
  if (yyn == 94)
    /* "Whkcc.y":356  */
                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 95: /* VAR_DEF_TYPE: DT_FLOAT  */
  if (yyn == 95)
    /* "Whkcc.y":357  */
                   {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 96: /* VAR_DEF_TYPE: DT_BOOLEAN  */
  if (yyn == 96)
    /* "Whkcc.y":358  */
                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 97: /* VAR_DEF_TYPE: DT_STRUCT  */
  if (yyn == 97)
    /* "Whkcc.y":359  */
                    {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 98: /* FUNC_DEF_TYPE: DT_INTEGER  */
  if (yyn == 98)
    /* "Whkcc.y":363  */
                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 99: /* FUNC_DEF_TYPE: DT_FLOAT  */
  if (yyn == 99)
    /* "Whkcc.y":364  */
                   {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 100: /* FUNC_DEF_TYPE: DT_BOOLEAN  */
  if (yyn == 100)
    /* "Whkcc.y":365  */
                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;


  case 101: /* FUNC_DEF_TYPE: DT_POINTER  */
  if (yyn == 101)
    /* "Whkcc.y":366  */
                     {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);};
  break;



/* "Whkcc.java":1347  */

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

  private static final short yypact_ninf_ = -108;
  private static final short yytable_ninf_ = -101;

/* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
   STATE-NUM.  */
  private static final short[] yypact_ = yypact_init();
  private static final short[] yypact_init()
  {
    return new short[]
    {
      65,  -108,  -108,  -108,    -1,   126,    18,  -108,    65,    65,
      65,  -108,   -10,     7,    19,    30,    56,    70,  -108,    -8,
      77,  -108,  -108,  -108,  -108,    62,    81,    72,     4,     4,
     157,  -108,  -108,    82,   218,   218,    87,    72,   218,  -108,
     -10,  -108,  -108,   157,    -9,    21,  -108,  -108,  -108,    90,
     218,   218,    97,   218,   218,    97,   410,    84,    72,  -108,
    -108,   471,   218,   432,     4,     4,   100,   157,   104,   128,
     131,   122,   136,   137,   181,   340,   501,   104,    84,  -108,
    -108,    84,  -108,   218,   218,   218,   218,   218,   218,   218,
     218,   218,   218,   218,   218,   218,   218,   218,   218,   150,
     471,  -108,  -108,  -108,   147,  -108,   104,    -9,   152,    75,
    -108,   126,   146,   149,  -108,  -108,   316,  -108,   487,   501,
     514,   526,   537,   243,   243,    78,    78,    78,    78,    92,
      92,  -108,  -108,  -108,   104,    72,  -108,   131,  -108,   153,
     154,   218,  -108,  -108,   145,   175,   233,    17,  -108,  -108,
    -108,  -108,  -108,  -108,  -108,   136,   122,   212,   218,   151,
    -108,   218,   218,   261,  -108,  -108,  -108,   218,  -108,  -108,
     158,   454,   316,  -108,   364,   388,  -108,   289,  -108,   160,
    -108,   135,   122,  -108,  -108,  -108,  -108,  -108,   180,     5,
    -108,  -108,  -108
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
       6,    94,    96,    95,     0,     0,     0,     2,     6,     6,
       6,    97,     0,    92,    94,    96,    95,     0,   101,     0,
       0,     1,     3,     5,     4,    66,     0,    68,     0,     0,
       0,    92,    93,     0,     0,     0,    67,    69,     0,    63,
       0,    62,    61,    75,     0,     0,    51,    53,    52,    44,
       0,     0,     0,     0,     0,     0,     0,    39,    46,    42,
      43,    70,     0,     0,     0,     0,     0,    75,    66,     0,
      78,     0,    87,     0,     0,     0,    32,    44,    40,    36,
      37,    41,    48,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
      71,    49,    65,    64,     0,    74,    67,     0,     0,     0,
      84,     0,     0,    88,    89,    81,    83,    38,    30,    31,
      33,    34,    35,    24,    23,    20,    22,    19,    21,    25,
      26,    27,    28,    29,    45,    47,    73,    78,    76,     0,
       0,     0,    18,     8,     0,    10,     0,    39,    17,    13,
      14,    11,    12,    15,    16,    87,     0,     0,     0,     0,
      77,     0,     0,     0,     7,     9,    50,     0,    86,    85,
       0,     0,    83,    80,     0,     0,    79,     0,    90,     0,
      82,     0,     0,    72,    91,    59,    60,    58,    57,     0,
      54,    55,    56
    };
  }

/* YYPGOTO[NTERM-NUM].  */
  private static final short[] yypgoto_ = yypgoto_init();
  private static final short[] yypgoto_init()
  {
    return new short[]
    {
    -108,  -108,   148,   -83,    53,    22,   -34,   -44,    -3,  -108,
    -108,    10,  -108,  -108,  -108,  -107,   -17,   -30,   164,  -108,
    -106,   133,   176,    73,  -108,  -108,    35,  -108,    54,   101,
    -108,  -108,  -108,     0,   208
    };
  }

/* YYDEFGOTO[NTERM-NUM].  */
  private static final short[] yydefgoto_ = yydefgoto_init();
  private static final short[] yydefgoto_init()
  {
    return new short[]
    {
       0,     6,     7,   110,   144,   145,   146,    57,    58,   148,
      59,   149,   190,   150,   187,     8,    41,    28,    29,   152,
       9,    66,    67,   108,   154,    60,   159,    10,   112,    72,
     114,    11,    18,    12,    73
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
      56,    61,   151,   153,    63,    19,    25,    68,    78,    27,
      64,    81,    42,   140,    70,    13,    75,    76,    21,    79,
      80,    39,    40,    37,    14,    15,    16,    17,   100,   109,
      44,    30,    26,    69,    32,   -98,    99,    27,   151,   153,
     116,    27,    71,    44,   167,    19,  -100,   102,   103,   118,
     119,   120,   121,   122,   123,   124,   125,   126,   127,   128,
     129,   130,   131,   132,   133,   147,    37,    44,     1,     2,
       3,     4,   -99,   169,   151,   153,     5,   137,     1,     2,
       3,     4,   139,   140,    34,   141,    31,    46,    47,    35,
      48,    49,   142,    33,    38,    50,   135,    36,   185,   188,
     143,   147,    45,    99,    27,    51,   191,   163,    52,    34,
      74,    19,    34,    77,    62,    53,    54,    55,    94,    95,
      96,    97,    98,   171,   172,   104,    34,   174,   175,    14,
      15,    16,    17,   177,    96,    97,    98,   147,     1,     2,
       3,     4,   139,   140,   106,   141,   109,    46,    47,   107,
      48,    49,   142,   113,   111,    50,    22,    23,    24,   109,
       1,     2,     3,    17,   136,    51,   134,   156,    52,   138,
     164,   157,   173,   161,   162,    53,    54,    55,     1,     2,
       3,     4,   139,   140,   178,   141,   184,    46,    47,   189,
      48,    49,   142,    46,    47,    50,    48,    49,   165,   192,
     105,    50,   115,   186,    65,    51,    43,   180,    52,   168,
     160,    51,   155,    20,    52,    53,    54,    55,     0,     0,
       0,    53,    54,    55,    46,    47,     0,    48,    49,     0,
      46,    47,    50,    48,    49,   170,     0,     0,    50,     0,
       0,     0,    51,     0,     0,    52,     0,     0,    51,     0,
     166,    52,    53,    54,    55,     0,     0,     0,    53,    54,
      55,    83,    84,     0,    85,    86,    87,    88,    89,    90,
      91,    92,    93,    94,    95,    96,    97,    98,   176,    90,
      91,    92,    93,    94,    95,    96,    97,    98,     0,    83,
      84,     0,    85,    86,    87,    88,    89,    90,    91,    92,
      93,    94,    95,    96,    97,    98,   183,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    83,    84,     0,
      85,    86,    87,    88,    89,    90,    91,    92,    93,    94,
      95,    96,    97,    98,   158,     0,     0,     0,     0,     0,
       0,     0,     0,     0,    83,    84,     0,    85,    86,    87,
      88,    89,    90,    91,    92,    93,    94,    95,    96,    97,
      98,   117,     0,     0,     0,     0,     0,     0,    83,    84,
       0,    85,    86,    87,    88,    89,    90,    91,    92,    93,
      94,    95,    96,    97,    98,   181,     0,     0,     0,     0,
       0,     0,    83,    84,     0,    85,    86,    87,    88,    89,
      90,    91,    92,    93,    94,    95,    96,    97,    98,   182,
       0,     0,     0,     0,     0,     0,    83,    84,     0,    85,
      86,    87,    88,    89,    90,    91,    92,    93,    94,    95,
      96,    97,    98,    82,     0,     0,     0,     0,    83,    84,
       0,    85,    86,    87,    88,    89,    90,    91,    92,    93,
      94,    95,    96,    97,    98,   101,     0,     0,     0,     0,
      83,    84,     0,    85,    86,    87,    88,    89,    90,    91,
      92,    93,    94,    95,    96,    97,    98,   179,     0,     0,
       0,     0,    83,    84,     0,    85,    86,    87,    88,    89,
      90,    91,    92,    93,    94,    95,    96,    97,    98,    83,
      84,     0,    85,    86,    87,    88,    89,    90,    91,    92,
      93,    94,    95,    96,    97,    98,    84,     0,    85,    86,
      87,    88,    89,    90,    91,    92,    93,    94,    95,    96,
      97,    98,    85,    86,    87,    88,    89,    90,    91,    92,
      93,    94,    95,    96,    97,    98,    86,    87,    88,    89,
      90,    91,    92,    93,    94,    95,    96,    97,    98,    87,
      88,    89,    90,    91,    92,    93,    94,    95,    96,    97,
      98,    88,    89,    90,    91,    92,    93,    94,    95,    96,
      97,    98
    };
  }

private static final short[] yycheck_ = yycheck_init();
  private static final short[] yycheck_init()
  {
    return new short[]
    {
      34,    35,   109,   109,    38,     5,    16,    16,    52,    12,
      40,    55,    29,     8,    44,    16,    50,    51,     0,    53,
      54,    17,    18,    26,     3,     4,     5,     6,    62,    24,
      30,    24,    42,    42,    42,    16,    19,    40,   145,   145,
      74,    44,    21,    43,    27,    45,    16,    64,    65,    83,
      84,    85,    86,    87,    88,    89,    90,    91,    92,    93,
      94,    95,    96,    97,    98,   109,    69,    67,     3,     4,
       5,     6,    16,   156,   181,   181,    11,   107,     3,     4,
       5,     6,     7,     8,    22,    10,    16,    12,    13,    27,
      15,    16,    17,    16,    22,    20,    99,    16,   181,   182,
      25,   145,    20,    19,   107,    30,   189,   141,    33,    22,
      20,   111,    22,    16,    27,    40,    41,    42,    40,    41,
      42,    43,    44,   157,   158,    25,    22,   161,   162,     3,
       4,     5,     6,   167,    42,    43,    44,   181,     3,     4,
       5,     6,     7,     8,    16,    10,    24,    12,    13,    18,
      15,    16,    17,    16,    18,    20,     8,     9,    10,    24,
       3,     4,     5,     6,    17,    30,    16,    21,    33,    17,
      25,    22,    21,    20,    20,    40,    41,    42,     3,     4,
       5,     6,     7,     8,    26,    10,    26,    12,    13,     9,
      15,    16,    17,    12,    13,    20,    15,    16,   145,   189,
      67,    20,    21,   181,    40,    30,    30,   172,    33,   155,
     137,    30,   111,     5,    33,    40,    41,    42,    -1,    -1,
      -1,    40,    41,    42,    12,    13,    -1,    15,    16,    -1,
      12,    13,    20,    15,    16,    23,    -1,    -1,    20,    -1,
      -1,    -1,    30,    -1,    -1,    33,    -1,    -1,    30,    -1,
      17,    33,    40,    41,    42,    -1,    -1,    -1,    40,    41,
      42,    28,    29,    -1,    31,    32,    33,    34,    35,    36,
      37,    38,    39,    40,    41,    42,    43,    44,    17,    36,
      37,    38,    39,    40,    41,    42,    43,    44,    -1,    28,
      29,    -1,    31,    32,    33,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    43,    44,    17,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,    -1,    28,    29,    -1,
      31,    32,    33,    34,    35,    36,    37,    38,    39,    40,
      41,    42,    43,    44,    18,    -1,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    28,    29,    -1,    31,    32,    33,
      34,    35,    36,    37,    38,    39,    40,    41,    42,    43,
      44,    21,    -1,    -1,    -1,    -1,    -1,    -1,    28,    29,
      -1,    31,    32,    33,    34,    35,    36,    37,    38,    39,
      40,    41,    42,    43,    44,    21,    -1,    -1,    -1,    -1,
      -1,    -1,    28,    29,    -1,    31,    32,    33,    34,    35,
      36,    37,    38,    39,    40,    41,    42,    43,    44,    21,
      -1,    -1,    -1,    -1,    -1,    -1,    28,    29,    -1,    31,
      32,    33,    34,    35,    36,    37,    38,    39,    40,    41,
      42,    43,    44,    23,    -1,    -1,    -1,    -1,    28,    29,
      -1,    31,    32,    33,    34,    35,    36,    37,    38,    39,
      40,    41,    42,    43,    44,    23,    -1,    -1,    -1,    -1,
      28,    29,    -1,    31,    32,    33,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    43,    44,    23,    -1,    -1,
      -1,    -1,    28,    29,    -1,    31,    32,    33,    34,    35,
      36,    37,    38,    39,    40,    41,    42,    43,    44,    28,
      29,    -1,    31,    32,    33,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    43,    44,    29,    -1,    31,    32,
      33,    34,    35,    36,    37,    38,    39,    40,    41,    42,
      43,    44,    31,    32,    33,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    43,    44,    32,    33,    34,    35,
      36,    37,    38,    39,    40,    41,    42,    43,    44,    33,
      34,    35,    36,    37,    38,    39,    40,    41,    42,    43,
      44,    34,    35,    36,    37,    38,    39,    40,    41,    42,
      43,    44
    };
  }

/* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
   symbol of state STATE-NUM.  */
  private static final byte[] yystos_ = yystos_init();
  private static final byte[] yystos_init()
  {
    return new byte[]
    {
       0,     3,     4,     5,     6,    11,    50,    51,    64,    69,
      76,    80,    82,    16,     3,     4,     5,     6,    81,    82,
      83,     0,    51,    51,    51,    16,    42,    57,    66,    67,
      24,    16,    42,    16,    22,    27,    16,    57,    22,    17,
      18,    65,    65,    71,    82,    20,    12,    13,    15,    16,
      20,    30,    33,    40,    41,    42,    55,    56,    57,    59,
      74,    55,    27,    55,    66,    67,    70,    71,    16,    42,
      66,    21,    78,    83,    20,    55,    55,    16,    56,    55,
      55,    56,    23,    28,    29,    31,    32,    33,    34,    35,
      36,    37,    38,    39,    40,    41,    42,    43,    44,    19,
      55,    23,    65,    65,    25,    70,    16,    18,    72,    24,
      52,    18,    77,    16,    79,    21,    55,    21,    55,    55,
      55,    55,    55,    55,    55,    55,    55,    55,    55,    55,
      55,    55,    55,    55,    16,    57,    17,    66,    17,     7,
       8,    10,    17,    25,    53,    54,    55,    56,    58,    60,
      62,    64,    68,    69,    73,    78,    21,    22,    18,    75,
      72,    20,    20,    55,    25,    53,    17,    27,    77,    52,
      23,    55,    55,    21,    55,    55,    17,    55,    26,    23,
      75,    21,    21,    17,    26,    52,    54,    63,    52,     9,
      61,    52,    60
    };
  }

/* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte[] yyr1_ = yyr1_init();
  private static final byte[] yyr1_init()
  {
    return new byte[]
    {
       0,    49,    50,    51,    51,    51,    51,    52,    52,    53,
      53,    54,    54,    54,    54,    54,    54,    54,    54,    55,
      55,    55,    55,    55,    55,    55,    55,    55,    55,    55,
      55,    55,    55,    55,    55,    55,    55,    55,    55,    55,
      55,    55,    55,    55,    56,    56,    56,    56,    57,    57,
      58,    59,    59,    59,    60,    61,    61,    61,    62,    63,
      63,    64,    64,    65,    65,    65,    66,    66,    66,    66,
      67,    67,    68,    69,    70,    70,    71,    72,    72,    73,
      74,    74,    75,    75,    76,    76,    77,    77,    78,    78,
      79,    79,    80,    81,    82,    82,    82,    82,    83,    83,
      83,    83
    };
  }

/* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
  private static final byte[] yyr2_ = yyr2_init();
  private static final byte[] yyr2_init()
  {
    return new byte[]
    {
       0,     2,     1,     2,     2,     2,     0,     3,     2,     2,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     3,
       3,     3,     3,     3,     3,     3,     3,     3,     3,     3,
       3,     3,     2,     3,     3,     3,     2,     2,     3,     1,
       2,     2,     1,     1,     1,     3,     1,     3,     4,     4,
       2,     1,     1,     1,     6,     2,     2,     0,     5,     1,
       1,     3,     3,     1,     3,     3,     1,     2,     1,     2,
       3,     4,     4,     7,     2,     0,     4,     3,     0,     3,
       5,     3,     3,     0,     6,     8,     3,     0,     2,     2,
       4,     5,     2,     2,     1,     1,     1,     1,     1,     1,
       1,     1
    };
  }




  /* YYTRANSLATE_(TOKEN-NUM) -- Symbol number corresponding to TOKEN-NUM
     as returned by yylex, with out-of-bounds checking.  */
  private static final SymbolKind yytranslate_(int t)
  {
    // Last valid token kind.
    int code_max = 303;
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
      45,    46,    47,    48
    };
  }


  private static final int YYLAST_ = 581;
  private static final int YYEMPTY_ = -2;
  private static final int YYFINAL_ = 21;
  private static final int YYNTOKENS_ = 49;

/* Unqualified %code blocks.  */
/* "Whkcc.y":14  */


private static final int YYERRTOKEN = 9;

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

/* "Whkcc.java":2242  */

}
/* "Whkcc.y":369  */

