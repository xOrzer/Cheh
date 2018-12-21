 #!/usr/bin/python3

from sklearn.preprocessing import PolynomialFeatures
from sklearn.linear_model import Ridge
from sklearn.pipeline import make_pipeline 
import random
import numpy as np
import matplotlib.pyplot as plt

np.random.seed(1337)


def show_polynomes(models, degrees, x, y):
   x_plot = np.linspace(-3,10,100).reshape(-1,1)
   colors = ['green','red','blue','orange','brown']
   plt.figure()
   plt.title('Plot all models')
   plt.xlabel('x')
   plt.ylabel('y')
   plt.scatter(x,y,color='black', s=50, marker='o', label='Training points')
   plt.axis([-4,12,-5,15])
   count=0
   
   for degree in degrees:
	   y_plot = models[count].predict(x_plot)
	   plt.plot(x_plot, y_plot, color=colors[count] , linewidth=2, label='degree %d' % degree)
	   count+=1
   plt.grid(True)
   plt.legend()
   plt.show()

def compute_errors(models, degrees, x, y):
	count = 0
	for model in models:
		prediction = model.predict(x)
		print('Degree %.2f : Residual Sum of squares : %.2f' % (degrees[count], np.mean((prediction - y) ** 2)))

def training(degrees, x, y):
	models = [make_pipeline(PolynomialFeatures(degree), Ridge()) for degree in degrees]
	for model in models:
		model.fit(x, y)
	return models

def main:
	np.random.seed(1337)
	x_train, y_train = generate_train_data(15)
	x_train = np.array(x_train).reshape(-1,1)
	plot(data(x_train, y_train)
	
	degrees = [1]
	models = training(degrees, x_train, y_train)
	
	show_polynomes(models, degrees, x_train, y_train)
	compute_errors(models, degrees, x_train, y_train)
	degrees = [1,3,6,9,12]
	models = training(degrees, x_train, y_train)
	show_polynomes(models, degrees,x_train, y_train)
	compute_errors(models, degrees, x_train, y_train)
	x_test, y_test = generate_train_data(50)
	y_real = f(x_test)
	x_test = np.asarray(x_test).reshape(-1,1)
	plot_data(x_test, y_test)
	show_polynomes(models, degrees, x_test, y_test)
	compute_errors(models, degrees, x_test, y_real)
	print_r_squared(models, degrees, x_test, y_real)
	print_r_squared(models, degrees, x_test, y_real)
