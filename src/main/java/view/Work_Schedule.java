package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import DAO.Work_scheduleDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Work_Schedule extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblStatusPage;
	private Double totalPage;
	private int firstPage = 1;
	private int rowOfPage = 22;
	private JButton btnPre;
	private JButton btnNext;

	/**
	 * Create the panel.
	 */
	public Work_Schedule() {
		
		scrollPane = new JScrollPane();
		
		lblStatusPage = new JLabel("New label");
		
		btnPre = new JButton("Previous");
		btnPre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNewButton_actionPerformed(e);
			}
		});
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnNext_actionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(33, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPre)
							.addGap(193)
							.addComponent(lblStatusPage)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNext))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
					.addGap(40))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStatusPage)
						.addComponent(btnPre)
						.addComponent(btnNext))
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
				case 0,1,2,3,4,5:
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
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
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
}
