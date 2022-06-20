import unittest as ut
from Placar import Placar

class TestePlacar(ut.TestCase):

    def testPlacar(self):
        p = Placar()
        p.add(3, [3,3,3,3,3])
        print(p)

    def testgetName(self):
        p = Placar()
        self.assertEqual("Ones", self.p.getName(0))

    def testcheckfull(self):
        p = Placar()
        p.add(1, [1,1,1,1,1])
        p.add(2, [2,2,2,2,2])
        p.add(3, [3,3,3,3,3])
        p.add(4, [4,4,4,4,4])
        p.add(5, [5,5,5,5,5])
        p.add(6, [6,6,6,6,6])
        p.add(7, [2,2,2,3,3])
        p.add(8, [1,2,3,4,5])
        p.add(9, [2,2,2,2,2])
        p.add(10, [1,1,1,1,1])

        k = p.getScore()
        self.assertEqual(210, k)

    def testcheckFailfull(self):
        p = Placar()
        p.add(1, [1,1,1,1,1])
        p.add(2, [2,2,2,2,2])
        p.add(3, [3,3,3,3,3])
        p.add(4, [4,4,4,4,4])
        p.add(5, [5,5,5,5,5])
        p.add(6, [6,6,6,6,6])
        p.add(7, [3,3,1,2,2])
        p.add(8, [2,3,4,5,6])
        p.add(9, [1,2,2,2,2])
        p.add(10, [1,2,1,1,1])

        j = p.getScore()
        self.assertEqual(125, j)

    def testcheckCC(self):
        p = Placar()
        p.add(1, [1,1,1,1,1])
        p.add(2, [2,2,2,2,2])
        p.add(3, [3,3,3,3,3])
        p.add(4, [4,4,4,4,4])
        p.add(5, [5,5,5,5,5])
        p.add(6, [6,6,6,6,6])
        p.add(7, [3,3,1,2,2])
        p.add(8, [2,3,5,5,6])
        p.add(9, [1,3,2,2,2])
        p.add(10, [1,2,1,1,1])

        k = p.getScore()
        self.assertEqual(125, k)


    def testGetScoreVazio(self):
        p = Placar()
        k = p.getScore()
        self.assertEqual(k, 1)


    def testAddPosInvalida(self):
        p = Placar()
        self.assertRaises(IndexError, p.add,  0, [1,1,1,1,1])
        self.assertRaises(IndexError, p.add, -1, [1,1,1,1,1])
        self.assertRaises(IndexError, p.add, 11, [1,1,1,1,1])

    def testAddPosOcupada(self):
        p = Placar()
        p.add(1, [1,2,3,4,5])
        self.assertRaisesRegex(ValueError, "ocupada", p.add, 1, [1,1,1,1,1])


if __name__ == '__main__':
    ut.main()