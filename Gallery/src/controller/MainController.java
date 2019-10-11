package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Image;
import model.ImageContainer;

public class MainController {
	@FXML private TableView<Image> table;
	@FXML private TableColumn<Image, String> colName;
	@FXML private TableColumn<Image, String> colAuthor;
	@FXML private TableColumn<Image, String> colInfo;
	
	@FXML private Label username;
	
    private Stage Stage;
    private boolean isLogged;
    private ImageContainer images;
    
    public void setStage(Stage stage){
        this.Stage = stage;
        table.setItems(images.getImages());
    }
    
    public Stage getStage (Stage stage) {
    	return Stage;
    }

    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colInfo.setCellValueFactory(new PropertyValueFactory<>("info"));
        isLogged = false;
        images = new ImageContainer();
    }

    @FXML
    void Login(ActionEvent event) {
    	if(!isLogged) 
    		loginWindow();
    	else
    		System.out.println("is not logged.");
    }
    
    @FXML
    void Exit(ActionEvent event) {
    	System.out.println("bye.");
    	Stage.close();
    }
    
    private boolean loginWindow() {
    	
    	return false;
    }
    
}
