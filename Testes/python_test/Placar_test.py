import unittest as ut
from Placar import Placar

class TestePlacar(ut.TestCase):
    def testPlacar(self):
        p = Placar()
        p.add(3, [3,3,3,3,3])
        print(p)

    def testGetScoreVazio(self):
        pl = Placar()
        k = pl.getScore()
        self.assertEqual(k, 1)

    def testAddPosInvalida(self):
        pl = Placar()
        self.assertRaises(IndexError, pl.add, 0, [1,1,1,1,1])

    def testAddPosOcupada(self):
        pl = Placar()
        pl.add(1, [1,2,3,4,5])
        self.assertRaisesRegex(ValueError, "ocupada", pl.add, 1, [1,1,1,1,1])


if __name__ == '__main__':
    ut.main()