import java.util.Random;

/**************************************************
 * Hill-climbing search
 * perform a first improvement search
 *
 */
public class HillClimbingFirstImprovement extends Search 
{
    /** constructor
     *
     * @param _eval evaluation function
     * @param _maxEval maximum number of evaluation
     * @param _max maximum fitness to reach
     */
    public HillClimbingFirstImprovement(Random random, Eval eval, int maxEval, double max) {
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
	int i = 0;

	// current fitness of the solution
	double currentFitness;

	this.nbStep = 0;

	while(nbEval < maxNbEval && solution.fitness() < maxFitness) {
	    currentFitness = solution.fitness();

	    // flip one bit at random
	    i = random.nextInt(eval.size());
	    solution.bitString[i] = ! solution.bitString[i];

	    // evaluation
	    eval.apply(solution);
	    this.nbEval += 1;

	    // update the current solution:
	    // accept if strictly better
	    if (solution.fitness() <= currentFitness) {
		// flip back to the current solution
		solution.bitString[i] = ! solution.bitString[i];
		solution.fitness(currentFitness);
	    } else 
		this.nbStep += 1;
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
