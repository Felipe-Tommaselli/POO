public class Loja {

    //Definição do vetor de itens
    private static final int SIZE = 1000;
    Estoque[] itens = new Estoque[SIZE];
    int nItens = 0;

    //Função para cadastro de produto
    public void cadastrarProduto() {
        int funcao = -1, amount = 0, code = -1;
        String name = "";

        System.out.println("\n** Adicionar Item **\n");
        System.out.println("Insira o item que deseja adicionar");
        System.out.println("1) Inserir Livro");
        System.out.println("2) Inserir CD");
        System.out.println("3) Inserir DVD");
        System.out.println("");
        try { funcao = EntradaTeclado.leInt(); }
        catch (Exception e) {
            System.out.println("\n** Erro **\nHouve um problema ao ler a função\nVerifique que o valor inserido é um inteiro de 1 a 3");
            return;
        }

        try {
            System.out.printf("Insira o código de barras para este produto: ");
            code = EntradaTeclado.leInt();

            int exists = encontrarProdutoViaChave(code);
            if(exists != -1) { System.out.printf("** Erro **\nJá existe um item com este código de barras"); return; }

            System.out.printf("Insira nome do produto: ");
            name = EntradaTeclado.leString();

            exists = encontrarProdutoViaChave(name);
            if(exists != -1) { System.out.printf("** Erro **\nJá existe um item com este código de barras"); return; }

            System.out.printf("Caso queira, insira uma quantidade inicial para o estoque: ");

            try {
                amount = EntradaTeclado.leInt();
                if(amount < 0) { 
                    System.out.printf("** Aviso **\nA quantidade inicial minima é 0");
                    amount = 0;
                }
            } catch(Exception e) { amount = 0; }
            

        } catch(Exception e) { System.out.println("\n** Erro **\nHouve um problema ao ler os valores de entrada"); return; }

        switch(funcao) {
            case 1: itens[nItens++] = new Livro(name, code, amount); break;
            case 2: itens[nItens++] = new CD(name, code, amount); break;
            case 3: itens[nItens++] = new DVD(name, code, amount); break;
            default: System.out.println("\n** Erro **\nHouve um problema ao ler a função\nVerifique que o valor inserido é um inteiro de 1 a 3");
        }
    }


    //Adicionar estoque a item ja existente
    public void adicionarProduto() {
        String key = "";
        int amount = 0;

        System.out.println("\n** Adicionar Estoque **\n");
        int index = coletarInformacoesEBuscarIndice();
        if(index == -1) { System.out.println("** Erro **\nItem não encontrado"); return; }

        try {
            System.out.println("Item " + itens[index].getName() + " encontrado");
            System.out.printf("Insira a quantidade que deseja acrescentar: ");
            amount = EntradaTeclado.leInt();

            if(amount <= 0) { System.out.println("\n** Erro **\nQuantia inválida"); return; }

        } catch(Exception e) { System.out.println("\n** Erro **\nHouve um problema ao ler os valores de entrada"); return; }

        itens[index].adicionar(amount);
        System.out.println("\n** Quantia adicionada com sucesso **");
        System.out.println("Quantidade atual: " + itens[index].getAmount());
    }


    //Função para encontrar produtos através do código de barras
    private int encontrarProdutoViaChave(int code) {
        for(int i = 0; i < nItens; i++) {
            if(code == itens[i].getCode()) { return i; }
        }
        return -1;
    }

    //Função para encontrar produtos através do nome
    private int encontrarProdutoViaChave(String name) {  
        for(int i = 0; i < nItens; i++) {
            if(name.equals(itens[i].getName())) { return i; }
        }
        return -1;
    }


    //Le dados de busca do usuário e retorna o índice do produto correspondente
    private int coletarInformacoesEBuscarIndice() {
        String key = "";
        int amount = 0, index = -1;

        try {
            System.out.printf("Insira o nome ou código de barras do item que deseja modificar ");
            key = EntradaTeclado.leString();

            try {
                int code = Integer.parseInt(key);
                index = encontrarProdutoViaChave(code);
                if(index == -1) { index = encontrarProdutoViaChave(key); } 
                //Faz a busca pelo nome caso nao encontre pelo codigo (nome pode ser apenas numeros)
            } 
            catch(Exception e) {
                index = encontrarProdutoViaChave(key);
            }
            
        } catch(Exception e) { System.out.println("\n** Erro **\nHouve um problema ao ler os valores de entrada"); return -2; }

        return index;
    }

    
    //Função para buscar e imprimir certo produto
    public void buscarProduto() {
        System.out.println("\n** Buscar Item **\n");
        int index = coletarInformacoesEBuscarIndice();
        if(index == -1) { System.out.println("\n** Erro **\nItem não encontrado"); return; }
        System.out.println("\n** Produto encontrado **\n" + itens[index]);
    }

    
    public void venderProduto() {
        System.out.println("\n** Vender Item **\n");
        int amount = 0, index = coletarInformacoesEBuscarIndice();
        if(index == -1) { System.out.println("\n** Erro **\nItem não encontrado"); return; }

        try {
            try {
                System.out.println("Item " + itens[index].getName() + " encontrado");
                System.out.printf("Insira a quantidade que deseja acrescentar: ");
                amount = EntradaTeclado.leInt();

                if(amount <= 0) { System.out.println("\n** Erro **\nQuantia inválida"); return; }

            } catch(Exception e) { System.out.println("\n** Erro **\nHouve um problema ao ler os valores de entrada"); return; }

            itens[index].remover(amount);
            System.out.println("\n** Remoção realizada com sucesso **\nNovo estoque: " + itens[index].getAmount());
        
        } catch(Exception e) {
            System.out.println("\n** Erro **\nA quantia fornecida é maior que a disponível em estoque");
        }
    }

    
    //Função para imprimir todo o estoque disponível
    public void imprimirEstoque() {
        System.out.println("\n** Imprimindo estoque **\n");
        for(int i = 0; i < nItens; i++) {
            System.out.println(itens[i]);
        }
    }


    //Função para excluir produto
    public void excluirProduto() {
        System.out.println("\n** Excluir Item **\n");
        int index = coletarInformacoesEBuscarIndice(); //Encontra o índice do produto a ser excluido
        if(index == -1) { System.out.println("\n** Erro **\nItem não encontrado"); return; }
        for(int i = index; i < nItens; i++) { //Faz a remoção do item
            itens[i] = itens[i+1];
        }
        nItens--;
        System.out.println("\n** Item excluido com sucesso **");
    }

}