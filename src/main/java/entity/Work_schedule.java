package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Work_schedule {
	private int work_schedule_id;
	private int employee_id;
	private Date work_date;
	private int work_shift_id;
	private String work_type;
	private String work_description;

	public Work_schedule() {
		super();
	}

	public Work_schedule(int work_schedule_id, int employee_id, Date work_date, int work_shift_id) {

		this.work_schedule_id = work_schedule_id;
		this.employee_id = employee_id;
		this.work_date = work_date;
		this.work_shift_id = work_shift_id;

	}

	public Work_schedule(int work_schedule_id, int employee_id, Date work_date, int work_shift_id,
			String work_description, String work_type) {
		this.work_schedule_id = work_schedule_id;
		this.employee_id = employee_id;
		this.work_date = work_date;
		this.work_shift_id = work_shift_id;
		this.work_description = work_description;
		this.work_type = work_type;

	}

	public int getWork_schedule_id() {
		return work_schedule_id;
	}

	public void setWork_schedule_id(int work_schedule_id) {
		this.work_schedule_id = work_schedule_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public Date getWork_date() {
		return work_date;
	}

	public void setWork_date(Date work_date) {
		this.work_date = work_date;
	}

	public int getWork_shift_id() {
		return work_shift_id;
	}

	public void setWork_shift_id(int work_shift_id) {
		this.work_shift_id = work_shift_id;
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	public String getWork_description() {
		return work_description;
	}

	public void setWork_description(String work_description) {
		this.work_description = work_description;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "Work_schedule [work_schedule_id=" + work_schedule_id + ", employee_id=" + employee_id + ", work_date="
				+ df.format(work_date) + ", work_shift_id=" + work_shift_id + ", work_type=" + work_type + "]";
	}

}
