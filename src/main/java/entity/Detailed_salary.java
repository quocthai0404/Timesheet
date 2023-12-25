package entity;

public class Detailed_salary {
	private int detailed_salary_id;
	private int employee_id;
	private double base_salary;
	private double paid_leave_pay;
	private double allowance;
	private int number_of_paid_leave_days;
	private int number_of_unpaid_leave_days;
	private double number_of_overtime_hours;
	private double unpaid_leave_deduction;
	private double overtime_pay;

	public Detailed_salary() {
	}

	public Detailed_salary(int detailed_salary_id, int employee_id, double base_salary, double paid_leave_pay,
			double allowance, int number_of_paid_leave_days, int number_of_unpaid_leave_days,
			double number_of_overtime_hours, double unpaid_leave_deduction, double overtime_pay) {
		super();
		this.detailed_salary_id = detailed_salary_id;
		this.employee_id = employee_id;
		this.base_salary = base_salary;
		this.paid_leave_pay = paid_leave_pay;
		this.allowance = allowance;
		this.number_of_paid_leave_days = number_of_paid_leave_days;
		this.number_of_unpaid_leave_days = number_of_unpaid_leave_days;
		this.number_of_overtime_hours = number_of_overtime_hours;
		this.unpaid_leave_deduction = unpaid_leave_deduction;
		this.overtime_pay = overtime_pay;
	}

	public int getDetailed_salary_id() {
		return detailed_salary_id;
	}

	public void setDetailed_salary_id(int detailed_salary_id) {
		this.detailed_salary_id = detailed_salary_id;
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

	public int getNumber_of_paid_leave_days() {
		return number_of_paid_leave_days;
	}

	public void setNumber_of_paid_leave_days(int number_of_paid_leave_days) {
		this.number_of_paid_leave_days = number_of_paid_leave_days;
	}

	public int getNumber_of_unpaid_leave_days() {
		return number_of_unpaid_leave_days;
	}

	public void setNumber_of_unpaid_leave_days(int number_of_unpaid_leave_days) {
		this.number_of_unpaid_leave_days = number_of_unpaid_leave_days;
	}

	public double getNumber_of_overtime_hours() {
		return number_of_overtime_hours;
	}

	public void setNumber_of_overtime_hours(double number_of_overtime_hours) {
		this.number_of_overtime_hours = number_of_overtime_hours;
	}

	public double getUnpaid_leave_deduction() {
		return unpaid_leave_deduction;
	}

	public void setUnpaid_leave_deduction(double unpaid_leave_deduction) {
		this.unpaid_leave_deduction = unpaid_leave_deduction;
	}

	public double getOvertime_pay() {
		return overtime_pay;
	}

	public void setOvertime_pay(double overtime_pay) {
		this.overtime_pay = overtime_pay;
	}

	@Override
	public String toString() {
		return "Detailed_salary [detailed_salary_id=" + detailed_salary_id + ", employee_id=" + employee_id
				+ ", base_salary=" + base_salary + ", paid_leave_pay=" + paid_leave_pay + ", allowance=" + allowance
				+ ", number_of_paid_leave_days=" + number_of_paid_leave_days + ", number_of_unpaid_leave_days="
				+ number_of_unpaid_leave_days + ", number_of_overtime_hours=" + number_of_overtime_hours
				+ ", unpaid_leave_deduction=" + unpaid_leave_deduction + ", overtime_pay=" + overtime_pay + "]";
	}

}
