public class Yytoken {
	private String description;
	private int valeur;
	
	public Yytoken(String d){
		description = d;
		valeur = 0;
	}
	
	public Yytoken(String d, int v){
		this (d);
		valeur = v;
	}
	
	public String toString(){
		return description + "(" + valeur + ")";
	}
}
