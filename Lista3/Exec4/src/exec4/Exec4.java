public class Exec4 {

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        Loja loja = new Loja();
        int sel = -1;
        while(true){

            System.out.println("\n============  PRODUTOS ============\n\n");

            System.out.println("1) Cadastrar produto");
            System.out.println("2) Adicionar estoque em produto existente");
            System.out.println("3) Buscar produto");
            System.out.println("4) Vender produto");
            System.out.println("5) Exibir estoque completo");
            System.out.println("6) Excluir item");
            System.out.println("7) Encerrar programa");
            System.out.println("");
            
            sel = -1;
            while(true){
                try {  
                    sel = EntradaTeclado.leInt();
                    break;
                } catch (Exception e) {
                    System.out.println("\nErro: bad input");
                }
            }

            switch(sel){
                case 1:
                    loja.cadastraProduto();
                    break;
                case 2: 
                    loja.adicionarProduto(); 
                    break;
                case 3: 
                    loja.getProduto(); 
                    break;
                case 4: 
                    loja.removeProduto();
                    break;
                case 5: 
                    loja.printEstoque();
                    break;
                case 6: 
                    loja.excluirProduto(); 
                    break;
                case 7: 
                    return;
                default: 
                    System.out.println("Erro: modo não disponível"); 
                    break;
            }
        }
    }
}