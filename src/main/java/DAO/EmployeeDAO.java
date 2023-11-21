package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.JdbcUlti;
import entity.Employee;

public class EmployeeDAO {
	public List<Employee> selectEmployee(){
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from employee";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Employee(
						rs.getInt("employee_id"),
						rs.getString("employee_name"), 
						rs.getString("position"),
						rs.getDate("birthday"), rs.getBoolean("gender")	
				));
				
			}
			JdbcUlti.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void update (int employee_id, String employee_name, 
			String position, Date birthday, Boolean gender) {
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "update employee set employee_name = ?, position=?, birthday= ?, gender=? where employee_id=?";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, employee_name);
			statement.setString(2, position);
			statement.setDate(3, new java.sql.Date(birthday.getTime()));
			statement.setBoolean(4, gender);
			statement.setInt(5, employee_id);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing employee was updated successfully!");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add(String employee_name, String position, Date birthday, Boolean gender) {
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "INSERT INTO employee (employee_name, position, birthday, gender)"
					+ "VALUES (?, ?, ?, ?);";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, employee_name);
			statement.setString(2, position);
			statement.setDate(3, new java.sql.Date(birthday.getTime()));
			statement.setBoolean(4, gender);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("A new employee schedule was inserted successfully!");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
