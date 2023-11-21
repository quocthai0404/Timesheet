package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUlti {

	public static Connection getConnection() {
		Connection cn = null; 
		String url = "jdbc:sqlserver:LAPTOP-B4B62Q9N\\SQLEXPRESS:1433; databaseName = timesheet ; user = sa; password = 123;";
		try {
			cn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
		
	}
	
	public static void closeConnection(Connection cn) {
		if(cn!=null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
