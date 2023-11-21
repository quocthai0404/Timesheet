package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.Salary_deducition;

public class Salary_deductionDAO {
    private Connection connection;

    public Salary_deductionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Salary_deducition> selectAllSalaryDeductions() {
        List<Salary_deducition> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM salary_deduction";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    list.add(new Salary_deducition(
                            rs.getInt("salary_deduction_id"),
                            rs.getInt("employee_id"),
                            rs.getString("deduction_reason"),
                            rs.getDouble("deduction_amount"),
                            rs.getDate("deduction_date")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
