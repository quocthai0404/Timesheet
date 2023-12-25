package entity;

import java.util.Date;

public class Leave {
	private int leave_id;
	private int employee_id;
	private String leave_type;
	private Date startdate;
	private int number_of_days;
	private String reason;
	private Boolean approved;

	public Leave() {
	}

	public Leave(int leave_id, int employee_id, String leave_type, Date startdate, int number_of_days, String reason,
			Boolean approved) {
		this.leave_id = leave_id;
		this.employee_id = employee_id;
		this.leave_type = leave_type;
		this.startdate = startdate;
		this.number_of_days = number_of_days;
		this.reason = reason;
		this.approved = approved;
	}

	public int getLeave_id() {
		return leave_id;
	}

	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getLeave_type() {
		return leave_type;
	}

	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public int getNumber_of_days() {
		return number_of_days;
	}

	public void setNumber_of_days(int number_of_days) {
		this.number_of_days = number_of_days;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	@Override
	public String toString() {
		return "Leave [leave_id=" + leave_id + ", employee_id=" + employee_id + ", leave_type=" + leave_type
				+ ", startdate=" + startdate + ", number_of_days=" + number_of_days + ", reason=" + reason
				+ ", approved=" + approved + "]";
	}

}
