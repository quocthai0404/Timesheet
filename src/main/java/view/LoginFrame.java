/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import attendancems_with_prepared22.AttendFrame;
import database.JdbcUlti;
import javax.swing.ImageIcon;

/**
 *
 * @author Iqbal-Asi
 */
public class LoginFrame extends javax.swing.JFrame {
	JdbcUlti cn;
	Color color;
	public LoginFrame() {
		initComponents();

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(getClass().getResource("/attendancems_with_prepared22/Project_Images/Logo.png")));
		setResizable(false);

		cn = new JdbcUlti();

		jPanel1buttons.setVisible(true);
		jPanel2teacher.setVisible(false);
		jPanel3admin.setVisible(false);

		// Title
		setTitle("Attendance Management System");

	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		jPanel1buttons = new javax.swing.JPanel();
		jPanel1buttons.setBackground(new Color(0, 255, 255));
		jButtonEmployee = new javax.swing.JButton();
		jButtonAdmin = new javax.swing.JButton();
		MainLayerBG = new javax.swing.JLabel();
		jPanel2teacher = new javax.swing.JPanel();
		jTextField1 = new javax.swing.JTextField();
		jPasswordField1 = new javax.swing.JPasswordField();
		EmployeeLoginButton = new javax.swing.JButton();
		EmployeeClearButton = new javax.swing.JButton();
		TeacherPanelBG = new javax.swing.JLabel();
		jPanel3admin = new javax.swing.JPanel();
		jTextField2 = new javax.swing.JTextField();
		jPasswordField2 = new javax.swing.JPasswordField();
		AdminloginButton = new javax.swing.JButton();
		AdminClearButton = new javax.swing.JButton();
		AdminPanelBG = new javax.swing.JLabel();
		LoginFrame = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		jPanel1buttons.setMaximumSize(new java.awt.Dimension(320, 240));
		jPanel1buttons.setLayout(null);

