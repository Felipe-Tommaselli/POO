from Cartas import *
from AbreCartas import *
from Jogo import *

class Pontos(object):

    def __init__(self, saldo, aposta, cartas: list()):
        self.saldo = saldo
        self.cartas = cartas

        ganho = 0
        if self.rsf() == True:
            ganho = 200
        elif self.sf() == True:
            ganho = 100
        elif self.quadra() == True:
            ganho = 50
        elif self.fh() == True:
            ganho = 20
        elif self.flush() == True:
            ganho = 10
        elif self.s() == True:
            ganho = 5
        elif self.trinca() == True:
            ganho = 2
        elif self.doispares() == True:
            ganho = 1
        else:
            ganho = 0
        
        self.saldo += ganho*aposta
        if ganho == 0:
            print('Infelizmente você não ganhou nada essa rodada')
        else:
            print(f'Parabéns! Você ganhou ${ganho*aposta}')

    def rsf(self) -> bool:
        if self.s() == True:
            if self.flush() == True:
                for e in self.cartas:
                    if e[0] in ('2', '3', '4', '5', '6', '7', '8', '9'):
                        return True

        return False

    def sf(self) -> bool:
        if self.s() == True:
            if self.flush() == True:
                return True

        return False

    
    def quadra(self) -> bool:

        nums = [e[0] for e in self.cartas]
        for num in nums:
            if nums.count(num) == 4:
                return True

        return False

    def fh(self) -> bool:
        if self.trinca() == True:
            nums = [e[0] for e in self.cartas]
            for num in nums:
                if nums.count(num) == 2:
                    return True
        
        return False

    def flush(self) -> bool:
        e0 = self.cartas[0]
        e1 = self.cartas[1]
        e2 = self.cartas[2]
        e3 = self.cartas[3]
        e4 = self.cartas[4]
        if e0[1] == e1[1] and e1[1] == e2[1] and e2[1] == e3[1] and e3[1] == e4[1]:
            return True
        
        return False

    def s(self) -> bool:
        nums = list()
        for e in self.cartas:
            if e[0] == 'J':
                nums.append(11)
            elif e[0] == 'Q':
                nums.append(12)
            elif e[0] == 'K':
                nums.append(13)
            elif e[0] == 'A':
                nums.append(14)
            else:
                nums.append(int(e[0]))
        
        sortnums = sorted(nums)        
        if sortnums[4]-sortnums[3]==1 and sortnums[3]-sortnums[2]==1 and sortnums[2]-sortnums[1]==1 and sortnums[1]-sortnums[0]==1:
            return True
        
        return False

    def trinca(self) -> bool:
        nums = [e[0] for e in self.cartas]
        for num in nums:
            if nums.count(num) == 3:
                return True

        return False

    def doispares(self) -> bool:
        par0 = False
        
        nums = [e[0] for e in self.cartas]
        for num in nums:
            if nums.count(num) == 2:
                par0 = True
                break

        if par0 == True:
            nums.remove(num)
            nums.remove(num)
            for num2 in nums:
                if nums.count(num2) == 2:
                    return True
        
        return False

