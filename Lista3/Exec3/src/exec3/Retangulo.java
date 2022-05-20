import java.lang.Math.*;

/**
 * Classe retangulo
 */
public class Retangulo extends Forma {

    /**
     * Retangulo com 2 ladosiguais e 2 diferentes
     * @param lado1
     * @param lado2
     * @param cheio
     * @param cor
     */
    public Retangulo(double lado1, double lado2, boolean cheio, String cor){
        super(lado1, lado2, cheio, cor);
    }

    /**
     * tostring
     */
    @Override
    public String toString(){
        boolean cheio = getCheio();
        String s = "\nForma Geométrica: RETANGULO\n";
        s += "Lados: " + getLados()[0] + " e " + getLados()[1] + "\n";
        s += "Area: " + area() + "\n";
        s += "Perímetro: " + perimetro() + "\n";
        s += "Colorido: " + cheio + "\n";
        if(cheio){ 
            s += "Cor: " + getCor() + "\n"; 
        }
        return s;
    }

}