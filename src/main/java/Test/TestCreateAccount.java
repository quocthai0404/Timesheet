package Test;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Scanner;

import javax.swing.JOptionPane;

import database.JdbcUlti;

public class TestCreateAccount {

	public static void main(String[] args) {
		TestCreateAccount tc = new TestCreateAccount();
		tc.SignUp("employee1", "employee1");
//		tc.login("employee", "employee");
//		tc.SignUp("manager", "manager");
//		tc.login("newaccount2", "adminthaiphan");
	}
	
	public void SignUp(String username, String password) {
		Connection con = null;
		try {
		    con = JdbcUlti.getConnection();
		    String sql = "insert into account(employee_id, username, password, email)\r\n"
		    		+ "values (4, ?, ?, 'thathua725@gmail.com' )";
		    PreparedStatement st = con.prepareStatement(sql);
		    MessageDigest md5 = MessageDigest.getInstance("MD5");
		    byte[] bytes = md5.digest(password.getBytes());
		    String md5_password = new String(Base64.getEncoder().encode(bytes));
		    st.setString(1, username);
		    st.setString(2, md5_password);
		    int rowsUpdated = st.executeUpdate();
			if (rowsUpdated > 0) {
			    JOptionPane.showMessageDialog(null, "A new account was inserted successfully!");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login(String username, String password) {
	    
	    Connection con = null;
	    try {
	    	con = JdbcUlti.getConnection();
		    String sql = "select * from account\r\n"
		    		+ "where username=?\r\n"
		    		+ "and password= ?";
		    PreparedStatement st = con.prepareStatement(sql);
		    MessageDigest md5 = MessageDigest.getInstance("MD5");
		    byte[] bytes = md5.digest(password.getBytes());
		    String md5_password = new String(Base64.getEncoder().encode(bytes));
		    st.setString(1, username);
		    st.setString(2, md5_password);
		    ResultSet rs = st.executeQuery();
			if (rs.next()) {
			    JOptionPane.showMessageDialog(null, "Login ok");
			}else {
				JOptionPane.showMessageDialog(null, "not ok");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
