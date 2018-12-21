
%%

%unicode
%standalone
%line

%%

FACTURE						{ System.out.println ("ligne " + (yyline+1) + " : FACTURE"); }
","							{ System.out.println ("ligne " + (yyline+1) + " : VIRG"); }
[A-Z][A-Z][0-9][0-9][0-9]	{ System.out.println ("ligne " + (yyline+1) + " : NO"); }
TOTAL 						{ System.out.println("ligne " + (yyline+1) + " : TOTAL"); }
[A-Z]+ 						{ System.out.println("ligne " + (yyline+1) + " : LIB"); }
[0-9]+	 					{ System.out.println("ligne " + (yyline+1) + " : NB"); }
"." 						{ System.out.println("ligne " + (yyline+1) + " : PT"); }
[ \t]						{ ; }
.							{ ; }
