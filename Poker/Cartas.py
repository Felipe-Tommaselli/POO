import Random as rd

class Cartas(object):

    def __init__(self):
        self.rd = rd.Random()
        self.numatt = 0
        self.naipeatt = '♣'
        
    def __str__(self):
        
        num = self.getNum()
        naipe = self.getNaipe()
        str =  f'+-----+\n'
        str += f'|     |\n'
        str += f'| {num} {naipe} |\n'
        str += f'|     |\n'
        str += f'+-----+\n'

        return str


    def getNum(self):
        return self.numatt

    def getNaipe(self):
        return self.naipeatt

def main():
    c = Cartas()
    print(c)

if __name__ == "__main__":
	main()