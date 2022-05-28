from Pessoa import *

class PessoaFisica(Pessoa):
    def __init__(self, nome: str, cpf: int, end: str, aniv: str, email: str, ciestado: str):
        super().__init__(nome, end, email)
        self.cpf = cpf
        self.aniv = aniv
        self.ciestado = ciestado
        

    def __str__(self):
        s = '\nTipo: Pessoa Fisica\n'
        s += "Nome: " + str(self.getNome()) + "\n"
        s += "Endereço: " + str(self.getend()) + "\n"
        s += "Email: " + str(self.getEmail()) + "\n"
        s += "Aniversário: " + str(self.getaniv()) + "\n"
        s += "Estado Civil: " + str(self.getciestado()) + "\n"
        s += "CPF: " + str(self.getCPF()) + "\n"
        return s

    def getCPF(self):
        return self.cpf

    def getaniv(self):
        return self.aniv

    def getciestado(self):
        return self.ciestado
    
    def setCPF(self, cpf):
        self.cpf = cpf

    def setaAniv(self, aniv):
        self.aniv = aniv

    def setciestado(self, ciestado):
        self.ciestado = ciestado
    
