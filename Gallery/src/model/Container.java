package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Container {
	protected static final ObservableList<User> users = FXCollections.observableArrayList();
	
	public boolean authenticate(String username, String password) {
		for(User element: users)
			if(element.getAuth().getUsername().equals(username))
				if(element.getAuth().getPassword().equals(password))
					return true;
		return false;
	}
	
	abstract public User createUser(String username, String password);
	abstract public ObservableList<User> getUsers();
}
