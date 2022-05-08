import Cartas as cartas
import time

'''
* Programa como objetivo de abrir as cartas pedidas pelo jogo
* Além disso, a ideia de receber parametros nas funções da classe
* garante que seja possível tanto abrir as cartas pela primeira vez,
* quanto trocar algumas pedidas pelo usuário
* @author: 11800910
'''

class AbreCartas:

	# construtor que cria o jogo de 5 cartas 
	def __init__(self, n = 5):
		self.cartas = list()
		self.cartasList = list()
		# cria 5 cartas
		for i in range(n):
			# obj é uma carta propriamente dita
			obj = cartas.Cartas()
			# adiciona os valores na cartasList
			# assim, esses valores podem ser acessados facilmente pela main
			self.cartasList.append(obj.valor_att)
			# passa a carta todapara a lista cartas 
			# essa lista será usada nesse programa, não na main
			self.cartas.append(obj)

	# define a representação string, análogo ao feito no Bozó
	def __str__(self):
		st = ''
		# arruma a formataçaõp entre uma carta e outra com os espaçozinhos
		for i in range(5):
			base = i * 8
			for carta in self.cartas:
				p = str(carta)
				st += p[base:base+7] +  "   "
			st += '\n'
		return st
	
    # código que abre as cartas, se ele receber uma lista "l", ele 
	# abrirá apenas essas cartas (utilizado para a troca de cartas pedida
	# pelo usuário), de resto ele abre todas por padrão
	def abrir(self, l = []):
		# lista com os elementos a serem trocados (se houverem), tipo:
		# 1, 4, 5 -> [True, False, False, True, True]
		if len(l) == 0:
			pl = len(self.cartas)*[True]
		else:
			pl = len(self.cartas)*[False]
		for i in l:
			if i >= 0 and i < len(self.cartas) + 1:
				pl[i- 1] = True
		# retorna quais dados devem ser alterados
		return self.abrir_boolean(pl)

	# troca os dados retornados acima
	# [True, False, False, True, True] -> trocar 1, 4 e 5
	def abrir_boolean(self, quais = []):
		aux = []
		i = 0
		# rodar todas as cartas pedidas para serem trocadas e 
		# sortear um novo valor e naipe para ela
		for q in quais:
			if i > len(self.cartas):
				break
			if q:
				self.cartas[i].sortear()
			aux.append(self.cartas[i].getValor()[0])
			i += 1
		return aux


	
if __name__ == '__main__':
	jogo = AbreCartas()
	# diferença de jogo e jogo.abrir()
	print('jogo:\n', jogo)
	print('jogo.abrir()', jogo.abrir())