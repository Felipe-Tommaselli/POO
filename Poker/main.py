from Jogo import *
from Pontos import *

'''
* @author: 11800910
'''

def main():

    saldo = 200
    while saldo != 0:
        j = Jogo(saldo)
        p = Pontos(saldo, j.aposta, j.cartasList)
        saldo = p.saldo 



if __name__ == '__main__':
    main()