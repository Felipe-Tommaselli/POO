/**
 * Classe DVD
 */
public class DVD extends Estoque {

    /**
     * expande a classe Estoque com as info do DVD
     * @param nome
     * @param num
     * @param qte
     */
    public DVD(String nome, double num, int qte){
        super(nome, num, qte);
    }

    @Override
    public String toString(){
        String s = "Tipo: DVD\n";
        s += "Nome: " + getNome() + "\n";
        s += "Código de Barras: " + getNum() + "\n";
        s += "Quantia em Estoque: " + getQte() + "\n";
        return s;
    }

}