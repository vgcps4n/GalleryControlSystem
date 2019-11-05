package model;

import data.DataBaseSelector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImageContainer {
	private static final ObservableList<Image> images = FXCollections.observableArrayList();
	
	public ImageContainer() {
		DataBaseSelector.SelectDB();
	}
	
	public Image createImage(String name, String author, String info, 
			int price, String draw, String type, int year, String path) {
		
		Image image = new Image(name, author, info, price, 
				draw, type, year, path);
		if(images.contains(image))
			return null;
		images.add(image);
		return image;
	}

	public static void createImage(String ID, String name, String author, String info, 
			int price, String draw, String type, int year, String path) {
		
		Image image = new Image(ID, name, author, info, price, 
				draw, type, year, path);
		if(images.contains(image))
			return;
		images.add(image);
	}
	
	
	public static Image getImage(String ID) {
		for(Image image: images)
			if(image.getID().equals(ID))
				return image;
		return null;
	}
	
	public ObservableList<Image> getImages() {
		return images;
	}
}
