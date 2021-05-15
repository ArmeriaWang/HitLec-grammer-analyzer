%language "Java"
%define api.parser.class {Whkcc}
%define api.parser.public
//%define api.value.type {ASTreeNode}

%define parse.error verbose

%define api.package {wang.armeria.whkcc};
%code imports {
import java.io.IOException;
import wang.armeria.token.Position;
}

%code {

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
}
%token DT_INTEGER DT_BOOLEAN DT_FLOAT STRUCT
%token WHILE
%token IF ELSE
%token RETURN
%token FUNCTION
%token CONST_INTEGER CONST_FLOAT CONST_STRING CONST_BOOLEAN ID
%token SEMICOLON COMMA DOT
%token ROUND_LEFT ROUND_RIGHT
%token SQUARE_LEFT SQUARE_RIGHT
%token BEGIN END
%token PLACEHOLDER

%right ASSIGN
%left LOR
%left LAND
%left LNOT
%left BOR
%left BXOR
%left APSAND
%left EQ NE
%left LE GE LT GT
%left PLUS MINUS
%left STAR DIVIDE MOD
%precedence GET_ADDR
%precedence DEREF
%precedence POSITIVE NEGATIVE

%nonassoc ELSE

%%


PROGRAM
	: TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

TOP_STATEMENTS
	: STATEMENT_VAR_DEF TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_FUNC_DEF TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_STRUCT_DEF TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENTS_BLOCK
	: BEGIN STATEMENTS END {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| BEGIN END {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENTS
	: STATEMENT STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT
	: STATEMENT_VAR_DEF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_ASSIGN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_IF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_WHILE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_STRUCT_DEF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_RETURN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT_EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

EXP_R
	: EXP_R LT EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R LE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R GT EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R GE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R NE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R EQ EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R PLUS EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R MINUS EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R STAR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R DIVIDE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R MOD EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R LOR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R LAND EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| LNOT EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R BOR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R BXOR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_R APSAND EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| PLUS EXP_R %prec POSITIVE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| MINUS EXP_R %prec NEGATIVE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| ROUND_LEFT EXP_R ROUND_RIGHT  {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_L {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| APSAND EXP_L %prec GET_ADDR {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STAR EXP_L %prec DEREF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| NUMBER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| FUNC_CALL {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

EXP_L
	: ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_L DOT ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| EXP_L DOT HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

HD_ARRAY
	: ID SQUARE_LEFT EXP_R SQUARE_RIGHT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| HD_ARRAY SQUARE_LEFT EXP_R SQUARE_RIGHT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_EXP_R
	: EXP_R SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

NUMBER
	: CONST_INTEGER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| CONST_BOOLEAN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| CONST_FLOAT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_IF
	: IF ROUND_LEFT EXP_R ROUND_RIGHT STATEMENTS_BLOCK STATEMENT_ELSE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_ELSE
	: ELSE STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| ELSE STATEMENT_IF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_WHILE
	: WHILE ROUND_LEFT EXP_R ROUND_RIGHT WHILE_BODY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

WHILE_BODY
	: STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STATEMENT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_VAR_DEF
	: VAR_DEF_TYPE DECLARE_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

DECLARE_MORE
	: SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| COMMA DECLARE_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| COMMA DECLARE_NON_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

DECLARE_NON_INITIALIZE
	: ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STAR ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STAR HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

DECLARE_INITIALIZE
	: ID ASSIGN EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| STAR ID ASSIGN EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_ASSIGN
	: EXP_L ASSIGN EXP_R SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_STRUCT_DEF
	: STRUCT ID BEGIN STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF END SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

MORE_STRUCT_MEMBER_DEF
	: STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STRUCT_MEMBER_DEF
	: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

DECLARE_MORE_NON_INITIALIZE
	: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_RETURN
	: RETURN EXP_R SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

FUNC_CALL
	: ID ROUND_LEFT EXP_R SEND_FUNC_ARGS ROUND_RIGHT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| ID ROUND_LEFT ROUND_RIGHT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

SEND_FUNC_ARGS
	: COMMA EXP_R SEND_FUNC_ARGS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

STATEMENT_FUNC_DEF
	: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT ROUND_RIGHT STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS ROUND_RIGHT STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

RECV_FUNC_ARGS
	: COMMA SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

SINGLE_RECV_FUNC_ARG
	: FUNC_DEF_TYPE ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| FUNC_DEF_TYPE RECV_HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

RECV_HD_ARRAY
	: ID SQUARE_LEFT SQUARE_RIGHT PLACEHOLDER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT PLACEHOLDER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

DT_STRUCT
	: STRUCT ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

DT_POINTER
	: VAR_DEF_TYPE STAR {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

VAR_DEF_TYPE
	: DT_INTEGER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
        | DT_FLOAT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
        | DT_BOOLEAN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| DT_STRUCT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

FUNC_DEF_TYPE
	: DT_INTEGER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| DT_FLOAT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| DT_BOOLEAN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	| DT_POINTER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen, yyn - 1);}
	;

%%
