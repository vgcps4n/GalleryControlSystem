package model;

import java.util.ArrayList;
import java.util.List;

public class AuthContainer {
	private static final List<Auth> auths = new ArrayList<>();
	
	public void create(Auth auth) {
		auths.add(auth);
	}
	
	public boolean find(Auth auth) {
		if(auths.contains(auth))
			return true;
		return false;
	}
	
	public Auth find(String username) {
		for(Auth auth: auths)
			if(auth.getUsername().equals(username))
				return auth;
		return null;
	}

}
