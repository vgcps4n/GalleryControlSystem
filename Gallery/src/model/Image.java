package model;

import java.util.UUID;

public class Image {
	String ID, name, author, path, info;
	int liked, bought;
	
	Image(String name, String author, String info, String path) {
		ID = UUID.randomUUID().toString();
		this.name = name;
		this.author = author;
		this.info = info;
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

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	public int getBought() {
		return bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}

}
