package loginAndPasLayout;

import java.awt.EventQueue;	

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import database.JdbcUlti;
import entity.Employee;
import loginAndPasLayout.LoginAndForgotPass;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SendPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JButton btnSendPassAgain_1;
	private JTextField textEmail;
	private JLabel lblSendpassword;
	private List<Employee> list;
	private LoginAndForgotPass jf2;
	private JTextField textNewPassword;
	
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public void setJf1(LoginAndForgotPass panelLoginAndRegister) {
		this.jf2 = panelLoginAndRegister;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendPassword frame = new SendPassword();
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
	public SendPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		panel = new JPanel();
		
		btnSendPassAgain_1 = new JButton("Send Pass Again");
		btnSendPassAgain_1.setForeground(new Color(0, 128, 64));
		btnSendPassAgain_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Email :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 64)));
		
		textNewPassword = new JTextField();
		textNewPassword.setColumns(10);
		textNewPassword.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "NewPassword", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 64)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textNewPassword, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textEmail, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
							.addGap(39))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(63)
					.addComponent(btnSendPassAgain_1)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textNewPassword, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnSendPassAgain_1)
					.addContainerGap(117, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		lblSendpassword = new JLabel("Send Password");
		lblSendpassword.setForeground(new Color(0, 128, 64));
		lblSendpassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSendpasswordMouseClicked(e);
			}
		});
		lblSendpassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(176)
					.addComponent(lblSendpassword, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(109)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addComponent(lblSendpassword, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void showErrorDialog(String message) {
	    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	private boolean resetPassword(Connection con, String email, String newPassword) throws SQLException {
	    try (var cs = con.prepareCall("{call resetPassword(?, ?)}")) {
	        cs.setString(1, email);
	        cs.setString(2, newPassword);

	        return cs.executeUpdate() > 0;
	    }
	}
	protected void lblSendpasswordMouseClicked(MouseEvent e) {
		setVisible(false);
		jf2.setVisible(true);
	}
}
