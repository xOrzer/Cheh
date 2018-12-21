import java.util.Random;

/**************************************************
 * Hill-climbing search
 * perform a best improvement search
 *
 */
public class HillClimbingBest extends Search 
{
    /** constructor
     *
     * @param _eval evaluation function
     * @param _maxEval maximum number of evaluation
     * @param _max maximum fitness to reach
     */
    public HillClimbingBest(Random random, Eval eval, int maxEval, double max) {
	super(eval); 

	this.maxNbEval = maxEval;
	this.maxFitness = max; 

	this.random = random;
	randomInit = new RandomInit(random, eval.size());
    }

    // the search
    public void run() {
	// initialization
	solution = new Solution();

	randomInit.init(this.solution);
	this.eval.apply(this.solution);
	this.nbEval = 1;
	
	// bit to flip
	int i;
	
	// current fitness of the solution
	double currentFitness;

	// to compute the best neighbor
	double bestNeighbor = -1;
	int iBest;

	this.nbStep = 0;
	boolean optimumLocal = false;

	while(!optimumLocal && this.nbEval < this.maxNbEval && this.solution.fitness() < this.maxFitness) {
	    // explore all the neighborhood
	    iBest = -1;
	    currentFitness = solution.fitness();
	    for(i = 0; i < eval.size(); i++) {
		// flip the bit i
		solution.bitString[i] = ! solution.bitString[i];

		// evaluation
		eval.apply(solution);
		this.nbEval += 1;

		// update the current best neighbor
		if (iBest < 0 || bestNeighbor < solution.fitness()) {
		    bestNeighbor = solution.fitness();
		    iBest = i;
		}

		// flip back
		solution.bitString[i] = ! solution.bitString[i];
		solution.fitness(currentFitness);
	    } // end of the exploration

	    // update the current solution (acceptance criterium)
	    if (solution.fitness() < bestNeighbor) {
		solution.bitString[iBest] = ! solution.bitString[iBest];
		solution.fitness(bestNeighbor);
		this.nbStep += 1;
	    } else {
		optimumLocal = true;
	    }
	}
    }

    String info() {
	return "" + nbStep ;
    }

    // number of step of HC
    private int nbStep;

    // maximum number of evaluations
    private int maxNbEval ;

    // maximum fitness to reach
    private double maxFitness;

    // random generator
    private Random random;

    // initialization method
    private RandomInit randomInit;
}

