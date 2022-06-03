from data import *
from verificar import *


def main():

    print('========== VERIFICAÇÃO DE GRUPOS ==========')
    verifica = verificar()

    print('\n\033[32m' + 'ARQUIVOS COM ERRO:' + '\033[0;0m')
    print(*data.erroAbrir, sep='\n')

    print('\n\033[32m' + 'GRUPOS DA TURMA 1:' + '\033[0;0m')


    print('\n\033[32m' + 'GRUPOS DA TURMA 2:' + '\033[0;0m')

    print('\n\033[32m' + 'Grupos nem da turma 1 nem da 2:'.upper() + '\033[0;0m')

    print('\n\033[32m' + 'grupos com alunos de 2 turmas ou que não existem:'.upper() + '\033[0;0m')

    print('\n\033[32m' + 'alunos sem grupo:'.upper() + '\033[0;0m')
    for aluno in verifica.alunosSemGrupo():
        print(f'{aluno[0]: <12} {aluno[1]: >12}')


def teste():

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

if __name__ == '__main__':
    main()