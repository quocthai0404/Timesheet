package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private int employee_id;
	private String employee_name;
	private String position;
	private Date birthday;
	private boolean gender;
	
	public Employee() {}
	public Employee(int employee_id, String employee_name, String position, Date birthday, boolean gender) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.position = position;
		this.birthday = birthday;
		this.gender = gender;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", position=" + position
				+ ", birthday=" + df.format(birthday) + ", gender=" + gender + "]";
	}
	
	
	
	
}
