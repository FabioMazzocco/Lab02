package it.polito.tdp.alien.model;

import java.util.*;

public class AlienModel {
	TreeMap<String, String> dizionario;
	
	public AlienModel() {
		dizionario = new TreeMap<String, String>();
	}
	
	public void addWord(String w1, String w2) throws Exception {
		if(!isCorrect(w1) || !isCorrect(w2))
			throw new Exception("Formato parola/e non corretto");
		if(dizionario.containsKey(w1))
			throw new Exception("Parola già inserita");
		dizionario.put(w1, w2);
	}
	
	public String findWord(String w) throws Exception {
		if(!isCorrect(w))
			throw new Exception("Formato parola/e non corretto");
		if(!dizionario.containsKey(w))
			throw new Exception("Parola inesistente");
		return dizionario.get(w);
	}
	
	public boolean isCorrect(String w) {
		char[] chars = w.toCharArray();

	    for (char c : chars)
	        if(!Character.isLetter(c))
	            return false;
	    return true;
	}
}
