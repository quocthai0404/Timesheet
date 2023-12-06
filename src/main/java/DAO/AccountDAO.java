package DAO;

import database.JdbcUlti;
import entity.Account;
import view.Login2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
                list.add(new Account(
                        rs.getInt("account_id"),
                        rs.getInt("employee_id"),
                        rs.getString("tendangnhap"),
                        rs.getString("matkhau"),
                        rs.getString("email"),
                        rs.getString("capbac")
                ));
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
			String sql = "select account.username, account.password, employee.position\r\n"
					+ "from account\r\n"
					+ "inner join employee on employee.employee_id=account.employee_id\r\n"
					+ "where account.username=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(1).equals(username)&&rs.getString(2).equals(password)) {
					lg.getPosition(rs.getString(3));
					System.out.println("login ok");
					return true;
				}else {
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
    public boolean isUsernameExist(String username) {
        Connection con = null;

        try {
            con = JdbcUlti.getConnection();
            String sql = "SELECT COUNT(*) FROM account WHERE username = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUlti.closeConnection(con);
        }

        return false;
    }

    public boolean isEmailExist(String email) {
        Connection con = null;

        try {
            con = JdbcUlti.getConnection();
            String sql = "SELECT COUNT(*) FROM account WHERE email = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUlti.closeConnection(con);
        }

        return false;
    }
    public void insertAccount(int employeeId, String username, String password, String email) {
        try {
            // Kiểm tra xem username hoặc email đã tồn tại hay chưa
            boolean isUsernameExist = isUsernameExist(username);
            boolean isEmailExist = isEmailExist(email);

            if (isUsernameExist && isEmailExist) {
                System.out.println("Username và email đã tồn tại trong hệ thống.");
                return;
            } else if (isUsernameExist) {
                System.out.println("Username đã tồn tại trong hệ thống.");
                return;
            } else if (isEmailExist) {
                System.out.println("Email đã tồn tại trong hệ thống.");
                return;
            }

            Connection con = JdbcUlti.getConnection();
            String sql = "INSERT INTO account (employee_id, username, password, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.executeUpdate();

            System.out.println("Account đã được thêm vào cơ sở dữ liệu.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
