package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AccountDAO;
import DAO.EmployeeDAO;

import DAO.LeaveDao;

import Validation.ValidateDate;
import database.JdbcUlti;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import view.Create_Employee_Account;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Font;


public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel panelContainer;
	private JPanel categoryPanel;
	private JButton btnEmployee_management;
	private JButton btnCreate_employee_account;
	private JButton btnEmp_work_schedule;
	private JButton btnReview_leave_reqs;
	private JPanel panel_employee_management;


	private Create_Employee_Account Create_Employee_Account_panel;

	private Review_Leave_Request Review_Leave_Request;

	private Manage_Employee_Work_Schedule Manage_Employee_Work_Schedule;
	private JScrollPane scrollPane;
	private JTable tableEmployee;
	private Double totalPage;
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblStatusPage;
	private int firstPage = 1;
	private int rowOfPage = 25;
	private JTextField textField_empName;
	private JLabel lblNewLabel;
	private JTextField textField_empID;
	private JLabel lblNewLabel_1;
	private JTextField textField_Position;
	private JLabel lblNewLabel_2;
	private JComboBox comboBox_year;
	private JComboBox comboBox_Month;
	private JComboBox comboBox_Day;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JButton btnAddEmployee;
	private ButtonGroup G;
	private ValidateDate valid = new ValidateDate();

	//-----------------------
	private String yearSelected;
	private String monthSelected;
	private String daySelected;
	private JButton btnUpdateEmp;
	private JButton btnCreateEmpAcc;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel jPanel23;
	private JLabel lblEmployeeManagement;
	private JPanel panel_2;
	private JLabel lblLogo;
