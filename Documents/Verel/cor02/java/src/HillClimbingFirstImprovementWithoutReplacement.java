import java.util.Random;

/**************************************************
 * Hill-climbing search
 * perform a first improvement search
 * The neighbors are visited only once (without replacement)
 *
 */
public class HillClimbingFirstImprovementWithoutReplacement extends Search 
{
    /** constructor
     *
     * @param _eval evaluation function
     * @param _maxEval maximum number of evaluation
     * @param _max maximum fitness to reach
     */
    public HillClimbingFirstImprovementWithoutReplacement(Random random, Eval eval, int maxEval, double max) {
	super(eval); 

	this.maxNbEval = maxEval;
	this.maxFitness = max; 

	this.random = random;
	randomInit = new RandomInit(random, eval.size());

	neighbors = new int[eval.size()];
	for(int i = 0; i < eval.size(); i++)
	    neighbors[i] = i;
    }

    // the search
    public void run() {
	// initialization
	solution = new Solution();

	randomInit.init(this.solution);
	this.eval.apply(this.solution);
	this.nbEval = 1;
	
	// bit to flip
	int i = 0;
	int j;

	// current fitness of the solution
	double currentFitness;
	double neighborFitness;

	this.nbStep = 0;
	boolean optimumLocal = false;

	while(!optimumLocal && nbEval < maxNbEval && solution.fitness() < maxFitness) {
	    currentFitness = solution.fitness();

	    // explore the neighborhood
	    int nbNeighbor = 0;
	    neighborFitness = currentFitness - 1;
	    while (neighborFitness < currentFitness && nbNeighbor < eval.size()) {
		// flip one bit at random
		j = random.nextInt(eval.size() - nbNeighbor);
		i = neighbors[j];
		solution.bitString[i] = ! solution.bitString[i];

		// evaluation
		eval.apply(solution);
		this.nbEval += 1;
		neighborFitness = solution.fitness();

		// flip back
		solution.bitString[i] = ! solution.bitString[i];
		solution.fitness(currentFitness);

		// don't put again the same neighbor
		nbNeighbor += 1;
		neighbors[j] = neighbors[eval.size() - nbNeighbor] ;
		neighbors[eval.size() - nbNeighbor] = i;
	    }

	    // update the current solution:
	    // accept if better (or equal)
	    if (currentFitness < neighborFitness) {
		solution.bitString[i] = ! solution.bitString[i];
		solution.fitness(neighborFitness);
		this.nbStep += 1;	      
	    } else
		optimumLocal = true;

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

    // list of neighbors
    private int [] neighbors;

}
