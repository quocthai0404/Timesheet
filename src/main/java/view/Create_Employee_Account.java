package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;

import database.JdbcUlti;
import entity.Employee;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Create_Employee_Account extends JPanel {
    private JPanel jPanel23;
    private JLabel lbAddNV5;
    private JTextField txtUsername;
    private JButton btnCreate;
    private JTextField txtPassword;
    private JTextField txtEmail;
    private JTextField txtAcc_privilege;
    private JTextField txtEmp_ID;

    public Create_Employee_Account() {

        jPanel23 = new JPanel();
        jPanel23.setBackground(Color.BLACK);

        lbAddNV5 = new JLabel();
        lbAddNV5.setText("Tạo Tài Khoản cho Nhân Viên");
        lbAddNV5.setHorizontalAlignment(SwingConstants.CENTER);
        lbAddNV5.setForeground(Color.WHITE);
        lbAddNV5.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbAddNV5.setBackground(Color.BLACK);
        GroupLayout gl_jPanel23 = new GroupLayout(jPanel23);
        gl_jPanel23.setHorizontalGroup(
            gl_jPanel23.createParallelGroup(Alignment.LEADING)
                .addGap(0, 542, Short.MAX_VALUE)
                .addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        gl_jPanel23.setVerticalGroup(
            gl_jPanel23.createParallelGroup(Alignment.LEADING)
                .addGap(0, 52, Short.MAX_VALUE)
                .addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        );
        jPanel23.setLayout(gl_jPanel23);

        txtUsername = new JTextField();
        txtUsername.setToolTipText("");
        txtUsername.setColumns(10);
        txtUsername.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        btnCreate = new JButton();
        btnCreate.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnCreate.setBackground(new Color(0, 0, 0));
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCreateActionPerformed(e);
            }
        });
        btnCreate.setText("Tạo");
        btnCreate.setMinimumSize(new Dimension(60, 30));

        txtPassword = new JTextField();
        txtPassword.setToolTipText("");
        txtPassword.setColumns(10);
        txtPassword.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        txtEmail = new JTextField();
        txtEmail.setToolTipText("");
        txtEmail.setColumns(10);
        txtEmail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        txtAcc_privilege = new JTextField();
        txtAcc_privilege.setToolTipText("");
        txtAcc_privilege.setColumns(10);
        txtAcc_privilege.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Account privilege", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        txtEmp_ID = new JTextField();
        txtEmp_ID.setToolTipText("");
        txtEmp_ID.setColumns(10);
        txtEmp_ID.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(113)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtEmp_ID, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtAcc_privilege, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(213, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addGap(72)
        			.addComponent(txtEmp_ID, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtAcc_privilege, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(49, Short.MAX_VALUE))
        );
        setLayout(groupLayout);
    }

    // Create
    protected void btnCreateActionPerformed(ActionEvent e) {
        try {
            // Lấy thông tin từ các trường dữ liệu
            int empId = Integer.parseInt(txtEmp_ID.getText());
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String email = txtEmail.getText();
            String accPrivilege = txtAcc_privilege.getText();

            // Gọi stored procedure để thêm tài khoản
            try (Connection connection = JdbcUlti.getConnection();
                 CallableStatement callableStatement = connection.prepareCall("{call InsertAccount(?, ?, ?, ?, ?)}")) {

                callableStatement.setInt(1, empId);
                callableStatement.setString(2, username);
                callableStatement.setString(3, password);
                callableStatement.setString(4, email);
                callableStatement.setString(5, accPrivilege);

                callableStatement.execute();
            }

            // In thông tin ra màn hình (bạn có thể xóa hoặc thay thế bằng hành động phù hợp)
//            System.out.println("Thông tin tài khoản đã tạo:");
//            System.out.println("Employee ID: " + empId);
//            System.out.println("Username: " + username);
//            System.out.println("Password: " + password);
//            System.out.println("Email: " + email);
//            System.out.println("Account Privilege: " + accPrivilege);
//
//            // Làm sạch các trường dữ liệu sau khi tạo xong
//            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

//    // Phương thức để làm sạch các trường dữ liệu sau khi tạo
//    private void clearFields() {
//        txtEmp_ID.setText("");
//        txtUsername.setText("");
//        txtPassword.setText("");
//        txtEmail.setText("");
//        txtAcc_privilege.setText("");
//    }
}
