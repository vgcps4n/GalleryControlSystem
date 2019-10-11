package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Employee implements User {
	private String ID;
	private Name name;
	private Auth auth;
	private int phone;
	private List<Image> images;
	Employee() {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth();
		images = new ArrayList<>();
	}
	Employee(String username, String password) {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth(username, password, this);
		images = new ArrayList<>();
	}
	Employee(String lName, String fName, String username, String password, int phone) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		images = new ArrayList<>();
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
	public List<Image> getImages() {
		return images;
	}
	public void addImage(Image image) {
		images.add(image);
	}
	@Override
	public Auth getAuth() {
		return auth;
	}
}
