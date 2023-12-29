package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JOptionPane;

import database.JdbcUlti;

public class ChangePassDAO {
	public void add(String username, String code, Date time) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "insert into forgetpassword(username, code, time)" + "values (?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, code);
			statement.setTimestamp(3, new Timestamp(time.getTime()));

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				JOptionPane.showMessageDialog(null, "Please wait");
			} else {
				JOptionPane.showMessageDialog(null, "cannot handle this action!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	public boolean checkUsernameExist(String username) {
	    try (Connection con = JdbcUlti.getConnection()) {
	        String sql = "SELECT username FROM forgetpassword WHERE username = ?";
	        
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, username);
	            
	            try (ResultSet rs = statement.executeQuery()) {
	                return rs.next(); // Trả về true nếu có ít nhất một bản ghi
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Hoặc xử lý lỗi theo nhu cầu của bạn
	    }
	    
	    return false;
	}
	public void update(String username, String code, Date time) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = " update forgetpassword set  code=?, time= ? where username =?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, code);
			statement.setTimestamp(2, new Timestamp(time.getTime()));
			statement.setString(3, username);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				JOptionPane.showMessageDialog(null, "Please wait");
			} else {
				JOptionPane.showMessageDialog(null, "cannot handle this action!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	
}
