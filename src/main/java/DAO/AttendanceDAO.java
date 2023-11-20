package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.Attendance;


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
}
