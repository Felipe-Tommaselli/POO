/**
 * Classe com a geometria tradicional das formas
 */
public class Gtm{

    private static final int TAM = 1000;
    Forma[] formas = new Forma[TAM];
    int num_formas = 0;

    /**
     * Ler lado
     * @return
     */
    private double getLado(){
        try {
            double lado = EntradaTeclado.leDouble();
            if(lado <= 0){ return -1; }
            return lado;
        }
        catch(Exception e){ 
            return -1; 
        }
    }

    /**
     * Inserir uma nova forma
     * @param flag
     */
    private void insereForma(int flag){
        // flag 0: QUADRADO 
        // flag 1: RETANGULO
        // flag 2: CIRCULO
        if(flag == 0){ System.out.println("\nInserir quadrado"); }
        else if(flag == 1){ System.out.println("\nInserir retângulo"); }
        else if(flag == 2){ System.out.println("\nInserir círculo"); }
        
        double[] lados = { -1, -1 };

        if(flag == 0){
            System.out.printf("Insira o lado: ");
            lados[0] = getLado();
            lados[1] = lados[0];
        }

        if(flag == 1){
            System.out.printf("Inserção de lados\n");
            System.out.printf("Insira o lado 1: ");
            lados[0] = getLado();
            System.out.printf("Insira o lado 2: ");
            lados[1] = getLado();
        }

        if(flag == 2){
            System.out.printf("Insira o raio: ");
            lados[0] = getLado();
            lados[1] = lados[0];
        }


        if(lados[0] == -1 || lados[1] == -1){ 
            System.out.println("ERRO: Não foi possível ler o valor para o lado");
            System.out.println("Verifique que o valor inserido é um numero positivo");
            return;
        }

        try {
            System.out.printf("Mudar cor? ('sim' em caso afirmativo) ");
            boolean cheio = false;
            String cheioS = EntradaTeclado.leString(), color = "";

            if(cheioS.toLowerCase().equals("sim") || cheioS.toLowerCase().equals("s")){
                cheio = true;
                System.out.printf("Insira a cor desejada: ");
                color = EntradaTeclado.leString();
            }

            if(flag == 0){ 
                formas[num_formas++] = new Quadrado(lados[0], cheio, color);
                System.out.println("Forma criada com sucesso ");
                System.out.println((Quadrado)formas[num_formas-1]);
            }
            if(flag == 1){ 
                formas[num_formas++] = new Retangulo(lados[0], lados[1], cheio, color);
                System.out.println("Forma criada com sucesso ");
                System.out.println((Retangulo)formas[num_formas-1]);
            }
            if(flag == 2){ 
                formas[num_formas++] = new Circulo(lados[0], cheio, color);
                System.out.println("Forma criada com sucesso ");
                System.out.println((Circulo)formas[num_formas-1]);
            }

        } catch(Exception e){
            System.out.println("ERRO: Houve um erro ao ler os valores de entrada");
            return;
        }
    }

    // SETTERS
    public void inserirQuadrado(){
        insereForma(0);
    }
    public void inserirRetangulo(){
        insereForma(1);
    }
    public void inserirCirculo(){
        insereForma(2);
    }

    /**
     * Imprimir todas as formas
     */
    public void printFormas(){
        System.out.println("* Imprimindo Formas *");
        for(int i = 0; i < num_formas; i++){
            if(formas[i] instanceof Circulo){
                System.out.println((Circulo)formas[i]);
            } 
            else if(formas[i] instanceof Quadrado){
                System.out.println((Quadrado)formas[i]);
            } 
            else{
                System.out.println((Retangulo)formas[i]);
            }
        }
    }

}