%%

%unicode
%line
%class EnleveNombreMaj
%standalone

%%

[0-9].*       { ; }
[a-z].*       { return new Yytoken("[A-Z]"); }
[ \t]		  { ; }
.			  { ; }

