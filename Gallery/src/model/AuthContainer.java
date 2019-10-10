package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthContainer {
	private static final List<Auth> auths = new ArrayList<>();
	private static final Map<String, String> map = auths.stream().collect(Collectors.toMap(auths -> auths.getUsername(), auths -> auths.getPassword()));
	public boolean create(Auth auth) {
		if(!find(auth)) {
			auths.add(auth);
			return true;
		}
		return false;
	}
	
	public boolean find(Auth auth) {
		if(map.get(auth.getUsername()) != null)
			return true;
		return false;
	}
}
