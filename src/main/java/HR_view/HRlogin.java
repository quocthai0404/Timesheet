package HR_view;

import java.awt.CardLayout;	
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
import helper.Helper;
import view.LoginFrame;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Toolkit;

import DAO.HRaccountDAO;

public class HRlogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JButton btnEmailCheck_1;
    private JPanel panelEmail;
    private JTextField textHR;
    private JButton btnEmailCheck;
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblHrLogin;
    private JPasswordField passwordHR;
    private JButton btnLogin;
    private JButton btnBack;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HRlogin frame = new HRlogin();
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
    public HRlogin() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(HRlogin.class.getResource("/Logo.png")));
        setTitle("Change Password");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 642, 417);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        panelEmail = new JPanel();
        panelEmail.setLayout(null);
        panelEmail.setBackground(new Color(128, 255, 255));
        panelEmail.setBounds(0, 0, 626, 378);
        contentPane.add(panelEmail);
        
        textHR = new JTextField();
        textHR.setFont(new Font("Candara", Font.PLAIN, 12));
        textHR.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        textHR.setBounds(140, 120, 325, 44);
        panelEmail.add(textHR);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 626, 76);
        panelEmail.add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(HRlogin.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblHrLogin = new JLabel("HR LOGIN PAGE");
        lblHrLogin.setFont(new Font("Candara", Font.BOLD, 48));
        lblHrLogin.setBounds(174, 22, 422, 54);
        panel.add(lblHrLogin);
        
        passwordHR = new JPasswordField();
        passwordHR.setBorder(new TitledBorder(null, "Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        passwordHR.setFont(new Font("Calibri", Font.PLAIN, 12));
        passwordHR.setBounds(140, 175, 325, 44);
        panelEmail.add(passwordHR);
        
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnLoginActionPerformed(e);
        	}
        });
        btnLogin.setBounds(140, 241, 98, 35);
        panelEmail.add(btnLogin);
        
        btnBack = new JButton("");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnBackActionPerformed(e);
        	}
        });
        btnBack.setIcon(new ImageIcon(HRlogin.class.getResource("/back.png")));
        btnBack.setBounds(411, 241, 52, 35);
        panelEmail.add(btnBack);
    }


	 
	protected void btnBackActionPerformed(ActionEvent e) {
		LoginFrame lf = new LoginFrame();
		lf.setVisible(true);
        this.dispose();
	}
	protected void btnLoginActionPerformed(ActionEvent e) {
        String username = textHR.getText();
        char[] passwordChars = passwordHR.getPassword();
        String password = new String(passwordChars);
        
        Helper helper = new Helper();
        String encryptedPassword = helper.changeToMD5(password);
        HRaccountDAO hrAccountDAO = new HRaccountDAO();
        if (hrAccountDAO.login(username, password)) {
            // Đăng nhập thành công
            JOptionPane.showMessageDialog(this, "Login Success!");

            // Ẩn cửa sổ hiện tại
            this.setVisible(false);

            // Hiển thị cửa sổ HRFrame
            HRFrame hrFrame = new HRFrame();
            hrFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Login Default!");
        }
    }

}