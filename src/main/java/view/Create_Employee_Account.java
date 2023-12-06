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
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Create_Employee_Account extends JPanel {
	
    private JPanel jPanel23;
    private JLabel lbAddNV5;
    private JTextField txtUsername;
    private JButton btnCreate;
    private JTextField txtPassword;
    private JTextField txtEmail;
    private JTextField textField_empID;
    private JTextField textField_empName;
    private JTextField textField_Position;
    private JScrollPane scrollPane;
    private JButton btnPrevious;
    private JButton btnNext;
    private JTable tableEmployee;
    private JLabel lblStatusPage;
	private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
    
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
        
        textField_empID = new JTextField();
        textField_empID.setEditable(false);
        textField_empID.setToolTipText("");
        textField_empID.setColumns(10);
        textField_empID.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        textField_empName = new JTextField();
        textField_empName.setToolTipText("");
        textField_empName.setEditable(false);
        textField_empName.setColumns(10);
        textField_empName.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Name", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        textField_Position = new JTextField();
        textField_Position.setToolTipText("");
        textField_Position.setEditable(false);
        textField_Position.setColumns(10);
        textField_Position.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Position", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        
        scrollPane = new JScrollPane();
        
        btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
        
        btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});

        
        lblStatusPage = new JLabel("1/1");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(94)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jPanel23, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        							.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        							.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
        							.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(textField_Position)
        							.addGroup(groupLayout.createSequentialGroup()
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        									.addComponent(btnCreate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        									.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(textField_empName, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))))
        					.addGap(124)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(btnPrevious)
        							.addGap(137)
        							.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
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
        						.addComponent(textField_empName, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(textField_Position, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
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
        						.addComponent(btnPrevious)
        						.addComponent(lblStatusPage))))
        			.addContainerGap(105, Short.MAX_VALUE))
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
    //Next btn and Previous
    protected void btnNextActionPerformed(ActionEvent e) {
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		if (firstPage < totalPage) {
			firstPage++;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();

	}

    protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}

    // Create
    protected void btnCreateActionPerformed(ActionEvent e) {
        try {
        	 // Lấy thông tin từ các trường dữ liệu
            int empId = Integer.parseInt(textField_empID.getText());
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String email = txtEmail.getText();
            String position = textField_Position.getText();

            // Kiểm tra nếu chức vụ là "manager" thì ẩn nút "Create Account"
            // Gọi stored procedure để thêm tài khoản
            try (Connection connection = JdbcUlti.getConnection();
                 CallableStatement callableStatement = connection.prepareCall("{call InsertAccount(?, ?, ?, ?)}")) {

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
            JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo tài khoản.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void getValueFromPanel(String id, String name, String position) {
    	textField_empID.setText(id);
    	textField_empName.setText(name);
    	textField_Position.setText(position);

    }
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

}
