package controller;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	private Stage primaryStage;

    @Override
    public void start(Stage stage) {
    	this.primaryStage = stage;
    	try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/view/Main.fxml"));
	        StackPane root = (StackPane) loader.load();

	    	BackgroundImage bg = new BackgroundImage(new Image(new File("src/data/images/bg.jpg").toURI().toString(), root.getWidth(), root.getHeight(), false, false),
	    	    	BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
	    	root.setBackground(new Background(bg));

	        MainController controller = loader.getController();
	        controller.setStage(primaryStage);

	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
	        
	        stage.setTitle("Gallery Control System");
	        stage.setMaximized(true);
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
