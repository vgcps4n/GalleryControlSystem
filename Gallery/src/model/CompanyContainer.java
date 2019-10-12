package model;

import javafx.collections.ObservableList;

public class CompanyContainer extends Container {

	public User createCompany(String name, String about, String address, int phone, String username, String password) {
		if(auths.find(username) != null)
			return null;
		Company company = new Company(name, about, address, phone, username, password);
		auths.create(company.getAuth());
		users.add(company);
		return company;
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}

}
