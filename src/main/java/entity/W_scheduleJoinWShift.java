package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.JdbcUlti;

public class W_scheduleJoinWShift {
	private int work_schedule_id;
	private int employee_id;
	private Date work_date;
	private int work_shift_id;
	private String description;
	private String work_type;

	public W_scheduleJoinWShift() {
	}

	public W_scheduleJoinWShift(int work_schedule_id, int employee_id, Date work_date, int work_shift_id,
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

	public ArrayList<W_scheduleJoinWShift> listJoin(Date date) {
		ArrayList<W_scheduleJoinWShift> list = new ArrayList<>();
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
			String sql = "select ws.work_schedule_id, ws.employee_id, ws.work_date, ws.work_shift_id, work_shift.description, work_shift.work_type  \r\n"
					+ "  from work_schedule as ws\r\n" + "  inner join work_shift\r\n"
					+ "  on work_shift.work_shift_id=ws.work_shift_id\r\n"
					+ "  where ws.employee_id=? and work_date=? and ws.isHide=0";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			statement.setDate(2, new java.sql.Date(date.getTime()));
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				list.add(new W_scheduleJoinWShift(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUlti.closeConnection(con);
		}
		return list;
	}

	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return "W_scheduleJoinWShift [work_schedule_id=" + work_schedule_id + ", employee_id=" + employee_id
				+ ", work_date=" + df.format(work_date) + ", work_shift_id=" + work_shift_id + ", description="
				+ description + ", work_type=" + work_type + "]";
	}

}
