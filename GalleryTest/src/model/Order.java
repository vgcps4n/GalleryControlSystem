package model;

public class Order {
	Member member;
	Employee employee;
	Painting painting;
	
	public Order(Member member, Employee employee, Painting painting) {
		this.member = member;
		this.employee = employee;
		this.painting = painting;
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

	public Painting getPainting() {
		return painting;
	}

	public void setPainting(Painting painting) {
		this.painting = painting;
	}
}
