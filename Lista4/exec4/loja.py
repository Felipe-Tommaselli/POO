class loja:

    #  * cadastro de produto
    def __init__(self) -> None:
        print("\nAdicionar Item \n\n")

        print("1) Inserir Livro")
        print("2) Inserir CD")
        print("3) Inserir DVD\n")

        self.modo = -1 
        self.qte = 0 
        self.num_itens_itens = -1
        self.nome = ""
        try: 
            self.modo = int(input('>> ')) 
        except Exception as e:
            print(f"\nErro: {e}")
            return
        
        try:
            self.num_itens = int(input('Código de barras para este produto: '))
            if self.ctProduto_codigo(self.num_itens) != -1: 
                print("Erro: produto já cadastrado\n") 
                return 
            
            self.nome = input('Insira nome do produto: ')

            if self.ctProduto_codigo(self.nome) != -1: 
                print("Erro: produto já cadastrado\n") 
                return 

            try:
                self.qte = int(input("Insira uma qte inicial para o estoque se quiser: "))
                if self.qte < 0: 
                    print("\n>> A quantidade inicial minima é 0")
                    self.qte = 0
                
            except Exception as e: 
                print(f'Erro: {e}')
                self.qte = 0 
            
        except Exception as e: 
            print(f"\nErro: {e}") 
            return 

        if self.modo == 1:
            itens[self.num_itens_itens] = self.livro(self.nome, self.num_itens, self.qte) 
        elif self.modo == 2: 
            itens[self.num_itens_itens] = self.CD(self.nome, self.num_itens, self.qte) 
        elif 3: 
            itens[self.num_itens_itens] = self.DVD(self.nome, self.num_itens, self.qte) 
        else:
            print("\nErro: Houve um problema ao ler o modo")
        
        self.num_itens_itens += 1
    
    #  * Adicionar mais estoque a um item ja existente
    def adicionarProduto(self):
        flag = ""
        self.qte = 0

        print("\n Adicionar Estoque \n")
        pos = self.ctIndice()
        if pos == -1: 
            print("Erro \nItem não encontrado") 
            return 

        try:
            print("Item "+ str(self.itens[pos].getNome()) + "encontrado")
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
            print('INT')
            for i in range(0, self.num_itens_itens):
                if self.num_itens == self.itens[i].getNum(): 
                    return i
        else:
            print('STR')
            for i in range(0, self.num_itens_itens):
                if self.nome.equals(self.itens[i].getNome()): 
                    return i 

        return -1


    
    #  * Le dados de busca do usuário e retorna a posição do produto
    #  * @return
    def ctIndice(self):
        flag = ""
        self.qte = 0
        self.pos = -1

        try:
            flag = input('Insira o nome ou código de barras do item que deseja modificar ')
            try:
                self.num_itens = int(flag)
                pos = ctProduto_codigo(self.num_itens)
                if pos == -1: 
                    pos = ctProduto_codigo(flag)  
                # Faz a busca pelo self.nome caso nao encontre pelo codigo (self.nome pode ser apenas self.num_itenseros)
            except Exception as e:
                pos = ctProduto_codigo(flag)
            
        except Exception as e: 
            print("\nErro: Houve um problema ao ler os valores de entrada") 
            return -2 

        return pos
    

    
    
    #  * imprimir todo o estoque disponível
    def printEstoque(self):
        print("\n Imprimindo estoque \n")
        for i in range(0, self.num_itens_itens):
            print(itens[i])


    #  * excluir produto
    def excluirProduto(self):
        print("\n Excluir Item \n")
        self.pos = ctIndice() 
        if self.pos == -1: 
            print("\nErro: Item não encontrado") 
            return 
        for i in range(0, self.num_itens_itens):
            itens[i] = itens[i+1]
        
        self.num_itens_itens -= 1
        print("\n Item excluido")
    

    #  * buscar e imprimir certo produto
    def getProduto(self):
        print("\n Buscar Item \n")
        pos = ctIndice()
        if pos == -1: 
            print("\nErro: Item não encontrado") 
            return 
        print("\n Produto encontrado \n"+ str(itens[pos]))
    

    
    #  * Vender produto (remover)
    def removeProduto(self):
        print("\n Vender Item \n")
        self.qte = 0
        self.pos = ctIndice()
        if pos == -1: 
            print("\nErro: Item não encontrado") 
            return 

        try:
            try:
                print("Item "+ itens[pos].getNome() + "encontrado")
                print("Insira a quantidade que deseja acrescentar: ")
                self.qte = int(input())

                if self.qte <= 0: 
                    print("\nErro: Quantia inválida") 
                    return 

            except Exception as e: print("\nErro: Houve um problema ao ler os valores de entrada") 
            return 

            self.itens[pos].remover(self.qte)
            print("\n Remoção realizada com sucesso \nNovo estoque: "+ itens[pos].getself.Qte())
        
        except Exception as e:
            print("\nErro: A quantia fornecida é maior que a disponível em estoque")
        
    
