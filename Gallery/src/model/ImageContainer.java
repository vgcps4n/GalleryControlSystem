package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ImageContainer {
	private static ObservableList<Image> images = FXCollections.observableArrayList();
	public ObservableList<Image> getImages() {
		return images;
	}
}
