
%%

%unicode
%standalone
%line

%{
 int compteur=0;
%}
 
%eof{
	System.out.println("résultat : );
%eof}

%%

[0-9]+						{ System.out.println("Nombre : " + yytext()); }
[ \t]						{ ; }
.							{ ; }

