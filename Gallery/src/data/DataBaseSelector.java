package data;

import java.sql.SQLException;

public class DataBaseSelector {
	private static DataBase db;
	public static DataBase SelectDB() {
		if(db != null)
			return db;
		
		try {
			return db = MySQL.getInstance();
		} catch(SQLException e) {
			System.out.print(e.getMessage());
			//other db
			return null;
		}
	}

}