//	private JButton btnCreateEmpAcc;
//	private JButton btnUpdateEmp;

	public MainJFrame() {
		setBackground(new Color(255, 255, 255));
		setTitle("Manager Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 743);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Tạo thanh category bên trái
		categoryPanel = new JPanel();
		categoryPanel.setBackground(new Color(255, 255, 255));
		categoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCreate_employee_account = new JButton("<html>Create Employee<br>&nbsp &nbsp &nbsp Account</html>");
		btnCreate_employee_account.setBackground(new Color(255, 255, 255));
		btnCreate_employee_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnEmployee_management = new JButton("Employee Management");
		btnEmployee_management.setBackground(new Color(255, 255, 255));
		btnEmployee_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}

		});

		btnEmployee_management.setMaximumSize(new Dimension(10000, 70));
		btnCreate_employee_account.setHorizontalTextPosition(SwingConstants.CENTER);

		btnCreate_employee_account.setMaximumSize(new Dimension(1000000, 70));
		btnEmp_work_schedule = new JButton("<html>Manage Employee <br>&nbsp Work Schedule</html>");
		btnEmp_work_schedule.setBackground(new Color(255, 255, 255));
		btnEmp_work_schedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnEmp_work_schedule.setMinimumSize(new Dimension(10000, 70));
		btnEmp_work_schedule.setMaximumSize(new Dimension(1000000, 70));
		btnReview_leave_reqs = new JButton("<html>Review Leave Requests </html>");
		btnReview_leave_reqs.setBackground(new Color(255, 255, 255));
		btnReview_leave_reqs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnReview_leave_reqsMouseClicked(e);
			}
		});
		btnReview_leave_reqs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnReview_leave_reqs.setMaximumSize(new Dimension(10000, 70));

		btnReview_leave_reqs.setMinimumSize(new Dimension(10000, 70));
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		// right
		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);
		panelContainer.setBorder(new LineBorder(new Color(0, 0, 0)));

		contentPane.add(categoryPanel, BorderLayout.WEST);
		
		panel_2 = new JPanel();
		GroupLayout gl_categoryPanel = new GroupLayout(categoryPanel);
		gl_categoryPanel.setHorizontalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addGroup(gl_categoryPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnReview_leave_reqs, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnEmp_work_schedule, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnCreate_employee_account, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
						.addComponent(btnEmployee_management, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_categoryPanel.setVerticalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEmployee_management, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCreate_employee_account, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEmp_work_schedule, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnReview_leave_reqs, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addGap(289))
		);
		
		lblLogo = new JLabel("");
		ImageIcon logoIcon = new ImageIcon("C:\\Users\\Admin\\git\\Timesheet\\lib\\EMPLOYEE.png");

		// Resize the logo to your preferred dimensions (e.g., 128x128)
		Image img = logoIcon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(img);

		lblLogo.setIcon(logoIcon);
		lblLogo.setPreferredSize(new Dimension(128, 128));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		categoryPanel.setLayout(gl_categoryPanel);
		contentPane.add(panelContainer, BorderLayout.CENTER);

		panel_employee_management = new JPanel();
		panel_employee_management.setBackground(new Color(0, 255, 255));
		panelContainer.add(panel_employee_management, "panel_employee_management");

		scrollPane = new JScrollPane();

		btnPrevious = new JButton("Previous");
		btnPrevious.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});

		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});

		lblStatusPage = new JLabel("1/?");

		comboBox_year = new JComboBox();
		comboBox_year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_yearActionPerformed(e);
			}
		});
		for (Integer years = 1950; years <= Calendar.getInstance().get(Calendar.YEAR); years++) {
			comboBox_year.addItem(years.toString());
		}
		comboBox_year.setSelectedIndex(0);

		comboBox_Month = new JComboBox();
		comboBox_Month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_MonthActionPerformed(e);
			}
		});
		comboBox_Month.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		comboBox_Month.setSelectedIndex(0);

		comboBox_Day = new JComboBox();
		comboBox_Day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_DayActionPerformed(e);
			}
		});
		comboBox_Day.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		comboBox_Day.setSelectedIndex(0);

		lblNewLabel_3 = new JLabel("-");

		lblNewLabel_4 = new JLabel("-");

		G = new ButtonGroup();
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setForeground(new Color(255, 255, 255));
		
				lblNewLabel_2 = new JLabel("Birthday:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 128));
		
		jPanel23 = new JPanel();
		jPanel23.setBackground(Color.BLACK);
		
		lblEmployeeManagement = new JLabel();
		lblEmployeeManagement.setText("Employee Management");
		lblEmployeeManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeManagement.setForeground(Color.WHITE);
		lblEmployeeManagement.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmployeeManagement.setBackground(Color.BLACK);
		GroupLayout gl_jPanel23 = new GroupLayout(jPanel23);
		gl_jPanel23.setHorizontalGroup(
			gl_jPanel23.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 919, Short.MAX_VALUE)
				.addGroup(gl_jPanel23.createSequentialGroup()
					.addGap(50)
					.addComponent(lblEmployeeManagement, GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_jPanel23.setVerticalGroup(
			gl_jPanel23.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_jPanel23.createSequentialGroup()
					.addComponent(lblEmployeeManagement, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
					.addContainerGap())
		);
		jPanel23.setLayout(gl_jPanel23);

		GroupLayout gl_panel_employee_management = new GroupLayout(panel_employee_management);
		gl_panel_employee_management.setHorizontalGroup(
			gl_panel_employee_management.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_employee_management.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.TRAILING)
						.addComponent(jPanel23, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
								.addGroup(gl_panel_employee_management.createSequentialGroup()
									.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(180)
									.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addGap(210)
									.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_employee_management.createSequentialGroup()
									.addGap(119)
									.addComponent(lblNewLabel_3)
									.addGap(50)
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_employee_management.createSequentialGroup()
									.addGap(40)
									.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
										.addGroup(gl_panel_employee_management.createSequentialGroup()
											.addGap(10)
											.addComponent(lblNewLabel_2)
											.addGap(51)
											.addComponent(comboBox_year, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(comboBox_Month, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox_Day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addGap(64))
		);
		gl_panel_employee_management.setVerticalGroup(
			gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_employee_management.createSequentialGroup()
					.addGap(20)
					.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_Month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_Day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addGap(18)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(1)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnPrevious, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
									.addComponent(lblStatusPage))
								.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))))
					.addGap(201))
		);
		
				btnAddEmployee = new JButton("Add Employee");
				btnAddEmployee.setBackground(new Color(255, 255, 255));
				btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 12));
				btnAddEmployee.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAddEmployeeActionPerformed(e);
					}
				});
		
		btnUpdateEmp = new JButton("Update Employee");
		btnUpdateEmp.setBackground(new Color(255, 255, 255));
		btnUpdateEmp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateEmpActionPerformed(e);
			}
		});
		
		btnCreateEmpAcc = new JButton("Create Account");
		btnCreateEmpAcc.setBackground(new Color(255, 255, 255));
		btnCreateEmpAcc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreateEmpAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateEmpAccActionPerformed(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCreateEmpAcc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(btnUpdateEmp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(btnAddEmployee, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
					.addGap(35))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAddEmployee, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(btnUpdateEmp, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCreateEmpAcc, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panel_1.setLayout(gl_panel_1);
		
				lblNewLabel = new JLabel("Employee Name:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				textField_empName = new JTextField();
				textField_empName.setColumns(10);
		
				lblNewLabel_1 = new JLabel("Position:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				textField_Position = new JTextField();
				textField_Position.setColumns(10);
				
						textField_Position.setEditable(false);
		
				lblNewLabel_5 = new JLabel("Gender:");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
				rdbtnNewRadioButton = new JRadioButton("Male");
				rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
				G.add(rdbtnNewRadioButton);
		
				rdbtnNewRadioButton_1 = new JRadioButton("Female");
				rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
				G.add(rdbtnNewRadioButton_1);
		
				textField_empID = new JTextField();
				textField_empID.setBackground(new Color(192, 192, 192));
				textField_empID.setVisible(false);
				textField_empID.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_empName, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
									.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
									.addComponent(rdbtnNewRadioButton_1)
									.addGap(41))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_Position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(101, Short.MAX_VALUE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(198, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_Position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField_empName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(42)))
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		

		tableEmployee = new JTable();
		tableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableEmployeeMouseClicked(e);
			}
		});
		scrollPane.setViewportView(tableEmployee);
		panel_employee_management.setLayout(gl_panel_employee_management);
		loadData();


		Create_Employee_Account_panel = new Create_Employee_Account();
		panelContainer.add(Create_Employee_Account_panel, "panel_create_emp_acc");
		


		Review_Leave_Request = new Review_Leave_Request();
		panelContainer.add(Review_Leave_Request, "panel_review_leave_reqs");
		
		Manage_Employee_Work_Schedule = new Manage_Employee_Work_Schedule();
		panelContainer.add(Manage_Employee_Work_Schedule, "panel_emp_work_schedule");

		setPreferredSize(new Dimension(1250, 800));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected void btnClickSwitchPanel(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnEmployee_management)) {
			cardLayout.show(panelContainer, "panel_employee_management");
		} else if (src.equals(btnCreate_employee_account)) {
			cardLayout.show(panelContainer, "panel_create_emp_acc");
		} else if (src.equals(btnEmp_work_schedule)) {
			cardLayout.show(panelContainer, "panel_emp_work_schedule");
		} else if (src.equals(btnReview_leave_reqs)) {
			cardLayout.show(panelContainer, "panel_review_leave_reqs");
		} else {
			cardLayout.show(panelContainer, "panel_timekeeping_info");
		}

	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Employee Name");
		model.addColumn("Position");
		model.addColumn("Birthday");
		model.addColumn("Gender");
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.selectPaginateEmp(firstPage, rowOfPage).stream().forEach(emp -> {
			String gender = emp.getGender() ? "Male" : "Female";
			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
					emp.getBirthday(), gender });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		tableEmployee.setModel(model);
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

	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}

	protected void comboBox_yearActionPerformed(ActionEvent e) {
		yearSelected = comboBox_year.getSelectedItem().toString();
	}

	protected void comboBox_MonthActionPerformed(ActionEvent e) {
		monthSelected = comboBox_Month.getSelectedItem().toString();
	}

	protected void comboBox_DayActionPerformed(ActionEvent e) {
		daySelected = comboBox_Day.getSelectedItem().toString();
	}

	protected void btnAddEmployeeActionPerformed(ActionEvent e) {

		if(textField_empName.getText().isEmpty()||textField_Position.getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
			return;

		}

		if(textField_Position.getText().toUpperCase().equals("manager".toUpperCase())) {
			JOptionPane.showMessageDialog(null, "cannot to add manager");
			return;
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDAO empDAO = new EmployeeDAO();
		Boolean gender = rdbtnNewRadioButton.isSelected() ? true : false;
		if(valid.checkDate(yearSelected, monthSelected, daySelected)) {
			Date date = null;
			try {
				date = df.parse(yearSelected+"-"+monthSelected+"-"+daySelected);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			System.out.println(year);
			if(Calendar.getInstance().get(Calendar.YEAR)-year<18) {
				JOptionPane.showMessageDialog(null, "Employee age must be greater than 18");
				return;
			}
			empDAO.add(textField_empName.getText(), textField_Position.getText(), date, gender);
			loadData();
		}else {
			JOptionPane.showMessageDialog(null, "Invalid date");
		}
		
		

	}

	protected void tableEmployeeMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = tableEmployee.getSelectedRow();
			textField_empID.setText(tableEmployee.getValueAt(row, 0).toString());
			textField_empName.setText(tableEmployee.getValueAt(row, 1).toString());
			textField_Position.setText(tableEmployee.getValueAt(row, 2).toString());

			String date = tableEmployee.getValueAt(row, 3).toString();
			String[] parts = date.split("-");

			comboBox_year.setSelectedIndex(Integer.parseInt(parts[0]) - 1950);
			comboBox_Month.setSelectedIndex(Integer.parseInt(parts[1]) - 1);
			comboBox_Day.setSelectedIndex(Integer.parseInt(parts[2]) - 1);

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
				Create_Employee_Account_panel.getValueFromPanel(textField_empID.getText(), textField_empName.getText(), textField_Position.getText());
				cardLayout.show(panelContainer, "panel_create_emp_acc");
			}
			JdbcUlti.closeConnection(con);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
	}
	
	protected void btnUpdateEmpActionPerformed(ActionEvent e) {
		if(textField_empName.getText().isEmpty()||textField_Position.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
			return;
		}
		if(textField_Position.getText().toUpperCase().equals("manager".toUpperCase())) {
			JOptionPane.showMessageDialog(null, "cannot to update manager");
			return;
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		EmployeeDAO empDAO = new EmployeeDAO();
		Boolean gender = rdbtnNewRadioButton.isSelected() ? true : false;
		if(valid.checkDate(yearSelected, monthSelected, daySelected)) {
			Date date = null;
			try {
				date = df.parse(yearSelected+"-"+monthSelected+"-"+daySelected);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			System.out.println(year);
			if(Calendar.getInstance().get(Calendar.YEAR)-year<18) {
				JOptionPane.showMessageDialog(null, "Employee age must be greater than 18");
				return;
			}
			empDAO.update(Integer.parseInt(textField_empID.getText()), textField_empName.getText(), textField_Position.getText(), date, gender);
			loadData();
		}else {
			JOptionPane.showMessageDialog(null, "Invalid date");
		}
	}
	
	 
	
	protected void btnReview_leave_reqsMouseClicked(MouseEvent e) {
	}
	
}