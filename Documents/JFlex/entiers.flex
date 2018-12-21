
%%

%unicode
%standalone
%line

%{
 int compteurInt=0; 
 int compteurReel=0; 
%}
 
%eof{
	System.out.println("Nombre d'entiers : " + compteurInt + "\nNombre de réels : " + compteurReel);
%eof}

%%

[0-9]+						{ compteurInt++; }
([0-9]+)?"."[0-9]+			{ compteurReel++; }
[ \t]						{ ; }
.							{ ; }
