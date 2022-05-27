from estoque import *
from livro import *
from CD import *
from DVD import *

class loja:

    #  * cadastro de produto
    def __init__(self) -> None:
        self.itens = ['' for i in range(0, 1000)]
        self.modo = -1 
        self.qte = 0 
        self.num_itens = 0
        self.nome = ""     

    def cadastrarProduto(self) -> None:
        
        print('\033[32m' + '\nAdicionar Item\n'.upper() + '\033[0;0m')

        print("1) Inserir Livro")
        print("2) Inserir CD")
        print("3) Inserir DVD\n")

        try: 
            self.modo = int(input('> ')) 
        except Exception as e:
            print(f"\nErro: {e}")
            return

        
        try:
            cbarras = int(input('Código de barras para este produto: '))
            nome = input('Insira nome do produto: ')
            try:
                self.qte = int(input("Insira uma qte inicial para o estoque se quiser: "))
                if self.qte < 0: 
                    print("\nErro: A quantidade inicial minima é 0")
                    self.qte = 0
            except Exception as e: 
                print(f'Erro: {e}')
                self.qte = 0 

            if self.modo == 1:
                self.itens[self.num_itens] = livro(nome, cbarras, self.qte) 
            elif self.modo == 2: 
                self.itens[self.num_itens] = CD(nome, cbarras, self.qte) 
            elif 3: 
                self.itens[self.num_itens] = DVD(nome, cbarras, self.qte) 
            else:
                print("\nErro: Houve um problema ao ler o modo")

            if (self.ctProduto_codigo(cbarras) != -1) or (self.ctProduto_codigo(nome) != -1): 
                print("Erro: produto já cadastrado\n") 

        except Exception as e: 
            print(f"\nErro: {e}") 
            return 

        print(self.itens[self.num_itens])
        self.num_itens += 1
    
    #  * Adicionar mais estoque a um item ja existente
    def adicionarProduto(self):
        flag = ""
        self.qte = 0

        print('\033[32m' + "\nAdicionar Estoque\n".upper() + '\033[0;0m')

        pos = self.ctIndice()
        if pos == -1: 
            print("Erro \nItem não encontrado") 
            return 

        try:
            print("Item "+ str((self.itens[pos]).getNome()) + "encontrado")
            print("Insira a quantidade que deseja acrescentar: ")
            self.qte = input()

            if self.qte <= 0: 
                print("\nErro: Quantia inválida") 
                return 

        except Exception as e: 
            print(f"\nErro: {e}") 
            return 

        self.itens[pos].adicionar(self.qte)
        print("\n Quantia adicionada com sucesso ")
        print("Quantidade atual: "+ str(self.itens[pos].getself.Qte()))

    
    #  * Encontrar produtos através do código de barras ou do nomne
    #  * @param chave
    #  * @return
    def ctProduto_codigo(self, chave):
        if type(chave) == 'int':
            for item in self.itens:
                if item != '':
                    if self.num_iten == item.getNum(): 
                        return i
        else:
            for item in self.itens:
                if item != '':
                    if self.nome ==  item.getNome(): 
                        return i 

        return -1


    #  * Le dados de busca do usuário e retorna a posição do produto
    #  * @return
    def ctIndice(self):
        flag = ""
        self.qte = 0
        self.pos = -1

        #try:
        flag = input('Insira o nome ou código de barras do item que deseja modificar: ')
        try:
            self.num_itens = int(flag)                
            pos = self.ctProduto_codigo(self.cbarras)
            if pos == -1: 
                pos = self.ctProduto_codigo(flag)  
        except Exception as e:
            pos = self.ctProduto_codigo(flag)
            
        #except Exception as e: 
        #    print(f"\nErro:{e}") 
        #    return -2 

        return pos

    #  * buscar e imprimir certo produto
    def getProduto(self):
        print('\033[32m' + "\nBuscar Item\n".upper() + '\033[0;0m')
        pos = self.ctIndice()
        if pos == -1: 
            print("\nErro: Item não encontrado") 
            return 
        print("\n Produto encontrado: " + str(self.itens[pos]))

    #  * imprimir todo o estoque disponível
    def printEstoque(self):
        print('\033[32m' + "\nImprimindo estoque\n".upper() + '\033[0;0m')
        for item in self.itens:
            if item != '':
                print(item)
            

    #  * excluir produto
    def excluirProduto(self):
        print('\033[32m' + "\nExcluir Item\n".upper() + '\033[0;0m')
        self.pos = ctIndice() 
        if self.pos == -1: 
            print("\nErro: Item não encontrado") 
            return 
        for i in range(0, self.num_itens):
            self.itens[i] = self.itens[i+1]
        
        self.num_itens -= 1
        print("\n Item excluido")

    #  * Vender produto (remover)
    def removerProduto(self):
        print('\033[32m' + "\nVender Item\n".upper() + '\033[0;0m')
        self.qte = 0
        self.pos = ctIndice()
        if pos == -1: 
            print("\nErro: Item não encontrado") 
            return 

        try:
            try:
                print("Item "+ str((estoque[pos]).getNome()) + "encontrado")
                print("Insira a quantidade que deseja retirar: ")
                self.qte = int(input())

                if self.qte <= 0: 
                    print("\nErro: Quantia inválida") 
                    return 

            except Exception as e: print("\nErro: Houve um problema ao ler os valores de entrada") 
            return 

            (self.itens[pos]).remover(self.qte)
            print("\n Remoção realizada com sucesso \nNovo estoque: "+ (self.itens[pos]).getself.Qte())

        except Exception as e:
            print(f"\nErro: {e}")
        
