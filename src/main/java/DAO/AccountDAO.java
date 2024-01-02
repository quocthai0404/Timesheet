package DAO;

import java.sql.Connection;	
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Test.Login2;
import database.JdbcUlti;
import entity.Account;
import entity.EmployeeAfterLogin;

public class AccountDAO {
	public List<Account> selectAccounts() {
		List<Account> list = new ArrayList<>();
		Connection con = null;

		try {
			con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT * FROM account";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				list.add(new Account(rs.getInt("account_id"), rs.getInt("employee_id"), rs.getString("tendangnhap"),
						rs.getString("matkhau"), rs.getString("email")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
		return list;
	}

	public Boolean Login(String username, String password) {
		Login2 lg = new Login2();
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select account.username, account.password, employee.position, account.employee_id\r\n"
					+ "from account\r\n" + "inner join employee on employee.employee_id=account.employee_id\r\n"
					+ "where account.username=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				if (rs.getString(1).equals(username) && rs.getString(2).equals(password)) {
					EmployeeAfterLogin.employeePosition = rs.getString(3);
					EmployeeAfterLogin.employeeID = rs.getInt(4);
					return true;
				}
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public String getUserNameFromEmail(String email) {
	    try (Connection con = JdbcUlti.getConnection()) {
	        String sql = "SELECT username FROM account WHERE email=?";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, email);
	            try (ResultSet rs = statement.executeQuery()) {
	                if (rs.next()) {
	                    return rs.getString("username");
	                } else {
	                    // Return null or an empty string if the email is not found
	                    return null;
	                }
	            }
	        }
	    } catch (SQLException e) {
	        // Log or handle the exception according to your application's needs.
	        
	        throw new RuntimeException("Error retrieving user information", e);
	    }
	}
	
	public String getEmployeePasswordByUsernameAndEmail(String username, String email) {
		String password = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUlti.getConnection();
			String query = "SELECT password FROM account " + "WHERE username = ? AND email = ? ";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				password = resultSet.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Lỗi khi truy xuất mật khẩu từ cơ sở dữ liệu", "Lỗi Cơ sở dữ liệu",
					JOptionPane.ERROR_MESSAGE);
		} finally {
			closeResources(connection, preparedStatement, resultSet);
		}

		return password;
	}

	// Existing methods...

	private void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void changePass(String password, String username) {
		try {

			Connection con = JdbcUlti.getConnection();

			String sql = " update account set  password =? where username =?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, password);
			statement.setString(2, username);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				JOptionPane.showMessageDialog(null, "Change Password succeddfully!");
			} else {
				JOptionPane.showMessageDialog(null, "cannot handle this action!");

			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public Boolean checkRoleManager(String username) {
		Connection con = null; 
		
		try {
			con = JdbcUlti.getConnection();
			String sql = "select employee.position from account\r\n"
					+ "	join employee on account.employee_id = employee.employee_id\r\n"
					+ "	where account.username=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals("manager")) {
					return true;
				}
			}
		} catch (Exception e) {
			
		}finally {
			JdbcUlti.closeConnection(con);
		}
		return false;
	}

	public static void getInfo(int id, String Name, String Position) {
		EmployeeAfterLogin.employeeID=id;
		EmployeeAfterLogin.employeeName=Name;
		EmployeeAfterLogin.employeePosition=Position;
	}
	
}