package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import it.polito.tdp.alien.model.*;

public class AlienController {
	
	AlienModel model;
	
	public AlienController() {
		model = null;
	}
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTranslation;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtArea.clear();
    }

    @FXML
    void initialize() {
        assert txtTranslation != null : "fx:id=\"txtTranslation\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Alien.fxml'.";

    }

    @FXML
    void doTranslate(ActionEvent event) throws Exception {
    	String word = txtTranslation.getText().trim();
    	LinkedList<String> translations = new LinkedList<String>();
    	if(!word.contains(" ")) {
    		//Qui per tradurre una parola
    		try{
    			translations = model.findWord(word);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
    		txtArea.appendText(toString(translations));
    	}
    	else {
    		//Qui per aggiungere una parola
    		txtArea.appendText("\n");
    		String translation = word.substring(word.indexOf(" ")+1).trim();
	    	word = word.substring(0, word.indexOf(" ")).trim();
	    	try{
	    		model.addWord(word, translation);
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	txtArea.appendText("Aggiunta '"+word.toLowerCase()+"' con traduzione '"+translation.toLowerCase()+"'\n");
    	}
    	txtTranslation.clear();
    }
    
    public void setModel(AlienModel model) {
    	this.model = model;
    }
    
    public AlienModel getModel() {
    	return model;
    }
    
    public String toString(LinkedList<String> lista) {
    	String result="";
    	for(String s:lista)
    		result+=s+" - ";
    	return result.substring(0, result.length()-3)+"\n";
    }
}
