package loginAndPasLayout;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import DAO.AccountDAO;
import DAO.EmployeeDAO;
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
import java.util.Properties;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;


public class LoginAndForgotPass extends JLayeredPane {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel login;
	private JPanel forgotpassword;
	private JTextField textEmp_Username;
	private JPanel panel_1;
	private JButton btnLogin;
	private JLabel lblNewLabel_4;
	private JLabel lblUsername;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JCheckBox show;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_8;
	private JTextField textEmail;
	private List<Employee> list;
	private MainLayout jf4;
	private JLabel lblNewLabel;
	private JLabel lblForgotPassword;
	private JButton btnSend;
	
	
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
		setSize(new Dimension(628, 517)); 
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
		show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showActionPerformed(e);
			}
		});
		show.setBackground(new Color(255, 255, 255));
		show.setForeground(new Color(0, 0, 0));
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
								.addComponent(textPassword, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
								.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))))
					.addContainerGap())
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(96))
		);
		panel_1.setLayout(gl_panel_1);
		
		lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 21));
		GroupLayout gl_login = new GroupLayout(login);
		gl_login.setHorizontalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_login.createSequentialGroup()
					.addGroup(gl_login.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_login.createSequentialGroup()
							.addGap(191)
							.addComponent(lblNewLabel))
						.addGroup(gl_login.createSequentialGroup()
							.addGap(41)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(200, Short.MAX_VALUE))
		);
		gl_login.setVerticalGroup(
			gl_login.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_login.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addGap(79))
		);
		login.setLayout(gl_login);
		
		forgotpassword = new JPanel();
		forgotpassword.setBackground(new Color(0, 0, 0));
		add(forgotpassword, "name_409049808236600");
		
		textEmp_Username = new JTextField();
		textEmp_Username.setColumns(10);
		textEmp_Username.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		
		lblNewLabel_3 = new JLabel("User name :");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 17));
		
		lblNewLabel_8 = new JLabel("Email :");
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 18));
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendActionPerformed(e);
			}
		});
		btnSend.setForeground(new Color(0, 0, 0));
		btnSend.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnSend.setBackground(Color.WHITE);
		
		lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setForeground(Color.WHITE);
		lblForgotPassword.setFont(new Font("Segoe UI", Font.BOLD, 21));
		GroupLayout gl_forgotpassword = new GroupLayout(forgotpassword);
		gl_forgotpassword.setHorizontalGroup(
			gl_forgotpassword.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_forgotpassword.createSequentialGroup()
					.addGroup(gl_forgotpassword.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addGap(41)
							.addGroup(gl_forgotpassword.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
							.addGap(46)
							.addGroup(gl_forgotpassword.createParallelGroup(Alignment.LEADING)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEmp_Username, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addGap(147)
							.addComponent(lblForgotPassword))
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addGap(117)
							.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		gl_forgotpassword.setVerticalGroup(
			gl_forgotpassword.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_forgotpassword.createSequentialGroup()
					.addGroup(gl_forgotpassword.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addContainerGap(140, Short.MAX_VALUE)
							.addComponent(lblForgotPassword)
							.addGap(91))
						.addGroup(gl_forgotpassword.createSequentialGroup()
							.addGap(187)
							.addGroup(gl_forgotpassword.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEmp_Username, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addGap(18)
							.addGroup(gl_forgotpassword.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGap(58)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(168))
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
		
	    private void showErrorDialog(String message) {
	        JOptionPane.showMessageDialog(new JFrame(), message, "Error", JOptionPane.ERROR_MESSAGE);
	    }
	    
	    protected void btnSendActionPerformed(ActionEvent e) {
	        // Trong phương thức btnSendActionPerformed
	        String userName = textEmp_Username.getText();
	        String email = textEmail.getText();

	        // Kiểm tra thông tin nhập liệu
	        if (userName.isEmpty() || email.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Lấy thông tin người dùng từ cơ sở dữ liệu
	        AccountDAO DAO = new AccountDAO();
	        String password = DAO.getEmployeePasswordByUsernameAndEmail(userName, email);
	        

	        

	        // Lấy mật khẩu từ cơ sở dữ liệu (bạn cần thay thế "yourColumnName" bằng tên cột chứa mật khẩu)
	        

	        if (password == null) {
	            JOptionPane.showMessageDialog(null, "Error retrieving password from the database.", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Gửi email mật khẩu mới
	        sendPasswordRecoveryEmail(email, password);

	        JOptionPane.showMessageDialog(null, "Password recovery email sent. Check your email for the new password.", "Success", JOptionPane.INFORMATION_MESSAGE);
	    }

	    // Phương thức gửi email mật khẩu mới
	    private void sendPasswordRecoveryEmail(String toEmail, String newPassword) {
	    	final String fromEmail = "phamtienorion@gmail.com";
			final String password = "rzyf avdc aezw qusr";
			String userName = textEmp_Username.getText();
	        String email = textEmail.getText();
			AccountDAO DAO = new AccountDAO();
	        String passwordFromDB = DAO.getEmployeePasswordByUsernameAndEmail(userName, email);
			
			
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
				mes.setRecipients(Message.RecipientType.TO, InternetAddress.parse(textEmail.getText()));
				mes.setSubject("Dear: "+ textEmp_Username.getText());
//				mes.setText("abc....");
				String html = "<div>\r\n"
						+ "        <h2>xin chao  "+ userName + "</h2>\r\n"
						+ "        <p>  Đây là pass đăng nhập của bạn :<strong>"+passwordFromDB +"</strong></p>\r\n"
						+ "    \r\n"
						+ "    </div>";
				mes.setContent(html,"text/html; charset = UTF-8");
				Transport.send(mes);
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "email chua dang ky bao mat 2 lop");
				return;
			}
	    }

	    protected void showActionPerformed(ActionEvent e) {
	        if (show.isSelected()) {
	            textPassword.setEchoChar((char) 0);
	        } else {
	            textPassword.setEchoChar('*');
	        }
	    }
}