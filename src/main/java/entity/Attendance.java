package entity;

import java.security.Timestamp;
import java.text.SimpleDateFormat;

public class Attendance {
	private int attendance_id;
	private int employee_id;
	private int work_schedule_id;
	private Timestamp time_in;
	private Timestamp time_out;
	private double hours_works;
	private String status;
	/**
	 * 
	 */
	public Attendance() {
		
	}
	/**
	 * @param attendance_id
	 * @param employee_id
	 * @param work_schedule_id
	 * @param time_in
	 * @param time_out
	 * @param hours_works
	 * @param status
	 */
	public Attendance(int attendance_id, int employee_id, int work_schedule_id, Timestamp time_in, Timestamp time_out,
			double hours_works, String status) {
		
		this.attendance_id = attendance_id;
		this.employee_id = employee_id;
		this.work_schedule_id = work_schedule_id;
		this.time_in = time_in;
		this.time_out = time_out;
		this.hours_works = hours_works;
		this.status = status;
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
	public Timestamp getTime_in() {
		return time_in;
	}
	public void setTime_in(Timestamp time_in) {
		this.time_in = time_in;
	}
	public Timestamp getTime_out() {
		return time_out;
	}
	public void setTime_out(Timestamp time_out) {
		this.time_out = time_out;
	}
	public double getHours_works() {
		return hours_works;
	}
	public void setHours_works(double hours_works) {
		this.hours_works = hours_works;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "Attendance [attendance_id=" + attendance_id + ", employee_id=" + employee_id + ", work_schedule_id="
				+ work_schedule_id + ", time_in=" + df.format(time_in) + ", time_out=" + df.format(time_out) + ", hours_works=" + hours_works
				+ ", status=" + status + "]";
	}
	
	
	
	
}
