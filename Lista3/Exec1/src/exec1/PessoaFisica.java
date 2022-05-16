
public class PessoaFisica extends Pessoa{

    public PessoaFisica(String nome, String endereco, String email, double telefone, double cpf, double aniversario, String estadocivil){
        super(nome, endereco, email, telefone);
        this.cpf = cpf;
        this.aniv = aniversario;
        this.ecivil = estadocivil;
    }

    // GETTERS 
    public double getCPF(){
        return this.cpf;
    }
    public double getAniv(){
        return this.aniv;
    }
    public double getECivil(){
        return this.cpf;
    }

    // SETTER
    public void setCPF(double cpf){
        this.cpf = cpf;
    } 
    public void setAniv(String aniv){
        this.aniv = aniv;
    }
    public void setECivil(String ecvivil){
        this.ecivil = ecivil;
    }

}