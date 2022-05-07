import Cartas as cartas
import time

class AbreCartas:

	def __init__(self, n = 5):
		self.cartas = list()
		for i in range(n):
			self.cartas.append(cartas.Cartas())
			time.sleep(0.5)
			
	def __str__(self):
		st = ''
		for i in range(5):
			base = i * 8
			for carta in self.cartas:
				p = str(carta)
				st += p[base:base+7] +  "   "
			st += '\n'
		return st
	
    # código inspirado na implementação do bozó, uma vez que a utilidade é
    # semelhante para essa implementação, com as devidas mudanças
	def abrir(self, l = []):
		# lista com os elementos a serem trocados, tipo:
		# 1, 4, 5 -> [True, False, False, True, True]
		if len(l) == 0:
			pl = len(self.cartas) * [True]
		else:
			pl = len(self.cartas) * [False]
		for i in l:
			if i >= 0 and i < len(self.cartas) + 1:
				pl[i- 1] = True
		# retorna quais dados devem ser alterados
		return self.abrir_boolean(pl)

	# troca os dados retornados acima
	# [True, False, False, True, True] -> trocar 1, 4 e 5
	def abrir_boolean(self, quais = []):
		print(quais)
		aux = []
		i = 0
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
	print('jogo:\n', jogo)
	print('jogo.abrir()', jogo.abrir())