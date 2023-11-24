package layout;

import java.awt.EventQueue;    
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JTextField txtUserName;
    private JPasswordField pwdPassword;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JSeparator separator_1;
    private JSeparator separator;
    private JPanel panel_3;
    private JLabel lblLogin;
    private JLabel lblForgetpassword;
    private JLabel lblExit;
    private JLabel lblLogo;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 979, 542);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        panel = new JPanel();
        panel.setBackground(new Color(0x5271ff));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );

        panel_1 = new JPanel();
        panel_1.setBackground(new Color(0x5271ff));

        panel_2 = new JPanel();
        panel_2.setBackground(new Color(0, 0, 0));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 469, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
        		.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        txtUserName = new JTextField();
        txtUserName.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		txtUserNameFocusGained(e);
        	}
        });
        txtUserName.setSelectionColor(new Color(0, 128, 255));
        txtUserName.setFont(new Font("Calibri", Font.PLAIN, 18));
        txtUserName.setForeground(new Color(255, 255, 255));
        txtUserName.setBorder(null);
        txtUserName.setText("User Name");
        txtUserName.setBackground(new Color(0, 0, 0));
        txtUserName.setColumns(10);

        pwdPassword = new JPasswordField();
        pwdPassword.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusGained(FocusEvent e) {
        		pwdPasswordFocusGained(e);
        	}
        });
        pwdPassword.setForeground(new Color(255, 255, 255));
        pwdPassword.setBorder(null);
        pwdPassword.setText("Password");
        pwdPassword.setToolTipText("");
        pwdPassword.setBackground(new Color(0, 0, 0));

        lblUsername = new JLabel("");
        lblUsername.setFont(new Font("Calibri", Font.PLAIN, 18));

        // Giới hạn chiều cao và chiều rộng của biểu tượng
        int iconWidth = 40;
        int iconHeight = 40;

        // Đọc biểu tượng từ đường dẫn và giới hạn kích thước cho username
        ImageIcon originalUserIcon = new ImageIcon("C:\\Users\\Admin\\git\\Timesheet\\src\\main\\java\\image\\user_icon.png");
        Image scaledUserImage = originalUserIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledUserIcon = new ImageIcon(scaledUserImage);
        lblUsername.setIcon(scaledUserIcon);

        // Đọc biểu tượng từ đường dẫn và giới hạn kích thước cho password
        ImageIcon originalPasswordIcon = new ImageIcon("C:\\Users\\Admin\\git\\Timesheet\\src\\main\\java\\image\\password_icon.png");
        Image scaledPasswordImage = originalPasswordIcon.getImage().getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledPasswordIcon = new ImageIcon(scaledPasswordImage);

        lblPassword = new JLabel("");
        lblPassword.setIcon(scaledPasswordIcon);
        
        separator_1 = new JSeparator();
        separator_1.setBackground(Color.WHITE);
        
        separator = new JSeparator();
        separator.setBackground(Color.WHITE);
        
        panel_3 = new JPanel();
        panel_3.setBackground(new Color(0, 0, 0));
        panel_3.setBorder(new LineBorder(new Color(255, 255, 255)));
        
        lblForgetpassword = new JLabel("    Forget Password?");
        lblForgetpassword.setForeground(new Color(255, 255, 255));
        lblForgetpassword.setFont(new Font("Calibri", Font.PLAIN, 18));
        
        lblExit = new JLabel("X");
        lblExit.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		lblExitMouseClicked(e);
        	}
        });
        lblExit.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblExit.setForeground(new Color(255, 255, 255));

        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGap(88)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblUsername))
        			.addGap(18)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblForgetpassword, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
        					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
        						.addComponent(txtUserName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        						.addComponent(panel_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
        						.addComponent(separator_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
        						.addComponent(pwdPassword, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE))
        					.addGap(90))))
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap(479, Short.MAX_VALUE)
        			.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addComponent(lblExit)
        					.addPreferredGap(ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
        					.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)))
        			.addGap(22)
        			.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_panel_2.createSequentialGroup()
        					.addGap(11)
        					.addComponent(pwdPassword, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(39)
        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(lblForgetpassword, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
        			.addGap(36))
        );
        
        // Xử lý sự kiện click chuột cho nhãn "Sign In"
        lblLogin = new JLabel("              Sign In");
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        lblLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
        lblLogin.setForeground(new Color(255, 255, 255));
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
        );
        panel_3.setLayout(gl_panel_3);
        panel_2.setLayout(gl_panel_2);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("C:\\Users\\Admin\\git\\Timesheet\\src\\main\\java\\image\\LOGO.png"));
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 447, Short.MAX_VALUE)
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addGap(89)
        			.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(84, Short.MAX_VALUE))
        );
        panel_1.setLayout(gl_panel_1);
        panel.setLayout(gl_panel);
        contentPane.setLayout(gl_contentPane);
    }
	protected void lblExitMouseClicked(MouseEvent e) {
		System.exit(0);
	}
	protected void txtUserNameFocusGained(FocusEvent e) {
		txtUserName.setText("");
	}
	protected void pwdPasswordFocusGained(FocusEvent e) {
		pwdPassword.setText("");
	}
	 protected void lblLoginMouseClicked(MouseEvent e) {
	        // Xử lý sự kiện khi nhấp chuột vào nhãn "Sign In"
	        MainJFrame mainFrame = new MainJFrame(); 
	        mainFrame.setVisible(true);
	        dispose();  // Đóng cửa sổ hiện tại nếu cần
	    }
}
