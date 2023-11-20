package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
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
}
