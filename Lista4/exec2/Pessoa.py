class Pessoa():
    def __init__(self, nome: str, end: str, email: str):
        self.nome = nome
        self.end = end
        self.email = email
        
    def genNome(self):
        return self.nome

    def getend(self):
        return self.end

    def getEmail(self):
        return self.email

    
    def setnome(self, nome):
        self.nome = nome

    def setend(self, end):
        self.end = end

    def setEmail(self, email):
        self.email = email

