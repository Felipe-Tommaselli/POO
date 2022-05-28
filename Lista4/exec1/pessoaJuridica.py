from Pessoa import *

class PessoaJuridica(Pessoa):
    def __init__(self, nome: str, cnpj: int, end: str, iscr: str, email: str, rsocial: str):
        super().__init__(nome, end, email)
        self.cnpj = cnpj
        self.iscr = iscr
        self.rsocial = rsocial

    def __str__(self):
        s = '\nTipo: Pessoa Juridica\n'
        s += "Nome: " + str(self.getNome()) + "\n"
        s += "Endereço: " + str(self.getend()) + "\n"
        s += "Email: " + str(self.getEmail()) + "\n"
        s += "Razão Social: " + str(self.getrsocial()) + "\n"
        s += "Inscriçaõ estadual: " + str(self.getiscr()) + "\n"
        s += "CNPJ: " + str(self.getCNPJ()) + "\n"
        return s

    def getCNPJ(self):
        return self.cnpj
    def getiscr(self):
        return self.iscr
    def getrsocial(self):
        return self.rsocial
    
    def setCNPJ(self, cnpj):
        self.cnpj = cnpj
    def setiscr(self, iscr):
        self.iscr = iscr
    def setrsocial(self, rsocial):
        self.rsocial = rsocial

