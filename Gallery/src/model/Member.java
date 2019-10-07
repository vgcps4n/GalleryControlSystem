package model;

import java.util.UUID;

public class Member implements User {
	String ID;
	Name name;
	Auth auth;
	int phone;
	Member() {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth();
	}
	Member(String username, String password) {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth(username, password, this);
	}
	Member(String lName, String fName, String username, String password, int phone) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
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
	public String getUsername() {
		return auth.getUsername();
	}

	@Override
	public String getPassword() {
		return auth.getPassword();
	}
	
}
