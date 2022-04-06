'''
 *
 * @author 11800910
'''

# link calc num: https://github.com/Felipe-Tommaselli/Calculo-numerico/blob/main/Trabalho1/Codigos/bisse%C3%A7%C3%A3o.py

import math

def valida_entrada():
    while(True):
        try:
            num = int(input('Digite um inteiro: '))
            break
        except ValueError:
            print('O valor que vc digitou não é um número inteiro')
    return num

def func(x):
    return pow(x, 3) - pow(x, 2) - 13*x + 8

'''
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

    while erro > 0.0000001 and intervalo > erro:
        intervalo = b0 - a0
        m = (a0 + b0) / 2
        if func(m) == 0:
            print('m =', m)
            break
        if func(a0)*func(b0) < 0:
            b0 = m
        else:
            a0 = m
        # ele nao entra no loop pq nao atualiza o erro
        
    
    # resposta
    print(f'\n[{a0}, {b0}] solução: {(a0 + b0)/2}')
'''

# tentativa minha
if __name__ == '__main__':

    # cabeçalho
    print('EXERCICIO 7: Método da Bisseção\n')
    
    # valdação da entrada 
    a0 = valida_entrada()
    b0 = valida_entrada()

    # com a entrada validada, vamos aplicar o método do bisseção
    erro = 0.0
    xk = a0 # xk, x naquela iteração
    xr = 0.0 # xr, x na iteração anterior, tal que r = k - 1
    k = 0
    a = a0
    b = b0

    while abs(xk - xr) > 0.0000001 and func(xk) != 0:

        # guarda o valor de xk e atualiza xk
        xr = xk
        xk = float((a + b)/2)
        fxk = func(xk)

        # condição para achar o ponto de valor negativo para inciar o m. da bisseção
        if func(a)*fxk < 0:
            b = xk
        if func(b)*fxk < 0:
            a = xk
        k += 1

        print(f'>>>>>> {k}')

        print(f'xr = {xr}, xk = {xk}, k = {k}, erro = {erro}')
        print(f'fa0 = {func(a)}, fb0 = {func(b)}, fxk = {func(xk)}, fxr = {func(xr)},')

    # resposta
    print(f'\n[{a0}, {b0}] solução: {xk}, com valor {func(xk)}')