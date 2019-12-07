package model;

import java.util.UUID;

public class Admin implements User {
	
	private String id;
	private Auth auth;
	private Name name;
	
	public Admin(String username, String password, String firstname, String lastname) {
		id = UUID.randomUUID().toString();
		auth = new Auth(username, password);
		name = new Name(firstname, lastname);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public Auth getAuth() {
		return auth;
	}
	public Name getName() {
		return name;
	}
}
