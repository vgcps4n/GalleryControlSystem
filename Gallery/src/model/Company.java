package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Company implements User {
	String ID, name, about, address;
	Auth auth;
	int phone;
	List<Employee> employees;
	
	public Company(String name, String about, String address, int phone, String username, String password) {
		ID = UUID.randomUUID().toString();
		this.name = name;
		this.about = about;
		this.address = address;
		this.auth = new Auth(username, password, this);
		this.phone = phone;
		this.employees = new ArrayList<>();
	}

	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void addEmployee(Employee employee) {
		employees.add(employee);
	}
	@Override
	public Auth getAuth() {
		return auth;
	}

}
