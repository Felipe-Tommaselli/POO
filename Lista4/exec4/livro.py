from estoque import *

class livro(estoque):

    #  * expande a classe Estoque com as info do Livro
    #  * @param nome
    #  * @param num
    #  * @param qte
    def __init__(self, nome: str, num: int, qte: int) -> None:
        super().__init__(nome, num, qte)

    def __str__(self) -> str:
        s = '\nTipo: Livro\n'
        s += "Nome: " + str(self.getNome()) + "\n"
        s += "Código de Barras: " + str(self.getNum()) + "\n"
        s += "Quantia em Estoque: " + str(self.getQte()) + "\n"
        return s

