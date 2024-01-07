package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Employee;
import entity.Salary;

public class SalaryDAO {
	public List<Salary> selectSalary() {
		List<Salary> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from salary";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Salary(rs.getInt("salary_id"), rs.getInt("employee_id"), rs.getDouble("base_salary"),
						rs.getDouble("overtime_pay"), rs.getDouble("paid_leave_pay"), rs.getDouble("allowance")));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//    public void delete(int salary_id) {
//    	try {
//    		Connection con = JdbcUlti.getConnection();
//            String sql = "delete from salary where salary_id=?";
//            try (PreparedStatement statement = con.prepareStatement(sql)) {
//                statement.setInt(1, salary_id);
//                statement.executeUpdate();
//                
//                if (statement.executeUpdate() > 0) {
//    			JOptionPane.showMessageDialog(null, "delete success");
//                }
//            }
//            JdbcUlti.closeConnection(con);
//    	} catch (Exception e) {
//			e.printStackTrace();
//		}
//    }

	public void update(int employee_id, double base_salary, double overtime_pay, double paid_leave_pay,
			double allowance) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "update salary set base_salary = ?, overtime_pay = ?, paid_leave_pay = ?, allowance = ? WHERE employee_id = ?";
			try (PreparedStatement statement = con.prepareStatement(sql)) {
				statement.setDouble(1, base_salary);
				statement.setDouble(2, overtime_pay);
				statement.setDouble(3, paid_leave_pay);
				statement.setDouble(4, allowance);
				statement.setInt(5, employee_id);
				int row = statement.executeUpdate();

				if (row > 0) {
					JOptionPane.showMessageDialog(null, "update success");
				}
				JdbcUlti.closeConnection(con);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(int employee_id, double base_salary, double overtime_pay, double paid_leave_pay, double allowance) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "insert into salary (employee_id, base_salary, overtime_pay, paid_leave_pay, allowance) values (?,?,?,?,?)";
			try (PreparedStatement statement = con.prepareStatement(sql)) {
				statement.setInt(1, employee_id);
				statement.setDouble(2, base_salary);
				statement.setDouble(3, overtime_pay);
				statement.setDouble(4, paid_leave_pay);
				statement.setDouble(5, allowance);
				int row = statement.executeUpdate();
				if (row > 0) {
					JOptionPane.showMessageDialog(null, "add success");
				}
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Boolean checkSalary(int empId) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select * from salary where employee_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, empId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Salary viewSalary(int empId) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select * from salary where employee_id=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, empId);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return new Salary(rs.getInt(1), rs.getInt(2), rs.getDouble(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int countDayOff(int id, int month, int year) {
		int count=0; 
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "SELECT SUM(number_of_days) AS total_days_off\r\n"
					+ "	FROM leave\r\n"
					+ "	WHERE employee_id = ?\r\n"
					+ "	AND month(startdate) = ?\r\n"
					+ "	and year(startdate) = ? and leave_type='paid'";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, month);
			statement.setInt(3, year);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int countDayOffUnpaid(int id, int month, int year) {
		int count=0; 
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "SELECT SUM(number_of_days) AS total_days_off\r\n"
					+ "	FROM leave\r\n"
					+ "	WHERE employee_id = ?\r\n"
					+ "	AND month(startdate) = ?\r\n"
					+ "	and year(startdate) = ? and leave_type='unpaid'";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, month);
			statement.setInt(3, year);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int countOvertimeHour(int id, int month, int year) {
		int count=0; 
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "SELECT SUM(hours_worked) AS total_overtime_hours\r\n"
					+ "	FROM work_schedule ws\r\n"
					+ "	INNER JOIN attendance a ON a.work_schedule_id = ws.work_schedule_id\r\n"
					+ "	 join work_shift  on work_shift.work_shift_id = ws.work_shift_id\r\n"
					+ "	WHERE a.employee_id = ?\r\n"
					+ "	and work_shift.work_type = 'overtime'\r\n"
					+ "	and month(ws.work_date) = ?\r\n"
					+ "	and year (ws.work_date) = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, month);
			statement.setInt(3, year);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public Double countDeduction(int id, int month, int year) {
		Double count=0.0; 
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select sum(deduction_amount)  as totaldeduc\r\n"
					+ "	from salary_deduction\r\n"
					+ "	where employee_id=?\r\n"
					+ "	and MONTH(deduction_date)=?\r\n"
					+ "	and year(deduction_date)=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, month);
			statement.setInt(3, year);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return count=rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}