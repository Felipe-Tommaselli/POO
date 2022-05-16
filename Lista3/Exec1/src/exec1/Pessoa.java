
public class Pessoa{

    public Pessoa(String nome, String endereco, String email, double telefone){
        this.nome = nome;
        this.end = endereco;
        this.email = email;
        this.tel = telefone;
    }

    // GETTERS
    public getNome(){
        return this.nome;
    }
    public getEnd(){
        return this.end;
    }
    public getEmail(){
        return this.email;
    }
    public getTel(){
        return this.tel;
    }

    // SETTER
    public setNome(String nome){
        this.nome = nome;
    } 
    public setEnd(String endereco){
        this.end = endereco;
    }
    public setEmail(String email){
        this.email = email;
    }
    public setTel(double telefone){
        this.tel = telefone;
    }

}