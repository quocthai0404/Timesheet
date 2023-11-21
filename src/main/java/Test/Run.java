package Test;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import entity.Attendance;

import DAO.EmployeeDAO;
import DAO.Salary_deductionDAO;
import DAO.Work_scheduleDAO;
import entity.Employee;
import entity.Leave;
import entity.Salary;
import entity.Salary_deduction;
import entity.Work_schedule;
public class Run {
	public static void main(String[] args) {
		List<Salary_deduction> list = new ArrayList<>();
		Salary_deductionDAO dao = new Salary_deductionDAO();
		list = dao.selectAllSalaryDeductions();
		list.forEach(sd -> System.out.println(sd.toString()));
		
		
		
		
		
		
		

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


		
		  

	}

}
