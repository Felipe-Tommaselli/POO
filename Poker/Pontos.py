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
        if rsf == True:
            self.premio = 200*self.aposta
        elif sf == True:
            self.premio = 100*self.aposta
        elif quadra == True:
            self.premio = 50*self.aposta
        elif fh == True:
            self.premio = 20*self.aposta
        elif flush == True:
            self.premio = 10*self.aposta
        elif straight == True:
            self.premio = 5*self.aposta
        elif trinca == True:
            self.premio = 2*self.aposta
        elif doispares() == True:
            self.premio = self.aposta
        else:
            self.premio = 0
        
    def doispares():
        par0 = False
        par1 = False
        for i0 in self.cartas:
            # procura um par
            if par0 == False:
                for j in self.cartas:
                    if i0 is j:
                        par0 = True
                        break
        for i1 in self.cartas:
            # procura outro par
            if par1 == False:
                for k in self.cartas:
                    if k == i1 and k != j:
                        par1 = True
                        break
        if par1 == True:
            return True
        else:
            return False



    def balanco(self):
        self.saldo += self.premio
        return self.saldo
