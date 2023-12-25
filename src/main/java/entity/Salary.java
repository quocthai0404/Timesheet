package entity;

public class Salary {
	private int salary_id;
	private int employee_id;
	private double base_salary;
	private double overtime_pay;
	private double paid_leave_pay;
	private double allowance;

	public Salary() {
	}

	public Salary(int salary_id, int employee_id, double base_salary, double overtime_pay, double paid_leave_pay,
			double allowance) {
		this.salary_id = salary_id;
		this.employee_id = employee_id;
		this.base_salary = base_salary;
		this.overtime_pay = overtime_pay;
		this.paid_leave_pay = paid_leave_pay;
		this.allowance = allowance;
	}

	public int getSalary_id() {
		return salary_id;
	}

	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public double getBase_salary() {
		return base_salary;
	}

	public void setBase_salary(double base_salary) {
		this.base_salary = base_salary;
	}

	public double getOvertime_pay() {
		return overtime_pay;
	}

	public void setOvertime_pay(double overtime_pay) {
		this.overtime_pay = overtime_pay;
	}

	public double getPaid_leave_pay() {
		return paid_leave_pay;
	}

	public void setPaid_leave_pay(double paid_leave_pay) {
		this.paid_leave_pay = paid_leave_pay;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	@Override
	public String toString() {
		return "Salary [salary_id=" + salary_id + ", employee_id=" + employee_id + ", base_salary=" + base_salary
				+ ", overtime_pay=" + overtime_pay + ", paid_leave_pay=" + paid_leave_pay + ", allowance=" + allowance
				+ "]";
	}

}
