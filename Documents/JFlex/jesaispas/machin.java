import java.io.*;

public class Main {


	public static void main(String [] argv) {
		Yytoken token;
		
		if (argv.length == 0) {
			System.out.println("Usage : java Expressions <inputfile>");
		}
		
		else {
			/* 1 - Scanner declaration */
			Expressions scanner = null;
		
			try {
				scanner = new Expressions( new
				java.io.FileReader(argv[0]) );
				token = scanner.yylex();
				
				while ( token != null ){
					System.out.println(token) ;
					token = scanner.yylex();
				}
			}

			catch (java.io.FileNotFoundException e) {

				System.out.println("File not found : \"" + argv[0] + "\"");
			}
			catch (java.io.IOException e) {
				System.out.println("IO error scanning file \"" + argv[0] + "\"");
				System.out.println(e);}
			catch (Exception e) {
				System.out.println("Unexpected exception:");
				e.printStackTrace();
			}
		}
	}
}
