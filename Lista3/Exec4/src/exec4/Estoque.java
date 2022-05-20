public class Estoque {

    //Item genérico com informações de nome, qte disponível e código
    private String nome;
    private int estoque;
    private long codigo;

    //Construtor
    public Estoque(String nome, long codigo, int quantiaInicial) {
        this.nome = nome;
        this.codigo = codigo;
        this.estoque = quantiaInicial;
    }

    //Getters e Setters
    public String getName() { return this.nome; }
    public long getCode() { return this.codigo; }
    public int getAmount() { return this.estoque; }
    
    public void setName(String nome) { this.nome = nome; }
    public void setCode(long codigo) { this.codigo = codigo; }
    public void setAmount(int estoque) { this.estoque = estoque; }


    //Remover (vender) quantia do estoque
    //Envia excessão caso novo estoque seja negativo
    public void remover(int quantia) throws Exception {
        if(this.estoque - quantia < 0) { throw new Exception(); }
        setAmount(this.estoque - quantia);
    }

    //Adicionar (comparar) quantia ao estoque
    public void adicionar(int quantia) {
        setAmount(this.estoque + quantia);
    }

}