%%

%unicode
%line
%standalone

%class Analyseur

%%

"//".*              { ; }
DECLARATIONS        { return new Yytoken(yytext() + " type-> " + yytext()); }
CODE                { return new Yytoken(yytext() + " type-> " + yytext()); }
double              { return new Yytoken(yytext() + " type-> " + yytext()); }
int                 { return new Yytoken(yytext() + " type-> " + yytext()); }
[a-z]+              { return new Yytoken(yytext() + " type-> identificateur"); }
"="                 { return new Yytoken(yytext() + " type-> AFFECT "); }
"("                 { return new Yytoken(yytext() + " type-> PARG "); }
")"                 { return new Yytoken(yytext() + " type-> PARD "); }
"+"                 { return new Yytoken(yytext() + " type-> PLUS "); }
"-"                 { return new Yytoken(yytext() + " type-> MOINS "); }
([0-9]+)?"."[0-9]+	{ return new Yytoken(yytext() + " type-> REEL "); }
[0-9]+	            { return new Yytoken(yytext() + " type-> ENTIER "); }
";"                 { return new Yytoken(yytext() + " type-> PTVIRG "); }
\n                  { return new Yytoken("\n"); }
.+                  { return new Yytoken(yytext()); }
