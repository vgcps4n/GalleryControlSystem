package model.container;

import java.util.ArrayList;

import model.Painting;

public class PaintingContainer {
	private ArrayList<Painting> paintings;
	
	public PaintingContainer() {
		 paintings = new ArrayList<>();
	}
	
	public Painting CreatePainting(String[] args) {
		Painting painting = new Painting(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
		paintings.add(painting);
		return painting;
	}
	
	public ArrayList<Painting> getPaintings() {
		return paintings;
	}
}
