package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;

    @Override
    public void start(Stage stage) {
    	this.primaryStage = stage;
    	try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/view/Main.fxml"));
	        BorderPane root = (BorderPane) loader.load();

	        MainController controller = loader.getController();
	        controller.setStage(primaryStage);
	
	        Scene scene = new Scene(root);
	        
	        stage.setTitle("Gallery Control System");
	        stage.setScene(scene);
	        stage.show();
    	} catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}

}
