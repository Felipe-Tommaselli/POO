/**
 * Classe que cria a Pessoa Física a partir da Pessoa
 */
public class PessoaFisica extends Pessoa{

    double aniv, cpf;
    String ecivil;
    /**
     * Construtor que a partir da herança da classe pessoa cria a Pessoa Física
     * @param nome
     * @param endereco
     * @param email
     * @param telefone
     * @param cpf
     * @param aniversario
     * @param estadocivil
     */
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

    // SETTERS
    public void setCPF(double cpf){
        this.cpf = cpf;
    } 
    public void setAniv(double aniv){
        this.aniv = aniv;
    }
    public void setECivil(String estcvivil){
        this.ecivil = estcvivil;
    }

}