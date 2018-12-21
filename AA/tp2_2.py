import pandas
import sys
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsRegressor
from sklearn.metrics import mean_absolute_error, mean_squared_error, r2_score
from sklearn.preprocessing import StandardScaler


dataframe = pandas.read_csv('cylindre.csv')

#a = dataframe.shape
#b = dataframe.info(sys.stdout)
#c = dataframe.describe()
#d = dataframe.head()

del dataframe['name']

#b = dataframe.info(sys.stdout)

#Pour la normalisation ( fit transform )
scaler = StandardScaler()

# On split la data pour faire deux tests différents
train, test = train_test_split(dataframe)

ytrain = train['mpg']
del train['mpg']

ytest = test['mpg']
del test['mpg']


# Normalisation des données
test = scaler.fit_transform(test)
train = scaler.fit_transform(train)

# Model de régression
model = KNeighborsRegressor(5)
# SQRT(Nb_Exemples) = valeur de k optimale

# Entrainement du model avec fit.
model.fit(train, ytrain)

##### NE JAMAIS FIT SUR TEST #####

print("===================")

# Calcul des scores
s = model.score(train, ytrain)
s2 = model.score(test, ytest)

# Prédiction du model
ypred = model.predict(test)

# Affichage des scores
print("score train: %.2f" % (s))
print("score test: %.2f" % (s2))

# Affichage MAE et MSE 
print("Absolute : %.2f" % (mean_absolute_error(ytest,ypred)))
print("Squared : %.2f" % (mean_squared_error(ytest,ypred)))


