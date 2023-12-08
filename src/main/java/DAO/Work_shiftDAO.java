package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.WorkShift;

public class Work_shiftDAO {
	public List<String> selectDes(){
		List<String> list = new ArrayList<>() ;
		Connection con=null;
		try {
			con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select description from work_shift ";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				list.add((rs.getString("description")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUlti.closeConnection(con);
		}
		return list;
	}

	public List<WorkShift> select() {
	    List<WorkShift> workShifts = new ArrayList<>();
	    String sql = "SELECT * FROM work_shift";

	    try (Connection connection = JdbcUlti.getConnection();
	         Statement statement = connection.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {

	        while (resultSet.next()) {
	            int workShiftId = resultSet.getInt("work_shift_id");
	            String description = resultSet.getString("description");
	            String workType = resultSet.getString("work_type"); // Make sure to include this line

	            WorkShift workShift = new WorkShift(workShiftId, description, workType);
	            workShifts.add(workShift);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle the exception as needed
	    }

	    return workShifts;

	}
	
	
}
