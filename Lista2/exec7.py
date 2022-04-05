'''
 *
 * @author 11800910
'''

import math

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

def func(x):
    return pow(x, 3) - pow(x, 2) - 13*x + 8

if __name__ == '__main__':

    # cabeçalho
    print('EXERCICIO 7: Método da Bisseção\n')
    
    # valdação da entrada 
    a0 = valida_entrada()
    b0 = valida_entrada()

    # com a entrada validada, vamos aplicar o método do bisseção
    erro = 0.0
    intervalo = 0.0
    m = 0.0
    div = 0.0
    
    # arrumando a flag div
    if (func(a0)*func(a0) > 0):
        div = 0
    else:
        div = 1
    
    # aplicando o método iterativo
    if (b0 - a0) > 0:
        i = math.log10(b0 - a0)
    if erro > 0:
        i -= math.log10(erro)
    i /= math.log10(2)

    
    if func(a0) == 0 or func(b0) == 0:
        if func(a0) == 0:
            print('a0 =', a0)
        if func(b0) == 0:
            print('b0 =', b0)

    while erro > 0.0000001:
        while intervalo > erro:
            intervalo = b0 - a0
            m = (a0 + b0) / 2
        if func(m) == 0:
            print('m =', m)
            break
        if func(a0)*func(b0) < 0:
            b0 = m
        else:
            a0 = m

    # resposta
    print(f'[{a0}, {b0}]\n solução: {(a0 + b0)/2}')