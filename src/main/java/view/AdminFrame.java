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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import com.itextpdf.text.Image;
import attendancems_with_prepared22.NewBatchInternalFrame;
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
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;	


public class AdminFrame extends javax.swing.JFrame {
	JdbcUlti cn;
	// Variables declaration - do not modify//GEN-BEGIN:variables
		private javax.swing.JPanel Horizontal_Panel;
		private javax.swing.JPanel Vertical_Panel;
		private javax.swing.JButton jButton11;
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
		private JLabel textEmp_ID;
		private JLabel Emp_Name;
		private JTextField textEmp_Name;
		private JLabel Position;
		private JLabel Gender;
		private JTextField textPosition;
		private JLabel Birthday;
		private JRadioButton rdbtnMale;
		private JRadioButton rdbtnFemale;
		private JScrollPane jScrollPane1;
		private JButton jButtonInsert;
		private JButton jButtonUpdate;

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
		jButton11 = new javax.swing.JButton();
		jButton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton11ActionPerformed(e);
			}
		});
		jButton12 = new javax.swing.JButton();
		jButton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton12ActionPerformed(e);
			}
		});
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
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
		
		textEmp_ID = new JLabel();
		textEmp_ID.setForeground(new Color(0, 0, 0));
		textEmp_ID.setFont(new Font("Candara", Font.BOLD, 14));
		textEmp_ID.setBounds(198, 58, 180, 30);
		jPanel1.add(textEmp_ID);
		
		Emp_Name = new JLabel();
		Emp_Name.setText("Employee Name :");
		Emp_Name.setForeground(Color.BLACK);
		Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
		Emp_Name.setBounds(65, 99, 110, 30);
		jPanel1.add(Emp_Name);
		
		textEmp_Name = new JTextField();
		textEmp_Name.setFont(new Font("Calibri", Font.BOLD, 14));
		textEmp_Name.setBounds(198, 99, 180, 30);
		jPanel1.add(textEmp_Name);
		
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
		Gender.setBounds(451, 99, 91, 30);
		jPanel1.add(Gender);
		
		textPosition = new JTextField();
		textPosition.setFont(new Font("Calibri", Font.BOLD, 14));
		textPosition.setBounds(198, 140, 180, 30);
		jPanel1.add(textPosition);
		
		Birthday = new JLabel();
		Birthday.setText("Birthday");
		Birthday.setForeground(Color.BLACK);
		Birthday.setFont(new Font("Candara", Font.BOLD, 14));
		Birthday.setBounds(451, 140, 91, 30);
		jPanel1.add(Birthday);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(128, 255, 255));
		rdbtnMale.setBounds(566, 101, 72, 23);
		rdbtnMale.setBounds(557, 101, 47, 23);

		jPanel1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(128, 255, 255));
		rdbtnFemale.setBounds(661, 101, 90, 23);
		rdbtnFemale.setBounds(647, 101, 59, 23);
		jPanel1.add(rdbtnFemale);
		
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setOpaque(false);
		jScrollPane1.setBounds(65, 308, 860, 170);
		jPanel1.add(jScrollPane1);
		
		tableEmployee = new JTable();
		jScrollPane1.setViewportView(tableEmployee);
		
		jButtonInsert = new JButton();
		jButtonInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonInsertActionPerformed(e);
			}
		});
		jButtonInsert.setIcon(new ImageIcon(AdminFrame.class.getResource("/add.png")));
		jButtonInsert.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonInsert.setBorderPainted(false);
		jButtonInsert.setBorder(null);
		jButtonInsert.setBounds(65, 267, 110, 30);
		jPanel1.add(jButtonInsert);
		
		jButtonUpdate = new JButton();
		jButtonUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonUpdateActionPerformed(e);
			}
		});
		jButtonUpdate.setIcon(new ImageIcon(AdminFrame.class.getResource("/update.png")));
		jButtonUpdate.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonUpdate.setBorderPainted(false);
		jButtonUpdate.setBorder(null);
		jButtonUpdate.setBounds(432, 267, 110, 30);
		jPanel1.add(jButtonUpdate);
			
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

		JButton jButtonCreate = new JButton();
		jButtonCreate.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        jButtonCreateActionPerformed(e);
		    }
		});
		jButtonCreate.setIcon(newIcon);  // Sử dụng newIcon thay vì icon
		jButtonCreate.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonCreate.setBorderPainted(false);
		jButtonCreate.setBorder(null);
		jButtonCreate.setBounds(230, 267, 110, 30);

		// Thêm JButton vào jPanel1 hoặc container tương ứng
		jPanel1.add(jButtonCreate);

		
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
		dateChooser.setBounds(564, 140, 180, 30);
		jPanel1.add(dateChooser);
		
		ImageIcon icon12 = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
		Image img12 = icon12.getImage();
		Image newImg12 = img12.getScaledInstance(58, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon12 = new ImageIcon(newImg12);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(newIcon12);
		btnNewButton.setBounds(594, 267, 58, 30);
		jPanel1.add(btnNewButton);


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
		jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton4);
		jButton4.setBounds(10, 404, 160, 40);

		jButton11.setBackground(new java.awt.Color(255, 255, 255));
		jButton11.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton11.setText("Employee Management");
		jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton11);
		jButton11.setBounds(10, 168, 160, 48);

		jButton12.setBackground(new java.awt.Color(255, 255, 255));
		jButton12.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton12.setText("<html>Create Employee<br>&nbsp &nbsp &nbsp Account</html>");
		jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton12);
		jButton12.setBounds(10, 227, 160, 48);

		jButton13.setBackground(new java.awt.Color(255, 255, 255));
		jButton13.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton13.setText("<html>Employee Errors  <br> And Leave Days </html>");
		jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		
		Vertical_Panel.add(jButton13);
		jButton13.setBounds(10, 286, 160, 48);

		jButton14.setBackground(new java.awt.Color(255, 255, 255));
		jButton14.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton14.setText("<html>Review Employee<br>&nbsp &nbsp &nbsp&nbsp&nbsp&nbsp&nbsp Request </html>");
		jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton14);
		jButton14.setBounds(10, 345, 160, 48);

		getContentPane().add(Vertical_Panel);
		Vertical_Panel.setBounds(0, 100, 200, 550);
		
		
		
		lblLogo = new JLabel("");
		ImageIcon logoIcon = new ImageIcon(AdminFrame.class.getResource("/EMPLOYEE.png"));
		// Resize the image to fit 128x128 while maintaining aspect ratio
		Image img2 = logoIcon.getImage().getScaledInstance(160, 128, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(img2);
		lblLogo.setIcon(logoIcon);
		lblLogo.setPreferredSize(new Dimension(160, 128));
		lblLogo.setBounds(10, 27, 160, 128);  // Adjust the bounds accordingly
		Vertical_Panel.add(lblLogo);
		
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
		
		setSize(new java.awt.Dimension(1206, 689));
		setLocationRelativeTo(null);
	}

	protected void jButtonInsertActionPerformed(ActionEvent e) {
		
	}
	protected void jButtonUpdateActionPerformed(ActionEvent e) {
		
<<<<<<< HEAD
	}	
