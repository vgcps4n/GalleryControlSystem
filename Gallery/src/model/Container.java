package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Container {
	protected List<User> users = new ArrayList<>();
	
	public boolean authenticate(String username, String password) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				if(users.get(i).getPassword().equals(password))
					return true;
			}
		}
		return false;
	}
	
	abstract public User createUser(String username, String password);
	abstract public List<User> readUsers();
	//abstract public boolean updateUser(String username, String password);
	abstract public boolean deleteUser(String username);
}
