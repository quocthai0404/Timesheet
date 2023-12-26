package view;

import java.awt.Color;	
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import database.JdbcUlti;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Create_Employee_Account extends javax.swing.JInternalFrame {
	JdbcUlti cn;
	

	/**
	 * Creates new form Create_Employee_Account
	 */
	public Create_Employee_Account() {
		getContentPane().setBackground(new Color(128, 255, 255));
		getContentPane().setForeground(new Color(128, 255, 255));
		initComponents();
		cn = new JdbcUlti();
		setTitle("New Student");
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
		Passwword = new javax.swing.JLabel();
		textEmp_ID = new javax.swing.JLabel();
		textEmp_Name = new javax.swing.JTextField();

		setMaximumSize(new java.awt.Dimension(990, 550));
		setMinimumSize(new java.awt.Dimension(990, 550));
		setPreferredSize(new java.awt.Dimension(990, 550));
		getContentPane().setLayout(null);

		Employee_ID.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		Employee_ID.setForeground(new Color(0, 0, 0));
		Employee_ID.setText("Employee ID :");
		getContentPane().add(Employee_ID);
		Employee_ID.setBounds(80, 87, 110, 30);

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
		Username.setBounds(80, 128, 109, 30);

		Passwword.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		Passwword.setForeground(new Color(0, 0, 0));
		Passwword.setText("Password :");
		getContentPane().add(Passwword);
		Passwword.setBounds(80, 169, 109, 30);

		textEmp_ID.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		textEmp_ID.setForeground(new java.awt.Color(255, 255, 255));
		getContentPane().add(textEmp_ID);
		textEmp_ID.setBounds(221, 87, 180, 30);

		textEmp_Name.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
	
		getContentPane().add(textEmp_Name);
		textEmp_Name.setBounds(635, 169, 180, 30);
		scrollPane.setBounds(80, 308, 729, 201);
		getContentPane().add(scrollPane);
		
		tableEmployee = new JTable();
		tableEmployee.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(tableEmployee);
		
		textPosition = new JTextField();
		textPosition.setFont(new Font("Calibri", Font.BOLD, 14));
		textPosition.setBounds(635, 210, 180, 30);
		getContentPane().add(textPosition);
		
		textUsername = new JTextField();
		textUsername.setFont(new Font("Calibri", Font.BOLD, 14));
		textUsername.setBounds(221, 128, 180, 30);
		getContentPane().add(textUsername);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Calibri", Font.BOLD, 14));
		textPassword.setBounds(221, 169, 180, 30);
		getContentPane().add(textPassword);
		
		Email = new JLabel();
		Email.setText("Email");
		Email.setForeground(Color.BLACK);
		Email.setFont(new Font("Candara", Font.BOLD, 14));
		Email.setBounds(80, 210, 109, 30);
		getContentPane().add(Email);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Calibri", Font.BOLD, 14));
		textEmail.setBounds(221, 210, 180, 30);
		getContentPane().add(textEmail);
		
		btnAdd_Account = new JButton("");
		btnAdd_Account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});

		btnAdd_Account.setIcon(new ImageIcon(Create_Employee_Account.class.getResource("/add.png")));
		ImageIcon originalIcon = (ImageIcon) btnAdd_Account.getIcon();
		Image img = originalIcon.getImage().getScaledInstance(124, 30, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(img);
		btnAdd_Account.setIcon(resizedIcon);
		btnAdd_Account.setPreferredSize(new Dimension(124, 30));
		btnAdd_Account.setBounds(80, 264, 90, 30);
		getContentPane().add(btnAdd_Account);

		
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
		lblNewLabel_1.setBounds(209, 11, 755, 54);
		panel.add(lblNewLabel_1);;

		setBounds(0, 0, 990, 550);
	}

	private javax.swing.JLabel Employee_ID;
	private javax.swing.JLabel Passwword;
	private javax.swing.JLabel textEmp_ID;
	private javax.swing.JLabel Emp_Name;
	private javax.swing.JLabel Position;
	private javax.swing.JLabel Username;
	private javax.swing.JTextField textEmp_Name;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable tableEmployee;
	private JTextField textPosition;
	private JTextField textUsername;
	private JTextField textPassword;
	private JLabel Email;
	private JTextField textEmail;
	private JButton btnAdd_Account;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	protected void btnNewButtonActionPerformed(ActionEvent e) {
	}
}
