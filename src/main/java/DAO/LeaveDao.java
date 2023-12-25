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
import entity.EmployeeAfterLogin;
import entity.Leave;

public class LeaveDao {
	public List<Leave> selectLeave() {
		List<Leave> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from leave";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Leave(rs.getInt("leave_id"), rs.getInt("employee_id"), rs.getString("leave_type"),
						rs.getDate("startdate"), rs.getInt("number_of_days"), rs.getString("reason"),
						rs.getBoolean("approved")));

			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//	public void delete(int leave_id){
//		try{
//			Connection con = JdbcUlti.getConnection();
//			
//			String sql = "DELETE FROM leave WHERE leave_id = ?";
//			 
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setInt(1, leave_id);
//			 
//			
//			if (statement.executeUpdate() > 0) {
//			    System.out.println("A user was deleted successfully!");
//			}
//			JdbcUlti.closeConnection(con);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

//	public void update(int leave_id,int employee_id, String leave_type, Date  startdate, int number_of_days, String reason, Boolean approved ) {
//		
//		try {
//			java.sql.Date sqlDate = new java.sql.Date(startdate.getTime());
//			Connection con = JdbcUlti.getConnection();
//			String sql = "UPDATE leave SET employee_id=?, leave_type=?, startdate=?, number_of_days=?, reason=?, approved=?  WHERE leave_id=?";
//			 
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setInt(1, employee_id);
//			statement.setString(2, leave_type);
//			statement.setDate(3, sqlDate);
//			statement.setInt(4,number_of_days);
//			statement.setString(5, reason);
//			statement.setBoolean(6, approved);
//			statement.setInt(7, leave_id); 
//			
//			if (statement.executeUpdate() > 0) {
//			    System.out.println("A leave was updated successfully!");
//			}
//			JdbcUlti.closeConnection(con);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public void update(int leave_id, boolean approved) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "UPDATE leave SET approved=?, leave_type='paid leave' WHERE leave_id=?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setBoolean(1, approved);
			statement.setInt(2, leave_id);

			if (statement.executeUpdate() > 0) {
				System.out.println("Approval status updated successfully!");
			}

			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(int employee_id, String leave_type, Date startdate, int number_of_days, String reason,
			Boolean approved) {
		try {
			java.sql.Date sqlDate = new java.sql.Date(startdate.getTime());
			Connection con = JdbcUlti.getConnection();
			String sql = "INSERT INTO leave( employee_id, leave_type, startdate, number_of_days, reason, approved)values( ?, ?, ?, ?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(sql);

			statement.setInt(1, employee_id);
			statement.setString(2, leave_type);
			statement.setDate(3, sqlDate);
			statement.setInt(4, number_of_days);
			statement.setString(5, reason);
			statement.setBoolean(6, approved);

			if (statement.executeUpdate() > 0) {
				System.out.println("A leave was added successfully!");
			}
			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int countRow() {
		int count = 0;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT COUNT(*) as count FROM leave";
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

	public void updateLeaveRequest(Date startDate, String numsOfDate, String reason) {
		try {

			Connection connection = JdbcUlti.getConnection();
			String sql = "UPDATE leave SET start_date=?, nums_of_date=?, reason=? WHERE leave_id=?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setDate(1, (java.sql.Date) startDate);
			statement.setString(2, numsOfDate);
			statement.setString(3, reason);

			if (statement.executeUpdate() > 0) {
				System.out.println("leave request updated");
			}

			JdbcUlti.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addLeaveRequest(Date startDate, String numsOfDate, String reason) {
		try {
			Connection connection = JdbcUlti.getConnection();
			String sql = "insert into leave(employee_id, leave_type, startdate, number_of_days, reason, approved)\r\n"
					+ "values (?, 'unpaid leave', ?, ?, ?, 0)";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			statement.setDate(2, new java.sql.Date(startDate.getTime()));
			statement.setString(3, numsOfDate);
			statement.setString(4, reason);

			if (statement.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Your request has been sent");
			}

			JdbcUlti.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void delete(int leaveId) {
		try {
			Connection connection = JdbcUlti.getConnection();
			String sql = "DELETE FROM leave WHERE leave_id = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, leaveId);

			if (statement.executeUpdate() > 0) {
				System.out.println("Leave request deleted successfully!");
			} else {
				System.out.println("Failed to delete leave request.");
			}

			JdbcUlti.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Leave> selectPaginateEmp(int pageNumber, int rowOfPage) {
		List<Leave> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "select * from leave\r\n" + "	order by leave_id\r\n" + "	offset (?-1)*? rows\r\n"
					+ "	fetch next ? rows only";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Leave(rs.getInt("leave_id"), rs.getInt("employee_id"), rs.getString("leave_type"),
						rs.getDate("startdate"), rs.getInt("number_of_days"), rs.getString("reason"),
						rs.getBoolean("approved")));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Boolean checkLeaveId(int id) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
			String sql = "select * from leave where employee_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
		return false;
	}

	public Boolean getDayOff(Date date, int numberOfDay) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String[] parts = df.format(date).split("-");
		Connection con = null;
		int total_month = 0;
		int total_year = 0;
		try {
			con = JdbcUlti.getConnection();
			String sql = "SELECT \r\n"
					+ "    SUM(CASE WHEN MONTH(startdate) = ? THEN number_of_days ELSE 0 END) AS total_days_in_month,\r\n"
					+ "    SUM(CASE WHEN YEAR(startdate) = ? THEN number_of_days ELSE 0 END) AS total_days_in_2000\r\n"
					+ "FROM\r\n" + "    leave\r\n" + "WHERE\r\n" + "    employee_id = ?\r\n" + "GROUP BY\r\n"
					+ "    employee_id;";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(parts[1]));
			statement.setInt(2, Integer.parseInt(parts[0]));
			statement.setInt(3, EmployeeAfterLogin.employeeID);
			ResultSet rs = statement.executeQuery();

			if (checkLeaveId(EmployeeAfterLogin.employeeID)) {
				System.out.println("ok");
				while (rs.next()) {
					total_month = rs.getInt(1);
					total_year = rs.getInt(2);
				}

			} else {
				System.out.println("ko");
			}
			if (total_month + numberOfDay <= 3 && total_year < 12) {
				return true;
			}
			JOptionPane.showMessageDialog(null,
					"You have asked for leave more than 3 days a month, 12 days a year\n" + "total days off in year "
							+ parts[0] + " is: " + total_year + "\ntotal days off in month " + parts[1] + " is: "
							+ total_month);
//				System.out.println("year"+parts[0]+" month"+parts[1]);
//				System.out.println("total month+nod = "+(total_month+numberOfDay));
//				System.out.println("totalyear="+total_year);
//				System.out.println("total_month ="+total_month);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
		return false;
	}
}