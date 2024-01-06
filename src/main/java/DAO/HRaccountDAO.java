package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.HRaccount;

public class HRaccountDAO {

    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "SELECT * FROM HRaccount WHERE username = ? AND password = ?";

    public Boolean login(String username, String password) {
        try (Connection con = JdbcUlti.getConnection()) {
            String sql = "SELECT username, password FROM HRaccount WHERE username = ? AND password = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, password);
                try (ResultSet rs = statement.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while accessing database for login", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    public boolean checkRoleHR(String username) {
    	try (Connection con = JdbcUlti.getConnection()) {
            String sql = "SELECT role FROM hr_account WHERE username = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, username);
                try (ResultSet rs = statement.executeQuery()) {
                    return rs.next() && "manager".equals(rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error while accessing database for role check", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
