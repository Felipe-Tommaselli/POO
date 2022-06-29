/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contapalavra;

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

/**
 *
 * @author felip
 */
public class ContaPalavra {
    /**
     * programa para leitura do arquivo texto 
     * inspiração do código: https://stackoverflow.com/questions/4716503/reading-a-plain-text-file-in-java
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String ContaPalavra() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\felip\\Documents\\POO\\Collection\\text.txt"))){ //! 
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

    /**
     * Cria o mapeamento das palavras no txt
     * @param pl
     */
    public static void criaMapa(String pl){
    	String s = pl;
        Map<String, Integer> mapa = new HashMap<String, Integer>();
        
        String[] palavras = s.split(" "); 
        for(String p : palavras){
            int cont = mapa.get(p);
            if(mapa.containsKey(p))    
                mapa.put(p, cont + 1); 
            else
                mapa.put(p, 1);
        }
        mostraMapa(mapa);
	}
    
    /**
     * Mostra e ordenada o mapeamento das palavras feito
     * @param <K>
     * @param <V>
     * @param map
     */
    public static <K extends Comparable,V extends Comparable> void mostraMapa(Map <K, V> map){
    	List<K> chaves = new ArrayList<K>(map.keySet());
    	Collections.sort(chaves);
    	
    	Map<K, V> ordenado = new LinkedHashMap<K, V>();
    	for(K c : chaves)
    		ordenado.put(c, map.get(c));

        System.out.println("\nMAPA DE PALAVRAS:\n");
    	System.out.println(ordenado);
    }

	public static void main(String[] args) throws IOException{
		String linha = ContaPalavra();
		criaMapa(linha);
	}
}