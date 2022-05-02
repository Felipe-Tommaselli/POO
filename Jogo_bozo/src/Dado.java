

/**
 * Simula um dado de número de lados variados. Ao criar o objeto é possível estabelecer o número de lados. 
 * A rolagem do dado é feita por meio de um gerador de números aleatórios (Random).
 * @author 11800910
 */

public class Dado {

    private int faces;
    private int numeroRolado;
    private Random random;

    public Dado(){
        this.faces = 6;
        random = new Random();
    }

    public Dado(int n){
        this.faces = n;
        random = new Random();
    }

    /**
     * Recupera o último número selecionado.
     * @return
     */
    public int getLado(){
        return this.numeroRolado;
    }

    /**
     * Simula a rolagem do dado por meio de um gerador aleatório.
     * @return
     */
    public int rolar(){
        this.numeroRolado = this.random.getIntRand(this.faces) + 1;
        return this.numeroRolado;
    }

    /**
     * Transforma representação do dado em String.
     * Override no toString default
     */
    @Override
    public String toString(){
        String s = new String("");
        s = s + "+-----+\n";
        
        switch(this.numeroRolado){
            case 1:
                s = s + "|     |\n";
                s = s + "|  *  |\n";
                s = s + "|     |\n";
                break;

            case 2:
                s = s + "|*    |\n";
                s = s + "|     |\n";
                s = s + "|    *|\n";
                break;

            case 3:
                s = s + "|*    |\n";
                s = s + "|  *  |\n";
                s = s + "|    *|\n";
                break;

            case 4:
                s = s + "|*   *|\n";
                s = s + "|     |\n";
                s = s + "|*   *|\n";
                break;
            
            case 5:
                s = s + "|*   *|\n";
                s = s + "|  *  |\n";
                s = s + "|*   *|\n";
                break;

            case 6:
                s = s + "|* * *|\n";
                s = s + "|     |\n";
                s = s + "|* * *|\n";
                break;
        }

        s = s + "+-----+\n";
        return s;
    }

    /**
     * Não tem função real dentro da classe.
     */
    public static void main(String[] args){
    }
}