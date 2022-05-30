# -*- coding: utf-8 -*-

import csv, sys
import os

# * É NECESSÁRIO TER A PASTA 'ASSETS' PARA CONSEGUIR OBTER OS DADOS
class data:
    @staticmethod
    def getData(nome: str):
        path = os.getcwd() + '\\assets\\'
        file = path + nome

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
    def getInfo(nome: str):
        turma = data.getData(nome)
        
        nomes = list()
        nusp = list()
        for linha in turma:
            nusp.append(int(linha[0]))
            nomes.append(linha[1])

        return nusp, nomes

