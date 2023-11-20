package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
}
