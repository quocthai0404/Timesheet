package view;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import DAO.AttendanceDAO;
import DAO.LeaveDao;

import javax.swing.JLabel;

public class Attendance_History extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tableHistory;
	private Double totalPage;
    private int firstPage=1;
	private int rowOfPage = 25;

	/**
	 * Create the panel.
	 */
	public Attendance_History() {
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 592, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		
		tableHistory = new JTable();
		scrollPane.setViewportView(tableHistory);
		setLayout(groupLayout);
		loadData();

	}
public void loadData() {
    	
    	DefaultTableModel model = new DefaultTableModel() ;
        model.addColumn("Attendance Id");
        model.addColumn("Employee Id");
        model.addColumn("Work schedule Id");
        model.addColumn("Time In");
        model.addColumn("Time out");
        model.addColumn("Hours Worked");
        AttendanceDAO dao = new AttendanceDAO();
        dao.selectAtt().forEach(a -> {
        	model.addRow(new Object[] {a.getAttendance_id(), a.getEmployee_id(), a.getWork_schedule_id(), a.getTime_in(), a.getTime_out(), a.getHours_works()});
        });
        
        tableHistory.setModel(model);
    }

    
}
