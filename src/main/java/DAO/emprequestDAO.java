package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Emprequest;

public class emprequestDAO {
	public void insert(int w_sche_id, Date work_date, int work_shift_id, String reason) {
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
		} finally {
			JdbcUlti.closeConnection(con);
		}
	}

	public List<Emprequest> selectUnCheckedEmprequests(int pageNumber, int rowOfPage) {

		List<Emprequest> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "select * from emprequest\r\n" + "where isaccept=0\r\n" + "	order by id\r\n"
					+ "	offset (?-1)*? rows\r\n" + "	fetch next ? rows only";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Emprequest(rs.getInt("id"), rs.getInt("work_schedule_id"), rs.getDate("work_date"),
						rs.getInt("work_shift_id"), rs.getString("reason"), rs.getBoolean("isaccept")

				));

			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public int countRow() {
		int count = 0;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT COUNT(*) as count FROM emprequest";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt(1);
			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public void delete(int id) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "delete from emprequest where id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				JOptionPane.showMessageDialog(null, "delete successfully!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "khong the ket noi den dtb");
		}
	}

	public void updateStatus(int id) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "update emprequest set isaccept = 1 where id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				JOptionPane.showMessageDialog(null, "Accepted request!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "khong the ket noi den dtb");
		}
	}
}
