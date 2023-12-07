package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.WorkShift;

public class Work_shiftDAO {
	public List<String> selectDes(){
		List<String> list = new ArrayList<>() ;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select description from work_shift ";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				list.add((rs.getString("description")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<WorkShift> select(){
		List<WorkShift> list = new ArrayList<>() ;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from work_shift ";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				new WorkShift(
						rs.getInt("work_shift_id"),
						rs.getString("description"),
						rs.getString("wwork_type")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String getWorkTypeByDescription(String description) {
	    String workType = null;
	    
	    try {
	        Connection con = JdbcUlti.getConnection();
	        String sql = "SELECT work_type FROM work_shift WHERE description = ?";
	        
	        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, description);
	            
	            
	            try (ResultSet rs = preparedStatement.executeQuery()) {
	                if (rs.next()) {
	                    workType = rs.getString("work_type");
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return workType;
	}
	
}
