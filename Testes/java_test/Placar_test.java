// VS CODE TA MALUCO DANDO UM MONTE DE ERRO, POR ISSO DEIXEI TUDO COMENTADO

// import static org.junit.Assert.*;
// import java.io.IOException;
// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// public class Placar {

// 	private Placar p;
	
// 	@Before
// 	public void testsetUp() throws Exception {
// 		p = new Placar();
// 	}

// 	@After
// 	public void testtearDown() throws Exception {
// 		p = null;
// 	}
	
// 	@Test
// 	public void testAdd() {
// 		for(int i = 0; i < 11; i++){
// 			try {
// 				p.add(i, new int[] {1,2,3,4,5});
// 			} catch (Exception e) {
// 				;
// 			}
// 		}
// 		assertEquals(35, p.getScore());
// 	}

	
// 	@Test
// 	public void testReAdd(){
// 		try {
// 			p.add(1, new int[] {1,2,3,4,5});
// 		} catch (Exception e) {
// 			;
// 		}
// 		try {
// 			p.add(1, new int[] {1,2,3,4,5});
// 		} catch (Exception e) {
// 			;
// 		}
// 	}

// 	@Test
// 	public void testAddInvalidPos() {
// 		try {
// 			p.add(0, new int[] {1,1,1,1,1});
// 		} catch(Exception e) {
// 			;
// 		}
// 		try {
// 			p.add(-1, new int[] {1,2,3,4,5});
// 		} catch(Exception e) {
// 			;
// 		}
// 		try {
// 			p.add(11, new int[] {1,2,3,4,5});
// 		} catch(Exception e) {
// 			;
// 		}
// 	}

	
// 	@Test
// 	public void testAddRepetitions(){
// 		for(int i = 0; i < 11; i++){
// 			try {
// 				p.add(i, new int[] {1,1,1,1,1});
// 			} catch (Exception e) {
// 				;
// 			}
// 		}
// 		assertEquals(90, p.getScore());
// 	}
	
// 	@Test
// 	public void testAddBreais(){
// 		for(int i = 0; i < 11; i++){
// 			try {
// 				p.add(i, new int[] {1,2,1,1,1});
// 			} catch (Exception e) {
// 				;
// 			}
// 		}
// 		assertEquals(36, p.getScore());
// 	}

// 	@Test
// 	public void testGetScoreEmpty() {
// 		int i = p.getScore();
// 		assertEquals(0, i);
// 	}
	
// 	@Test
// 	public void testGetScoreFull() throws IllegalArgumentException, IOException {		
// 		p.add(1, new int[] {1, 1, 1, 1, 1} );
// 		p.add(2, new int[] {2, 2, 2, 2, 2} );
// 		p.add(3, new int[] {3, 3, 3, 3, 3} );
// 		p.add(4, new int[] {4, 4, 4, 4, 4} );
// 		p.add(5, new int[] {5 ,5, 5, 5, 5} );
// 		p.add(6, new int[] {6, 6, 6, 6, 6} );
// 		p.add(7, new int[] {2, 2, 2, 3, 3} );
// 		p.add(8, new int[] {1, 2, 3, 4, 5} );
// 		p.add(9, new int[] {1, 2, 2, 2, 2} );
// 		p.add(10, new int[] {1, 1, 1, 1, 1} );
		
// 		int i = p.getScore();
// 		assertEquals(210, i);
// 	}
	
// 	@Test
// 	public void testGetScoreFailFullHouse() throws IllegalArgumentException, IOException {
// 		p.add(1, new int[] {1, 1, 1, 1, 1} );
// 		p.add(2, new int[] {2, 2, 2, 2, 2} );
// 		p.add(3, new int[] {3, 3, 3, 3, 3} );
// 		p.add(4, new int[] {4, 4, 4, 4, 4} );
// 		p.add(5, new int[] {5 ,5, 5, 5, 5} );
// 		p.add(6, new int[] {6, 6, 6, 6, 6} );
// 		p.add(7, new int[] {3, 3, 1, 2, 2} );
// 		p.add(8, new int[] {2, 3, 4, 5, 6} );
// 		p.add(9, new int[] {1, 3, 2, 2, 2} );
// 		p.add(10, new int[] {1, 2, 1, 1, 1} );
		
