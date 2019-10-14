package model;

import java.util.UUID;

public class Image {
	String ID, name, author, path, info;
	int liked, bought, price;
	
	Image(String name, String author, String info, int price, String path) {
		ID = UUID.randomUUID().toString();
		this.name = name;
		this.author = author;
		this.info = info;
		this.price = price;
		this.path = path;
		liked = 0;
		bought = 0;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getLiked() {
		return liked;
	}

	public void incLiked() {
		liked++;
	}

	public void decLiked() {
		liked--;
	}
	
	public int getBought() {
		return bought;
	}

	public void incBought() {
		bought++;
	}


	public void decBought() {
		bought--;
	}

}
