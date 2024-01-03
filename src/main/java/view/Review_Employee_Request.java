/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.EmployeeDAO;
import DAO.emprequestDAO;
import DAO.Work_scheduleDAO;
import DAO.Work_shiftDAO;
import entity.WorkShift;
import entity.Work_schedule;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.desktop.UserSessionEvent.Reason;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/**
 *
 * @author Iqbal-Asi
 */
public class Review_Employee_Request extends javax.swing.JInternalFrame {

	public Review_Employee_Request() {
		getContentPane().setBackground(new Color(128, 255, 255));
		initComponents();
		setTitle("Admin");
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabelWorktime = new javax.swing.JLabel();


        jLabelWorktime.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
        jLabelWorktime.setForeground(new Color(0, 0, 0));
        jLabelWorktime.setText("Work Time :");
        getContentPane().add(jLabelWorktime);
        jLabelWorktime.setBounds(588, 235, 100, 30);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 974, 76);
        getContentPane().add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Review_Employee_Request.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblNewLabel_1 = new JLabel("Review Employee Request");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(209, 11, 755, 54);
        panel.add(lblNewLabel_1);
        
//        textField_reason = new JTextField();
//        textField_reason.setColumns(10);
//        textField_reason.setBounds(588, 306, 300, 126);
//        getContentPane().add(textField_reason);
        
        lblReason_1 = new JLabel("Reason :");
        lblReason_1.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason_1.setBounds(588, 279, 103, 16);
        getContentPane().add(lblReason_1);
        
        Employee_ID = new JLabel();
        Employee_ID.setText("Employee ID :");
        Employee_ID.setForeground(Color.BLACK);
        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
        Employee_ID.setBounds(588, 160, 110, 23);
        getContentPane().add(Employee_ID);
        
        textField_empID = new JLabel();
        textField_empID.setForeground(Color.BLACK);
        textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
        textField_empID.setBounds(711, 153, 177, 30);
        getContentPane().add(textField_empID);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 158, 442, 274);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        
        btnPrevious = new JButton("Previous");
        btnPrevious.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnPreviousActionPerformed(e);
        	}
        });
        btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPrevious.setBounds(76, 466, 103, 33);
        getContentPane().add(btnPrevious);
        
        lblStatusPage = new JLabel("1/3");
        lblStatusPage.setBounds(274, 476, 35, 14);
        getContentPane().add(lblStatusPage);
        
        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNextActionPerformed(e);
        	}
        });
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNext.setBounds(414, 466, 103, 33);
        getContentPane().add(btnNext);
        
        Emp_Name = new JLabel();
        Emp_Name.setText("Employee Name :");
        Emp_Name.setForeground(Color.BLACK);
        Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
        Emp_Name.setBounds(588, 194, 110, 30);
        getContentPane().add(Emp_Name);
        
//        textField_EmpName = new JTextField();
//        textField_EmpName.setFont(new Font("Calibri", Font.BOLD, 14));
//        textField_EmpName.setBounds(708, 194, 180, 30);
//        getContentPane().add(textField_EmpName);
        
        btnAccept = new JButton("Accept\r\n");
        btnAccept.setBounds(588, 466, 76, 33);
        getContentPane().add(btnAccept);
        
        btnReject = new JButton("Reject");
        btnReject.setBounds(711, 466, 85, 33);
        getContentPane().add(btnReject);
        
