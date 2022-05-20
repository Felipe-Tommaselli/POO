/**
 *
 * @author 11800910
 */
public class Exec1{

    /**
     * Main rodando o código a partir das outras classes
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
            
        Contatos contato = new Contatos();

        while(true) {
            int modo = -1;
            System.out.println("\n===========  AGENDA  ===========\n\n");

            System.out.println("1) Cadastrar Pessoa Física");
            System.out.println("2) Cadastrar Pessoa Jurídica");
            System.out.println("3) Buscar por contato existente");
            System.out.println("4) Remover contato");
            System.out.println("5) Visualizar todos os contatos");
            System.out.println("6) Ordenar contatos");
            System.out.println("7) Encerrar programa");
            System.out.println("");

            while(true){
                try{  
                    modo = EntradaTeclado.leInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Erro: bad input");
                }
            }

            switch(modo){
                case 1: contato.cadastrarFisica(); 
                    break;
                case 2: contato.cadastrarJuridica(); 
                    break;
                case 3: contato.tfPessoa(true); 
                    break;
                case 4: contato.tfPessoa(false); 
                    break;
                case 5: contato.printContatos(); 
                    break;
                case 6: contato.ordenar();
                    break;
                case 7: return;
                default: System.out.println("Erro: modo não disponivel"); 
                    break;
            }
        }
    }
}