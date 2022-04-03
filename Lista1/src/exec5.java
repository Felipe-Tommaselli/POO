/**
 *
 * @author 11800910
 */
public class exec5 {

    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 5: Primeiro primo menor\n");

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
        // com num validado, vamos procurar o proximo menor num
        boolean primo = true;
        int menor_primo = num;
        int i;
        // loop indo de num a 0 procurando um primo
        while(menor_primo > 0){
            // teste de numero primo
            primo = true;
            for(i = 2; i < menor_primo; i++){
                if (menor_primo % i == 0){
                    primo = false;
                    break;
                }
            }
            // achou o primeiro numero primo
            if(primo == true) break;
            menor_primo--;
        }
        // resposta
        System.out.printf("O primeiro menor primo depois de %d é %d\n", num, menor_primo);

    }
}
