package DAO;

import database.JdbcUlti;
import entity.Account;
import entity.EmployeeAfterLogin;
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
			String sql = "select account.username, account.password, employee.position, account.employee_id\r\n"
					+ "from account\r\n"
					+ "inner join employee on employee.employee_id=account.employee_id\r\n"
					+ "where account.username=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				if(rs.getString(1).equals(username)&&rs.getString(2).equals(password)) {
					EmployeeAfterLogin.employeePosition=rs.getString(3);
					EmployeeAfterLogin.employeeID=rs.getInt(4);
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

}