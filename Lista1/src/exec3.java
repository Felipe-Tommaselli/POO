/**
 *
 * @author 11800910
 */
public class exec3 {

    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 3: Arvore esquerda->direita\n");
        
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
        // com num validado, vamos montar a arvore
        int x = num;
        // loop vertical (até acabar o num)
        while(x > 0){
            // loop horizontal (até acabar a linha)
            for(int i = 0; i < x; i++)
                System.out.printf("*");
            System.out.printf("\n");
            x--;
        }
    }
}
