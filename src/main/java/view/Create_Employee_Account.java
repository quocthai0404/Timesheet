package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import com.toedter.calendar.JDateChooser;

import DAO.EmployeeDAO;
import database.JdbcUlti;

import entity.Employee;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Create_Employee_Account extends JPanel {
	
    private JScrollPane scrollPane;
    private JButton btnPrevious;
    private JTable tableEmployee;
    private JLabel lblStatusPage;
	private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
	private JButton btnNext;
	private JPanel jPanel23;
	private JLabel lbAddNV5;
	private JPanel panel;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtEmail;
	private JButton btnCreate;
	private JTextField textField_empID;
	private JTextField textField_Position;
	private JTextField textField_empName;
    
    public Create_Employee_Account() {
    
        
        scrollPane = new JScrollPane();
        scrollPane.setForeground(new Color(255, 255, 255));
        scrollPane.setBackground(new Color(255, 255, 255));
        
        btnPrevious = new JButton("Previous");
        btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPrevious.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnPreviousActionPerformed(e);
            }
        });

        
        lblStatusPage = new JLabel("1/1");
        
        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
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
        	gl_jPanel23.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 919, Short.MAX_VALUE)
        		.addGroup(gl_jPanel23.createSequentialGroup()
        			.addGap(50)
        			.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_jPanel23.setVerticalGroup(
        	gl_jPanel23.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 52, Short.MAX_VALUE)
        		.addGroup(gl_jPanel23.createSequentialGroup()
        			.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel23.setLayout(gl_jPanel23);
        
        panel = new JPanel();
        panel.setBackground(new Color(255, 128, 128));
        
        txtUsername = new JTextField();
        txtUsername.setToolTipText("");
        txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txtUsername.setColumns(10);
        txtUsername.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        txtPassword = new JTextField();
        txtPassword.setToolTipText("");
        txtPassword.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txtPassword.setColumns(10);
        txtPassword.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        txtEmail = new JTextField();
        txtEmail.setToolTipText("");
        txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        txtEmail.setColumns(10);
        txtEmail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        btnCreate = new JButton("Create");
        btnCreate.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnCreateActionPerformed(e);
            }
        });
        textField_empID = new JTextField();
        textField_empID.setToolTipText("");
        textField_empID.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        textField_empID.setEditable(false);
        textField_empID.setColumns(10);
        textField_empID.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        textField_Position = new JTextField();
        textField_Position.setToolTipText("");
        textField_Position.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        textField_Position.setEditable(false);
        textField_Position.setColumns(10);
        textField_Position.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Position", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        textField_empName = new JTextField();
        textField_empName.setToolTipText("");
        textField_empName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        textField_empName.setEditable(false);
        textField_empName.setColumns(10);
        textField_empName.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 351, Short.MAX_VALUE)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(txtUsername)
        					.addComponent(textField_empID)
        					.addGroup(gl_panel.createSequentialGroup()
        						.addComponent(textField_Position, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        						.addGap(18)
        						.addComponent(textField_empName, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
        					.addComponent(txtPassword)
        					.addComponent(txtEmail))
        				.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(12, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 327, Short.MAX_VALUE)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField_Position, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        				.addComponent(textField_empName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(27, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(96)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 919, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(btnPrevious)
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        							.addGap(117)
        							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
        						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE))))
        			.addGap(66))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addGap(34)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(7)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblStatusPage)
        						.addComponent(btnPrevious, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        					.addGap(191))))
        );
        
        tableEmployee = new JTable();
        tableEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableEmployeeMouseClicked(e);
            }
        });	

        scrollPane.setViewportView(tableEmployee);

        setLayout(groupLayout);
        loadData();
    }
    
    //loadData
    public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Employee Name");
		model.addColumn("Position");
		model.addColumn("Birthday");
		model.addColumn("Gender");
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.selectPaginateEmp(firstPage, rowOfPage).stream().forEach(emp -> {
			String gender = emp.getGender() ? "Male" : "Female";
			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
					emp.getBirthday(), gender });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		tableEmployee.setModel(model);
	}

    protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}


    public boolean isUsernameExist(String username) {
        Connection con = null;

        try {
            con = JdbcUlti.getConnection();
            String sql = "SELECT COUNT(*) FROM account WHERE username = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUlti.closeConnection(con);
        }

        return false;
    }
    //Check Username and Email Exist
    public boolean isEmailExist(String email) {
        Connection con = null;

        try {
            con = JdbcUlti.getConnection();
            String sql = "SELECT COUNT(*) FROM account WHERE email = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUlti.closeConnection(con);
        }

        return false;
    }

    public void insertAccount(int employeeId, String username, String password, String email) {
        try {
            // Kiểm tra xem username hoặc email đã tồn tại hay chưa
            boolean isUsernameExist = isUsernameExist(username);
            boolean isEmailExist = isEmailExist(email);

            if (isUsernameExist || isEmailExist) {
                System.out.println("Username or email already exists in the system.");
                return;
            }

            Connection con = JdbcUlti.getConnection();
            String sql = "INSERT INTO account (employee_id, username, password, email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, employeeId);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.executeUpdate();

            System.out.println("Account has been added to the database.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getValueFromPanel(String id, String name, String position) {
        if (isComponentInVisiblePanel(this)) {
            textField_empID.setText(id);
            textField_empName.setText(name);
            textField_Position.setText(position);
        }
    }

    protected void btnCreateActionPerformed(ActionEvent e) {
        try {
            // Lấy thông tin từ các trường dữ liệu
            int empId = Integer.parseInt(textField_empID.getText());
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String email = txtEmail.getText();

            // Kiểm tra xem người dùng đã nhập đủ thông tin chưa
            String errorMessage = "";
            if (username.isEmpty()) {
                errorMessage += "Please enter a username.\n";
            }
            if (password.isEmpty()) {
                errorMessage += "Please enter a password.\n";
            }
            if (email.isEmpty()) {
                errorMessage += "Please enter an email.\n";
            }

            // Nếu có thông báo lỗi, hiển thị và dừng lại
            if (!errorMessage.isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra xem username đã tồn tại trong cơ sở dữ liệu chưa
            if (isUsernameExist(username)) {
                JOptionPane.showMessageDialog(null, "Username already exists. Please choose another username.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Kiểm tra xem email đã tồn tại trong cơ sở dữ liệu chưa
            if (isEmailExist(email)) {
                JOptionPane.showMessageDialog(null, "Email already exists. Please select another email.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tiếp tục thực hiện thêm vào cơ sở dữ liệu
            insertAccount(empId, username, password, email);

            // Reload data after creating an account
            loadData();

            JOptionPane.showMessageDialog(null, "Account created successfully.", "Notification", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error creating account.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Existing methods...

    // Method to handle table row click
    private void tableEmployeeMouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            int row = tableEmployee.getSelectedRow();

            // Lấy giá trị từ cột "Position" của dòng được chọn
            String positionValue = tableEmployee.getValueAt(row, 2).toString();

            // Kiểm tra nếu chức vụ là "manager" thì ẩn nút "Create"
            if ("manager".equalsIgnoreCase(positionValue)) {
                btnCreate.setEnabled(false);
            } else {
                btnCreate.setEnabled(true);
            }

            // Set các giá trị khác từ bảng vào các trường dữ liệu khác
            textField_empID.setText(tableEmployee.getValueAt(row, 0).toString());
            textField_empName.setText(tableEmployee.getValueAt(row, 1).toString());
            textField_Position.setText(positionValue);

            // Các thao tác khác có thể được thêm tùy thuộc vào yêu cầu cụ thể của bạn
        }
    }
    private boolean isComponentInVisiblePanel(Component component) {
        Container parent = component.getParent();
        while (parent != null) {
            if (parent instanceof JTabbedPane) {
                JTabbedPane tabbedPane = (JTabbedPane) parent;
                return tabbedPane.getSelectedComponent() == component;
            }
            parent = parent.getParent();
        }
        return true; // Nếu không nằm trong một tabbedPane, coi như visible
    }
    private void updateCreateButtonStatus(String position) {
        // Kiểm tra nếu chức vụ là "manager" thì ẩn nút "Create"
        if ("manager".equalsIgnoreCase(position)) {
            btnCreate.setEnabled(false);
        } else {
            btnCreate.setEnabled(true);
        }
    }
    
}