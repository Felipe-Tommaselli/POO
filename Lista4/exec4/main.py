from loja import *

def main():

    print('\033[31m' + '===========    LOJA    ===========' + '\033[0;0m')  

    loja_ = loja()

    while(True):

        print("\n===========  PRODUTOS ===========\n\n")

        print("1) Cadastrar produto")
        print("2) Adicionar estoque em produto existente")
        print("3) Buscar produto")
        print("4) Vender produto")
        print("5) Exibir estoque completo")
        print("6) Excluir item")
        print("7) Encerrar programa")
        print("\n")

        modo = -1
        x = True
        while(x):
            try:  
                modo = int(input('>> '))
                x = False
            except Exception as e:
                print(f'\nErro: {e}')
                
        if   modo == 1:
            loja_.cadastrarProduto()
        elif modo == 2:
            loja_.adicionarProduto()
        elif modo == 3:
            loja_.getProduto()
        elif modo == 4:
            loja_.removeProduto()
        elif modo == 5:
            loja_.printEstoque()
        elif modo == 6:
            loja.excluirProduto()
        elif modo == 7:
            exit()
        else:
            print('Erro: Modo inválido')
        

if __name__ == '__main__':
    main()