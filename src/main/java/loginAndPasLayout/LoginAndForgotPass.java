package loginAndPasLayout;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DAO.AccountDAO;
import database.JdbcUlti;
import entity.Employee;
import entity.EmployeeAfterLogin;
import view.FrameForEmp;
import view.MainJFrame;

import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;


public class LoginAndForgotPass extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel login;
	private JPanel forgotpassword;
	private JTextField textName;
	private JPanel panel_1;
	private JButton btnLogin;
	private JLabel lblNewLabel_4;
	private JLabel lblUsername;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JCheckBox show;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_8;
	private JTextField textPass;
	private List<Employee> list;
	private MainLayout jf4;
	private JLabel lblNewLabel;
	private JLabel lblForgotPassword;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JButton btnSignIn_1;
	
	
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public void setJf(MainLayout logIn) {
		this.jf4 = logIn;
	}

	/**
	 * Create the panel.
	 */
	public LoginAndForgotPass() {
		setSize(new Dimension(497, 530)); 
		setLayout(new CardLayout(0, 0));
		
	
		 
		login = new JPanel();
		login.setForeground(new Color(255, 255, 255));
		login.setBackground(new Color(255, 255, 255));
		login.setSize(new Dimension(501, 528));
		add(login, "name_409012289542800");
		
		panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(255, 255, 255));
		
		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginActionPerformed(e);
			}
		});
		
		lblNewLabel_4 = new JLabel("Password :");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblUsername = new JLabel("User Name");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textUsername = new JTextField();
		textUsername.setColumns(10);
		textUsername.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		textPassword = new JPasswordField();
		textPassword.setBackground(new Color(255, 255, 255));
		textPassword.setEchoChar('*');
		
		show = new JCheckBox("Show Password");
		show.setBackground(new Color(255, 255, 255));
		show.setForeground(new Color(0, 0, 0));
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showActionPerformed(e);
			}
		});
		show.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(show, Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_4, Alignment.LEADING))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(textUsername, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
								.addComponent(textPassword, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))
					.addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(show)
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(85))
		);
		panel_1.setLayout(gl_panel_1);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		GroupLayout gl_login = new GroupLayout(login);
		gl_login.setHorizontalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addGap(55)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(55, Short.MAX_VALUE))
				.addGroup(gl_login.createSequentialGroup()
					.addGap(206)
					.addComponent(lblNewLabel)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		gl_login.setVerticalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addGap(130)
					.addComponent(lblNewLabel)
					.addGap(3)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(135, Short.MAX_VALUE))
		);
		login.setLayout(gl_login);
		
		forgotpassword = new JPanel();
		forgotpassword.setBackground(new Color(0, 0, 0));
		add(forgotpassword, "name_409049808236600");
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		
		lblNewLabel_3 = new JLabel("User name :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		
		lblNewLabel_8 = new JLabel("Email :");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		textPass = new JTextField();
		textPass.setColumns(10);
		textPass.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		
		lblNewLabel_1 = new JLabel("Employee ID");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_1.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		
		btnSignIn_1 = new JButton("Send");
		btnSignIn_1.setForeground(new Color(0, 0, 0));
		btnSignIn_1.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnSignIn_1.setBackground(Color.WHITE);
		
		lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setFont(new Font("Segoe UI", Font.BOLD, 21));
		GroupLayout gl_forgotpassword = new GroupLayout(forgotpassword);
		gl_forgotpassword.setHorizontalGroup(
			gl_forgotpassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_forgotpassword.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_forgotpassword.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
							.addComponent(textName, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
							.addComponent(textPass, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(46, Short.MAX_VALUE))
				.addGroup(gl_forgotpassword.createSequentialGroup()
					.addGap(118)
					.addComponent(btnSignIn_1, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(gl_forgotpassword.createSequentialGroup()
					.addGap(147)
					.addComponent(lblForgotPassword)
					.addContainerGap(185, Short.MAX_VALUE))
		);
		gl_forgotpassword.setVerticalGroup(
			gl_forgotpassword.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_forgotpassword.createSequentialGroup()
					.addContainerGap(164, Short.MAX_VALUE)
					.addComponent(lblForgotPassword)
					.addGap(18)
					.addGroup(gl_forgotpassword.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addComponent(textName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPass, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_forgotpassword.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnSignIn_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(172))
		);
		forgotpassword.setLayout(gl_forgotpassword);
        login.setVisible(false);
        forgotpassword.setVisible(true);

	}

	

	
	public void showForgotPass(boolean show) {
        if (show) {
            forgotpassword.setVisible(true);
            login.setVisible(false);
        } else {
            forgotpassword.setVisible(false);
            login.setVisible(true);
        }
    }

	private boolean validateCreateAccountInput(String fullName, String email, String password) {
	    StringBuilder errorMessage = new StringBuilder();
	    if ("".equals(fullName)) {
	        errorMessage.append("Full Name is required\n");
	    }if ("".equals(email)) {
	        errorMessage.append("Email Address is required\n");
	    } else if (!email.contains("@")) {
	        errorMessage.append("Invalid Email Address\n");
	    }if ("".equals(password)) {
	        errorMessage.append("Password is required\n");	
	    }if (errorMessage.length() > 0) {
	        JOptionPane.showMessageDialog(null, errorMessage.toString(), "Error", JOptionPane.ERROR_MESSAGE);
	        return false; // Trả về false nếu có lỗi
	    }
	    return true; // Trả về true nếu không có lỗi
	}

	private void handleDatabaseError(SQLException ex, String message) {
	    // Xử lý lỗi cơ sở dữ liệu ở đây
	    ex.printStackTrace();
	    JOptionPane.showMessageDialog(null, message, "Database Error", JOptionPane.ERROR_MESSAGE);
	}

	protected void btnLoginActionPerformed(ActionEvent e) {
		AccountDAO accDAO = new AccountDAO();
		if(accDAO.Login(textUsername.getText(), String.valueOf(textPassword.getPassword()))) {
			System.out.println(EmployeeAfterLogin.employeePosition);
			System.out.println(EmployeeAfterLogin.employeeID);
			if(EmployeeAfterLogin.employeePosition.equals("manager")) {
				setVisible(false);
				new MainJFrame();
			}else {
				setVisible(false);
				new FrameForEmp();
			}
		}else {
			JOptionPane.showMessageDialog(null, "incorrect username or password");
		}

	}


	    private void dispose() {
			// TODO Auto-generated method stub
			
		}
		private LoginResult signIn(String email, String password) throws SQLException {
	        try (Connection con = JdbcUlti.getConnection();
	             CallableStatement csSignIn = con.prepareCall("{call signIn(?,?)}")) {
	            csSignIn.setString(1, email);
	            csSignIn.setString(2, password);
	            ResultSet rsSignIn = csSignIn.executeQuery();
	            if (rsSignIn.next()) {
	                return new LoginResult(true, "");
	            } else {
	                return new LoginResult(false, "Wrong Email or Password. Please try again.");
	            }
	        }
	    }

	    protected void showActionPerformed(ActionEvent e) {
	        if (show.isSelected()) {
	            textPassword.setEchoChar((char) 0);
	        } else {
	            textPassword.setEchoChar('*');
	        }
	    }

//	    private void showPrisonerFrame() {
//	        PrisonerFrame pr = new PrisonerFrame();
//	        pr.setVisible(true);
//	        pr.pack();
//	        pr.setLocationRelativeTo(null);
//	    }


	    private void showErrorDialog(String message) {
	        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
	    }



	    private boolean validateSignInInput(String email, String password) {
	        if ("".equals(email) || "".equals(password)) {
	            showErrorDialog("Please enter Email Address and Password.");
	            return false;
	        }
	        return true;
	    }
}