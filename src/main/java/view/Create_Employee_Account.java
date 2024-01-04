package view;

import java.awt.Color;	
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.EmployeeDAO;
import database.JdbcUlti;
import helper.Helper;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.awt.event.ActionEvent;


public class Create_Employee_Account extends javax.swing.JInternalFrame {
	JdbcUlti cn;
	private LayoutManager groupLayout;
	public Create_Employee_Account() {
		getContentPane().setBackground(new Color(128, 255, 255));
		getContentPane().setForeground(new Color(128, 255, 255));
		initComponents();
		cn = new JdbcUlti();
		setTitle("Create Employee Account");
		statusCombo();
		

	}
	
	

	public void statusCombo() {
	}

	@SuppressWarnings("unchecked")
	
	private void initComponents() {

		Employee_ID = new javax.swing.JLabel();
		Emp_Name = new javax.swing.JLabel();
		Position = new javax.swing.JLabel();
		Username = new javax.swing.JLabel();
		textField_empID = new javax.swing.JLabel();
		textField_empName = new javax.swing.JTextField();

		setMaximumSize(new java.awt.Dimension(990, 550));
		setMinimumSize(new java.awt.Dimension(990, 550));
		setPreferredSize(new java.awt.Dimension(990, 550));
		getContentPane().setLayout(null);

		Employee_ID.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		Employee_ID.setForeground(new Color(0, 0, 0));
		Employee_ID.setText("Employee ID :");
		getContentPane().add(Employee_ID);
		Employee_ID.setBounds(80, 128, 110, 30);

		Emp_Name.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		Emp_Name.setForeground(new Color(0, 0, 0));
		Emp_Name.setText("Employee Name :");
		getContentPane().add(Emp_Name);
		Emp_Name.setBounds(495, 169, 110, 30);

		Position.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		Position.setForeground(new Color(0, 0, 0));
		Position.setText("Position :");
		getContentPane().add(Position);
		Position.setBounds(495, 210, 110, 30);

		Username.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		Username.setForeground(new Color(0, 0, 0));
		Username.setText("Username :");
		getContentPane().add(Username);
		Username.setBounds(80, 169, 109, 30);

		textField_empID.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		textField_empID.setForeground(new java.awt.Color(255, 255, 255));
		getContentPane().add(textField_empID);
		textField_empID.setBounds(221, 128, 180, 30);

		textField_empName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
	
		getContentPane().add(textField_empName);
		textField_empName.setBounds(635, 169, 180, 30);
		
		txtEmployee = new JTextField();
		txtEmployee.setText("employee");
		txtEmployee.setEditable(false);
		txtEmployee.setFont(new Font("Calibri", Font.BOLD, 14));
		txtEmployee.setBounds(635, 210, 180, 30);
		getContentPane().add(txtEmployee);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Calibri", Font.BOLD, 14));
		txtUsername.setBounds(221, 169, 180, 30);
		getContentPane().add(txtUsername);
		
		Email = new JLabel();
		Email.setText("Email");
		Email.setForeground(Color.BLACK);
		Email.setFont(new Font("Candara", Font.BOLD, 14));
		Email.setBounds(80, 210, 109, 30);
		getContentPane().add(Email);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		txtEmail.setBounds(221, 210, 180, 30);
		getContentPane().add(txtEmail);
		
		btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateActionPerformed(e);
			}
		});
		

		btnCreate.setIcon(new ImageIcon(Create_Employee_Account.class.getResource("/add.png")));
		ImageIcon originalIcon = (ImageIcon) btnCreate.getIcon();
		Image img = originalIcon.getImage().getScaledInstance(124, 30, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(img);
		btnCreate.setIcon(resizedIcon);
		btnCreate.setPreferredSize(new Dimension(124, 30));
		btnCreate.setBounds(80, 264, 90, 30);
		getContentPane().add(btnCreate);

		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 974, 76);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Create_Employee_Account.class.getResource("/aptech_logo.png")));
		lblNewLabel.setBounds(10, 0, 154, 76);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Create Employee Account");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
		lblNewLabel_1.setBounds(271, 22, 560, 54);

		panel.add(lblNewLabel_1);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnPrevious.setBounds(785, 304, 103, 33);
		getContentPane().add(btnPrevious);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNext.setBounds(785, 453, 103, 33);
		getContentPane().add(btnNext);
		
		lblStatusPage = new JLabel("1/0");
		lblStatusPage.setBounds(785, 386, 35, 14);
		getContentPane().add(lblStatusPage);
		
		scrollPane = new JScrollPane();
		scrollPane.setForeground(Color.WHITE);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(80, 304, 681, 182);
		getContentPane().add(scrollPane);
		
		tableEmployee = new JTable();
		tableEmployee.setRowHeight(30);
		tableEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableEmployeeMouseClicked(e);
            }
        });	

        scrollPane.setViewportView(tableEmployee);

        getContentPane().setLayout(groupLayout);
        loadData();
		scrollPane.setViewportView(tableEmployee);;

		setBounds(0, 0, 990, 550);
	}

	private javax.swing.JLabel Employee_ID;
	private javax.swing.JLabel textField_empID;
	private javax.swing.JLabel Emp_Name;
	private javax.swing.JLabel Position;
	private javax.swing.JLabel Username;
	private javax.swing.JTextField textField_empName;
	private JTextField txtEmployee;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel Email;
	private JTextField txtEmail;
	private JButton btnCreate;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnPrevious;
	private JButton btnNext;
	private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
	private JLabel lblStatusPage;
	private JScrollPane scrollPane;
	private JTable tableEmployee;
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
	 protected void btnNextActionPerformed(ActionEvent e) {
			EmployeeDAO dao = new EmployeeDAO();
			totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
			if (firstPage < totalPage) {
				firstPage++;
			}

			lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
			loadData();

		}
	 public void getValueFromPanel(String id, String name, String position) {
	            textField_empID.setText(id);
	            textField_empName.setText(name);
	            txtEmployee.setText(position);
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
	            txtEmployee.setText(positionValue);

	            // Các thao tác khác có thể được thêm tùy thuộc vào yêu cầu cụ thể của bạn
	        }
	    }
	   public Boolean checkAccID(int textField_empID) {
		   Connection con = null;
			try {
				con = JdbcUlti.getConnection();
	            String sql = "SELECT * FROM account where employee_id = ?";
	            PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, textField_empID);
				ResultSet rs = statement.executeQuery();
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "This employee already has an account");
					return false;
				}
				JdbcUlti.closeConnection(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return true;
	   }
	   public Boolean checkUsernameDuplicate(String username) {
		   Connection con = null;
			try {
				con = JdbcUlti.getConnection();
	            String sql = "SELECT * FROM account where username = ?";
	            PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, username);
				ResultSet rs = statement.executeQuery();
				if(rs.next()) {
					return false;
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				JdbcUlti.closeConnection(con);
			}
			return true;
	   }
	   public Boolean checkEmailDuplicate(String email) {
		   Connection con = null;
			try {
				con = JdbcUlti.getConnection();
	            String sql = "SELECT * FROM account where email = ?";
	            PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, email);
				ResultSet rs = statement.executeQuery();
				if(rs.next()) {
					return false;
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				JdbcUlti.closeConnection(con);
			}
			return true;
	   }
	   public void SignUp(String username, String password, String email, int id) {
			Connection con = null;
			try {
			    con = JdbcUlti.getConnection();
			    String sql = "insert into account(employee_id, username, password, email)\r\n"
			    		+ "values (?, ?, ?, ?)";
			    PreparedStatement st = con.prepareStatement(sql);
			    MessageDigest md5 = MessageDigest.getInstance("MD5");
			    byte[] bytes = md5.digest(password.getBytes());
			    String md5_password = new String(Base64.getEncoder().encode(bytes));
			    st.setInt(1, id);
			    st.setString(2, username);
			    st.setString(3, md5_password);
			    st.setString(4, email);
			    int rowsUpdated = st.executeUpdate();
				if (rowsUpdated > 0) {
				    JOptionPane.showMessageDialog(null, "A new account was inserted successfully!");
				}
				
				JdbcUlti.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	   public void refresh() {
		   textField_empID.setText("");
		   txtUsername.setText("");
		   jPasswordField1.setText("");
		   txtEmail.setText("");
		   textField_empName.setText("");
		   txtEmployee.setText("");
	   }
	protected void btnCreateActionPerformed(ActionEvent e) {
		int id = Integer.parseInt(textField_empID.getText());
		if(checkAccID(id)) {
			if(checkEmailDuplicate(txtEmail.getText())&&checkUsernameDuplicate(txtUsername.getText())){
				SignUp(txtUsername.getText(), 
						String.valueOf(jPasswordField1.getPassword()), txtEmail.getText(), id);
				sendMail(String.valueOf(jPasswordField1.getPassword()),txtUsername.getText());
				refresh();
			}else {
				JOptionPane.showMessageDialog(null, "Username or Email already exists");
				refresh();
				return;
			}
		}else {
			refresh();
			return;
		}
		
		

	}
	public void sendMail(String pass,String username) {
		final String fromEmail = "employeemanager25@gmail.com";
		final String password = "pvhq uixx stql luqj";
		
		
		
		var prop = new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com" );
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable","true" );
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		//khoi tao 1 giao dich section
		Session session = Session.getInstance(prop,new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(fromEmail, password);
			}
		});
		try {
			Message mes = new MimeMessage(session);
			mes.setFrom(new InternetAddress(fromEmail));
			mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(txtEmail.getText()));
			mes.setSubject("Dear: "+ username);
//			mes.setText("abc....");
			String html = "<div>\r\n"
					
					+ "        <h2>Hi "+username+"</h2>\r\n"
					+ "        <p>This is your password to log into the system: <strong>"+ pass+"</strong></p>\r\n"
					+ "    \r\n"
					+ "    </div>";
			mes.setContent(html,"text/html; charset = UTF-8");
			Transport.send(mes);
			JOptionPane.showMessageDialog(null, "send successfully");
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Have error in sending mail process");
			e2.printStackTrace();
		}
	}
}