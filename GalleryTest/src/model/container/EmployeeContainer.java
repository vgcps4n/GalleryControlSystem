package model.container;

import model.Employee;
import model.User;

public class EmployeeContainer extends UserContainer {

	@Override
	protected User create(String[] args) {
		return new Employee(args[0], args[1], args[2], args[3], args[4]);
	}

}
