
saldo = 200

class Interface(object):

    def __init__(self) -> None:
        print(f'Saldo atual: {saldo}')
        print(f'Digite o valor da aposta ou "F" para finalizar: ', end='')
        foi = False
        self.entrada = 0
        while(foi != True):
            try:
                self.entrada = int(input())
                foi = True
            except ValueError as e:
                print(f'\nEntrada invalida ({e})\nDigite denovo: ', end='')
        print(self.entrada)

        


i = Interface()
