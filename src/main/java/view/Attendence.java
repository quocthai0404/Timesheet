package view;

import javax.swing.JPanel;

import entity.EmployeeAfterLogin;
import entity.W_scheduleJoinWShift;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DAO.AttendanceDAO;
import DAO.EmployeeDAO;
import database.JdbcUlti;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Attendence extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCheckIn;
	private JButton btnCheckOut;
	private JLabel lblToday;
	private W_scheduleJoinWShift wsDao = new W_scheduleJoinWShift();
	private ArrayList<W_scheduleJoinWShift> list = new ArrayList<>();
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnChooseIn;

	private JTextField textWorkScheduleId;
	private JTextField textWorkShiftID;
	private JTextField textEmpID;
	private JButton btnChooseOut;
	Map<Integer, String> mapTimeIn = new HashMap<Integer, String>();
	Map<Integer, String> mapTimeOut = new HashMap<Integer, String>();
	public Attendence() {
		mapTimeIn.put(1, "08");
		mapTimeIn.put(2, "08");
		mapTimeIn.put(3, "13");
		mapTimeIn.put(4, "17");
		mapTimeOut.put(1, "17");
		mapTimeOut.put(2, "12");
		mapTimeOut.put(3, "17");
		mapTimeOut.put(4, "20");
		btnCheckIn = new JButton("Check In");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckInActionPerformed(e);
			}
		});

		btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckOutActionPerformed(e);
			}
		});

		lblToday = new JLabel("Today");
		lblToday.setText("Today is: "+new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis())));
		
		scrollPane = new JScrollPane();
		
		btnChooseIn = new JButton("Choose");
		btnChooseIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChooseActionPerformed(e);
			}
		});
		btnChooseIn.setVisible(false);
		
		textWorkScheduleId = new JTextField();
		textWorkScheduleId.setColumns(10);
		textWorkScheduleId.setVisible(false);
		
		textWorkShiftID = new JTextField();
		textWorkShiftID.setColumns(10);
		textWorkShiftID.setVisible(false);
		
		textEmpID = new JTextField();
		textEmpID.setColumns(10);
		textEmpID.setVisible(false);
		
		btnChooseOut = new JButton("Choose");
		btnChooseOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChooseOutActionPerformed(e);
			}
		});
		btnChooseOut.setVisible(false);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(233)
							.addComponent(btnCheckIn)
							.addGap(161)
							.addComponent(btnCheckOut))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(149)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 525, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textEmpID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textWorkShiftID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textWorkScheduleId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(286)
							.addComponent(lblToday, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(324)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnChooseOut, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChooseIn, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))))
					.addContainerGap(346, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(textWorkScheduleId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textWorkShiftID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textEmpID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(77)
					.addComponent(lblToday)
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCheckOut)
						.addComponent(btnCheckIn))
					.addGap(36)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChooseIn)
					.addGap(18)
					.addComponent(btnChooseOut)
					.addContainerGap(197, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		setLayout(groupLayout);

	}

	

	
	

	protected void btnCheckInActionPerformed(ActionEvent e) {
		long currentTimeMillis = System.currentTimeMillis();
		Date dateNow = new Date(currentTimeMillis);
		if(btnChooseOut.isDisplayable()) {
			btnChooseOut.setVisible(false);
		}
		list = wsDao.listJoin(dateNow);
		if (list.size() > 0) {
			loadData();
			scrollPane.setVisible(true);
			btnChooseIn.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "This employee has no work schedule today");
			return;
		}

	}
	
	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("work_schedule_id");
		model.addColumn("employee_id");
		model.addColumn("work_date");
		model.addColumn("work_shift_id");
		model.addColumn("description");
		try {
			Connection con = JdbcUlti.getConnection();
			String sql = "select ws.work_schedule_id, ws.employee_id,ws.work_date,ws.work_shift_id,work_shift.description\r\n"
					+ "	from work_schedule as ws\r\n"
					+ "	inner join work_shift\r\n"
					+ "	on  work_shift.work_shift_id=ws.work_shift_id\r\n"
					+ "	where ws.employee_id=? and ws.isHide=0";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, EmployeeAfterLogin.employeeID);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				model.addRow(new Object[] {rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getString(5)});
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		table.setModel(model);
	}
	protected void tableMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = table.getSelectedRow();
			textWorkScheduleId.setText(table.getValueAt(row, 0).toString());
			textEmpID.setText(table.getValueAt(row, 1).toString());
			textWorkShiftID.setText(table.getValueAt(row, 3).toString());
			
		}
	}
	protected void btnChooseActionPerformed(ActionEvent e) {
		AttendanceDAO ad = new AttendanceDAO();
		ad.checkIn(textWorkScheduleId.getText(), textEmpID.getText(), textWorkShiftID.getText(), mapTimeIn);
	}
	protected void btnCheckOutActionPerformed(ActionEvent e) {
		long currentTimeMillis = System.currentTimeMillis();
		Date dateNow = new Date(currentTimeMillis);
		if(btnChooseIn.isDisplayable()) {
			btnChooseIn.setVisible(false);
		}
		list = wsDao.listJoin(dateNow);
		if (list.size() > 0) {
			loadData();
			scrollPane.setVisible(true);
			btnChooseOut.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "This employee has no work schedule today");
			return;
		}
	}
	protected void btnChooseOutActionPerformed(ActionEvent e) {
		AttendanceDAO ad = new AttendanceDAO();
		if(ad.checkExitsAtten(textWorkScheduleId.getText())) {
			JOptionPane.showMessageDialog(null, "you can check out");
			ad.checkOut(textWorkShiftID.getText(), mapTimeOut, textEmpID.getText(), textWorkScheduleId.getText(), mapTimeIn);
		}else {
			JOptionPane.showMessageDialog(null, "You need check in before check out!");
		}
	}
}
