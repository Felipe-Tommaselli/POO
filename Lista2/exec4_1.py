'''
 *
 * @author 11800910
'''

def valida_entrada():
    while(True):
        try:
            num = int(input('Digite um inteiro: '))
            if num < 0:
                print('Número deve ser positivo!!')
                continue
            break
        except ValueError:
            print('O valor que vc digitou não é um número inteiro')
    return num

if __name__ == '__main__':

    # cabeçalho
    print('EXERCICIO 4 (parte 1): Arvore direita->esquerda\n')
    
    # valdação da entrada 
    num = valida_entrada()

    # com num validado, vamos montar a arvore
    asteriscos = num
    espacos = 0
    # loop vertical (até acabar o num)
    while asteriscos > 0:
        # loop horizontal (até acabar a linha)
        for _ in range(0, espacos):
            print(' ', end="")
        # espacos roda horizontalmente de 0 até num
        for _ in range(0, asteriscos):
            print('*', end="")
        print('\n')
        asteriscos -= 1
        espacos += 1