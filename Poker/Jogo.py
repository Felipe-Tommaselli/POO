import sys
from Cartas import *
from AbreCartas import *

'''
* Código com o intuito de criar o Jogo de cartas, ou seja, apresentar o cabeçalho,
* dar as cartas, trocar as cartas e passar o resultado para a main. Vale ressaltar
* que esse código procura tratar da melhor forma os bad inputs do usuario
* @author: 11800910
'''

# tratametno da exceção de forma mais legível, EntradaError e TrocaError
# herdam todas as exceções e criam esses novos erros, enquanto 
class EntradaError(Exception):
    pass

class TrocaError(Exception):
    pass

# puxaError apenas coloca a condiçaõ que deve levantar
# o erro, tornando o código menos poluido
def puxaError(entrada, saldo, sel):
    # seleciona o erro de entrada [0, saldo]
    if sel == 0:
        if entrada > saldo or entrada < 0:
            raise EntradaError()
    # seleciona o erro de numero de elementos para trocar [0, 3]
    elif sel == 1:
        if entrada > 5 or entrada < 0:
            raise TrocaError()
    # seleciona o erro de carta escolhida para trocar [1, 5]
    else:
        if entrada > 5 or entrada < 1:
            raise TrocaError()

class Jogo(object):

    # construtor principal
    def __init__(self, saldo) -> None:
        self.aposta = 0
        self.troca = list()
        self.saldo = saldo
        self.cartasList = list()

        # cabeçalho, pega aposta    
        print(f'Saldo atual: ${self.saldo}')
        print(f'Digite o valor da aposta ou "F" para finalizar: ', end='')
        self.EntradaTeclado()

        # abre as cartas
        jogo = AbreCartas(5)
        jogo.abrir()
        print(jogo, end='')
        print("  (1)       (2)       (3)       (4)       (5)");
        
        # permite primeira troca
        self.TrocarJogo()
        jogo.abrir(self.troca)
        print(jogo, end='')

        # permite segunda troca
        self.TrocarJogo()
        jogo.abrir(self.troca)
        print(jogo, end='')

        # passa a lista de cartas que estava relacionada ao jogo para a classe
        # esse é um jeito fácil de conseguir acessar essa lista a partir da main
        self.cartasList = jogo.cartasList

    # função com o objetivo de pegar a entrada do teclado (nesse caso a APOSTA)
    # tentei fazer o tratamento de erro da melhor forma que consegui
    def EntradaTeclado(self):
        foi = False
        while(foi != True):
            try:
                # entrada da aposta
                self.aposta = input()
                # quit do jogo
                if self.aposta == "F":
                    print('Obrigado por jogar, até mais!')
                    sys.exit()
                # tipagem para int
                self.aposta = int(self.aposta)
                # verifica se o erro está no intervalo correto
                puxaError(self.aposta, self.saldo, 0)
                foi = True
            except ValueError as ve:
                print(f'\nEntrada invalida ({ve})\nDigite denovo: ', end='')
            except EntradaError:
                print(f'\nEntrada invalida (Valor não está entre 0 e {self.saldo})\nDigite denovo: ', end='')

    # função com o objetivo de pegar a entrada do teclado (nesse caso a TROCA)
    # tentei fazer o tratamento de erro da melhor forma que consegui
    def TrocarJogo(self):
        foi = False
        msg = 'Digite o número de cartas que deseja trocar, separado por espaços: '
        (self.troca).clear()
        while(foi != True):
            try:
                # passa a entrada "1 4 5" para [1, 4, 5]
                self.troca =  list(map(int, input(msg).split(' ')))
                # trocar no minimo 0 e no maximo 5 cartas
                puxaError(len(self.troca), self.saldo, 1)
                # numero de cartas tem que estar entre 0 e 5
                for i in range(0, len(self.troca)):
                    puxaError(self.troca[i], self.saldo, 2)
                foi = True
            except ValueError as ve:
                print(f'\nEntrada invalida ({ve})\n', end='')
            except TrocaError:
                print(f'\nEntrada invalida (Troca impossível)\n', end='')


def main():
    Jogo()

if __name__ == '__main__':
    main()