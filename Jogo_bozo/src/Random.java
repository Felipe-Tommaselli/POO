import java.util.Calendar;

/**
 * gerador simples de números aleatórios.
 * Todos 
 * @author delamaro
 *
 */

public class Random {
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;
	
	
	private long xi = 1023;

	/**
	 * Retorna um número aleatório no intervalo (0,1[
	 * @return
	 */
	public double getRand() {
		xi = (a + m * xi) % p;
		double d = xi;
		return d / p;
	}
	
	/**
	 * Retorna um valor inteiro no intervalo (0,max[
	 * @param max
	 * @return
	 */
	public int getIntRand(int max)
	{
		double d = getRand() * max;
		
			return (int) d;
	}

	/**
	 * Permite alterar a semente de geração de números aleatórios. 
	 * Supostamente deve ser chamada antes de iniciar a geração, 
	 * mas se for chamado a qualquer instante, reseta o valor da semante
	 * @param semente
	 */
	public void setSemente(int semente) {
        xi = semente;		
	}

	public Random(int k)
	{
		xi = k;
	}
	
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis() % p;
	}
	
	@Override
	public String toString() {
		return xi + "";
	}
	
	static public void main(String args[]) {
		Random rd = new Random();
		Random rd2 = new Random();
		String s = rd.toString();
		System.out.println(rd);
		System.out.println(rd2);
		int k = rd.getIntRand(100);
		System.out.println(rd);

	}
}