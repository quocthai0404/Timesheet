	package HR_view;
	
	import java.awt.Color;	
	import java.awt.Dimension;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
	import java.util.Base64;
	import java.util.Calendar;
	import java.util.Date;
import java.util.List;
import java.util.Locale;
	
	import javax.swing.JOptionPane;
	import javax.swing.table.DefaultTableCellRenderer;
	import javax.swing.table.DefaultTableModel;
	
	import DAO.EmployeeDAO;
import DAO.SalaryDAO;
import DAO.Work_scheduleDAO;
	import database.JdbcUlti;
	import entity.Employee;
import entity.Salary;
import entity.Work_schedule;
import helper.Helper;
	
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.JTextField;
	import java.awt.Font;
	import java.awt.Image;
	import java.awt.LayoutManager;
	
	import javax.swing.JLabel;
	import javax.swing.JButton;
	import javax.swing.ImageIcon;
	import javax.swing.JRadioButton;
	import javax.swing.JPanel;
	import javax.swing.JPasswordField;
	import javax.swing.border.LineBorder;
	import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.security.MessageDigest;
	import java.awt.event.ActionEvent;
	import javax.swing.JComboBox;
	import com.toedter.calendar.JDateChooser;
	
	
	public class Emp_salary extends javax.swing.JInternalFrame {
		JdbcUlti cn;
		private LayoutManager groupLayout;
		public Emp_salary() {
			getContentPane().setBackground(new Color(128, 255, 255));
			getContentPane().setForeground(new Color(128, 255, 255));
			initComponents();
			cn = new JdbcUlti();
			setTitle("Create Employee Account");
			statusCombo();
			loadData();
			
	
		}
		
		
	
		public void statusCombo() {
		}
	
		@SuppressWarnings("unchecked")
		
		private void initComponents() {
	
			setMaximumSize(new java.awt.Dimension(990, 550));
			setMinimumSize(new java.awt.Dimension(990, 550));
			setPreferredSize(new java.awt.Dimension(990, 550));
			getContentPane().setLayout(null);
	//		Image img = originalIcon.getImage().getScaledInstance(124, 30, Image.SCALE_SMOOTH);
	//		ImageIcon resizedIcon = new ImageIcon(img);
	
			
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 974, 76);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Emp_salary.class.getResource("/aptech_logo.png")));
			lblNewLabel.setBounds(10, 0, 154, 76);
			panel.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Employee Salary");
			lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
			lblNewLabel_1.setBounds(209, 11, 755, 54);
			panel.add(lblNewLabel_1);
	
	        getContentPane().setLayout(groupLayout);
	        
	        ImageIcon icon1 = new ImageIcon(HRFrame.class.getResource("/search.png"));
			Image img1 = icon1.getImage();
			Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon1 = new ImageIcon(newImg1);
	        
	        
	        ImageIcon refreshIcon = new ImageIcon(HRFrame.class.getResource("/refresh-page-option.png"));
			Image refreshImg = refreshIcon.getImage();
			Image newRefreshImg = refreshImg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);
	        
	        String choice[] = {"1 day", "Next 7 days"};
	        
	        scrollPane = new JScrollPane();
	        scrollPane.setBounds(115, 340, 737, 113);
	        getContentPane().add(scrollPane);
	        
	        table = new JTable();
	        table.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		tableMouseClicked(e);
	        	}
	        });
	        scrollPane.setViewportView(table);
	        
	        btnPrevious = new JButton("Previous");
	        btnPrevious.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnPreviousActionPerformed(e);
	        	}
	        });
	        btnPrevious.setBounds(115, 463, 85, 33);
	        getContentPane().add(btnPrevious);
	        
	        btnNext = new JButton("Next");
	        btnNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnNextActionPerformed(e);
	        	}
	        });
	        btnNext.setBounds(767, 463, 85, 33);
	        getContentPane().add(btnNext);
	        
	        Employee_ID = new JLabel();
	        Employee_ID.setText("Employee ID :");
	        Employee_ID.setForeground(Color.BLACK);
	        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
	        Employee_ID.setBounds(115, 106, 110, 30);
	        getContentPane().add(Employee_ID);
	        
	        Emp_Name = new JLabel();
	        Emp_Name.setText("Employee Name :");
	        Emp_Name.setForeground(Color.BLACK);
	        Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
	        Emp_Name.setBounds(115, 146, 110, 30);
	        getContentPane().add(Emp_Name);
	        
	        Position = new JLabel();
	        Position.setText("Position :");
	        Position.setForeground(Color.BLACK);
	        Position.setFont(new Font("Candara", Font.BOLD, 14));
	        Position.setBounds(115, 186, 110, 30);
	        getContentPane().add(Position);
	        
	        textField_name = new JTextField();
	        textField_name.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_name.setBounds(250, 146, 180, 30);
	        getContentPane().add(textField_name);
	        
	        textField_Position = new JTextField();
	        textField_Position.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_Position.setBounds(250, 186, 180, 30);
	        getContentPane().add(textField_Position);
	        
	        btnAddSalary = new JButton("Add Salary");
	        btnAddSalary.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnNewButton_1ActionPerformed(e);
	        	}
	        });
	        btnAddSalary.setBounds(115, 292, 110, 38);
	        getContentPane().add(btnAddSalary);
	        
	        dateChooser = new JDateChooser();
	        dateChooser.setBounds(609, 249, 180, 25);
	        dateChooser.setDateFormatString("yyyy-MM");
	        getContentPane().add(dateChooser);
	        
	        Emp_Name_1 = new JLabel();
	        Emp_Name_1.setText("Base Salary :");
	        Emp_Name_1.setForeground(Color.BLACK);
	        Emp_Name_1.setFont(new Font("Candara", Font.BOLD, 14));
	        Emp_Name_1.setBounds(500, 106, 110, 30);
	        getContentPane().add(Emp_Name_1);
	        
	        Emp_Name_2 = new JLabel();
	        Emp_Name_2.setText("Overtime Pay :");
	        Emp_Name_2.setForeground(Color.BLACK);
	        Emp_Name_2.setFont(new Font("Candara", Font.BOLD, 14));
	        Emp_Name_2.setBounds(500, 134, 110, 30);
	        getContentPane().add(Emp_Name_2);
	        
	        Emp_Name_3 = new JLabel();
	        Emp_Name_3.setText("Paid Leave Day :");
	        Emp_Name_3.setForeground(Color.BLACK);
	        Emp_Name_3.setFont(new Font("Candara", Font.BOLD, 14));
	        Emp_Name_3.setBounds(500, 171, 110, 30);
	        getContentPane().add(Emp_Name_3);
	        
	        Emp_Name_4 = new JLabel();
	        Emp_Name_4.setText("Allowance :");
	        Emp_Name_4.setForeground(Color.BLACK);
	        Emp_Name_4.setFont(new Font("Candara", Font.BOLD, 14));
	        Emp_Name_4.setBounds(500, 209, 110, 30);
	        getContentPane().add(Emp_Name_4);
	        
	        textField_baseSalary = new JTextField();
	        textField_baseSalary.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					keyChange();
	            }
			});
	        textField_baseSalary.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_baseSalary.setBounds(609, 106, 180, 24);
	        getContentPane().add(textField_baseSalary);
	        
	        textField_OvertimePay = new JTextField();
	        textField_OvertimePay.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_OvertimePay.setBounds(609, 136, 180, 26);
	        getContentPane().add(textField_OvertimePay);
	        
	        textField_paidLeaveDay = new JTextField();
	        textField_paidLeaveDay.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_paidLeaveDay.setBounds(609, 173, 180, 26);
	        getContentPane().add(textField_paidLeaveDay);
	        
	        Emp_Name_5 = new JLabel();
	        Emp_Name_5.setText("Year - Month :");
	        Emp_Name_5.setForeground(Color.BLACK);
	        Emp_Name_5.setFont(new Font("Candara", Font.BOLD, 14));
	        Emp_Name_5.setBounds(500, 247, 110, 30);
	        getContentPane().add(Emp_Name_5);
	        
	        btnViewSalaryDetails = new JButton("View Salary Details");
	        btnViewSalaryDetails.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnViewSalaryDetailsActionPerformed(e);
	        	}
	        });
	        btnViewSalaryDetails.setBounds(549, 292, 145, 38);
	        getContentPane().add(btnViewSalaryDetails);
	        
	        btnViewSalary = new JButton("View Salary");
	        btnViewSalary.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnViewSalaryActionPerformed(e);
	        	}
	        });
	        btnViewSalary.setBounds(407, 292, 110, 38);
	        getContentPane().add(btnViewSalary);
	        
	        btnUpdateSalary = new JButton("Update Salary");
	        btnUpdateSalary.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnUpdateSalaryActionPerformed(e);
	        	}
	        });
	        btnUpdateSalary.setBounds(250, 292, 130, 38);
	        getContentPane().add(btnUpdateSalary);
	        
	        textField_Allowance = new JTextField();
	        textField_Allowance.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_Allowance.setBounds(609, 211, 180, 26);
	        getContentPane().add(textField_Allowance);
	        
	        Employee_ID_1 = new JLabel();
	        Employee_ID_1.setForeground(Color.BLACK);
	        Employee_ID_1.setFont(new Font("Candara", Font.BOLD, 14));
	        Employee_ID_1.setBounds(250, 106, 110, 30);
	        getContentPane().add(Employee_ID_1);
	        
	        btnRefresh = new JButton();
	        btnRefresh.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnRefreshActionPerformed(e);
	        	}
	        });
	        btnRefresh.setFont(new Font("Candara", Font.BOLD, 12));
	        btnRefresh.setBorderPainted(false);
	        btnRefresh.setBorder(null);
	        btnRefresh.setBounds(716, 292, 37, 38);
	        btnRefresh.setIcon(newRefreshIcon);
	        getContentPane().add(btnRefresh);
	        
	        String descr[] = { "8h-12h", "13h-17h", "18h-22h", 
	        "22h-6h"};
	
			setBounds(0, 0, 990, 550);
		}
		private JTextField txtPassword;
		private JPanel panel;
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private int firstPage = 1;
		private int rowOfPage = 10;
		private Double totalPage;
		private JScrollPane scrollPane;
		private JTable table;
		private JButton btnPrevious;
		private JButton btnNext;
		private JLabel Employee_ID;
		private JLabel Emp_Name;
		private JLabel Position;
		private JTextField textField_name;
		private JTextField textField_Position;
		private JButton btnAddSalary;
		private JDateChooser dateChooser;
		private JLabel Emp_Name_1;
		private JLabel Emp_Name_2;
		private JLabel Emp_Name_3;
		private JLabel Emp_Name_4;
		private JTextField textField_baseSalary;
		private JTextField textField_OvertimePay;
		private JTextField textField_paidLeaveDay;
		private JLabel Emp_Name_5;
		private JButton btnViewSalaryDetails;
		private JButton btnViewSalary;
		private JButton btnUpdateSalary;
		private JTextField textField_Allowance;
		private JLabel Employee_ID_1;
		private JButton btnRefresh;
		
		
		
		protected void btnNextActionPerformed(ActionEvent e) {
			EmployeeDAO dao = new EmployeeDAO();
			totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
			if (firstPage < totalPage) {
				firstPage++;
			}

//			lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
			loadData();
		}
		protected void btnPreviousActionPerformed(ActionEvent e) {
			if (firstPage > 1) {
				firstPage--;
			}

//			lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
			loadData();
		}
		protected void btnNewButton_1ActionPerformed(ActionEvent e) {
			SalaryDAO dao = new SalaryDAO();
			if(dao.checkSalary(Integer.parseInt(Employee_ID_1.getText()))) {
				JOptionPane.showMessageDialog(null, "This employee already has a salary");
			}else {
				int id = Integer.parseInt(Employee_ID_1.getText());
				Double base = Double.parseDouble(textField_baseSalary.getText());
				Double overtime = Double.parseDouble(textField_OvertimePay.getText());
				Double paid = Double.parseDouble(textField_paidLeaveDay.getText());
				Double allow = Double.parseDouble(textField_Allowance.getText());
				dao.add(id,base , overtime, paid, allow);
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
//			lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
			table.setModel(model);
		}
		
		protected void tableMouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) {
				int row = table.getSelectedRow();
				Employee_ID_1.setText(table.getValueAt(row, 0).toString());
				textField_name.setText(table.getValueAt(row, 1).toString());
				textField_Position.setText(table.getValueAt(row, 2).toString());
				
				

			}
		}
		protected void btnViewSalaryActionPerformed(ActionEvent e) {
			SalaryDAO dao = new SalaryDAO();
			if(dao.checkSalary(Integer.parseInt(Employee_ID_1.getText()))) {
				Salary sl = new Salary();
				sl = dao.viewSalary(Integer.parseInt(Employee_ID_1.getText()));
				textField_baseSalary.setText(sl.getBase_salary()+"");
				textField_OvertimePay.setText(sl.getOvertime_pay()+"");
				textField_paidLeaveDay.setText(sl.getPaid_leave_pay()+"");
				textField_Allowance.setText(sl.getAllowance()+"");
			}else {
				JOptionPane.showMessageDialog(null, "This employee does not have salary");
			}
		}
		
		public void keyChange() {
			if(textField_baseSalary.getText().isBlank()) {
        		
        	}else {
        		Double base = Double.parseDouble(textField_baseSalary.getText());
        		Double overtime =  (double) Math.round(base/208.0 * 2);
        		Double paidLeave =  (double) Math.round(base/26.0);
        		Double allow =  (double) Math.round(base/10.0);
        		textField_OvertimePay.setText(overtime+"");
        		textField_paidLeaveDay.setText(paidLeave+"");
        		textField_Allowance.setText(allow+"");
        	}
		}
		protected void btnUpdateSalaryActionPerformed(ActionEvent e) {
			SalaryDAO dao = new SalaryDAO();
			if(dao.checkSalary(Integer.parseInt(Employee_ID_1.getText()))) {
				
				int id = Integer.parseInt(Employee_ID_1.getText());
				Double base = Double.parseDouble(textField_baseSalary.getText());
				Double overtime = Double.parseDouble(textField_OvertimePay.getText());
				Double paid = Double.parseDouble(textField_paidLeaveDay.getText());
				Double allow = Double.parseDouble(textField_Allowance.getText());
				dao.update(id,base , overtime, paid, allow);
			}else {
				JOptionPane.showMessageDialog(null, "This employee does not have salary");
			}
		}
		protected void btnViewSalaryDetailsActionPerformed(ActionEvent e) {
			Salary sl = new Salary();
			
			SalaryDAO dao = new SalaryDAO();
			sl = dao.viewSalary(Integer.parseInt(Employee_ID_1.getText()));
			Date date = dateChooser.getDate();
			int month = date.getMonth()+1;
			int year = date.getYear()+1900;
			int id = Integer.parseInt(Employee_ID_1.getText());
			
			int dayOff = dao.countDayOff(id, month, year);
			int dayOffUnPaid = dao.countDayOffUnpaid(id, month, year);
			int overtimeHour = dao.countOvertimeHour(id, month, year);
			Double deduction = dao.countDeduction(id, month, year);
			Double total = sl.getBase_salary() + sl.getPaid_leave_pay()*dayOff 
					+ sl.getOvertime_pay()*overtimeHour+ sl.getAllowance()-deduction ;
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Emp_ID");
			model.addColumn("Base Salary");
			model.addColumn("Paid_leave_day");
			model.addColumn("Overtime pay");
			model.addColumn("Allowance");
			model.addColumn("Paid Leave days");
			model.addColumn("Unpaid Leave days");
			model.addColumn("Overtime Hours");
			model.addColumn("Deduction");
			model.addColumn("Total");
			model.addRow(new Object[] {
					id, sl.getBase_salary(), sl.getPaid_leave_pay(), sl.getOvertime_pay(), sl.getAllowance(),
					dayOff, dayOffUnPaid, overtimeHour, deduction, total
			});
			table.setModel(model);
		}
		protected void btnRefreshActionPerformed(ActionEvent e) {
			loadData();
			Employee_ID_1.setText("");
			textField_name.setText("");
			textField_Position.setText("");
			textField_baseSalary.setText("");
			textField_OvertimePay.setText("");
			textField_paidLeaveDay.setText("");
			textField_Allowance.setText("");
			dateChooser.setDate(null);
			
		}
	}