package view;

import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
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
import com.toedter.calendar.demo.DateChooserPanel;

import DAO.EmployeeDAO;
import DAO.Work_scheduleDAO;
import DAO.Work_shiftDAO;
import Validation.ValidateDate;
import entity.WorkShift;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
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
	private int rowOfPage = 25;
	private JDateChooser dateChooser;
	
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel;
	private JTextField textWorkType;
	private JComboBox comboBox = new JComboBox<WorkShift>();
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
		textWorkType.setColumns(10);
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
									.addComponent(lblStatusPage)
									.addGap(112))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap(360, Short.MAX_VALUE)
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
							.addGap(0)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(19))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
							.addGap(12)))
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
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
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnPrevious)
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblEmpId)
										.addComponent(textEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(lblWorkDate))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNext)
										.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
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
				case 2:
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
		dao.selectPaginateEWS(firstPage, rowOfPage).stream().forEach(ws -> {

			model.addRow(new Object[] { ws.getWork_schedule_id(), ws.getEmployee_id(), ws.getWork_date(),
					ws.getWork_shift_id(), ws.getWork_description(), ws.getWork_type() });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		table.setModel(model);

	}
	
	
	public void loadDataEmp() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Employee Name");
		model.addColumn("Position");
		model.addColumn("Birthday");
		model.addColumn("Gender");
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.selectPaginateEmpOnlyEmp(firstPage, rowOfPage).stream().forEach(emp -> {
			String gender = emp.getGender() ? "Male" : "Female";
			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
					emp.getBirthday(), gender });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
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
//		if (table.getSelectedRow() == -1) {
//			JOptionPane.showMessageDialog(null, "Vui long chon dong can update");
//			return;
//		}
//		if (textEmpId.getText().isBlank() ||  textWorkType.getText().isBlank()
//				) {
//			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
//			return;
//		}
//		if (dateChooser.getDate() == null) {
//			JOptionPane.showMessageDialog(null, "Invalid Date");
//			return;
//
//		}
//		int row = table.getSelectedRow();
//		int empId = Integer.parseInt(textEmpId.getText().replaceAll("\\s", ""));
//		java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
//		int work_shift_id = (Integer.parseInt(textWorkshiftId.getText().replaceAll("\\s", "")));
//		String work_type = textWorkType.getText().trim();
//		int work_schedule_id = (Integer.parseInt(table.getValueAt(row, 0).toString()));
//		var dao = new Work_scheduleDAO();
//		dao.update(work_schedule_id, empId, sqlDate, work_shift_id, work_type);
//		loadData();
	}

	protected void do_btnAddEWS_actionPerformed(ActionEvent e) {
		if (textEmpId.getText().isBlank() || comboBox.getSelectedItem().toString().isBlank() || textWorkType.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
			return;
		}
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Invalid Date");
			return;

		}

		int empId = Integer.parseInt(textEmpId.getText().replaceAll("\\s", ""));
		java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
		String work_type = textWorkType.getText().trim();

		var dao = new Work_scheduleDAO();
//		dao.add(empId, sqlDate, work_shift_id);
		loadData();
	}

	protected void do_this_mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !table.contains(e.getPoint())) {
			table.clearSelection();
			textEmpId.setText("");
			textField_1.setText("");
//			textWorkshiftId.setText("");
//			textWorkType.setText("");
			dateChooser.setCalendar(null);
		}

	}
	protected void do_comboBox_actionPerformed(ActionEvent e) {

		WorkShift ws = (WorkShift) comboBox.getSelectedItem();
		System.out.println("ID: "+ws.getWork_shift_id());
		System.out.println("des: "+ws.getDescription());
		System.out.println("work_type: "+ws.getWork_type());
	}
}
