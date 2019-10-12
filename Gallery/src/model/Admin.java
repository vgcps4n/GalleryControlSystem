package model;

public class Admin implements User {

	Auth auth;
	public Admin() {
		auth = new Auth("admin", "somepass", this);
	}
	
	@Override
	public Auth getAuth() {
		return auth;
	}

}
