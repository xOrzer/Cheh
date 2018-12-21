/* Ledet Benoît && Boitel Thomas */

#include <iostream>
#include <string>
#include <fstream>
#include <cstring>

using namespace std;

string cryptage(string texte, string cle){

	string msg = "";
	int h=0;
	
	for (int i=0; i<texte.length(); i++){
		if(texte[i]<='Z' && texte[i]>='A'){
			msg += ((texte[i]-'A') + (cle[h]-'a'))%26 + 'A';  
			h++;
			if(h == cle.length()){
				h=0;
			}      
		}else if(texte[i]<='z' && texte[i]>='a'){
			msg += ((texte[i]-'a') + (cle[h]-'a'))%26 + 'a';   
			h++;
			if(h == cle.length()){
				h=0;
			}
		}else{
			msg += texte[i];
		}//endif		
	}//end for i

	return msg;
}

string decryptage(string code, string cle){

	string msg = "";
	int h=0;
	
	
	for (int i=0; i<code.length(); i++){
		if(code[i]<='Z' && code[i]>='A'){
			msg += ((code[i]-'A') - (cle[h]-'a')+26)%26 + 'A';   
			h++;
			if(h == cle.length()){
				h=0;
			}            
		}else if(code[i]<='z' && code[i]>='a'){
			msg += ((code[i]) - (cle[h])+26)%26 + 'a';   
			h++;
			if(h == cle.length()){
				h=0;
			}
		}else{
			msg += code[i];
		}//endif	
		
	}//end for i

	return msg;
}


int main (int argc, char *argv[]){

	string texte = "abcdEFGHIjklmnopqrsTUVwxyz";
	string code = "ID PGW RRLVET OSSQIV FIIPQAZX FQUHP EGO XKG MYZCDB HLUTHEBL LJ SGNDOXDSEQKA Swrw Kypdeh 4:04-YU-02688 LXQPA J. AESRJMONEH, as si., Tocidphxcw yu. DERDJ XVHC SSDNGI HLUTHEBL ASYGR QNDS PGKQOB ZHKQVLET RKZJA SI FIHABLLVV, Fevamvxrwu AVPDJKSRP SUORALR";
	string cle = "aqwzsxedc";
	ofstream fichierChiffre("testChiffre.txt", ios::out | ios::trunc);  // ouverture en écriture avec effacement du fichier ouvert
	ofstream fichierClair("testClair.txt", ios::out | ios::trunc);  // ouverture en écriture avec effacement du fichier ouvert

	
	if(strcmp(argv[1],"-c")==0){
		if(fichierChiffre){
				fichierChiffre <<"Message crypté: "<<cryptage(texte,cle)<<endl;
				fichierChiffre.close();
					cout<<"Message crypte: "<<cryptage(texte,cle)<<endl;

		}else{
			cerr << "Impossible d'ouvrir le fichier !" << endl;
		}
	}else if(strcmp(argv[1],"-d")==0){	
		if(fichierClair){
			fichierClair <<"Message décrypté: "<<decryptage(code,cle)<<endl;
			fichierClair.close();
				cout<<"Message decrypte: "<<decryptage(code,cle)<<endl;

		}
		else{
			cerr << "Impossible d'ouvrir le fichier !" << endl;
		}
	}
	
	/*
		Clé texte 1: aqwzsxedc 
		Clé texte 2: encore inconnue
	*/

	return 0;
}

