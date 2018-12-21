#!/usr/bin/python3

import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.linear_model import Ridge
from sklearn.preprocessing import PolynomialFeatures
from sklearn.pipeline import make_pipeline

def nb_rand (nb):
	x=np.random.uniform(-3,10,nb)
	x=np.sort(x)
	return x

def f (x): 
	y = 10 * np.sin(x)/x + np.random.normal(0,1,15)
	#bruit = np.random.normal(0,1,15)

	return (y)
	
def polyReg(deg):
	return make_pipeline(PolynomialFeatures(deg),Ridge())
	


np.random.seed(1337)
x = nb_rand(15)
x_plot = np.linspace(-3,10,100).reshape(-1,1)

y = f(x)
x =x.reshape(-1,1)


print(y)
plt.plot(x,y, color='black', marker='o',linestyle='none',markersize=2)
plt.xlabel('x')

plt.ylabel('f(x) = 10 * sin(x)/x + gaussian')
plt.axis([-4, 12, -5, 15])
plt.grid(True)


model = polyReg(1)
model.fit(x,y)
y_pred = model.predict(x)
x_plot = np.linspace(-3,10,100).reshape(-1,1)
y_plot = model.predict(x_plot)
print(np.mean((y-y_pred)**2))
plt.plot(x_plot,y_plot,color="green")

model = polyReg(3)
model.fit(x,y)
y_pred = model.predict(x)
x_plot = np.linspace(-3,10,100).reshape(-1,1)
y_plot = model.predict(x_plot)
print(np.mean((y-y_pred)**2))
plt.plot(x_plot,y_plot,color="red")

model = polyReg(6)
model.fit(x,y)
y_pred = model.predict(x)
x_plot = np.linspace(-3,10,100).reshape(-1,1)
y_plot = model.predict(x_plot)
print(np.mean((y-y_pred)**2))
plt.plot(x_plot,y_plot,color="blue")

model = polyReg(9)
model.fit(x,y)
y_pred = model.predict(x)
x_plot = np.linspace(-3,10,100).reshape(-1,1)
y_plot = model.predict(x_plot)
print(np.mean((y-y_pred)**2))
plt.plot(x_plot,y_plot,color="yellow")

model = polyReg(12)
model.fit(x,y)
y_pred = model.predict(x)
x_plot = np.linspace(-3,10,100).reshape(-1,1)
y_plot = model.predict(x_plot)
print(np.mean((y-y_pred)**2))
plt.plot(x_plot,y_plot,color="brown")

				
plt.show()











