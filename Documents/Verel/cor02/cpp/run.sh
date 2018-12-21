#!/bin/bash

# size of the bit string
n=100

# nombre d'exécutions
nbRun=100

# Hil-Climbing
echo hill-climbing
> hc.csv
for((i=0; i < ${nbRun};i++))
do
    echo -n $i' '
    ./main 2 $n 1000000 ${i} >> hc.csv
done
echo 

# first improvement
echo first improvement
> fi.csv
for((i=0; i < ${nbRun};i++))
do
    echo -n $i' '
    ./main 3 $n 1000000 ${i} >> fi.csv
done
echo 

# first improvement without replacement
echo first improvement without replacement
> fiwr.csv
for((i=0; i < ${nbRun};i++))
do
    echo -n $i' '
    ./main 4 $n 1000000 ${i} >> fiwr.csv
done
echo 
