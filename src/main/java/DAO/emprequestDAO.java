package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import javax.swing.JOptionPane;

import database.JdbcUlti;

public class emprequestDAO {
	public void insert(int w_sche_id, Date work_date, 
			int work_shift_id, String reason) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
			String sql = "insert into emprequest(work_schedule_id, work_date, work_shift_id, reason, isaccept)\r\n"
					+ "  values (?, ?, ?, ?, 0)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, w_sche_id);
			statement.setDate(2, new java.sql.Date(work_date.getTime()));
			statement.setInt(3, work_shift_id);
			statement.setString(4, reason);
			int row = statement.executeUpdate();
			if (row > 0) {
				JOptionPane.showMessageDialog(null, "Your request has been sent successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUlti.closeConnection(con);
		}
	}
}
