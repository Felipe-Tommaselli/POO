from Contatos import *

def main():
    agenda2 = Contatos()

    while True:

        print("\n========= AGENDA2 =========")

        print("Selecione a função que deseja executar:")
        print("1) Cadastrar Pessoa Física")
        print("2) Cadastrar Pessoa Jurídica")
        print("3) Buscar por contato existente")
        print("4) Remover contato")
        print("5) Ordenar")
        print("6) Sair")

        modo = int(input())

        if modo == 1:
            agenda2.setCPF()
        elif modo == 2:
            agenda2.setPJuridica()
        elif modo == 3:
            agenda2.procuraPessoa()
        elif modo == 4:
            agenda2.retiraPessoa()
        elif modo == 5:
            agenda2.ordena()
        else:
            break

if __name__ == '__main__':
    main()
