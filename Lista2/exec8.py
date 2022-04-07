'''
 *
 * @author 11800910
'''

# biblioteca da scipy, documentação: https://docs.scipy.org/doc/scipy/
from scipy import misc 

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
    print('EXERCICIO 8: Método de Newton\n')
    
    # valdação da entrada 
    x0 = valida_entrada()
    
    # com a entrada validada, vamos aplicar o método de newton
    xk = x0 # xk, x naquela iteração k
    xr = 0.0 # xr, com r = k - 1, ou seja x na iteração anterior
    i = 0

    # loop principal
    while True:

        # formula do m. de newton
        xr = (xk) - (func(xk)/misc.derivative(func, xk))

        # condição de parada clássica
        if  abs(xr - xk) < 0.0000001:
            break
        
        # atualiza i e xk com o valor de xr (que agr esta ultrapassado)
        xk = xr
        i += 1
    
    # saida
    print(f'\nsolução: {xk}, com valor {func(xk)} na iteração {i}')