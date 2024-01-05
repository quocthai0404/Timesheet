	package view;
	
	import java.awt.Color;	
	import java.awt.Dimension;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
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
	import DAO.Work_scheduleDAO;
	import database.JdbcUlti;
	import entity.Employee;
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
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.security.MessageDigest;
	import java.awt.event.ActionEvent;
	import javax.swing.JComboBox;
	import com.toedter.calendar.JDateChooser;
	
	
	public class Create_Work_Schedule extends javax.swing.JInternalFrame {
		JdbcUlti cn;
		private LayoutManager groupLayout;
		public Create_Work_Schedule() {
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
	
			Employee_ID = new javax.swing.JLabel();
			Emp_Name = new javax.swing.JLabel();
			Position = new javax.swing.JLabel();
			textField_empName = new javax.swing.JTextField();
	
			setMaximumSize(new java.awt.Dimension(990, 550));
			setMinimumSize(new java.awt.Dimension(990, 550));
			setPreferredSize(new java.awt.Dimension(990, 550));
			getContentPane().setLayout(null);
	
			Employee_ID.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
			Employee_ID.setForeground(new Color(0, 0, 0));
			Employee_ID.setText("Employee ID :");
			getContentPane().add(Employee_ID);
			Employee_ID.setBounds(73, 149, 110, 30);
	
			Emp_Name.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
			Emp_Name.setForeground(new Color(0, 0, 0));
			Emp_Name.setText("Employee Name :");
			getContentPane().add(Emp_Name);
			Emp_Name.setBounds(73, 199, 110, 30);
	
			Position.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
			Position.setForeground(new Color(0, 0, 0));
			Position.setText("Position :");
			getContentPane().add(Position);
			Position.setBounds(73, 239, 110, 30);
	
			textField_empName.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
		
			getContentPane().add(textField_empName);
			textField_empName.setBounds(221, 199, 145, 30);
			
			textField_Position = new JTextField();
			textField_Position.setFont(new Font("Calibri", Font.BOLD, 14));
			textField_Position.setBounds(221, 239, 145, 30);
			getContentPane().add(textField_Position);
	//		Image img = originalIcon.getImage().getScaledInstance(124, 30, Image.SCALE_SMOOTH);
	//		ImageIcon resizedIcon = new ImageIcon(img);
	
			
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
			panel.setBackground(new Color(255, 255, 255));
			panel.setBounds(0, 0, 974, 76);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Create_Work_Schedule.class.getResource("/aptech_logo.png")));
			lblNewLabel.setBounds(10, 0, 154, 76);
			panel.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Create Employee Schedule");
			lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
			lblNewLabel_1.setBounds(209, 11, 755, 54);
			panel.add(lblNewLabel_1);
	
	        getContentPane().setLayout(groupLayout);
	        
	        lblBirthday = new JLabel();
	        lblBirthday.setText("Birthday:");
	        lblBirthday.setForeground(Color.BLACK);
	        lblBirthday.setFont(new Font("Candara", Font.BOLD, 14));
	        lblBirthday.setBounds(73, 279, 110, 30);
	        getContentPane().add(lblBirthday);
	        
	        textField_birthday = new JTextField();
	        textField_birthday.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_birthday.setBounds(221, 279, 145, 30);
	        getContentPane().add(textField_birthday);
	        
	        textField_empID = new JTextField();
	        textField_empID.setFont(new Font("Calibri", Font.BOLD, 14));
	        textField_empID.setBounds(221, 149, 67, 30);
	        getContentPane().add(textField_empID);
	        
	        ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
			Image img1 = icon1.getImage();
			Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newIcon1 = new ImageIcon(newImg1);
	        
	        jButtonFind = new JButton();
	        jButtonFind.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		jButtonFindActionPerformed(e);
	        	}
	        });
	        jButtonFind.setIcon(new ImageIcon(Create_Work_Schedule.class.getResource("/view.png")));
	        jButtonFind.setFont(new Font("Candara", Font.BOLD, 12));
	        jButtonFind.setBorderPainted(false);
	        jButtonFind.setBorder(null);
	        jButtonFind.setBounds(298, 149, 30, 30);
	        getContentPane().add(jButtonFind);
	        
	        
	        ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
			Image refreshImg = refreshIcon.getImage();
			Image newRefreshImg = refreshImg.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
			ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);
	
	        btnRefresh = new JButton();
	        btnRefresh.setIcon(newRefreshIcon);
	        btnRefresh.setFont(new Font("Candara", Font.BOLD, 12));
	        btnRefresh.setBorderPainted(false);
	        btnRefresh.setBorder(null);
	        btnRefresh.setBounds(336, 149, 30, 30);
	        getContentPane().add(btnRefresh);
	        
	        lblCreateScheduleNext = new JLabel();
	        lblCreateScheduleNext.setText("Number Of Day: ");
	        lblCreateScheduleNext.setForeground(Color.BLACK);
	        lblCreateScheduleNext.setFont(new Font("Candara", Font.BOLD, 14));
	        lblCreateScheduleNext.setBounds(73, 360, 135, 30);
	        getContentPane().add(lblCreateScheduleNext);
	        
	        String choice[] = {"1 day", "Next 7 days"};
	        comboBoxNod = new JComboBox(choice);
	       
	        
	        comboBoxNod.setBounds(221, 358, 145, 30);
	        getContentPane().add(comboBoxNod);
	        
	        lblBeginDay = new JLabel();
	        lblBeginDay.setText("Begin Day: ");
	        lblBeginDay.setForeground(Color.BLACK);
	        lblBeginDay.setFont(new Font("Candara", Font.BOLD, 14));
	        lblBeginDay.setBounds(73, 319, 110, 30);
	        getContentPane().add(lblBeginDay);
	        
	        dateChooser = new JDateChooser();
	        dateChooser.setDateFormatString("yyyy-MM-dd");
	        dateChooser.setBounds(221, 319, 145, 30);
	        getContentPane().add(dateChooser);
	        
	        btnCreateSche = new JButton("Create Schedule");
	        btnCreateSche.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnCreateScheActionPerformed(e);
	        	}
	        });
	        btnCreateSche.setBounds(221, 399, 145, 42);
	        getContentPane().add(btnCreateSche);
	        
	        scrollPane = new JScrollPane();
	        scrollPane.setBounds(442, 188, 482, 179);
	        getContentPane().add(scrollPane);
	        
	        table = new JTable();
	        scrollPane.setViewportView(table);
	        
	        btnPrevious = new JButton("Previous");
	        btnPrevious.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnPreviousActionPerformed(e);
	        	}
	        });
	        btnPrevious.setBounds(443, 388, 85, 33);
	        getContentPane().add(btnPrevious);
	        
	        btnNext = new JButton("Next");
	        btnNext.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		btnNextActionPerformed(e);
	        	}
	        });
	        btnNext.setBounds(839, 388, 85, 33);
	        getContentPane().add(btnNext);
	        
	        String descr[] = { "8h-12h", "13h-17h", "18h-22h", 
	        "22h-6h"};
	        comboBoxWork_Shift = new JComboBox(descr);
	        comboBoxWork_Shift.setBounds(553, 147, 145, 30);
	        getContentPane().add(comboBoxWork_Shift);
	        
	        lblWorkShift = new JLabel();
	        lblWorkShift.setText("Work Shift:");
	        lblWorkShift.setForeground(Color.BLACK);
	        lblWorkShift.setFont(new Font("Candara", Font.BOLD, 14));
	        lblWorkShift.setBounds(442, 149, 110, 30);
	        getContentPane().add(lblWorkShift);
	        
	        jButtonFind_WorkShift = new JButton();
	        jButtonFind_WorkShift.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		jButtonFind_WorkShiftActionPerformed(e);
	        	}
	        });
	        jButtonFind_WorkShift.setIcon(new ImageIcon(Create_Work_Schedule.class.getResource("/view.png")));
	        jButtonFind_WorkShift.setFont(new Font("Candara", Font.BOLD, 12));
	        jButtonFind_WorkShift.setBorderPainted(false);
	        jButtonFind_WorkShift.setBorder(null);
	        jButtonFind_WorkShift.setBounds(718, 149, 30, 30);
	        getContentPane().add(jButtonFind_WorkShift);
	
			setBounds(0, 0, 990, 550);
		}
	
		private javax.swing.JLabel Employee_ID;
		private javax.swing.JLabel Emp_Name;
		private javax.swing.JLabel Position;
		private javax.swing.JTextField textField_empName;
		private JTextField textField_Position;
		private JTextField txtPassword;
		private JPanel panel;
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_1;
		private int firstPage = 1;
		private int rowOfPage = 10;
		private Double totalPage;
		private JLabel lblBirthday;
		private JTextField textField_birthday;
		private JTextField textField_empID;
		private JButton jButtonFind;
		private JButton btnRefresh;
		private JLabel lblCreateScheduleNext;
		private JComboBox comboBoxNod;
		private JLabel lblBeginDay;
		private JDateChooser dateChooser;
		private JButton btnCreateSche;
		private JScrollPane scrollPane;
		private JTable table;
		private JButton btnPrevious;
		private JButton btnNext;
		private JComboBox comboBoxWork_Shift;
		private JLabel lblWorkShift;
		private JButton jButtonFind_WorkShift;
		
		protected void jButtonFindActionPerformed(ActionEvent e) {
			EmployeeDAO dao = new EmployeeDAO();
			Employee emp = new Employee();
			emp = dao.getEmpByID(Integer.parseInt(textField_empID.getText().toString()));
			textField_empName.setText(emp.getEmployee_name());
			textField_Position.setText(emp.getPosition());
			textField_birthday.setText(new SimpleDateFormat("yyyy-MM-dd").format(emp.getBirthday()));
		
		}
		public void loadData() {
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Employee ID");
			model.addColumn("Date");
			model.addColumn("Work Shift ID");
			Work_scheduleDAO dao = new Work_scheduleDAO();
			
			dao.paginate(firstPage, rowOfPage).stream().forEach(ws -> {
				model.addRow(new Object[] { ws.getWork_schedule_id(), ws.getEmployee_id(), ws.getWork_date(), ws.getWork_shift_id() });
			});
			table.setModel(model);
		}
		
		
		protected void btnNextActionPerformed(ActionEvent e) {
			Work_scheduleDAO dao = new Work_scheduleDAO();
			totalPage = Math.ceil(dao.countRow2() / Double.valueOf(rowOfPage));
			if (firstPage < totalPage) {
				firstPage++;
			}
			loadData();
		}
		protected void btnPreviousActionPerformed(ActionEvent e) {
			if (firstPage > 1) {
				firstPage--;
			}
			loadData();
		}
		protected void btnCreateScheActionPerformed(ActionEvent e) {
		    try {	     
		        int employeeId = Integer.parseInt(textField_empID.getText());
		        java.util.Date startDate = dateChooser.getDate();
		        int numberOfDayIndex = comboBoxNod.getSelectedIndex();
		        int workShiftIndex = comboBoxWork_Shift.getSelectedIndex() + 1;
		        Work_scheduleDAO dao = new Work_scheduleDAO();
		        boolean success = false;
	
		        if (numberOfDayIndex == 0) {
		            int existingWorkShiftId = dao.selectForCheck(employeeId, startDate);
		            if (existingWorkShiftId != -1) {
		                dao.updateWSAfterRequest(workShiftIndex, startDate, existingWorkShiftId);
		            } else {
		                dao.add(employeeId, startDate, workShiftIndex);
		            }
		          
		            int updatedWorkShiftId = dao.selectForCheck(employeeId, startDate);
		            if (updatedWorkShiftId != -1) {
		                success = true;
		            }
		        } else if (numberOfDayIndex == 1) {
		            for (int i = 0; i < 7; i++) {
		                java.util.Date currentDate = addDays(startDate, i);
		                int existingWorkShiftId = dao.selectForCheck(employeeId, currentDate);
		                if (existingWorkShiftId != -1) {
		                    dao.updateWSAfterRequest(workShiftIndex, currentDate, existingWorkShiftId);
		                } else {
		                   
		                    dao.add(employeeId, currentDate, workShiftIndex);
		                }
		            }
	
		            for (int i = 0; i < 7; i++) {
		                java.util.Date currentDate = addDays(startDate, i);
		                int existingWorkShiftId = dao.selectForCheck(employeeId, currentDate);
		                if (existingWorkShiftId != -1) {
		                    success = true;
		                    break; 
		                }
		            }
		        }
	
		        if (success) {
		            loadData();
		            JOptionPane.showMessageDialog(this, "Work schedule has been created successfully!");
		        } else {
		            JOptionPane.showMessageDialog(this, "No business days added.", "Notification", JOptionPane.WARNING_MESSAGE);
		        }
	
		    } catch (Exception ex) {
		        JOptionPane.showMessageDialog(this, "Error when creating work schedule: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		    }
		}
	


		// Phương thức giúp thêm ngày vào một ngày cụ thể
		public static Date addDays(Date date, int days) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.DAY_OF_YEAR, days);
		    return calendar.getTime();
		}
		protected void jButtonFind_WorkShiftActionPerformed(ActionEvent e) {
		    // Lấy giá trị được chọn từ comboboxWorkShift
		    String selectedWorkShift = comboBoxWork_Shift.getSelectedItem().toString();

		    // Kiểm tra xem giá trị có tồn tại hay không
		    if (!selectedWorkShift.isEmpty()) {
		        // Tạo đối tượng Work_scheduleDAO
		        Work_scheduleDAO dao = new Work_scheduleDAO();

		        // Lấy dữ liệu từ cơ sở dữ liệu dựa trên workShift
		        List<Work_schedule> workShiftData = dao.searchByWorkShiftDescription(selectedWorkShift);

		        // Hiển thị dữ liệu lên table
		        displayWorkShiftData(workShiftData);
		    } else {
		        JOptionPane.showMessageDialog(this, "Please select a work shift.", "Notification", JOptionPane.WARNING_MESSAGE);
		    }
		}

		// Phương thức hiển thị dữ liệu của ca làm việc lên table
		private void displayWorkShiftData(List<Work_schedule> workShiftData) {
		    DefaultTableModel model = new DefaultTableModel();
		    model.addColumn("ID");
		    model.addColumn("Employee ID");
		    model.addColumn("Date");
		    model.addColumn("Work Shift ID");

		    // Thêm dữ liệu vào model
		    workShiftData.forEach(ws -> {
		        model.addRow(new Object[]{ws.getWork_schedule_id(), ws.getEmployee_id(), ws.getWork_date(), ws.getWork_shift_id()});
		    });

		    // Set model cho table
		    table.setModel(model);
		}


	}