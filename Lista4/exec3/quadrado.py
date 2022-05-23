from forma import *

class quadrado(forma):

    def __init__(self, lado: float, cheio: bool, cor: str) -> None:
        super().__init__(lado, lado, cheio, cor)

    def __str__(self) -> str:
        self.cheio = self.getCheio()
        s = '\nForma Geométrica: QUADRADO\n'
        s += "Lados: " + str(self.getLados()[0]) + " e " + str(self.getLados()[1]) + "\n"
        s += "Area: " + str(self.area()) + "\n"
        s += "Perímetro: " + str(self.perimetro()) + "\n"
        s += "Colorido: " + str(self.cheio) + "\n"
        if(self.cheio):
            s += "Cor: " + self.getCor() + "\n"
        
        return s

