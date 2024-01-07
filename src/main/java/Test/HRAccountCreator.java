package Test;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;

import javax.swing.JOptionPane;

import database.JdbcUlti;

public class HRAccountCreator {

    public static void main(String[] args) {
        HRAccountCreator hrCreator = new HRAccountCreator();
        hrCreator.createHRAccount("hr", "hr");
    }

    public void createHRAccount(String username, String password) {
        Connection con = null;
        try {
            con = JdbcUlti.getConnection();
            String sql = "insert into HRaccount(username, password) values (?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            
            // Mã hóa mật khẩu bằng MD5
            String encryptedPassword = encryptPassword(password);

            st.setString(1, username);
            st.setString(2, encryptedPassword);

            int rowsUpdated = st.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "A new HR account was inserted successfully!");
            }

            JdbcUlti.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mã hóa mật khẩu bằng MD5
    private String encryptPassword(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getBytes());
            return new String(Base64.getEncoder().encode(bytes));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
