package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Employee;
import entity.EmployeeAfterLogin;
import entity.RowClicked;
import entity.Work_schedule;
import entity.wSche_join_wShift;

public class Work_scheduleDAO {
	public Double lateforwork = 200000.0;
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

	public Work_schedule selectFromId(int work_schedule_id) {
	    Work_schedule ws = null;
	    try {
	        Connection con = JdbcUlti.getConnection();
	        String sql = "SELECT * FROM work_schedule WHERE work_schedule_id = ? ";
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setInt(1, work_schedule_id);
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            ws = new Work_schedule(rs.getInt("work_schedule_id"), rs.getInt("employee_id"),
	                    rs.getDate("work_date"), rs.getInt("work_shift_id"));
	        }
	        JdbcUlti.closeConnection(con);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return ws;
	}
	public void updateWSAfterRequest(int workShiftId, Date work_date,int Work_schedule_id) {
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "update work_schedule set  work_shift_id = ?,work_date = ? where work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, workShiftId);
			statement.setDate(2, new java.sql.Date(work_date.getTime()));
			statement.setInt(3, Work_schedule_id);
			

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Update successfully!");
			}
			else {
				JOptionPane.showMessageDialog(null, "khong update");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<wSche_join_wShift> getListSchedule(Date date){
		Connection con = null;
		List<wSche_join_wShift> list = new ArrayList<>();
		
		try {
			con = JdbcUlti.getConnection();
			String sql = "SELECT *\r\n"
					+ "\r\n"
					+ "FROM work_schedule AS w_sche\r\n"
					+ "\r\n"
					+ "JOIN work_shift AS ws ON ws.work_shift_id = w_sche.work_shift_id\r\n"
					+ "\r\n"
					+ "WHERE w_sche.isHide = 0\r\n"
					+ "\r\n"
					+ "AND w_sche.employee_id = ?\r\n"
					+ "\r\n"
					+ "AND (w_sche.work_date = ?\r\n"
					+ "\r\n"
					+ "OR (w_sche.work_shift_id = 4\r\n"
					+ "\r\n"
					+ "AND w_sche.work_date = ?))";
			java.util.Date nextDate = new java.util.Date(date.getTime() - 86400000);
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			statement.setDate(2, new java.sql.Date(date.getTime()));
			statement.setDate(3, new java.sql.Date(nextDate.getTime()));
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				list.add(new wSche_join_wShift(rs.getInt(1), rs.getInt(2), rs.getDate(3), 
						rs.getInt(4), rs.getString(7), rs.getString(8)));
			}
			return list; 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUlti.closeConnection(con);
		}
		return list;
	}
	
	public List<Work_schedule> paginate(int pageNumber, int rowOfPage){
		List<Work_schedule> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			String sql2 = "SELECT *\r\n"
					+ "  FROM work_schedule\r\n"
					+ "  where isHide=0\r\n"
					+ "  order by work_schedule_id\r\n"
					+ "  offset (?-1)*? rows\r\n"
					+ "  fetch next ? rows only";
			PreparedStatement st = con.prepareStatement(sql2);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Work_schedule(rs.getInt("work_schedule_id"), rs.getInt("employee_id"),
						rs.getDate("work_date"), rs.getInt("work_shift_id")));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int countRow2() {
		int count = 0;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT count(*)\r\n"
					+ "  FROM work_schedule\r\n"
					+ "  where isHide=0";
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
	
	public Boolean checkExistsAttendance(int WscheID) {
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "SELECT *\r\n"
					+ "  FROM attendance\r\n"
					+ "  where work_schedule_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, WscheID);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return false;
			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public void checkIn ()  {
		
		
		try {
			Connection con = JdbcUlti.getConnection();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long miliNow = System.currentTimeMillis();
			Date date = new Date(miliNow);
			String sql = "insert into attendance(employee_id, work_schedule_id, time_in, time_out, hours_worked)\r\n"
					+ "  values (?, ?, ?, 0, 0)";

			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			statement.setInt(2, RowClicked.work_schedule_id);
			statement.setString(3, df.format(date));


			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Check In Successfully");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void lateForWork() {
		try {
			Connection con = JdbcUlti.getConnection();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			long miliNow = System.currentTimeMillis();
			Date date = new Date(miliNow);
			String sql = "insert into salary_deduction(employee_id, deduction_reason, deduction_amount, deduction_date)\r\n"
					+ "  values(?,?,?,?)";

			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			statement.setString(2, "late for work");
			statement.setDouble(3, lateforwork);
			statement.setDate(4, new java.sql.Date(date.getTime()));

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Late For Work!");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void checkOutRightTime() {
		try {
			Connection con = JdbcUlti.getConnection();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long miliNow = System.currentTimeMillis();
			Date date = new Date(miliNow);
			
			Double hour = (RowClicked.dateWorkOut.getTime() - RowClicked.dateWorkIn.getTime())/3600000.0;
			
			String sql = "update attendance\r\n"
					+ "  set time_out = ?, hours_worked= ?\r\n"
					+ "  where work_schedule_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, df.format(date));
			statement.setDouble(2, hour);
			statement.setInt(3, RowClicked.work_schedule_id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Check Out Successfully");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkOutWrongTime() {
		try {
			Connection con = JdbcUlti.getConnection();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long miliNow = System.currentTimeMillis();
			Date date = new Date(miliNow);
			
			Double hour = (RowClicked.dateWorkOut.getTime() - RowClicked.dateWorkIn.getTime())/3600000.0;
			
			String sql = "update attendance\r\n"
					+ "  set time_out = ?, hours_worked= ?\r\n"
					+ "  where work_schedule_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, df.format(date));
			statement.setDouble(2, hour/2.0);
			statement.setInt(3, RowClicked.work_schedule_id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Check Out Successfully");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void checkOutBefore() {
		try {
			Connection con = JdbcUlti.getConnection();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			long miliNow = System.currentTimeMillis();
			Date date = new Date(miliNow);
			
			Double hour = (date.getTime() - RowClicked.dateWorkIn.getTime())/3600000.0;
			
			String sql = "update attendance\r\n"
					+ "  set time_out = ?, hours_worked= ?\r\n"
					+ "  where work_schedule_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setString(1, df.format(date));
			statement.setDouble(2, hour);
			statement.setInt(3, RowClicked.work_schedule_id);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				JOptionPane.showMessageDialog(null, "Check Out Successfully");
			}

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void setIsHide() {
		try {
			Connection con = JdbcUlti.getConnection();
			
			
			String sql = " update work_schedule\r\n"
					+ "  set isHide=1\r\n"
					+ "  where work_schedule_id = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, RowClicked.work_schedule_id);

			statement.executeUpdate();
			

			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
