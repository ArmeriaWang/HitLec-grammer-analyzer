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
