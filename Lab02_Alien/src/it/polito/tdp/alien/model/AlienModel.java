package it.polito.tdp.alien.model;

import java.util.*;

public class AlienModel {
	TreeMap<String, LinkedList<String>> dizionario;
	
	public AlienModel() {
		dizionario = new TreeMap<String, LinkedList<String>>();
	}
	
	/**
	 * Add a word to the dictionary alien-italian if it is not present yet, or add a translation
	 * @param w1 Alien word
	 * @param w2 Italian word
	 * @throws Exception Format incorrect (only letters accepted)
	 */
	public void addWord(String w1, String w2) throws Exception {
		w1 = w1.toLowerCase();
		w2 = w2.toLowerCase();
		if(!isCorrect(w1) || !isCorrect(w2))
			throw new Exception("Formato parola/e non corretto");
		if(!dizionario.containsKey(w1))
			dizionario.put(w1, new LinkedList<String>());
		dizionario.get(w1).add(w2);
	}
	
	/**
	 * Search in the dictionary to find the translations of the given word
	 * @param w The word in Alien
	 * @return translations if present as LinkedList<String>
	 * @throws Exception Incorrect format or word not present in the dictionary
	 */
	public LinkedList<String> findWord(String w) throws Exception {
		w = w.toLowerCase();
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
