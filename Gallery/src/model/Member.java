package model;

import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Member implements User {
	String ID, address;
	Name name;
	Auth auth;
	int phone;
	ObservableList<Image> liked;
	
	Member(String lName, String fName, String username, String password, int phone, String address) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		this.address = address;
		liked = FXCollections.observableArrayList();
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

	public void addLiked(Image image) {
		liked.add(image);
	}
	
	public void deleteLiked(Image image) {
		liked.remove(image);
	}
	
	public boolean findLiked(Image image) {
		if(liked.contains(image)) 
			return true;
		return false;
	}
	
	public ObservableList<Image> getLiked() {
		return liked;
	}
	
	@Override
	public Auth getAuth() {
		return auth;
	}
	
}
