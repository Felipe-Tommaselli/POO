/**
 *
 * @author 11800910
 */
public class exec4_1 {

    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 4 (parte 1): Arvore direita->esquerda\n");
        
        // validação da entrada num (análogo ao feito em aula)
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
        }
        // com num validado, vamos montar a arvore invertida
        int asterisco = num;
        int espacos = 0;        
        // loop vertical
        while(asterisco > 0){
            // asteriscos roda horizontalmente de num até 0, enquanto 
            for(int i = 0; i < espacos; i++)
                System.out.printf(" ");
            // espacos roda horizontalmente de 0 até num
            for(int i = 0; i < asterisco; i++)
                System.out.printf("*");
            System.out.printf("\n");
            asterisco--;
            espacos++;
        }
    }

}
