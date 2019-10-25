package data;

import model.Company;
import model.Employee;
import model.Image;
import model.Member;
import model.User;

public interface DataBase {
	public void ReadAll();
	public void createUser(User user);
	public void createEmployee(Company c, Employee e);
	public void createImage(Employee e, Image i);
	public void deleteImage(Employee e, Image i);
	public void like(Member m, Image i);
	public void unlike(Member m, Image i);
}
