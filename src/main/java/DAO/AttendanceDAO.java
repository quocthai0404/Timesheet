package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Attendance;
import entity.EmployeeAfterLogin;

public class AttendanceDAO {

	Double deductionForLate = 100000.0;
	Double deductionForCheckOutWrongTime = 200000.0;

	public List<Attendance> selectAtt() {
		List<Attendance> list = new ArrayList<>();
		try {
			var con = JdbcUlti.getConnection();
			String sql = "select * from attendance where employee_id=?";
			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, EmployeeAfterLogin.employeeID);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),
						rs.getInt("work_schedule_id"), rs.getString("time_in"), rs.getString("time_out"),
						rs.getDouble("hours_worked")));

			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	public List<Attendance> getAttendanceForEmployee() {
//		List<Attendance> list = new ArrayList<>();
//		try {
//			var con = JdbcUlti.getConnection();
//			var statement = con.createStatement();
//			String sql = "SELECT * FROM attendance WHERE employee_id = ?";
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, EmployeeAfterLogin.employeeID);
//			ResultSet rs = st.executeQuery();
//			while (rs.next()) {
//				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),
//						rs.getInt("work_schedule_id"), rs.getTimestamp("time_in"), rs.getTimestamp("time_out"),
//						rs.getDouble("hours_worked"), rs.getString("status")));
//			}
//			JdbcUlti.closeConnection(con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

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

