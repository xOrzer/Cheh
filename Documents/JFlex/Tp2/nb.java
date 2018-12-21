import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Nombre {
	
	public static void main(String [] args) throws IOException {
		System.out.println(args[0]);
		
		// créer un analyseur EnleveNombreMaj qui va prendre ses entrées dans le fichier de nom arg[0]
		EnleveNombreMaj yy = null;
		yy = new EnleveNombreMaj( new FileReader(args[0]));
		Yytoken token;
		
		// la fin de fichier est codée par le token null
		while((token = yy.yylex()) != null)
		 System.out.print(token);
	}
}
