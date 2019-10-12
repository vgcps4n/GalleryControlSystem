package model;

import javafx.collections.ObservableList;

public class MemberContainer extends Container {
	
	public User createMember(String lName, String fName, String username, String password, int phone, String address) {
		if(auths.find(username) != null)
			return null;
		Member member = new Member(lName, fName, username, password, phone, address);
		auths.create(member.getAuth());
		users.add(member);
		return member;
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}

}
