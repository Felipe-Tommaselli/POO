/**
 * Classe que cria o básico de uma pessoa, comum a Juridica e a Fisica
 */
public class Pessoa{

    String nome, end, email;
    double tel;
    /**
     * Construtor do básico de uma pessoa (a ser expandido para pessoa fisica ou juridica por herança)
     * @param nome
     * @param endereco
     * @param email
     * @param telefone
     */
    public Pessoa(String nome, String endereco, String email, double telefone){
        this.nome = nome;
        this.end = endereco;
        this.email = email;
        this.tel = telefone;
    }

    // GETTERS
    public String getNome(){
        return this.nome;
    }
    public String getEnd(){
        return this.end;
    }
    public String getEmail(){
        return this.email;
    }
    public double getTel(){
        return this.tel;
    }

    // SETTERS
    public void setNome(String nome){
        this.nome = nome;
    } 
    public void setEnd(String endereco){
        this.end = endereco;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTel(double telefone){
        this.tel = telefone;
    }

}