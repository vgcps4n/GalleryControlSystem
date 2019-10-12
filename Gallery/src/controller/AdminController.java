package controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.CompanyContainer;
import model.User;
import view.Dialog;

public class AdminController {
	@FXML private BorderPane pane;
	@FXML private TableView<User> table;
	@FXML private TableColumn<User, String> colName;
	@FXML private TextField name;
	@FXML private TextField phone;
	@FXML private TextArea about;
	@FXML private TextArea address;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField confirm;
	
    private Stage Stage;
    private Scene root;
    
    private CompanyContainer companies;
    
    public void setStage(Stage stage){
        this.Stage = stage;
        table.setItems(companies.getUsers());
    }
    
    public Stage getStage (Stage stage) {
    	return Stage;
    }

    public void setRoot(Scene root) {
    	this.root = root;
    }
    
    public Scene getRoot() {
    	return root;
    }
    
    @FXML
    void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
    	companies = new CompanyContainer();
    }
    
    @FXML
    void Create() {
		if(name.getText().toString().equals("") ||
				phone.getText().toString().equals("") ||
				about.getText().toString().equals("") ||
				address.getText().toString().equals("") ||
				username.getText().toString().equals("") ||
				password.getText().toString().equals("") ||
				confirm.getText().toString().equals("")) {
			new Dialog(pane, Stage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 650, 250);
		} else if(!password.getText().toString().equals(confirm.getText().toString()))
			new Dialog(pane, Stage, "Нууц үг таарсангүй.", "Нууц үгээ шалгана уу.", 650, 250);
		else {
			User company = companies.createCompany(name.getText().toString(), about.getText().toString(), 
					address.getText().toString(), Integer.parseInt(phone.getText().toString()), 
					username.getText().toString(), password.getText().toString());
			if(company == null) {
				new Dialog(pane, Stage, "Нэвтрэх нэр бүртгэгдсэн байна.", "Өөр нэвтрэх нэр сонгоно уу.", 650, 250);
				return;
			}
			new Dialog(pane, Stage, "Амжилттай.", "Компани амжилттай бүртгэгдлээ.", 650, 250);
			table.refresh();
			clear();
		}
    }
    
    void clear() {
    	name.setText("");
    	phone.setText("");
    	about.setText("");
    	address.setText("");
    	username.setText("");
    	password.setText("");
    	confirm.setText("");
    }
    
    @FXML
    void Logout() {
    	Stage.setScene(root);
    }
    
}
