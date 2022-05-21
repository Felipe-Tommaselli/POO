/**
 * Classe livro
 */
public class Livro extends Estoque {
    
    /**
     * expande a classe Estoque com as info do livro
     * @param nome
     * @param num
     * @param qte
     */
    public Livro(String nome, long num, int qte){
        super(nome, num, qte);
    }


    @Override
    public String toString(){
        String s = "\nTipo: LIVRO\n";
        s += "Nome: " + getNome() + "\n";
        s += "Código de Barras: " + getNum() + "\n";
        s += "Quantia em Estoque: " + getQte() + "\n";
        return s;
    }

}