//	public List<Attendance> selectPaginateAtt(int pageNumber, int rowOfPage) {
//		List<Attendance> list = new ArrayList<>();
//		try {
//			Connection con = JdbcUlti.getConnection();
//
//			String sql = "select * from attendance\r\n" + "	order by attendance_id\r\n" + "	offset (?-1)*? rows\r\n"
//					+ "	fetch next ? rows only";
//			PreparedStatement st = con.prepareStatement(sql);
//			st.setInt(1, pageNumber);
//			st.setInt(2, rowOfPage);
//			st.setInt(3, rowOfPage);
//			ResultSet rs = st.executeQuery();
//			while (rs.next()) {
//				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),
//						rs.getInt("work_schedule_id"), rs.getTimestamp("time_in"), rs.getTimestamp("time_out"),
//						rs.getFloat("hours_worked"), rs.getString("status")));
//			}
//			JdbcUlti.closeConnection(con);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

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
			} else {
				JOptionPane.showMessageDialog(null, "cannot handle this action!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
	}

	public void checkIn(String textWorkScheduleId, String textEmpID, String textWorkShiftID,
			Map<Integer, String> mapTimeIn) {
		int wsID = Integer.parseInt(textWorkShiftID);
		int wscheID = Integer.parseInt(textWorkScheduleId);
		int empID = Integer.parseInt(textEmpID);
		AttendanceDAO dao = new AttendanceDAO();
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
			dao.checkInOnTime(textWorkScheduleId, textEmpID);
		} else {
			System.out.println("ok");

			dao.checkInOnTime(textWorkScheduleId, textEmpID);
		}

	}

	public Boolean checkExitsAtten(String textWorkScheduleId) {
		Connection con = null;
		int hour_worked = 1;
		try {
			con = JdbcUlti.getConnection();
			String sql = "select hours_worked from attendance where work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(textWorkScheduleId));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				hour_worked = rs.getInt(1);
			}
			if (hour_worked == 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void checkOut(String textWorkShiftID, Map<Integer, String> mapTimeOut, String textEmpID,
			String textWorkScheduleId, Map<Integer, String> mapTimeIn) {
		int wsID = Integer.parseInt(textWorkShiftID);
		Connection con = null;
		String timeOut = null;
		long currentTimeMillis = System.currentTimeMillis();
		Date dateNow = new Date(currentTimeMillis);
		AttendanceDAO dao = new AttendanceDAO();
		String timeIn = null;
		String date_work = null;
		String timeMustIn = null;
		switch (wsID) {
		case 1: {
			timeOut = mapTimeOut.get(wsID).toString() + ":00:00";
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		case 2: {
			timeOut = mapTimeOut.get(wsID).toString() + ":00:00";
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		case 3: {
			timeOut = mapTimeOut.get(wsID).toString() + ":00:00";
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		case 4: {
			timeOut = mapTimeOut.get(wsID).toString() + ":00:00";
			timeMustIn = mapTimeIn.get(wsID).toString() + ":00:00";
		}
		}
		String StringDateTimeMustIn = new SimpleDateFormat("yyyy-MM-dd").format(dateNow) + " " + timeMustIn;
		Date timeMustInDate = null;
		try {
			timeMustInDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(StringDateTimeMustIn);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String StringDateTimeOut = new SimpleDateFormat("yyyy-MM-dd").format(dateNow) + " " + timeOut;
		Date DateTimeOut = null;
		try {
			DateTimeOut = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(StringDateTimeOut);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if ((DateTimeOut.getTime() < currentTimeMillis) && (currentTimeMillis - DateTimeOut.getTime() < 7200000)) {
			System.out.println("checkout success");
			timeIn = dao.getTimeIn(textEmpID, textWorkScheduleId);
			date_work = dao.getDateWork(textEmpID, textWorkScheduleId);
			String dateWork_timeIn = date_work + " " + timeIn;
			Date dateWorkTimeIn = null;
			try {
				dateWorkTimeIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateWork_timeIn);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (dateWorkTimeIn.getTime() < timeMustInDate.getTime()) {
				System.out.println("check in som");
				dateWorkTimeIn = timeMustInDate;
			}
			System.out.println("date time in: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateWorkTimeIn));
			System.out.println("date time out: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(DateTimeOut));
			double HourWorked = (DateTimeOut.getTime() - dateWorkTimeIn.getTime()) / 3600000.0;
			DecimalFormat df = new DecimalFormat("#.##");
			HourWorked = Double.valueOf(df.format(HourWorked));
			String timeout = new SimpleDateFormat("HH:mm:ss").format(dateNow);
			dao.addToAttendance(textEmpID, timeout, HourWorked, textWorkScheduleId);
			dao.updateHideWorkSche(textWorkScheduleId);
		} else if (currentTimeMillis < DateTimeOut.getTime()) {
			JOptionPane.showMessageDialog(null, "You are on shift and cannot check out");
		} else {
			String timeout = new SimpleDateFormat("HH:mm:ss").format(dateNow);
			dao.checkOutWrongTime(timeout, textEmpID, textWorkScheduleId);
			dao.deductionCheckOutWrongTime(deductionForCheckOutWrongTime, textEmpID, dateNow);
			dao.updateHideWorkSche(textWorkScheduleId);
			JOptionPane.showMessageDialog(null, "You checked out at the wrong time");
		}

	}

	public String getTimeIn(String emp_id, String work_sche_id) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();

			String sql = "SELECT time_in\r\n" + "   \r\n" + "FROM attendance\r\n"
					+ "where employee_id=? and work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, Integer.parseInt(emp_id));
			statement.setInt(2, Integer.parseInt(work_sche_id));

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
		return null;
	}

	public String getDateWork(String emp_id, String work_sche_id) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();

			String sql = "select work_schedule.work_date\r\n" + "  from attendance\r\n" + "  join work_schedule\r\n"
					+ "  on attendance.work_schedule_id=work_schedule.work_schedule_id\r\n"
					+ "  where attendance.employee_id=? and attendance.work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, Integer.parseInt(emp_id));
			statement.setInt(2, Integer.parseInt(work_sche_id));

			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
		return null;
	}

	public void addToAttendance(String emp_id, String timeout, Double hourWorked, String workScheID) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();

			String sql = " update attendance\r\n" + "  set time_out=?, hours_worked=?\r\n"
					+ "  where employee_id=? and work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, timeout);
			statement.setDouble(2, hourWorked);
			statement.setInt(3, Integer.parseInt(emp_id));
			statement.setInt(4, Integer.parseInt(workScheID));
			int row = statement.executeUpdate();
			if (row > 0) {
				JOptionPane.showMessageDialog(null, "Check out successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
	}

	public void updateHideWorkSche(String textWorkScheduleId) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();

			String sql = " update work_schedule\r\n" + "  set isHide=1\r\n" + "  where work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(textWorkScheduleId));

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("ok");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
	}

	public void checkOutWrongTime(String timeout, String textEmpID, String textWorkScheduleId) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();

			String sql = " update attendance\r\n" + "  set time_out=?, hours_worked=0\r\n"
					+ "  where employee_id=? and work_schedule_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, timeout);
			statement.setInt(2, Integer.parseInt(textEmpID));
			statement.setInt(3, Integer.parseInt(textWorkScheduleId));

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("update ok");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
	}

	public void deductionCheckOutWrongTime(Double deductionForCheckOutWrongTime, String textEmpID, Date date) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();

			String sql = "insert into salary_deduction(employee_id, deduction_reason, deduction_amount, deduction_date)\r\n"
					+ "  values(?,'Check Out Wrong Time', ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(textEmpID));
			statement.setDouble(2, deductionForCheckOutWrongTime);
			statement.setDate(3, new java.sql.Date(date.getTime()));

			int row = statement.executeUpdate();
			if (row > 0) {
				System.out.println("insert ok");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
	}

}