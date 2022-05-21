/**
 * Classe que cria a forma geométrica
 */
public class Forma {

    private double[] lados = new double[2];
    private boolean cheio;
    private String cor;

    /**
     * Construtor para adicionar apenas cor
     * @param cheio
     * @param cor
     */
    public Forma(boolean cheio, String cor){
        this.cheio = cheio;
        if(this.cheio){ 
            this.cor = cor; } 
    }

    /**
     * Construtor para adicionar cor e lados
     * @param lado1
     * @param lado2
     * @param cheio
     * @param cor
     */
    public Forma(double lado1, double lado2, boolean cheio, String cor){

        this.cheio = cheio;
        this.lados[0] = lado1;
        this.lados[1] = lado2;
        if(this.cheio){ 
            this.cor = cor; 
        } 
    }

    /**
     * Cálculo de área
     * @return
     */
    public double perimetro(){
        return 2 * (lados[0] + lados[1]);
    }

    /**
     * Cálculo de perimetro
     * @return
     */
    public double area(){

        return lados[0] * lados[1];
    }

    //Getters
    public double[] getLados(){ 
        return this.lados; 
    }
    public boolean getCheio(){ 
        return this.cheio; 
    }
    public String getCor(){ 
        return this.cor; 
    }

}