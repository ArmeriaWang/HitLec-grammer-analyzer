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
%precedence POSITIVE NEGATIVE

%nonassoc ELSE

%%


PROGRAM
	: TOP_STATEMENTS {wl.addNonTerminalNode(SymbolKind.S_PROGRAM, 1);}
	;

TOP_STATEMENTS
	: STATEMENT_VAR_DEF TOP_STATEMENTS {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 2);}
	| STATEMENT_FUNC_DEF TOP_STATEMENTS {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 2);}
	| STATEMENT_STRUCT_DEF TOP_STATEMENTS {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 2);}
	| {wl.addNonTerminalNode(SymbolKind.S_TOP_STATEMENTS, 0);}
	;

STATEMENTS_BLOCK
	: BEGIN STATEMENTS END {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS_BLOCK, 3);}
	| BEGIN END {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS_BLOCK, 2);}
	;

STATEMENTS
	: STATEMENT STATEMENTS {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS, 2);}
	| STATEMENT {wl.addNonTerminalNode(SymbolKind.S_STATEMENTS, 1);}
	;

STATEMENT
	: STATEMENT_VAR_DEF {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	| STATEMENT_ASSIGN {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	| STATEMENT_IF {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	| STATEMENT_WHILE {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	| STATEMENT_STRUCT_DEF {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	| STATEMENT_RETURN {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	| FUNC_CALL SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 2);}
	| SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_STATEMENT, 1);}
	;

EXP_R
	: EXP_R LT EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R LE EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R GT EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R GE EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R NE EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R EQ EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R PLUS EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R MINUS EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R STAR EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R DIVIDE EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R MOD EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R LOR EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R LAND EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R BOR EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R BXOR EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| EXP_R APSAND EXP_R {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| PLUS EXP_R %prec POSITIVE {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 2);}
	| MINUS EXP_R %prec NEGATIVE {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 2);}
	| ROUND_LEFT EXP_R ROUND_RIGHT  {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| ID {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 4);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT DOT ID {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 6);}
	| ID DOT ID {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 3);}
	| APSAND EXP_L %prec GET_ADDR {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 2);}
	| CONST_STRING {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);}
	| NUMBER {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);}
	| FUNC_CALL {wl.addNonTerminalNode(SymbolKind.S_EXP_R, 1);}
	;

EXP_L:
	| ID {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 1);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 4);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT DOT ID {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 6);}
	| ID DOT ID {wl.addNonTerminalNode(SymbolKind.S_EXP_L, 3);}
	;

NUMBER
	: CONST_INTEGER {wl.addNonTerminalNode(SymbolKind.S_NUMBER, 1);}
	| CONST_BOOLEAN {wl.addNonTerminalNode(SymbolKind.S_NUMBER, 1);}
	| CONST_FLOAT {wl.addNonTerminalNode(SymbolKind.S_NUMBER, 1);}
	;

STATEMENT_IF
	: IF ROUND_LEFT EXP_R ROUND_RIGHT STATEMENTS_BLOCK STATEMENT_ELSE {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_IF, 6);}
	;

STATEMENT_ELSE
	: ELSE STATEMENTS_BLOCK {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ELSE, 2);}
	| ELSE STATEMENT_IF {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ELSE, 2);}
	| {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ELSE, 0);}
	;

STATEMENT_WHILE
	: WHILE ROUND_LEFT EXP_R ROUND_RIGHT WHILE_BODY {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_WHILE, 5);}
	;

WHILE_BODY
	: STATEMENTS_BLOCK {wl.addNonTerminalNode(SymbolKind.S_WHILE_BODY, 1);}
	| STATEMENT {wl.addNonTerminalNode(SymbolKind.S_WHILE_BODY, 1);}
	;

STATEMENT_VAR_DEF
	: VAR_DEF_TYPE DECLARE_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_VAR_DEF, 3);}
	| VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_VAR_DEF, 3);}
	;

DECLARE_MORE
	: SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE, 1);}
	| COMMA DECLARE_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE, 3);}
	| COMMA DECLARE_NON_INITIALIZE DECLARE_MORE {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE, 3);}
	;

DECLARE_NON_INITIALIZE
	: ID {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 1);}
	| STAR ID {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 2);}
	| ID SQUARE_LEFT CONST_INTEGER SQUARE_RIGHT {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 4);}
	| STAR ID SQUARE_LEFT CONST_INTEGER SQUARE_RIGHT {wl.addNonTerminalNode(SymbolKind.S_DECLARE_NON_INITIALIZE, 5);}
	;

