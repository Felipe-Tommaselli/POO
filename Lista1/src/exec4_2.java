/**
 *
 * @author 11800910
 */
public class exec4_2 {

    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 4 (parte 2): Verificador de Primo\n");

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
        // com num validado, vamos ver se ele é primo
        boolean primo = true;
        int i;
        // teste de divisão (i guarda o menor divisor comum caso haja)
        for(i = 2; i < num; i++) {
            if (num % i == 0){
                primo = false;
                break;
            }
        }
        // resposta para primo ou não
        if(primo == true)
            System.out.printf("O número %d é primo!\n", num);
        else{
            System.out.printf("O número %d NÃO é primo!\n", num);
            System.out.printf("Seu menor divisor é %d\n", i);
        }
    }
}