// 		int i = p.getScore();
// 		assertEquals(125, i);
// 	}
	
// 	@Test
// 	public void testGetScoreCC() throws IllegalArgumentException, IOException {
// 		p.add(1, new int[] {1, 1, 1, 1, 1} );
// 		p.add(2, new int[] {2, 2, 2, 2, 2} );
// 		p.add(3, new int[] {3, 3, 3, 3, 3} );
// 		p.add(4, new int[] {4, 4, 4, 4, 4} );
// 		p.add(5, new int[] {5 ,5, 5, 5, 5} );
// 		p.add(6, new int[] {6, 6, 6, 6, 6} );
// 		p.add(7, new int[] {3, 3, 1, 2, 2} );
// 		p.add(8, new int[] {2, 3, 5, 5, 6} );
// 		p.add(9, new int[] {1, 3, 2, 2, 2} );
// 		p.add(10, new int[] {1, 2, 1, 1, 1} );
		
// 		int i = p.getScore();
// 		assertEquals(105, i);
// 	}
	

// 	@Test
// 	public void testtoStringNull() throws IllegalArgumentException, IOException {
// 		String str = "";
		
// 		str +=("  (1)  |");
// 		str += ("  (7)  |");
// 		str += ("  (4)  |");
		
// 		str += '\n';
// 		str += ("------------------------\n");
		
// 		str +=("  (2)  |");
// 		str +=("  (8)  |");
// 		str +=("  (5)  |");
		
// 		str += '\n';
// 		str += ("------------------------\n");
		
// 		str += ("  (3)  |");
// 		str += ("  (9)  |");
// 		str += ("  (6)  |");
		
// 		str += '\n';
// 		str +=("------------------------\n");
		
// 		str += ("       |  (10) |         ");
		
// 		str +='\n';
// 		str +=("       x-------x        \n");
		
// 		assertEquals(p.toString(), str);
// 	}

// 	@Test
// 	public void testGetScoreCasosRestantes2() throws IllegalArgumentException, IOException {
// 		p.add(1, new int[] {1, 1, 1, 1, 1} );
// 		p.add(1, new int[] {1, 2, 2, 2, 2} );
// 	}

// 	@Test
// 	public void testToString() {
// 		p.toString();
// 	}
	
// 	@Test
// 	public void testToStringWithValues(){
// 		String str = "";
		
// 		p.add(1, new int[] {1, 2, 3, 4, 5} );
// 		p.add(2, new int[] {1, 2, 3, 4, 5} );
// 		p.add(3, new int[] {1, 2, 3, 4, 5} );
// 		p.add(4, new int[] {1, 2, 3, 4, 5} );
// 		p.add(5, new int[] {1, 2, 3, 4, 5} );
// 		p.add(6, new int[] {1, 2, 3, 4, 5} );
// 		p.add(7, new int[] {1, 2, 3, 4, 5} );
// 		p.add(8, new int[] {1, 2, 3, 4, 5} );
// 		p.add(9, new int[] {1, 2, 3, 4, 5} );
// 		p.add(10, new int[] {1, 2, 3, 4, 5} );
		
// 		str += ("   " + p.placar[0] + "   |");
// 		str += ("  " + p.placar[6] + "   |");
// 		str += ("  " + p.placar[3] + "   |");
		
// 		str += '\n';
// 		str += ("------------------------\n");
		
// 		str += ("   " + p.placar[1] + "   |");
// 		str += ("  " + p.placar[7] + "   |");
// 		str += ("  " + p.placar[4] + "   |");
		
// 		str += '\n';
// 		str += ("------------------------\n");
		
// 		str += ("  " + p.placar[2] + "   |");
// 		str += ("  " + p.placar[8] + "   |");
// 		str += ("  " + p.placar[5] + "   |");
		
// 		str += '\n';
// 		str +=("------------------------\n");
		
// 		str += ("       |"  + "  " + p.placar[9] + "   " +  "|   ");
		
// 		str +='\n';
// 		str +=("       x-------x        \n");
		
// 		assertEquals(p.toString(), str);
// 	}
	

// }