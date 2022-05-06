from Cartas import *
from AbreCartas import *
from Interface import *

'''


* @author: 11800910

'''

def main():
    Interface()
    jogo = AbreCartas(5)
    jogo.abrir()
    print(jogo, end='')
    print("  (1)       (2)       (3)       (4)       (5)");

if __name__ == '__main__':
    main()