/**
 * Esta classe representa o placar de um jogo de Bozó. 
 * Permite que combinações de dados sejam alocadas às posições e mantém o escore de um jogador.
 * @author 11800910
 */

import java.util.Arrays;

public class Placar{
        /*
        OBS: adaptações para vetor baseado em 0.
        Posições do tabuleiro (0 a 5 e posições especiais)
        6 - full; 7 - seq.; 8 - quadra; 9 - quina;
        */
        private int[] placar_valor;
    
        public Placar(){
            this.placar_valor = new int[10];
            Arrays.fill(this.placar_valor, -1);
        }
        
        /**
         * Adiciona uma sequencia de dados em uma determinada posição do placar.
         * @param posicao
         * @param dados
         */
        public void add(int posicao, int[] dados){
            int posicaoVector = posicao - 1;
            int freq[] = new int[6];
            Arrays.fill(freq, 0);
    
            if(this.placar_valor[posicaoVector] == -1){
                for(int i = 0; i < dados.length; i++){
                    freq[dados[i] - 1]++;
                }
        
                if(posicao >= 1 && posicao <= 6){
                    this.placar_valor[posicaoVector] = freq[posicaoVector]*posicao;
                }
                
                switch(posicao){
                    case 7:
                        boolean hasThreeFlag = false;
                        boolean hasTwoFlag = false;
                        boolean hasFiveFlag = false;
    
                        for(int i = 0; i < freq.length; i++){
                            if(freq[i] == 3)
                                hasThreeFlag = true;
    
                            if(freq[i] == 2)
                                hasTwoFlag = true;
    
                            if(freq[i] == 5)
                                hasFiveFlag = true;
                        }
    
                        if((hasThreeFlag && hasTwoFlag) || hasFiveFlag){
                            this.placar_valor[6] = 15;
                        }
                        else {
                            this.placar_valor[6] = 0;
                        }
    
                        break;
    
                    case 8:
                        if(freq[0] == 1 && 
                            freq[1] == 1 &&
                            freq[2] == 1 &&
                            freq[3] == 1 &&
                            freq[4] == 1){
    
                            this.placar_valor[7] = 20;
                        }
                        else if(freq[1] == 1 && 
                                freq[2] == 1 &&
                                freq[3] == 1 &&
                                freq[4] == 1 &&
                                freq[5] == 1){
    
                            this.placar_valor[7] = 20;
                        }
                        else {
                            this.placar_valor[7] = 0;
                        }
                        break;
    
                    case 9: {
                        boolean flag = false;
                        for(int i = 0; i < freq.length; i++){
                            if(freq[i] == 4){
                                this.placar_valor[8] = 30;
                                flag = true;
                                break;
                            }
                        }
    
                        if(!flag)
                            this.placar_valor[8] = 0;
                    }
                        break;
    
                    case 10: {
                        boolean flag = false;
                        for(int i = 0; i < freq.length; i++){
                            if(freq[i] == 5){
                                this.placar_valor[9] = 40;
                                flag = true;
                                break;
                            }
                        }
    
                        if(!flag)
                            this.placar_valor[9] = 0;
                    }
                        break;
                }
            }
        }
        
        /**
         * Computa a soma dos valores obtidos, considerando apenas as posições que já estão ocupadas.
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
         * A representação na forma de string, mostra o placar completo, indicando quais são as posições livres (com seus respectivos números) e o valor obtido nas posições já ocupadas.
         * @param posicao
         * @return
         */
        private String scoreToPrint(int posicao){
            int posicaoScore = this.placar_valor[posicao - 1];
    
            if(posicaoScore == -1){
                return "(" + posicao + ")";
            }
            else {
                String s = new String("");
                s += posicaoScore + "";
                if(posicaoScore < 10)
                    s += "  ";
                else
                    s += " ";
    
                return s;
            }
        }
    
        /**
        * Transforma representação do dado em String.
        * Override no toString default
        */
        @Override
        public String toString(){
            String s = new String("");
    
            s += scoreToPrint(1);
            s += "    |   ";
            s += scoreToPrint(7);
            s += "    |   ";
            s += scoreToPrint(4);
            s += " \n";
    
            s += "--------------------------\n";
    
            s += scoreToPrint(2);
            s += "    |   ";
            s += scoreToPrint(8);
            s += "    |   ";
            s += scoreToPrint(5);
            s += " \n";
    
            s += "--------------------------\n";
    
            s += scoreToPrint(3);
            s += "    |   ";
            s += scoreToPrint(9);
            s += "    |   ";
            s += scoreToPrint(6);
            s += " \n";
    
            s += "--------------------------\n";
    
            s += "       |   ";
            s += scoreToPrint(10);
            s += "    |\n";
    
            s+= "       +----------+\n";
        
            return s;
        }
    }
