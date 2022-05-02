

/**
 * Simula um dado de número de ladostr variados. Ao criar o objeto é possível estabelecer o número de lados. 
 * A rolagem do dado é feita por meio de um gerador de númerostr aleatóriostr (Random).
 * @author 11800910
 */

public class Dado{

    private int faces;
    private int num_rolado;
    private Random rand;

    /**
     * Construtor que cria o dado com 6 faces
     */
    public Dado(){
        this.faces = 6;
        rand = new Random();
    }

    /**
     * Construtor que cria o dado com n faces
     * @param n
     */
    public Dado(int n){
        this.faces = n;
        rand = new Random();
    }

    /**
     * Recupera o último número selecionado.
     * @return o número que foi sorteado
     */
    public int getLado(){
        return this.num_rolado;
    }

    /**
     * Simula a rolagem do dado por meio de um gerador aleatório.
     * @return o número que foi sorteado
    */
    public int rolar(){
        this.num_rolado = this.rand.getIntRand(this.faces); // valor de 0 a 5
        this.num_rolado++; // dado vai de 1 a 6
        return this.num_rolado;
    }

    /**
     * Transforma representação do dado em String.
     * Override no toString default
     */
    @Override
    public String toString(){
        String str = new String("");
    
        int sel = this.num_rolado;
        switch(sel){
            case 1:
                str = str + "+-----+\n";
                str = str + "|     |\n";
                str = str + "|  *  |\n";
                str = str + "|     |\n";
                str = str + "+-----+\n";
                break;

            case 2:
                str = str + "+-----+\n";
                str = str + "|*    |\n";
                str = str + "|     |\n";
                str = str + "|    *|\n";
                str = str + "+-----+\n";
                break;

            case 3:
                str = str + "+-----+\n";
                str = str + "|*    |\n";
                str = str + "|  *  |\n";
                str = str + "|    *|\n";
                str = str + "+-----+\n";
                break;

            case 4:
                str = str + "+-----+\n";
                str = str + "|*   *|\n";
                str = str + "|     |\n";
                str = str + "|*   *|\n";
                str = str + "+-----+\n";
                break;
            
            case 5:
                str = str + "+-----+\n";
                str = str + "|*   *|\n";
                str = str + "|  *  |\n";
                str = str + "|*   *|\n";
                str = str + "+-----+\n";
                break;

            case 6:
                str = str + "+-----+\n";
                str = str + "|* * *|\n";
                str = str + "|     |\n";
                str = str + "|* * *|\n";
                str = str + "+-----+\n";
                break;
        }
        return str;
    }

    /**
     * Não tem função real dentro da classe.
     */
    public static void main(String[] args){
    }
}