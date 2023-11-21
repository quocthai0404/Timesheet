package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.Salary;

public class SalaryDAO {
    public List<Salary> selectSalary() {
        List<Salary> list = new ArrayList<>();
        try {
            Connection con = JdbcUlti.getConnection();
            var statement = con.createStatement();
            String sql = "select * from salary";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                list.add(new Salary(
                        rs.getInt("salary_id"),
                        rs.getInt("employee_id"),
                        rs.getDouble("base_salary"),
                        rs.getDouble("overtime_pay"),
                        rs.getDouble("paid_leave_pay"),
                        rs.getDouble("allowance")
                ));
            }
            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}