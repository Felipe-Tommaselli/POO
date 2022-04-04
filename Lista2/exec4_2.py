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
    print('EXERCICIO 4 (parte 2): Verificador de Primo\n')
    
    # valdação da entrada 
    num = valida_entrada()

    # com num validado, vamos verificar se ele é primo
    bool primo = True
    int i

    # teste de divisão (i guarda o menor divisor comum caso haja)
    for i in range(2, num + 1):
        if num % i == 0:
            primo = False
            break

    # resposta
    if primo == True:
        print(f'O número {num} é primo!')
    else:
        print(f'O número {num} NÃO é primo!')
        print(f'Seu menor divisor é {i}')
