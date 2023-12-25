package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Work_schedule;

public class Work_scheduleDAO {
	public List<Work_schedule> selectWorkSchedule() {
		List<Work_schedule> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from work_schedule where isHide=0";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Work_schedule(rs.getInt("work_schedule_id"), rs.getInt("employee_id"),
						rs.getDate("work_date"), rs.getInt("work_shift_id")

				));

			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public void delete(int work_schedule_id) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "delete from work_schedule where work_schedule_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, work_schedule_id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("work schedule was deleted successfully!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(int work_schedule_id, int employee_id, Date work_date, int work_shift_id) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "update work_schedule set employee_id = ?, work_date = ?, work_shift_id = ? where work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, employee_id);
			statement.setDate(2, new java.sql.Date(work_date.getTime()));
			statement.setInt(3, work_shift_id);

			statement.setInt(4, work_schedule_id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Update successfully!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(int employee_id, Date work_date, int work_shift_id) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "insert into work_schedule(employee_id, work_date, work_shift_id)" + "values (?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, employee_id);
			statement.setDate(2, new java.sql.Date(work_date.getTime()));
			statement.setInt(3, work_shift_id);

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

	public int countRow() {
		int count = 0;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT COUNT(*) as count FROM work_schedule";
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

	public List<Work_schedule> selectPaginateEWS(int pageNumber, int rowOfPage) {
		List<Work_schedule> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "SELECT work_schedule.*, work_shift.*\r\n" + "	FROM work_schedule\r\n"
					+ "	JOIN work_shift ON work_schedule.work_shift_id = work_shift.work_shift_id\r\n"
					+ "	order by work_schedule_id\r\n" + "	offset (?-1)*? rows\r\n" + "	fetch next ? rows only";

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Work_schedule(rs.getInt("work_schedule_id"), rs.getInt("employee_id"),
						rs.getDate("work_date"), rs.getInt("work_shift_id"), rs.getString("description"),
						rs.getString("work_type")

				));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int selectForCheck(int employee_id, Date work_date) {
		int workShiftIdFromDb = -1; // Initialize to a default value or handle appropriately

		try {
			Connection con = JdbcUlti.getConnection();
			java.sql.Date wd = new java.sql.Date(work_date.getTime());
			String sql = "SELECT work_shift_id FROM work_schedule WHERE employee_id = ? AND work_date = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, employee_id);
			st.setDate(2, wd);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				workShiftIdFromDb = rs.getInt("work_shift_id");
				// Additional processing if needed
			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return workShiftIdFromDb;

	}

}
