'''
 *
 * @author 11800910
'''

def valida_entrada():
    while(True):
        try:
            num = int(input('Digite um inteiro: '))
            break
        except ValueError:
            print('O valor que vc digitou não é um número inteiro')
    return num

if __name__ == '__main__':

    # cabeçalho
    print('EXERCICIO 3:Arvore esquerda->direita\n')
    
    # valdação da entrada 
    num = valida_entrada()

    # com num validado, vamos montar a arvore
    x = num
    # loop vertical (até acabar o num)
    while x > 0:
        # loop horizontal (até acabar a linha)
        for _ in range(0, x):
            print('*', end="")
        print('\n')
        x -= 1
