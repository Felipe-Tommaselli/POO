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
    print('EXERCICIO 6: Valores ponto fluante\n')
    
    # validação da entrada passando os resultados para a lista 
    lista = list()
    while(True):
        num = valida_entrada()
        if num == 0:
            break
        lista.append(num)

    # calcula o maior e o menor presentes na lista
    menor = lista[0]
    maior = lista[0]
    for _ in lista:
        if _ < menor:
            menor = _
        if _ > maior:
            maior = _

    # resposta
    print(f'O maior número digitado foi {maior} e o menor {menor}')