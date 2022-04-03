/**
 *
 * @author 11800910
 */
public class exec4_1 {

    public static void main(String[] args) {
        System.out.println("EXERCICIO 4 (parte 1): Arvore direita->esquerda\n");
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
        // com num validado, vamos montar a arvore
        int asterisco = num;
        int espaco = 0;
        while(asterisco > 0){
            for(int i = 0; i < espaco; i++)
                System.out.printf(" ");
            for(int i = 0; i < asterisco; i++)
                System.out.printf("*");
            System.out.printf("\n");
            asterisco--;
            espaco++;
        }
    }

}
