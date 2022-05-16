
public class PessoaJurifica extends Pessoa{

    public PessoaJurifica(String nome, String endereco, String email, double telefone, double cnpj, double aniversario, String estadocivil){
        super(nome, endereco, email, telefone);
        this.cnpj = cnpj;
        this.aniv = aniversario;
        this.ecivil = estadocivil;
    }

    // GETTERS 
    public double getCNPJ(){
        return this.cnpj;
    }
    public double getAniv(){
        return this.aniv;
    }
    public double getECivil(){
        return this.cnpj;
    }

    // SETTER
    public void setCNPJ(double cnpj){
        this.cnpj = cnpj;
    } 
    public void setAniv(String aniv){
        this.aniv = aniv;
    }
    public void setECivil(String ecvivil){
        this.ecivil = ecivil;
    }

}