public class Loja {

    private static final int TAM = 1000;
    Estoque[] itens = new Estoque[TAM];
    int num_itens = 0;

    /**
     * cadastro de produto
     */
    public void cadastraProduto(){
        System.out.println("\nAdicionar Item \n\n");

        System.out.println("1) Inserir Livro");
        System.out.println("2) Inserir CD");
        System.out.println("3) Inserir DVD");
        System.out.println("");

        int modo = -1; 
        int qte = 0; 
        int num = -1;
        String nome = "";
        try{ 
            modo = EntradaTeclado.leInt(); 
        }
        catch (Exception e){
            System.out.println("\nErro: Bad input");
            return;
        }

        try{
            System.out.printf("Código de barras para este produto: ");
            num = EntradaTeclado.leInt();

            if(ctProduto_codigo(num) != -1){ 
                System.out.printf("Erro: produto já cadastrado\n"); 
                return; 
            }

            System.out.printf("Insira nome do produto: ");
            nome = EntradaTeclado.leString();

            if(ctProduto_codigo(nome) != -1){ 
                System.out.printf("Erro: produto já cadastrado\n"); 
                return; 
            }

            System.out.printf("Insira uma qte inicial para o estoque se quiser: ");

            try {
                qte = EntradaTeclado.leInt();
                if(qte < 0){ 
                    System.out.printf("\n>> A quantidade inicial minima é 0");
                    qte = 0;
                }
            } catch(Exception e){ 
                qte = 0; 
            }
        } catch(Exception e){ 
            System.out.println("\nErro: Não foi possível ler os valores da entrada"); 
            return; 
        }

        switch(modo){
            case 1: itens[num_itens++] = new Livro(nome, num, qte); 
                break;
            case 2: itens[num_itens++] = new CD(nome, num, qte); 
                break;
            case 3: itens[num_itens++] = new DVD(nome, num, qte); 
                break;
            default: System.out.println("\nErro: Houve um problema ao ler o modo");
        }
    }


    /**
     * Adicionar mais estoque a um item ja existente
     */
    public void adicionarProduto(){
        String flag = "";
        int qte = 0;

        System.out.println("\n Adicionar Estoque \n");
        int pos = ctIndice();
        if(pos == -1){ System.out.println("Erro \nItem não encontrado"); return; }

        try {
            System.out.println("Item "+ itens[pos].getNome() + "encontrado");
            System.out.printf("Insira a quantidade que deseja acrescentar: ");
            qte = EntradaTeclado.leInt();

            if(qte <= 0){ System.out.println("\nErro: Quantia inválida"); return; }

        } catch(Exception e){ System.out.println("\nErro: Houve um problema ao ler os valores de entrada"); return; }

        itens[pos].adicionar(qte);
        System.out.println("\n Quantia adicionada com sucesso ");
        System.out.println("Quantidade atual: "+ itens[pos].getQte());
    }


    /**
     * Encontrar produtos através do código de barras
     * @param num
     * @return
     */
    public int ctProduto_codigo(int num){
        for(int i = 0; i < num_itens; i++){
            if(num == itens[i].getNum()){ 
                return i;
            }
        }
        return -1;
    }

    /**
     * Encontrar produtos através do nome
     * @param nome
     * @return
     */
    public int ctProduto_codigo(String nome){  
        for(int i = 0; i < num_itens; i++){
            if(nome.equals(itens[i].getNome())){ 
                return i; 
            }
        }
        return -1;
    }


    /**
     * Le dados de busca do usuário e retorna a posição do produto
     * @return
     */
    public int ctIndice(){
        String flag = "";
        int qte = 0, pos = -1;

        try {
            System.out.printf("Insira o nome ou código de barras do item que deseja modificar ");
            flag = EntradaTeclado.leString();

            try {
                int num = Integer.parseInt(flag);
                pos = ctProduto_codigo(num);
                if(pos == -1){ pos = ctProduto_codigo(flag); } 
                //Faz a busca pelo nome caso nao encontre pelo codigo (nome pode ser apenas numeros)
            } 
            catch(Exception e){
                pos = ctProduto_codigo(flag);
            }
            
        } catch(Exception e){ System.out.println("\nErro: Houve um problema ao ler os valores de entrada"); return -2; }

        return pos;
    }

    
    /**
     * imprimir todo o estoque disponível
     */
    public void printEstoque(){
        System.out.println("\n Imprimindo estoque \n");
        for(int i = 0; i < num_itens; i++){
            System.out.println(itens[i]);
        }
    }


    /**
     * excluir produto
     */
    public void excluirProduto(){
        System.out.println("\n Excluir Item \n");
        int pos = ctIndice(); 
        if(pos == -1){ 
            System.out.println("\nErro: Item não encontrado"); 
            return; }
        for(int i = pos; i < num_itens; i++){ 
            itens[i] = itens[i+1];
        }
        num_itens--;
        System.out.println("\n Item excluido");
    }

    /**
     * buscar e imprimir certo produto
     */
    public void getProduto(){
        System.out.println("\n Buscar Item \n");
        int pos = ctIndice();
        if(pos == -1){ System.out.println("\nErro: Item não encontrado"); return; }
        System.out.println("\n Produto encontrado \n"+ itens[pos]);
    }

    /**
     * Vender produto (remover)
     */
    public void removeProduto(){
        System.out.println("\n Vender Item \n");
        int qte = 0, pos = ctIndice();
        if(pos == -1){ System.out.println("\nErro: Item não encontrado"); return; }

        try {
            try {
                System.out.println("Item "+ itens[pos].getNome() + "encontrado");
                System.out.printf("Insira a quantidade que deseja acrescentar: ");
                qte = EntradaTeclado.leInt();

                if(qte <= 0){ System.out.println("\nErro: Quantia inválida"); return; }

            } catch(Exception e){ System.out.println("\nErro: Houve um problema ao ler os valores de entrada"); return; }

            itens[pos].remover(qte);
            System.out.println("\n Remoção realizada com sucesso \nNovo estoque: "+ itens[pos].getQte());
        
        } catch(Exception e){
            System.out.println("\nErro: A quantia fornecida é maior que a disponível em estoque");
        }
    }

}