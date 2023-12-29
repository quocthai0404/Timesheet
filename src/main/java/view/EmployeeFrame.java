/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import attendancems_with_prepared22.ClassJInternalFrame;
import attendancems_with_prepared22.SettingInternalFrame;
import attendancems_with_prepared22.TeacherInternalFrame;
import database.JdbcUlti;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

/**
 *
 * @author Iqbal-Asi
 */
public class EmployeeFrame extends javax.swing.JFrame {

	JdbcUlti cn;

	/**
	 * Creates new form EmployeeFrame
	 */
	public EmployeeFrame() {
		initComponents();
		cn = new JdbcUlti();

		// Logo
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/attendancems_with_prepared22/Project_Images/Logo.png")));
		// Disabling size
		setResizable(false);

		// Title
		setTitle("Employee Panel");
		jDesktopPane1.removeAll();
	}

	
	@SuppressWarnings("unchecked")
	
	private void initComponents() {

		jDesktopPane1 = new javax.swing.JDesktopPane() {

			public void paintComponent(Graphics g) {
				ImageIcon icon = new ImageIcon(
						(getClass().getResource("/attendancems_with_prepared22/Project_Images/FrameBG.png")));
				Image image = icon.getImage();
				g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
			}
		};
		jDesktopPane1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jDesktopPane1.setBounds(200, 101, 800, 449);
		jPanel2 = new javax.swing.JPanel();
		jPanel2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		jPanel2.setBounds(0, 101, 200, 449);
		jPanel2.setBackground(new Color(108, 108, 255));
		jButton3 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jDesktopPane1.setBackground(new Color(128, 255, 255));
		jDesktopPane1.setMaximumSize(new java.awt.Dimension(800, 540));
		jDesktopPane1.setMinimumSize(new java.awt.Dimension(800, 540));
		jDesktopPane1.setPreferredSize(new java.awt.Dimension(800, 550));

		getContentPane().add(jDesktopPane1);
		
		Employee_ID = new JLabel();
		Employee_ID.setText("Employee ID :");
		Employee_ID.setForeground(Color.BLACK);
		Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
		Employee_ID.setBounds(122, 83, 110, 30);
		jDesktopPane1.add(Employee_ID);
		
		textEmp_ID = new JLabel();
		textEmp_ID.setForeground(Color.BLACK);
		textEmp_ID.setFont(new Font("Candara", Font.BOLD, 14));
		textEmp_ID.setBounds(247, 83, 180, 30);
		jDesktopPane1.add(textEmp_ID);
		
		Emp_Name = new JLabel();
		Emp_Name.setText("Employee Name :");
		Emp_Name.setForeground(Color.BLACK);
		Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
		Emp_Name.setBounds(122, 123, 110, 30);
		jDesktopPane1.add(Emp_Name);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.BOLD, 14));
		textField.setBounds(247, 123, 180, 30);
		jDesktopPane1.add(textField);
		
		Position = new JLabel();
		Position.setText("Position :");
		Position.setForeground(Color.BLACK);
		Position.setFont(new Font("Candara", Font.BOLD, 14));
		Position.setBounds(122, 163, 110, 30);
		jDesktopPane1.add(Position);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_1.setBounds(247, 163, 180, 30);
		jDesktopPane1.add(textField_1);
		
		lblBirthday = new JLabel();
		lblBirthday.setText("Birthday :");
		lblBirthday.setForeground(Color.BLACK);
		lblBirthday.setFont(new Font("Candara", Font.BOLD, 14));
		lblBirthday.setBounds(122, 203, 91, 30);
		jDesktopPane1.add(lblBirthday);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(247, 203, 180, 30);
		jDesktopPane1.add(dateChooser);
		
		lblGender = new JLabel();
		lblGender.setText("Gender :");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Candara", Font.BOLD, 14));
		lblGender.setBounds(122, 243, 91, 30);
		jDesktopPane1.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnMale.setBackground(new Color(128, 255, 255));
		rdbtnMale.setBounds(247, 244, 91, 23);
		jDesktopPane1.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFemale.setBackground(new Color(128, 255, 255));
		rdbtnFemale.setBounds(340, 244, 91, 23);
		jDesktopPane1.add(rdbtnFemale);
		
		lblLeaveDays = new JLabel();
		lblLeaveDays.setText("Leave Days :");
		lblLeaveDays.setForeground(Color.BLACK);
		lblLeaveDays.setFont(new Font("Candara", Font.BOLD, 14));
		lblLeaveDays.setBounds(122, 278, 91, 30);
		jDesktopPane1.add(lblLeaveDays);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Calibri", Font.BOLD, 14));
		textField_2.setBounds(247, 273, 180, 30);
		jDesktopPane1.add(textField_2);

		jPanel2.setMaximumSize(new java.awt.Dimension(190, 550));
		jPanel2.setMinimumSize(new java.awt.Dimension(190, 550));
		jPanel2.setPreferredSize(new java.awt.Dimension(190, 550));
		jPanel2.setLayout(null);

		jButton3.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
		jButton3.setIcon(new ImageIcon(EmployeeFrame.class.getResource("/report.png"))); // NOI18N
		jButton3.setText("Report");
		jButton3.setBorderPainted(false);
		jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton3.setOpaque(false);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});
		jPanel2.add(jButton3);
		jButton3.setBounds(20, 136, 160, 50);

		jButton6.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
		jButton6.setIcon(new ImageIcon(EmployeeFrame.class.getResource("/Setting.png"))); // NOI18N
		jButton6.setText("Setting");
		jButton6.setBorderPainted(false);
		jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton6.setOpaque(false);
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});
		jPanel2.add(jButton6);
		jButton6.setBounds(20, 221, 160, 50);

		jButton7.setFont(new java.awt.Font("Candara", 1, 18)); // NOI18N
		jButton7.setIcon(new ImageIcon(EmployeeFrame.class.getResource("/exit.png"))); // NOI18N
		jButton7.setText("Exit");
		jButton7.setBorderPainted(false);
		jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton7.setOpaque(false);
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});
		jPanel2.add(jButton7);
		jButton7.setBounds(20, 301, 160, 50);

		jButton8.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/attendancems_with_prepared22/Project_Images/back.png"))); // NOI18N
		jButton8.setOpaque(false);
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});
		jPanel2.add(jButton8);
		jButton8.setBounds(20, 408, 40, 30);

		getContentPane().add(jPanel2);
		
		jButton1 = new JButton();
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton1ActionPerformed(e);
			}
		});
		jButton1.setIcon(new ImageIcon(EmployeeFrame.class.getResource("/Student.png")));
		jButton1.setText("Infor");
		jButton1.setOpaque(false);
		jButton1.setFont(new Font("Candara", Font.BOLD, 18));
		jButton1.setBorderPainted(false);
		jButton1.setBounds(20, 46, 160, 50);
		jPanel2.add(jButton1);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1000, 99);
		getContentPane().add(panel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EmployeeFrame.class.getResource("/aptech_logo.png")));
		lblNewLabel.setBounds(10, 12, 154, 76);
		panel.add(lblNewLabel);
		
		lblEmployeeFrame = new JLabel("Employee Page");
		lblEmployeeFrame.setBackground(new Color(240, 240, 240));
		lblEmployeeFrame.setFont(new Font("Candara", Font.BOLD, 48));
		lblEmployeeFrame.setBounds(299, 34, 354, 54);
		panel.add(lblEmployeeFrame);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(20, 11, 154, 76);
		panel.add(lblNewLabel_1);

		setSize(new java.awt.Dimension(1016, 589));
		setLocationRelativeTo(null);
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {

		jDesktopPane1.removeAll();
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int response = JOptionPane.showConfirmDialog(null,
					"You have clicked Exit. \n Do you want to close the window?", "Confirm", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (response == JOptionPane.YES_OPTION) {

				LoginFrame lf = new LoginFrame();
				lf.show();
				this.dispose();
			} else if (response == JOptionPane.NO_OPTION) {
			} else if (response == JOptionPane.CLOSED_OPTION) {
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(rootPane, ex.toString());
		}

	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		
		jDesktopPane1.removeAll();
		TeacherInternalFrame tif = new TeacherInternalFrame();
		jDesktopPane1.add(tif);
		tif.show();

	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		SettingInternalFrame sif = new SettingInternalFrame();
		jDesktopPane1.removeAll();
		jDesktopPane1.add(sif);
		sif.show();
	}
	public static void main(String args[]) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new EmployeeFrame().setVisible(true);
			}
		});
	}
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JDesktopPane jDesktopPane1;
	private javax.swing.JPanel jPanel2;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblEmployeeFrame;
	private JLabel lblNewLabel_1;
	private JButton jButton1;
	private JLabel Employee_ID;
	private JLabel textEmp_ID;
	private JLabel Emp_Name;
	private JTextField textField;
	private JLabel Position;
	private JTextField textField_1;
	private JLabel lblBirthday;
	private JDateChooser dateChooser;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JLabel lblLeaveDays;
	private JTextField textField_2;
	protected void jButton1ActionPerformed(ActionEvent e) {
	}
}
