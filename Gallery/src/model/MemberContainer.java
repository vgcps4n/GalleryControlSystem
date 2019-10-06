package model;

import java.util.List;

public class MemberContainer extends Container {
	
	public User createUser(String lName, String fName, String username, String password, int phone) {
		Member member = new Member(lName, fName, username, password, phone);
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
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				users.remove(i);
				return true;
			}
		}
		return false;
	}

}
