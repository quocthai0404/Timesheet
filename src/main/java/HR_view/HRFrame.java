/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HR_view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import DAO.EmployeeDAO;
import database.JdbcUlti;
import view.AdminFrame;
import view.Create_Employee_Account;
import view.LoginFrame;

import javax.swing.JTable;

public class HRFrame extends javax.swing.JFrame {
    JdbcUlti cn;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Horizontal_Panel;
    private javax.swing.JPanel Vertical_Panel;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private JLabel lblLogo;
    private JLabel lblNewLabel;
    private JButton jButton1;
    private ButtonGroup G;
    private JPanel panel;
    private JLabel lblLogo_1;
    private JLabel lblNewLabel_1;
    private JLabel Employee_ID;
    private JLabel textField_empID;
    private JLabel Emp_Name;
    private JTextField textField_empName;
    private JLabel Position;
    private JTextField textField_Position;
    private JRadioButton rdbtnNewRadioButton;
    private JLabel Gender;
    private JRadioButton rdbtnNewRadioButton_1;
    private JLabel Birthday;
    private JDateChooser dateChooser;
    private JScrollPane jScrollPane1;
    private JButton btnAddEmployee;
    private JButton btnCreateEmpAcc;
    private JButton btnUpdateEmp;
    private JButton btnRefresh;
    private JTextField textFind;
    private JButton jButtonFind;
    private JTable tableEmployee;
    private JButton btnPrevious;
    private JButton btnNext;
    private JLabel lblStatusPage;
    private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;

    /**
     * Creates new form HRFrame
     */
    public HRFrame() {
        getContentPane().setBackground(new Color(0, 255, 255));
        initComponents();
        cn = new JdbcUlti();

        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(getClass().getResource("/attendancems_with_prepared22/Project_Images/Logo.png")));
        setResizable(false);

        setTitle("Employee Panel");

        DateFormat dateFormat = new SimpleDateFormat("EEEE',' dd MMMMMM yyyy");
        Date date = new Date();

