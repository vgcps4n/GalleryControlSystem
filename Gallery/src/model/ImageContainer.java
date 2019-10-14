package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImageContainer {
	private static final ObservableList<Image> images = FXCollections.observableArrayList();
	
	public Image createImage(String name, String author, String info, 
			int price, String draw, String type, 
			int year, int count, String path) {
		
		Image image = new Image(name, author, info, price, 
				draw, type, year, count, path);
		if(images.contains(image))
			return null;
		images.add(image);
		return image;
	}
	
	public ObservableList<Image> getImages() {
		return images;
	}
}
