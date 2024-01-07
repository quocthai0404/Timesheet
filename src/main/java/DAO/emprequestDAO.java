package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import database.JdbcUlti;
import entity.Emprequest;

public class emprequestDAO {
    public void insert(int w_sche_id, Date work_date, int work_shift_id, String reason) {
        Connection con = null;
        try {
            con = JdbcUlti.getConnection();
            String sql = "INSERT INTO emprequest(work_schedule_id, work_date, work_shift_id, reason, isaccept) "
                    + "VALUES (?, ?, ?, ?, 0)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, w_sche_id);
            statement.setDate(2, new java.sql.Date(work_date.getTime()));
            statement.setInt(3, work_shift_id);
            statement.setString(4, reason);
            int row = statement.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(null, "Your request has been sent successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUlti.closeConnection(con);
        }
    }

    public List<Emprequest> selectUnCheckedEmprequests(int pageNumber, int rowOfPage) {
        List<Emprequest> list = new ArrayList<>();
        try {
            Connection con = JdbcUlti.getConnection();
            String sql = "SELECT * FROM emprequest WHERE isaccept = 0 ORDER BY id "
                    + "OFFSET (?-1)*? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, pageNumber);
            st.setInt(2, rowOfPage);
            st.setInt(3, rowOfPage);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Emprequest(rs.getInt("id"), rs.getInt("work_schedule_id"), rs.getDate("work_date"),
                        rs.getInt("work_shift_id"), rs.getString("reason"), rs.getBoolean("isaccept"),
                        rs.getInt("employee_id"), rs.getString("employee_name")
                ));
            }
            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int countRow() {
        int count = 0;
        try {
            Connection con = JdbcUlti.getConnection();
            var statement = con.createStatement();
            String sql = "SELECT COUNT(*) AS count FROM emprequest";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                count = rs.getInt("count");
            }
            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void delete(int id) {
        try {
            Connection con = JdbcUlti.getConnection();
            String sql = "DELETE FROM emprequest WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Deleted successfully!");
            }
            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the database");
        }
    }

    public void updateStatus(int id) {
        try {
            Connection con = JdbcUlti.getConnection();
            String sql = "UPDATE emprequest SET isaccept = 1 WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Accepted request!");
            }
            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the database");
        }
    }
}
