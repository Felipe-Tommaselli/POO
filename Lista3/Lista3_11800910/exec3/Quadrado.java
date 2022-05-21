/**
 * Classe que cria o quadrado
 */
public class Quadrado extends Retangulo {

    /**
     * Retângulo com ambos os lados iguais
     * @param lado
     * @param cheio
     * @param cor
     */
    public Quadrado(double lado, boolean cheio, String cor){
        super(lado, lado, cheio, cor);
    }

    /**
     * toString
     */
    @Override
    public String toString(){
        boolean cheio = getCheio();
        String s = "\nForma Geométrica: QUADRADO\n";
        s += "Lados: " + getLados()[0] + "\n";
        s += "Area: " + area() + "\n";
        s += "Perímetro: " + perimetro() + "\n";
        s += "Colorido: " + cheio + "\n";
        if(cheio){ 
            s += "Cor: " + getCor() + "\n"; 
        }
        return s;
    }

}