package model;

import javafx.collections.ObservableList;

public class EmployeeContainer extends Container {

	public User createEmployee(String fName, String lName, int phone, String username, String password) {
		if(auths.find(username) != null)
			return null;
		Employee employee = new Employee(fName, lName, phone, username, password);
		auths.create(employee.getAuth());
		users.add(employee);
		return employee;
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}

}
