from data import *

class verificar():

    turmas = data.getTurmaList()
    nusps, nomes = data.getTurmaInfo()
    grupos = data.getGruposList()
    
    def __init__(self):
        self.grp_verif = [False for i in range(len(self.grupos))] 
        self.alunos_sem_grp = list()

    # * checa quais grupos possuem numero de participantes correto
    def numParticipantes(self):
        for grupo in self.grupos: # grupo em grupo 
            if len(grupo) == 4:
                self.grp_verif[self.grupos.index(grupo)] = True # grupo tem 4 integrantes
            else:
                self.grp_verif[self.grupos.index(grupo)] = False
        print(self.grp_verif)

    # * checa quais alunos estão sem grupo
    def alunosSemGrupo(self):
        for t in [0, 1]:# turma 1 e 2
            conta = [False for i in range(len(self.nomes[t]))]
            for aluno in self.nomes[t]: # aluno em aluno na lista de aluno
                for grupo in self.grupos: # grupo em grupo na lista de grupos
                    for i in range(len(grupo)): # participante por participante em cada grupo
                        if aluno == grupo[i][1]: # checa se o aluno está em algum grupo
                            conta[self.nomes[t].index(aluno)] = True
            
            for pos in range(len(conta)): # roda o vetor bool conta
                if conta[pos] == False: # checa se o aluno não foi encontrado em nenhum grupo
                    self.alunos_sem_grp.append(self.turmas[t][pos]) # adiciona ele na lista 
        
        return self.alunos_sem_grp

    def gruposTurma(self):
        grupos4 = [list(), list()]
        for i in len(self.alunos_sem_grp): # roda nos grupo verificados
            if self.alunos_sem_grp[i] == True: # 4 integrantes por grupo
                t = procuraTurma(self.grupos[i]) 
                grupos4[t].append1(self.grupos[i])


        print(grupos4)

    def procuraTurma(self, aluno: str):
        for t in [0, 1]:# turma 1 e 2
            for nome in self.nomes[t]: # aluno em aluno na lista de aluno
                for grupo in self.grupos: # grupo em grupo na lista de grupos
                    for i in range(len(grupo)): # participante por participante em cada grupo
                        if aluno == grupo[i][1]: # checa se o aluno está em algum grupo
                            return t

        return -1