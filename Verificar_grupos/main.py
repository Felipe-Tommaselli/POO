from data import *

path = os.getcwd() + '\\assets\\'

for file in getfiles('\\SSC0103-2022-Definição dos grupos-4240978'):
    print(file)
turma1 = data.getTurmaList('ListadeApoioaoDocente-SSC01032022101.csv')
turma2 = data.getTurmaList('ListadeApoioaoDocente-SSC01032022102.csv')

nusp1, nomes1 = data.getTurmaInfo('ListadeApoioaoDocente-SSC01032022101.csv')

print(turma1)

print(nusp1)
print(nomes1)