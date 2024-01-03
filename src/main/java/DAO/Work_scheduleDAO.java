package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.EmployeeAfterLogin;
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
			String sql = "select count(*) as count\r\n"
					+ "  from work_schedule\r\n"
					+ "  where work_schedule.employee_id=? and isHide=0";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, EmployeeAfterLogin.employeeID);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			return count;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;

	}

	public ResultSet selectPaginateEWS(int pageNumber, int rowOfPage) {
		
		try {
			Connection con = JdbcUlti.getConnection();


			String sql = "select w_sche.work_schedule_id, w_sche.employee_id, w_sche.work_date, w_sche.work_shift_id,\r\n"
					+ "  ws.description, ws.work_type\r\n"
					+ "  from work_schedule as w_sche\r\n"
					+ "  join work_shift as ws on ws.work_shift_id=w_sche.work_shift_id\r\n"
					+ "  where w_sche.employee_id=? and w_sche.isHide=0\r\n"
					+ "  order by w_sche.work_schedule_id\r\n"
					+ "  offset (?-1)*? rows \r\n"
					+ "  fetch next ? rows only";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, EmployeeAfterLogin.employeeID);
			st.setInt(2, pageNumber);
			st.setInt(3, rowOfPage);
			st.setInt(4, rowOfPage);
			ResultSet rs = st.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
