import java.lang.Math.*;

public class Circulo extends Forma {

    private double raio; //raio

    /**
     * Construtor do circulo
     * @param raio
     * @param cheio
     * @param cor
     */
    public Circulo(double raio, boolean cheio, String cor){
        super(cheio, cor);
        this.raio = raio;
    }

    /**
     * Sobreescreve a area
     */
    @Override
    public double perimetro(){
        return 2 * Math.PI * raio;
    }

    /**
     * Sobreescreve o perimetro
     */
    @Override
    public double area(){
        return Math.PI * raio * raio;
    }

    /**
     * Representação do circulo como string
     */
    @Override
    public String toString(){

        boolean cheio = getCheio();
        String s = "\nForma Geométrica: CIRCULO\n";
        s += "Raio: " + raio + "\n";
        s += "Area: " + area() + "\n";
        s += "Perímetro: " + perimetro() + "\n";
        s += "Colorido: " + cheio + "\n";
        if(cheio){ 
            s += "Cor: " + getCor() + "\n"; 
        }
        return s;
    }

}