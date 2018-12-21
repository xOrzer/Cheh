import pandas
import sys
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import confusion_matrix

dataframe = pandas.read_csv('iris.csv')

a = dataframe.shape
b = dataframe.info(sys.stdout)
c = dataframe.describe()
d = dataframe.head()

#print ("Dimension : {}".format(a))
#print ("info : {}".format(b))
#print ("describe : {}".format(c))
#print ("head : {}".format(d))

del dataframe['Id']
train, test = train_test_split(dataframe)

ytrain = train['Species']
del train['Species']

ytest = test['Species']
del test['Species']

#print("ytrain : {}".format(ytrain))
#print("train : {}".format(train))

#print("ytest : {}".format(ytest))
#print("test : {}".format(test))

#print(test)

model = KNeighborsClassifier(5)

model.fit(train, ytrain) 	
##### NE JAMAIS FIT SUR TEST #####

print("===================")

s = model.score(train, ytrain)
s2 = model.score(test, ytest)
ypred = model.predict(test)

print("score train: %.2f" % (s))
print("score test: %.2f" % (s2))

print(confusion_matrix(ytest, ypred))

    
