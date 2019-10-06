package model;

import java.util.List;
import java.util.UUID;

public class Employee implements User {
	String ID;
	Name name;
	Auth auth;
	int phone;
	List<Content> contents;
	Employee() {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth();
	}
	Employee(String username, String password) {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth(username, password);
	}
	Employee(String lName, String fName, String username, String password, int phone) {
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
