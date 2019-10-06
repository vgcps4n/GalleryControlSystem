package model;

public class Name {
	String last, first;
	Name() {
		last = "";
		first = "";
	}
	Name(String last, String first) {
		this.last = last;
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	
}
