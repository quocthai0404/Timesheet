package Test;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import DAO.EmployeeDAO;
import entity.Employee;
import entity.Leave;
import entity.Salary;
public class Run {
	public static void main(String[] args) {
		EmployeeDAO empdao = new EmployeeDAO();
		List<Employee> list = new ArrayList<>();
		list = empdao.selectEmployee();
		list.forEach(emp -> System.out.println(emp.toString()));
	}

}
