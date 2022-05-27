from estoque import *

class DVD(estoque):

    #  * expande a classe Estoque com as info do DVD
    #  * @param nome
    #  * @param num
    #  * @param qte
    def __init__(self, nome: str, num: float, qte: int) -> None:
        super().__init__(nome, num, qte)

    def __str__(self) -> str:
        s = 'Tipo: DVD'
        s += "Nome: " + str(self.getNome()) + "\n"
        s += "Código de Barras: " + str(self.getNum()) + "\n"
        s += "Quantia em Estoque: " + str(self.getQte()) + "\n"
        return s
