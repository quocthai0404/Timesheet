package entity;

import java.util.Date;

public class Emprequest {
	private int id;
	private int work_schedule_id;
	private Date work_date;
	private int work_shift_id;
	private String reason;
	private int isaccept;

	public Emprequest() {
	}
	public Emprequest(int id, int work_schedule_id, Date work_date, int work_shift_id, String reason, int isaccept) {
		this.id = id;
		this.work_schedule_id = work_schedule_id;
		this.work_date = work_date;
		this.work_shift_id = work_shift_id;
		this.reason = reason;
		this.isaccept = isaccept;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWork_schedule_id() {
		return work_schedule_id;
	}
	public void setWork_schedule_id(int work_schedule_id) {
		this.work_schedule_id = work_schedule_id;
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
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getIsaccept() {
		return isaccept;
	}
	public void setIsaccept(int isaccept) {
		this.isaccept = isaccept;
	}
	@Override
	public String toString() {
		return "Emprequest [id=" + id + ", work_schedule_id=" + work_schedule_id + ", work_date=" + work_date
				+ ", work_shift_id=" + work_shift_id + ", reason=" + reason + ", isaccept=" + isaccept + "]";
	}
	
	
}
