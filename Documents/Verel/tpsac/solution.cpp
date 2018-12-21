#include "solution.hpp"
#include <iostream>

Solution::Solution(vector<int> & v){
	x  = v;
	fx = 0;
}

Solution::Solution(unsigned n){
	x.resize(n);
	fx = 0;
}

void Solution::print() {
	std::cout << fx << " " ; 
	for(unsigned i = 0; i < x.size(); i++) 
	  std::cout << x[i] ; 
	std::cout << std::endl;
}
