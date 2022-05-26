from quadrado import *
from retangulo import *
from circulo import *
from forma import *

TAM = 1000

class gtm():

    def __init__(self):
        self.formas = [0 for i in range(0, TAM)]
        self.num_forma = 0

    def getLado(self) -> float:
        try:
            return float(input('Lado: '))
        except:
            print('Um erro ocorreu')
            exit()

    def printFormas(self) -> None:
        print('FORMAS:\n')
        for forma in self.formas:
            if isinstance(forma, circulo):
                print('\nCirculo: ' + str(forma))
            if isinstance(forma, quadrado):
                print('\nQuadrado: ' + str(forma))
            if isinstance(forma, retangulo):
                print('\nRetangulo: ' + str(forma))

    def insereFormas(self, modo: str) -> None:
        # flag 0: QUADRADO 
        # flag 1: RETANGULO
        # flag 2: CIRCULO
        if modo == 'quadrado': 
            print("\nInserir quadrado".upper()) 
        elif modo == 'retangulo':
            print("\nInserir retângulo".upper())
        elif modo == 'circulo':
            print("\nInserir círculo".upeer()) 
        
        lados =  [-1.0, -1.0]

        try:
            if modo == 'quadrado':
                print("Insira o lado: ")
                lados[0] = self.getLado()
                lados[1] = lados[0]
            

            if modo == 'retangulo':
                print("Insira o lado 1: ")
                lados[0] = self.getLado()
                print("Insira o lado 2: ")
                lados[1] = self.getLado()
            

            if modo == 'circulo':
                print("Insira o raio: ")
                lados[0] = self.getLado()
                lados[1] = lados[0]
            


            if lados[0] == -1 or lados[1] == -1: 
                print("ERRO: Não foi possível ler o valor para o lado")
                print("Verifique que o valor inserido é um numero positivo")
                return
        

            self.cheio = False
            self.cheioStr = input('Mudar cor? ("sim" em caso afirmativo) ') 
            self.cheioStr.strip().lower()
            self.cor = ""

            if self.cheioStr == 'sim':
                self.cheio = True
                self.cor = input('Insira a cor desejada: ')
            
            if modo == 'quadrado': 
                self.formas[self.num_forma] = quadrado(lados[0], self.cheio, self.cor)
                self.num_forma += 1
                print("Forma criada com sucesso: ")
                print(str(self.formas[self.num_forma]))
            
            if modo == 'retangulo':
                self.formas[self.num_forma] = retangulo(lados[0], lados[1], self.cheio, self.cor)
                self.num_forma += 1
                print("Forma criada com sucesso: ")
                print(str(self.formas[self.num_forma]))
            
            if modo == 'circulo': 
                self.formas[self.num_forma] = circulo(lados[0], self.cheio, self.cor)
                self.num_forma += 1
                print("Forma criada com sucesso: ")
                print(str(self.formas[self.num_forma]))
        
        except Exception as e:
            print(f"ERRO: {e}\nHouve um erro ao ler os valores de entrada")
            return