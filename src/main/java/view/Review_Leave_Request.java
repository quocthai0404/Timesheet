package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.EmployeeDAO;
import DAO.LeaveDao;
import DAO.Work_scheduleDAO;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;

public class Review_Leave_Request extends JPanel {
    private JTable dataTable;
    private JScrollPane scrollPane;
    private JTable tableLeave;
    private JButton btnPrevious;
    private JLabel lblStatusPage;
    private JButton btnNext;
    private Double totalPage;
    private int firstPage=1;
	private int rowOfPage = 25;
	private JLabel lblEmpId;
	private JTextField txtEmpId;
	private JLabel lblLeaveType;
	private JTextField txtLeaveType;
	private JLabel lblStartDate;
	private JDateChooser dateChooser;
	private JLabel lblNumsDate;
	private JTextField txtNod;
	private JLabel lblApproved;
	private JRadioButton rdbtnYes; 
	private JRadioButton rdbtnNo;
	private JButton btnApprove;
	private JLabel lblNewLabel;
	private JTextField txtLeaveId;
	private JLabel lblReason;
	private JTextField txtReason;

    public Review_Leave_Request() {
        
        scrollPane = new JScrollPane();
        
        btnPrevious = new JButton("Previous");
        
        lblStatusPage = new JLabel("1/1");
        
        btnNext = new JButton("Next");
        
        lblEmpId = new JLabel("Employee Id");
        
        txtEmpId = new JTextField();
        txtEmpId.setColumns(10);
        
        lblLeaveType = new JLabel("Leave Type");
        
        txtLeaveType = new JTextField();
        txtLeaveType.setColumns(10);
        
        lblStartDate = new JLabel("Start Date");
        
        dateChooser = new JDateChooser();
        
        lblNumsDate = new JLabel("Nums of Date");
        
        txtNod = new JTextField();
        txtNod.setColumns(10);
        
        lblApproved = new JLabel("Approved");
        
        rdbtnYes = new JRadioButton("Yes");
        
        rdbtnNo = new JRadioButton("No");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnYes);
        buttonGroup.add(rdbtnNo);
        
        btnApprove = new JButton("Approve");
        btnApprove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnApproveActionPerformed(e);
        	}
        });
        
        
        lblNewLabel = new JLabel("Leave Id");
        
        txtLeaveId = new JTextField();
        txtLeaveId.setEnabled(false);
        txtLeaveId.setColumns(10);
        
        lblReason = new JLabel("Reason");
        
        txtReason = new JTextField();
        txtReason.setColumns(10);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        					.addGap(200)
        					.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE))
        			.addGap(84)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnApprove, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addComponent(lblApproved, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addComponent(rdbtnYes, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        									.addGap(18)
        									.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        									.addGap(21))
        								.addGroup(groupLayout.createSequentialGroup()
        									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        										.addComponent(lblNumsDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(lblReason, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        										.addComponent(lblStartDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        										.addComponent(lblLeaveType, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
        										.addComponent(lblEmpId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(txtEmpId, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        										.addComponent(txtLeaveType)
        										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(txtNod, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
        										.addComponent(txtReason, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        										.addComponent(txtLeaveId, 152, 152, 152))))
        							.addGap(11)))
        					.addGap(128))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(63)
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(70)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblNewLabel)
        						.addComponent(txtLeaveId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblEmpId)
        						.addComponent(txtEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(16)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(18)
        							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lblLeaveType)
        								.addComponent(txtLeaveType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        							.addGap(34)
        							.addComponent(lblStartDate)
        							.addGap(34))
        						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(32)))
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtNod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblNumsDate))
        					.addGap(43)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblReason)
        						.addComponent(txtReason, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(29)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(rdbtnYes)
        						.addComponent(lblApproved)
        						.addComponent(rdbtnNo))
        					.addGap(22)
        					.addComponent(btnApprove)))
        			.addGap(68)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnPrevious)
        				.addComponent(btnNext)
        				.addComponent(lblStatusPage))
        			.addContainerGap(132, Short.MAX_VALUE))
        );
        
        tableLeave = new JTable();
        tableLeave.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableLeaveMouseClicked(e);
        	}
        });
        loadData();
        scrollPane.setViewportView(tableLeave);
        setLayout(groupLayout);
        btnPrevious.addActionListener(this::btnPreviousActionPerformed);
        btnNext.addActionListener(this::btnNextActionPerformed);
    }
    public void loadData() {
    	DefaultTableModel model = new DefaultTableModel() ;
        model.addColumn("Leave Id");
        model.addColumn("Employee Id");
        model.addColumn("Leave Type");
        model.addColumn("Start Date");
        model.addColumn("Numbers of Date");
        model.addColumn("Reason");
        model.addColumn("Approved");
        LeaveDao dao = new LeaveDao();
        totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
        dao.selectPaginateEmp(firstPage, rowOfPage).forEach(emp -> {
            String approvedStatus = emp.getApproved() ? "Yes" : "No";
            model.addRow(new Object[]{emp.getLeave_id(), emp.getEmployee_id(), emp.getLeave_type(), emp.getStartdate(), emp.getNumber_of_days(), emp.getReason(), approvedStatus});
        });
        lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
        model.fireTableDataChanged();
        tableLeave.setModel(model);
    }

    private void btnNextActionPerformed(ActionEvent e) {
        LeaveDao dao = new LeaveDao();
        totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
        if (firstPage < totalPage) {
            firstPage++;
        }

        lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
        loadData();
    }

    private void btnPreviousActionPerformed(ActionEvent e) {
        if (firstPage > 1) {
            firstPage--;
        }

        lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
        loadData();
    }
	protected void tableLeaveMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = tableLeave.getSelectedRow();
			txtLeaveId.setText(tableLeave.getValueAt(row, 0).toString());
			txtEmpId.setText(tableLeave.getValueAt(row, 1).toString());
			txtLeaveType.setText(tableLeave.getValueAt(row, 2).toString());
			try {
				dateChooser.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tableLeave.getValueAt(row, 3).toString()));
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			txtNod.setText(tableLeave.getValueAt(row, 4).toString());
			txtReason.setText(tableLeave.getValueAt(row, 5).toString());
			if (tableLeave.getValueAt(row, 6).toString().equals("Yes")) {
				rdbtnYes.setSelected(true);
			} else {
				rdbtnNo.setSelected(true);
			}

		}
	}
	protected void btnApproveActionPerformed(ActionEvent e) {
//		if (rdbtnYes.isSelected()) {
//			  tableLeave.setValueAt("Yes", tableLeave.getSelectedRow(), 6);
//			} else {
//			  tableLeave.setValueAt("No", tableLeave.getSelectedRow(), 6);
//		}
		
		LeaveDao dao = new LeaveDao();
	    int leaveId = Integer.parseInt(txtLeaveId.getText());
	    boolean approved = rdbtnYes.isSelected();


	    dao.update(leaveId, approved);


	    DefaultTableModel model = (DefaultTableModel) tableLeave.getModel();
	    int selectedRow = tableLeave.getSelectedRow();
	    model.setValueAt(approved ? "Yes" : "No", selectedRow, 6);
	}
}