=======
	}

<<<<<<< HEAD
=======
	protected void jButtonClearActionPerformed(ActionEvent e) {
		
	}
	protected void jButtonViewAllActionPerformed(ActionEvent e) {
	}		
>>>>>>> 0d733b622f871e8c0bdfe56d192bd3fbc724e754
	protected void jButton12ActionPerformed(ActionEvent e) {
		Create_Employee_Account create_employee_account = new Create_Employee_Account();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(create_employee_account);
        create_employee_account.show();
	}
	
	protected void jButton11ActionPerformed(ActionEvent e) {
		 jDesktopPane1.removeAll();
	     jDesktopPane1.add(jPanel1);
	     jPanel1.show();
	}
	

>>>>>>> 346469d3490cf76952364c49d030284f030d59a3
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
	protected void jButtonCreateActionPerformed(ActionEvent e) {
		
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
<<<<<<< HEAD

=======
>>>>>>> 0d733b622f871e8c0bdfe56d192bd3fbc724e754
	}
	protected void jButton12ActionPerformed(ActionEvent e) {
		Create_Employee_Account create_employee_account = new Create_Employee_Account();
        jDesktopPane1.removeAll();
        jDesktopPane1.add(create_employee_account);
        create_employee_account.show();
	}
	protected void jButton11ActionPerformed(ActionEvent e) {
		 jDesktopPane1.removeAll();
	     jDesktopPane1.add(jPanel1);
	     jPanel1.show();
	}
}
