import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Commentaire {
	
	public static void main(String [] args) throws IOException {
		System.out.println(args[0]);
		
		// créer un analyseur Analyseur qui va prendre ses entrées dans le fichier de nom arg[0]
		Analyseur yy = null;
		yy = new Analyseur( new FileReader(args[0]));
		Yytoken token;
		
		// la fin de fichier est codée par le token null
		while((token = yy.yylex()) != null)
		 System.out.print(token);
	}
}
