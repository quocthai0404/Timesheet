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
					System.out.println("login ok");
					return true;
				} else {
					System.out.println("ko");
				}
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String getPasswordFromAccount(String username) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select password from account where username=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				return rs.getString("password");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

}