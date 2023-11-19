package entity;

public class WorkShift {
	private int work_shift_id;
	private String description;
	/**
	 * 
	 */
	public WorkShift() {
	}

	public WorkShift(int work_shift_id, String description) {
		this.work_shift_id = work_shift_id;
		this.description = description;
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
	@Override
	public String toString() {
		return "WorkShift [work_shift_id=" + work_shift_id + ", description=" + description + "]";
	}
	
}
