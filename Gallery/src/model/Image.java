package model;

import java.util.UUID;

public class Image implements Content {
	String ID, name, author, path;
	Image() {
		ID = UUID.randomUUID().toString();
		name = "";
		author = "";
		path = "";
	}
	Image(String name, String author, String path) {
		ID = UUID.randomUUID().toString();
		this.name = name;
		this.author = author;
		this.path = path;
	}
	@Override
	public String getName() {
		return name;
	}

}
