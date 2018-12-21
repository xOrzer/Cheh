Pour compiler en ligne de commande :
javac -d bin -cp bin -sourcepath src src/*.java

Pour executer :
java -cp bin Main 
donne le détail des arguments

java -cp bin Main 2 ks_1000.dat 1000 30000 12
exécute un hill-climber best improvement sur l'instance "ks_1000.dat" avec un nombre maximum d'évaluations égale à 1000, une fitness à atteindre de 30000 et une graine aléatoire de 12


run.sh lance les expériences pour comparer les performances des heuristiques.
Ensuite, les statistiques peuvent être calculée à l'aide d'un logiciel de statistiques (tableur, R, etc.) en ouvrant les fichiers csv. Voir le script traitement.R.



Queques informations sur le code :

* Solution.java décrit une solution (classe Solution)
Le champs bitString est un tableau de boolean
Le champ fitness correspond à la qualité de la solution calculée par la fonction d'évaluation

* Eval.java est une classe abstraite qui décrit une fonction d'évaluation sur les chaines binaires (classe Eval)
La méthode apply() exécute le calcul de la fonction d'évaluation pour la solution donnée
size() correspond à la longueur de la chaine de bits du problème

La classe OneMax dérive de la classe Eval et calcule le nombre de bits vrai.
La classe KnapsackEval dérive de la classe Eval et calcule la fonction d'évaluation pour le problème du sac à dos.

* Init.java est une classe abstraite qui décrit une méthode d'initialisation.
Les classes RandomInit (loi aléatoire uniforme sur {0,1}^N) et ZeroInit (0^N) dérivent de cette classe.

* Search.java est une classe abstraite qui décrit les heuristiques de recherche
Les champs de cette classe sont: la fonction d'évaluation, la solution courante, le nombre d'évaluations et le générateur de nombres pseudo-aléatoires.

Les RandomSearch, RandomWalk, HillClimbingBest, HillClimbingFirstImprovement et HillClimbingFirstImprovementWithoutReplacement dérivent de cette classe.

* Main.java contient la fonction principale qui permet d'exécuter l'une des recherches.


