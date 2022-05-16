
public class PessoaJuridica extends Pessoa{

    double iestadual, cnpj;
    String rsocial;
    public PessoaJuridica(String nome, String endereco, String email, double telefone, double cnpj, double iestadual, String razaosocial){
        super(nome, endereco, email, telefone);
        this.cnpj = cnpj;
        this.iestadual = iestadual;
        this.rsocial = razaosocial;
    }

    // GETTERS 
    public double getCNPJ(){
        return this.cnpj;
    }
    public double getiestadual(){
        return this.iestadual;
    }
    public double getrsocial(){
        return this.cnpj;
    }

    // SETTER
    public void setCNPJ(double cnpj){
        this.cnpj = cnpj;
    } 
    public void setiestadual(double iestadual){
        this.iestadual = iestadual;
    }
    public void setrsocial(String ecvivil){
        this.rsocial = rsocial;
    }

}