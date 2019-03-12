package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import it.polito.tdp.alien.model.*;

public class AlienController {
	
	AlienModel model;
	
	public AlienController() {
		model=null;
		txtArea.appendText("Welcome to Alien Translator v2019");
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
    private TextField txtNewWord;

    @FXML
    private TextArea txtArea;
    
    @FXML
    private Button btnAddWord;

    @FXML
    void doAddWord(ActionEvent event) throws Exception {
    	txtArea.clear();
    	String word = txtNewWord.getText().trim();
    	if(!word.contains(" ")) {
    		txtArea.appendText("Formato errato");
    		return;
    	}
    	String translation = word.substring(word.indexOf(" ")+1).trim();
    	word = word.substring(0, word.indexOf(" ")).trim();
    	try{
    		model.addWord(word, translation);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	txtArea.appendText("Aggiunta '"+word+"' con traduzione '"+translation+"'\n");
    	txtNewWord.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String word = txtTranslation.getText().trim();
    	txtTranslation.clear();
    }

    @FXML
    void initialize() {
        assert txtTranslation != null : "fx:id=\"txtTranslation\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtNewWord != null : "fx:id=\"txtNewWord\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnAddWord != null : "fx:id=\"btnAddWord\" was not injected: check your FXML file 'Alien.fxml'.";

    }
    
    public void setModel(AlienModel model) {
    	this.model = model;
    }
    
    public AlienModel getModel() {
    	return model;
    }
}
