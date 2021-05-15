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
