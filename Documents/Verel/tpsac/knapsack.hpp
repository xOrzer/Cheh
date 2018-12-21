#ifndef KNAPSACK_HPP_
#define KNASACK_HPP_
#include <vector>
#include <fstream>
#include <string>
#include "solution.hpp"

using namespace std;

class Knapsack{
	
	public :
		vector <double> tblBeta;
		vector <float> profits;
		vector <float> weights;
		double beta;
		int nbObjets;
		int capacity;	
		
		Knapsack(string fileName);
		float profitsTotal(Solution & s);
		float weightsTotal(Solution & s);
		void calculBeta();
		void eval(Solution & s);
		
			
};
#endif
