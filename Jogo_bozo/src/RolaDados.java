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
        String numStr[] = s.replaceAll("[^1-" + this.num + "]+", " "); // !
        numStr = numStr.trim();
        numStr = numStr.split(" ");

        if(!numStr[0].isEmpty())
        for(int i = 0; i < numStr.length; i++){
            int dado = parseInt(numStr[i]);
            dado--;
            if(dado >= 0 && dado <= this.num) // 0 a 6 do dado padrão
                this.resultado[dado] = lista[dado].rolar();
        }
        return this.resultado;
    }

    /**
     * Usa a representação em string do dados, para mostrar o valor de todos os dados do conjunto.
     * Override no toString default
     */
    @Override
    public String toString(){
        
        String[] final = new String[5];
        String str = "1      2      3       4       5\n";

        Arrays.fill(final, "");
        

        for(int i = 0; i < lista.length; i++){
            String[] str2 = lista[i];
            str2 = str2.toString();
            str2 = str2.split("\n");
            
            for(int j = 0; j < str2.length; j++)
                final[j] += (str2[j] + "   ");
        }
        
        for(int i = 0; i < final.length; i++)
            str += final[i] + "\n"; // concatena string final
        
        return str;
    }

    public static void main(String args[]){

    }
}
