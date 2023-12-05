package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.EmployeeDAO;
import DAO.LeaveDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;

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
	private JTextField textField;
	private JLabel lblApproved;
	private JRadioButton rdbtnYes;
	private JRadioButton rdbtnNo;

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
        
        textField = new JTextField();
        textField.setColumns(10);
        
        lblApproved = new JLabel("Approved");
        
        rdbtnYes = new JRadioButton("Yes");
        rdbtnYes.setSelected(true);
        
        rdbtnNo = new JRadioButton("No");
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(89)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(btnPrevious, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        					.addGap(218)
        					.addComponent(lblStatusPage, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE))
        			.addGap(47)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lblApproved, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblNumsDate, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        				.addComponent(lblStartDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblLeaveType, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lblEmpId, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        					.addComponent(txtLeaveType)
        					.addComponent(txtEmpId, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        					.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(textField))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(rdbtnYes, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(rdbtnNo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(82)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addComponent(lblEmpId)
        							.addGap(28)
        							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(lblLeaveType)
        								.addComponent(txtLeaveType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(txtEmpId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(31)
        							.addComponent(lblStartDate))
        						.addGroup(groupLayout.createSequentialGroup()
        							.addGap(28)
        							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        					.addGap(28)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblNumsDate)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        					.addGap(45)
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblApproved)
        						.addComponent(rdbtnYes)
        						.addComponent(rdbtnNo))))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnPrevious)
        				.addComponent(lblStatusPage)
        				.addComponent(btnNext))
        			.addContainerGap(115, Short.MAX_VALUE))
        );
        
        tableLeave = new JTable();
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
}
