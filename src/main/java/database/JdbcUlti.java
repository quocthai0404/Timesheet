package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUlti {
	public static Connection getConnection() {
		//thai
		// String serverName = "DESKTOP-6L06R65";
		//	String password = "123456";
		//String dbName = "timesheet";
		//------
		//Lộc
//		String serverName = "DESKTOP-FICVKMH";
//		String dbName = "timesheet_new";
//		String username = "sa";
//		String password = "";
		Connection cn = null;

<<<<<<< HEAD
		String serverName = "LAPTOP-B4B62Q9N\\SQLEXPRESS";
		String dbName = "timesheet";
		String username = "sa";
		String password = "123";
=======
		String serverName = "DESKTOP-6L06R65";
		String dbName = "timesheet";
		String username = "sa";
		String password = "123456";
>>>>>>> ab6fef4e152471d47e4b43088096a50317923872

		String port = "1433";
		String url = "jdbc:sqlserver://"+serverName+":"+port+"; databaseName = "+dbName +"; user = "+username+"; password = "+password+";";
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
