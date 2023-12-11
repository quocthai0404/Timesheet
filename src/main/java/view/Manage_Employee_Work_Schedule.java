package view;

import javax.swing.JPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;


import DAO.EmployeeDAO;
import DAO.Work_scheduleDAO;
import DAO.Work_shiftDAO;

import entity.WorkShift;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;

public class Manage_Employee_Work_Schedule extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnPrevious;
	private JButton btnNext;
	private JScrollPane scrollPane;
	private JLabel lblEmpId;
	private JLabel lblWorkDate;
	private JLabel lblDescription;
	private JTextField textEmpId;
	private JTextField textField_1;
	private JButton btnAddEWS;
	private JButton btnUpdateWorkShift;
	private JTable table;
	private JLabel lblStatusPage;
	private Double totalPage;
	private int firstPage = 1;
	private int rowOfPage = 22;
	private JDateChooser dateChooser;
	
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel;
	private JTextField textWorkType;
	private JComboBox<WorkShift> comboBox = new JComboBox();
	private Work_shiftDAO wsd = new Work_shiftDAO();
	private List<WorkShift> list = wsd.select();

	/**
	 * Create the panel.
	 */
	public Manage_Employee_Work_Schedule() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_this_mouseClicked(e);
			}
		});

		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnPrevious_actionPerformed(e);
			}
		});

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNext_actionPerformed(e);
			}
		});

		scrollPane = new JScrollPane();

		lblEmpId = new JLabel("Employee Id");

		lblWorkDate = new JLabel("Work Date");

		lblDescription = new JLabel("Description");

		textEmpId = new JTextField();
		textEmpId.setEnabled(false);
		textEmpId.setEditable(false);
		textEmpId.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);

		btnAddEWS = new JButton("Add Work Schedule");
		btnAddEWS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAddEWS_actionPerformed(e);
			}
		});

		btnUpdateWorkShift = new JButton("Update Work Schedule");
		btnUpdateWorkShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnUpdateWorkShift_actionPerformed(e);
			}
		});

		lblStatusPage = new JLabel("New label");

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		
		scrollPane_1 = new JScrollPane();
		
		lblNewLabel = new JLabel("Work type");
		
		textWorkType = new JTextField();
		textWorkType.setEnabled(false);
		textWorkType.setEditable(false);
		textWorkType.setColumns(10);
		WorkShift ws = new WorkShift();
		comboBox.addItem(ws);
		
        for (WorkShift i : list) {
			comboBox.addItem((WorkShift) i);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_comboBox_actionPerformed(e);
			}
		});

		
        
        comboBox.setSelectedIndex(0);
		


		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(20)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel)
												.addComponent(lblWorkDate, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblEmpId, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblDescription, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
											.addGap(41)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textEmpId, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
												.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
												.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
												.addComponent(textWorkType, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
											.addGap(5)))
									.addGap(0))
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblStatusPage)
									.addGap(190)))
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
							.addGap(12)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
							.addGap(25))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAddEWS, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(140))))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(684, Short.MAX_VALUE)
					.addComponent(btnUpdateWorkShift)
					.addGap(135))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEmpId)
										.addComponent(textEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblWorkDate))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNext)
										.addComponent(btnPrevious)
										.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDescription)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(btnAddEWS)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(btnUpdateWorkShift))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textWorkType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(38))
		);
		
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_1_mouseClicked(e);
			}
		});
		scrollPane_1.setViewportView(table_1);
		loadDataEmp();

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		loadData();

	}

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 0,1,2,4,5:
					return false;
				default:
					return true;
				}
			}
		};
		model.addColumn("Work Schedule Id");
		model.addColumn("Employee Id");
		model.addColumn("Work Date");
		model.addColumn("Work Shift Id");
		model.addColumn("Work Description");
		model.addColumn("Work Type");
		

		Work_scheduleDAO dao = new Work_scheduleDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		System.out.println(totalPage);
		dao.selectPaginateEWS(firstPage, rowOfPage).stream().forEach(ws -> {
			

			model.addRow(new Object[] { ws.getWork_schedule_id(), ws.getEmployee_id(), ws.getWork_date(),
					ws.getWork_shift_id(), ws.getWork_description(), ws.getWork_type() });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		table.setModel(model);

	}
	
	
	public void loadDataEmp() {
		DefaultTableModel model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int col) {
				switch (col) {
				case 0,1,2,3,4:
					return false;
				default:
					return true;
				}
				
			}
		};
		
		model.addColumn("ID");
		model.addColumn("Employee Name");
		model.addColumn("Position");
		model.addColumn("Birthday");
		model.addColumn("Gender");
		EmployeeDAO dao = new EmployeeDAO();
		
		dao.selectPaginateEmpOnlyEmp(firstPage, rowOfPage).stream().forEach(emp -> {
			String gender = emp.getGender() ? "Male" : "Female";
			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
					emp.getBirthday(), gender });
		});
		
		table_1.setModel(model);

	}

	protected void do_btnPrevious_actionPerformed(ActionEvent e) {

		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}

	protected void do_btnNext_actionPerformed(ActionEvent e) {
		Work_scheduleDAO dao = new Work_scheduleDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		if (firstPage < totalPage) {
			firstPage++;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}

	protected void do_table_mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = table.getSelectedRow();
			textField_1.setText(table.getValueAt(row, 0).toString());
			textEmpId.setText(table.getValueAt(row, 1).toString());
			try {
				dateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(table.getValueAt(row, 2).toString()));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			String value = table.getValueAt(row, 4).toString();
			
	        for (WorkShift i : list) {
				if(i.getDescription().equals(value)) {
					comboBox.setSelectedItem(i);
				}
			}
			
			textWorkType.setText(table.getValueAt(row, 5).toString());

		}
	}

	protected void do_btnUpdateWorkShift_actionPerformed(ActionEvent e) {
		Date today = new Date();

		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui long chon dong can update");
			return;
		}
		if (textEmpId.getText().isBlank() 
				) {
			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
			return;
		}
		if (textWorkType.getText().isBlank()) {
	        JOptionPane.showMessageDialog(null, "Vui long chon work description");
	        return;
	    }
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Invalid Date");
			return;

		}
		if(today.before(dateChooser.getDate())){
			JOptionPane.showMessageDialog(null, "vui long khong nhap ngay truoc ngay hom nay" );
			return;
		}
		int row = table.getSelectedRow();
		int empId = Integer.parseInt(textEmpId.getText());
		java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
		WorkShift ws = (WorkShift) comboBox.getSelectedItem();
		
		int work_shift_id = ws.getWork_shift_id();
		
		int work_schedule_id = (Integer.parseInt(table.getValueAt(row, 0).toString()));
		
		
		if(check(work_shift_id, dateChooser.getDate(), empId)) {
			Work_scheduleDAO dao = new Work_scheduleDAO();
			dao.update(work_schedule_id, empId, sqlDate, work_shift_id);
			loadData();
		}

	}

	protected void do_btnAddEWS_actionPerformed(ActionEvent e) {
		WorkShift ws = (WorkShift) comboBox.getSelectedItem();
		Date today = new Date();
		if (textEmpId.getText().isBlank() ) {
			JOptionPane.showMessageDialog(null, "Please choose an employee from the table");
			return;
		}
		
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Invalid Date");
			return;

		}
		if (ws.getWork_type() == null) {
	        JOptionPane.showMessageDialog(null, "Vui long chon work description");
	        return;
	    }
		if(today.before(dateChooser.getDate())){
			JOptionPane.showMessageDialog(null, "vui long khong nhap ngay truoc ngay hom nay" );
			return;
		}
			
		

		int empId = Integer.parseInt(textEmpId.getText());
		//thay the thanh id cua combobox
		java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
		
		int work_shift_id = ws.getWork_shift_id();
		

		
	
		var dao = new Work_scheduleDAO();
		dao.add(empId, sqlDate, work_shift_id);
		loadData();
	}

	protected void do_this_mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !table.contains(e.getPoint())) {
			table.clearSelection();
			textEmpId.setText("");
			textField_1.setText("");
			textWorkType.setText("");
			comboBox.setSelectedIndex(-1);
			table_1.clearSelection();
			

			dateChooser.setCalendar(null);
		}

	}
	protected void do_comboBox_actionPerformed(ActionEvent e) {
	    
	    if (comboBox.getSelectedItem() == null) {
	        textWorkType.setText("");
	        return;
	    }

	   
	    WorkShift ws = (WorkShift) comboBox.getSelectedItem();

	   
	    if (ws != null) {
	        textWorkType.setText(ws.getWork_type());
	    } else {
	        
	        textWorkType.setText("");
	    }
	}
	protected void do_table_1_mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = table_1.getSelectedRow();
			
			textEmpId.setText(table_1.getValueAt(row, 0).toString());
			

		}
	}
	public boolean check(int work_shift_id,Date work_date, int emp_id) {
//		WorkShift ws = (WorkShift) comboBox.getSelectedItem();
//		work_shift_id = ws.getWork_shift_id();
//		work_date = dateChooser.getDate();
//		emp_id = Integer.parseInt(textEmpId.getText());
		Work_scheduleDAO dao = new Work_scheduleDAO();
		int workShiftIdFromDB = dao.selectForCheck(emp_id,work_date);
		if(workShiftIdFromDB == 1) {
			if(work_shift_id == 2 || work_shift_id == 3) {
				JOptionPane.showMessageDialog(null, "chi cho phep chuyen sang loai 4, vui long nhap lai");
				return false;
				
			}else {
				if(work_shift_id == 1 || workShiftIdFromDB == work_shift_id) {
					JOptionPane.showMessageDialog(null, "vui long nhap 1 id khac");
					return false;
				}
			}
		}	return true;
	
		
		
	}
}
