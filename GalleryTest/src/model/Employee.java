package model;

import java.util.ArrayList;
import java.util.UUID;

public class Employee implements User {
	
	String id;
	Auth auth;
	Name name;
	int number;
	ArrayList<Painting> paintings;
	
	public Employee(String username, String password, String firstname, String lastname, String number) {
		id = UUID.randomUUID().toString();
		paintings = new ArrayList<>();
		auth = new Auth(username, password);
		name = new Name(firstname, lastname);
		this.number = Integer.parseInt(number);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<Painting> getPaintings() {
		return paintings;
	}

	public void addPaintings(Painting painting) {
		paintings.add(painting);
	}
	
	@Override
	public Auth getAuth() {
		return auth;
	}

}
