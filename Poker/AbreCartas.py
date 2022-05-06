import Cartas as cartas
import time

class AbreCartas:

	def __init__(self, n = 5):
		self.cartas = list()
		for i in range(n):
			self.cartas.append(cartas.Cartas())
			time.sleep(0.5)
			
	def __str__(self):
		s = ''
		for i in range(5):
			base = i * 8
			for d in self.cartas:
				p = str(d)
				s += p[base:base+7]
				s += "   "
			s += '\n'
		return s
	
	def abrir(self, s = None):
		if s == None:
			r = []
			b = len(self.cartas) * [True]
		else:
			r = s.split()
			b = len(self.cartas) * [False]
		for k in r:
			try:
				i = int(k) - 1
			except ValueError :
				i = -1
			if i >= 0 and i < len(self.cartas):
				b[i] = True
		return self.abrir_boolean(b)

	def abrir_boolean(self, quais = []):
		r = []
		i = 0
		for b in quais:
			if i >= len(self.cartas):
				break
			if b:
				self.cartas[i].sortear()
			r.append(self.cartas[i].getValor()[0])
			i += 1
		return r
	
if __name__ == '__main__':
	jogo = AbreCartas()
	print('jogo:\n', jogo)
	print('jogo.abrir()', jogo.abrir())
	print(jogo)
	jogo = AbreCartas(3)
	print(jogo)
	jogo = AbreCartas(7)
	print(jogo)