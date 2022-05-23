from quadrado import *
from retangulo import *
from circulo import *
from forma import *

TAM = 1000

class gtm():

    def __init__(self):
        self.formas = [0 for i in range(0, TAM)]
        self.num_formas = 0

    def getLado(self) -> float:
        try:
            return float(input('Lado: '))
        except:
            print('Um erro ocorreu')
            exit()

    def printFormas(self) -> None:
        print('FORMAS:\n')
        for i in range(0, self.num_formas):
            if isinstance(self.formas[i], circulo):
                print('\nCirculo: ' + str(self.formas[i]))
            if isinstance(self.formas[i], quadrado):
                print('\nQuadrado: ' + str(self.formas[i]))
            if isinstance(self.formas[i], retangulo):
                print('\nRetangulo: ' + str(self.formas[i]))

    def insereFormas(self, flag: int) -> None:
        # flag 0: QUADRADO 
        # flag 1: RETANGULO
        # flag 2: CIRCULO
        if flag == 0: 
            print("\nInserir quadrado") 
        elif flag == 1:
            print("\nInserir retângulo") 
        elif flag == 2:
            print("\nInserir círculo") 
        
        lados =  [-1.0, -1.0]

        if flag == 0:
            print("Insira o lado: ")
            lados[0] = self.getLado()
            lados[1] = lados[0]
        

        if flag == 1:
            print("Inserção de lados\n")
            print("Insira o lado 1: ")
            lados[0] = self.getLado()
            print("Insira o lado 2: ")
            lados[1] = self.getLado()
        

        if flag == 2:
            print("Insira o raio: ")
            lados[0] = self.getLado()
            lados[1] = lados[0]
        


        if lados[0] == -1 or lados[1] == -1: 
            print("ERRO: Não foi possível ler o valor para o lado")
            print("Verifique que o valor inserido é um numero positivo")
            return
        

        try:
            self.cheio = False
            self.cheioStr = input('Mudar cor? ("sim" em caso afirmativo) ') 
            print(self.cheioStr.strip().lower())
            self.cor = ""

            if self.cheioStr is 'sim':
                self.cheio = True
                self.cor = input('Insira a cor desejada: ')
            
            if flag == 0: 
                self.formas[self.num_formas] = quadrado(lados[0], self.cheio, self.cor)
                self.num_formas += 1
                print("Forma criada com sucesso: ")
                print(str(self.formas[self.num_formas]))
            
            if flag == 1:
                self.formas[self.num_formas] = retangulo(lados[0], lados[1], self.cheio, self.cor)
                self.num_formas += 1
                print("Forma criada com sucesso: ")
                print(str(self.formas[self.num_formas]))
            
            if flag == 2: 
                self.formas[self.num_formas] = circulo(lados[0], self.cheio, self.cor)
                self.num_formas += 1
                print("Forma criada com sucesso: ")
                print(str(self.formas[self.num_formas]))
        
        except Exception as e:
            print(f"ERRO: {e}\nHouve um erro ao ler os valores de entrada")
            return
        

    def insereQuadrado(self):
        self.insereFormas(0)

    def insereRetangulo(self):
        self.insereFormas(1)

    def insereCirculo(self):
        self.insereFormas(2)