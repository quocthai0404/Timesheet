package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import DAO.Work_scheduleDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Work_Schedule extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblStatusPage;
	private Double totalPage;
	private int firstPage = 1;
	private int rowOfPage = 25;

	/**
	 * Create the panel.
	 */
	public Work_Schedule() {
		
		scrollPane = new JScrollPane();
		
		lblStatusPage = new JLabel("New label");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(315)
					.addComponent(lblStatusPage)
					.addContainerGap(350, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblStatusPage)
					.addContainerGap(71, Short.MAX_VALUE))
		);
		
		table = new JTable();
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
}
