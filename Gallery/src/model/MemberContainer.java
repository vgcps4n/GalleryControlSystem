package model;

import java.util.List;

public class MemberContainer extends Container {
	
	public User createUser(String lName, String fName, String username, String password, int phone, String address) {
		Member member = new Member(lName, fName, username, password, phone, address);
		users.add(member);
		return member;
	}
	
	@Override
	public User createUser(String username, String password) {
		Member member = new Member(username, password);
		users.add(member);
		return member;
	}
	
	@Override
	public List<User> readUsers() {
		return users;
	}

	@Override
	public boolean deleteUser(String username) {
		for(User element: users)
			if(element.getAuth().getUsername().equals(username)) {
				users.remove(element);
				return true;
			}
		return false;
	}

}
