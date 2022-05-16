
public class Pessoa{

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

    // SETTER
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