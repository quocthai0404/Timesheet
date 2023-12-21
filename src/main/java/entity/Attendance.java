package entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Attendance {
	private int attendance_id;
	private int employee_id;
	private int work_schedule_id;
	private String time_in; // Change type to Timestamp
    private String time_out; // Change type to Timestamp
	private double hours_works;
	public Attendance() {
		
	}
	
	public Attendance(int attendance_id, int employee_id, int work_schedule_id, String time_in, String time_out,
	            double hours_works) {
	    this.attendance_id = attendance_id;
	    this.employee_id = employee_id;
	    this.work_schedule_id = work_schedule_id;
	    this.time_in = time_in;
	    this.time_out = time_out;
	    this.hours_works = hours_works;
	}

	public int getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(int attendance_id) {
		this.attendance_id = attendance_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public int getWork_schedule_id() {
		return work_schedule_id;
	}

	public void setWork_schedule_id(int work_schedule_id) {
		this.work_schedule_id = work_schedule_id;
	}

	public String getTime_in() {
		return time_in;
	}

	public void setTime_in(String time_in) {
		this.time_in = time_in;
	}

	public String getTime_out() {
		return time_out;
	}

	public void setTime_out(String time_out) {
		this.time_out = time_out;
	}

	public double getHours_works() {
		return hours_works;
	}

	public void setHours_works(double hours_works) {
		this.hours_works = hours_works;
	}

	@Override
	public String toString() {
		return "Attendance [attendance_id=" + attendance_id + ", employee_id=" + employee_id + ", work_schedule_id="
				+ work_schedule_id + ", time_in=" + time_in + ", time_out=" + time_out + ", hours_works=" + hours_works
				+ "]";
	}

	

	

}
