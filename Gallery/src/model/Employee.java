package model;

import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Employee implements User {
	private String ID;
	private Name name;
	private Auth auth;
	private int phone;
	private ObservableList<Image> images;
	
	Employee(String lName, String fName, int phone, String username, String password) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		images = FXCollections.observableArrayList();
	}
	
	Employee(String ID, String lName, String fName, int phone, String username, String password) {
		this.ID = ID;
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		images = FXCollections.observableArrayList();
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public void setName(String lName, String fName) {
		name.setLast(lName);
		name.setFirst(fName);
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public ObservableList<Image> getImages() {
		return images;
	}
	public void addImage(Image image) {
		images.add(image);
	}
	public void deleteImage(Image image) {
		images.remove(image);
	}
	@Override
	public Auth getAuth() {
		return auth;
	}
}
