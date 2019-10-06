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
	Member(String lName, String fName, String username, String password, int phone) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password);
		this.phone = phone;
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
