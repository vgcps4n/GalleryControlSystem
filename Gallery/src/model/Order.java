package model;

import java.util.UUID;

public class Order {
	String ID, name, address, ename, iname;
	int phone;
	Member member;
	Employee employee;
	Image image;
	
	public Order(String name, String address, int phone, Member member, Employee employee, Image image) {
		ID = UUID.randomUUID().toString();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.member = member;
		this.employee = employee;
		ename = employee.getName().getFirst();
		this.image = image;
		iname = image.getName();
	}
	
	public Order(String ID, String name, String address, int phone, Member member, Employee employee, Image image) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.member = member;;
		this.employee = employee;
		ename = employee.getName().getFirst();
		this.image = image;
		iname = image.getName();
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}
	
}
