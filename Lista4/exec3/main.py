from gtm import *

def main():
    gtm_ = gtm()

    while(True):
        modo = -1


        print("\n===========  FORMAS GEOMETRICAS ===========\n\n")

        print("1) Inserir quadrado")
        print("2) Inserir retângulo")
        print("3) Inserir circulo")
        print("4) Imprimir todas as formas")
        print("5) Encerrar programa")
        print("")

        problema = True
        while(problema):
            try:  
                modo = int(input('>> '))
                problema = False
            except Exception as e:
                print(f'\nErro: {e}')
            
        if modo == 1:
            gtm_.insereQuadrado()
        elif modo == 2:
            gtm_.insereRetangulo()
        elif modo == 3:
            gtm_.insereCirculo()
        elif modo == 4:
            gtm_.printFormas()
        else:
            print('Encerrando programa')
        

if __name__ == '__main__':
    main()