
/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author 11800910
 */

public class Bozo{
    private static RolaDados dados;
    private static Placar placar;
    
    private static String leString(){
        try{
            return EntradaTeclado.leString();
        }
        catch(Exception e) {
            System.out.println("Entrada invalida");
        }

        return null;
    }

    /**
     * Método inicial do programa. Ele cuida da execução do jogo e possui um laço, no qual cada iteração representa uma rodada do jogo. 
     * Em cada rodada, o jogador joga os dados até 3 vezes e depois escolhe a posição do placar que deseja preencher. 
     * No final das rodadas a pontuação total é exibida.
     * @param args
     */
    public static void main(String[] args){
        
        dados = new RolaDados(5);
        placar = new Placar();

        System.out.println("\n====== JOGO DE BOZO ======");
        System.out.println("      (SSC0103 - POO)\n\n");

        System.out.println(placar);

        for(int rodada = 1; rodada <= 10; rodada++){
            
            String enter = " "; // inicia com valor qualquer

            System.out.println(" Rodada " + rodada);
            while(enter != ""){
                System.out.println("Pressione ENTER para lançar os dados");
                enter = leString();
            }

            int[] rolagemDados = new int[5];
            rolagemDados = dados.rolar();
            
            
            System.out.println(dados);
            for(int i = 0; i < 2; i++){
                
                System.out.println("Solicite os números dos dados que quiser trocar, separados por espaços");
                String str = leString();
                rolagemDados = dados.rolar(str);
                System.out.println(dados);
            }

            System.out.println(placar);
            System.out.print("Escolha a posição que será ocupada com essa jogada: ");
            
            int pos = -5; // valor aleatorio
            try {
                pos = EntradaTeclado.leInt();
            }
            catch(Exception e) {
                System.out.println("Entrada invalida!");
            }

            placar.add(pos, rolagemDados);
            System.out.println("\n");
            System.out.println(placar);
            
        }

        System.out.println("*****************************");
        System.out.println("Score final: " + placar.getScore());
    }
}