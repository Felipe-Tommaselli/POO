class CD(estoque):

    #  * expande a classe Estoque com as info do Livro
    #  * @param nome
    #  * @param num
    #  * @param qte
    def __init__(self, nome: str, num: int, qte: int):
        super().__int__(nome, num, qte)

    def __str__(self) -> str:
        s = 'Tipo: Livro'
        s += "Nome: " + self.getNome() + "\n"
        s += "Código de Barras: " + self.getNum() + "\n"
        s += "Quantia em Estoque: " + self.getQte() + "\n"
        return s