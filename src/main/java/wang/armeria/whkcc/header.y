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
			/* illegal token, report an error */
			yychar = Lexer.YYUNDEF;
			yytoken = SymbolKind.S_YYUNDEF;
			label = YYERRTOKEN;
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
		    if (yychar == YYEMPTY_)
			yytoken = null;
		    yyreportSyntaxError(new Context(yystack, yytoken));
		    label = YYABORT;
		    break;

		/*-------------------------------------------------------------.
		| yyerrtoken -- syntax error  |
		`-------------------------------------------------------------*/
		case YYERRTOKEN:
		    System.err.println("Invalid token at position " + yylpos);
		    label = YYABORT;
		    break;

		/* Accept.  */
		case YYACCEPT:
		    return true;

		/* Abort.  */
		case YYABORT:
		    return false;
	    }
    }
}
