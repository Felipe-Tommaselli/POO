from forma import *
import math

class circulo(forma):

    def __init__(self, raio: float, cheio: bool, cor: str) -> None:
        super().__init__(0, 0, cheio, cor)
        self.raio = raio

    def area(self):
        return float(math.pi) * self.raio * self.raio

    def perimetro(self):
        return 2 * math.pi * self.raio

    def __str__(self) -> str:
        self.cheio = self.getCheio()
        s = '\nForma Geométrica: CIRCULO\n'
        s += "Lados: " + str(self.raio) + "\n"
        s += "Area: " + str(self.area()) + "\n"
        s += "Perímetro: " + str(self.perimetro()) + "\n"
        s += "Colorido: " + str(self.cheio) + "\n"
        if(self.cheio):
            s += "Cor: " + self.getCor() + "\n"
        
        return s

