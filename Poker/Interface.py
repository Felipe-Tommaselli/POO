import sys
saldo = 200

'''
tratametno da exceção de forma mais legível, EntradaError
herda todas as exceções e cria esse novo erro, enquanto 
puxaEntradaError apenas coloca a condiçaõ que deve levantar
o erro, tornando o código menos poluido
'''
class EntradaError(Exception):
    pass
    
def puxaEntradaError(entrada):
    if entrada > saldo or entrada < 0:
        raise EntradaError()

class Interface(object):

    def __init__(self) -> None:
        print(f'Saldo atual: {saldo}')
        print(f'Digite o valor da aposta ou "F" para finalizar: ', end='')
        foi = False
        self.entrada = 0
        while(foi != True):
            try:
                self.entrada = input()
                if self.entrada == "F":
                    print('Obrigado por jogar, até mais!')
                    sys.exit()
                self.entrada = int(self.entrada)
                puxaEntradaError(self.entrada)
                foi = True
            except ValueError as ve:
                print(f'\nEntrada invalida ({ve})\nDigite denovo: ', end='')
            except EntradaError:
                print(f'\nEntrada invalida (Valor não está entre 0 e {saldo})\nDigite denovo: ', end='')
            

        print(self.entrada)




i = Interface()
