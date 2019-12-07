package model;

import java.util.UUID;

public class Painting {

	private String id, name, author, info, type, path;
	private int year, liked, price;
	public Painting(String name, String author, String info, String type, String year, String price, String path) {
		id = UUID.randomUUID().toString();
		liked = 0;
		this.name = name;
		this.author = author;
		this.info = info;
		this.type = type;
		this.year = Integer.parseInt(year);
		this.price = Integer.parseInt(price);
		this.path = path;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
