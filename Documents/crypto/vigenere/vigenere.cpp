#include <iostream>
#include <string>

using namespace std;

int main (void){
	char tab[26][26];
	char tabref[26]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	for(int i=0;i<26;i++){
		cout<<tabref[i];
	}
	char st = 'A'+1;
	cout<<endl<<int(st)<<endl;
	
	for(int i=0;i<26;i++){
		for(int y=0;y<26;y++){
			tab[i][y]=tabref[y]+i;
		}
	}
	
	for(int i=0;i<26;i++){
		for(int y=0;y<26;y++){
			cout<<tab[i][y];
		}
		cout<<endl;
	}
	
	return 0;
}
