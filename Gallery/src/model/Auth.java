package model;

public class Auth {
	private String user, pass;
	Auth() {
		user = "";
		pass = "";
	}
	Auth(String user, String pass) {
		this.user = user;
		this.pass = pass;
	}
	public String getUsername() {
		return user;
	}
	public void setUsername(String user) {
		this.user = user;
	}
	public String getPassword() {
		return pass;
	}
	public void setPassword(String pass) {
		this.pass = pass;
	}
}
