
/**
 * Essa é a classe inicial do programa Bozó. Possui apenas o método main, que cuida da execução do jogo.
 * @author 11800910
 */

public class Bozo{
    private static RolaDados dados;
    private static Placar placar;
    
    public Bozo(){
        dados = new RolaDados(5);
        placar = new Placar();
    }

    private static String leStringTeclado(){
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
        
        System.out.println("\n====== JOGO DE BOZO ======");
        System.out.println("      (SSC0103 - POO)\n\n");

        Bozo bozo = new Bozo();
        System.out.println(bozo.placar);

        for(int rodada = 1; rodada <= 10; rodada++){
            System.out.println(" Rodada " + rodada);
            System.out.println("Pressione ENTER para lançar os dados");
            
            leStringTeclado();

            int[] rolagemDados = new int[5];
            rolagemDados = bozo.dados.rolar();
            System.out.println(bozo.dados);
            
            for(int troca = 0; troca < 2; troca++){
                System.out.println("Solicite os números dos dados que quiser TROCAR, separados por espaços");
                String s = leStringTeclado();
                rolagemDados = bozo.dados.rolar(s);
                System.out.println(bozo.dados);
            }

            System.out.println(bozo.placar);

            System.out.print("Escolha a posição que será ocupada com essa jogada =====> ");
            
            int posicao = -1;

            try {
                posicao = EntradaTeclado.leInt();
            }
            catch(Exception e) {
                System.out.println("Erro na leitura do teclado!");
            }

            bozo.placar.add(posicao, rolagemDados);
            System.out.println("\n");
            System.out.println(bozo.placar);
            
        }

        System.out.println("*****************************");
        System.out.println("Seu score final foi: " + bozo.placar.getScore());
        System.out.println("*****************************");
    }
}