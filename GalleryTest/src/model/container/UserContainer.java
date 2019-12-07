package model.container;

import java.util.ArrayList;

import model.User;

public abstract class UserContainer {
	private final ArrayList<User> users = new ArrayList<>();
	public User CreateUser(String[] args) {
		User user = create(args);
		users.add(user);
		return user;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	protected abstract User create(String[] args);
}
