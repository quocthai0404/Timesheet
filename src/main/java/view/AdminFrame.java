/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Image;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import com.itextpdf.text.Image;
import attendancems_with_prepared22.NewBatchInternalFrame;
import attendancems_with_prepared22.NewTeacherInternalFrame;
import database.JdbcUlti;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.EmployeeDAO;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;	


public class AdminFrame extends javax.swing.JFrame {
	JdbcUlti cn;
	// Variables declaration - do not modify//GEN-BEGIN:variables
		private javax.swing.JPanel Horizontal_Panel;
		private javax.swing.JPanel Vertical_Panel;
		private javax.swing.JButton jButton12;
		private javax.swing.JButton jButton13;
		private javax.swing.JButton jButton14;
		private javax.swing.JButton jButton4;
		private javax.swing.JDesktopPane jDesktopPane1;
		private javax.swing.JLabel jLabel1;
		private javax.swing.JPanel jPanel1;
		private JLabel lblLogo;
		private JLabel lblNewLabel;
		private JLabel Employee_ID;
		private JLabel textField_empID;
		private JLabel Emp_Name;
		private JTextField textField_empName;
		private JLabel Position;
		private JLabel Gender;
		private JTextField textField_Position;
		private JLabel Birthday;
		private JRadioButton rdbtnNewRadioButton;
		private JRadioButton rdbtnNewRadioButton_1;
		private JScrollPane jScrollPane1;
		private JButton btnAddEmployee;
		private JButton btnUpdateEmp;

		private JButton btnPrevious;
		private JLabel lblStatusPage;
		private JButton btnNext;
		private int firstPage = 1;
		private int rowOfPage = 10;
		private Double totalPage;
		private JTable tableEmployee;
		private JButton jButtonCreate;
		private JTextField textFind;
		private JButton jButtonFind;
		private JDateChooser dateChooser;
		private JButton btnRefrest;
		private ButtonGroup G;
		private JButton btnCreateEmpAcc;
		private JButton btnNewButton;

	/**
	 * Creates new form AdminFrame
	 */
	public AdminFrame() {
		getContentPane().setBackground(new Color(0, 255, 255));
		initComponents();
		cn = new JdbcUlti();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/attendancems_with_prepared22/Project_Images/Logo.png")));
		setResizable(false);

		setTitle("Admin Panel");

		DateFormat dateFormat = new SimpleDateFormat("EEEE',' dd MMMMMM yyyy");
		// get current date with Date()
		Date date = new Date();

		Thread t = new Thread() {

			/**
			 * @override
			 */
			public void run() {
				for (;;) {
					try {
						sleep(1000);
					} catch (InterruptedException ex) {
						System.out.println(ex.toString());
					}
					SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
					Calendar cal = Calendar.getInstance();
					

				}
			}
		};
		loadData();
		t.start();
	}

	@SuppressWarnings("unchecked")
	
