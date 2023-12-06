package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import DAO.EmployeeDAO;
import DAO.LeaveDao;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Request_Leave extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbAddNV5;
	private JPanel panel;
	private JLabel lblStartDate;
	private JDateChooser dateLeave;
	private JLabel lblNumsOfDate;
	private JTextField txtNod;
	private JLabel lblReason;
	private JTextField txtReason;
	private JButton btnSend;
	private JTable tableRequest;
	
	public Request_Leave() {
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		lblStartDate = new JLabel("Leave Start");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		dateLeave = new JDateChooser();
		
		lblNumsOfDate = new JLabel("Nums of Date");
		lblNumsOfDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtNod = new JTextField();
		txtNod.setColumns(10);
		
		lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtReason = new JTextField();
		txtReason.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtReason.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendActionPerformed(e);
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtReason, Alignment.LEADING)
							.addComponent(lblReason, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lblStartDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNumsOfDate, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(txtNod)
									.addComponent(dateLeave, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))))
					.addContainerGap(392, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(dateLeave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtNod)
						.addComponent(lblNumsOfDate, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
					.addGap(29)
					.addComponent(lblReason, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtReason, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
					.addGap(43)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(169))
		);
		
		lbAddNV5 = new JLabel();
		lbAddNV5.setText("Request For Leave");
		lbAddNV5.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddNV5.setForeground(new Color(255, 255, 255));
		lbAddNV5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbAddNV5.setBackground(Color.BLACK);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbAddNV5, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
	
	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Start Date");
		model.addColumn("Number of Days");
		model.addColumn("Reason");
		EmployeeDAO dao = new EmployeeDAO();
		
		LeaveDao dao1 = new LeaveDao();

	    dao1.selectLeave().forEach(leave -> {
	        model.addRow(new Object[]{leave.getStartdate(), leave.getNumber_of_days(), leave.getReason()});
	    });
	    tableRequest.setModel(model);
	}
	
	protected void btnSendActionPerformed(ActionEvent e) {
		Date startDate = dateLeave.getDate();
        String numsOfDate = txtNod.getText();
        String reason = txtReason.getText();

        
        LeaveDao leaveDao = new LeaveDao();
        leaveDao.addLeaveRequest(startDate, numsOfDate, reason); 
        loadData();
	    
	}
}
