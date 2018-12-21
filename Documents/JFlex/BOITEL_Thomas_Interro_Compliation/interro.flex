
%%

%unicode
%standalone
%line

%%

DECLARATIONS				{ System.out.println (yytext() + " type-> DECLARATIONS "); }
CODE						{ System.out.println (yytext() + " type-> CODE "); }
double						{ System.out.println (yytext() + " type-> double "); }
int							{ System.out.println (yytext() + " type-> int "); }
([a-z]+)?[A-Z]*[a-z]+[0-9]*	{ System.out.println (yytext() + " type-> indentificateur "); }
"="							{ System.out.println (yytext() + " type-> AFFECT "); }
([0-9]+)?"."[0-9]+			{ System.out.println (yytext() + " type-> REEL "); }
[0-9]+						{ System.out.println (yytext() + " type-> ENTIER "); }
";" 						{ System.out.println (yytext() + " type-> PTVIRG "); }
"(" 						{ System.out.println (yytext() + " type-> PARG "); }
")" 						{ System.out.println (yytext() + " type-> PARD "); }
"-" 						{ System.out.println (yytext() + " type-> MOINS "); }
"+" 						{ System.out.println (yytext() + " type-> PLUS "); }
"*" 						{ System.out.println (yytext() + " type-> MULT "); }
/* piste de recherche pour les chaines : "(.)[a-z]+"	{ System.out.println (yytext() + " type-> CHAINE "); } */
/* piste de recherche pour les instructions : s([a-z]+)?[A-Z]*[a-z]+		{ System.out.println (yytext() + " type-> instruction "); } */
[ \t]						{ ; }
.							{ ; }
"//".*  					{ ; }

