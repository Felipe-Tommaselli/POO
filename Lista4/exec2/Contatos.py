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
            print("ERRO: Pessoa, infelizmente, não encontrada")
        elif pos != -1 and flag == True: # procurar
            print(self.pessoas[pos])
        else: # remover
            del self.pessoas[pos]
            self.num_pessoas -= 1
            print(f'\nPessoa {str(pos)} removida com sucesso')

    def procuraContato(self, chave):
        if isinstance(chave, int):
            for i in range(len(self.pessoas)):
                if len(self.pessoas) == 0:
                    continue
                if isinstance(self.pessoas[i], PessoaFisica):
                    if int(self.pessoas[i].getCPF()) == chave: 
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

    def bubbleSort(self, lista: list, flag: bool):
        for passo in range(len(lista) - 1, 0, -1):
            for k in range(passo):
                if flag == True:
                    if lista[k].getCPF() > lista[k + 1].getCPF():
                        temp = lista[k].getCPF()
                        lista[k].setCPF(lista[k + 1].getCPF())
                        lista[k + 1].setCPF(tempo)
                elif flag == False:
                    if lista[k].getCNPJ() > lista[k + 1].getCNPJ():
                        temp = lista[k].getCNPJ()
                        lista[k].setCNPJ(lista[k + 1].getCNPJ())
                        lista[k + 1].setCNPJ(temp)

    def Ordenar(self):
        Pfisica = list()
        PJuridica = list()
        N1 = 0 # conta pessoas fisicas
        N2 = 0 # conta pessoas juridicas

        for i in range(len(self.pessoas)):
            if len(self.pessoas) == 0:
                continue
            if isinstance(self.pessoas[i], PessoaFisica):
                Pfisica.append(self.pessoas[i])
                N1 += 1
            else:
                PJuridica.append(self.pessoas[i])
                N2 += 1

        self.bubbleSort(Pfisica, True)
        self.bubbleSort(PJuridica, False)

        for i in range(len(Pfisica)):
            self.pessoas[i] = Pfisica[i]
        
        for i in range(len(PJuridica)):
            self.pessoas[i + N1] = PJuridica[i]

        print("Agenda ordenada com sucesso")
        print('\n'.join(map(str, self.pessoas)))