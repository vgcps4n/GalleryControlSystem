package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Container {
	protected static final ObservableList<User> users = FXCollections.observableArrayList();
	protected static final AuthContainer auths = new AuthContainer();
	public int authenticate(String username, String password) {
		Auth auth = auths.find(username);
		if(auth != null)
			if(auth.getPassword().equals(password)) return 1;
			else return 0;
		else return -1;
	}
	abstract public ObservableList<User> getUsers();
}
