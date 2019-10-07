package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Container {
	protected static final List<User> users = new ArrayList<>();
	
	public boolean authenticate(String username, String password) {
		for(User element: users)
			if(element.getUsername().equals(username))
				if(element.getPassword().equals(password))
					return true;
		return false;
	}
	
	abstract public User createUser(String username, String password);
	abstract public List<User> readUsers();
	//abstract public boolean updateUser(String username, String password);
	abstract public boolean deleteUser(String username);
}
