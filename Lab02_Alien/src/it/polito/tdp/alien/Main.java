package it.polito.tdp.alien;
	
import it.polito.tdp.alien.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		AlienModel model;
		FXMLLoader loader;
		AlienController controller;
		try {
			loader = new FXMLLoader(getClass().getResource("Alien.fxml"));
			model = new AlienModel();
			
			BorderPane root = (BorderPane)loader.load();
			controller = (AlienController)loader.getController();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			controller.setModel(model);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
