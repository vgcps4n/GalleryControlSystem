package model.container;

import model.Member;
import model.User;

public class MemberContainer extends UserContainer {

	@Override
	protected User create(String[] args) {
		return new Member(args[1], args[2], args[3], args[4], args[5], args[6]);
	}

}
