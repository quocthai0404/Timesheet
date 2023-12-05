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

import javax.swing.LayoutStyle.ComponentPlacement;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.JScrollPane;

public class Create_Employee_Account extends JPanel {
    private JPanel jPanel23;
    private JLabel lbAddNV5;
    private JTextField txtUsername;
    private JButton btnCreate;
    private JTextField txtPassword;
    private JTextField txtEmail;
    private JTextField txtEmp_ID;
    private JTextField textEmpName;
    private JTextField textPosition;
    private JScrollPane scrollPane;
    private JButton btnPrevious;
    private JButton btnNext;
    public Create_Employee_Account() {
    	setBackground(UIManager.getColor("Button.background"));

        jPanel23 = new JPanel();
        jPanel23.setBackground(Color.BLACK);

        lbAddNV5 = new JLabel();
        lbAddNV5.setText("Create Employee Account");
        lbAddNV5.setHorizontalAlignment(SwingConstants.CENTER);
        lbAddNV5.setForeground(Color.WHITE);
        lbAddNV5.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbAddNV5.setBackground(Color.BLACK);
        GroupLayout gl_jPanel23 = new GroupLayout(jPanel23);
        gl_jPanel23.setHorizontalGroup(
        	gl_jPanel23.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_jPanel23.createSequentialGroup()
        			.addGap(50)
        			.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_jPanel23.setVerticalGroup(
        	gl_jPanel23.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel23.createSequentialGroup()
        			.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addContainerGap())
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
        btnCreate.setText("Create Account");
        btnCreate.setMinimumSize(new Dimension(60, 30));

        txtPassword = new JTextField();
        txtPassword.setToolTipText("");
        txtPassword.setColumns(10);
        txtPassword.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

        txtEmail = new JTextField();
        txtEmail.setToolTipText("");
        txtEmail.setColumns(10);
        txtEmail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        txtEmp_ID = new JTextField();
        txtEmp_ID.setEditable(false);
        txtEmp_ID.setToolTipText("");
        txtEmp_ID.setColumns(10);
        txtEmp_ID.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        textEmpName = new JTextField();
        textEmpName.setToolTipText("");
        textEmpName.setEditable(false);
        textEmpName.setColumns(10);
        textEmpName.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        textPosition = new JTextField();
        textPosition.setToolTipText("");
        textPosition.setEditable(false);
        textPosition.setColumns(10);
        textPosition.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Position", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        scrollPane = new JScrollPane();
        
        btnPrevious = new JButton("Previous");
        
        btnNext = new JButton("Next");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addGap(94)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel23, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        							.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        							.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(textPosition, Alignment.LEADING)
        							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        									.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(txtEmp_ID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(textEmpName, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
        					.addGap(124)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(btnPrevious)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(btnNext)))))
        			.addGap(66))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addGap(45)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(textEmpName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtEmp_ID, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textPosition, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnNext)
        						.addComponent(btnPrevious))))
        			.addContainerGap(145, Short.MAX_VALUE))
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

            // Gọi stored procedure để thêm tài khoản
            try (Connection connection = JdbcUlti.getConnection();
                 CallableStatement callableStatement = connection.prepareCall("{call InsertAccount(?, ?, ?, ?, ?)}")) {

                callableStatement.setInt(1, empId);
                callableStatement.setString(2, username);
                callableStatement.setString(3, password);
                callableStatement.setString(4, email);

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
    public void getValueFromPanel(String id, String name, String position) {
    	txtEmp_ID.setText(id);
    	textEmpName.setText(name);
    	textPosition.setText(position);

    }
}
