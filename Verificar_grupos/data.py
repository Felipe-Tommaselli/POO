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

    def cleanData(s: list):
        s[0] = s[0].strip()
        s[1] = s[1].strip()
        return s

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

        grupos = [e for e in turmas if e] # remove turmas vazios
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

        grupos = [list() for i in range(len(res))]
        pos = 0

        for file in data.getFiles(r'SSC0103-2022-Definição dos grupos-4240978\\'):
            try:
                with open(dirpath + file, encoding='utf-8') as ficheiro:
                    reader = csv.reader(ficheiro)        
                    try:
                        for linha in reader:
                            if linha: # checa se linha é vazia
                                if len(linha) > 2:
                                    parsed_list = [linha[i:i + 2] for i in range(0, len(linha), 2)] # quebra a lista de 2 em 2
                                    for pl in parsed_list:
                                        grupos[pos].append(data.cleanData(pl))
                                
                                grupos[pos].append(data.cleanData(linha))
                    except csv.Error as e:
                        sys.exit('ficheiro %s, linha %d: %s' % (file, reader.line_num, e))
                pos += 1
            except Exception as e:
                print('\033[31m' + f'Erro: Não foi possível ler o arquivo {file}, por: \n{e}' + '\033[0;0m')

        grupos = [e for e in grupos if e] # remove grupos vazios
        return grupos


