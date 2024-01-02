package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.apache.commons.lang3.RandomStringUtils;

import DAO.AccountDAO;
import DAO.ChangePassDAO;
import database.JdbcUlti;


import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ChangePassDemo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextField txtEmail;
    private JButton btnEmailCheck_1;
    private JPanel panelEmail;

    private JLabel lblPassword;
    private JTextField txtCode;
    private JButton btnVerifyCode;
    private JPanel panelCode;
    private JPanel panelNewPass;
    private JPasswordField pwdEnterYourNewPW;
    private JPasswordField pwdComfirmNewPass;
    private JButton btnChangePass;
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private JPanel panel_1;
    private JLabel lblLogo_1;
    private JLabel lblChangePassword;
    private JPanel panel_2;
    private JLabel lblLogo_2;
    private JLabel lblChangePassword_2;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChangePassDemo frame = new ChangePassDemo();
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
    public ChangePassDemo() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ChangePassDemo.class.getResource("/Logo.png")));
        setTitle("Change Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 417);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 0, 626, 378);
        contentPane.add(cardPanel);

        // Panel 1
        panelEmail = new JPanel();
        panelEmail.setBackground(new Color(128, 255, 255));
        txtEmail = new JTextField();
        txtEmail.setBounds(140, 120, 325, 44);
        txtEmail.setText("Enter your email .....");
        btnEmailCheck_1 = new JButton("Send");
        btnEmailCheck_1.setBounds(355, 209, 110, 44);
        btnEmailCheck_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		do_btnEmailCheck_1_mouseClicked(e);
        	}
        });
        cardPanel.add(panelEmail, "panelEmail");
        panelEmail.setLayout(null);
        panelEmail.add(txtEmail);
        panelEmail.add(btnEmailCheck_1);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 626, 76);
        panelEmail.add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(ChangePassDemo.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblNewLabel = new JLabel("Forget Password");
        lblNewLabel.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel.setBounds(174, 11, 422, 54);
        panel.add(lblNewLabel);
        
        btnNewButton = new JButton("Back Login");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNewButtonActionPerformed(e);
        	}
        });
        btnNewButton.setBounds(138, 209, 110, 44);
        panelEmail.add(btnNewButton);

        // Panel 2
        panelCode = new JPanel();
        panelCode.setBackground(new Color(128, 255, 255));
        lblPassword = new JLabel("Enter Your Code :");
        lblPassword.setFont(new Font("Candara", Font.PLAIN, 12));
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(40, 112, 117, 59);
        txtCode = new JTextField();
        txtCode.setFont(new Font("Candara", Font.PLAIN, 12));
        txtCode.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        txtCode.setText("  Enter your code .....");
        txtCode.setOpaque(false);
        txtCode.setBounds(167, 116, 269, 50);
        btnVerifyCode = new JButton("comfirm");
        btnVerifyCode.setFont(new Font("Candara", Font.BOLD, 14));
        btnVerifyCode.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		do_btnVerifyCode_mouseClicked(e);
        	}
        });
        btnVerifyCode.setBounds(338, 214, 98, 36);
        panelCode.add(lblPassword);
        panelCode.add(txtCode);
        panelCode.add(btnVerifyCode);
        panelCode.setLayout(null);
        cardPanel.add(panelCode, "panelCode");
        
        panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel_1.setBackground(Color.WHITE);
        panel_1.setBounds(0, 0, 626, 76);
        panelCode.add(panel_1);
        
        lblLogo_1 = new JLabel("");
        lblLogo_1.setIcon(new ImageIcon(ChangePassDemo.class.getResource("/aptech_logo.png")));
        lblLogo_1.setBounds(10, 0, 154, 76);
        panel_1.add(lblLogo_1);
        
        lblChangePassword = new JLabel("Enter Code");
        lblChangePassword.setFont(new Font("Candara", Font.BOLD, 48));
        lblChangePassword.setBounds(174, 11, 288, 54);
        panel_1.add(lblChangePassword);
        
        panelNewPass = new JPanel();
        panelNewPass.setBackground(new Color(128, 255, 255));
        cardPanel.add(panelNewPass, "name_1786383825300");
        panelNewPass.setLayout(null);
        cardPanel.add(panelNewPass, "panelNewPass");
        
        pwdEnterYourNewPW = new JPasswordField();
        pwdEnterYourNewPW.setBounds(258, 111, 191, 40);
        panelNewPass.add(pwdEnterYourNewPW);
        
        pwdComfirmNewPass = new JPasswordField();
        pwdComfirmNewPass.setBounds(258, 164, 191, 40);
        panelNewPass.add(pwdComfirmNewPass);
        
        btnChangePass = new JButton("Change Password");
        btnChangePass.setFont(new Font("Candara", Font.BOLD, 14));
        btnChangePass.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_btnChangePass_actionPerformed(e);
        	}
        });
        btnChangePass.setBounds(277, 228, 172, 40);
        panelNewPass.add(btnChangePass);
        
        panel_2 = new JPanel();
        panel_2.setLayout(null);
        panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 0, 626, 76);
        panelNewPass.add(panel_2);
        
        lblLogo_2 = new JLabel("");
        lblLogo_2.setIcon(new ImageIcon(ChangePassDemo.class.getResource("/aptech_logo.png")));
        lblLogo_2.setBounds(10, 0, 154, 76);
        panel_2.add(lblLogo_2);
        
        lblChangePassword_2 = new JLabel("Change Password");
        lblChangePassword_2.setFont(new Font("Candara", Font.BOLD, 48));
        lblChangePassword_2.setBounds(174, 22, 405, 54);
        panel_2.add(lblChangePassword_2);
        
        lblNewLabel_1 = new JLabel("Enter your new pass :");
        lblNewLabel_1.setFont(new Font("Candara", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(53, 113, 129, 40);
        panelNewPass.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("Confirm your new pass :");
        lblNewLabel_2.setFont(new Font("Candara", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(53, 166, 183, 40);
        panelNewPass.add(lblNewLabel_2);

        btnEmailCheck_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        btnVerifyCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	cardLayout.show(cardPanel, "panelNewPass");
            }
        });
    }
    public boolean checkMail() {
		try {
			var address = new InternetAddress(txtEmail.getText().trim());
			address.validate();
		} catch (Exception e) {
			return true;
		}return false;
	}
    public void sendMail(String randomKey,String username) {
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
					
					+ "        <h2>xin chao ban</h2>\r\n"
					+ "        <p>day la code dang nhap vao he thong <strong>"+ randomKey+"</strong></p>\r\n"
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
	protected void do_btnEmailCheck_1_mouseClicked(MouseEvent e) {
		if (checkMail()) {
			JOptionPane.showMessageDialog(null, "Error email!");
			return;
		}
		AccountDAO acc = new  AccountDAO();
		String username = acc.getUserNameFromEmail(txtEmail.getText());
		if(username == null) {
			JOptionPane.showMessageDialog(null, "This email isn't used by any account! Please enter another one");
			return;
		}
		String randomCode = RandomStringUtils.randomAlphanumeric(6);
		Date expirationTime = new Date();
		expirationTime.setTime(expirationTime.getTime()+5*60*1000);//5 phut de kich hoat
		
		
			ChangePassDAO dao = new ChangePassDAO();
			if(dao.checkUsernameExist(username)) {
				dao.update(username, randomCode, expirationTime);
			}
			else {
				dao.add(username, randomCode, expirationTime);
			}
			
			
			
			 
				sendMail(randomCode, username);
				JOptionPane.showMessageDialog(null, "The confirmation code will expire after 5 minutes");
				cardLayout.show(cardPanel, "panelCode");
			
			}
		
	protected void do_btnVerifyCode_mouseClicked(MouseEvent e) {
		if (txtCode.getText().isBlank() ) {
			JOptionPane.showMessageDialog(null, "Please fill in the text");
			return;
		}
		if(checkCode(txtCode.getText().trim())) {
			JOptionPane.showMessageDialog(null, "successful");
			cardLayout.show(cardPanel, "panelNewPass");
		}
		else {
			txtCode.setText("");
		}
		
	} 
	public boolean checkCode(String code) {
		AccountDAO acc = new  AccountDAO();
		String username = acc.getUserNameFromEmail(txtEmail.getText());
		if(username == null) {
			JOptionPane.showMessageDialog(null, "Error email!");
			return false;
		}
		try (
				var con = JdbcUlti.getConnection();
				
		){
			
			String sql = "select code, time from forgetpassword where username = ?";

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, username);
			
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				if(rs.getString("code").equals(code)) {
					if(rs.getTimestamp("time").getTime()<System.currentTimeMillis()) {
						JOptionPane.showMessageDialog(null, "Code qua han");
						return false;
					}else {
						return true;
					}
				}else {
					JOptionPane.showMessageDialog(null, "code khong trung khop, vui long nhap lai");
					return false;
					
				}
			}
			
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null," loi ket noi database");
		}
		return false;
	}
	protected void do_btnChangePass_actionPerformed(ActionEvent e) {
		if(checkPassword()) {
			
			AccountDAO acc = new  AccountDAO();
			String username = acc.getUserNameFromEmail(txtEmail.getText());
			acc.changePass(helper.Helper.changeToMD5(String.valueOf(pwdEnterYourNewPW.getPassword())),username );
			//sau do chuyen huong sang trang dang nhap
		}
		else {
			return;
		}
	}
	public boolean checkPassword() {
		String newPass = String.valueOf(pwdEnterYourNewPW.getPassword());
		String comfirmPass = String.valueOf(pwdComfirmNewPass.getPassword());
		if(newPass.isBlank() || comfirmPass.isBlank() ) {
			JOptionPane.showMessageDialog(null, "Please fill in both two fields");
			return false;
			
		}
		if(comfirmPass.equals(newPass)) {
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "2 mk khong giong nhau");
			return false;
		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
	      LoginFrame lf = new LoginFrame();
	      lf.show();
	      dispose();
	}
}