DECLARE_INITIALIZE
	: ID ASSIGN EXP_R {wl.addNonTerminalNode(SymbolKind.S_DECLARE_INITIALIZE, 3);}
	| STAR ID ASSIGN EXP_R {wl.addNonTerminalNode(SymbolKind.S_DECLARE_INITIALIZE, 4);}
	;

STATEMENT_ASSIGN
	: EXP_L ASSIGN EXP_R SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_ASSIGN, 4);}
	;

STATEMENT_STRUCT_DEF
	: STRUCT ID BEGIN STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF END SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_STRUCT_DEF, 7);}
	;

MORE_STRUCT_MEMBER_DEF
	: STRUCT_MEMBER_DEF MORE_STRUCT_MEMBER_DEF {wl.addNonTerminalNode(SymbolKind.S_MORE_STRUCT_MEMBER_DEF, 2);}
	| {wl.addNonTerminalNode(SymbolKind.S_MORE_STRUCT_MEMBER_DEF, 0);}
	;

STRUCT_MEMBER_DEF
	: VAR_DEF_TYPE DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_STRUCT_MEMBER_DEF, 4);}
	;

DECLARE_MORE_NON_INITIALIZE
	: COMMA DECLARE_NON_INITIALIZE DECLARE_MORE_NON_INITIALIZE {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE_NON_INITIALIZE, 3);}
	| {wl.addNonTerminalNode(SymbolKind.S_DECLARE_MORE_NON_INITIALIZE, 0);}
	;

STATEMENT_RETURN
	: RETURN EXP_R SEMICOLON {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_RETURN, 3);}
	;

FUNC_CALL
	: ID ROUND_LEFT EXP_R SEND_FUNC_ARGS ROUND_RIGHT {wl.addNonTerminalNode(SymbolKind.S_FUNC_CALL, 5);}
	| ID ROUND_LEFT ROUND_RIGHT {wl.addNonTerminalNode(SymbolKind.S_FUNC_CALL, 3);}
	;

SEND_FUNC_ARGS
	: COMMA EXP_R SEND_FUNC_ARGS {wl.addNonTerminalNode(SymbolKind.S_SEND_FUNC_ARGS, 3);}
	| {wl.addNonTerminalNode(SymbolKind.S_SEND_FUNC_ARGS, 0);}
	;

STATEMENT_FUNC_DEF
	: FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT ROUND_RIGHT STATEMENTS_BLOCK {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_FUNC_DEF, 6);}
	| FUNCTION FUNC_DEF_TYPE ID ROUND_LEFT SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS ROUND_RIGHT STATEMENTS_BLOCK {wl.addNonTerminalNode(SymbolKind.S_STATEMENT_FUNC_DEF, 8);}
	;

RECV_FUNC_ARGS
	: COMMA SINGLE_RECV_FUNC_ARG RECV_FUNC_ARGS {wl.addNonTerminalNode(SymbolKind.S_RECV_FUNC_ARGS, 3);}
	| {wl.addNonTerminalNode(SymbolKind.S_RECV_FUNC_ARGS, 0);}
	;

SINGLE_RECV_FUNC_ARG
	: FUNC_DEF_TYPE ID {wl.addNonTerminalNode(SymbolKind.S_SINGLE_RECV_FUNC_ARG, 2);}
	| FUNC_DEF_TYPE ID SQUARE_LEFT SQUARE_RIGHT {wl.addNonTerminalNode(SymbolKind.S_SINGLE_RECV_FUNC_ARG, 4);}
	;

DT_STRUCT
	: STRUCT ID {wl.addNonTerminalNode(SymbolKind.S_DT_STRUCT, 2);}
	;

DT_POINTER
	: VAR_DEF_TYPE STAR {wl.addNonTerminalNode(SymbolKind.S_DT_POINTER, 2);}
	;

VAR_DEF_TYPE
	: DT_INTEGER {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);}
        | DT_FLOAT {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);}
        | DT_BOOLEAN {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);}
	| DT_STRUCT {wl.addNonTerminalNode(SymbolKind.S_VAR_DEF_TYPE, 1);}
	;

FUNC_DEF_TYPE
	: DT_INTEGER {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);}
	| DT_FLOAT {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);}
	| DT_BOOLEAN {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);}
	| DT_POINTER {wl.addNonTerminalNode(SymbolKind.S_FUNC_DEF_TYPE, 1);}
	;


%%
