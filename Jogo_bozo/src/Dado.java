/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 11800910
 */

public class Dado {

    private int faces;
    private int numeroRolado;
    private Random random;

    public Dado() {
        this.faces = 6;
        random = new Random();
    }

    public Dado(int n) {
        this.faces = n;
        random = new Random();
    }

    public int getLado() {
        return this.numeroRolado;
    }

    public int rolar() {
        this.numeroRolado = this.random.getIntRand(this.faces) + 1;
        return this.numeroRolado;
    }

    @Override
    public String toString() {
        String s = new String("");
        s = s + "+-----+\n";
        
        switch(this.numeroRolado) {
            case 1:
                s = s + "|     |\n";
                s = s + "|  *  |\n";
                s = s + "|     |\n";
                break;

            case 2:
                s = s + "|*    |\n";
                s = s + "|     |\n";
                s = s + "|    *|\n";
                break;

            case 3:
                s = s + "|*    |\n";
                s = s + "|  *  |\n";
                s = s + "|    *|\n";
                break;

            case 4:
                s = s + "|*   *|\n";
                s = s + "|     |\n";
                s = s + "|*   *|\n";
                break;
            
            case 5:
                s = s + "|*   *|\n";
                s = s + "|  *  |\n";
                s = s + "|*   *|\n";
                break;

            case 6:
                s = s + "|* * *|\n";
                s = s + "|     |\n";
                s = s + "|* * *|\n";
                break;
        }

        s = s + "+-----+\n";
        return s;
    }

    public static void main(String[] args) {

    }
}