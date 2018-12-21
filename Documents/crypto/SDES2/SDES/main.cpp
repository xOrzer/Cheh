#include <iostream>
#include <string>
#include <cmath>
#include <fstream>
#include <sstream>

using namespace std;

int S0[4][4] = {S0[0][0]=1,S0[0][1]=0,S0[0][2]=3,S0[0][3]=2,S0[1][0]=3,S0[1][1]=2,S0[1][2]=1,S0[1][3]=0,S0[2][0]=0,S0[2][1]=2,S0[2][2]=1,S0[2][3]=3,S0[3][0]=3,S0[3][1]=1,S0[3][2]=3,S0[3][3]=2};
int S1[4][4] = {S1[0][0]=0,S1[0][1]=1,S1[0][2]=2,S1[0][3]=3,S1[1][0]=2,S1[1][1]=0,S1[1][2]=1,S1[1][3]=3,S1[2][0]=3,S1[2][1]=0,S1[2][2]=1,S1[2][3]=0,S1[3][0]=2,S1[3][1]=1,S1[3][2]=0,S1[3][3]=3};

string XOR (string s1, string s2){
    string st = "";
    for(int i=0; i<(int)s1.length() ;i++){
        if(s1[i]==s2[i]){
            st+="0";
        }else{
            st+="1";
        }
    }
    return st;
}

string IP (string st){
    string stm = {st[1],st[5],st[2],st[0],st[3],st[7],st[4],st[6]};

    return stm;
}

string IPinv (string st){
    string stm = {st[3],st[0],st[2],st[4],st[6],st[1],st[7],st[5]};

    return stm;
}

string EP (string st){
    string stm = {st[3],st[0],st[1],st[2],st[1],st[2],st[3],st[0]};

    return stm;
}

string SX(string st, int s[4][4]){
    string str1 = {st[0],st[3]};
    string str2 = {st[1],st[2]};
    string r="";
    int ligne = (((int)str1[0]-48)*pow(2,1)) + (((int)str1[1]-48)*pow(2,0));
    int colonne = (((int)str2[0]-48)*pow(2,1)) + (((int)str2[1]-48)*pow(2,0));

    int result = s[ligne][colonne];

    if(result == 0){
        r = "00";
    }else if(result == 1){
        r = "01";
    }else if(result == 2){
        r = "10";
    }else if(result == 3){
        r = "11";
    }

    return r;
}

string P4 (string st){
    string stm = {st[1],st[3],st[2],st[0]};

    return stm;
}

/*-------------- FONCTION POUR LES CLES --------------*/


string P10 (string st){
    string stm = {st[2],st[4],st[1],st[6],st[3],st[9],st[0],st[8],st[7],st[5]};

    return stm;
}

string LS1 (string st){
    string stm = st;
    char tmp = st[0];

    for(int i=1; i<(int)st.length(); i++){
        stm[i-1] = st[i];
    }

    stm[stm.length()-1]=tmp;

    return stm;
}

string LS2 (string st){
    string stm = st;
    stm=LS1(LS1(st));
    return stm;
}

string P8 (string st){
    string stm = {st[5],st[2],st[6],st[3],st[7],st[4],st[9],st[8]};

    return stm;
}

/*---------------- K1 -------------------*/

string K1 (string st){
    string k1 = P10(st);
    string sk1="";
    string sk2="";


    for(int i=0; i<(int)st.length()/2; i++){
        sk1+=k1[i];
    }

    for(int i=st.length()/2; i<(int)st.length(); i++){
        sk2+=k1[i];
    }

    sk1=LS1(sk1);
    sk2=LS1(sk2);

    k1 = sk1 + sk2;

    k1=P8(k1);

    return k1;
}

/*---------------- K2 -------------------*/

string K2 (string st){
    string k2 = P10(st);
    string sk1="";
    string sk2="";

    for(int i=0; i<(int)st.length()/2; i++){
        sk1+=k2[i];
    }

    for(int i=st.length()/2; i<(int)st.length(); i++){
        sk2+=k2[i];
    }

    sk1=LS1(sk1);
    sk2=LS1(sk2);

    sk1=LS2(sk1);
    sk2=LS2(sk2);

    k2 = sk1 + sk2;

    k2=P8(k2);

    return k2;
}

/*---------------- F -------------------*/
string F (string st, string cle){

    string st1 = "";
    string st2 = "";
    string stm = "";

    stm=EP(st);
    stm=XOR(stm,cle);

    /* Split */
    for(int i=0; i<(int)stm.length()/2; i++){
        st1+=stm[i];
    }

    for(int i=st.length()/2; i<(int)stm.length(); i++){
        st2+=stm[i];
    }

    st1=SX(st1,S0);
    st2=SX(st2,S1);

    /* Assemble */

    stm = st1 + st2;

    stm = P4(stm);

    return stm;
}

string fk (string st1, string st2, string cle){
    string stF = F(st2,cle);
    stF = XOR(st1,stF);
    return stF;
}

string sdes(string st, string ci){
    string cle1 = K1(ci);
    string cle2 = K2(ci);
    string st1 = "";
    string st2 = "";
    string rfk = "";
    string rfk1 = "";
    string rfk2 = "";
    string stm = IP(st);

    for(int i=0; i<(int)stm.length()/2; i++){
        st1+=stm[i];
    }

    for(int i=st.length()/2; i<(int)stm.length(); i++){
        st2+=stm[i];
    }

    rfk1 = fk(st1,st2,cle1);
    rfk2 = fk(st2,rfk1,cle2);

    rfk = rfk1 + rfk2;
    rfk = IPinv(rfk);

    return rfk;
}

string base2 (int a){
    string r="00000000";
    int nombre = a; // ce nombre sera detruit par le traitement
    for(int i = 7; i >= 0; i--) // long int : 32 bits
    {
        if((nombre & 1) == 1){
            r[i]='1';
        }else{
            r[i]='0';
        }
        nombre >>= 1; // decalage d'un bit a droite
    }
    return r;
}

int base10 (string st){
    int ascii=0;
    for(int i=7; i>=0; i--){
        ascii+=((int)st[i]-48)*pow(2,7-i);
    }
    return ascii;
}

char cryptageLettre(char a,string cle){
    int x = a;
    char r;
    string st = base2(x);
    st = sdes(st,cle);
    x = base10(st);
    r=x;

    return r;
}


int main(){
	string str;
	string r="";
	ifstream t("texte.txt");
	stringstream ss;
    ss << t.rdbuf();
    str = ss.str();
    
    for(int i=0; i<str.length(); i++){
        r+=cryptageLettre(str[i],"1011110101");
    }
    cout<<r;

    return 0;
}
