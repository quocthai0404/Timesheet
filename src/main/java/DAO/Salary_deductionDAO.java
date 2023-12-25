package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.JdbcUlti;
import entity.Salary_deduction;

public class Salary_deductionDAO {

	public List<Salary_deduction> selectAllSalaryDeductions() {
		List<Salary_deduction> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String query = "SELECT * FROM salary_deduction";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				list.add(new Salary_deduction(rs.getInt("salary_deduction_id"), rs.getInt("employee_id"),
						rs.getString("deduction_reason"), rs.getDouble("deduction_amount"),
						rs.getDate("deduction_date")));
			}
			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void delete(int salary_deduction_id) {
		try {
			Connection con = JdbcUlti.getConnection();
			String query = "DELETE FROM salary_deduction WHERE salary_deduction_id = ?";
			try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
				preparedStatement.setInt(1, salary_deduction_id);
				preparedStatement.executeUpdate();
			}
			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int salary_deduction_id, int employee_id, String deduction_reason, double deduction_amount,
			Date deduction_date) {
		try {
			Connection con = JdbcUlti.getConnection();
			String query = "UPDATE salary_deduction SET employee_id = ?, deduction_reason = ?, deduction_amount = ?, deduction_date = ? WHERE salary_deduction_id = ?";
			try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
				preparedStatement.setInt(1, employee_id);
				preparedStatement.setString(2, deduction_reason);
				preparedStatement.setDouble(3, deduction_amount);
				preparedStatement.setDate(4, new java.sql.Date(deduction_date.getTime()));
				preparedStatement.setInt(5, salary_deduction_id);
				preparedStatement.executeUpdate();
			}
			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(int employee_id, String deduction_reason, double deduction_amount, Date deduction_date) {
		try {
			Connection con = JdbcUlti.getConnection();
			String query = "INSERT INTO salary_deduction (employee_id, deduction_reason, deduction_amount, deduction_date) VALUES (?, ?, ?, ?)";
			try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
				preparedStatement.setInt(1, employee_id);
				preparedStatement.setString(2, deduction_reason);
				preparedStatement.setDouble(3, deduction_amount);
				preparedStatement.setDate(4, new java.sql.Date(deduction_date.getTime()));
				preparedStatement.executeUpdate();
			}
			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}