import java.lang.*;

/**
 * Classe que cria a estrutura de contatos
 */
public class Contatos{

    private Pessoa[] pessoas;
    private int num_pessoas;
    private final int TAM = 1000;
    /**
     * Constroi o vetor de contatos
     */
    public Contatos() {
        pessoas =  new Pessoa[TAM];
        num_pessoas = 0;
    }

    /**
     * Cadastra pessoas físicas (se houver como)
     */
    public void cadastrarFisica(){
        
        if(num_pessoas > TAM){
            System.out.println("Agenga cheia");
            return ;
        }
        else{
            try {
                //Faz a leitura das entradas do usuário
                System.out.println("Cadastrar Pessoa Física\nInserir dados:\n\n1. Nome");
                String nome = EntradaTeclado.leString();

                if(procuraContato(nome) != -1){ 
                    System.out.println("ERRO: Há um registro com esse nome"); 
                    return; 
                }

                System.out.printf("2. Endereço: ");
                String end = EntradaTeclado.leString();
                System.out.printf("3. Email: ");
                String email = EntradaTeclado.leString();
                System.out.printf("4. Telefone: ");
                double tel = EntradaTeclado.leDouble();
                System.out.printf("5. Aniversário (DD/MM/AAAA): ");
                double aniv = EntradaTeclado.leDouble();
                System.out.printf("6. Estado civil: ");
                String ecivil = EntradaTeclado.leString();
                System.out.printf("7. CPF: ");
                double cpf = EntradaTeclado.leDouble();

                if(procuraContato(cpf) != -1){ 
                    System.out.println("CPF já registrado\n"); 
                    return; 
                }
                
                // adiciona a nova pessoa nos contatos
                pessoas[num_pessoas++] = new PessoaFisica(nome, end, email, tel, cpf, aniv, ecivil);

            } catch(Exception e) {
                System.out.printf("Não foi possível realizar o cadastro");
            }
        }
    }

    /**
     * Cadastra pessoas físicas (se houver como)
     */
    public void cadastrarJuridica(){
        
        if(num_pessoas > TAM){
            System.out.println("Agenga cheia");
            return ;
        }
        else{
            try {
                //Faz a leitura das entradas do usuário
                System.out.println("Cadastrar Pessoa Física\nInserir dados:\n\n1. Nome");
                String nome = EntradaTeclado.leString();

                if(procuraContato(nome) != -1){ 
                    System.out.println("ERRO: Há um registro com esse nome"); 
                    return; 
                }

                System.out.printf("2. Endereço: ");
                String end = EntradaTeclado.leString();
                System.out.printf("3. Email: ");
                String email = EntradaTeclado.leString();
                System.out.printf("4. Telefone: ");
                double tel = EntradaTeclado.leDouble();
                System.out.printf("5. Razão social: ");
                String rsocial = EntradaTeclado.leString();
                System.out.printf("6. Inscrição estadual: ");
                double iestadual = EntradaTeclado.leDouble();
                System.out.printf("7. CNPJ: ");
                double cnpj = EntradaTeclado.leDouble();

                if(procuraContato(cnpj) != -1){ 
                    System.out.println("** Aviso **\nJá há um registro com esse CNPJ"); 
                    return; 
                }

                pessoas[num_pessoas++] = new PessoaJuridica(nome, end, email, tel, rsocial, iestadual, cnpj);

            } catch(Exception e) {
                System.out.printf("Não foi possível realizar o cadastro");
            }
        }
    }

    /**
     * imprimir um contato específico utilizando a toString
     * utilização de polimorfismo
     * @param pessoa
     */
    public void printContato(Pessoa pessoa){
        if(pessoa instanceof PessoaFisica){
            System.out.printf("" + (PessoaFisica) pessoa);
        }else{
            System.out.printf("" + (PessoaJuridica) pessoa);
        }
    }


    /**
     * imprimir varios contatos
     */
    public void printContatos() {
        for(int i = 0; i < num_pessoas; i++){
            if(pessoas[i] == null){ 
                continue; 
            }
            printContato(pessoas[i]);
        }
    }


    /**
     * Encontrar registro a partir do nome
     * @param nome
     * @return
     */
    public int procuraContato(String nome){
        for(int i = 0; i < num_pessoas; i++){
            if(pessoas[i] == null){ 
                continue; 
            }
            if(pessoas[i].getNome().equals(nome)){ 
                return i; 
            }
        }
        return -1;
    }

    /**
     * Encontrar registro a partir do cpf / cnpj
     * @param obj
     * @return
     */
    public int procuraContato(Double obj) {
        for(int i = 0; i < num_pessoas; i++){
            if(pessoas[i] == null){ 
                continue; 
            }
            if(pessoas[i] instanceof PessoaFisica){ 
                PessoaFisica p = (PessoaFisica)pessoas[i];
                if(p.getCPF() == obj){ 
                    return i; 
                } 
            }else{
                PessoaJuridica p = (PessoaJuridica)pessoas[i];
                if(p.getCNPJ() == obj){ 
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * Encontrar pessoa específica
     */
    public void encontrarPessoa(boolean flag) {
        System.out.printf("Buscar por Nome, CPF ou CNPJ? ");
        String busca = new String();
        int pos = -1;
        try{
            busca = EntradaTeclado.leString();
        }catch(Exception e){
            System.out.printf("Não foi possível ler a chave de busca");
        }
        try {
            // se der para converter a chave para número, faz a busca por CPF ou CNPJ
            double obj = Double.parseDouble(busca); 
            pos = procuraContato(obj);
        } catch(NumberFormatException e){
            // ou, faz a busca por nome
            pos = procuraContato(busca);
        }

        if(pos == -1){ 
            System.out.println("Erro: Pessoa não encontrada\n"); 
            return; 
        }
        if(flag == true){
            Pessoa a = pessoas[pos];
            printContato(a);    
        } else{        
            for(int i = pos; i < num_pessoas; i++) {
                pessoas[i] = pessoas[i+1];
            }
            num_pessoas--;
        }
        System.out.println("Operação realizada com sucesso\n");

    }
}