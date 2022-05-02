/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente. 
 * Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * @author 11800910
 */
import static java.lang.Integer.*;
import java.util.Arrays;

public class RolaDados {
    private int num;
    private int[] resultado;
    private Dado[] lista;

    private static void esperar(int ms){  
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Construtor que cria e armazena vários objetos do tipo Dado. 
     * Usa para isso o construtor padrão daquela classe, ou seja, um dado de 6 lados e gerando sempre uma semente aleatória para o gerador de números aleatórios. 
     * Os dados criados podem ser referenciados por números, entre 1 e n.
     * @param n
     */
    public RolaDados(int n){
        this.num = n;
        this.resultado = new int[n];
        this.lista = new Dado[n];

        for(int i = 0; i < this.num; i++){
            esperar(50); //Delay responsável por consertar a seed do Random
            lista[i] = new Dado(6);
            resultado[i] = 0;
        }
    }

    /**
     * Rola todos os dados.
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
     *         Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(){
        for(int i = 0; i < this.num; i++){
            this.resultado[i] = lista[i].rolar();
        }

        return this.resultado;
    }

    /**
     * Rola alguns dos dados.
     * @param quais
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
     *         Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(boolean[] quais){
        for(int i = 0; i < this.num; i++){
            if(quais[i]){
                this.resultado[i] = lista[i].rolar();
            }
        }

        return this.resultado;
    }

    /**
     * Rola alguns dos dados.
     * @param s
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
     *         Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(String s){
        String numbersInString[] = s.replaceAll("[^1-" + this.num + "]+", " ").trim().split(" ");

        if(!numbersInString[0].isEmpty())
        for(int i = 0; i < numbersInString.length; i++){
            int dadoTarget = parseInt(numbersInString[i]) - 1;
            
            if(dadoTarget >= 0 && dadoTarget <= this.num)
                this.resultado[dadoTarget] = lista[dadoTarget].rolar();
        }

        return this.resultado;
    }

    /**
     * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto.
     * Override no toString default
     */
    @Override
    public String toString(){
        String[] finalStrings = new String[5];
        Arrays.fill(finalStrings, "");

        String s = "1          2          3          4          5\n";

        //Iterando sobre os dados
        for(int i = 0; i < lista.length; i++){
            String[] partsStringDado = lista[i].toString().split("\n");
            
            //Iterando sobre cada parte da String ao imprimir um dado e separando em strings finais
            for(int j = 0; j < partsStringDado.length; j++){
                finalStrings[j] += partsStringDado[j];
                finalStrings[j] += "    ";
            }
        }
        
        //Concatenação das strings finais
        for(int i = 0; i < finalStrings.length; i++){
            s += finalStrings[i];
            s += '\n';
        }

        return s;
    }

    public static void main(String args[]){

    }
}
