from data import *

turma1 = data.getData('ListadeApoioaoDocente-SSC01032022101.csv')
turma2 = data.getData('ListadeApoioaoDocente-SSC01032022102.csv')

nusp1, nomes1 = data.getInfo('ListadeApoioaoDocente-SSC01032022101.csv')

print(turma1)

print(nusp1)
print(nomes1)