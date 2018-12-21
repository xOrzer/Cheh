#include <iostream>
#include <stdlib.h>

#include <solution.h>
#include <eval.h>
#include <search.h>

using namespace std;

/**
 *  Main function
 */
int main(int argc, char **argv) {
  if (argc == 6) {
    // maximum number of evaluation
    int maxEval = atoi(argv[3]);

    // maximum fitness to reach
    double maxFit = atof(argv[4]);

    // initialization of the random numbers sequence
    srandom(atoi(argv[5]));
    
    // Evaluation function (oneMax)
    //OneMax eval(n);
    Knapsack eval(argv[2]);

    // different possible search heuristics
    Search * search;

    int selectSearch = atoi(argv[1]);

    switch (selectSearch) {
    // random search
    case 0: 
      search = new RandomSearch(eval, maxEval);
      break;
    // random walk
    case 1: 
      search = new RandomWalk(eval, maxEval);
      break;
    // hill-climbing
    case 2: 
      search = new HillClimbing(eval, maxEval, maxFit);
      break;
    // first improvement
    case 3: 
      search = new FirstImprovement(eval, maxEval, maxFit);
      break;
    // first improvement without replacement
    case 4: 
      search = new FirstImprovementWithoutReplacement(eval, maxEval, maxFit);
      break;
    }

    // perform the search
    (*search)();

    if (selectSearch == 1) {
      // print the random walk
      ((RandomWalk*) search)->print();
    } else {
      // print the number of evaluations
      cout << search->nbEval() << " " << search->info() << " " << search->solution().fitness() << std::endl;
      // print the final solution 
      //search->solution().print();
    }

  } else {
    cout << "5 arguments attendus : " << endl;
    cout << "premier argument: (0) random search, (1) random walk, (2) hill-climbing, (3) first-improvement, (4) first-improvement without replacement." << endl;
    cout << "Puis: nom du fichier de l'instance, nombre d'évaluation, maximum fitness et la graine du générateur de nombres pseudo-aléatoires" << endl;
  }
  
}
