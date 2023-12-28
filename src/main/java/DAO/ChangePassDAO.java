package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			statement.setDate(3, new java.sql.Date(time.getTime()));

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				JOptionPane.showMessageDialog(null, "Add successfully!");
			} else {
				JOptionPane.showMessageDialog(null, "cannot handle this action!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
