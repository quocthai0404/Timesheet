package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class wSche_join_wShift {
	private int work_schedule_id;
	private int employee_id;
	private Date work_date;
	private int work_shift_id;
	private String description;
	private String work_type;
	
	public wSche_join_wShift() {}
	
	public wSche_join_wShift(int work_schedule_id, int employee_id, 
			Date work_date, int work_shift_id,
			String description, String work_type) {
		this.work_schedule_id = work_schedule_id;
		this.employee_id = employee_id;
		this.work_date = work_date;
		this.work_shift_id = work_shift_id;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "wSche_join_wShift [work_schedule_id=" + work_schedule_id + ", employee_id=" + employee_id
				+ ", work_date=" + df.format(work_date) + ", work_shift_id=" + work_shift_id + ", description=" + description
				+ ", work_type=" + work_type + "]";
	}
	
	
	
	
	
	
}
