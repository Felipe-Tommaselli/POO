/**
 * Classe que cria o estoque com os produtos e as quantidades
 */
public class Estoque {

    private String nome;
    private int estoque;
    private double num;

    /**
     * Construtor de um item genérico
     * @param nome
     * @param num
     * @param qte0
     */
    public Estoque(String nome, double num, int qte0){
        this.nome = nome;
        this.num = num;
        this.estoque = qte0;
    }

    // Getters 
    public String getNome(){ 
        return this.nome; 
    }
    public double getNum(){ 
        return this.num; 
    }
    public int getQte(){ 
        return this.estoque; 
    }
    
    // Setters
    public void setNome(String nome){ 
        this.nome = nome; 
    }
    public void setNum(double num){ 
        this.num = num; 
    }
    public void setQte(int estoque){ 
        this.estoque = estoque; 
    }

    /**
     * Adicionar qunatia ao estoque
     * @param produtos
     */
    public void adicionar(int produtos){
        setQte(this.estoque + produtos);
    }

    /**
     * Remover ou vender quantia do estoque (se houver)
     * @param produtos
     * @throws Exception
     */
    public void remover(int produtos) throws Exception{
        if(this.estoque - produtos < 0){ 
            throw new Exception(); 
        }
        setQte(this.estoque - produtos);
    }


}