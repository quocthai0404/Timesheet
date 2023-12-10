package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Attendance;
import entity.EmployeeAfterLogin;
import entity.Leave;

public class AttendanceDAO {
	Map<Integer, String> mapTimeIn = new HashMap<Integer, String>();
	Map<Integer, String> mapTimeOut = new HashMap<Integer, String>();
	Double deductionForLate = 100000.0;

	public List<Attendance> selectAtt() {
		List<Attendance> list = new ArrayList<>();
		try {
			var con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from attendance";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),
						rs.getInt("work_schedule_id"), rs.getTimestamp("time_in"), rs.getTimestamp("time_out"),
						rs.getDouble("hours_worked"), rs.getString("status")));

			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Attendance> getAttendanceForEmployee() {
		List<Attendance> list = new ArrayList<>();
		try {
			var con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT * FROM attendance WHERE employee_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, EmployeeAfterLogin.employeeID);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),
						rs.getInt("work_schedule_id"), rs.getTimestamp("time_in"), rs.getTimestamp("time_out"),
						rs.getDouble("hours_worked"), rs.getString("status")));
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
			String sql = "SELECT COUNT(*) as count FROM attendance";
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

	public List<Attendance> selectPaginateAtt(int pageNumber, int rowOfPage) {
		List<Attendance> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "select * from attendance\r\n" + "	order by attendance_id\r\n" + "	offset (?-1)*? rows\r\n"
					+ "	fetch next ? rows only";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),
						rs.getInt("work_schedule_id"), rs.getTimestamp("time_in"), rs.getTimestamp("time_out"),
						rs.getFloat("hours_worked"), rs.getString("status")));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void checkInOnTime(String textWorkScheduleId, String textEmpID) {
		long currentTimeMillis = System.currentTimeMillis();
		Date dateIn = new Date(currentTimeMillis);
		Connection con = null;
		String timeIn = new SimpleDateFormat("HH:mm:ss").format(dateIn);
			
		try {
			con = JdbcUlti.getConnection();
			
			String sql = "insert into attendance(employee_id, work_schedule_id, time_in, time_out, hours_worked)\r\n"
					+ "	values (?, ?, ?, ?, ?)";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(textEmpID));
			statement.setInt(2, Integer.parseInt(textWorkScheduleId));
			statement.setString(3, timeIn);
			statement.setString(4, "");
			statement.setInt(5, 0);
	 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				JOptionPane.showMessageDialog(null, "Check In successfully!");
			}else {
				JOptionPane.showMessageDialog(null, "cannot handle this action!");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUlti.closeConnection(con);
		}
	}

	public void checkIn(String textWorkScheduleId, String textEmpID, String textWorkShiftID) {
		int wsID = Integer.parseInt(textWorkShiftID);
		int wscheID = Integer.parseInt(textWorkScheduleId);
		int empID = Integer.parseInt(textEmpID);
		mapTimeIn.put(1, "08");
		mapTimeIn.put(2, "08");
		mapTimeIn.put(3, "13");
		mapTimeIn.put(4, "17");
		mapTimeOut.put(1, "17");
		mapTimeOut.put(2, "12");
		mapTimeOut.put(3, "17");
		mapTimeOut.put(4, "20");
		long currentTimeMillis = System.currentTimeMillis();
		Date dateIn = new Date(currentTimeMillis);

		String dateMustIn = new SimpleDateFormat("yyyy-MM-dd").format(dateIn);
		String timeMustIn = null;
		switch (wsID) {
		case 1: {
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		case 2: {
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		case 3: {
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		case 4: {
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		}
		String full = dateMustIn + " " + timeMustIn;
		Date dmInFull = null;
		try {
			dmInFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(full);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("dateIn: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateIn));
		System.out.println("dateMustIn: " + dateMustIn + " " + timeMustIn);

		System.out.println("dateIn: " + dateIn.getTime());
		System.out.println("dateMustIn: " + dmInFull.getTime());
		if (dateIn.getTime() > dmInFull.getTime()) {
			JOptionPane.showMessageDialog(null,
					"You are late. You will be deducted " + deductionForLate + " from your salary.");
			Salary_deductionDAO sldao = new Salary_deductionDAO();
			try {
				sldao.add(empID, "late for work", deductionForLate,
						new SimpleDateFormat("yyyy-MM-dd").parse(dateMustIn));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ok");
			AttendanceDAO dao = new AttendanceDAO();
			dao.checkInOnTime(textWorkScheduleId, textEmpID);
		}

	}
}
