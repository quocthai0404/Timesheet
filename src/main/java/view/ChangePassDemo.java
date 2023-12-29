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

public class ChangePassDemo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JLabel lblEmail_1;
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
        setTitle("Change Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 452, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 0, 434, 261);
        contentPane.add(cardPanel);

        // Panel 1
        panelEmail = new JPanel();
        lblEmail_1 = new JLabel("Change Password");
        lblEmail_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail_1.setBounds(137, 21, 142, 36);
        txtEmail = new JTextField();
        txtEmail.setText("Enter your email .....");
        txtEmail.setBounds(69, 91, 289, 36);
        btnEmailCheck_1 = new JButton("Next");
        btnEmailCheck_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		do_btnEmailCheck_1_mouseClicked(e);
        	}
        });
        btnEmailCheck_1.setBounds(267, 164, 91, 44);
        panelEmail.add(lblEmail_1);
        panelEmail.add(txtEmail);
        panelEmail.add(btnEmailCheck_1);
        panelEmail.setLayout(null);
        cardPanel.add(panelEmail, "panelEmail");

        // Panel 2
        panelCode = new JPanel();
        lblPassword = new JLabel("Code");
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setBounds(26, 67, 55, 59);
        txtCode = new JTextField();
        txtCode.setText("Enter your code .....");
        txtCode.setOpaque(false);
        txtCode.setBounds(91, 71, 269, 50);
        btnVerifyCode = new JButton("comfirm");
        btnVerifyCode.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		do_btnVerifyCode_mouseClicked(e);
        	}
        });
        btnVerifyCode.setBounds(262, 173, 98, 36);
        panelCode.add(lblPassword);
        panelCode.add(txtCode);
        panelCode.add(btnVerifyCode);
        panelCode.setLayout(null);
        cardPanel.add(panelCode, "panelCode");
        
        panelNewPass = new JPanel();
        cardPanel.add(panelNewPass, "name_1786383825300");
        panelNewPass.setLayout(null);
        cardPanel.add(panelNewPass, "panelNewPass");
        
        pwdEnterYourNewPW = new JPasswordField();
        pwdEnterYourNewPW.setBounds(99, 44, 191, 20);
        panelNewPass.add(pwdEnterYourNewPW);
        
        pwdComfirmNewPass = new JPasswordField();
        pwdComfirmNewPass.setBounds(99, 89, 191, 20);
        panelNewPass.add(pwdComfirmNewPass);
        
        btnChangePass = new JButton("Change Password");
        btnChangePass.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		do_btnChangePass_actionPerformed(e);
        	}
        });
        btnChangePass.setBounds(279, 169, 132, 23);
        panelNewPass.add(btnChangePass);

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
}