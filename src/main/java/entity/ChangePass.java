package entity;

import java.util.Date;

public class ChangePass {
	private int id;
	private String username;
	private String code;
	private Date time;

	public ChangePass() {

	}

	public ChangePass(int id, String username, String code, Date time) {

		this.id = id;
		this.username = username;
		this.code = code;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "ChangePass [id=" + id + ", username=" + username + ", code=" + code + ", time=" + time + "]";
	}
	
	
}
