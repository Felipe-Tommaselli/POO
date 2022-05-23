class pessoa():

    def __init__(self, nome: str, endereco: str, email: str, tel: float):
        self.nome = nome
        self.end = endereco
        self.email = email
        self.tel = telefone


    # getters
    def getNome(self):
        return self.nome
    def getEnd(self):
        return self.end
    def getEmail(self):
        return self.email
    def getTel(self):
        return self.tel

    # setters
    def setNome(self, nome_):
        self.nome = nome_
    def setEnd(self, end_):
        self.end = end_
    def setEmail(self, email_):
        self.email = email_
    def setTel(self, tel_):
        self.tel = tel_