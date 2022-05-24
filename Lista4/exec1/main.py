from Contatos import *

def main():
    agenda = Contatos()

    while True:

        print("\n========= AGENDA =========")

        print("Selecione a função que deseja executar:")
        print("1) Cadastrar Pessoa Física")
        print("2) Cadastrar Pessoa Jurídica")
        print("3) Buscar por contato existente")
        print("4) Remover contato")
        print("5) Sair")

        modo = int(input())

        if modo == 1:
            agenda.setCPF()
        elif modo == 2:
            agenda.setPJuridica()
        elif modo == 3:
            agenda.procuraPessoa()
        elif modo == 4:
            agenda.retiraPessoa()
        else:
            break

if __name__ == '__main__':
    main()
