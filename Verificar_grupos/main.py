from data import *
from verificar import *


def main():

    print('========== VERIFICAÇÃO DE GRUPOS ==========')
    verifica = verificar()
    grupos4, gruposInvalidos = verifica.gruposTurma()
    naoAlunos = verifica.grupoDeNaoAluno()
    grupo2turmas = verifica.grupoDuasTurmas()

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'ARQUIVOS COM ERRO:' + '\033[0;0m')
    print(*data.erroAbrir, sep='\n')

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'GRUPOS DA TURMA 1:' + '\033[0;0m', end='')
    for grupo in grupos4[0]:
        print(f'\nGrupo #{grupos4[0].index(grupo) + 1}:')
        for aluno in grupo:
            print(f'{aluno[0]: <12} {aluno[1]: >12}')

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'GRUPOS DA TURMA 2:' + '\033[0;0m', end='')
    for grupo in grupos4[1]:
        print(f'\nGrupo #{grupos4[1].index(grupo) + 1}:')
        for aluno in grupo:
            print(f'{aluno[0]: <12} {aluno[1]: >12}')

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'GRUPOS INVÁLIDOS:' + '\033[0;0m', end='')
    for t in [0, 1]:
        for grupo in gruposInvalidos[t]:
            print(f'\nGrupo Inválido (turma {t + 1}):')
            for aluno in grupo:
                print(f'{aluno[0]: <12} {aluno[1]: >12}')

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'Alunos nem da turma 1 nem da 2 em grupos ou que não existem:'.upper() + '\033[0;0m')
    for nA in naoAlunos:
        print('{0:10} {1:40} Grupo # {2:0}'.format(nA[0][0], nA[0][1], nA[1]))

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'grupos com alunos de 2 turmas:'.upper() + '\033[0;0m')
    for grupo in grupo2turmas:
        print(f'\nGrupo #{grupo[1]}:')
        for aluno in grupo[0]:
            print(f'{aluno[0]: <12} {aluno[1]: >12}')

    #-------------------------------------------------------------------------
    print('\n\033[32m' + 'alunos sem grupo:'.upper() + '\033[0;0m')
    for aluno in verifica.alunosSemGrupo():
        print(f'{aluno[0]: <12} {aluno[1]: >12}')

if __name__ == '__main__':
    main()