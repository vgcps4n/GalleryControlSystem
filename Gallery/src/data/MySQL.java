package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Company;
import model.CompanyContainer;
import model.Employee;
import model.EmployeeContainer;
import model.Image;
import model.ImageContainer;
import model.Member;
import model.MemberContainer;
import model.User;

public class MySQL implements DataBase {

	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	
	private static MySQL db;
	public static MySQL getInstance() throws SQLException {
		if(db != null)
			return db;
		return db = new MySQL();
	}
	
	private MySQL() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gallery", "root", "");
		st = con.createStatement();
		ReadAll();
	}
	
	@Override
	public void createEmployee(Company company, Employee employee) {
		try {
			st.executeUpdate("insert into employee value("
					+ "\"" + employee.getID() + "\", "
					+ "\"" + employee.getAuth().getUsername() + "\", "
					+ "\"" + employee.getAuth().getPassword() + "\", "
					+ "\"" + employee.getName().getFirst() + "\", "
					+ "\"" + employee.getName().getLast() + "\", "
					+ employee.getPhone() + ");");
			
			st.executeUpdate("insert into emp_comp value("
					+ "\"" + company.getID() + "\", \"" + employee.getID() + "\");");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void createUser(User user) {
		try {
			if(user instanceof Company) {
				Company company = (Company) user;
					st.executeUpdate("insert into company value("
							+ "\"" + company.getID() + "\", "
							+ "\"" + company.getAuth().getUsername() + "\", "
							+ "\"" + company.getAuth().getPassword() + "\", "
							+ "\"" + company.getName() + "\", "
							+ "\"" + company.getAbout() + "\", "
							+ "\"" + company.getAddress() + "\", "
							+ company.getPhone() + ");");
			} else if(user instanceof Member) {
				Member member = (Member) user;
				st.executeUpdate("insert into member value("
						+ "\"" + member.getID() + "\", "
						+ "\"" + member.getAuth().getUsername() + "\", "
						+ "\"" + member.getAuth().getPassword() + "\", "
						+ "\"" + member.getName().getFirst() + "\", "
						+ "\"" + member.getName().getLast() + "\", "
						+ member.getPhone() + ", "
						+ "\"" + member.getAddress() + "\");");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void createImage(Employee employee, Image image) {
		try {
			st.executeUpdate("insert into image value("
					+ "\"" + image.getID() + "\", "
					+ "\"" + image.getName() + "\", "
					+ "\"" + image.getAuthor() + "\", "
					+ "\"" + image.getInfo() + "\", "
					+  image.getPrice() + ", "
					+ "\"" + image.getDraw() + "\", "
					+ "\"" + image.getType() + "\", "
					+ image.getYear() + ", "
					+ image.getCount() + ", "
					+ "\"" + image.getPath() + "\");");
			
			st.executeUpdate("insert into img_emp value("
					+ "\"" + employee.getID() + "\", \"" + image.getID() + "\");");
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void like(Member member, Image image) {
		try {
			st.executeUpdate("insert into liked value(\"" + member.getID() + "\", \"" + image.getID() + "\");");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void unlike(Member member, Image image) {
		try {
			st.executeUpdate("delete from liked where memberID = \"" + member.getID() + "\" and imageID = \"" + image.getID() + "\";");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void ReadAll() {
		try {
			rs = st.executeQuery(Queries.SELECT_COMPANY);
			while(rs.next())
				CompanyContainer.createCompany(rs.getString("ID"), rs.getString("name"), rs.getString("about"), 
						rs.getString("address"), rs.getInt("phone"), rs.getString("username"), rs.getString("password"));
			
			rs = st.executeQuery(Queries.SELECT_EMPLOYEE);
			while(rs.next())
				EmployeeContainer.createEmployee(rs.getString("ID"), rs.getString("lname"), rs.getString("fname"), 
						rs.getInt("phone"), rs.getString("username"), rs.getString("password"));
			
			rs = st.executeQuery(Queries.SELECT_MEMBER);
			while(rs.next())
				MemberContainer.createMember(rs.getString("ID"), rs.getString("lname"), rs.getString("fname"), 
						rs.getString("username"), rs.getString("password"), rs.getInt("phone"), rs.getString("address"));
			
			rs = st.executeQuery(Queries.SELECT_IMAGE);
			while(rs.next())
				ImageContainer.createImage(rs.getString("ID"), rs.getString("name"), rs.getString("author"), 
						rs.getString("info"), rs.getInt("price"), rs.getString("draw"), rs.getString("type"), 
						rs.getInt("year"), rs.getInt("count"), rs.getString("path"));
			
			rs = st.executeQuery(Queries.SELECT_EMP_COMP);
			while(rs.next())
				if(CompanyContainer.getUser(rs.getString("companyID")) != null && 
						EmployeeContainer.getUser(rs.getString("employeeID")) != null) {
					CompanyContainer.getUser(rs.getString("companyID")).addEmployee(EmployeeContainer.getUser(rs.getString("employeeID")));
				}
			
			rs = st.executeQuery(Queries.SELECT_IMG_EMP);
			while(rs.next())
				if(EmployeeContainer.getUser(rs.getString("employeeID")) != null &&
						ImageContainer.getImage(rs.getString("imageID")) != null)
				EmployeeContainer.getUser(rs.getString("employeeID")).addImage(ImageContainer.getImage(rs.getString("imageID")));

			rs = st.executeQuery(Queries.SELECT_LIKED);
			while(rs.next())
				if(MemberContainer.getUser(rs.getString("memberID")) != null &&
							ImageContainer.getImage(rs.getString("imageID")) != null) {
					MemberContainer.getUser(rs.getString("memberID")).addLiked(ImageContainer.getImage(rs.getString("imageID")));
					ImageContainer.getImage(rs.getString("imageID")).incLiked();
				}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
