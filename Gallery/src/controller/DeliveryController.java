package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Order;
import model.OrderContainer;

public class DeliveryController {
	@FXML private Label name, address, phone, image, price;
	
	private Stage dialogStage;
	private Order order;
	private OrderContainer orders;

	public void setDialogStage(Stage stage) {
		dialogStage = stage;
	}
	
	//sad
	public void setOrder(Order order) {
		this.order = order;
		name.setText(order.getName());
		address.setText(order.getAddress());
		phone.setText(Integer.toString(order.getPhone()));
		image.setText(order.getIname());
		price.setText(Integer.toString(order.getImage().getPrice()));
	}
	
	@FXML
	void initialize() {
		orders = new OrderContainer();
	}
	
	@FXML
	void Delivered() {
		orders.deliverOrder(order);
		dialogStage.close();
	}
	
	@FXML
	void Close() {
		dialogStage.close();
	}

}
