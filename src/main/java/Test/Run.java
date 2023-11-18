package Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import entity.Employee;
public class Run {

	public static void main(String[] args) {
		Employee emp = new Employee();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			emp.setBirthday(df.parse("2004-12-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(emp.toString());
	}

}
