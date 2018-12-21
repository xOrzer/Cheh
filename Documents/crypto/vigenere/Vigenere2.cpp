#include <iostream>
#include <string>
#include <fstream>

using namespace std;

string cryptage(string texte, string cle){

    char tab[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    string msg = "";
    int index = 0;
    int add = 0;
    int h = 0;

    for (int i=0; i<texte.length(); i++){
        for (int j=0; j<26; j++){
            if(tab[j]==texte[i]){
                index = j;
                add = 0;
                
                if(tab[index]==cle[h])
                {
                    msg+='A';
                }else{
                    while(tab[index]!=cle[h]){
                        index++;
                        add++;

                        if(index==26){
                            index=0;
                        }
                        if(tab[index]==cle[h]){
                            msg+=tab[add];
                        }
                    }//end while
                }
            }//end if
        }//end for j

        h++;
        if(h == cle.length()){
            h=0;
        }

    }//end for i

    return msg;
}



int main (void){

    string texte = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    string cle = "MINH";
    
    
    
    ofstream fichier("test.txt", ios::out | ios::trunc);  // ouverture en écriture avec effacement du fichier ouvert


	if(fichier)
        {
                
                fichier <<"Message crypte: "<<cryptage(texte,cle)<<endl;
 
                fichier.close();
        }
        else{
                cerr << "Impossible d'ouvrir le fichier !" << endl;
			}




    cout<<"Message crypte: "<<cryptage(texte,cle)<<endl;
    cout<<"Message decrypte: "<<cryptage(cryptage(texte,cle),cle)<<endl;

    return 0;
}
