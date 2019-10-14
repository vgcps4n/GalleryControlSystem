package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImageContainer {
	private static final ObservableList<Image> images = FXCollections.observableArrayList();
	
	public Image createImage(String name, String author, String info, int price, String path) {
		Image image = new Image(name, author, info, price, path);
		images.add(image);
		return image;
	}
	
	public ObservableList<Image> getImages() {
		return images;
	}
}
