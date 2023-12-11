package view;

import java.awt.EventQueue;
import DAO.AccountDAO;
import DAO.EmployeeDAO;
import Test.Login2;
import database.JdbcUlti;
import entity.Account;
import entity.Employee;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Forget_Password extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jPanel23;
	private JLabel lblForgetPassword;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextField textField;
	private JButton btnSend;
	private JButton btnBack_Login;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forget_Password frame = new Forget_Password();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Forget_Password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 374);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		jPanel23 = new JPanel();
		jPanel23.setBackground(Color.BLACK);
		
		lblForgetPassword = new JLabel();
		lblForgetPassword.setText("Forget Password");
		lblForgetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgetPassword.setForeground(Color.WHITE);
		lblForgetPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblForgetPassword.setBackground(Color.BLACK);
		GroupLayout gl_jPanel23 = new GroupLayout(jPanel23);
		gl_jPanel23.setHorizontalGroup(
			gl_jPanel23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 542, Short.MAX_VALUE)
				.addComponent(lblForgetPassword, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
		);
		gl_jPanel23.setVerticalGroup(
			gl_jPanel23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addComponent(lblForgetPassword, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
		);
		jPanel23.setLayout(gl_jPanel23);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtEmail.setToolTipText("");
		txtEmail.setColumns(10);
		txtEmail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Segoe UI", Font.BOLD, 13));
		txtUsername.setToolTipText("");
		txtUsername.setColumns(10);
		txtUsername.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 13));
		textField.setToolTipText("");
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee ID", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendActionPerformed(e);
			}
		});
		btnSend.setFont(new Font("Segoe UI", Font.BOLD, 13));
		
		btnBack_Login = new JButton("Back Login");
		btnBack_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBack_LoginActionPerformed(e);
			}
		});
		btnBack_Login.setFont(new Font("Segoe UI", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(116)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(btnBack_Login, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(textField, Alignment.LEADING)
							.addComponent(txtUsername, Alignment.LEADING)
							.addComponent(txtEmail)
							.addComponent(jPanel23, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)))
					.addContainerGap(139, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addComponent(btnBack_Login, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnSendActionPerformed(ActionEvent e) {
	    String email = txtEmail.getText();
	    String username = txtUsername.getText();
	    String empId = textField.getText();

	    if (!email.isEmpty() && !username.isEmpty() && !empId.isEmpty()) {
	        AccountDAO accDAO = new AccountDAO();
	        String password = accDAO.getPasswordFromAccount(username);

	        if (password != null) {
	            sendPasswordToEmail(email, password);
	            System.out.println("Password has been sent to your email");
	        } else {
	            System.out.println("User information not found");
	        }
	    } else {
	        System.out.println("Please complete all information");
	    }
	}
	    private void sendPasswordToEmail(String email, String password) {
	        System.out.println("Password has been sent to email: " + email);
	    }

	    protected void btnBack_LoginActionPerformed(ActionEvent e) {

	        Login2 loginFrame = new Login2();

	        loginFrame.setVisible(true);

	        this.dispose(); 
	        
	    }

}