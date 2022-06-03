from data import *

class verifica:
    turmas = data.getTurmaList()
    nusps, nomes = data.getTurmaInfo()
    grupos = data.getGruposList()
    
    def __init__(self):
        self.grp_verif = [False for i in range(len(self.grupos))] 
        self.alunos_sem_grp = list()

    def numParticipantes(self):
        for grupo in self.grupos:
            if len(grupo) == 4:
                self.grp_verif[self.grupos.index(grupo)] = True
            else:
                self.grp_verif[self.grupos.index(grupo)] = False
        print(self.grp_verif)

    def alunosSemGrupo(self):
        conta = [False for i in range(len(self.nomes[0]))]
        for aluno in self.nomes[0]: # aluno em aluno na lista de aluno
            for grupo in self.grupos: # grupo em grupo na lista de grupos
                for i in range(len(grupo)): # participante por participante em cada grupo
                    if aluno == grupo[i][1]: # checa se o aluno está em algum grupo
                        conta[self.nomes[0].index(aluno)] = True
        
        for pos in range(len(conta)): # roda o vetor bool conta
            if conta[pos] == False: # checa se o aluno não foi encontrado em nenhum grupo
                self.alunos_sem_grp.append(self.turmas[0][pos]) # adiciona ele na lista 

obj = verifica()
obj.numParticipantes()
obj.alunosSemGrupo()