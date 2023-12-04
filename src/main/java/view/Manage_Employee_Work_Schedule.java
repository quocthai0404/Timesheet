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
import com.toedter.calendar.demo.DateChooserPanel;

import DAO.Work_scheduleDAO;
import Validation.ValidateDate;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Manage_Employee_Work_Schedule extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnPrevious;
	private JButton btnNext;
	private JScrollPane scrollPane;
	private JLabel lblEmpId;
	private JLabel lblWorkDate;
	private JLabel lblWorkShiftId;
	private JLabel lblWorkType;
	private JTextField textEmpId;
	private JTextField textField_1;
	private JTextField textWorkshiftId;
	private JTextField textWorkType;
	private JButton btnAddEWS;
	private JButton btnUpdateWorkShift;
	private JTable table;
	private JLabel lblStatusPage;
	private Double totalPage;
	private int firstPage = 1;
	private int rowOfPage = 25;
	private JDateChooser dateChooser;
	private ValidateDate valid = new ValidateDate();

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

		lblWorkShiftId = new JLabel("Work Shift Id");

		lblWorkType = new JLabel("Work Type");

		textEmpId = new JTextField();
		textEmpId.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);

		textWorkshiftId = new JTextField();
		textWorkshiftId.setColumns(10);

		textWorkType = new JTextField();
		textWorkType.setColumns(10);

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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(125)
							.addComponent(lblStatusPage)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWorkDate, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmpId, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWorkShiftId, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWorkType, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textWorkType, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(textWorkshiftId, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(textEmpId, 152, 152, 152)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(407))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnUpdateWorkShift, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnAddEWS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
							.addGap(446))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(126)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblWorkDate))
									.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblWorkShiftId)
										.addComponent(textWorkshiftId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(116)
											.addComponent(btnAddEWS))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(50)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(lblWorkType)
												.addComponent(textWorkType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
									.addGap(128))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(361)
											.addComponent(btnUpdateWorkShift)))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnPrevious)
										.addComponent(btnNext)
										.addComponent(lblStatusPage))
									.addGap(16))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmpId))))
					.addContainerGap(100, Short.MAX_VALUE))
		);

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
				switch(col) {
				case 2:return false;
				default: return true;
				}
			}
		};
		model.addColumn("Work Schedule Id");
		model.addColumn("Employee Id");
		model.addColumn("Work Date");
		model.addColumn("Work Shift Id");
		model.addColumn("Work Type");
		
		Work_scheduleDAO dao = new Work_scheduleDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.selectPaginateEWS(firstPage, rowOfPage).stream().forEach(ws -> {

			model.addRow(new Object[] { ws.getWork_schedule_id(), ws.getEmployee_id(), ws.getWork_date(),
					ws.getWork_shift_id(), ws.getWork_type() });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		table.setModel(model);
		
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
			textWorkshiftId.setText(table.getValueAt(row, 3).toString());
			textWorkType.setText(table.getValueAt(row, 4).toString());

		}
	}

	protected void do_btnUpdateWorkShift_actionPerformed(ActionEvent e) {
		if(table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui long chon dong can update");
			return;
		}
//		if(!validText.isNull(textEmpId.getText())||!validText.isNull(textWorkshiftId.getText())||!validText.isNull(textWorkType.getText())||!validText.isNull(textWorkshiftId.getText())) {
//			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
//			return;
//		}
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Invalid Date");
			return;
			
		}
		int row = table.getSelectedRow();
		int empId = Integer.parseInt(textEmpId.getText());
		java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
		int work_shift_id = (Integer.parseInt(textWorkshiftId.getText()));
		String work_type = textWorkType.getText();
		int work_schedule_id = (Integer.parseInt(table.getValueAt(row, 0).toString()));
		var dao = new Work_scheduleDAO();
		dao.update(work_schedule_id, empId, sqlDate, work_shift_id, work_type);
		loadData();
	}
	protected void do_btnAddEWS_actionPerformed(ActionEvent e) {
//		if(!validText.isNull(textEmpId.getText())||!validText.isNull(textWorkshiftId.getText())||!validText.isNull(textWorkType.getText())||!validText.isNull(textWorkshiftId.getText())) {
//			JOptionPane.showMessageDialog(null, "Input fields cannot be blank");
//			return;
//		}
		if (dateChooser.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Invalid Date");
			return;
			
		}
		
		int empId = Integer.parseInt(textEmpId.getText());
		java.sql.Date sqlDate = new java.sql.Date(dateChooser.getDate().getTime());
		int work_shift_id = (Integer.parseInt(textWorkshiftId.getText()));
		String work_type = textWorkType.getText();
		
		
		var dao = new Work_scheduleDAO();
		dao.add( empId, sqlDate, work_shift_id, work_type);
		loadData();
	}
	
	protected void do_this_mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !table.contains(e.getPoint())) { 
	        table.clearSelection();
	        textEmpId.setText("");
	        textField_1.setText("");
	        textWorkshiftId.setText("");
	        textWorkType.setText("");
	        dateChooser.setCalendar(null);
	    }
	    
	}
}
