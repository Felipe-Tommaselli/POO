# -*- coding: utf-8 -*-

import csv, sys
import os

# * É NECESSÁRIO TER A PASTA 'ASSETS' PARA CONSEGUIR OBTER OS DADOS
path = os.getcwd() + '\\assets\\'
class data:
    def getFiles(dir: str):
        relpath = path + dir
        for file in os.listdir(relpath):
            if os.path.isfile(os.path.join(relpath, file)):
                yield file

    @staticmethod
    def getTurmaList():
        turmas = [list(), list()] # duas turmas
        pos = 0
        for file in data.getFiles(r''):
            with open(path + file, encoding='utf-8') as ficheiro:
                reader = csv.reader(ficheiro)        
                try:
                    for linha in reader:
                        turmas[pos].append(linha)
                except csv.Error as e:
                    sys.exit('ficheiro %s, linha %d: %s' % (file, reader.line_num, e))
            pos += 1
        
        return turmas

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

    @staticmethod
    def getGruposList():
        dirpath = path + r'SSC0103-2022-Definição dos grupos-4240978\\'
        res = list()
        for relpath in os.listdir(dirpath):
            if os.path.isfile(os.path.join(dirpath, relpath)): # check if current path is a file
                res.append(relpath) 

        print(res)
        grupos = [list() for i in range(len(res))]
        pos = 0

        # aporra do arquivo do joa nao ta em utf, mas oresto ta funcionado
        for file in data.getFiles(r'SSC0103-2022-Definição dos grupos-4240978\\'):
            print(file)
            with open(dirpath + file, encoding='utf-8') as ficheiro:
                reader = csv.reader(ficheiro)        
                try:
                    for linha in reader:
                        grupos[pos].append(linha)
                except csv.Error as e:
                    sys.exit('ficheiro %s, linha %d: %s' % (file, reader.line_num, e))
            pos += 1
        
        return grupos


