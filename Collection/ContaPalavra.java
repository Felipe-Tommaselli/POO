/**
 *
 * @author 11800910
 */

import java.util.Collections;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;


public class ContaPalavra {

	public static String ContaPalavra() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/home/gian/Documentos/file.txt"))){ //! 
            StringBuilder sb = new StringBuilder(); 
            String linha = br.readLine();     

            while (linha != null) {
                sb.append(linha);
                sb.append(System.lineSeparator());
                linha = br.readLine();
            }
            
            return sb.toString();
        }     
	}
	
    public static void criaMapa(String palavras_na_linha){
    	String str = palavras_na_linha;
        Map<String, Integer> mapa = new HashMap<String, Integer>(); // Mapa de String para Integer
        
        String[] palavras = str.split(" "); 
        
        // Itera as palavras que estão espaçadas
        for(String palavra : palavras){
            if(mapa.containsKey(palavra))
                mapa.put(palavra, mapa.get(palavra) + 1); // Palavra já está no mapa, mas ocorre mais de uma vez
            else
                mapa.put(palavra, 1); // Caso a palavra ainda não esteja no mapa, adiciona ela
        }
        mostraMapa(mapa);
	}
    
    public static <K extends Comparable,V extends Comparable> void mostraMapa(Map <K, V> map){
    	List<K> map_key = new ArrayList<K>(map.keySet());
    	Collections.sort(map_key);
    	
    	Map<K, V> sorted_map = new LinkedHashMap<K, V>();
    	
    	for(K key : map_key)
    		sorted_map.put(key, map.get(key));
    	
    	System.out.println(sorted_map);
    }
        
	public static void main(String[] args) throws IOException{
		String linha = ContaPalavra();
		
		criaMapa(linha);
	}
}