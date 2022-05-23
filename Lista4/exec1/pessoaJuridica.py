from pessoa import *

class pessoaJuridica():

    def __init__(self, nome: str, endereco: str, email: str, tel: float, cpnj: str, iestadual: float, rsocial: str):
        super(self, nome, end, email, tel)
        self.cpnj = cpnj
        self.iestadual = iestadual
        self.rsocial = rsocial

    
    # getters
    def getCpnj(self):
        return self.cpnj
    def getIestadual(self):
        return self.iestadual
    def getRsocial(self):
        return self.rsocial

    # setters
    def setCpnj(self, cpnj):
        self.cpnj = cpnj
    def setIestadual(self, iestadual):
        self.eniv = iestadual
    def setRsocial(self, rsocial):
        self.rsocial = rsocial