	private void initComponents() {

		jDesktopPane1 = new javax.swing.JDesktopPane();
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new Color(128, 255, 255));
		Vertical_Panel = new javax.swing.JPanel();
		jButton4 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton12ActionPerformed(e);
			}
		});
		jButton13 = new javax.swing.JButton();
		jButton13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton13ActionPerformed(e);
			}
		});
		jButton14 = new javax.swing.JButton();
		jButton14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton14ActionPerformed(e);
			}
		});
		Horizontal_Panel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(800, 600));
		setResizable(false);
		getContentPane().setLayout(null);

		jDesktopPane1.setMaximumSize(new java.awt.Dimension(990, 550));
		jDesktopPane1.setMinimumSize(new java.awt.Dimension(990, 550));

		jPanel1.setLayout(null);

		jDesktopPane1.add(jPanel1);
		jPanel1.setBounds(0, 0, 990, 550);
		
		Employee_ID = new JLabel();
		Employee_ID.setText("Employee ID :");
		Employee_ID.setForeground(Color.BLACK);
		Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
		Employee_ID.setBounds(65, 58, 110, 30);
		jPanel1.add(Employee_ID);
		
		textField_empID = new JLabel();
		textField_empID.setForeground(new Color(0, 0, 0));
		textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
		textField_empID.setBounds(198, 58, 180, 30);
		jPanel1.add(textField_empID);
		
		Emp_Name = new JLabel();
		Emp_Name.setText("Employee Name :");
		Emp_Name.setForeground(Color.BLACK);
		Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
		Emp_Name.setBounds(65, 99, 110, 30);
		jPanel1.add(Emp_Name);
		
		textField_empName = new JTextField();
		textField_empName.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_empName.setBounds(198, 99, 180, 30);
		jPanel1.add(textField_empName);
		
		Position = new JLabel();
		Position.setText("Position :");
		Position.setForeground(Color.BLACK);
		Position.setFont(new Font("Candara", Font.BOLD, 14));
		Position.setBounds(65, 140, 110, 30);
		jPanel1.add(Position);
		
		Gender = new JLabel();
		Gender.setText("Gender");
		Gender.setForeground(Color.BLACK);
		Gender.setFont(new Font("Candara", Font.BOLD, 14));
		Gender.setBounds(452, 99, 91, 30);
		jPanel1.add(Gender);
		
		textField_Position = new JTextField();
		textField_Position.setEditable(false);
		textField_Position.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_Position.setBounds(198, 140, 180, 30);
		jPanel1.add(textField_Position);
		
		Birthday = new JLabel();
		Birthday.setText("Birthday");
		Birthday.setForeground(Color.BLACK);
		Birthday.setFont(new Font("Candara", Font.BOLD, 14));
		Birthday.setBounds(451, 140, 91, 30);
		jPanel1.add(Birthday);
		
		rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(new Color(128, 255, 255));
		rdbtnNewRadioButton.setBounds(557, 101, 72, 23);
		jPanel1.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setBackground(new Color(128, 255, 255));
		rdbtnNewRadioButton_1.setBounds(647, 101, 90, 23);
		jPanel1.add(rdbtnNewRadioButton_1);
		
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setOpaque(false);
		jScrollPane1.setBounds(65, 308, 860, 170);
		jPanel1.add(jScrollPane1);
		
		tableEmployee = new JTable();
		tableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableEmployeeMouseClicked(e);
			}
		});
		jScrollPane1.setViewportView(tableEmployee);
		
		btnAddEmployee = new JButton();
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddEmployeeActionPerformed(e);
			}
		});
		
		btnAddEmployee.setIcon(new ImageIcon(AdminFrame.class.getResource("/add.png")));
		btnAddEmployee.setFont(new Font("Candara", Font.BOLD, 12));
		btnAddEmployee.setBorderPainted(false);
		btnAddEmployee.setBorder(null);
		btnAddEmployee.setBounds(65, 267, 110, 30);
		jPanel1.add(btnAddEmployee);
		
		btnUpdateEmp = new JButton();
		btnUpdateEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonUpdateActionPerformed(e);
			}
		});
		btnUpdateEmp.setIcon(new ImageIcon(AdminFrame.class.getResource("/update.png")));
		btnUpdateEmp.setFont(new Font("Candara", Font.BOLD, 12));
		btnUpdateEmp.setBorderPainted(false);
		btnUpdateEmp.setBorder(null);
		btnUpdateEmp.setBounds(432, 267, 110, 30);
		jPanel1.add(btnUpdateEmp);
			
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnPrevious.setBounds(65, 489, 103, 33);
		jPanel1.add(btnPrevious);
		
		lblStatusPage = new JLabel("1/3");
		lblStatusPage.setBounds(475, 499, 35, 14);
		jPanel1.add(lblStatusPage);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNext.setBounds(822, 495, 103, 33);
		jPanel1.add(btnNext);
		
		ImageIcon icon = new ImageIcon(AdminFrame.class.getResource("/create.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(110, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		btnCreateEmpAcc = new JButton();
		btnCreateEmpAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateEmpAccActionPerformed(e);
			}
		});
		
		btnCreateEmpAcc.setIcon(newIcon);
		btnCreateEmpAcc.setFont(new Font("Candara", Font.BOLD, 12));
		btnCreateEmpAcc.setBorderPainted(false);
		btnCreateEmpAcc.setBorder(null);
		btnCreateEmpAcc.setBounds(230, 267, 110, 30); // Đặt kích thước JButton tùy thuộc vào kích thước của ảnh

		jPanel1.add(btnCreateEmpAcc);
		
		textFind = new JTextField();
		textFind.setFont(new Font("Calibri", Font.BOLD, 14));
		textFind.setBounds(661, 267, 180, 30);
		jPanel1.add(textFind);
		
		// Load hình ảnh từ tệp tin
		ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
		JButton jButtonFind = new JButton();
		jButtonFind.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        jButtonFindActionPerformed(e);
		    }
		});
		jButtonFind.setIcon(newIcon1);
		jButtonFind.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonFind.setBorderPainted(false);
		jButtonFind.setBorder(null);
		jButtonFind.setBounds(868, 267, 30, 30); 

		jPanel1.add(jButtonFind);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(539, 140, 180, 30);
		jPanel1.add(dateChooser);
		
		ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
		Image refreshImg = refreshIcon.getImage();
		Image newRefreshImg = refreshImg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);

		JButton btnRefresh = new JButton();
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setIcon(newRefreshIcon);
		btnRefresh.setFont(new Font("Candara", Font.BOLD, 12));
		btnRefresh.setBorderPainted(false);
		btnRefresh.setBorder(null);
		btnRefresh.setBounds(600, 267, 30, 30); // Điều chỉnh kích thước tại đây
		jPanel1.add(btnRefresh);


		
		getContentPane().add(jDesktopPane1);
		jDesktopPane1.setBounds(200, 100, 990, 550);

		Vertical_Panel.setBackground(new Color(108, 108, 255));
		Vertical_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
		Vertical_Panel.setMaximumSize(new java.awt.Dimension(800, 100));
		Vertical_Panel.setMinimumSize(new java.awt.Dimension(800, 100));
		Vertical_Panel.setPreferredSize(new java.awt.Dimension(800, 100));
		Vertical_Panel.setLayout(null);

		jButton4.setBackground(new java.awt.Color(255, 255, 255));
		jButton4.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton4.setText("EXIT");
		jButton4.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		
		Vertical_Panel.add(jButton4);
		jButton4.setBounds(10, 404, 160, 40);

		jButton12.setBackground(new java.awt.Color(255, 255, 255));
		jButton12.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton12.setText("<html>Create Employee<br>&nbsp &nbsp &nbsp Account</html>");
		jButton12.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		
		Vertical_Panel.add(jButton12);
		jButton12.setBounds(10, 227, 160, 48);

		jButton13.setBackground(new java.awt.Color(255, 255, 255));
		jButton13.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton13.setText("<html>Employee Errors  <br> And Leave Days </html>");
		jButton13.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		
		Vertical_Panel.add(jButton13);
		jButton13.setBounds(10, 286, 160, 48);

		jButton14.setBackground(new java.awt.Color(255, 255, 255));
		jButton14.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton14.setText("<html>Review Employee<br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp Request </html>");
		jButton14.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		
		Vertical_Panel.add(jButton14);
		jButton14.setBounds(10, 345, 160, 48);

		getContentPane().add(Vertical_Panel);
		Vertical_Panel.setBounds(0, 100, 200, 550);
		
		
		
		lblLogo = new JLabel("");
		ImageIcon logoIcon = new ImageIcon(AdminFrame.class.getResource("/EMPLOYEE.png"));
		// Resize the image to fit 128x128 while maintaining aspect ratio
		Image img2 = logoIcon.getImage().getScaledInstance(200, 139, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(img2);
		lblLogo.setIcon(logoIcon);
		lblLogo.setPreferredSize(new Dimension(200, 139));
		lblLogo.setBounds(0, 0, 200, 139);  // Adjust the bounds accordingly
		Vertical_Panel.add(lblLogo);
		
		btnNewButton = new JButton("Employee Manager");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		btnNewButton.setFont(new Font("Candara", Font.BOLD, 14));
		btnNewButton.setBounds(10, 168, 160, 48);
		Vertical_Panel.add(btnNewButton);
		
		Horizontal_Panel.setBackground(new Color(255, 255, 255));
		Horizontal_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
		Horizontal_Panel.setLayout(null);

		jLabel1.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
		jLabel1.setForeground(new Color(0, 0, 0));
		jLabel1.setText("Employee Attendance System");
		Horizontal_Panel.add(jLabel1);
		jLabel1.setBounds(270, 20, 700, 70);

		getContentPane().add(Horizontal_Panel);
		Horizontal_Panel.setBounds(0, 0, 1190, 100);
		
		lblNewLabel = new JLabel("");
		ImageIcon aptechLogoIcon = new ImageIcon(AdminFrame.class.getResource("/aptech_logo.png"));
		Image img21 = aptechLogoIcon.getImage().getScaledInstance(140, 62, Image.SCALE_SMOOTH);
		aptechLogoIcon = new ImageIcon(img21);
		lblNewLabel.setIcon(aptechLogoIcon);
		lblNewLabel.setBounds(10, 11, 150, 79);
		Horizontal_Panel.add(lblNewLabel);
		G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		setSize(new java.awt.Dimension(1206, 689));
		setLocationRelativeTo(null);
	}

	
	protected void jButtonUpdateActionPerformed(ActionEvent e) {
		
	}
	
	
	
	

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
//		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		tableEmployee.setModel(model);
	}
	
	public void refreshAll() {
		textField_empID.setText("");
		textField_empName.setText("");
		textField_Position.setText("");
		dateChooser.setDate(null);
		G.clearSelection();
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
	
	protected void jButtonFindActionPerformed(ActionEvent e) {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Employee Name");
		model.addColumn("Position");
		model.addColumn("Birthday");
		model.addColumn("Gender");
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.findName(textFind.getText()).stream().forEach(emp -> {
			String gender = emp.getGender() ? "Male" : "Female";
			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
					emp.getBirthday(), gender });
		});

		
		tableEmployee.setModel(model);
	}
	
	protected void tableEmployeeMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = tableEmployee.getSelectedRow();
			textField_empID.setText(tableEmployee.getValueAt(row, 0).toString());
			textField_empName.setText(tableEmployee.getValueAt(row, 1).toString());
			textField_Position.setText(tableEmployee.getValueAt(row, 2).toString());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = df.parse(tableEmployee.getValueAt(row, 3).toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			dateChooser.setDate(date);
			


			if (tableEmployee.getValueAt(row, 4).toString().equals("Male")) {
				rdbtnNewRadioButton.setSelected(true);
			} else {
				rdbtnNewRadioButton_1.setSelected(true);
			}
			
			if(textField_Position.getText().equals("manager")) {
				btnCreateEmpAcc.setEnabled(false);
			}else {
				btnCreateEmpAcc.setEnabled(true);
			}
		}
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
		loadData();
	}
	protected void btnAddEmployeeActionPerformed(ActionEvent e) {
		if(textField_empName.getText().isEmpty()||textField_Position.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
			return;

		}

		if(textField_Position.getText().toUpperCase().equals("manager".toUpperCase())) {
			JOptionPane.showMessageDialog(null, "cannot to add manager");
			return;
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDAO empDAO = new EmployeeDAO();
		Boolean gender = rdbtnNewRadioButton.isSelected() ? true : false;
		Date date = dateChooser.getDate();
		int year = date.getYear()+1900;
		if(Calendar.getInstance().get(Calendar.YEAR)-year<18) {
			JOptionPane.showMessageDialog(null, "Employee age must be greater than 18");
			return;
		}
		empDAO.add(textField_empName.getText(), textField_Position.getText(), date, gender);
		loadData();
		refreshAll();
		
		
		
	}
	protected void btnCreateEmpAccActionPerformed(ActionEvent e) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
            String sql = "SELECT * FROM account where employee_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(textField_empID.getText()));
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "This employee already has an account");
				return;
			}else {
				Create_Employee_Account create_employee_account = new Create_Employee_Account();
				create_employee_account.getValueFromPanel(textField_empID.getText(), 
						textField_empName.getText(), textField_Position.getText());
		        jDesktopPane1.removeAll();
		        jDesktopPane1.add(create_employee_account);
		        create_employee_account.show();
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		 jDesktopPane1.removeAll();
	     jDesktopPane1.add(jPanel1);
	     jPanel1.show();
	}
	protected void jButton12ActionPerformed(ActionEvent e) {
		Create_Employee_Account create_employee_account = new Create_Employee_Account();
	    jDesktopPane1.removeAll();
	    jDesktopPane1.add(create_employee_account);
	    create_employee_account.show();
	}
	protected void jButton13ActionPerformed(ActionEvent e) {
		Review_Employee_Errors REE = new Review_Employee_Errors();
	    jDesktopPane1.removeAll();
	    jDesktopPane1.add(REE);
	    REE.show();
	}
	protected void jButton14ActionPerformed(ActionEvent e) {
		Review_Employee_Request RER = new Review_Employee_Request();
	    jDesktopPane1.removeAll();
	    jDesktopPane1.add(RER);
	    RER.show();
	}
}