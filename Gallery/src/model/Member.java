package model;

import java.util.UUID;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Member implements User {
	String ID, address;
	Name name;
	Auth auth;
	int phone;
	ObservableList<Image> liked, bag;
	
	Member(String lName, String fName, String username, String password, int phone, String address) {
		ID = UUID.randomUUID().toString();
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		this.address = address;
		liked = FXCollections.observableArrayList();
		bag = FXCollections.observableArrayList();
	}
	
	Member(String ID, String lName, String fName, String username, String password, int phone, String address) {
		this.ID = ID;
		name = new Name(lName, fName);
		auth = new Auth(username, password, this);
		this.phone = phone;
		this.address = address;
		liked = FXCollections.observableArrayList();
		bag = FXCollections.observableArrayList();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
	
	public void addToBag(Image image) {
		bag.add(image);
	}
	
	public void deleteFromBag(Image image) {
		bag.remove(image);
	}
	
	public boolean findFromBag(Image image) {
		if(bag.contains(image))
			return true;
		return false;
	}
	
	public ObservableList<Image> getBag() {
		return bag;
	}
	
	@Override
	public Auth getAuth() {
		return auth;
	}
	
}
