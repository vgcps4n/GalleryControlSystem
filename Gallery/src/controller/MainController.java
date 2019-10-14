package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Admin;
import model.Company;
import model.Employee;
import model.Image;
import model.ImageContainer;
import model.Member;
import model.User;
import view.Dialog;

public class MainController {
	@FXML private BorderPane pane;
	@FXML private TableView<Image> table;
	@FXML private TableColumn<Image, String> colName;
	@FXML private TableColumn<Image, String> colAuthor;
	@FXML private TableColumn<Image, String> colInfo;
	@FXML private JFXButton login;
	@FXML private Label username;
	
    private Stage Stage;
    private boolean isLogged;
    private User user;
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
    void Clicked() {
    	if(!isLogged) {
    		new Dialog(pane, Stage, "Зураг үзэх боломжгүй.", "Та эхлээд нэвтэрнэ үү.", 500, 400);
    		return;
    	}
    	if(table.getSelectionModel().getSelectedItem() == null) {
    		new Dialog(pane, Stage, "Зураг аа сонгоно уу.", "Үзэх зураг сонгогдоогүй байна.", 500, 400);
    		return;
    	}
    	System.out.println("Clicked.");
    	OpenImageWindow(table.getSelectionModel().getSelectedItem());
    }

    @FXML
    void Login() {
    	if(!isLogged) 
    		OpenLoginWindow();
    	else {
    		isLogged = false;
        	this.login.textProperty().setValue("Нэвтрэх");
        	username.setText("");
        	user = null;
        	OpenLoginWindow();
    	}
    		
    }
    
    @FXML
    void Exit() {
    	System.out.println("bye.");
    	Stage.close();
    }
    
    private void OpenImageWindow(Image image) {
    	try {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource("/view/Image.fxml"));
			BorderPane img = (BorderPane) loader.load();
			
			Stage imageWindow = new Stage();
            imageWindow.initModality(Modality.WINDOW_MODAL);
			imageWindow.initOwner(Stage);
			Scene scene = new Scene(img);
			imageWindow.setScene(scene);
			
			ImageController controller = loader.getController();
			imageWindow.setTitle(image.getName());
			controller.setDialogStage(imageWindow);
			controller.setImage(image);
			controller.setMember((Member) user);
			
			imageWindow.showAndWait();
			
		} catch (IOException e) {
			System.out.println("sad");
			e.printStackTrace();
		}
    	
    }
    
    private void OpenLoginWindow() {
    	try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            
            Stage loginWindow = new Stage();
            loginWindow.initModality(Modality.WINDOW_MODAL);
            loginWindow.initOwner(Stage);
            Scene scene = new Scene(login);
            loginWindow.setScene(scene);
            
            LoginController controller = loader.getController();
            loginWindow.setTitle("Нэвтрэх");
            controller.setDialogStage(loginWindow);
            
            loginWindow.showAndWait();
            
            if(controller.getAuth() == null) {
        		System.out.println("Login canceled.");
            } else {
            	user = controller.getAuth().getUser();
	        	if(user instanceof Member) {
	            	isLogged = true;
	            	username.setText(((Member) user).getName().getFirst() + " та тавтай морилно уу.");
	            	this.login.textProperty().setValue("Өөр хэрэглэгчээр нэвтрэх");
	        	} else if(user instanceof Employee) {
	        		SwitchEmployeeWindow((Employee) user);
	        	} else if(user instanceof Company) {
	        		SwitchCompanyWindow((Company) user);
	        	} else if(user instanceof Admin) {
	        		SwitchAdminWindow();
	        	}
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private void SwitchAdminWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Admin.fxml"));
            BorderPane admin = (BorderPane) loader.load();

            Scene adminWindow = new Scene(admin);
            
            AdminController controller = loader.getController();
            controller.setStage(Stage);
            controller.setRoot(Stage.getScene());
            Stage.setTitle("Админ");
    	    Stage.setScene(adminWindow);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void SwitchCompanyWindow(Company company) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Company.fxml"));
            BorderPane comp = (BorderPane) loader.load();

            Scene companyWindow = new Scene(comp);
            
            CompanyController controller = loader.getController();
            controller.setStage(Stage);
            controller.setRoot(Stage.getScene());
            controller.setCompany(company);
            Stage.setTitle("Компани");
    	    Stage.setScene(companyWindow);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void SwitchEmployeeWindow(Employee employee) {
    	try {
    		FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Employee.fxml"));
            BorderPane emp = (BorderPane) loader.load();

            Scene employeeWindow = new Scene(emp);
            
            EmployeeController controller = loader.getController();
            controller.setStage(Stage);
            controller.setRoot(Stage.getScene());
            controller.setEmployee(employee);
            Stage.setTitle("Ажилтан");
    	    Stage.setScene(employeeWindow);
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
