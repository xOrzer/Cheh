#!/bin/bash

# file name of the knapsack instance
fileName=ks_1000.dat

# number of evaluation
nbEval=1000000

# maximum fitness
maxFitList="28000 30000 32000 34000 36000 38000 40000"

# nombre d'exécutions
nbRun=100

# Hill-Climbing
echo hill-climbing best improvement
echo nbevalmax fitmax nbeval nbstep fitness > bi.csv
for maxFit in ${maxFitList}
do
    echo $maxFit
    for((i=0; i < ${nbRun};i++))
    do
	echo -n $i' '
	echo -n ${nbEval} ${maxFit}' ' >> bi.csv
	java -cp bin Main 2 ${fileName} ${nbEval} ${maxFit} ${i} >> bi.csv
    done
    echo
done
echo 

# first improvement
echo hill-climbing first improvement
echo nbevalmax fitmax nbeval nbstep fitness > fi.csv
for maxFit in ${maxFitList}
do
    echo $maxFit
    for((i=0; i < ${nbRun};i++))
    do
	echo -n $i' '
	echo -n ${nbEval} ${maxFit}' ' >> fi.csv
	java -cp bin Main 3 ${fileName} ${nbEval} ${maxFit} ${i} >> fi.csv
    done
    echo
done
echo 

# first improvement without replacement
echo hill-climbing first improvement without replacement
echo nbevalmax fitmax nbeval nbstep fitness > fiwr.csv
for maxFit in ${maxFitList}
do
    echo $maxFit
    for((i=0; i < ${nbRun};i++))
    do
	echo -n $i' '
	echo -n ${nbEval} ${maxFit}' ' >> fiwr.csv
	java -cp bin Main 4 ${fileName} ${nbEval} ${maxFit} ${i} >> fiwr.csv
    done
    echo
done
echo 


# Etude du paysage de fitness:
#   Run jusqu'a l'optimum local
nbEval=10000000 
maxFit=70000

# best improvement
echo hill-climbing best improvement until local optimum
echo nbevalmax fitmax nbeval nbstep fitness > bi-full.csv
for((i=0; i < ${nbRun};i++))
do
    echo -n $i' '
    echo -n ${nbEval} ${maxFit}' ' >> bi-full.csv
    java -cp bin Main 2 ${fileName} ${nbEval} ${maxFit} ${i} >> bi-full.csv
done
echo

# first improvement without replacement
echo hill-climbing first improvement without replacement until local optimum
echo nbevalmax fitmax nbeval nbstep fitness > fiwr-full.csv
for((i=0; i < ${nbRun};i++))
do
    echo -n $i' '
    echo -n ${nbEval} ${maxFit}' ' >> fiwr-full.csv
    java -cp bin Main 4 ${fileName} ${nbEval} ${maxFit} ${i} >> fiwr-full.csv
done
echo

