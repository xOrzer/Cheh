
%%

%unicode
%standalone
%line

%%

DECLARATIONS				{ return new Yytoken(yytext() + " type-> " + yytext()); }

[ \t]						{ ; }
.							{ ; }
"//".*  					{ ; }

