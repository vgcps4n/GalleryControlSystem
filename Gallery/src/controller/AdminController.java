package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class AdminController {
	@FXML private JFXTextField name;
	@FXML private JFXTextField number;
	@FXML private JFXTextArea about;
	@FXML private JFXTextArea address;
	@FXML private JFXTextField username;
	@FXML private JFXPasswordField password;
	@FXML private JFXPasswordField confirm;
	
    private Stage Stage;
    
    public void setStage(Stage stage){
        this.Stage = stage;
    }
    
    public Stage getStage (Stage stage) {
    	return Stage;
    }

    
}
