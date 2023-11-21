package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;



import database.JdbcUlti;

import entity.Leave;

public class LeaveDao {
	public List<Leave> selectLeave(){
		List<Leave> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from leave";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Leave(rs.getInt("leave_id"), rs.getInt("employee_id"), rs.getString("leave_type"), rs.getDate("startdate"), rs.getInt("number_of_days"),rs.getString("reason"),rs.getBoolean("approved")
				));
				
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
	public void update(int leave_id,int employee_id, String leave_type, Date  startdate, int number_of_days, String reason, Boolean approved ) {
		
		try {
			java.sql.Date sqlDate = new java.sql.Date(startdate.getTime());
			Connection con = JdbcUlti.getConnection();
			String sql = "UPDATE leave SET employee_id=?, leave_type=?, startdate=?, number_of_days=?, reason=?, approved=?  WHERE leave_id=?";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, leave_id);
			statement.setInt(2, employee_id);
			statement.setString(3, leave_type);
			statement.setDate(4, sqlDate);
			statement.setInt(5,number_of_days);
			statement.setString(6, reason);
			statement.setBoolean(7, approved);
			 
			
			if (statement.executeUpdate() > 0) {
			    System.out.println("A leave was updated successfully!");
			}
			JdbcUlti.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void add(int employee_id, String leave_type, Date startdate, int number_of_days, String reason, Boolean approved) {
		try {
			java.sql.Date sqlDate = new java.sql.Date(startdate.getTime());
			Connection con = JdbcUlti.getConnection();
			String sql = "INSERT INTO leave( employee_id, leave_type, startdate, number_of_days, reason, approved)values( ?, ?, ?, ?, ?, ?)";
			 
			PreparedStatement statement = con.prepareStatement(sql);
			
			statement.setInt(1, employee_id);
			statement.setString(2, leave_type);
			statement.setDate(3, sqlDate);
			statement.setInt(4,number_of_days);
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
}

