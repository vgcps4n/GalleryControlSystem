package model.container;

import model.Gallery;
import model.User;

public class GalleryContainer extends UserContainer {

	@Override
	protected User create(String[] args) {
		return new Gallery(args[0], args[1], args[2], args[3], args[4], args[5]);
	}

}
