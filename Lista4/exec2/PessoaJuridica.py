from Pessoa import *

class PessoaJuridica(Pessoa):
    def __init__(self, nome: str, cnpj: int, end: str, iscr: str, email: str, rsocial: str):
        super().__init__(nome, end, email)
        self.cnpj = cnpj
        self.iscr = iscr
        self.rsocial = rsocial
        
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

