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

def func(x):
    return pow(x, 3) - pow(x, 2) - 13*x + 8

if __name__ == '__main__':

    # cabeçalho
    print('EXERCICIO 7: Método da Bisseção\n')
    
    # valdação da entrada 
    a0 = valida_entrada()
    b0 = valida_entrada()

    # com a entrada validada, vamos aplicar o método do bisseção
    xk = a0 # xk, x naquela iteração k
    fxk = func(xk)
    k = 0
    a = a0
    b = b0

    # caso não haja nenhuma raiz dentro do intervalo
    if func(a0) * func(b0) >= 0:
        print("O método da bisseção não consegue achar raizes nesse intervalo")
        fxk = 0.0


    # loop principal
    while abs(fxk) > 0.0000001:

        # atualiza o valor de xk e fxk
        xk = float((a + b)/2)
        fxk = func(xk)

        # condição para achar pelo m. da bisseção
        if func(a)*fxk < 0:
            b = xk
        if func(b)*fxk < 0:
            a = xk
        k += 1

    # resposta
    if(fxk != 0):
        print(f'\n[{a0}, {b0}] solução: {xk}, com valor {func(xk)}')
