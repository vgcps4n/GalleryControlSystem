package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Company;
import model.CompanyContainer;
import model.User;
import view.Dialog;

public class AdminController {
	@FXML private BorderPane pane;
	@FXML private TableView<Company> table;
	@FXML private TableColumn<Company, String> colName;
	@FXML private TextField name;
	@FXML private TextField phone;
	@FXML private TextArea about;
	@FXML private TextArea address;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField confirm;
	
    private Stage stage;
    private Scene root;
    
    private CompanyContainer companies;
    private ObservableList<Company> comps;
    
    public void setStage(Stage stage){
        this.stage = stage;
        for(User company: companies.getUsers())
        	if(company instanceof Company)
        		comps.add((Company) company);
        table.setItems(comps);
    }
    
    public Stage getStage (Stage stage) {
    	return stage;
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
    	table.setPlaceholder(new Label("Хоосон."));
    	comps  = FXCollections.observableArrayList();
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
			new Dialog(pane, stage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 650, 250);
		} else if(!password.getText().toString().equals(confirm.getText().toString()))
			new Dialog(pane, stage, "Нууц үг таарсангүй.", "Нууц үгээ шалгана уу.", 650, 250);
		else {
			if(!phone.getText().toString().matches("[0-9]*")) {
				new Dialog(pane, stage, "Дугаар буруу байна.", "Дугаараа зөв оруулна уу.", 650, 250);
				return;
			}
			Company company = (Company) companies.createCompany(name.getText().toString(), about.getText().toString(), 
					address.getText().toString(), Integer.parseInt(phone.getText().toString()), 
					username.getText().toString(), password.getText().toString());
			if(company == null) {
				new Dialog(pane, stage, "Нэвтрэх нэр бүртгэгдсэн байна.", "Өөр нэвтрэх нэр сонгоно уу.", 650, 250);
				return;
			}
			new Dialog(pane, stage, "Амжилттай.", "Компани амжилттай бүртгэгдлээ.", 650, 250);
			comps.add(company);
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
    	stage.setTitle("Gallery Control System");
    	stage.setScene(root);
    }
    
}
