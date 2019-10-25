package data;

public class Queries {
	public static final String ADMIN_TABLE = "CREATE TABLE admin(username VARCHAR(40), password VARCHAR(60), PRIMARY KEY(username));";
	public static final String COMPANY_TABLE = "CREATE TABLE company(ID VARCHAR(36), username VARCHAR(40), password VARCHAR(60), name VARCHAR(60), about TEXT, address TEXT, phone INT, PRIMARY KEY(ID));";
	public static final String EMPLOYEE_TABLE = "CREATE TABLE employee(ID VARCHAR(36), username VARCHAR(40), password VARCHAR(60), lname VARCHAR(40), fname VARCHAR(40), phone INT, PRIMARY KEY(ID));";
	public static final String MEMBER_TABLE = "CREATE TABLE member(ID VARCHAR(36), username VARCHAR(40), password VARCHAR(60), lname VARCHAR(40), fname VARCHAR(40), phone INT, address TEXT, PRIMARY KEY(ID));";
	public static final String IMAGE_TABLE = "CREATE TABLE image(ID VARCHAR(36), name VARCHAR(60), author VARCHAR(40), info TEXT, price INT, draw VARCHAR(100), type VARCHAR(40), year INT, path VARCHAR(200), PRIMARY KEY(ID));";
	public static final String LIKED_TABLE = "CREATE TABLE liked(memberID VARCHAR(36), imageID VARCHAR(36));";
	public static final String EMP_COMP_TABLE = "CREATE TABLE emp_comp(companyID VARCHAR(36), employeeID VARCHAR(36));";
	public static final String IMG_EMP_TABLE = "CREATE TABLE img_emp(employeeID VARCHAR(36), imageID VARCHAR(36));";
	
	public static final String SELECT_ADMIN = "SELECT * FROM admin;";
	public static final String SELECT_COMPANY = "SELECT * FROM company;";
	public static final String SELECT_EMPLOYEE = "SELECT * FROM employee;";
	public static final String SELECT_MEMBER = "SELECT * FROM member;";
	public static final String SELECT_IMAGE = "SELECT * FROM image;";
	public static final String SELECT_LIKED = "SELECT * FROM liked;";
	public static final String SELECT_EMP_COMP = "SELECT * FROM emp_comp;";
	public static final String SELECT_IMG_EMP = "SELECT * FROM img_emp;";
	
}
