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
	private JButton btnPrevious;
	private JButton btnNext;
	private JLabel lblStatusPage;
	private Double totalPage;
    private int firstPage=1;
	private int rowOfPage = 25;

	/**
	 * Create the panel.
	 */
	public Attendance_History() {
		
		scrollPane = new JScrollPane();
		
		btnPrevious = new JButton("Previous");
		
		btnNext = new JButton("Next");
		
		lblStatusPage = new JLabel("1/1");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(105)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(162)
							.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(262, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrevious)
						.addComponent(btnNext)
						.addComponent(lblStatusPage))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		tableHistory = new JTable();
		scrollPane.setViewportView(tableHistory);
		setLayout(groupLayout);

	}
public void loadData() {
    	
    	DefaultTableModel model = new DefaultTableModel() ;
        model.addColumn("Attendance Id");
        model.addColumn("Employee Id");
        model.addColumn("Work schedule Id");
        model.addColumn("Time In");
        model.addColumn("Time out");
        model.addColumn("Hours Worked");
        model.addColumn("Status");
        AttendanceDAO dao = new AttendanceDAO();
        totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
        dao.selectPaginateAtt(firstPage, rowOfPage).forEach(att -> {
            model.addRow(new Object[]{att.getAttendance_id(), att.getEmployee_id(), att.getWork_schedule_id(), att.getTime_in(), att.getTime_in(), att.getHours_works(), att.getStatus()});
        });
        lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
        model.fireTableDataChanged();
        tableHistory.setModel(model);
    }

    private void btnNextActionPerformed(ActionEvent e) {
        AttendanceDAO dao = new AttendanceDAO();
        totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
        if (firstPage < totalPage) {
            firstPage++;
        }

        lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
        loadData();
    }
}
