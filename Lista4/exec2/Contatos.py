from Pessoa import *
from PessoaFisica import *
from PessoaJuridica import *
from sys import *

TAM = 2000
class Contatos():
    def __init__(self):
        self.pessoas = list()
        self.num_pessoas = 0
    
    def setCPF(self):
        if self.num_pessoas == (TAM - 1):
            print("** AVISO **\nAgenda de contatos cheia!")
            return
        
        try:
            print('Cadastrar Pessoa Física\n')
            nome = input('nome:')

            pos = self.procuraContato(nome)

            if pos != -1:
                return ('\nJá existe um registro com este nome!')
                
            end = input('endereco: ')
            email = input('e-mail: ')
            aniv = input('aniversario: ')
            ciestado = input('estado civil: ')
            cpf = input('CPF: ')

            self.pessoas[self.num_pessoas] = PessoaFisica(nome, cpf, end, aniv, email, ciestado)
            print(self.pessoas)
            num_pessoas += 1

        except:
            print("Infelizmente, não foi possível realizar o cadastro")

    def procuraPessoa(self):
        print("chave de busca: ")
        
        pos = -1
        try:
            ct = input()
        except:
            print("** AVISO **\nInfelizmente, não foi possível ler a chave!")

        try:
            pos = self.procuraContato(int(ct))
        except:
            pos = self.procuraContato(ct)

        if pos == -1:
            return ("** AVISO **\n Pessoa Infelizmente, não encontrada")

        pessoa = self.pessoas[pos]
        self.imprimirContato(pessoa)

    def retiraPessoa(self):
        print("chave de busca: ")

        pos = -1

        try:
            ct = input()
        except:
            print("** AVISO **\nInfelizmente, não foi possível ler a chave!")
        
        try:
            pos = self.procuraContato(int(ct))
        except:
            pos = self.procuraContato(ct)

        if pos == -1:
            return ("** AVISO **\n Pessoa Infelizmente, não encontrada")

        for pos in range(self.num_pessoas):
            self.pessoas[pos] = self.pessoas[pos + 1]
            
        self.num_pessoas -= 1
            

    def setPJuridica(self):
        if self.num_pessoas == (TAM - 1):
            print("** AVISO **\nAgenda de contatos cheia!")
            return
        
        try:
            print('Cadastrar Pessoa Jurídica\n')
            nome = input('nome:')

            pos = self.procuraContato(nome)

            if pos != -1:
                return ('\nJá existe um registro com este nome!')
                
            end = input('endereco: ')
            email = input('e-mail: ')
            iscr = input('inscrição estadual: ')
            rsocial = input('razão social: ')
            cnpj = int(input('CNPJ: '))

            self.pessoas[self.num_pessoas] = PessoaJuridica(nome, cnpj, end, iscr, email, rsocial)
            num_pessoas += 1

        except:
            print("Infelizmente, não foi possível realizar o cadastro")

    def imprimirContato(self):
        if isinstance(self.pessoa, PessoaFisica):
            print(PessoaFisica(self.pessoa))
        else:
            print(PessoaJuridica(self.pessoa))

    def imprimirContatos(self):
        for i in range(self.num_pessoas):
            if self.pessoas:
                self.imprimirContato(self.pessoas[i])
            else:
                pass

    def procuraContato(self, nome):
        for i in range(self.num_pessoas):
            if self.pessoas:
                self.pessoas[i].getnome() is nome
            else:
                pass
    
    def procuraContato(self, num):
        for i in range(self.num_pessoas):
            if self.pessoas:
                if isinstance(self.pessoa, PessoaFisica):
                    self.pessoas[i] = self.PessoaFisica() 
                    if(self.pessoas[i].getCPF() == num):
                        return i
                else:
                    self.pessoas[i] = self.PessoaJuridica()
                    if(self.pessoas[i].getCNPJ() == num):
                        return i
        return -1

            
    def ordena(self):
        self.ga1 = list(TAM)
        pos1 = 0
        self.ga2 = list(TAM)
        pos2 = 0
        for i in range(self.num_pessoas):
            if isinstance(self.pessoa[i], PessoaFisica):
                pf[pos1] = self.pessoas[i]
                pos2 += 1
            else:
                pos1[nj] = self.pessoas[i]
                pos2 += 1
        sorted(self.ga1)
        sorted(self.ga2)
        self.imprimirContato()