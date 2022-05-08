from Jogo import *
from Pontos import *

'''
* Arquivo principal main, que utiliza e roda as outras classes criadas*
* @author: 11800910
'''

def main():

    # saldo inicial
    saldo = 200
    # loop até acabar o dinheiro
    while saldo != 0:
        # puxa o objeto j que solta a interface com o jogo
        j = Jogo(saldo)
        # atualiza o saldo a partir da aposta
        saldo -= j.aposta
        # puxa o objeto p para fazer a pontuação
        p = Pontos(saldo, j.aposta, j.cartasList)
        # atualiza o saldo a partir da pontuação
        saldo = p.saldo
    
    # fim do loop, ou seja, acabou o dinheiro
    print('\nVocê perdeu :(')


if __name__ == '__main__':
    main()