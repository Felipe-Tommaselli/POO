import Random as rd

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

naipes = {
    0: '♣',
    1: '♠',
    2: '♥',
    3: '♦',
}

class Cartas(object):

    def __init__(self) -> None:
        self.rd = rd.Random()
        self.valor_att = ['A', '♣']
        self.sortear()

        
    def __str__(self) -> str:
        valor = self.getValor()[0]
        naipe = self.getValor()[1]
        
        str =  f'+-----+\n'
        str += f'|     |\n'
        str += f'| {valor} {naipe} |\n'
        str += f'|     |\n'
        str += f'+-----+\n'

        return str

    def sortear(self):
        self.valor_att[0] = simbol[self.rd.getIntRand(13)]
        self.valor_att[1] = naipes[self.rd.getIntRand(4)]        
        return self.valor_att
        

    def getValor(self):
        return self.valor_att


def main():
    c = Cartas()
    print(c)

if __name__ == "__main__":
	main()