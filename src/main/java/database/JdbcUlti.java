package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUlti {
	public static Connection getConnection() {
<<<<<<< HEAD
		Connection cn = null;
		String serverName = "DESKTOP-6L06R65";
		String dbName = "timesheet";
		String username = "sa";
		String password = "123456";
		String port = "1433";
		String url = "jdbc:sqlserver://"+serverName+":"+port+"; databaseName = "+dbName +"; user = "+username+"; password = "+password+";";
=======
		Connection cn = null; 
		String url = "jdbc:sqlserver:LAPTOP-B4B62Q9N\\SQLEXPRESS:1433; databaseName = timesheet ; user = sa; password = 123;";
>>>>>>> 5c3751271068b9bfbb2ecf0c1cc8c1f1fa07b7a4
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
