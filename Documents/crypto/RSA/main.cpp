#include <iostream>
#include <tuple>
#include <cmath>
#include <array>
#include <fstream>
#include <vector>
using namespace std;


int modpow(int base, int exp, int m) {

   int result = 1;

   while (exp > 0) {
      if ((exp & 1) > 0) result = (result * base) % m;
      exp >>= 1;
      base = (base * base) % m;
   }

   return result;
}

tuple<int, int, int> euclide(int a, int b) {
// r = PGCD(a, b) et r = au + bv
    int r = a;
    int u = 1;
    int v = 0;
    int rp = b; int up = 0; int vp = 1;
    int q, rs, us, vs;

        while (rp != 0) {
            q = r / rp;
            rs = r; us = u; vs = v;
            r = rp; u = up; v = vp;
            rp = rs - q * rp; up = us - q * up; vp = vs - q * vp;
        }

    return make_tuple(r, u, v);
}

bool estPremierAvec(int a, int b){
    int x,y;
    auto c = euclide(a,b);

    x = get<1>(c);
    y = get<2>(c);

    return (a*x+b*y == 1);
}

bool estPremier(int a){

    long nombre = a;
    long premier = 0;

    if ( nombre % 2 == 0 )
    {
        premier = 3;
    }
    else{
        for (int i = 3; i <= sqrt(nombre); i+=2){
            if (nombre % i == 0){
                premier = i;
            }
        }
    }

    if (nombre == 2)
    {
        premier = 0;
    }
    if (nombre == 1)
    {
        premier = 1;
    }
    if ( premier == 0)
    {
        return true;
    }
    else
    {
        return false;
    }
}

tuple <int, int, int> generationCle(int p, int q, int e){
    int n = p*q;
    int phi = (p-1)*(q-1);
    tuple<int, int, int> tup = euclide(e,phi); 
	int d=get<1>(tup);
	if(d<=2){
		d += phi;
	}
	cout<<"privée : " << n << " "<<  e << "	clé public : " << n << " "<< d <<endl;
    return make_tuple(n,e,d);
}

vector<int> chiffrement (vector<int> s, tuple<int,int,int>t){
    vector<int>str;
    int e = get<1>(t);
    int n = get<0>(t);
    int c;

    for (int i=0; i<s.size(); i++){
            c=s[i];
        if(s[i]==0){
            str.push_back(0);
        }else{
            str.push_back(modpow(c,e,n));
        }
    }
	
    return str;
}

vector<int> dechiffrement (vector <int> s, tuple<int,int,int>t){
    vector<int>str;
    int e = get<2>(t);
    int n = get<0>(t);

    for (int i=0; i<s.size(); i++){    
        if(s[i]==0){
            str.push_back(0);
        }else{
            str.push_back(modpow(s[i],e,n));
        }
    }
    
    return str;
}


int main (void){
    tuple <int, int, int> t = generationCle(7,13,19);
    vector<int> s = {61, 62, 62, 63};
    vector<int>tab = chiffrement(s, t);
    vector<int>tab2 = dechiffrement(tab, t);

	cout<<"message chiffre : ";
	for(int i=0; i<tab.size(); i++){
		cout<<tab[i]<<"  ";
	}
			cout<<endl;

	cout<<"message dechiffre : ";
	for(int i=0; i<tab2.size(); i++){
		cout<<tab2[i]<<"  ";
	}

    return 0;
}
