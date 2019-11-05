package controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Company;
import model.CompanyContainer;
import model.Employee;
import model.EmployeeContainer;
import model.Name;
import model.Order;
import model.OrderContainer;
import model.User;
import view.Dialog;

public class CompanyController {
	@FXML private BorderPane pane;
	@FXML private TableView<Name> table;
	@FXML private TableColumn<Name, String> colL;
	@FXML private TableColumn<Name, String> colF;
	@FXML private TableView<Order> order;
	@FXML private TableColumn<Order, String> colUser, colImg, colEmp;
	@FXML private Label name;
	@FXML private TextField fName;
	@FXML private TextField lName;
	@FXML private TextField phone;
	@FXML private TextField username;
	@FXML private PasswordField password;
	@FXML private PasswordField confirm;
	
	private Stage stage;
	private Scene root;
	private Company company;
	private CompanyContainer companies;
	private OrderContainer orders;
	private ObservableList<Name> names = FXCollections.observableArrayList();

	private EmployeeContainer employees;
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setRoot(Scene root) {
		this.root = root;
	}
	
	public void setCompany(User company) {
		this.company = (Company) company;
		for(Employee employee: this.company.getEmployees())
			names.add(employee.getName());
		table.setItems(names);
		order.setItems(orders.getFilteredOrders(this.company));
		name.setText(this.company.getName() + " Галлерей");
	}
	
	@FXML
	void initialize() {
        colF.setCellValueFactory(new PropertyValueFactory<>("first"));
        colL.setCellValueFactory(new PropertyValueFactory<>("last"));
        colUser.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmp.setCellValueFactory(new PropertyValueFactory<>("ename"));
        colImg.setCellValueFactory(new PropertyValueFactory<>("iname"));
        employees = new EmployeeContainer();
        companies = new CompanyContainer();
        orders = new OrderContainer();
        
        order.setRowFactory(tv -> {
        	TableRow<Order> row = new TableRow<>();
        	row.setOnMouseClicked(event -> {
        		if(event.getClickCount() == 2 && !row.isEmpty()) {
        			OpenDeliveryWindow(row.getItem());
        		}
        	});
            return row;
        });
        
	}
	
	@FXML
	void Submit() {
		if(fName.getText().toString().equals("") ||
			lName.getText().toString().equals("") ||
			phone.getText().toString().equals("") ||
			username.getText().toString().equals("") ||
			password.getText().toString().equals("") ||
			confirm.getText().toString().equals("")) {
			new Dialog(pane, stage, "Талбар дутуу байна.", "Бүх талбрыг бөглөнө үү.", 400, 280);
		} else if(!password.getText().toString().equals(confirm.getText().toString()))
			new Dialog(pane, stage, "Нууц үг таарсангүй.", "Нууц үгээ шалгана уу.", 400, 280);
		else {
			if(!phone.getText().toString().matches("[0-9]*")) {
				new Dialog(pane, stage, "Дугаар буруу байна.", "Дугаараа зөв оруулна уу.", 400, 280);
				return;
			}
			User employee = employees.createEmployee(lName.getText().toString(), fName.getText().toString(), 
					Integer.parseInt(phone.getText().toString()), username.getText().toString(), password.getText().toString());
			if(employee == null) {
				new Dialog(pane, stage, "Нэвтрэх нэр бүртгэгдсэн байна.", "Өөр нэвтрэх нэр сонгоно уу.", 400, 280);
				return;
			}
			new Dialog(pane, stage, "Амжилттай.", "Ажилтан амжилттай бүртгэгдлээ.", 400, 280);
			
			companies.addEmployee(company, (Employee) employee);
			names.add(((Employee) employee).getName());
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
		stage.setTitle("Gallery Control System");
		stage.setScene(root);
	}
	
	private void OpenDeliveryWindow(Order order) {
    	try {
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(Main.class.getResource("/view/Delivery.fxml"));
			BorderPane delivery = (BorderPane) loader.load();
			
			Stage deliveryWindow = new Stage();
            deliveryWindow.initModality(Modality.WINDOW_MODAL);
			deliveryWindow.initOwner(stage);
			Scene scene = new Scene(delivery);
			deliveryWindow.setScene(scene);
			
			DeliveryController controller = loader.getController();
			deliveryWindow.setTitle("Хүргэлт");
			controller.setDialogStage(deliveryWindow);
			controller.setOrder(order);
			
			deliveryWindow.showAndWait();

			this.order.setItems(orders.getFilteredOrders(company));
		} catch (IOException e) {
			System.out.println("sad");
			e.printStackTrace();
		}
    	
    }
}
