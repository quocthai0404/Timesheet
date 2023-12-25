package entity;

public class WorkShift {
	private int work_shift_id;
	private String description;
	private String work_type;

	public WorkShift() {
	}

	public WorkShift(int work_shift_id, String description, String work_type) {

		this.work_shift_id = work_shift_id;
		this.description = description;
		this.work_type = work_type;
	}

	/**
	 * @param description
	 */
	public WorkShift(String description) {

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

	public String getWork_type() {
		return work_type;
	}

	public void setWork_type(String work_type) {
		this.work_type = work_type;
	}

	@Override
	public String toString() {
		return getDescription();
	}

}
