class CD(estoque):

    #  * expande a classe Estoque com as info do CD
    #  * @param nome
    #  * @param num
    #  * @param qte
    def __init__(self, nome: str, num: int, qte: int):
        super().__int__(nome, num, qte)

    def __str__(self) -> str:
        s = 'Tipo: CD'
        s += "Nome: " + str(self.getNome()) + "\n"
        s += "Código de Barras: " + str(self.getNum()) + "\n"
        s += "Quantia em Estoque: " + str(self.getQte()) + "\n"
        return s