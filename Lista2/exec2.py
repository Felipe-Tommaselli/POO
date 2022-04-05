'''
 *
 * @author 11800910
'''

import math

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
    print('EXERCICIO 2: EQUAÇÃO SEGUNDO GRAU\n')
    
    # valdação da entrada 
    a = valida_entrada()
    b = valida_entrada()
    c = valida_entrada()

    # com num validado, vamos calcular a solução
    delta = 0
    x = 0

    # calculo do discriminant
    delta = (b*b) - 4.0*a*c
    print("delta =", delta)

    # para cada caso do discriminante, a equação terá diferentes soluções
    # a partir disso, é aplicada a fórmula de baskhara
    #* SEM RAIZES REAL
    if delta < 0:
        print('Equação fornecida não possui soluçaõ :(')
    #* UMA RAIZ REAL
    elif delta == 0:
        x = (-b)/(2.0*a)
        print('Equação fornecida tem uma solução:', x)
    #* DUAS RAIZES REAIS
    else:
        x = (-b + math.sqrt(delta))/(2.0*a)
        print('Equação fornecida tem duas soluções:', x, end="")
        x = (-b - math.sqrt(delta))/(2.0*a)
        print(' e', x)