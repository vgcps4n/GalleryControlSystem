package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Admin;
import model.Auth;
import model.AuthContainer;
import view.Dialog;

public class LoginController {
	@FXML private AnchorPane root;
	@FXML private TextField username;
	@FXML private PasswordField password;
	
	Stage dialogStage;
	AuthContainer auths;
	Admin admin;
	Auth auth = null;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public Stage getDialogStage() {
        return dialogStage;
    }

    @FXML
    void initialize() {
        auths = new AuthContainer();
        admin = new Admin();
        auths.create(admin.getAuth());
        
        password.setOnKeyPressed(e -> {
        	if(e.getCode() == KeyCode.ENTER)
        		Login();
        });
    }
    
	@FXML
	void Login() {
		if(username.getText().toString().equals("") ||
				password.getText().toString().equals("")) {
			new Dialog(root, dialogStage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 250, 150);
			return;
		}
		auth = auths.find(username.getText().toString());
		if(auth == null)
			new Dialog(root, dialogStage, "Хэрэглэгч олдсонгүй.", "Та нэрээ шалгана уу.", 250, 150);
		else if(!auth.getPassword().equals(password.getText().toString())) {
			new Dialog(root, dialogStage, "Нууц үг буруу байна.", "Нууц үгээ шалгана уу.", 250, 150);
			auth = null;
		}else dialogStage.close();
	}
	
	@FXML
	void Cancel() {
		dialogStage.close();
	}
	
	@FXML
	void Register() {
		try{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/Register.fxml"));
            BorderPane cScene = (BorderPane) loader.load();
            
            Stage createWindow = new Stage();
            createWindow.initModality(Modality.WINDOW_MODAL);
            createWindow.initOwner(dialogStage);
            Scene scene = new Scene(cScene);
            createWindow.setScene(scene);
            
            RegisterController controller = loader.getController();
            createWindow.setTitle("Бүртгүүлэх");
            controller.setDialogStage(createWindow);
            
            createWindow.showAndWait();
            if(controller.isSuccess()) {
            	auth = controller.getAuth();
            	username.setText(auth.getUsername());
            	password.setText(auth.getPassword());
            	Login();
            }
		}catch(IOException e){
            e.printStackTrace();
        }    
	}
	
	public Auth getAuth() {
		return auth;
	}
}
