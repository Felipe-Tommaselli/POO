from Pessoa import *
from PessoaFisica import *
from PessoaJuridica import *

TAM = 1000
class Contatos():
    def __init__(self):
        self.pessoas = list()
        self.num_pessoas = 0
    
    def PFisica(self):
        if self.num_pessoas == (TAM - 1):
            print("AVISO\nAgenda de contatos cheia!")
            return
        
        try:
            print('\033[32m' + "\nCadastrar Pessoa Física\n".upper() + '\033[0;0m')

            nome        = input('nome:')

            if self.procuraContato(nome) != -1:
                return ('\nNome já registrado!')
            else:
                end      =    input('endereco: ')
                email    = input('e-mail: ')
                aniv     = input('aniversario: ')
                ciestado = input('estado civil: ')
                cpf      = input('CPF: ')

                self.pessoas.append(PessoaFisica(nome, cpf, end, aniv, email, ciestado))
                self.num_pessoas += 1

        except Exception as e:
            print("Infelizmente, não foi possível realizar o cadastro")
            print(f'Erro: {e}')

    def PJuridica(self):
        if self.num_pessoas == (TAM - 1):
            print(" AVISO \nAgenda de contatos cheia!")
            return

        try:
            print('\033[32m' + "\nCadastrar Pessoa Juridica\n".upper() + '\033[0;0m')
            nome        = input('nome:')

            if self.procuraContato(nome) != -1:
                return ('\nNome já registrado!')
            else:
                end     = input('endereco: ')
                email   = input('e-mail: ')
                iscr    = input('inscrição estadual: ')
                rsocial = input('razão social: ')
                cnpj    = int(input('CNPJ: '))

                self.pessoas.append(PessoaJuridica(nome, cnpj, end, iscr, email, rsocial))
                self.num_pessoas += 1   

        except Exception as e:
            print("Infelizmente, não foi possível realizar o cadastro")
            print(f'Erro: {e}')


    def imprimirContatos(self):
        for pessoa in self.pessoas:
            if len(self.pessoas) == 0:
                continue
            else:
                print(pessoa)

    def Proc_Rem_Pessoa(self, flag: bool): # procura ou remove a pessoa
        # flag = False, remover
        # flag = True , procurar
        print("Nome, CPF ou CNPJ para busca: ")        
        pos = -1
        try:
            cb = input()
        except:
            print("Erro: {e}")

        try:
            pos = self.procuraContato(int(cb))
        except:
            pos = self.procuraContato(cb)

        if pos == -1:
            return (" AVISO \n Pessoa Infelizmente, não encontrada")
        elif pos != -1 and flag == True: # procurar
            self.imprimirContatos(self.pessoas[pos])
        else: # remover
            for pos in range(len(self.pessoas)):
                self.pessoas.pop(pos)
            self.num_pessoas -= 1

        pessoa = self.pessoas[pos]
        self.imprimirContato(pessoa)

    def procuraContato(self, chave):
        if type(chave) == 'int':
            for i in range(len(self.pessoas)):
                if len(self.pessoas) == 0:
                    continue
                if isinstance(self.pessoas[i], PessoaFisica):
                    if self.pessoas[i].getCPF() == chave: 
                        return i
                else: 
                    if self.pessoas[i].getCNPJ() == chave:
                        return i
            return -1
        else: 
            for i in range(self.num_pessoas):
                if len(self.pessoas) == 0:
                    continue
                else:
                    if self.pessoas[i].getNome() == chave:
                        print('\n')
                        return i
            return -1
