package entity;
import java.sql.*;


import java.text.SimpleDateFormat;	
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Salary_deduction {
	private int salary_deduction_id;
	private int employee_id;
	private String deduction_reason;
	private double deduction_amount;

	private Date deduction_date;
	

	
	public Salary_deduction() {}

	public Salary_deduction(int salary_deduction_id, int employee_id, String deduction_reason, double deduction_amount,
			Date deduction_date) {
		this.salary_deduction_id = salary_deduction_id;
		this.employee_id = employee_id;
		this.deduction_reason = deduction_reason;
		this.deduction_amount = deduction_amount;
		this.deduction_date = deduction_date;
	}



	public int getSalary_deduction_id() {
		return salary_deduction_id;
	}


	public void setSalary_deduction_id(int salary_deduction_id) {
		this.salary_deduction_id = salary_deduction_id;

	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getDeduction_reason() {
		return deduction_reason;
	}


	public void setDeduction_reason(String deduction_reason) {
		this.deduction_reason = deduction_reason;
	}


	public double getDeduction_amount() {
		return deduction_amount;
	}


	public void setDeduction_amount(double deduction_amount) {
		this.deduction_amount = deduction_amount;
	}


	public Date getDeduction_date() {
		return deduction_date;
	}


	public void setDeduction_date(Date deduction_date) {
		this.deduction_date = deduction_date;
	}


	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				return "Salary_deduction [salary_deduction_id=" + salary_deduction_id + ", employee_id=" + employee_id
						+ ", deduction_reason=" + deduction_reason + ", deduction_amount=" + deduction_amount
						+ ", deduction_date=" + df.format(deduction_date) + "]";
	}
}
