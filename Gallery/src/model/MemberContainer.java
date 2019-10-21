package model;

import javafx.collections.ObservableList;

public class MemberContainer extends Container {
	
	public User createMember(String lName, String fName, String username, String password, int phone, String address) {
		if(auths.find(username) != null)
			return null;
		Member member = new Member(lName, fName, username, password, phone, address);
		auths.create(member.getAuth());
		users.add(member);
		db.createUser(member);
		return member;
	}
	
	public static void createMember(String ID, String lName, String fName, String username, String password, int phone, String address) {
		if(auths.find(username) != null)
			return;
		Member member = new Member(ID, lName, fName, username, password, phone, address);
		auths.create(member.getAuth());
		users.add(member);
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}

	public static Member getUser(String ID) {
		for(User member: users) {
			if(member instanceof Member)
				if(((Member) member).getID().equals(ID))
					return (Member) member;
		}
		return null;
	}
	
	public void addLiked(Member member, Image image) {
		member.addLiked(image);
		db.like(member, image);
	}
	
	public void deleteLiked(Member member, Image image) {
		member.deleteLiked(image);
		db.unlike(member, image);
	}
	
}
