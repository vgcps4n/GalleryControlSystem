package test;

import model.Auth;
import model.container.PaintingContainer;

public class Main {

	public static void main(String[] args) {
		Auth auth = new Auth("aeon", "somepass");
		System.out.println(auth.getUsername());
		PaintingContainer cont = new PaintingContainer();
		cont.CreatePainting(new String[] {"painting", "aeon", "no info", "typeless", "somewhere", "2019"});
		System.out.print(cont.getPaintings().get(0).getName());
	}

}