//        comboBox = new JComboBox();
//        comboBox.setBounds(708, 235, 180, 30);
//        getContentPane().add(comboBox);

		setMaximumSize(new java.awt.Dimension(990, 550));
		setMinimumSize(new java.awt.Dimension(990, 550));
		setPreferredSize(new java.awt.Dimension(990, 550));
		getContentPane().setLayout(null);


		jLabelWorktime.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
		jLabelWorktime.setForeground(new Color(0, 0, 0));
		jLabelWorktime.setText("Work Time :");
		getContentPane().add(jLabelWorktime);
		jLabelWorktime.setBounds(588, 235, 100, 30);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 974, 76);
		getContentPane().add(panel);
		
		lblStatusPage = new JLabel("1/?");
		lblStatusPage.setBounds(274, 476, 35, 14);
		getContentPane().add(lblStatusPage);

		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Review_Employee_Request.class.getResource("/aptech_logo.png")));
		lblLogo.setBounds(10, 0, 154, 76);
		panel.add(lblLogo);

		lblNewLabel_1 = new JLabel("Review Employee Request");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
		lblNewLabel_1.setBounds(209, 11, 755, 54);
		panel.add(lblNewLabel_1);

		textReason = new JTextField();
		textReason.setColumns(10);
		textReason.setBounds(588, 306, 300, 126);
		getContentPane().add(textReason);

		lblReason_1 = new JLabel("Reason :");
		lblReason_1.setFont(new Font("Candara", Font.BOLD, 14));
		lblReason_1.setBounds(588, 279, 103, 16);
		getContentPane().add(lblReason_1);

		Employee_ID = new JLabel();
		Employee_ID.setText("Employee ID :");
		Employee_ID.setForeground(Color.BLACK);
		Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
		Employee_ID.setBounds(588, 160, 110, 23);
		getContentPane().add(Employee_ID);

		textField_empID = new JLabel();
		textField_empID.setForeground(Color.BLACK);
		textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
		textField_empID.setBounds(711, 153, 177, 30);
		getContentPane().add(textField_empID);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 158, 442, 274);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				do_table_mouseClicked(e);
			}
		});
		loadData();

		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPreviousActionPerformed(e);
			}
		});
		btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnPrevious.setBounds(76, 466, 103, 33);
		getContentPane().add(btnPrevious);

		

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNext.setBounds(414, 466, 103, 33);
		getContentPane().add(btnNext);

		Emp_Name = new JLabel();
		Emp_Name.setText("Employee Name :");
		Emp_Name.setForeground(Color.BLACK);
		Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
		Emp_Name.setBounds(588, 194, 110, 30);
		getContentPane().add(Emp_Name);

		textEmpName = new JTextField();
		textEmpName.setFont(new Font("Calibri", Font.BOLD, 14));
		textEmpName.setBounds(708, 194, 180, 30);
		getContentPane().add(textEmpName);

		btnAccept = new JButton("Accept\r\n");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnAccept_actionPerformed(e);
			}
		});
		btnAccept.setBounds(588, 466, 76, 33);
		getContentPane().add(btnAccept);

		btnReject = new JButton("Reject");
		btnReject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnReject_actionPerformed(e);
			}
		});
		btnReject.setBounds(711, 466, 85, 33);
		getContentPane().add(btnReject);

		textWorkTime = new JTextField();
		textWorkTime.setFont(new Font("Calibri", Font.BOLD, 14));
		textWorkTime.setBounds(708, 238, 180, 30);
		getContentPane().add(textWorkTime);

		setBounds(0, 0, 1025, 629);
	}// </editor-fold>//GEN-END:initComponents

	private javax.swing.JLabel jLabelWorktime;
	private JPanel panel;
	private JLabel lblLogo;
	private JLabel lblNewLabel_1;
	private JTextField textReason;
	private JLabel lblReason_1;
	private JLabel Employee_ID;
	private JLabel textField_empID;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnPrevious;
	private JLabel lblStatusPage;
	private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
	private JButton btnNext;
	private JLabel Emp_Name;
	private JTextField textEmpName;
	private JButton btnAccept;
	private JButton btnReject;
	private JTextField textWorkTime;

	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Work Schedule Id");
		model.addColumn("Work Date");
		model.addColumn("Work Shift Id");
		model.addColumn("Reason");
		model.addColumn("Is Accepted");
		emprequestDAO dao = new emprequestDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.selectUnCheckedEmprequests(firstPage, rowOfPage).stream().forEach(emp -> {
			String isaccept = emp.isIsaccept() ? "Yes" : "No";
			model.addRow(new Object[] { emp.getId(), emp.getWork_schedule_id(), emp.getWork_date(),
					emp.getWork_shift_id(), emp.getReason(), isaccept });
		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		table.setModel(model);
	}

	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}

	protected void btnNextActionPerformed(ActionEvent e) {
		emprequestDAO dao = new emprequestDAO();
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
			Work_scheduleDAO dao = new Work_scheduleDAO();
			Work_schedule ws = dao.selectFromId(Integer.parseInt(table.getValueAt(row, 1).toString()));
			textField_empID.setText(String.valueOf(ws.getEmployee_id()));
			EmployeeDAO empDao = new EmployeeDAO();
			textEmpName.setText(String.valueOf(empDao.findNameFromId(ws.getEmployee_id())));
			Work_shiftDAO shiftDao = new Work_shiftDAO();
			textWorkTime.setText(shiftDao.selectDesFromId(Integer.parseInt(table.getValueAt(row, 3).toString())));
			textReason.setText(table.getValueAt(row, 4).toString());
		}
	}
	
	protected void do_btnReject_actionPerformed(ActionEvent e) {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui long chon dong can update");
			return;
		}
		int row = table.getSelectedRow();
		emprequestDAO dao = new emprequestDAO();
		dao.delete(Integer.parseInt(table.getValueAt(row, 0).toString()));
		loadData();
		
	}
	protected void do_btnAccept_actionPerformed(ActionEvent e) {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui long chon dong can update");
			return;
		}
		int row = table.getSelectedRow();
		emprequestDAO dao = new emprequestDAO();
		dao.updateStatus(Integer.parseInt(table.getValueAt(row, 0).toString()));
		Work_scheduleDAO wsdao = new Work_scheduleDAO();
		int workShiftId = Integer.parseInt(table.getValueAt(row, 3).toString());
		int workScheduleId = Integer.parseInt(table.getValueAt(row, 1).toString());
		Date newDate = (Date) table.getValueAt(row, 2);
		wsdao.updateWSAfterRequest(workShiftId,newDate, workScheduleId);
		dao.delete(Integer.parseInt(table.getValueAt(row, 0).toString()));
		loadData();
	}
}