        Thread t = new Thread() {
            public void run() {
                for (;;) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println(ex.toString());
                    }
                    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
                    Calendar cal = Calendar.getInstance();
                }
            }
        };
        t.start();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(128, 255, 255));
        Vertical_Panel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jButton4ActionPerformed(e);
        	}
        });
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Horizontal_Panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        jDesktopPane1.setMaximumSize(new java.awt.Dimension(990, 550));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(990, 550));

        jPanel1.setLayout(null);

        jDesktopPane1.add(jPanel1);
        jPanel1.setBounds(0, 0, 990, 550);

        ImageIcon icon = new ImageIcon(HRFrame.class.getResource("/create.png"));
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(110, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newImg);

        ImageIcon icon1 = new ImageIcon(HRFrame.class.getResource("/search.png"));
        Image img1 = icon1.getImage();
        Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon1 = new ImageIcon(newImg1);

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(200, 100, 990, 550);

        Vertical_Panel.setBackground(new Color(108, 108, 255));
        Vertical_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        Vertical_Panel.setMaximumSize(new java.awt.Dimension(800, 100));
        Vertical_Panel.setMinimumSize(new java.awt.Dimension(800, 100));
        Vertical_Panel.setPreferredSize(new java.awt.Dimension(800, 100));
        Vertical_Panel.setLayout(null);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new Font("Candara", Font.BOLD, 14));
        jButton4.setText("EXIT");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        Vertical_Panel.add(jButton4);
        jButton4.setBounds(10, 400, 160, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new Font("Candara", Font.BOLD, 14));
        jButton2.setText("<html>Work Schedule</html>");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));

        Vertical_Panel.add(jButton2);
        jButton2.setBounds(10, 240, 160, 48);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new Font("Candara", Font.BOLD, 14));
        jButton3.setText("<html>View Salary</html>");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4, true));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Vertical_Panel.add(jButton3);
        jButton3.setBounds(10, 320, 160, 48);

        getContentPane().add(Vertical_Panel);
        Vertical_Panel.setBounds(0, 100, 200, 550);

        lblLogo = new JLabel("");
        ImageIcon logoIcon = new ImageIcon(HRFrame.class.getResource("/EMPLOYEE.png"));
        Image img2 = logoIcon.getImage().getScaledInstance(200, 139, Image.SCALE_SMOOTH);
        logoIcon = new ImageIcon(img2);
        lblLogo.setIcon(logoIcon);
        lblLogo.setPreferredSize(new Dimension(200, 139));
        lblLogo.setBounds(0, 0, 200, 139);
        Vertical_Panel.add(lblLogo);

        jButton1 = new JButton("Manager All Employee");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 4));
        jButton1.setFont(new Font("Candara", Font.BOLD, 14));
        jButton1.setBounds(10, 160, 160, 48);
        Vertical_Panel.add(jButton1);

        Horizontal_Panel.setBackground(new Color(255, 255, 255));
        Horizontal_Panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true));
        Horizontal_Panel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Candara", 1, 48));
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setText("Employee Attendance System");
        Horizontal_Panel.add(jLabel1);
        jLabel1.setBounds(271, 20, 700, 70);

        getContentPane().add(Horizontal_Panel);
        Horizontal_Panel.setBounds(0, 0, 1190, 100);

        lblNewLabel = new JLabel("");
        ImageIcon aptechLogoIcon = new ImageIcon(HRFrame.class.getResource("/aptech_logo.png"));
        Image img21 = aptechLogoIcon.getImage().getScaledInstance(140, 62, Image.SCALE_SMOOTH);
        aptechLogoIcon = new ImageIcon(img21);
        lblNewLabel.setIcon(aptechLogoIcon);
        lblNewLabel.setBounds(10, 11, 150, 79);
        Horizontal_Panel.add(lblNewLabel);
        G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);
		
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 980, 76);
        jPanel1.add(panel);

        lblLogo_1 = new JLabel("");
        lblLogo_1.setIcon(new ImageIcon(HRFrame.class.getResource("/aptech_logo.png")));
        lblLogo_1.setBounds(10, 0, 154, 76);
        panel.add(lblLogo_1);

        lblNewLabel_1 = new JLabel("Manager Page");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(233, 22, 341, 54);
        panel.add(lblNewLabel_1);

        Employee_ID = new JLabel();
        Employee_ID.setText("Employee ID :");
        Employee_ID.setForeground(Color.BLACK);
        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
        Employee_ID.setBounds(75, 124, 110, 30);
        jPanel1.add(Employee_ID);

        textField_empID = new JLabel();
        textField_empID.setForeground(Color.BLACK);
        textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
        textField_empID.setBounds(205, 124, 180, 30);
        jPanel1.add(textField_empID);

        Emp_Name = new JLabel();
        Emp_Name.setText("Employee Name :");
        Emp_Name.setForeground(Color.BLACK);
        Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
        Emp_Name.setBounds(75, 171, 110, 30);
        jPanel1.add(Emp_Name);

        textField_empName = new JTextField();
        textField_empName.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_empName.setBounds(205, 171, 180, 30);
        jPanel1.add(textField_empName);

        Position = new JLabel();
        Position.setText("Position :");
        Position.setForeground(Color.BLACK);
        Position.setFont(new Font("Candara", Font.BOLD, 14));
        Position.setBounds(75, 212, 110, 30);
        jPanel1.add(Position);

        textField_Position = new JTextField();
        textField_Position.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_Position.setBounds(205, 212, 180, 30);
        jPanel1.add(textField_Position);

        rdbtnNewRadioButton = new JRadioButton("Male");
        rdbtnNewRadioButton.setBackground(new Color(128, 255, 255));
        rdbtnNewRadioButton.setBounds(547, 178, 72, 23);
        jPanel1.add(rdbtnNewRadioButton);

        Gender = new JLabel();
        Gender.setText("Gender");
        Gender.setForeground(Color.BLACK);
        Gender.setFont(new Font("Candara", Font.BOLD, 14));
        Gender.setBounds(450, 177, 91, 30);
        jPanel1.add(Gender);

        rdbtnNewRadioButton_1 = new JRadioButton("Female");
        rdbtnNewRadioButton_1.setBackground(new Color(128, 255, 255));
        rdbtnNewRadioButton_1.setBounds(626, 178, 90, 23);
        jPanel1.add(rdbtnNewRadioButton_1);

        Birthday = new JLabel();
        Birthday.setText("Birthday");
        Birthday.setForeground(Color.BLACK);
        Birthday.setFont(new Font("Candara", Font.BOLD, 14));
        Birthday.setBounds(450, 218, 91, 30);
        jPanel1.add(Birthday);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(551, 218, 180, 30);
        jPanel1.add(dateChooser);

        jScrollPane1 = new JScrollPane();
        jScrollPane1.setOpaque(false);
        jScrollPane1.setBounds(75, 308, 860, 170);
        jPanel1.add(jScrollPane1);
        
        tableEmployee = new JTable();
		tableEmployee.setRowHeight(30);
		tableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableEmployeeMouseClicked(e);
			}
		});
        jScrollPane1.setViewportView(tableEmployee);

        btnAddEmployee = new JButton();
        btnAddEmployee.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnAddEmployeeActionPerformed(e);
        	}
        });
        btnAddEmployee.setIcon(new ImageIcon(HRFrame.class.getResource("/add.png")));
        btnAddEmployee.setFont(new Font("Candara", Font.BOLD, 12));
        btnAddEmployee.setBorderPainted(false);
        btnAddEmployee.setBorder(null);
        btnAddEmployee.setBounds(75, 267, 110, 30);
        jPanel1.add(btnAddEmployee);
        
        ImageIcon icon12 = new ImageIcon(AdminFrame.class.getResource("/create.png"));
		Image img12 = icon.getImage();
		Image newImg12 = img.getScaledInstance(110, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon12 = new ImageIcon(newImg);
		btnCreateEmpAcc = new JButton();
		btnCreateEmpAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateEmpAccActionPerformed(e);
			}
		});
		btnCreateEmpAcc.setIcon(newIcon);
		btnCreateEmpAcc.setFont(new Font("Candara", Font.BOLD, 12));
		btnCreateEmpAcc.setBorderPainted(false);
		btnCreateEmpAcc.setBorder(null);
		btnCreateEmpAcc.setBounds(205, 267, 110, 30); // Đặt kích thước JButton tùy thuộc vào kích thước của ảnh

        jPanel1.add(btnCreateEmpAcc);
        
        btnUpdateEmp = new JButton();
        btnUpdateEmp.setIcon(new ImageIcon(HRFrame.class.getResource("/update.png")));
        btnUpdateEmp.setFont(new Font("Candara", Font.BOLD, 12));
        btnUpdateEmp.setBorderPainted(false);
        btnUpdateEmp.setBorder(null);
        btnUpdateEmp.setBounds(338, 267, 110, 30);
        jPanel1.add(btnUpdateEmp);
        
        ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
		Image refreshImg = refreshIcon.getImage();
		Image newRefreshImg = refreshImg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);

		JButton btnRefresh = new JButton();
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		btnRefresh.setIcon(newRefreshIcon);
		btnRefresh.setFont(new Font("Candara", Font.BOLD, 12));
		btnRefresh.setBorderPainted(false);
		btnRefresh.setBorder(null);
		btnRefresh.setBounds(551, 267, 30, 30);
        jPanel1.add(btnRefresh);
        
        textFind = new JTextField();
        textFind.setFont(new Font("Calibri", Font.BOLD, 14));
        textFind.setBounds(591, 267, 180, 30);
        jPanel1.add(textFind);
        
        jButtonFind = new JButton();
        jButtonFind.setIcon(new ImageIcon(HRFrame.class.getResource("/view.png")));
        jButtonFind.setFont(new Font("Candara", Font.BOLD, 12));
        jButtonFind.setBorderPainted(false);
        jButtonFind.setBorder(null);
        jButtonFind.setBounds(781, 267, 30, 30);
        jPanel1.add(jButtonFind);
        
        btnPrevious = new JButton("Previous");
        btnPrevious.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnPreviousActionPerformed(e);
        	}
        });
        btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPrevious.setBounds(75, 495, 103, 33);
        jPanel1.add(btnPrevious);
        
        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNextActionPerformed(e);
        	}
        });
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNext.setBounds(833, 501, 103, 33);
        jPanel1.add(btnNext);
        
        lblStatusPage = new JLabel("1/3");
        lblStatusPage.setBounds(477, 505, 35, 14);
        jPanel1.add(lblStatusPage);
        setSize(new java.awt.Dimension(1206, 689));
        setLocationRelativeTo(null);
    }
    public void loadData() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Employee Name");
        model.addColumn("Position");
        model.addColumn("Birthday");
        model.addColumn("Gender");

        // Thay đổi tên class DAO và phương thức để phản ánh các thay đổi cần thiết
        EmployeeDAO dao = new EmployeeDAO();
        totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));

        dao.selectPaginateEmp(firstPage, rowOfPage).forEach(emp -> {
            String gender = emp.getGender() ? "Male" : "Female";
            model.addRow(new Object[]{emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
                    emp.getBirthday(), gender});
        });

        lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
        tableEmployee.setModel(model);
    }
	
    protected void tableEmployeeMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = tableEmployee.getSelectedRow();
			textField_empID.setText(tableEmployee.getValueAt(row, 0).toString());
			textField_empName.setText(tableEmployee.getValueAt(row, 1).toString());
			textField_Position.setText(tableEmployee.getValueAt(row, 2).toString());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = df.parse(tableEmployee.getValueAt(row, 3).toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			dateChooser.setDate(date);
			


			if (tableEmployee.getValueAt(row, 4).toString().equals("Male")) {
				rdbtnNewRadioButton.setSelected(true);
			} else {
				rdbtnNewRadioButton_1.setSelected(true);
			}
			
			if(textField_Position.getText().equals("manager")) {
				btnCreateEmpAcc.setEnabled(false);
			}else {
				btnCreateEmpAcc.setEnabled(true);
			}
		}
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
		loadData();
	}
	

	
	public void refreshAll() {
		textField_empID.setText("");
		textField_empName.setText("");
		textField_Position.setText("");
		dateChooser.setDate(null);
		G.clearSelection();
	}

	
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}
	
	protected void btnNextActionPerformed(ActionEvent e) {
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		if (firstPage < totalPage) {
			firstPage++;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();

	}
	
	protected void btnAddEmployeeActionPerformed(ActionEvent e) {
	    if (textField_empName.getText().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Employee name cannot be blank");
	        return;
	    }

	    // Kiểm tra và xử lý ngày sinh
	    Date date = dateChooser.getDate();
	    if (date == null) {
	        JOptionPane.showMessageDialog(null, "Invalid birthdate");
	        return;
	    }

	    int birthYear = date.getYear() + 1900;
	    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
	    if (currentYear - birthYear < 18) {
	        JOptionPane.showMessageDialog(null, "Employee age must be greater than 18");
	        return;
	    }

	    // Thêm nhân viên với chức vụ mặc định là "employee"
	    EmployeeDAO empDAO = new EmployeeDAO();
	    Boolean gender = rdbtnNewRadioButton.isSelected();
	    empDAO.add(textField_empName.getText(), "employee", date, gender);

	    // Tải lại dữ liệu và làm mới giao diện
	    loadData();
	    refreshAll();
	}

	protected void btnCreateEmpAccActionPerformed(ActionEvent e) {
		Connection con = null;
		try {
			con = JdbcUlti.getConnection();
            String sql = "SELECT * FROM account where employee_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(textField_empID.getText()));
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "This employee already has an account");
				return;
			}else {
				Create_Employee_Account create_employee_account = new Create_Employee_Account();
				create_employee_account.getValueFromPanel(textField_empID.getText(), 
						textField_empName.getText(), textField_Position.getText());
		        jDesktopPane1.removeAll();
		        jDesktopPane1.add(create_employee_account);
		        create_employee_account.show();
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	protected void jButton4ActionPerformed(ActionEvent e) {
		try {
	        int response = JOptionPane.showConfirmDialog(null,
	                "You have clicked Exit. \n Do you want to close the window?", "Confirm", JOptionPane.YES_NO_OPTION,
	                JOptionPane.QUESTION_MESSAGE);

	        if (response == JOptionPane.YES_OPTION) {

	            LoginFrame lf = new LoginFrame();
	            lf.show();
	            dispose();
	        } else if (response == JOptionPane.NO_OPTION) {
	            // Do nothing or handle accordingly
	        } else if (response == JOptionPane.CLOSED_OPTION) {
	            // Do nothing or handle accordingly
	        }
	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(rootPane, ex.toString());
	    }
	}
}
