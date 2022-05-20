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

                int i = procuraContato(nome);
                if(i != -1){ 
                    System.out.println("** Aviso **\nJá há um registro com esse nome"); 
                    return; 
                }

                System.out.printf("Endereço: ");
                String end = EntradaTeclado.leString();
                System.out.printf("Email: ");
                String email = EntradaTeclado.leString();
                System.out.printf("Aniversário (DD/MM/AAAA): ");
                String bday = EntradaTeclado.leString();
                System.out.printf("Estado civil: ");
                String ciestadual = EntradaTeclado.leString();
                System.out.printf("CPF: ");
                double cpf = EntradaTeclado.leDouble();

                i = procuraContato(cpf);
                if(i != -1) { System.out.println("** Aviso **\nJá há um registro com esse CPF"); return; }

                System.out.printf("Insira o telefone: ");
                Double phone = EntradaTeclado.leDouble();
                pessoas[num_pessoas++] = new PessoaFisica(nome, end, email, bday, ciestadual, cpf, phone);
                //Adiciona nova pessoa no vetor de contatos

            } catch(Exception e) {
                System.out.printf("** Aviso **\nNão foi possível realizar o cadastro\nVerifique os valores de entrada");
            }
        }
    }


    //Função para cadastrar pessoa jurídica
    public void cadastrarJuridica() {
        if(num_pessoas == TAM-1) { //Verifica se há espaço no vetor
            System.out.println("ERRO: Agenda cheio"); 
            return;
        }

        try {
            //Faz as leituras do usuário
            System.out.println("**Pessoa Jurídica");
            System.out.printf("\nInsira o nome: ");
            String nome = EntradaTeclado.leString();

            int i = procuraContato(nome); //Verifica se há um registro c msm nome
            if(i != -1) { System.out.println("** Aviso **\nJá há um registro com esse nome"); return; }

            System.out.printf("Eendereço: ");
            String end = EntradaTeclado.leString();
            System.out.printf("Email: ");
            String email = EntradaTeclado.leString();
            System.out.printf("Razão social: ");
            String rsocial = EntradaTeclado.leString();
            System.out.printf("Inscrição estadual: ");
            String iestadual = EntradaTeclado.leString();
            System.out.printf("CNPJ: ");
            int cnpj = EntradaTeclado.leInt();

            i = procuraContato(cnpj); //Verifica se há registro c msm CNPJ
            if(i != -1) { System.out.println("** Aviso **\nJá há um registro com esse CNPJ"); return; }

            pessoas[num_pessoas++] = new PessoaJuridica(nome, end, email, rsocial, iestadual, cnpj);
            //Adiciona nova pessoa no vetor de contatos
            
        } catch(Exception e) {
            System.out.printf("** Aviso **\nNão foi possível realizar o cadastro\nVerifique os valores de entrada");
        }
    }


    //Função para imprimir um contato específico utilizando a toString
    public void imprimirContato(Pessoa pessoa) {
        if(pessoa instanceof PessoaFisica) {
            System.out.printf("" + (PessoaFisica)pessoa);
        } else {
            System.out.printf("" + (PessoaJuridica)pessoa);
        }
    }


    //Função para imprimir todos os contatos
    public void imprimirContatos() {
        for(int i = 0; i < num_pessoas; i++) {
            if(pessoas[i] == null) { continue; }
            imprimirContato(pessoas[i]);
        }
    }


    //Função para encontrar registro a partir do nome
    public int procuraContato(String nome) {
        for(int i = 0; i < num_pessoas; i++) {
            if(pessoas[i] == null) { continue; }
            if(pessoas[i].getnome().equals(nome)) { return i; }
        }
        return -1;
    }

    //Função para encontrar registro a partir do cpf / cnpj
    public int procuraContato(Double code) {
        for(int i = 0; i < num_pessoas; i++) {
            if(pessoas[i] == null) { continue; }
            if(pessoas[i] instanceof PessoaFisica) { 
                PessoaFisica p = (PessoaFisica)pessoas[i];
                if(p.getCPF() == code) { return i; } 
            } else {
                PessoaJuridica p = (PessoaJuridica)pessoas[i];
                if(p.getCNPJ() == code) { return i; }
            }
        }
        return -1;
    }


    //Função para encontrar pessoa específica
    public void encontrarPessoa() {
        System.out.printf("Insira a chave de busca (Nome, CPF ou CNPJ): ");
        String key = new String();
        int index = -1;

        try {
            key = EntradaTeclado.leString();
        } catch(Exception e) {
            System.out.printf("** Aviso **\nNão foi possível ler a chave de busca\nVerifique os valores de entrada");
        }

        try {
            //Caso seja possível converter a chave para número, faz a busca por CPF / CNPJ
            int code = Integer.parseInt(key); 
            index = procuraContato(code);
        } catch(NumberFormatException e) {
            //Caso contrário, faz a busca por nome
            index = procuraContato(key);
        }

        if(index == -1) { System.out.println("** Aviso **\nPessoa não encontrada\n"); return; }
        Pessoa p = pessoas[index];
        imprimirContato(p);
    }


    //Função para remover pessoa do vetor de contatos
    public void removerPessoa() {
        System.out.printf("Insira a chave de busca (Nome, CPF ou CNPJ): ");
        String key = new String();
        int index = -1;

        try {
            key = EntradaTeclado.leString();
        } catch(Exception e) {
            System.out.printf("** Aviso **\nNão foi possível ler a chave de busca\nVerifique os valores de entrada");
        }

        //Mesma busca que a utilizada anteriormente
        try {
            int code = Integer.parseInt(key);
            index = procuraContato(code);
        } catch(NumberFormatException e) {
            index = procuraContato(key);
        }

        if(index == -1) { System.out.println("** Aviso **\nPessoa não encontrada\n"); return; }
        for(int i = index; i < num_pessoas; i++) { //Traz todas as pessoas do vetor uma posição para frente
            pessoas[i] = pessoas[i+1];
        }
        System.out.println("Pessoa removida com sucesso\n");
        num_pessoas--;
    }
    
}