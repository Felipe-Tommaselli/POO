from loja import *

def main():
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

        sel = 1
        while(True):
            try:  
                sel = int(input('>> '))
            except Exception as e:
                print(f'\nErro: {e}')
            
        if sel == 1:
            loja_.__int__()
        elif sel == 2:
            loja_.adicionarProduto()
        elif sel == 3:
            loja_.getProduto()
        elif sel == 4:
            loja_.removeProduto()
        elif sel == 5:
            loja_.printEstoque
        elif sel == 6:
            loja.excluirProduto()
        elif sel == 7:
            exit()
        else:
            print('Encerrando programa')
        

if __name__ == '__main__':
    main()