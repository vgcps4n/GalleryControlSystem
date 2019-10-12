package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Company;
import model.Employee;
import model.EmployeeContainer;
import model.Name;
import model.User;
import view.Dialog;

public class CompanyController {
	@FXML private BorderPane pane;
	@FXML private TableView<Name> table;
	@FXML private TableColumn<Name, String> colL;
	@FXML private TableColumn<Name, String> colF;
	@FXML private TextField fName;
	@FXML private TextField lName;
	@FXML private TextField phone;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField confirm;
	
	private Stage Stage;
	private Scene root;
	private Company company;
	private ObservableList<Name> names = FXCollections.observableArrayList();

	private EmployeeContainer employees;
	
	public Stage getStage() {
		return Stage;
	}

	public void setStage(Stage stage) {
		Stage = stage;
	}
	
	public void setRoot(Scene root) {
		this.root = root;
	}
	
	public void setCompany(User company) {
		this.company = (Company) company;
		for(Employee employee: this.company.getEmployees()) 
			names.add(employee.getName());
		table.setItems(names);
	}
	
	@FXML
	void initialize() {
        colF.setCellValueFactory(new PropertyValueFactory<>("first"));
        colL.setCellValueFactory(new PropertyValueFactory<>("last"));
        employees = new EmployeeContainer();
	}
	
	@FXML
	void Submit() {
		if(fName.getText().toString().equals("") ||
			lName.getText().toString().equals("") ||
			phone.getText().toString().equals("") ||
			username.getText().toString().equals("") ||
			password.getText().toString().equals("") ||
			confirm.getText().toString().equals("")) {
		new Dialog(pane, Stage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 400, 280);
	} else if(!password.getText().toString().equals(confirm.getText().toString()))
		new Dialog(pane, Stage, "Нууц үг таарсангүй.", "Нууц үгээ шалгана уу.", 400, 280);
	else {
		User employee = employees.createEmployee(fName.getText().toString(), lName.getText().toString(), 
				Integer.parseInt(phone.getText().toString()), username.getText().toString(), password.getText().toString());
		if(employee == null) {
			new Dialog(pane, Stage, "Нэвтрэх нэр бүртгэгдсэн байна.", "Өөр нэвтрэх нэр сонгоно уу.", 400, 280);
			return;
		}
		new Dialog(pane, Stage, "Амжилттай.", "Ажилтан амжилттай бүртгэгдлээ.", 400, 280);
		company.addEmployee((Employee) employee);
		table.refresh();
		clear();
	}
	}

    void clear() {
    	fName.setText("");
    	lName.setText("");
    	phone.setText("");
    	username.setText("");
    	password.setText("");
    	confirm.setText("");
    }
    
	@FXML
	void Logout() {
		Stage.setScene(root);
	}
}
