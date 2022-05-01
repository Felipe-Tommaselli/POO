/**
 *
 * @author 11800910
 */

import java.lang.Math;

public class exec2 {

    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 2: EQUAÇÃO SEGUNDO GRAU\n");
        
        int num = 0;
        int i = 1;
        boolean leu = false;
        int a = 0;
        int b = 0;
        int c = 0;
        // loop para repetir o processo para os 3 coeficientes a,b,c tal que:
        // ax^2 + bx + c = 0
        while(i <= 3){
            leu = false;
            num = 0;


            
        // validação da entrada num (análogo ao feito em aula)
        while(!leu){
                leu = true;
                System.out.printf("Digite o %dº coeficiente: ", i);
                try {
                    num = EntradaTeclado.leInt();
                    if( num < 0){
                        System.out.println("Número deve ser positivo!!");
                        leu = false;
                    }
                } catch (Exception e) {
                System.out.println("O valor que vc digitou não é um número inteiro");
                    leu = false;
                }
            }
            // atribui o numero validado para cada iteração
            if(i == 1)
                a = num;
            if(i == 2)
                b = num;
            if(i == 3)
                c = num;
            i++;
        }
        // Agora com os 3 coeficientes calculados, vamos aplicar a fórmula de baskhara
        float x = 0;
        float delta = 0;

        // calculo do discriminante
        delta = (b*b) - (float) 4.0*a*c;
        System.out.printf("delta = %f\n", delta);
        
        // para cada caso do discriminante, a equação terá diferentes soluções
        // a partir disso, é aplicada a fórmula de baskhara
        // SEM RAIZES REAL
        if(delta < 0)
            System.out.printf("Equação fornecida não possui soluçaõ :(\n");
        // UMA RAIZ REAL
            else if(delta == 0){
            x = (float)-b;
            x /= (float)(2.0*a);
            System.out.printf("Equação fornecida tem uma solução: %f\n", x);
        } 
        // DUAS RAIZES REAIS
        else{
            x = (float)(-b + Math.sqrt(delta));
            x /= (float)(2.0*a);
            System.out.printf("Equação fornecida tem duas soluções: %f", x);
            x = (float)(-b - Math.sqrt(delta));
            x /= (float)(2.0*a);
            System.out.printf(" e %f", x);
        } 
    }

}
