package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.JdbcUlti;
import entity.Salary_deduction;

public class Salary_deductionDAO {
<<<<<<< HEAD
    public List<Salary_deduction> selectAllSalaryDeductions() {
        List<Salary_deduction> list = new ArrayList<>();
        try {
        	Connection con = JdbcUlti.getConnection();
            var statement = con.createStatement();
            String sql = "select * from salary_deduction";
            ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
=======
    
    public List<Salary_deduction> selectAllSalaryDeductions() {
        List<Salary_deduction> list = new ArrayList<>();
        try {
            Connection con = JdbcUlti.getConnection();
    		var statement = con.createStatement();
    		String query = "SELECT * FROM salary_deduction";
    		ResultSet rs = statement.executeQuery(query);
               while (rs.next()) {
>>>>>>> 96050a2413f2a306d56d263fc845c85973f5140a
                    list.add(new Salary_deduction(
                            rs.getInt("salary_deduciton_id"),
                            rs.getInt("employee_id"),
                            rs.getString("deduction_reason"),
                            rs.getDouble("deduction_amount"),
                            rs.getDate("deduction_date")
                    ));
<<<<<<< HEAD
                }
=======
           }
           JdbcUlti.closeConnection(con);
>>>>>>> 96050a2413f2a306d56d263fc845c85973f5140a
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
