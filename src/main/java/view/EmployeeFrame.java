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
import entity.Employee;


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
import javax.swing.JPanel;	


public class EmployeeFrame extends javax.swing.JFrame {
	JdbcUlti cn;
	// Variables declaration - do not modify//GEN-BEGIN:variables
		private javax.swing.JPanel Horizontal_Panel;
		private javax.swing.JPanel Vertical_Panel;
		private javax.swing.JButton jButton2;
		private javax.swing.JButton jButton3;
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
		private JButton jButton1;
		private JPanel panel;
		private JLabel lblLogo_1;
		private JLabel lblNewLabel_1;
		private JTextField textField_Gender;
		private JTextField textField_birthDay;

	/**
	 * Creates new form AdminFrame
	 */
	public EmployeeFrame() {
		getContentPane().setBackground(new Color(0, 255, 255));
		initComponents();
		cn = new JdbcUlti();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/attendancems_with_prepared22/Project_Images/Logo.png")));
		setResizable(false);

		setTitle("Employee Panel");

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
		jButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton4ActionPerformed(e);
			}
		});
		jButton2 = new javax.swing.JButton();
		jButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton2ActionPerformed(e);
			}
		});
		jButton3 = new javax.swing.JButton();
		jButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton3ActionPerformed(e);
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
		Employee_ID.setBounds(65, 100, 110, 30);
		jPanel1.add(Employee_ID);
		
		textField_empID = new JLabel();
		textField_empID.setEnabled(false);
		textField_empID.setForeground(new Color(0, 0, 0));
		textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
		textField_empID.setBounds(198, 100, 180, 30);
		jPanel1.add(textField_empID);
		
		Emp_Name = new JLabel();
		Emp_Name.setText("Employee Name :");
		Emp_Name.setForeground(Color.BLACK);
		Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
		Emp_Name.setBounds(65, 155, 110, 30);
		jPanel1.add(Emp_Name);
		
		textField_empName = new JTextField();
		textField_empName.setEditable(false);
		textField_empName.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_empName.setBounds(198, 155, 180, 30);
		jPanel1.add(textField_empName);
		
		Position = new JLabel();
		Position.setText("Position :");
		Position.setForeground(Color.BLACK);
		Position.setFont(new Font("Candara", Font.BOLD, 14));
		Position.setBounds(65, 210, 110, 30);
		jPanel1.add(Position);
		
		Gender = new JLabel();
		Gender.setText("Gender :");
		Gender.setForeground(Color.BLACK);
		Gender.setFont(new Font("Candara", Font.BOLD, 14));
		Gender.setBounds(65, 320, 91, 30);
		jPanel1.add(Gender);
		
		textField_Position = new JTextField();
		textField_Position.setEditable(false);
		textField_Position.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_Position.setBounds(198, 210, 180, 30);
		jPanel1.add(textField_Position);
		
		Birthday = new JLabel();
		Birthday.setText("Birthday :");
		Birthday.setForeground(Color.BLACK);
		Birthday.setFont(new Font("Candara", Font.BOLD, 14));
		Birthday.setBounds(65, 263, 91, 30);
		jPanel1.add(Birthday);
		

		
	
		

		ImageIcon icon = new ImageIcon(EmployeeFrame.class.getResource("/create.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(110, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		// Load hình ảnh từ tệp tin
		ImageIcon icon1 = new ImageIcon(EmployeeFrame.class.getResource("/search.png"));
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);

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
		jButton4.setBounds(10, 400, 160, 40);

		jButton2.setBackground(new java.awt.Color(255, 255, 255));
		jButton2.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton2.setText("<html>Work Schedule</html>");
		jButton2.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		
		Vertical_Panel.add(jButton2);
		jButton2.setBounds(10, 240, 160, 48);

		jButton3.setBackground(new java.awt.Color(255, 255, 255));
		jButton3.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton3.setText("<html>CheckIn and CheckOut</html>");
		jButton3.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		
		Vertical_Panel.add(jButton3);
		jButton3.setBounds(10, 320, 160, 48);

		getContentPane().add(Vertical_Panel);
		Vertical_Panel.setBounds(0, 100, 200, 550);
		
		
		
		lblLogo = new JLabel("");
		ImageIcon logoIcon = new ImageIcon(EmployeeFrame.class.getResource("/EMPLOYEE.png"));
		// Resize the image to fit 128x128 while maintaining aspect ratio
		Image img2 = logoIcon.getImage().getScaledInstance(200, 139, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(img2);
		lblLogo.setIcon(logoIcon);
		lblLogo.setPreferredSize(new Dimension(200, 139));
		lblLogo.setBounds(0, 0, 200, 139);  // Adjust the bounds accordingly
		Vertical_Panel.add(lblLogo);
		
		jButton1 = new JButton("Profile");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		jButton1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		jButton1.setFont(new Font("Candara", Font.BOLD, 14));
		jButton1.setBounds(10, 160, 160, 48);
		Vertical_Panel.add(jButton1);
		
		Horizontal_Panel.setBackground(new Color(255, 255, 255));
		Horizontal_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
		Horizontal_Panel.setLayout(null);

		jLabel1.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
		jLabel1.setForeground(new Color(0, 0, 0));
		jLabel1.setText("Employee Attendance System");
		Horizontal_Panel.add(jLabel1);
		jLabel1.setBounds(271, 20, 700, 70);

		getContentPane().add(Horizontal_Panel);
		Horizontal_Panel.setBounds(0, 0, 1190, 100);
		
		lblNewLabel = new JLabel("");
		ImageIcon aptechLogoIcon = new ImageIcon(EmployeeFrame.class.getResource("/aptech_logo.png"));
		Image img21 = aptechLogoIcon.getImage().getScaledInstance(140, 62, Image.SCALE_SMOOTH);
		aptechLogoIcon = new ImageIcon(img21);
		lblNewLabel.setIcon(aptechLogoIcon);
		lblNewLabel.setBounds(10, 11, 150, 79);
		Horizontal_Panel.add(lblNewLabel);


		

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 980, 76);
		jPanel1.add(panel);
		
		lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon(EmployeeFrame.class.getResource("/aptech_logo.png")));
		lblLogo_1.setBounds(10, 0, 154, 76);
		panel.add(lblLogo_1);
		
		lblNewLabel_1 = new JLabel("Employee Information");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
		lblNewLabel_1.setBounds(233, 22, 648, 54);
		panel.add(lblNewLabel_1);
		
		textField_Gender = new JTextField();
		textField_Gender.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_Gender.setBounds(198, 320, 180, 30);
		jPanel1.add(textField_Gender);
		
		textField_birthDay = new JTextField();
		textField_birthDay.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_birthDay.setBounds(198, 267, 180, 30);
		jPanel1.add(textField_birthDay);
		setSize(new java.awt.Dimension(1206, 689));
		setLocationRelativeTo(null);
	}
	
	
	
	

	public void loadData() {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.getProfileEmp();
		textField_empID.setText(emp.getEmployee_id()+"");
		textField_empName.setText(emp.getEmployee_name());
		textField_Position.setText(emp.getPosition());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		textField_birthDay.setText(df.format(emp.getBirthday()));
		String gender = emp.getGender()?"Male":"Female";
		textField_Gender.setText(gender);
	}

	
	
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		 jDesktopPane1.removeAll();
	     jDesktopPane1.add(jPanel1);
	     jPanel1.show();
	}
	protected void jButton2ActionPerformed(ActionEvent e) {
		Work_Schedule WS = new Work_Schedule();
	    jDesktopPane1.removeAll();
	    jDesktopPane1.add(WS);
	    WS.show();
	}
	protected void jButton3ActionPerformed(ActionEvent e) {
		CheckInAndCheckOut CHECK = new CheckInAndCheckOut();
	    jDesktopPane1.removeAll();
	    jDesktopPane1.add(CHECK);
	    CHECK.show();
	}
	protected void jButton4ActionPerformed(ActionEvent e) {
		try {
	        int response = JOptionPane.showConfirmDialog(null,
	                "You have clicked Exit. \n Do you want to close the window?", "Confirm", JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE);

	        if (response == JOptionPane.YES_OPTION) {

	            LoginFrame lf = new LoginFrame();
	            lf.show();
	            dispose();
	        } else if (response == JOptionPane.NO_OPTION) {
	            // Do nothing or handle accordingly
	        } else if (response == JOptionPane.CLOSED_OPTION) {
	            // Do nothing or handle accordingly
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(rootPane, ex.toString());
	    }
	}
}

