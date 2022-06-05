from data import *

# rodar um "pip install unidecode" no terminal
import unidecode

class verificar():

    turmas = data.getTurmaList()
    nusps, nomes = data.getTurmaInfo()
    grupos = data.getGruposList()
    
    def __init__(self):
        self.grp_verif = [False for i in range(len(self.grupos))] 
        self.alunos_sem_grp = list()

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

    # * checa quais grupos possuem numero de participantes correto
    def numParticipantes(self):
        for grupo in self.grupos: # grupo em grupo 
            if len(grupo) == 4:
                self.grp_verif[self.grupos.index(grupo)] = True # grupo tem 4 integrantes
            else:
                self.grp_verif[self.grupos.index(grupo)] = False

    # * separa os grupos com 4 participantes nas duas turmas
    def gruposTurma(self):
        self.numParticipantes()
        grupos4 = [list(), list()]
        gruposInvalidos = [list(), list()]

        for i in range(len(self.grp_verif)): # roda nos grupo verificados
            t = self.procuraTurma(self.grupos[i][0][1]) # procura a turma do aluno 
            if t == -2:
                continue
            try:
                if self.grp_verif[i] == True: # 4 integrantes por grupo
                    grupos4[t].append(self.grupos[i]) # adiciona cada grupo em uma turma
                else:
                    gruposInvalidos[t].append(self.grupos[i])
            except:
                continue

        return grupos4, gruposInvalidos

    # * procura turma (0 ou 1) a partir de um aluno
    def procuraTurma(self, aluno: str):
        if aluno == 'None':
            return -2

        for t in [0, 1]:# turma 1 e 2
            for nome in self.nomes[t]: # aluno em aluno na lista de aluno
                # tratar problemas de nome, como pessoas que não colocam o nome compeleto
                aluno = self.StringParse(aluno)
                nome  = self.StringParse(nome)
                if aluno == nome or aluno in nome or nome in aluno: # checa se o aluno está na turma t
                    return t
        return -1

    # * procura grupo com participante não inscrito na disciplino
    def grupoDeNaoAluno(self):
        naoAlunos = list()
        for grupo in self.grupos: 
            for aluno in grupo: # aluno no grupo 
                t = self.procuraTurma(aluno[1]) # procura o aluno na turma
                if t < 0 and aluno[1] != 'None' and self.grupos.index(grupo) != 12: 
                    # evita caso de erro no arquivo
                    # evita caso viu todas as opcoes
                    naoAlunos.append([aluno, self.grupos.index(grupo)])

        return naoAlunos

    # * pega os grupos que tem integrantes das duas turmas misturadas
    def grupoDuasTurmas(self):
        grupo2turmas = list()
        tlist = list() # lista com as turmas para ver se são todos da mesma turma
        for grupo in self.grupos:
            tlist.clear() # reseta a cada grupo
            for aluno in grupo: 
                t = self.procuraTurma(aluno[1])
                tlist.append(t) # adiciona a turma de cada aluno do grupo
            if tlist.count(tlist[0]) != len(tlist) and tlist.count(-1) == 0: # checa se há elementos 1 e 2 no mesmo grupo
                grupo2turmas.append([grupo, self.grupos.index(grupo)])

        return grupo2turmas

    # * formata strings, tira do utf-8 para comparar com o csv
    def StringParse(self, s: str):
        s = s.lower()
        s = unidecode.unidecode(s)

        return s

veri = verificar()
veri.grupoDuasTurmas()