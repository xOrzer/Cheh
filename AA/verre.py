import pandas as pd
from sklearn import tree

def main():
	data = pd.read_csv("glass.csv")
	#print(data)
	#print(data['Type'])
	x_train = data
	y_train = data['Type']
	del x_train['Type']
	del x_train['Id']
	del x_train['refractive index']
	
	print(x_train)

	classifier = tree.DecisionTreeClassifier(criterion='gini')
	classifier.fit(x_train, y_train)

	tree.export_graphviz(classifier, out_file='glass.dot', feature_names=['Sodium','Magnesium','Aluminium','Silicon','Potassium','Calcium','Barium','Iron'])

if __name__ == '__main__':
	main()
