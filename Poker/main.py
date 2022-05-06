'''


* @author: 11800910

'''

class TelePoker():

    def __init__(self):
        print(self)



class Cartas():

    num = 5
    nipe = 'W'

    def printCartas(num, nipe):
        str =  '+-----+'
        str += '|     |'
        str += f'|  {num} {nipe}  |'
        str += '|     |'
        str +=  '+-----+'


if __name__ == '__main__':
    print('classe main')