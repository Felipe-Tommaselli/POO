from Contatos import *

def main():
    agenda = Contatos()

    while True:

        print('\033[31m' + '===========  AGENDA  ===========' + '\033[0;0m')  

        print("Seleione um modo:")
        print("1) Cadastrar Pessoa Física")
        print("2) Cadastrar Pessoa Jurídica")
        print("3) Buscar por contato existente")
        print("4) Remover contato")
        print("5) Ordenar")
        print("6) Sair\n")

        modo = int(input('>> '))
        if  modo == 1:
            agenda.PFisica()
        elif modo == 2:
            agenda.PJuridica()
        elif modo == 3:
            agenda.Proc_Rem_Pessoa(True) # procurar
        elif modo == 4:
            agenda.Proc_Rem_Pessoa(False) # remover
        elif modo == 5:
            agenda.Ordenar()
        else:
            break

if __name__ == '__main__':
    main()
