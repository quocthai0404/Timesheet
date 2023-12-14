package view;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

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
	private JPanel jPanel23;
	private JLabel lblLeaveRequest;
	

    public Review_Leave_Request() {
    	setBackground(new Color(0, 255, 255));
        
        scrollPane = new JScrollPane();
        
        btnPrevious = new JButton("Previous");
        btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        lblStatusPage = new JLabel("1/1");
        
        btnNext = new JButton("Next");
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        lblEmpId = new JLabel("Employee Id");
        lblEmpId.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        txtEmpId = new JTextField();
        txtEmpId.setColumns(10);
        
        lblLeaveType = new JLabel("Leave Type");
        lblLeaveType.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        txtLeaveType = new JTextField();
        txtLeaveType.setColumns(10);
        
        lblStartDate = new JLabel("Start Date");
        lblStartDate.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        dateChooser = new JDateChooser();
        
        lblNumsDate = new JLabel("Nums of Date");
        lblNumsDate.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        txtNod = new JTextField();
        txtNod.setColumns(10);
        
        lblApproved = new JLabel("Approved");
        lblApproved.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        rdbtnYes = new JRadioButton("Yes");
        
        rdbtnNo = new JRadioButton("No");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnYes);
        buttonGroup.add(rdbtnNo);
        
        btnApprove = new JButton("Approve");
        btnApprove.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnApprove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnApproveActionPerformed(e);
        	}
        });
        
        
        lblNewLabel = new JLabel("Leave Id");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        txtLeaveId = new JTextField();
        txtLeaveId.setEnabled(false);
        txtLeaveId.setColumns(10);
        
        lblReason = new JLabel("Reason");
        lblReason.setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        txtReason = new JTextField();
        txtReason.setColumns(10);
        
        jPanel23 = new JPanel();
        jPanel23.setBackground(Color.BLACK);
        
        lblLeaveRequest = new JLabel();
        lblLeaveRequest.setText("Leave Request");
        lblLeaveRequest.setHorizontalAlignment(SwingConstants.CENTER);
        lblLeaveRequest.setForeground(Color.WHITE);
        lblLeaveRequest.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblLeaveRequest.setBackground(Color.BLACK);
        GroupLayout gl_jPanel23 = new GroupLayout(jPanel23);
        gl_jPanel23.setHorizontalGroup(
        	gl_jPanel23.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 912, Short.MAX_VALUE)
        		.addGroup(gl_jPanel23.createSequentialGroup()
        			.addGap(50)
        			.addComponent(lblLeaveRequest, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        			.addContainerGap())
        );
        gl_jPanel23.setVerticalGroup(
        	gl_jPanel23.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 52, Short.MAX_VALUE)
        		.addGroup(gl_jPanel23.createSequentialGroup()
        			.addComponent(lblLeaveRequest, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel23.setLayout(gl_jPanel23);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 982, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
        							.addGap(141)
        							.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
        							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
        						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(30)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        									.addComponent(lblEmpId, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        									.addComponent(lblLeaveType, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
        									.addComponent(lblStartDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(lblNumsDate, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        									.addComponent(lblReason, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
        								.addComponent(lblApproved, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        								.addGroup(groupLayout.createSequentialGroup()
        									.addComponent(txtLeaveId, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
        									.addContainerGap())
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        									.addGroup(groupLayout.createSequentialGroup()
        										.addComponent(rdbtnYes, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        										.addGap(42)
        										.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        										.addGap(304))
        									.addGroup(groupLayout.createSequentialGroup()
        										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        											.addComponent(txtReason, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        											.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        											.addComponent(txtLeaveType, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        											.addComponent(txtNod, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
        											.addComponent(txtEmpId, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE))
        										.addGap(83)))))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(72)
        							.addComponent(btnApprove, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
        							.addContainerGap())))))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel23, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(71)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(lblStatusPage)
        							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        							.addComponent(btnApprove, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        						.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNewLabel)
        						.addComponent(txtLeaveId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(21)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblEmpId)
        						.addComponent(txtEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(5)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblEmpId)
        						.addComponent(txtEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(137)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblLeaveType)
        						.addComponent(txtLeaveType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        							.addComponent(lblStartDate)
        							.addGap(15)
        							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lblNumsDate)
        								.addComponent(txtNod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(6)
        							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(40)))
        					.addGap(9)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblReason)
        						.addComponent(txtReason, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        					.addGap(22)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(rdbtnYes)
        						.addComponent(rdbtnNo)
        						.addComponent(lblApproved))
        					.addGap(170)))
        			.addGap(474))
        );
        
        tableLeave = new JTable();
        tableLeave.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableLeaveMouseClicked(e);
        	}
        	@Override
        	public void mousePressed(MouseEvent e) {
        		tableLeaveMousePressed(e);
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
	    loadData();

	}
	protected void tableLeaveMousePressed(MouseEvent e) {
		var menu= new JPopupMenu("function");
		var menuItem=new JMenuItem("delete row",'d');
		menuItem.addActionListener(this::deleteRow);
		menu.add(menuItem);
		if(e.getButton()==MouseEvent.BUTTON3) {
			menu.show(tableLeave,e.getX(),e.getY());
		}
	}
	private void deleteRow(ActionEvent actionEvent) {
	    int selectedRow = tableLeave.getSelectedRow();
	    if (selectedRow >= 0) {
	        int employeeId = (int) tableLeave.getValueAt(selectedRow, 0); 
	        LeaveDao leaveDao = new LeaveDao();
	        LeaveDao.delete(employeeId); 
	        DefaultTableModel model = (DefaultTableModel) tableLeave.getModel();
	        model.removeRow(selectedRow); 
	    }
	}
}