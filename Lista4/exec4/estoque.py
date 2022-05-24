class estoque():

    #  * Construtor de um item genérico
    #  * @param nome
    #  * @param num
    #  * @param qte0
    def __init__(self, nome: str, num: float, qte: int) -> None:
        self.nome = nome
        self.num = num
        self.estoque = qte0

    # Getters
    def getNome(self) -> str:
        return self.nome

    def getNum(self) -> float:
        return self.num

    def getQte(self) -> int:
        return self.qte

    # Setters
    def setNome(self, nome) -> str:
        self.nome = nome

    def setNum(self, num) -> float:
        self.num = num

    def setQte(self, estoque) -> int:
        self.estoque = estoque


    #  * Adicionar qunatia ao estoque
    #  * @param produtos
    def adicionar(self, produtos: int) -> None:
        self.setQte(self.estoque + produtos)

    #  * Remover ou vender quantia do estoque (se houver)
    #  * @param produtos
    #  * @throws Exception
    def remover(produtos: int) -> None:
        if self.estoque < produtos:
            print('Não há estoque suficiente')
            setQte(self.estoque)
        else:
            setQte(self.estoque - produtos)