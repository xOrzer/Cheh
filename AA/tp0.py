#!/usr/bin/python3

import statistics
import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression


X = np.array([[6], [8], [10], [14], [18]])
y = [7, 9, 13, 17.5, 18]

plot_x=np.arange(0,25,0.1).reshape(-1,1)


regr = LinearRegression()
regr.fit(X,y)
plt.plot(plot_x,regr.predict(plot_x))

plt.plot(X,y,".")
plt.ylabel('prix')
plt.xlabel('taille')

plt.show()

a = 0.0
var = np.var(X, ddof=1)
co = np.cov(X.transpose(), y)[0][1]
alpha = co/var
moyx = 0.0
moyy = statistics.mean(y)


for i in range(len(X)):
	a += (y[i]-regr.predict(X[i]))*(y[i]-regr.predict(X[i]))
	
for i in range(len(X)):
	moyx += X[i]

moyx /= len(X)

beta = moyy - alpha*moyx

Xtest = np.array([[8], [9], [11], [16], [12]])
ytest = [11, 8.5, 15, 18, 11]

sc = regr.score(Xtest,ytest)
ss = 0.0
moypred = 0.0

for i in range(len(X)):
	moypred += regr.predict(X[i])
	
moypred /= len(X)

for i in range(len(X)):
	ss += (regr.predict(X[i])-moypred)*(regr.predict(X[i])-moypred)

Rsquared = 1 - a/ss


print ("a : {}".format(a))
print ("Varriance : {}".format(var))
print ("Covariance : {}".format(co))
print ("Alpha : {}".format(alpha))
print ("Moyenne de x : {}".format(moyx))
print ("Moyenne de y : {}".format(moyy))
print ("Beta : {}".format(beta))
print ("SStot : {}".format(ss))
print ("Rsquared = {}".format(Rsquared))
	
print("sc: %f" % sc)
