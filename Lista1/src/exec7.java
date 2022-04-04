/**
 *
 * @author 11800910
 */

import java.io.IOException;
import java.io.PrintStream;
import java.lang.Math;

public class exec7 {

    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 7: Bisseção\n");

        // validação da entrada (análogo ao feito em aula)
        boolean leu = false;
        double a0 = 0.0;
        double b0 = 0.0;
        double erro = 0, intervalo, m, i;
        int div = 0;
        while(!leu){
            leu = true;
            System.out.println("Digite um número: ");
            try{
                a0 = EntradaTeclado.leDouble();
            } catch(Exception e){
                System.out.println("O valor digitado deve ser um número!");
                leu = false;
            }
        }
        leu = false;
        while(!leu){
            leu = true;
            System.out.println("Digite um número: ");
            try{
                b0 = EntradaTeclado.leDouble();
            } catch(Exception e){
                System.out.println("O valor digitado deve ser um número!");
                leu = false;
            }
        }
        // com num validado, vamos procurar o proximo menor num
        intervalo = b0 - a0;
        div = ((Math.pow(a0, 3) - Math.pow(a0, 2) - 13*a0 + 8) * (Math.pow(b0, 3) - Math.pow(b0, 2) - 13*b0 + 8) > 0 ? 0 : 1); 
        i = Math.log10(b0 - a0);
        i -= Math.log10(erro);
        i /= Math.log(2);
        if(((Math.pow(a0, 3) - Math.pow(a0, 2) - 13*a0 + 8)) == 0 || (Math.pow(b0, 3) - Math.pow(b0, 2) - 13*b0 + 8) == 0){
            if(((Math.pow(a0, 3) - Math.pow(a0, 2) - 13*a0 + 8)) == 0)
                System.out.printf("a0 = %f\n", a0);
            else
                System.out.printf("b0 = %f\n", b0);
        }
        while(erro > 0.0000001){
            while(intervalo > erro){
                intervalo = b0 - a0;
                m = (a0 + b0) / 2;
            if(((Math.pow(m, 3) - Math.pow(m, 2) - 13*m + 8)) == 0){
                System.out.printf("m = %f\n", m);
                break;
            }
            if(((Math.pow(a0, 3) - Math.pow(a0, 2) - 13*a0 + 8)) * (Math.pow(m, 3) - Math.pow(m, 2) - 13*m + 8) < 0){
                b0 = m;
            }
            else{
                a0 = m;
            }
            }
        }
        System.out.printf("[%f, %f]\n solução: %f\n", a0, b0, (a0+b0)/2);
    }
}
