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
	
	public static void createEmployee(String ID, String lName, String fName, int phone, String username, String password) {
		if(auths.find(username) != null)
			return;
		Employee employee = new Employee(ID, lName, fName, phone, username, password);
		auths.create(employee.getAuth());
		users.add(employee);
	}
	
	@Override
	public ObservableList<User> getUsers() {
		return users;
	}
	
	public static Employee getUser(String ID) {
		for(User employee: users) {
			if(employee instanceof Employee)
				if(((Employee) employee).getID().equals(ID))
					return (Employee) employee;
		}
		return null;
	}
}
