%%

%unicode
%line
%class EnleveCommentaires

%%

"//".*  { ; }
\n    { return new Yytoken("\n"); }
.+      { return new Yytoken(yytext()); }
