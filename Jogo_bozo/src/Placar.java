/**
 *
 * @author 11800910
 */

public class Placar {

    import java.util.Arrays;

    public class Placar {
        /*
        OBS: adaptações para vetor baseado em 0.
        Posições do tabuleiro (0 a 5 e posições especiais)
        6 - full; 7 - seq.; 8 - quadra; 9 - quina;
        */
        private int[] scoreValues;
    
        public Placar() {
            this.scoreValues = new int[10];
            Arrays.fill(this.scoreValues, -1);
        }
    
        public void add(int posicao, int[] dados) {
            int posicaoVector = posicao - 1;
            int freq[] = new int[6];
            Arrays.fill(freq, 0);
    
            if(this.scoreValues[posicaoVector] == -1) {
                for(int i = 0; i < dados.length; i++) {
                    freq[dados[i] - 1]++;
                }
        
                if(posicao >= 1 && posicao <= 6) {
                    this.scoreValues[posicaoVector] = freq[posicaoVector]*posicao;
                }
                
                switch(posicao) {
                    case 7:
                        boolean hasThreeFlag = false;
                        boolean hasTwoFlag = false;
                        boolean hasFiveFlag = false;
    
                        for(int i = 0; i < freq.length; i++) {
                            if(freq[i] == 3)
                                hasThreeFlag = true;
    
                            if(freq[i] == 2)
                                hasTwoFlag = true;
    
                            if(freq[i] == 5)
                                hasFiveFlag = true;
                        }
    
                        if((hasThreeFlag && hasTwoFlag) || hasFiveFlag) {
                            this.scoreValues[6] = 15;
                        }
                        else {
                            this.scoreValues[6] = 0;
                        }
    
                        break;
    
                    case 8:
                        if(freq[0] == 1 && 
                            freq[1] == 1 &&
                            freq[2] == 1 &&
                            freq[3] == 1 &&
                            freq[4] == 1) {
    
                            this.scoreValues[7] = 20;
                        }
                        else if(freq[1] == 1 && 
                                freq[2] == 1 &&
                                freq[3] == 1 &&
                                freq[4] == 1 &&
                                freq[5] == 1) {
    
                            this.scoreValues[7] = 20;
                        }
                        else {
                            this.scoreValues[7] = 0;
                        }
                        break;
    
                    case 9: {
                        boolean flag = false;
                        for(int i = 0; i < freq.length; i++) {
                            if(freq[i] == 4) {
                                this.scoreValues[8] = 30;
                                flag = true;
                                break;
                            }
                        }
    
                        if(!flag)
                            this.scoreValues[8] = 0;
                    }
                        break;
    
                    case 10: {
                        boolean flag = false;
                        for(int i = 0; i < freq.length; i++) {
                            if(freq[i] == 5) {
                                this.scoreValues[9] = 40;
                                flag = true;
                                break;
                            }
                        }
    
                        if(!flag)
                            this.scoreValues[9] = 0;
                    }
                        break;
                }
            }
        }
    
        public int getScore() {
            int score = 0;
            for(int i = 0; i < this.scoreValues.length; i++) {
                score += this.scoreValues[i];
            }
    
            return score;
        }
    
        private String scoreToPrint(int posicao) {
            int posicaoScore = this.scoreValues[posicao - 1];
    
            if(posicaoScore == -1) {
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
    
        @Override
        public String toString() {
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