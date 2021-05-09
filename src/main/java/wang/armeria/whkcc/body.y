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

%right ASSIGN
%left LOR
%left LAND
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
	: TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

TOP_STATEMENTS
	: STATEMENT_VAR_DEF TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_FUNC_DEF TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_STRUCT_DEF TOP_STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENTS_BLOCK
	: BEGIN STATEMENTS END {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| BEGIN END {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENTS
	: STATEMENT STATEMENTS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT
	: STATEMENT_VAR_DEF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_ASSIGN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_IF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_WHILE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_STRUCT_DEF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT_RETURN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

EXP_R
	: EXP_R LT EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R LE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R GT EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R GE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R NE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R EQ EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R PLUS EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R MINUS EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R STAR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R DIVIDE EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R MOD EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R LOR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R LAND EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R BOR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R BXOR EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_R APSAND EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| PLUS EXP_R %prec POSITIVE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| MINUS EXP_R %prec NEGATIVE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| ROUND_LEFT EXP_R ROUND_RIGHT  {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| EXP_L {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| APSAND EXP_L %prec GET_ADDR {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STAR EXP_L %prec DEREF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| CONST_STRING {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| NUMBER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| FUNC_CALL {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

EXP_L
	: ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| ID DOT EXP_L {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| HD_ARRAY DOT EXP_L {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

HD_ARRAY
	: ID SQUARE_LEFT EXP_R SQUARE_RIGHT MORE_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

MORE_ARRAY_DIM
	: SQUARE_LEFT EXP_R SQUARE_RIGHT MORE_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

NUMBER
	: CONST_INTEGER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| CONST_BOOLEAN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| CONST_FLOAT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_IF
	: IF ROUND_LEFT EXP_R ROUND_RIGHT STATEMENTS_BLOCK STATEMENT_ELSE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_ELSE
	: ELSE STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| ELSE STATEMENT_IF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_WHILE
	: WHILE ROUND_LEFT EXP_R ROUND_RIGHT WHILE_BODY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

WHILE_BODY
	: STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STATEMENT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_VAR_DEF
	: VAR_DEF_TYPE DECLARE_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

DECLARE_MORE
	: SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| COMMA DECLARE_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| COMMA DECLARE_NON_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

DECLARE_NON_INITIALIZE
	: ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STAR ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STAR HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

DECLARE_INITIALIZE
	: ID ASSIGN EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| STAR ID ASSIGN EXP_R {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_ASSIGN
	: EXP_L ASSIGN EXP_R SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_STRUCT_DEF
	: STRUCT ID BEGIN STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF END SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

MORE_STRUCT_MEMBER_DEF
	: STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STRUCT_MEMBER_DEF
	: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

DECLARE_MORE_NON_INITIALIZE
	: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_RETURN
	: RETURN EXP_R SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

FUNC_CALL
	: ID ROUND_LEFT EXP_R SEND_FUNC_ARGS ROUND_RIGHT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| ID ROUND_LEFT ROUND_RIGHT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

SEND_FUNC_ARGS
	: COMMA EXP_R SEND_FUNC_ARGS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

STATEMENT_FUNC_DEF
	: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT ROUND_RIGHT STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS ROUND_RIGHT STATEMENTS_BLOCK {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

RECV_FUNC_ARGS
	: COMMA SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

SINGLE_RECV_FUNC_ARG
	: FUNC_DEF_TYPE ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| FUNC_DEF_TYPE RECV_HD_ARRAY {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

RECV_HD_ARRAY
	: ID SQUARE_LEFT SQUARE_RIGHT MORE_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT MORE_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

DT_STRUCT
	: STRUCT ID {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

DT_POINTER
	: VAR_DEF_TYPE STAR {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

VAR_DEF_TYPE
	: DT_INTEGER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
        | DT_FLOAT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
        | DT_BOOLEAN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| DT_STRUCT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

FUNC_DEF_TYPE
	: DT_INTEGER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| DT_FLOAT {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| DT_BOOLEAN {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| DT_POINTER {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;


%%
