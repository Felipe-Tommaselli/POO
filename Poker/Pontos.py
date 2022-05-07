from Cartas import *
from AbreCartas import *
from Jogo import *

class Pontos(object):

    def __init__(self, saldo, aposta, cartas: list()):
        self.premio = 0
        self.saldo = saldo
        self.aposta = aposta
        self.cartas = cartas

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
        elif s() == True:
            self.premio = 5*self.aposta
        elif trinca() == True:
            self.premio = 2*self.aposta
        elif doispares() == True:
            self.premio = self.aposta
        else:
            self.premio = 0
        
        self.saldo += self.premio

    def rsf(self):
        if s() == True:
            if flush() == True:
                for e in self.cartas:
                    if e[0] not in ('10', 'J', 'Q', 'K', 'A'):
                        return False

        return True

    def sf(self):
        if s() == True:
            if flush() == True:
                return True

        return False

    
    def quadra(self):
        for i in self.cartas:
            for j in self.cartas:
                for k in self.cartas:
                    for l in self.cartas:
                        if i == j and i == k and i == l:
                            return True

    def fh(self):
        if trinca() == True:
            for i in self.cartas:
                # procura um par
                for j in self.cartas:
                    if i is j:
                        return True
        
        return False

    def flush(self):
        e0 = self.cartas[0]
        e1 = self.cartas[1]
        e2 = self.cartas[2]
        e3 = self.cartas[3]
        e4 = self.cartas[4]
        if e0[1] == e1[1] and e1[1] == e2[1] and e2[1] == e3[1] and e3[1] == e4[1]:
            return True
        
        return False

    def s(self):
        nums = list()
        for e in self.cartas:
            nums.append(e[0])
        
        sortnums = sorted(nums)        
        if sortnums[4]-sortnums[3]==1 and sortnums[3]-sortnums[2]==1 and sortnums[2]-sortnums[1]==1 and sortnums[1]-sortnums[0]==1:
            return True
        
        return False

    def trinca(self) -> bool:
        # procura uma trinca
        for i in self.cartas:
                for j in self.cartas:
                    for k in self.cartas:
                        if i is j and i is k :
                            return True

        return False

    def doispares(self) -> bool:
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
