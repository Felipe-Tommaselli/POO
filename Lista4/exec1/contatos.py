from pessoa import *
from pessoaFIsica import *
from pessoaJuridica import *
from sys import *

TAM = 1000
class Contatos:

    def __init__(self):
        self.pessoas = list()
        self.num_pessoas = 0

    def cadastrarFisica(self):    
        if num_pessoas > TAM:
            print('Agenda cheia')
            exit()
        
        try:
            print('Cadastrar Pessoa Física\nInserir dados:')
            nome   = input('1. Nome: ')
            end    = input('2. Endereco: ')
            email  = input('3. Email: ')
            tel    = input('4. Telefone: ')
            aniv   = input('5. Aniversario: ')
            ecivil = input('6. Estado civil: ')
            cpf    = input('7. CPF: ')

            if procuraContato(cpf) != 1:
                print('CPF já registrado')

            self.pessoas[num_pessoas] = pessoaFisica(nome, end, email, tel, cpf, aniv, ecivil)
            num_pessoas += 1
        except:
            print('Não foi possível realizar o cadastro')

