package Test;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;

import javax.swing.JOptionPane;

import database.JdbcUlti;

public class Test_Create_Admin_Account {

    public static void main(String[] args) {
        signUpNewAdmin("admin", "admin");
    }

    public static void signUpNewAdmin(String username, String password) {
        Connection con = null;
        try {
            con = JdbcUlti.getConnection();
            String sql = "insert into admin(username, password) values (?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            String md5_password = new String(Base64.getEncoder().encode(bytes));
            st.setString(1, username);
            st.setString(2, md5_password);
            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "A new admin account was inserted successfully!");
            }

            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
