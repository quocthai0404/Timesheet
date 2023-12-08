package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;



import database.JdbcUlti;

import entity.Employee;
import entity.EmployeeAfterLogin;
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
	
	
//	public void update(int leave_id,int employee_id, String leave_type, Date  startdate, int number_of_days, String reason, Boolean approved ) {
//		
//		try {
//			java.sql.Date sqlDate = new java.sql.Date(startdate.getTime());
//			Connection con = JdbcUlti.getConnection();
//			String sql = "UPDATE leave SET employee_id=?, leave_type=?, startdate=?, number_of_days=?, reason=?, approved=?  WHERE leave_id=?";
//			 
//			PreparedStatement statement = con.prepareStatement(sql);
//			statement.setInt(1, employee_id);
//			statement.setString(2, leave_type);
//			statement.setDate(3, sqlDate);
//			statement.setInt(4,number_of_days);
//			statement.setString(5, reason);
//			statement.setBoolean(6, approved);
//			statement.setInt(7, leave_id); 
//			
//			if (statement.executeUpdate() > 0) {
//			    System.out.println("A leave was updated successfully!");
//			}
//			JdbcUlti.closeConnection(con);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public void update(int leave_id, boolean approved) {
	    try {
	        Connection con = JdbcUlti.getConnection();
	        String sql = "UPDATE leave SET approved=?, leave_type='paid leave' WHERE leave_id=?";
	 
	        PreparedStatement statement = con.prepareStatement(sql);
	        statement.setBoolean(1, approved);
	        statement.setInt(2, leave_id);
	        
	        if (statement.executeUpdate() > 0) {
	            System.out.println("Approval status updated successfully!");
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
	
	public int countRow() {
		int count=0;
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "SELECT COUNT(*) as count FROM leave";
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
	
	public void updateLeaveRequest(Date startDate, String numsOfDate, String reason) {
        try {
 
            Connection connection = JdbcUlti.getConnection();
            String sql = "UPDATE leave SET start_date=?, nums_of_date=?, reason=? WHERE leave_id=?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setDate(1, (java.sql.Date) startDate);
            statement.setString(2, numsOfDate);
            statement.setString(3, reason);
            
            if (statement.executeUpdate() > 0) {
                System.out.println("leave request updated");
            }
            
            JdbcUlti.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void addLeaveRequest(Date startDate, String numsOfDate, String reason) {
        try {
            Connection connection = JdbcUlti.getConnection();
            String sql = "insert into leave(employee_id, leave_type, startdate, number_of_days, reason, approved)\r\n"
            		+ "values (?, 'unpaid leave', ?, ?, ?, 0)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, EmployeeAfterLogin.employeeID);
            statement.setDate(2, new java.sql.Date(startDate.getTime()));	
            statement.setString(3, numsOfDate);
            statement.setString(4, reason);
            
            if (statement.executeUpdate() > 0) {
                System.out.println("leave request added");
            }
            
            JdbcUlti.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    public static void delete(int leaveId) {
        try {
            Connection connection = JdbcUlti.getConnection();
            String sql = "DELETE FROM leave WHERE leave_id = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, leaveId);
            
            if (statement.executeUpdate() > 0) {
                System.out.println("Leave request deleted successfully!");
            } else {
                System.out.println("Failed to delete leave request.");
            }
            
            JdbcUlti.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
	public List<Leave> selectPaginateEmp(int pageNumber, int rowOfPage) {
		List<Leave> list = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			
			String sql = "select * from leave\r\n"
					+ "	order by leave_id\r\n"
					+ "	offset (?-1)*? rows\r\n"
					+ "	fetch next ? rows only";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pageNumber);
			st.setInt(2, rowOfPage);
			st.setInt(3, rowOfPage);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				list.add(new Leave(
						rs.getInt("leave_id"),
						rs.getInt("employee_id"), 
						rs.getString("leave_type"),
						rs.getDate("startdate"),
						rs.getInt("number_of_days"),
						rs.getString("reason"),
						rs.getBoolean("approved")	
				));
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	 public void addLeaveRequest(Date startDate, String numberOfDays, String reason, int employeeId) {
	         String sql = "INSERT INTO leave_requests (employee_id, leave_type, startdate, number_of_days, reason, approved) " +
	                      "VALUES (?, ?, ?, ?, ?, ?)";

	         try (Connection connection = JdbcUlti.getConnection();
	              PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

	             // Thiết lập tham số cho câu truy vấn
	             preparedStatement.setInt(1, employeeId);
	             preparedStatement.setString(2, "Phép nghỉ"); // Hoặc loại nghỉ phép mà bạn đang sử dụng
	             preparedStatement.setDate(3, new java.sql.Date(startDate.getTime()));
	             preparedStatement.setString(4, numberOfDays);
	             preparedStatement.setString(5, reason);
	             preparedStatement.setBoolean(6, false); // Ban đầu, yêu cầu chưa được phê duyệt

	             // Thực hiện truy vấn
	             preparedStatement.executeUpdate();

	         } catch (SQLException e) {
	             e.printStackTrace();
	             // Xử lý lỗi tùy theo yêu cầu
	         }
	     }
	 private Connection connection;
	    public Leave getLeaveByUsername(String username) {
	        // Lấy employee_id từ bảng account dựa trên username
	        int employeeId = getEmployeeIdByUsername(username);

	        // Nếu không tìm thấy employee_id, trả về null hoặc xử lý theo ý bạn
	        if (employeeId == -1) {
	            return null;
	        }

	        // Sử dụng employee_id để lấy thông tin từ bảng leave
	        String sql = "SELECT * FROM leave WHERE employee_id = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setInt(1, employeeId);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                Leave leave = new Leave();
	                leave.setLeave_id(resultSet.getInt("leave_id"));
	                leave.setEmployee_id(resultSet.getInt("employee_id"));
	                leave.setLeave_type(resultSet.getString("leave_type"));
	                leave.setStartdate(resultSet.getDate("startdate"));
	                leave.setNumber_of_days(resultSet.getInt("number_of_days"));
	                leave.setReason(resultSet.getString("reason"));
	                leave.setApproved(resultSet.getBoolean("approved"));
	                return leave;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	    private int getEmployeeIdByUsername(String username) {
	        String sql = "SELECT employee_id FROM account WHERE username = ?";
	        try (PreparedStatement statement = connection.prepareStatement(sql)) {
	            statement.setString(1, username);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                return resultSet.getInt("employee_id");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        // Trả về -1 nếu không tìm thấy employee_id
	        return -1;
	    }
}

