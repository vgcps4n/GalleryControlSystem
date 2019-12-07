package model.container;

import model.Admin;
import model.User;

public class AdminContainer extends UserContainer {
	
	@Override
	protected User create(String[] args) {
		return new Admin(args[0], args[1], args[2], args[3]);
	}
	
	//crud

}
