public class Exec3{

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        Gtm gtm = new Gtm();

        while(true) {
            int function = -1;

            System.out.println("\n===========  FORMAS GEOMETRICAS ===========\n\n");

            System.out.println("1) Inserir quadrado");
            System.out.println("2) Inserir retângulo");
            System.out.println("3) Inserir circulo");
            System.out.println("4) Imprimir todas as formas");
            System.out.println("5) Encerrar programa");
            System.out.println("");

            boolean problema = true;
            while(problema) {
                try {  
                    function = EntradaTeclado.leInt();
                    problema = false;
                } catch (Exception e) {
                    System.out.println("\nErro: Bad input");
                }
            }

            switch(function) {
                case 1: gtm.inserirQuadrado(); 
                    break;
                case 2: gtm.inserirRetangulo(); 
                    break;
                case 3: gtm.inserirCirculo(); 
                    break;
                case 4: gtm.printFormas(); 
                    break;
                case 5: return;
                default: System.out.println("Função não encontrada"); break;
            }
        }
    }
}