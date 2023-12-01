package DAO;

import database.JdbcUlti;
import entity.Account;

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
    	try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select password from account where username=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				if(password.equals(rs.getString(1))) {
					return true;
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
