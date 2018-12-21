#include <iostream>
#include <vector>
#include <cstdlib>
#include <cstdlib>
#include "knapsack.hpp"
#include "solution.hpp"

using namespace std;

/*
int eval(){
	vector <int> v;
	
	for(int i=0; i<ks.nbObjets; i++){
		int random = rand()%2;
		v.push_back(random);
		cout<<"v[i]= " << v[i]<<endl;
	}	
		
	Solution s(v);	
	float pt = ks.profitsTotal(s);
	float wt = ks.weightsTotal(s);
	
	ks.beta = ks.calculBeta(ks.tblBeta);

	if(wt<ks.capacity){
		s.fx = pt;
	}else{
		s.fx = pt - ks.beta*(wt-ks.capacity);
	}
	
	return s.fx;
}
* */

void randomSolution(Solution & s) {
	for(unsigned i = 0; i < s.x.size(); i++){
		s.x[i] = rand()%2;
		cout<<s.x[i];
	}	
	cout<<endl;
}

double randomSearch(Knapsack & ks, unsigned nbeval) {
	
	Solution s(ks.nbObjets);
	
	randomSolution(s);
	ks.eval(s);
	//s.print();
	
	double fbest = s.fx;
	
	for(unsigned i = 1; i < nbeval; i++) {
		randomSolution(s);
		ks.eval(s);
		//s.print();
		
		if (fbest < s.fx)
			fbest = s.fx;
	}
	
	return fbest;
}

double bestImprovment(Knapsack & ks){		
	Solution s(ks.nbObjets);
	Solution test(ks.nbObjets);
	double best = -1;
	unsigned iBest;
	double oldBest = best;
	
	randomSolution(s);
	ks.eval(s);
	
	cout << "init" << endl;
	s.print();
	
	do{
		oldBest = s.fx;
		
		/* inversion bit */
		best = -1;
		for(unsigned i=0; i<s.x.size(); i++){
			if(s.x[i]==0)
				s.x[i]=1;
			else
				s.x[i]=0;
//			cout<<test.x[i];
			ks.eval(s);	
			
			if(s.fx > best) {
				best = s.fx;
				iBest = i;
			}

			if(s.x[i]==0)
				s.x[i]=1;
			else
				s.x[i]=0;

		}
				
		//evaluation test
		
		if (oldBest < best) {
			if(s.x[iBest]==0)
				s.x[iBest]=1;
			else
				s.x[iBest]=0;
			s.fx = best;
		} else
			s.fx = oldBest;

		s.print();
	} while (s.fx > oldBest);
	
	return s.fx;
}

int main (int argc, char *argv[]){
	
	srand(atoi(argv[3]));
	Knapsack ks(argv[1]);
	int nbeval = atoi(argv[2]);

	//double fbest = randomSearch(ks, nbeval);
	double bestImp = bestImprovment(ks);
	
	//std::cout <<"fbest : " << fbest << endl;
	std::cout <<"bestImp : " << bestImp << endl;
	
	/*
	vector <int> result;
	int max1=0;
	int max2=0;
	int maxDes2=0;
	cout<<"var : " <<var<<endl;
	result.resize(var);
	for(int i=0;i<1;i++){
		for(int j=0;j<var;j++){
			result[j]=eval();
			if(result[j]>max1){
				max1=result[j];
			}
		}	
		
		cout<<endl<<endl<<endl;
		
		
		for(int j=0;j<var;j++){
			result[j]=eval();
			if(result[j]>max2){
				max2=result[j];
			}
		}	
		
		if(max1>max2)
			maxDes2=max1;
		else
			maxDes2=max2;
	}
	
	cout<<"Performance 1: "<<max1<<endl;
	cout<<"Performance 2: "<<max2<<endl;
	cout<<"Performance Finale: "<<maxDes2<<endl;
	
	
	*/
	return 0;	
}
