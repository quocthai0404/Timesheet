package DAO;

import database.JdbcUlti;
import entity.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public List<Account> selectAccounts() {
        List<Account> list = new ArrayList<>();
        Connection con = null;

        try {
            con = JdbcUlti.getConnection();
            var statement = con.createStatement();
            String sql = "SELECT * FROM tbltaikhoan";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                list.add(new Account(
                        rs.getInt("account_id"),
                        rs.getInt("employee_id"),
                        rs.getString("tendangnhap"),
                        rs.getString("matkhau"),
                        rs.getString("email"),
                        rs.getString("capbac")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUlti.closeConnection(con);
        }
        return list;
    }
}
