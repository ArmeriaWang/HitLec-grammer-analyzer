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
		    /* New state.  the state is already pushed when we come here.  */
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
	| FUNC_CALL SEMICOLON {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
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
	: ID SQUARE_LEFT SQUARE_RIGHT MORE_RECV_HD_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| ID SQUARE_LEFT EXP_R SQUARE_RIGHT MORE_RECV_HD_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	;

MORE_RECV_HD_ARRAY_DIM
	: SQUARE_LEFT EXP_R SQUARE_RIGHT MORE_RECV_HD_ARRAY_DIM {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
	| {wl.addNonTerminalNode(Whkcc.SymbolKind.get(yyr1_[yyn]), yylen);}
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
