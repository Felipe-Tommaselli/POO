/*  *
 * Classe que cria a Pessoa jurídica a partir da Pessoa
 */
public class PessoaJuridica extends Pessoa{

    double iestadual, cnpj;
    String rsocial;
    /**
     * COnstrutor que a partir da herança da classe pessoa cria a Pessoa Jurídica
     * @param nome
     * @param endereco
     * @param email
     * @param telefone
     * @param cnpj
     * @param insestadual
     * @param razaosocial
     */
    public PessoaJuridica(String nome, String endereco, String email, double telefone, String razaosocial, double insestadual, double cnpj){
        super(nome, endereco, email, telefone);
        this.cnpj = cnpj;
        this.iestadual = insestadual;
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
    public void setrsocial(String razaosocial){
        this.rsocial = razaosocial;
    }

}