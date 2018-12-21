#ifndef SOLUTION_HPP_
#define SOLUTION_HPP_
#include <vector>
#include <string>

using namespace std;

class Solution {
	public:
	
	Solution(vector <int> & v);
	Solution(unsigned n);
	
	void print();
	
	// vecteur de boolean
	vector <int> x;
	// perforamnce (fitness)
	double fx;
};
#endif
