package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUlti {
	public static Connection getConnection() {

		Connection cn = null;
		String serverName = "DESKTOP-6L06R65";
		String dbName = "timesheet";
		String username = "sa";
		String password = "123456";
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
