package model;

import java.util.List;

public class Company implements User {
	String ID, name, about, address;
	Auth auth;
	int phone;
	List<Employee> employees;

	@Override
	public Auth getAuth() {
		return auth;
	}

}
