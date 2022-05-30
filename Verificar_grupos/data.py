# -*- coding: utf-8 -*-

import csv, sys
import os

# * É NECESSÁRIO TER A PASTA 'ASSETS' PARA CONSEGUIR OBTER OS DADOS
path = os.getcwd() + '\\assets\\'
class data:
    def getfiles(dir):
        relpath = path + dir
        for file in os.listdir(relpath):
            if os.path.isfile(os.path.join(relpath, file)):
                yield file
    
    # falta abrir as duas turmas 
    @staticmethod
    def getTurmaList():

        turma = list()
        with open(file, encoding='utf-8') as ficheiro:
            reader = csv.reader(ficheiro)        
            try:
                for linha in reader:
                    turma.append(linha)
            except csv.Error as e:
                sys.exit('ficheiro %s, linha %d: %s' % (file, reader.line_num, e))
        return turma

    @staticmethod
    def getTurmaInfo(fname: str):
        turma = data.getTurmaList(fname)
        
        nomes = list()
        nusp = list()
        for linha in turma:
            nusp.append(int(linha[0]))
            nomes.append(linha[1])
        return nusp, nomes

    @staticmethod
    def getGruposList(fname: str):
        print('hello')


