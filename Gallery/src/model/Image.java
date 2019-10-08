package model;

import java.util.UUID;

public class Image {
	String ID, name, author, path, def;
//	int liked, viewed;
	
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

}
