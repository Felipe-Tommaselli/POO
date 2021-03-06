class forma:
    
    def __init__(self, lado1: float, lado2: float, cheio: bool, cor: str):
        self.cheio = cheio
        self.lados = [0,0]
        self.lados[0] = lado1
        self.lados[1] = lado2
        if(self.cheio):
            self.cor = cor

    def perimetro(self):
        return 2*(self.lados[0] + self.lados[1])

    def area(self):
        return self.lados[0]*self.lados[1]

    # Getters
    def getLados(self):
        return self.lados
    def getCheio(self):
        return self.cheio
    def getCor(self):
        return self.cor
