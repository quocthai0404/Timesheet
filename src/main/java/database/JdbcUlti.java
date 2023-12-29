package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUlti {
	public static Connection getConnection() {

		String serverName = "DESKTOP-6L06R65";
		String username = "sa";
		String password = "123456";
		String dbName = "timesheet";
		// ------;
//		Lộc
//		String serverName = "DESKTOP-FICVKMH";
//		String dbName = "timesheet2";
<<<<<<< HEAD
=======
//		String username = "sa";
//		String password = "NguyenAn2004";
//		---------;
//		String serverName = "CPS";
//		String dbName = "timesheet";
>>>>>>> 30e71a0ab8486621a8cd470510c5b7c5b439cfa0
//		String username = "sa";
//		String password = "NguyenAn2004";

		String serverName = "CPS";
		String dbName = "timesheet";
		String username = "sa";
		String password = "phamtien2004";

//		String serverName = "DESKTOP-6L06R65";
//		String dbName = "timesheet";
//		String username = "sa";
//		String password = "123456";

		String port = "1433";
		String url = "jdbc:sqlserver://" + serverName + ":" + port + "; databaseName = " + dbName + "; user = "
				+ username + "; password = " + password + ";";
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;

	}

	public static void closeConnection(Connection cn) {
		if (cn != null) {
			try {
				cn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static CallableStatement prepareCall(String sql) throws SQLException {
        Connection cn = getConnection();
        return cn.prepareCall(sql);
    }

}
