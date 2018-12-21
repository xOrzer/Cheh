%%

%unicode
%standalone

NON_DEBUT_COMMENTAIRE=[^/]|"/"[^/]

%%

{NON_DEBUT_COMMENTAIRE}* {return new Yytoken(yytext()); }
"//".* {}
