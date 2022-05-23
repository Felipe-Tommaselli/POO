from forma import *

class retangulo(forma):

    def __init__(self, lado1: float, lado2: float, cheio: bool, cor: str) -> None:
        super().__init__(lado1, lado2, cheio, cor)

    def __str__(self) -> str:
        self.cheio = self.getCheio()
        s = '\nForma Geométrica: RETANGULO\n'
        s += "Lados: " + str(self.getLados()[0]) + " e " + str(self.getLados()[1]) + "\n"
        s += "Area: " + str(self.area()) + "\n"
        s += "Perímetro: " + str(self.perimetro()) + "\n"
        s += "Colorido: " + str(self.cheio) + "\n"
        if(self.cheio):
            s += "Cor: " + self.getCor() + "\n"
        
        return s

