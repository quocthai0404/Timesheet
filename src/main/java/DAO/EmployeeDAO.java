package DAO;


import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
}
