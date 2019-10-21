package model;

import javafx.collections.ObservableList;

public class CompanyContainer extends Container {

	public User createCompany(String name, String about, String address, int phone, String username, String password) {
		if(auths.find(username) != null)
			return null;
		Company company = new Company(name, about, address, phone, username, password);
		auths.create(company.getAuth());
		users.add(company);
//		db.createUser(company);
		return company;
	}
	
	public static void createCompany(String ID, String name, String about, String address, int phone, String username, String password) {
		if(auths.find(username) != null)
			return;
		Company company = new Company(ID, name, about, address, phone, username, password);
		auths.create(company.getAuth());
		users.add(company);
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}
	
	public static Company getUser(String ID) {
		for(User company: users) {
			if(company instanceof Company)
				if(((Company) company).getID().equals(ID))
					return (Company) company;
		}
		return null;
	}

}
