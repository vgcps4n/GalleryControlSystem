package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderContainer {
	private static final ObservableList<Order> orders = FXCollections.observableArrayList();
	private static final ObservableList<Order> delivered = FXCollections.observableArrayList();
	
	public Order createOrder(String name, String address, int phone, Member member, Employee employee, Image image) {
		Order order = new Order(name, address, phone, member, employee, image);
		if(orders.contains(order))
			return null;
		orders.add(order);
		return order;
	}
	
	public static void createOrder(String ID, String name, String address, int phone, Member member, Employee employee, Image image) {
		Order order = new Order(ID, name, address, phone, member, employee, image);
		if(orders.contains(order))
			return;
		orders.add(order);
	}
	
	public static Order getOrder(String ID) {
		for(Order order: orders)
			if(order.getID().equals(ID))
				return order;
		return null;
	}
	
	public ObservableList<Order> getFilteredOrders(Company company) {
		ObservableList<Order> filtered = FXCollections.observableArrayList();
		for(Order order: orders)
			if(company.findEmployee(order.getEmployee()))
				filtered.add(order);
		return filtered;
	}
	
	public ObservableList<Order> getOrders() {
		return orders;
	}
	
	public void deliverOrder(Order order) {
		delivered.add(order);
		orders.remove(order);
	}

	public static ObservableList<Order> getDelivered() {
		return delivered;
	}
}
