package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Employee implements User {
	private String ID;
	private Name name;
	private Auth auth;
	private int phone;
	private List<Content> contents;
	Employee() {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth();
		contents = new ArrayList<>();
	}
	Employee(String username, String password) {
		ID = UUID.randomUUID().toString();
		name = new Name();
		auth = new Auth(username, password);
		contents = new ArrayList<>();
	}
	Employee(String lName, String fName, String username, String password, int phone) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password);
		this.phone = phone;
		contents = new ArrayList<>();
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
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
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
