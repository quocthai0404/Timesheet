package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
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

	public void update(int salary_id, int employee_id, double base_salary, double overtime_pay, double paid_leave_pay,
			double allowance) {
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "update salary set employee_id = ?, base_salary = ?, overtime_pay = ?, paid_leave_pay = ?, allowance = ? WHERE salary_id = ?";
			try (PreparedStatement statement = con.prepareStatement(sql)) {
				statement.setInt(1, employee_id);
				statement.setDouble(2, base_salary);
				statement.setDouble(3, overtime_pay);
				statement.setDouble(4, paid_leave_pay);
				statement.setDouble(5, allowance);
				statement.setInt(6, salary_id);
				statement.executeUpdate();

				if (statement.executeUpdate() > 0) {
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
				statement.executeUpdate();
				if (statement.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "add success");
				}
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}