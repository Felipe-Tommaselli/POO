from pessoa import *

class pessoaFisica():

    def __init__(self, nome: str, endereco: str, email: str, tel: float, cpf: str, aniv: float, ecivil: str):
        super(self, nome, end, email, tel)
        self.cpf = cpf
        self.aniv = aniv
        self.ecivil = ecivil

    
    # getters
    def getCPF(self):
        return self.cpf
    def getAniv(self):
        return self.aniv
    def getEcivil(self):
        return self.ecivil

    # setters
    def setCPF(self, cpf):
        self.cpf = cpf
    def setAniv(self, aniv):
        self.eniv = aniv
    def setEcivil(self, ecivil):
        self.ecivil = ecivil
