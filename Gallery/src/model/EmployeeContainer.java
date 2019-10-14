package model;

import javafx.collections.ObservableList;

public class EmployeeContainer extends Container {

	public User createEmployee(String lName, String fName, int phone, String username, String password) {
		if(auths.find(username) != null)
			return null;
		Employee employee = new Employee(lName, fName, phone, username, password);
		auths.create(employee.getAuth());
		users.add(employee);
		return employee;
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}

}