		jButtonEmployee.setBackground(new java.awt.Color(0, 0, 102));
		jButtonEmployee.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
		jButtonEmployee.setIcon(new ImageIcon(LoginFrame.class.getResource("/teachermainbutton.png"))); // NOI18N
		jButtonEmployee.setIcon(new ImageIcon("media/employeemainbutton.png")); // NOI18N
		jButtonEmployee.setToolTipText("");
		jButtonEmployee.setBorder(null);
		jButtonEmployee.setBorderPainted(false);
		jButtonEmployee.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonTeacherActionPerformed(evt);
			}
		});
		jPanel1buttons.add(jButtonEmployee);
		jButtonEmployee.setBounds(80, 38, 150, 60);

		jButtonAdmin.setIcon(new ImageIcon("media/managermainbutton.png")); // NOI18N
		jButtonAdmin.setBorder(null);
		jButtonAdmin.setBorderPainted(false);
		jButtonAdmin.setOpaque(false);
		jButtonAdmin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonAdminActionPerformed(evt);
			}
		});
		jPanel1buttons.add(jButtonAdmin);
		jButtonAdmin.setBounds(80, 120, 150, 60);

		MainLayerBG.setIcon(new ImageIcon(LoginFrame.class.getResource("/mainlayer.png"))); // NOI18N
		jPanel1buttons.add(MainLayerBG);
		MainLayerBG.setBounds(-10, 0, 350, 240);

		jLayeredPane1.add(jPanel1buttons);
		jPanel1buttons.setBounds(0, 0, 320, 240);

		jPanel2teacher.setMaximumSize(new java.awt.Dimension(320, 240));
		jPanel2teacher.setMinimumSize(new java.awt.Dimension(320, 240));
		jPanel2teacher.setPreferredSize(new java.awt.Dimension(320, 240));
		jPanel2teacher.setLayout(null);

		jTextField1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
		jPanel2teacher.add(jTextField1);
		jTextField1.setBounds(70, 80, 200, 30);

		jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jPasswordField1KeyPressed(evt);
			}
		});
		jPanel2teacher.add(jPasswordField1);
		jPasswordField1.setBounds(70, 140, 200, 30);

		EmployeeLoginButton.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		EmployeeLoginButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/loginbutton.png"))); // NOI18N
		EmployeeLoginButton.setBorder(null);
		EmployeeLoginButton.setBorderPainted(false);
		EmployeeLoginButton.setOpaque(false);
		EmployeeLoginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EmployeeLoginButtonActionPerformed(evt);
			}
		});
		jPanel2teacher.add(EmployeeLoginButton);
		EmployeeLoginButton.setBounds(80, 190, 70, 30);

		EmployeeClearButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/back.png"))); // NOI18N
		EmployeeClearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				EmployeeClearButtonActionPerformed(evt);
			}
		});
		jPanel2teacher.add(EmployeeClearButton);
		EmployeeClearButton.setBounds(170, 200, 50, 20);

		TeacherPanelBG.setIcon(new ImageIcon(LoginFrame.class.getResource("/layer.png"))); // NOI18N
		jPanel2teacher.add(TeacherPanelBG);
		TeacherPanelBG.setBounds(-10, 0, 330, 240);

		jLayeredPane1.add(jPanel2teacher);
		jPanel2teacher.setBounds(0, 0, 320, 240);

		jPanel3admin.setMaximumSize(new java.awt.Dimension(320, 240));
		jPanel3admin.setMinimumSize(new java.awt.Dimension(320, 240));
		jPanel3admin.setPreferredSize(new java.awt.Dimension(320, 240));
		jPanel3admin.setLayout(null);

		jTextField2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
		jPanel3admin.add(jTextField2);
		jTextField2.setBounds(80, 80, 200, 30);

		jPasswordField2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
		jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				jPasswordField2KeyPressed(evt);
			}
		});
		jPanel3admin.add(jPasswordField2);
		jPasswordField2.setBounds(80, 140, 200, 30);

		AdminloginButton.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
		AdminloginButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/loginbutton.png"))); // NOI18N
		AdminloginButton.setBorder(null);
		AdminloginButton.setBorderPainted(false);
		AdminloginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AdminloginButtonActionPerformed(evt);
			}
		});
		jPanel3admin.add(AdminloginButton);
		AdminloginButton.setBounds(100, 190, 70, 30);

		AdminClearButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/back.png"))); // NOI18N
		AdminClearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				AdminClearButtonActionPerformed(evt);
			}
		});
		jPanel3admin.add(AdminClearButton);
		AdminClearButton.setBounds(190, 196, 50, 20);

		AdminPanelBG.setIcon(new ImageIcon(LoginFrame.class.getResource("/layer.png"))); // NOI18N
		jPanel3admin.add(AdminPanelBG);
		AdminPanelBG.setBounds(-10, 0, 330, 240);

		jLayeredPane1.add(jPanel3admin);
		jPanel3admin.setBounds(0, 0, 320, 240);

		getContentPane().add(jLayeredPane1);
		jLayeredPane1.setBounds(45, 30, 320, 240);

		LoginFrame.setIcon(new ImageIcon(LoginFrame.class.getResource("/Login.png"))); // NOI18N
		getContentPane().add(LoginFrame);
		LoginFrame.setBounds(0, 0, 400, 300);

		setSize(new java.awt.Dimension(416, 339));
		setLocationRelativeTo(null);
	}

	private void EmployeeLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    try {
	        // Assuming 'cn' is an instance of your Connection class
	        CallableStatement userLogin = cn.prepareCall(
	            "select * from account where username = ? and password = ? ");
	        userLogin.setString(1, jTextField1.getText());
	        userLogin.setString(2, new String(jPasswordField1.getPassword())); 
	        ResultSet rs = userLogin.executeQuery();

	        if (rs.next()) {
	            // If a matching record is found, show a welcome message and open the AttendFrame
	            JOptionPane.showMessageDialog(this, "Welcome");

	            EmployeeFrame af = new EmployeeFrame();
	            af.setVisible(true); // Use setVisible instead of show
	            this.dispose(); // Close the current frame
	        } else {
	            // If no matching record is found, show an error message
	            JOptionPane.showMessageDialog(this, "Invalid Username or Password or User doesn't exist", "Invalid",
	                    JOptionPane.WARNING_MESSAGE);
	        }

	        // Close the ResultSet and CallableStatement
	        rs.close();
	        userLogin.close();
	    } catch (SQLException ex) {
	        // Handle SQL exceptions
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error during login", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void EmployeeClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		jPanel1buttons.setVisible(true);
		jPanel2teacher.setVisible(false);
		jPanel3admin.setVisible(false);

		jTextField1.setText("");
		jPasswordField1.setText("");

	}

	private void AdminClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		
		jPanel1buttons.setVisible(true);
		jPanel2teacher.setVisible(false);
		jPanel3admin.setVisible(false);

		jTextField2.setText("");
		jPasswordField2.setText("");
	}

	private void AdminloginButtonActionPerformed(java.awt.event.ActionEvent evt) {
	    try (Connection connection = JdbcUlti.getConnection();
	         PreparedStatement adminLogin = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?")) {

	        adminLogin.setString(1, jTextField2.getText());
	        adminLogin.setString(2, new String(jPasswordField2.getPassword()));

	        try (ResultSet rs = adminLogin.executeQuery()) {
	            if (rs.next()) {
	                JOptionPane.showMessageDialog(this, "Welcome");

	                AdminFrame adminf = new AdminFrame();
	                adminf.setVisible(true);
	                this.dispose();
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Invalid",
	                        JOptionPane.WARNING_MESSAGE);
	            }
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error during login", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


	private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	        try {
	            Connection connection = JdbcUlti.getConnection();
	            CallableStatement userLogin = connection.prepareCall(
	                    "select * from tbl_teacher where user_name = ? and teacher_pass = ? and teacher_status = 'true'");
	            userLogin.setString(1, jTextField1.getText());
	            userLogin.setString(2, new String(jPasswordField1.getPassword()));

	            ResultSet rs = userLogin.executeQuery();

	            if (rs.next()) {
	                JOptionPane.showMessageDialog(this, "Welcome");

	                AttendFrame af = new AttendFrame();
	                af.setVisible(true);
	                this.dispose();
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid Username or Password or User doesn't exist", "Invalid",
	                        JOptionPane.WARNING_MESSAGE);
	            }

	            rs.close();
	            userLogin.close();
	            connection.close();

	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error during login", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
	        // Login Match for Admin
	        try {
	            Connection connection = JdbcUlti.getConnection(); 

	            CallableStatement adminLogin = connection.prepareCall(
	                    "select * from tbl_admin where admin_name = ? and admin_pass = ?");
	            adminLogin.setString(1, jTextField2.getText());
	            adminLogin.setString(2, new String(jPasswordField2.getPassword()));

	            ResultSet rs = adminLogin.executeQuery();

	            if (rs.next()) {
	                JOptionPane.showMessageDialog(this, "Welcome");

	                AdminFrame adminf = new AdminFrame();
	                adminf.setVisible(true); // Use setVisible instead of show
	                this.dispose();
	            } else {
	                JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Invalid",
	                        JOptionPane.WARNING_MESSAGE);
	            }

	            rs.close();
	            adminLogin.close();
	            connection.close(); // Close the connection
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Error during login", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
	private void jButtonTeacherActionPerformed(java.awt.event.ActionEvent evt) {
		jPanel1buttons.setVisible(false);
		jPanel2teacher.setVisible(true);
		jPanel3admin.setVisible(false);
	}// GEN-LAST:event_jButtonTeacherActionPerformed

	private void jButtonAdminActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAdminActionPerformed
		// TODO add your handling code here:
		jPanel1buttons.setVisible(false);
		jPanel2teacher.setVisible(false);
		jPanel3admin.setVisible(true);
	}// GEN-LAST:event_jButtonAdminActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		// JOption Pane Font
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Candara", Font.PLAIN, 17)));

		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		// Default Look and Feel
		/*
		 * try { for (javax.swing.UIManager.LookAndFeelInfo info :
		 * javax.swing.UIManager.getInstalledLookAndFeels()) { if
		 * ("Nimbus".equals(info.getName())) {
		 * javax.swing.UIManager.setLookAndFeel(info.getClassName()); break; } } } catch
		 * (ClassNotFoundException ex) {
		 * java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.
		 * logging.Level.SEVERE, null, ex); } catch (InstantiationException ex) {
		 * java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.
		 * logging.Level.SEVERE, null, ex); } catch (IllegalAccessException ex) {
		 * java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.
		 * logging.Level.SEVERE, null, ex); } catch
		 * (javax.swing.UnsupportedLookAndFeelException ex) {
		 * java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.
		 * logging.Level.SEVERE, null, ex); } try {
		 * UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel"); }
		 * catch (javax.swing.UnsupportedLookAndFeelException ex) {
		 * java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.
		 * logging.Level.SEVERE, null, ex); } catch (ClassNotFoundException ex) {
		 * Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex); }
		 * catch (InstantiationException ex) {
		 * Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex); }
		 * catch (IllegalAccessException ex) {
		 * Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex); }
		 */
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LoginFrame().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton AdminClearButton;
	private javax.swing.JLabel AdminPanelBG;
	private javax.swing.JButton AdminloginButton;
	private javax.swing.JLabel LoginFrame;
	private javax.swing.JLabel MainLayerBG;
	private javax.swing.JButton EmployeeClearButton;
	private javax.swing.JButton EmployeeLoginButton;
	private javax.swing.JLabel TeacherPanelBG;
	private javax.swing.JButton jButtonAdmin;
	private javax.swing.JButton jButtonEmployee;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JPanel jPanel1buttons;
	private javax.swing.JPanel jPanel2teacher;
	private javax.swing.JPanel jPanel3admin;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JPasswordField jPasswordField2;
	public static javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables
}