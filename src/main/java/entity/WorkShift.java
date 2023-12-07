package entity;

public class WorkShift {
	private int work_shift_id;
	private String description;
	private String leave_type;
	/**
	 * 
	 */
	public WorkShift() {}
	public WorkShift(int work_shift_id, String description, String leave_type) {
		this.work_shift_id = work_shift_id;
		this.description = description;
		this.leave_type = leave_type;
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
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	@Override
	public String toString() {
		return "WorkShift [work_shift_id=" + work_shift_id + ", description=" + description + ", leave_type="
				+ leave_type + "]";
	}
	
	
	
}
