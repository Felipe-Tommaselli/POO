from data import *


turmas = data.getTurmaList()
nusp, nomes = data.getTurmaInfo()
grupos = data.getGruposList()

# print('\033[31m' +'\nturma 1:' + '\033[0;0m')
# print(turmas[0][:5])

# print('\033[31m' +'\nturma 2:' + '\033[0;0m')
# print(turmas[1][:5])

print('\033[31m' +'\nnusp 1:' + '\033[0;0m')
print(nusp[0])

print('\033[31m' +'\nnome 1:' + '\033[0;0m')
print(nomes[0])

print('\033[31m' +'\nGRUPOS:' + '\033[0;0m')
print(grupos)
for grupo in grupos:
    print('\033[32m' + f'\ngrupo {grupos.index(grupo)}:' + '\033[0;0m')
    print(grupo)