package model;

import java.util.ArrayList;
import java.util.UUID;

public class Gallery implements User {
	
	private Auth auth;
	private String id, name, about, address;
	private int number;
	private ArrayList<Employee> employees;
	private ArrayList<Order> orders;
	
	public Gallery(String username, String password, String name, String about, String address, String number) {
		id = UUID.randomUUID().toString();
		employees = new ArrayList<>();
		orders = new ArrayList<>();
		auth = new Auth(username, password);
		this.name = name;
		this.about = about;
		this.address = address;
		this.number = Integer.parseInt(number);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void addOrder(Order order) {
		orders.add(order);
	}
	public void setAuth(Auth auth) {
		this.auth = auth;
	}
	@Override
	public Auth getAuth() {
		return auth;
	}
	
}
