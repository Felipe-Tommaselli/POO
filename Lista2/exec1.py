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

def raiz_quadrada():
    

if __name__ == '__main__':

    # cabeçalho
    print('EXERCICIO 1: RAIZ QUADRADA\n')
    
    # valdação da entrada 
    num = valida_entrada()

    # com num validado, vamos calcular a raiz
    xi = 0
    xi_1 = num/2 
    erro = None

    # fórmula iterativa da raiz quadrada com erro do enunciado
    while erro > 0.00000001:
        xi = (xi_1 + (num/xi_1))/2
        erro = xi - xi_1
        if erro < 0:
            erro *= -1
        xi_1 = xi

    # resultado
    print(f'"A raiz quadrada de {num} é {xi}')