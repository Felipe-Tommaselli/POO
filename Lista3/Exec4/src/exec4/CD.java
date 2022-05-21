/**
 * Classe CD
 */
public class CD extends Estoque {
    
    /**
     * expande a classe Estoque com as info do CD
     * @param nome
     * @param num
     * @param qte
     */
    public CD(String nome, long num, int qte){
        super(nome, num, qte);
    }

    @Override
    public String toString(){
        String s = "Tipo: CD\n";
        s += "Nome: " + getNome() + "\n";
        s += "Código de Barras: " + getNum() + "\n";
        s += "Quantia em Estoque: " + getQte() + "\n";
        return s;
    }

}