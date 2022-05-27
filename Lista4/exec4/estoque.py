class estoque:

    #  * Construtor de um item genérico
    #  * @param nome
    #  * @param num
    #  * @param qte0
    def __init__(self, nome: str, num: int, qte0: int) -> None:
        self.nome = nome
        self.num = num
        self.qte = qte0

    # Getters
    def getNome(self) -> str:
        return self.nome

    def getNum(self) -> int:
        return self.num

    def getQte(self) -> int:
        return self.qte

    # Setters
    def setNome(self, nome) -> str:
        self.nome = nome

    def setNum(self, num) -> int:
        self.num = num

    def setQte(self, estoque) -> int:
        self.qte = estoque


    #  * Adicionar qunatia ao estoque
    #  * @param produtos
    def adicionar(self, produtos: int) -> None:
        self.setQte(self.qte + produtos)

    #  * Remover ou vender quantia do estoque (se houver)
    #  * @param produtos
    #  * @throws Exception
    def remover(produtos: int) -> None:
        if self.qte < produtos:
            print('Não há estoque suficiente')
            setQte(self.qte)
        else:
            setQte(self.qte - produtos)