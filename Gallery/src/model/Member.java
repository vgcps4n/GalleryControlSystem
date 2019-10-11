package model;

import java.util.UUID;

public class Member implements User {
	String ID, address;
	Name name;
	Auth auth;
	int phone;
	
	Member(String lName, String fName, String username, String password, int phone, String address) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		this.address = address;
	}
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public int getPhone() {
		return phone;
	}
	
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public Name getName() {
		return name;
	}
	
	@Override
	public Auth getAuth() {
		return auth;
	}
	
}
