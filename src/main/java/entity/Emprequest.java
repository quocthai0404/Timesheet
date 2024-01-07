package entity;

import java.util.Date;

public class Emprequest {
    private int id;
    private int work_schedule_id;
    private Date work_date;
    private int work_shift_id;
    private String reason;
    private boolean isaccept;
    private int employee_id; // Thêm trường employee_id
    private String employee_name; // Thêm trường employee_name

    public Emprequest() {
    }

    public Emprequest(int id, int work_schedule_id, Date work_date, int work_shift_id, String reason, boolean isaccept, int employee_id, String employee_name) {
        this.id = id;
        this.work_schedule_id = work_schedule_id;
        this.work_date = work_date;
        this.work_shift_id = work_shift_id;
        this.reason = reason;
        this.isaccept = isaccept;
        this.employee_id = employee_id;
        this.employee_name = employee_name;
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

    public boolean isIsaccept() {
        return isaccept;
    }

    public void setIsaccept(boolean isaccept) {
        this.isaccept = isaccept;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    @Override
    public String toString() {
        return "Emprequest [id=" + id + ", work_schedule_id=" + work_schedule_id + ", work_date=" + work_date
                + ", work_shift_id=" + work_shift_id + ", reason=" + reason + ", isaccept=" + isaccept
                + ", employee_id=" + employee_id + ", employee_name=" + employee_name + "]";
    }
}
