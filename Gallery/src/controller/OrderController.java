package controller;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.EmployeeContainer;
import model.Image;
import model.ImageContainer;
import model.Member;
import model.OrderContainer;
import view.Dialog;

public class OrderController {
	@FXML private BorderPane root;
	@FXML private TableView<Image> table;
	@FXML private TableColumn<Image, String> colName;
	@FXML private TableColumn<Image, Integer> colPrice;
	@FXML private Label total;
	@FXML private Label username;
	@FXML private TextArea address;
	@FXML private TextField phone;
	@FXML private JFXButton pay;
	
	private Stage dialogStage;
	private OrderContainer orders;
	private ImageContainer images;
	private EmployeeContainer employees;
	private Member member;
	private Image image;
	private int sum;
	private boolean paid = false, confirmed = false;
	
	public Stage getDialogStage() {
		return dialogStage;
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}

	public void setMember(Member member) {
		this.member = member;
		table.setItems(member.getBag());
		username.setText(member.getName().getFirst());
		phone.setText(Integer.toString(member.getPhone()));
		address.setText(member.getAddress());
		calc();
	}
	
	private void calc() {
		for(Image image: table.getItems())
			sum += image.getPrice();
		total.setText(Integer.toString(sum));
		sum = 0;
	}
	
	@FXML
	void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        orders = new OrderContainer();
        images = new ImageContainer();
        employees = new EmployeeContainer();
        sum = 0;
	}
	
	@FXML
	void Confirm() {
		if(!paid) {
			new Dialog(root, dialogStage, "Төлбөр төлөгдөөгүй.", "Төлбрөө төлнө үү.", 450, 240);
			return;
		}
		confirmed = true;
		
		//order creation
		for(int i=0; i<member.getBag().size(); i++) {
			image = member.getBag().get(i);
			orders.createOrder(username.getText().toString(), address.getText().toString(),
					Integer.parseInt(phone.getText().toString()),
					member, employees.findImage(image), image);
		}
		//remove from image container
		images.getImages().removeAll(member.getBag());
		//clear bag
		member.getBag().clear();
		dialogStage.close();
	}
	
	@FXML
	void Pay() {
		paid = !paid;
		pay.setDisable(true);
	}
	
	@FXML
	void Delete() {
		Image selectedImage = table.getSelectionModel().getSelectedItem();
		if(selectedImage != null) {
			member.deleteFromBag(selectedImage);
			if(table.getItems().isEmpty())
				dialogStage.close();
			calc();
		}
		else
			new Dialog(root, dialogStage, "Зураг хасах боломжгүй.", "Хасах зургаа сонгоно уу.", 450, 240);
	}
	
	@FXML
	void Cancel() {
		dialogStage.close();
	}
}
