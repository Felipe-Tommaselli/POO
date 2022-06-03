from data import *

class verifica:
    turmas = data.getTurmaList()
    nusps, nomes = data.getTurmaInfo()
    grupos = data.getGruposList()
    
    def num_participantes(self):
        for grupo in self.grupos:
            print(grupo)


obj = verifica()
obj.num_participantes()