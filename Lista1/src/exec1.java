/**
 *
 * @author 11800910
 */
public class exec1 {

    public static void main(String[] args) {
        System.out.println("EXERCICIO 1: RAIZ QUADRADA\n");
        int num = 0;
        boolean leu = false;
        while(!leu){
            leu = true;
            System.out.printf("Digite um inteiro: ");
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
            System.out.printf("Numero lido: %d\n", num);
        }
        // validado o num, vamos fazer a raiz quadrada agora
        float xi = 0;
        float xi_1 = num/2; // x0
        float erro = 1; // entrar no while
        
        while(erro > 0.00000001){
            xi = (xi_1 + (num/xi_1))/2;
            erro = xi - xi_1;
            if(erro < 0)
                erro *= -1;
            xi_1 = xi;
        }
        System.out.printf("A raiz quadrada de %d é %f\n", num, xi);
    }
    
}
