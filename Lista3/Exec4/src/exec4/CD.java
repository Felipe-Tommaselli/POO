public class CD extends Estoque {
    
    public CD(String name, long code, int amount) {
        super(name, code, amount);
    }

    @Override
    public String toString() {
        String s = "Tipo: CD\n";
        s += "Nome: " + getName() + "\n";
        s += "Código de Barras: " + getCode() + "\n";
        s += "Quantia em Estoque: " + getAmount() + "\n";
        return s;
    }

}