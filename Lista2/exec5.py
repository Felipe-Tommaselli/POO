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
    print('EXERCICIO 5: Primeiro primo menor\n')
    
    # valdação da entrada 
    num = valida_entrada()

    # com num validado, vamos procurar o proximo menor num
    primo = True
    menor_primo = num

    # loop indo de num a 0 procurando um primo
    while menor_primo > 0:
        # teste de numero primo
        primo = True
        for i in range(2, menor_primo):
            if (menor_primo % i) == 0:
                primo = False
                break
        if primo == True:
            break
        menor_primo -= 1

    # resposta
    print(f'O primeiro menor primo depois de {num} é {menor_primo}')