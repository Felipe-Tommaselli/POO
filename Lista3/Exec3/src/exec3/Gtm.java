public class Gtm{

    private static final int TAM = 1000;
    Forma[] formas = new Forma[TAM];
    int nFormas = 0;

    /
     * Ler lado
     * @return
     */
    private double getLado() {
        try {
            double lado = EntradaTeclado.leDouble();
            if(lado <= 0) { return -1; }
            return lado;
        }
        catch(Exception e) { return -1; }
    }

    //Função para inserir uma nova forma
    //0 - QUADRADO --- 1 - RETANGULO --- 2 - CIRCULO
    private void insereForma(int type) {

        if(type == 0) { System.out.println("\n* Inserir quadrado *"); }
        else if(type == 1) { System.out.println("\n* Inserir retângulo *"); }
        else if(type == 2) { System.out.println("\n* Inserir círculo *"); }
        
        System.out.println("Informações geométricas");
        double[] lados = { -1, -1 };

        if(type == 0) {
            System.out.printf("Insira o lado: ");
            lados[0] = getLado();
            lados[1] = lados[0];
        }

        if(type == 1) {
            System.out.printf("Inserção de lados\n");
            System.out.printf("Insira o lado 1: ");
            lados[0] = getLado();
            System.out.printf("Insira o lado 2: ");
            lados[1] = getLado();
        }

        if(type == 2) {
            System.out.printf("Insira o raio: ");
            lados[0] = getLado();
            lados[1] = lados[0];
        }


        if(lados[0] == -1 || lados[1] == -1) { 
            System.out.println("ERRO: Não foi possível ler o valor para o lado");
            System.out.println("Verifique que o valor inserido é um numero positivo");
            return;
        }

        try {
            System.out.printf("Deseja que a forma possua cor? (insira 'sim' em caso afirmativo) ");
            boolean filled = false;
            String filledS = EntradaTeclado.leString(), color = "";

            if(filledS.toLowerCase().equals("sim") || filledS.toLowerCase().equals("s")) {
                filled = true;
                System.out.printf("Insira a cor desejada: ");
                color = EntradaTeclado.leString();
            }

            if(type == 0) { 
                formas[nFormas++] = new Quadrado(lados[0], filled, color);
                System.out.println(" Forma criada com sucesso ");
                System.out.println((Quadrado)formas[nFormas-1]);
            }
            if(type == 1) { 
                formas[nFormas++] = new Retangulo(lados[0], lados[1], filled, color);
                System.out.println(" Forma criada com sucesso ");
                System.out.println((Retangulo)formas[nFormas-1]);
            }
            if(type == 2) { 
                formas[nFormas++] = new Circulo(lados[0], filled, color);
                System.out.println(" Forma criada com sucesso ");
                System.out.println((Circulo)formas[nFormas-1]);
            }

        } catch(Exception e) {
            System.out.println("ERRO: Houve um erro ao ler os valores de entrada");
            System.out.println("Confira os valores e tente novamente");
            return;
        }
    }


    public void inserirQuadrado() {
        insereForma(0);
    }


    public void inserirRetangulo() {
        insereForma(1);
    }


    public void inserirCirculo() {
        insereForma(2);
    }


    //Imprimir todas as formas
    public void imprimirFormas() {
        System.out.println("* Imprimindo Formas *");
        for(int i = 0; i < nFormas; i++) {
            if(formas[i] instanceof Circulo) {
                System.out.println((Circulo)formas[i]);
            } else if(formas[i] instanceof Quadrado) {
                System.out.println((Quadrado)formas[i]);
            } else {
                System.out.println((Retangulo)formas[i]);
            }
        }
    }

}