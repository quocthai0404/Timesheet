package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Employee;
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
				int row = preparedStatement.executeUpdate();
				if(row>0) {
					JOptionPane.showMessageDialog(null, "This row update OK!");
				}
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
				int row = preparedStatement.executeUpdate();
				if(row>0) {
					JOptionPane.showMessageDialog(null, "Add A New Salary Deduction OK");
				}
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
			String sql = "SELECT COUNT(*) as count FROM salary_deduction";
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
	
	public List<Salary_deduction> selectPaginateEmp(int pageNumber, int rowOfPage) {
		List<Salary_deduction> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "select * from salary_deduction\r\n"
					+ "  	order by salary_deduction_id\r\n"
					+ "  offset (?-1)*? rows\r\n"
					+ "  	fetch next ? rows only";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
		
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Salary_deduction(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getDouble(4), rs.getDate(5)));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Salary_deduction> searchByid(int ID) {
		List<Salary_deduction> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();

			String sql = "SELECT [salary_deduction_id]\r\n"
					+ "      ,[employee_id]\r\n"
					+ "      ,[deduction_reason]\r\n"
					+ "      ,[deduction_amount]\r\n"
					+ "      ,[deduction_date]\r\n"
					+ "  FROM [dbo].[salary_deduction]\r\n"//[timesheet].
					+ "  where employee_id=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, ID);
		
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(new Salary_deduction(rs.getInt(1), rs.getInt(2), rs.getString(3), 
						rs.getDouble(4), rs.getDate(5)));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Employee getEmpNameByID(int ID) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
			String sql = "select * from employee\r\n"
					+ "  where employee_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getString("employee_name"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUlti.closeConnection(con);
		}
		return null;
		
	}
	
	public int countError(int ID) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
			String sql = "select Count(employee_id)\r\n"
					+ "  from salary_deduction\r\n"
					+ "  where employee_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUlti.closeConnection(con);
		}
		return 0;
	}
}