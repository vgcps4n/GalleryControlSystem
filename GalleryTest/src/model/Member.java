package model;

import java.util.ArrayList;
import java.util.UUID;

public class Member implements User {

	private String id, address;
	private Auth auth;
	private Name name;
	private int number;
	private ArrayList<Painting> bag;
	
	public Member(String username, String password, String firstname, String lastname, String address, String number) {
		id = UUID.randomUUID().toString();
		bag = new ArrayList<>();
		auth = new Auth(username, password);
		name = new Name(firstname, lastname);
		this.address = address;
		this.number = Integer.parseInt(number);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public ArrayList<Painting> getBag() {
		return bag;
	}

	public void addToBag(Painting painting) {
		bag.add(painting);
	}
	
	public void removeFromBag(Painting painting) {
		bag.remove(painting);
	}

	@Override
	public Auth getAuth() {
		return auth;
	}

}
