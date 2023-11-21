package entity;
import java.sql.*;
import java.text.SimpleDateFormat;	
import java.util.Date;
public class Salary_deduction {
	private int salary_đeucition_id;
	private int employee_id;
	private String deducition_reason;
	private double deducition_amount;
	private Date deducition_date;
	
	public Salary_deduction() {}

	public Salary_deduction(int salary_đeucition_id, int employee_id, String deducition_reason,
		Double deducition_amount, Date deducition_date) {
		super();
		this.salary_đeucition_id = salary_đeucition_id;
		this.employee_id = employee_id;
		this.deducition_reason = deducition_reason;
		this.deducition_amount = deducition_amount;
		this.deducition_date = deducition_date;
	}

	public int getSalary_đeucition_id() {
		return salary_đeucition_id;
	}

	public void setSalary_đeucition_id(int salary_đeucition_id) {
		this.salary_đeucition_id = salary_đeucition_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getDeducition_reason() {
		return deducition_reason;
	}

	public void setDeducition_reason(String deducition_reason) {
		this.deducition_reason = deducition_reason;
	}

	public Double getDeducition_amount() {
		return deducition_amount;
	}

	public void setDeducition_amount(Double deducition_amount) {
		this.deducition_amount = deducition_amount;
	}

	public Date getDeducition_date() {
		return deducition_date;
	}

	public void setDeducition_date(Date deducition_date) {
		this.deducition_date = deducition_date;
	}

	@Override
	public String toString() {
		return "Salary_deduction [salary_đeucition_id=" + salary_đeucition_id + ", employee_id=" + employee_id
				+ ", deducition_reason=" + deducition_reason + ", deducition_amount=" + deducition_amount
				+ ", deducition_date=" + deducition_date + "]";
	}
	
	
}
