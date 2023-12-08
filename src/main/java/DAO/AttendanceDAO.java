package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.Attendance;
import entity.EmployeeAfterLogin;
import entity.Leave;


public class AttendanceDAO {
	public List<Attendance> selectAtt(){
		List<Attendance> list = new ArrayList<>();
		try {
			var con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from attendance";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Attendance(rs.getInt("attendance_id"), rs.getInt("employee_id"),rs.getInt("work_schedule_id"), rs.getTimestamp("time_in"),rs.getTimestamp("time_out"),rs.getDouble("hours_worked"),rs.getString("status")
				));
				
			}
			JdbcUlti.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	 public List<Attendance> getAttendanceForEmployee() {
	        List<Attendance> list = new ArrayList<>();
	        try {
	        	var con = JdbcUlti.getConnection();
				var statement = con.createStatement();
	            String sql = "SELECT * FROM attendance WHERE employee_id = ?";
	            PreparedStatement st = con.prepareStatement(sql);
	            st.setInt(1, EmployeeAfterLogin.employeeID);
	            ResultSet rs = st.executeQuery();
	            while (rs.next()) {
	                list.add(new Attendance(
	                        rs.getInt("attendance_id"),
	                        rs.getInt("employee_id"),
	                        rs.getInt("work_schedule_id"),
	                        rs.getTimestamp("time_in"),
	                        rs.getTimestamp("time_out"),
	                        rs.getDouble("hours_worked"),
	                        rs.getString("status")
	                ));
	            }
	            JdbcUlti.closeConnection(con);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	
	public int countRow() {
		int count=0;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT COUNT(*) as count FROM attendance";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				count = rs.getInt(1);
			}
			JdbcUlti.closeConnection(con);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	public List<Attendance> selectPaginateAtt(int pageNumber, int rowOfPage) {
		List<Attendance> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "select * from attendance\r\n"
					+ "	order by attendance_id\r\n"
					+ "	offset (?-1)*? rows\r\n"
					+ "	fetch next ? rows only";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				list.add(new Attendance(
						rs.getInt("attendance_id"),
						rs.getInt("employee_id"), 
						rs.getInt("work_schedule_id"),
						rs.getTimestamp("time_in"),
						rs.getTimestamp("time_out"),
						rs.getFloat("hours_worked"),
						rs.getString("status")
				));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} 
}
