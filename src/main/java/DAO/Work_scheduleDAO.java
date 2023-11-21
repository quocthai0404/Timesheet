package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import database.JdbcUlti;
import entity.Work_schedule;

public class Work_scheduleDAO {
	public List<Work_schedule> selectWorkSchedule(){
		List<Work_schedule> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from work_schedule";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Work_schedule(
						rs.getInt("work_schedule_id"),
						rs.getInt("employee_id"),
						rs.getDate("work_date"),
						rs.getInt("work_shift_id"),
						rs.getString("work_type")
						)
					);
				
			}
			JdbcUlti.closeConnection(con);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void delete(int work_schedule_id) {
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "delete from work_schedule where work_schedule_id = ?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, work_schedule_id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
			    System.out.println("work schedule was deleted successfully!");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(int work_schedule_id, int employee_id, Date work_date, 
			int work_shift_id, String work_type) 
	{
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "update work_schedule set employee_id = ?, work_date = ?, work_shift_id = ?, work_type = ? where work_schedule_id=?";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, employee_id);
			statement.setDate(2,new java.sql.Date(work_date.getTime()));
			statement.setInt(3, work_shift_id);
			statement.setString(4, work_type);
			statement.setInt(5, work_schedule_id);
			 
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
			    System.out.println("An existing work schedule was updated successfully!");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void add(int employee_id, Date work_date, int work_shift_id, String work_type) {
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, "bill");
			statement.setString(2, "secretpass");
			statement.setString(3, "Bill Gates");
			statement.setString(4, "bill.gates@microsoft.com");
			 
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
			    System.out.println("A new user was inserted successfully!");
			}
			
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
