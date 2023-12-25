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
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;	


/**
 *
 * @author Iqbal-Asi
 */
public class AdminFrame extends javax.swing.JFrame {
	ConnectClass c;
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
		private javax.swing.JLabel jLabel5;
		private javax.swing.JLabel jLabeltime;
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
		private JDateChooser jDateChooser1;
		private JRadioButton rdbtnMale;
		private JRadioButton rdbtnFemale;
		private JScrollPane jScrollPane1;
		private JButton jButtonInsert;
		private JButton jButtonDelete;
		private JButton jButtonUpdate;
		private JButton jButtonClear;
		private JButton jButtonViewAll;
	/**
	 * Creates new form AdminFrame
	 */
	public AdminFrame() {
		getContentPane().setBackground(new Color(0, 255, 255));
		initComponents();
		c = new ConnectClass();

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
					jLabeltime.setText(time.format(cal.getTime()));

				}
			}
		};

		t.start();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jDesktopPane1 = new javax.swing.JDesktopPane();
		jPanel1 = new javax.swing.JPanel();
		jPanel1.setBackground(new Color(128, 255, 255));
		Vertical_Panel = new javax.swing.JPanel();
		jButton4 = new javax.swing.JButton();
		jButton11 = new javax.swing.JButton();
		jButton12 = new javax.swing.JButton();
		jButton13 = new javax.swing.JButton();
		jButton14 = new javax.swing.JButton();
		Horizontal_Panel = new javax.swing.JPanel();
		jLabeltime = new javax.swing.JLabel();
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
		textEmp_ID.setForeground(Color.WHITE);
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
		Gender.setBounds(452, 99, 91, 30);
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
		
		jDateChooser1 = new JDateChooser();
		jDateChooser1.setBounds(557, 140, 180, 30);
		jPanel1.add(jDateChooser1);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(128, 255, 255));
		rdbtnMale.setBounds(557, 101, 47, 23);
		jPanel1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(128, 255, 255));
		rdbtnFemale.setBounds(647, 101, 59, 23);
		jPanel1.add(rdbtnFemale);
		
		jScrollPane1 = new JScrollPane();
		jScrollPane1.setOpaque(false);
		jScrollPane1.setBounds(65, 347, 860, 170);
		jPanel1.add(jScrollPane1);
		
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
		jButtonInsert.setBounds(65, 306, 110, 30);
		jPanel1.add(jButtonInsert);
		
		jButtonDelete = new JButton();
		jButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonDeleteActionPerformed(e);
			}
		});
		jButtonDelete.setIcon(new ImageIcon(AdminFrame.class.getResource("/remove.png")));
		jButtonDelete.setBorderPainted(false);
		jButtonDelete.setBorder(null);
		jButtonDelete.setBounds(258, 306, 100, 30);
		jPanel1.add(jButtonDelete);
		
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
		jButtonUpdate.setBounds(439, 306, 110, 30);
		jPanel1.add(jButtonUpdate);
		
		jButtonClear = new JButton();
		jButtonClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonClearActionPerformed(e);
			}
		});
		jButtonClear.setIcon(new ImageIcon(AdminFrame.class.getResource("/clear.png")));
		jButtonClear.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonClear.setBorderPainted(false);
		jButtonClear.setBorder(null);
		jButtonClear.setBounds(615, 306, 110, 30);
		jPanel1.add(jButtonClear);
		
		jButtonViewAll = new JButton();
		jButtonViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonViewAllActionPerformed(e);
			}
		});
		jButtonViewAll.setIcon(new ImageIcon(AdminFrame.class.getResource("/viewAll.png")));
		jButtonViewAll.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonViewAll.setBorderPainted(false);
		jButtonViewAll.setBorder(null);
		jButtonViewAll.setBounds(815, 306, 110, 30);
		jPanel1.add(jButtonViewAll);

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
		jButton4.setBounds(10, 380, 160, 40);

		jButton11.setBackground(new java.awt.Color(255, 255, 255));
		jButton11.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton11.setText("Employee Management");
		jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton11);
		jButton11.setBounds(10, 160, 160, 48);

		jButton12.setBackground(new java.awt.Color(255, 255, 255));
		jButton12.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton12.setText("<html>Create Employee<br>&nbsp &nbsp &nbsp Account</html>");
		jButton12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton12);
		jButton12.setBounds(10, 219, 160, 48);

		jButton13.setBackground(new java.awt.Color(255, 255, 255));
		jButton13.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton13.setText("<html>Manage Employee <br>&nbsp Work Schedule</html>");
		jButton13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		
		Vertical_Panel.add(jButton13);
		jButton13.setBounds(10, 278, 160, 40);

		jButton14.setBackground(new java.awt.Color(255, 255, 255));
		jButton14.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jButton14.setText("<html>Review Leave Requests </html>");
		jButton14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
		
		Vertical_Panel.add(jButton14);
		jButton14.setBounds(10, 329, 160, 40);

		getContentPane().add(Vertical_Panel);
		Vertical_Panel.setBounds(0, 100, 200, 550);
		
		
		
		lblLogo = new JLabel("");
		ImageIcon logoIcon = new ImageIcon(AdminFrame.class.getResource("/EMPLOYEE.png"));
		// Resize the image to fit 128x128 while maintaining aspect ratio
		Image img = logoIcon.getImage().getScaledInstance(160, 128, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(img);
		lblLogo.setIcon(logoIcon);
		lblLogo.setPreferredSize(new Dimension(160, 128));
		lblLogo.setBounds(10, 27, 160, 128);  // Adjust the bounds accordingly
		Vertical_Panel.add(lblLogo);
		
		Horizontal_Panel.setBackground(new Color(108, 108, 255));
		Horizontal_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
		Horizontal_Panel.setLayout(null);

		jLabeltime.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		jLabeltime.setForeground(new java.awt.Color(255, 255, 255));
		Horizontal_Panel.add(jLabeltime);
		jLabeltime.setBounds(1080, 40, 110, 30);

		jLabel1.setFont(new java.awt.Font("Candara", 1, 48)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("Employee Attendance System");
		Horizontal_Panel.add(jLabel1);
		jLabel1.setBounds(270, 20, 700, 70);

		getContentPane().add(Horizontal_Panel);
		Horizontal_Panel.setBounds(0, 0, 1190, 100);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setBounds(170, 20, 90, 30);
		Horizontal_Panel.add(jLabel5);

		jLabel5.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("Admin Panel");
		jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		
		lblNewLabel = new JLabel("");
		ImageIcon aptechLogoIcon = new ImageIcon(AdminFrame.class.getResource("/aptech_logo.png"));
		Image img2 = aptechLogoIcon.getImage().getScaledInstance(140, 62, Image.SCALE_SMOOTH);
		aptechLogoIcon = new ImageIcon(img2);
		lblNewLabel.setIcon(aptechLogoIcon);
		lblNewLabel.setBounds(20, 11, 140, 62);
		Horizontal_Panel.add(lblNewLabel);
		
		setSize(new java.awt.Dimension(1206, 689));
		setLocationRelativeTo(null);
	}

	
	protected void jButtonInsertActionPerformed(ActionEvent e) {
		
	}
	protected void jButtonDeleteActionPerformed(ActionEvent e) {
		
	}
	protected void jButtonUpdateActionPerformed(ActionEvent e) {
		
	}
	protected void jButtonClearActionPerformed(ActionEvent e) {
		
	}
	protected void jButtonViewAllActionPerformed(ActionEvent e) {
		
	}
}
