/**
 *
 * @author 11800910
 */

// input output classes
import java.io.*;


public class ContaPalavra {
    
    public void leTexto() throws Exception {
        File file = new File("C:\\Users\\felip\\Documents\\POO\\Collection\\text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        while ((st = br.readLine()) != null)
            System.out.println(st);
    }

    public ContaPalavra() throws Exception{
        System.out.println("hello world");
    }

    public static void main(String[] args){

    }

}
