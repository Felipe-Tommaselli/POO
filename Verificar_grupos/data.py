# -*- coding: utf-8 -*-

import csv, sys
import os

# * É NECESSÁRIO TER A PASTA 'ASSETS' PARA CONSEGUIR OBTER OS DADOS
path = os.getcwd() + '\\assets\\'
class data:

    # * publica o arquivo a partir da lista de diretorios
    def getFiles(dir: str):
        relpath = path + dir
        for file in os.listdir(relpath):
            if os.path.isfile(os.path.join(relpath, file)):
                yield file

    # * para limpar os dados de nome e nusp dos alunos
    def cleanData(s: list):
        s[0] = s[0].strip()
        s[1] = s[1].strip()
        return s

    # * cria uma lista com duas listas dentro, uma com cada aluno e cada turma
    @staticmethod
    def getTurmaList():
        turmas = [list(), list()] # duas turmas
        pos = 0
        for file in data.getFiles(r''):
            with open(path + file, encoding='utf-8') as ficheiro:
                reader = csv.reader(ficheiro)        
                try:
                    for linha in reader:
                        if linha:
                            turmas[pos].append(data.cleanData(linha)) 
                except csv.Error as e:
                    sys.exit('ficheiro %s, linha %d: %s' % (file, reader.line_num, e))
            pos += 1

        grupos = [e for e in turmas if e] # remove turmas vazias
        return turmas

    # * cria uma lista com nusp e nome de todos os alunos separados a partir da lista total para cada turma
    @staticmethod
    def getTurmaInfo():
        turmas = data.getTurmaList()
        
        pos = 0
        nusp  = [list(), list()]
        nomes = [list(), list()]
        for turma in turmas:
            for linha in turma:
                nusp[pos].append(int(linha[0]))
                nomes[pos].append(linha[1])
            pos += 1
        return nusp, nomes

    # * cria uma lista com os grupos disponibilizados (estático)
    @staticmethod
    def getGruposList():
        dirpath = path + r'SSC0103-2022-Definição dos grupos-4240978\\'
        res = list()
        # cria uma lista res com todos os arquivos da pasta (csvs com os grupos)
        for relpath in os.listdir(dirpath):
            if os.path.isfile(os.path.join(dirpath, relpath)): # checa se o path é um arquivo
                res.append(relpath) 

        # lista de grupos com cada posícão sendo um lista de nome e nusp
        grupos = [list() for i in range(len(res))]
        pos = 0

        # abre a pasta definida com cada file dentro dela
        for file in data.getFiles(r'SSC0103-2022-Definição dos grupos-4240978\\'):
            try:
                # abre com decodificação utf-8 cada arquivo csv
                with open(dirpath + file, encoding='utf-8') as ficheiro:
                    # parse do csv para leitura
                    reader = csv.reader(ficheiro)        
                    try:
                        # cada linha é uma pessoa do grupo com nome e nusp
                        for linha in reader:
                            if linha: # checa se linha é vazia
                                if len(linha) > 2: # grupo com todas pessoas em uma unica linha
                                    parsed_list = [linha[i:i + 2] for i in range(0, len(linha), 2)] # quebra a lista de 2 em 2
                                    for pl in parsed_list:
                                        grupos[pos].append(data.cleanData(pl)) # adiciona de um em um
                                else:
                                    grupos[pos].append(data.cleanData(linha)) # adiciona no grupo
                    except csv.Error as e:
                        sys.exit('ficheiro %s, linha %d: %s' % (file, reader.line_num, e)) # erro de leitura do csv 
                pos += 1 # vai para o próximo grupo
            except Exception as e: 
                print('\033[31m' + f'Erro: Não foi possível ler o arquivo {file}, por: \n{e}' + '\033[0;0m')
                grupos[pos].append([None, None])
                pos += 1

        grupos = [e for e in grupos if e] # remove grupos vazios
        return grupos


