/**
 *
 * @author 11800910
 */
import static java.lang.Integer.*;
import java.util.Arrays;

public class RolaDados {
    private int numeroDados;
    private int[] rolagemResult;
    private Dado[] listaDados;

    private static void esperar(int ms) {   
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public RolaDados(int n) {
        this.numeroDados = n;
        this.rolagemResult = new int[n];
        this.listaDados = new Dado[n];

        for(int i = 0; i < this.numeroDados; i++) {
            esperar(50); //Delay responsável por consertar a seed do Random
            listaDados[i] = new Dado(6);
            rolagemResult[i] = 0;
        }
    }

    public int[] rolar() {
        for(int i = 0; i < this.numeroDados; i++) {
            this.rolagemResult[i] = listaDados[i].rolar();
        }

        return this.rolagemResult;
    }

    public int[] rolar(boolean[] quais) {
        for(int i = 0; i < this.numeroDados; i++) {
            if(quais[i]) {
                this.rolagemResult[i] = listaDados[i].rolar();
            }
        }

        return this.rolagemResult;
    }

    public int[] rolar(String s) {
        String numbersInString[] = s.replaceAll("[^1-" + this.numeroDados + "]+", " ").trim().split(" ");

        if(!numbersInString[0].isEmpty())
        for(int i = 0; i < numbersInString.length; i++) {
            int dadoTarget = parseInt(numbersInString[i]) - 1;
            
            if(dadoTarget >= 0 && dadoTarget <= this.numeroDados)
                this.rolagemResult[dadoTarget] = listaDados[dadoTarget].rolar();
        }

        return this.rolagemResult;
    }

    @Override
    public String toString() {
        String[] finalStrings = new String[5];
        Arrays.fill(finalStrings, "");

        String s = "1          2          3          4          5\n";

        //Iterando sobre os dados
        for(int i = 0; i < listaDados.length; i++) {
            String[] partsStringDado = listaDados[i].toString().split("\n");
            
            //Iterando sobre cada parte da String ao imprimir um dado e separando em strings finais
            for(int j = 0; j < partsStringDado.length; j++) {
                finalStrings[j] += partsStringDado[j];
                finalStrings[j] += "    ";
            }
        }
        
        //Concatenação das strings finais
        for(int i = 0; i < finalStrings.length; i++) {
            s += finalStrings[i];
            s += '\n';
        }

        return s;
    }

    public static void main(String args[]) {

    }
}
