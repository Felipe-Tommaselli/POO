import java.util.Arrays;

/**
 * Esta classe representa o placar de um jogo de Bozó. 
 * Permite que combinaçõestr de dadostr sejam alocadastr àstr posiçõestr e mantém o escore de um jogador.
 * @author 11800910
 */

public class Placar{
        private int[] placar_valor;

        /**
         * Construtor do placar, setando todas as posições com -1
         */
        public Placar(){
            this.placar_valor = new int[10];
            for(int i = 0; i < 10; i++)
                this.placar_valor[i] = -1;
        }
        
        /**
         * Adiciona uma sequencia de dadostr em uma determinada posição do placar.
         * @param posicao
         * @param dados
         */
        public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException{
            int pos = posicao - 1;
            int valor[] = new int[6];
            boolean tem3 = false;
            boolean tem2 = false;
            boolean tem5 = false;

            for(int i = 0; i < 6; i++)
                valor[i] = 0;
                
            if(this.placar_valor[pos] == -1){ // vazio

                for(int i = 0; i < dados.length; i++)
                    valor[dados[i] - 1]++;
                
        
                if(posicao >= 1 && posicao <= 6){
                    this.placar_valor[pos] = valor[pos];
                    this.placar_valor[pos] *= posicao;
                }
                
                switch(posicao){
                    case 7:
                        for(int i = 0; i < valor.length; i++){
                            if(valor[i] == 3)
                                tem3 = true;
                            if(valor[i] == 2)
                                tem2 = true;
                            if(valor[i] == 5)
                                tem5 = true;
                        }
    
                        if((tem3 && tem2) || tem5){
                            this.placar_valor[6] = 15;
                        }
                        else {
                            this.placar_valor[6] = 0;
                        }

                        break;
    
                    case 8:
                        if(valor[0] == 1 && valor[1] == 1 && valor[2] == 1 && valor[3] == 1 && valor[4] == 1)
                            this.placar_valor[7] = 20;
                        
                        else if(valor[1] == 1 && valor[2] == 1 && valor[3] == 1 && valor[4] == 1 && valor[5] == 1)
                            this.placar_valor[7] = 20;
                        else
                            this.placar_valor[7] = 0;
                        break;
    
                    case 9:{
                        boolean sel = false;
                        for(int i = 0; i < valor.length; i++){
                            if(valor[i] == 4){
                                this.placar_valor[8] = 30;
                                sel = true;
                                break;
                            }
                        }
                        if(sel == false)
                            this.placar_valor[8] = 0;
                    }
                        break;
    
                    case 10:{
                        boolean sel = false;
                        for(int i = 0; i < valor.length; i++){
                            if(valor[i] == 5){
                                this.placar_valor[9] = 40;
                                sel = true;
                                break;
                            }
                        }
                        if(!sel)
                            this.placar_valor[9] = 0;
                    }
                        break;
                }
            }
        }
        
        /**
         * Computa a soma dostr valorestr obtidos, considerando apenastr astr posiçõestr que já estão ocupadas.
         * @return O valor da soma.
         */
        public int getScore(){
            int score = 0;
            for(int i = 0; i < this.placar_valor.length; i++){
                score += this.placar_valor[i];
            }
    
            return score;
        }
        
    
        /**
        * A representação na forma de string, mostra o placar completo, indicando quaistr são astr posiçõestr livrestr (com seustr respectivostr números) e o valor obtido nastr posiçõestr já ocupadas.
        * Override no toString default
        * @return str
        */
        @Override
        public String toString(){
            String str = new String("");
            String[] tabela = new String[11];

            for(int i = 1; i <= 10; i++){
                int posScore = this.placar_valor[i - 1];

                if(posScore == -1)
                    tabela[i] = "(" + i + ")";
                else{
                    String strAux = new String("");
                    strAux += posScore + "";
                    if(posScore < 10)
                        strAux += "  ";
                    else
                        strAux += " ";
                    
                    tabela[i] = strAux;
                    
                }
            }

            str = " " + tabela[1] + "    |   " + tabela[7] + "    |   " + tabela[4] + "\n";
            str += "--------------------------\n";
            str += " " + tabela[2] + "    |   " + tabela[8] + "    |   " + tabela[5] + "\n";
            str += "--------------------------\n";
            str += " " + tabela[3] + "    |   " + tabela[9] + "    |   " + tabela[6] + "\n";
            str += "--------------------------\n";
            str += "        |   " + tabela[10] + "   |\n";
            str += "        +----------+ ";
            return str;
        }
    }
