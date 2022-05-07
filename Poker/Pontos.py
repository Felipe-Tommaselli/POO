from Cartas import *
from AbreCartas import *
from Jogo import *

class Pontos(object):

    def __init__(self, saldo, aposta, cartas: list()):
        self.premio = 0
        self.saldo = saldo
        self.aposta = aposta
        self.cartas = cartas

        self.pontuacao()
        self.balanco()


    def pontuacao(self):
        
        
        self.premio = 100

    def balanco(self):
        self.saldo += self.premio
        return self.saldo
