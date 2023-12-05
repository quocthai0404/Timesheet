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


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
	private JButton btnTimekeeping_info;
	private JPanel panel_employee_management;


	private Create_Employee_Account Create_Employee_Account_panel;

	private Review_Leave_Request Review_Leave_Request;

	private Manage_Employee_Work_Schedule Manage_Employee_Work_Schedule;



	private JPanel panel_timekeeping_info;
	private JScrollPane scrollPane;
	private JTable tableEmployee;
	private Double totalPage;
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblStatusPage;
	private int firstPage = 1;
	private int rowOfPage = 10;
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
//	private JButton btnCreateEmpAcc;
//	private JButton btnUpdateEmp;

	public MainJFrame() {
		setTitle("Manager Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Tạo thanh category bên trái
		categoryPanel = new JPanel();
		categoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		btnCreate_employee_account = new JButton("<html>Create Employee<br>&nbsp &nbsp &nbsp Account</html>");
		btnCreate_employee_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnEmployee_management = new JButton("Employee Management");
		btnEmployee_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}

		});

		btnEmployee_management.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(btnEmployee_management);
		btnCreate_employee_account.setHorizontalTextPosition(SwingConstants.CENTER);

		btnCreate_employee_account.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnCreate_employee_account);
		btnEmp_work_schedule = new JButton("<html>Manage Employee <br>&nbsp Work Schedule</html>");
		btnEmp_work_schedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnEmp_work_schedule.setMinimumSize(new Dimension(10000, 70));
		btnEmp_work_schedule.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnEmp_work_schedule);
		btnReview_leave_reqs = new JButton("<html>Review Leave Requests </html>");
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
		categoryPanel.add(btnReview_leave_reqs);
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		// right
		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);
		panelContainer.setBorder(new LineBorder(new Color(0, 0, 0)));

		contentPane.add(categoryPanel, BorderLayout.WEST);

		btnTimekeeping_info = new JButton("Timekeeping information");
		btnTimekeeping_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});
		btnTimekeeping_info.setMinimumSize(new Dimension(10000, 70));
		btnTimekeeping_info.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(btnTimekeeping_info);
		contentPane.add(panelContainer, BorderLayout.CENTER);

		panel_employee_management = new JPanel();
		panelContainer.add(panel_employee_management, "panel_employee_management");

		scrollPane = new JScrollPane();

		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});

		lblStatusPage = new JLabel("1/?");

		textField_empName = new JTextField();
		textField_empName.setColumns(10);

		lblNewLabel = new JLabel("Employee Name:");

		textField_empID = new JTextField();
		textField_empID.setVisible(false);
		textField_empID.setColumns(10);

		lblNewLabel_1 = new JLabel("Position:");

		textField_Position = new JTextField();
		textField_Position.setColumns(10);

		textField_Position.setEditable(false);

		lblNewLabel_2 = new JLabel("Birthday:");

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

		lblNewLabel_5 = new JLabel("Gender:");

		rdbtnNewRadioButton = new JRadioButton("Male");

		rdbtnNewRadioButton_1 = new JRadioButton("Female");

		G = new ButtonGroup();
		G.add(rdbtnNewRadioButton);
		G.add(rdbtnNewRadioButton_1);

		btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddEmployeeActionPerformed(e);
			}
		});
		
		btnCreateEmpAcc = new JButton("Create Account");
		btnCreateEmpAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCreateEmpAccActionPerformed(e);
			}
		});
		
		btnUpdateEmp = new JButton("Update Employee");
		btnUpdateEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateEmpActionPerformed(e);
			}
		});

		GroupLayout gl_panel_employee_management = new GroupLayout(panel_employee_management);
		gl_panel_employee_management.setHorizontalGroup(
			gl_panel_employee_management.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_employee_management.createSequentialGroup()
					.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addGap(64)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_employee_management.createSequentialGroup()
									.addComponent(btnPrevious)
									.addGap(220)
									.addComponent(lblStatusPage)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnNext))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE))
							.addGap(56)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_employee_management.createSequentialGroup()
									.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblNewLabel_1)
										.addComponent(lblNewLabel_2)
										.addComponent(lblNewLabel_5))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_Position, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addComponent(textField_empName, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
										.addGroup(gl_panel_employee_management.createSequentialGroup()
											.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel_employee_management.createSequentialGroup()
													.addComponent(rdbtnNewRadioButton)
													.addGap(18)
													.addComponent(rdbtnNewRadioButton_1))
												.addGroup(gl_panel_employee_management.createSequentialGroup()
													.addComponent(comboBox_year, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
													.addComponent(lblNewLabel_3)
													.addGap(12)
													.addComponent(comboBox_Month, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboBox_Day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(btnAddEmployee, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnUpdateEmp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnCreateEmpAcc, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))))
					.addGap(76))
		);
		gl_panel_employee_management.setVerticalGroup(
			gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_employee_management.createSequentialGroup()
					.addGap(37)
					.addComponent(textField_empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_empName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addGap(35)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_Position, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(29)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(comboBox_year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_Day, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(comboBox_Month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(rdbtnNewRadioButton_1))
							.addGap(37)
							.addComponent(btnAddEmployee)
							.addGap(18)
							.addComponent(btnUpdateEmp)
							.addGap(18)
							.addComponent(btnCreateEmpAcc))
						.addGroup(gl_panel_employee_management.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panel_employee_management.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnPrevious)
								.addComponent(btnNext)
								.addComponent(lblStatusPage))))
					.addContainerGap(222, Short.MAX_VALUE))
		);
		

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


		panel_timekeeping_info = new JPanel();
		panelContainer.add(panel_timekeeping_info, "panel_timekeeping_info");

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
		
		Create_Employee_Account_panel.getValueFromPanel(textField_empID.getText(), textField_empName.getText(), textField_Position.getText());
		cardLayout.show(panelContainer, "panel_create_emp_acc");
		
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
