package model;

import java.util.UUID;

public class Image {
	String ID, name, author, path, info, type, draw;
	int liked, price, year;
	
	Image(String name, String author, String info, 
			int price, String draw, String type, 
			int year, String path) {
		ID = UUID.randomUUID().toString();
		this.name = name;
		this.author = author;
		this.info = info;
		this.price = price;
		this.draw = draw;
		this.type = type;
		this.year = year;
		this.path = path;
		liked = 0;
	}
	
	Image(String ID, String name, String author, String info, 
			int price, String draw, String type, 
			int year, String path) {
		this.ID = ID;
		this.name = name;
		this.author = author;
		this.info = info;
		this.price = price;
		this.draw = draw;
		this.type = type;
		this.year = year;
		this.path = path;
		liked = 0;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
}
