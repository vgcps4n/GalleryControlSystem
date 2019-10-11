package model;

import java.util.ArrayList;
import java.util.List;

public class AuthContainer {
	private static final List<Auth> auths = new ArrayList<>();
	public boolean create(Auth auth) {
		if(!find(auth)) {
			auths.add(auth);
			return true;
		}
		return false;
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
