/**
 *
 * @author 11800910
 */
public class exec6 {
    
    public static void main(String[] args) {
        // cabeçalho
        System.out.println("EXERCICIO 6: Valores ponto fluante\n");

        // validação da entrada num (análogo ao feito em aula)
        // com inserção em um vetor dos valores
        double num = 0.0;
        boolean leu = false;
        double nums[] = new double[999];
        int i = 0;
        loopfora:
        while(true){
            num = 0.0;
            while(!leu){
                leu = true;
                System.out.printf("Digite um inteiro: ");
                try {
                    num = EntradaTeclado.leDouble();
                    if(num == 0.0)
                        break loopfora;
                } catch (Exception e) {
                System.out.println("O valor que vc digitou não é um número");
                    leu = false;
                }
            }
            nums[i] = num;
            i++;
        }
        // com num validado, vamos achar o maior e o menor valor
        int j = 0;
        double maior = 0.0;
        double menor = 0.0;
        while(j < i){
            if(nums[j] > maior)
                maior =nums[j];
            if(nums[j] < menor)
                menor =nums[j];
            System.out.printf("nums[%d]: %f\n", j, nums[j]);
            j++;
        }
    }
}
