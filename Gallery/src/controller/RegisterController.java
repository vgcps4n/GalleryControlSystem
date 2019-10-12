package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Auth;
import model.MemberContainer;
import model.User;
import view.Dialog;

public class RegisterController {
	@FXML private BorderPane root;
	@FXML private TextField fName;
	@FXML private TextField lName;
	@FXML private TextField phone;
	@FXML private TextArea address;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField confirm;
	
	private Stage dialogStage;
	private MemberContainer members;
	private Auth auth = null;
	
	private boolean success = false;
	
	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@FXML
	void initialize() {
		members = new MemberContainer();
	}
	
	@FXML
	void Submit() {
		if(fName.getText().toString().equals("") ||
				lName.getText().toString().equals("") ||
				phone.getText().toString().equals("") ||
				address.getText().toString().equals("") ||
				username.getText().toString().equals("") ||
				password.getText().toString().equals("") ||
				confirm.getText().toString().equals("")) {
			new Dialog(root, dialogStage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 350, 220);
		} else if(!password.getText().toString().equals(confirm.getText().toString()))
			new Dialog(root, dialogStage, "Нууц үг таарсангүй.", "Нууц үгээ шалгана уу.", 350, 220);
		else {
			User member = members.createMember(lName.getText().toString(), fName.getText().toString(), 
					username.getText().toString(), password.getText().toString(), 
					Integer.parseInt(phone.getText().toString()), address.getText().toString());
			if(member == null) {
				new Dialog(root, dialogStage, "Хэрэглэгч бүртгэгдсэн байна.", "Өөр нэвтрэх нэр сонгоно уу.", 350, 220);
				return;
			}
			auth = member.getAuth();
			success = true;
			dialogStage.close();
		}
	}
	
	@FXML
	void Cancel() {
		dialogStage.close();
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public Auth getAuth() {
		return auth;
	}
}
