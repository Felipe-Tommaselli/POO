import Random as rd

'''
* Código que cria UMA carta, que será usado para criar todos as cartas do jogo.
* A ideia principal é sortear os atributos da carta e entregar a carta pronta para
* o resto do programa
* @author: 11800910
'''


# gabarito das cartas do poker
simbol = {
    0:  '2',
    1:  '3',
    2:  '4',
    3:  '5',
    4:  '6',
    5:  '7',
    6:  '8',
    7:  '9',
    8:  '10',
    9:  'J',
    10: 'Q',
    11: 'K',
    12: 'A'
}

# gabarito de naipes disponiveis
naipes = {
    0: '♣',
    1: '♠',
    2: '♥',
    3: '♦',
}

class Cartas(object):

    # construtor com os parametros da carta
    def __init__(self) -> None:
        self.rd = rd.Random()
        self.valor_att = ['A', '♣']
        self.sortear()

    
    # constrói a formatação de string
    def __str__(self) -> str:
        # pega o valor e naipe retornado pelo getvalor
        valor = str(self.getValor()[0])
        naipe = str(self.getValor()[1])
        
        # corrigir formatação do 10
        if valor != '10':
            valor += ' '
        
        # monta as cartas
        st =  f'+-----+\n'
        st += f'|     |\n'
        st += f'| {valor}{naipe} |\n'
        st += f'|     |\n'
        st += f'+-----+\n'

        return st

    # sorteia um valor e um naipe para a carta
    def sortear(self):
        # atribui lista valor_att o valor e o naipe da carta
        # utiliza o gabrito "simbol" e "naipes" referenciado acima
        self.valor_att[0] = simbol[self.rd.getIntRand(13)]
        self.valor_att[1] = naipes[self.rd.getIntRand(4)]        
        return self.valor_att
        

    # envia o proprio valor
    def getValor(self):
        return self.valor_att


def main():
    c = Cartas()
    print(c)

if __name__ == "__main__":
	main()