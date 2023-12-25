package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.Detailed_salary;

public class Detailed_salaryDAO {
	public List<Detailed_salary> selectDetailedSalaries() {
		List<Detailed_salary> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from detailed_salary";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Detailed_salary(rs.getInt("detailed_salary_id"), rs.getInt("employee_id"),
						rs.getDouble("base_salary"), rs.getDouble("paid_leave_pay"), rs.getDouble("allowance"),
						rs.getInt("number_of_paid_leave_days"), rs.getInt("number_of_unpaid_leave_days"),
						rs.getDouble("number_of_overtime_hours"), rs.getDouble("unpaid_leave_deduction"),
						rs.getDouble("overtime_pay")));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
