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
    
    public List<Salary_deduction> selectAllSalaryDeductions() {
        List<Salary_deduction> list = new ArrayList<>();
        try {
            Connection con = JdbcUlti.getConnection();
    		var statement = con.createStatement();
    		String query = "SELECT * FROM salary_deduction";
    		ResultSet rs = statement.executeQuery(query);
               while (rs.next()) {
                    list.add(new Salary_deduction(
                            rs.getInt("salary_deduciton_id"),
                            rs.getInt("employee_id"),
                            rs.getString("deduction_reason"),
                            rs.getDouble("deduction_amount"),
                            rs.getDate("deduction_date")
                    ));
           }
           JdbcUlti.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
