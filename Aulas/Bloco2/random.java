
//SEI LA TAMBEM, SO PARA ANOTAR OS PSEUDOCODIGOS

public class random {
    // atributos
    private long p = 2147483648L;
    private long m = 843314861;
    private long a = 453816693;

    private long xi = 1023; // semente

}


public double getRand() {
    // calcua o prox valor xi
    // calcula valor entre 0 e 1 dividndo por p
    xi = (a + m*xi);
    double d = xi;
    return d/p;
}

public int getIntRand(int max) {

    double d = getRand() * max;
    return (int) d;
}

