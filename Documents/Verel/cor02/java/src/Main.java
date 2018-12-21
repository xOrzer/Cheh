/**
 * 
 */
import java.io.*;
import java.util.Random;



/**
 * @author verel
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException {
	if (args.length == 5) {
	    String instanceFileName = args[1];

	    // maximum number of evaluation
	    int maxEval = Integer.parseInt(args[2]);

	    // maximum fitness to reach
	    double maxFit = Integer.parseInt(args[3]);

	    // initialization of the random numbers sequence
	    Random random = new Random(Integer.parseInt(args[4]));
    
	    // Evaluation function (oneMax)
	    //OneMax eval = new OneMax(n);
	    KnapsackEval eval = new KnapsackEval(instanceFileName);

	    // different possible search heuristics
	    Search search = null;

	    int selectSearch = Integer.parseInt(args[0]);

	    switch (selectSearch) {
		// random search
	    case 0: 
		search = new RandomSearch(random, eval, maxEval);
		break;
		// random walk
	    case 1: 
		search = new RandomWalk(random, eval, maxEval);
		break;
		// hill-climbing
	    case 2: 
		search = new HillClimbingBest(random, eval, maxEval, maxFit);
		break;
		// first improvement
	    case 3: 
		search = new HillClimbingFirstImprovement(random, eval, maxEval, maxFit);
		break;
		// first improvement without replacement
	    case 4: 
		search = new HillClimbingFirstImprovementWithoutReplacement(random, eval, maxEval, maxFit);
		break;
	    }

	    // perform the search
	    search.run();

	    if (selectSearch == 1) {
		// print the random walk
		System.out.print(search);
	    } else {
		// print the number of evaluations
		System.out.println(search.nbEval() + " " + search.info() + " " + search.solution().fitness());
	    }

	} else {
	    System.out.println("4 arguments attendus : ");
	    System.out.println("premier argument: (0) random search, (1) random walk, (2) hill-climbing, (3) first-improvement, (4) first-improvement without replacement.");
	    System.out.println("Puis: nom du fichier d'instance du sac a dos, nombre d'évaluation maximum, fitness maximum et la graine du générateur de nombres pseudo-aléatoires");
	}
    }


}
