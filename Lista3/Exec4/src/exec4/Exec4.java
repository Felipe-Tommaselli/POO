public class Exec4 {

    public static void main(String[] args) {

        Loja loja = new Loja();

        while(true) {
            int function = -1;

            System.out.println("\n********  PRODUTOS  ********\n");
            System.out.println("Selecione a função que deseja executar");
            System.out.println("1) Cadastrar produto");
            System.out.println("2) Adicionar estoque em produto existente");
            System.out.println("3) Buscar produto");
            System.out.println("4) Vender produto");
            System.out.println("5) Exibir estoque completo");
            System.out.println("6) Excluir item");
            System.out.println("7) Encerrar programa");
            System.out.println("");

            while(true) {
                try {  
                    function = EntradaTeclado.leInt();
                    break;
                } catch (Exception e) {
                    System.out.println("\n** Erro **\nA função deve ser um inteiro entre 1 e 7");
                }
            }

            switch(function) {
                case 1: loja.cadastrarProduto(); break;
                case 2: loja.adicionarProduto(); break;
                case 3: loja.buscarProduto(); break;
                case 4: loja.venderProduto(); break;
                case 5: loja.imprimirEstoque(); break;
                case 6: loja.excluirProduto(); break;
                case 7: return;
                default: System.out.println("Função não encontrada"); break;
            }
        }
    }
}