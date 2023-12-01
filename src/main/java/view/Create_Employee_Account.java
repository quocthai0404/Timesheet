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

import entity.Employee;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Create_Employee_Account extends JPanel {
	private JTextField txtUsername;
	private JButton btnCreate;
	private JTextField txtPassword;
	private JTextField txtEmail;
	public Create_Employee_Account() {
		
		txtUsername = new JTextField();
		txtUsername.setToolTipText("");
		txtUsername.setColumns(10);
		txtUsername.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnCreate = new JButton();
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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(76)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 542, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(473, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(114)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(101, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	//Create

	protected void btnCreateActionPerformed(ActionEvent e) {
	    try {
	        // Lấy thông tin từ các trường dữ liệu
	        int accId = Integer.parseInt(txtAcc_ID.getText());
	        int empId = Integer.parseInt(txtEmp_ID.getText());
	        String username = txtUsername.getText();
	        String password = txtPassword.getText();
	        String email = txtEmail.getText();
	        String accPrivilege = txtAcc_privilege.getText();

	        // Tạo đối tượng Employee
	        Employee employee = new Employee(empId, "Default Name", "Default Position", new Date(), true);

	        // TODO: Thực hiện lưu thông tin vào cơ sở dữ liệu SQL ở đây.
	        // Sử dụng thông tin từ các trường dữ liệu (accId, empId, username, password, email, accPrivilege) 
	        // và thông tin từ đối tượng Employee (employee).

	        // In thông tin ra màn hình (bạn có thể xóa hoặc thay thế bằng hành động phù hợp)
	        System.out.println("Thông tin tài khoản đã tạo:");
	        System.out.println("Account ID: " + accId);
	        System.out.println("Employee ID: " + empId);
	        System.out.println("Username: " + username);
	        System.out.println("Password: " + password);
	        System.out.println("Email: " + email);
	        System.out.println("Account Privilege: " + accPrivilege);

	        // Làm sạch các trường dữ liệu sau khi tạo xong
	        clearFields();

	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	    }
	}

	// Phương thức để làm sạch các trường dữ liệu sau khi tạo
	private void clearFields() {
	    txtAcc_ID.setText("");
	    txtEmp_ID.setText("");
	    txtUsername.setText("");
	    txtPassword.setText("");
	    txtEmail.setText("");
	    txtAcc_privilege.setText("");
	}
}
