import static java.lang.Integer.*;
import java.util.Arrays;

/**
 * Essa é uma classe auxiliar que permite gerencia um conjunto de vários dados simultaneamente. 
 * Operações como rolar alguns dos dados ou exibir o resultado de todos eles, são implementadas.
 * @author 11800910
 */
public class RolaDados {
    private int num;
    private int[] resultado;
    private Dado[] lista;

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

        for(int i = 0; i < n; i++){
            esperaPor(50); 
            lista[i] = new Dado(6);
            resultado[i] = 0;
        }
    }

    /**
     * Classe privada para dar um tempo de espera na geração de seeds no sorteio dos dados e garantir que eles não entrem com a mesma seed
     * @param tms (tempo em milisegundos)
     */
    private static void esperaPor(int tms){  
        try{
            Thread.sleep(tms);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }


    /**
     * Rola todos os dados.
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
     *         Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(){
        for(int i = 0; i < this.num; i++)
            this.resultado[i] = lista[i].rolar();
        
        return this.resultado;
    }

    /**
     * Rola alguns dos dados.
     * @param quais
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
     *         Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(boolean[] quais){
        for(int i = 0; i < this.num; i++)
            if(quais[i] == true)
                this.resultado[i] = lista[i].rolar();

        return this.resultado;
    }

    /**
     * Rola alguns dos dados.
     * @param s
     * @return Retorna o valor de cada um dos dados, inclusive os que não foram rolados. 
     *         Nesse caso, o valor retornado é o valor anterior que ele já possuia.
     */
    public int[] rolar(String s){
        // utilização de regular expressions para limpar o numero da string
        String auxStr = s.replaceAll("[^1-" + this.num + "]+", " ").trim();
        String ParsingStr[] = auxStr.split(" ");
        String numStr = ParsingStr[0];
        

        if(!numStr.isEmpty())
            for(int i = 0; i < ParsingStr.length; i++){
                int numInt = parseInt(ParsingStr[i]);
                numInt--;
                if(numInt >= 0 && numInt <= this.num) // 1 a 6 do dado padrão
                    this.resultado[numInt] = lista[numInt].rolar();
            }
            return this.resultado;
    }

    /**
     * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto.
     * Override no toString default
     */
    @Override
    public String toString(){
        
        String finalStr[] = new String[5];
        String str = "1         2         3          4          5\n";

        Arrays.fill(finalStr, "");
        for(int i = 0; i < lista.length; i++){
            String str2 = lista[i].toString();
            String listaStr[] = str2.split("\n");
            
            for(int j = 0; j < listaStr.length; j++)
                finalStr[j] += (listaStr[j] + "   ");
        }
        
        for(int i = 0; i < finalStr.length; i++)
            str += finalStr[i] + "\n"; // concatena string finalStr
        
        return str;
    }

    public static void main(String args[]){

    }
}
