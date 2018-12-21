#include "knapsack.hpp"
#include <iostream>
using namespace std;

Knapsack::Knapsack(string fileName){
		
	ifstream myfile (fileName);
	if(myfile){
		
		myfile >> nbObjets;

		tblBeta.resize(nbObjets);
		weights.resize(nbObjets);
		profits.resize(nbObjets);

		for(int i = 0; i<nbObjets; i++){
			myfile >> profits[i];
		}
		
		for(int i = 0; i<nbObjets; i++){
			myfile >> weights[i];
		}
		
		myfile >> capacity;
		
		calculBeta();
	}
}

float Knapsack::profitsTotal(Solution & s){
	float total = 0;
	for(int i=0; i<nbObjets; i++){
		total += profits[i]*s.x[i];
	}
	return total;
}

float Knapsack::weightsTotal(Solution & s){
	float total = 0;
	for(int i=0; i<nbObjets; i++){
		total += weights[i]*s.x[i];
	}
	return total;
}


void Knapsack::calculBeta(){
	beta = -1;
	double tblBeta;
	for(int i=0; i<nbObjets; i++){
		tblBeta = (double) profits[i] / (double) weights[i];
		if(tblBeta > beta){
			beta = tblBeta;
		}
	}
}


void Knapsack::eval(Solution & s){
	float pt = profitsTotal(s);
	float wt = weightsTotal(s);
	
	if(wt < capacity){
		s.fx = pt;
	} else {
		s.fx = pt - beta * (wt - capacity);
	}
		
}

