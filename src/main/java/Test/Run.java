package Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.Account;
import entity.Employee;

public class Run {
	public static void main(String[] args) {
//		List<Salary_deduction> list = new ArrayList<>();
//		Salary_deductionDAO dao = new Salary_deductionDAO();
//		list = dao.selectAllSalaryDeductions();
//		list.forEach(sd -> System.out.println(sd.toString()));

//		 String dateString = "2000-12-31 12:09:07";
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//	        try {
//	            java.util.Date parsedDate = dateFormat.parse(dateString);
//	            Timestamp timestamp = new Timestamp(parsedDate.getTime());
//
//	            // Sử dụng timestamp theo nhu cầu của bạn
//	            System.out.println("Timestamp: " + timestamp);
//	            Attendance att = new Attendance(1,1,1,timestamp,timestamp,15.6,"abc");
//	            System.out.println(att.toString());
//	        } catch (ParseException e) {
//	            e.printStackTrace();
//	        }
//		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Salary sl = new Salary();
//		System.out.println(sl);
//		
//		
//		
//
//
//		EmployeeDAO empdao = new EmployeeDAO();
//		List<Employee> list = new ArrayList<>();
//		list = empdao.selectEmployee();
//		list.forEach(emp -> System.out.println(emp.toString()));
//		Work_scheduleDAO dao1 = new Work_scheduleDAO();
//		try {
//			dao1.update(3, 2, new SimpleDateFormat("yyyy-MM-dd").parse("2023-12-01"), 1, "overtime");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			dao1.add(2, new SimpleDateFormat("yyyy-MM-dd").parse("1999-12-01"), 1, "overtime");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		EmployeeDAO dao = new EmployeeDAO();
//		try {
//			dao.add("thai", "manager", new SimpleDateFormat("yyyy-MM-dd").parse("2000-09-09"), true);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			dao.update(1, "update", "up", new SimpleDateFormat("yyyy-MM-dd").parse("2000-09-09"), false);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List<Employee> list = new ArrayList<>();
		List<Account> list2 = new ArrayList<>();
		try {
			Connection con = JdbcUlti.getConnection();
			var statement = con.createStatement();
			String sql = "select * from employee";
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				list.add(new Employee(rs.getInt("employee_id"), rs.getString("employee_name"), rs.getString("position"),
						rs.getDate("birthday"), rs.getBoolean("gender")));

			}
			var statement2 = con.createStatement();
			String sql2 = "select * from account";
			ResultSet rs2 = statement2.executeQuery(sql2);
			while (rs2.next()) {
				list2.add(new Account(rs2.getInt(1), rs2.getInt(2), rs2.getString(3), rs2.getString(4),
						rs2.getString(5)));
			}
			for (Account account : list2) {
				System.out.println(account);
			}
			for (Employee e : list) {
				System.out.println(e);
			}
			JdbcUlti.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
