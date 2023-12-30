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

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Iqbal-Asi
 */
public class Review_Employee_Request extends javax.swing.JInternalFrame {

    public Review_Employee_Request() {
    	getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle ("Date Entry");
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWorktime = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"8h   -  12h", "13h - 17h ", "18h -  22h", "22h -  6h OT"}));

        setMaximumSize(new java.awt.Dimension(990, 550));
        setMinimumSize(new java.awt.Dimension(990, 550));
        setPreferredSize(new java.awt.Dimension(990, 550));
        getContentPane().setLayout(null);

        jLabelWorktime.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
        jLabelWorktime.setForeground(new Color(0, 0, 0));
        jLabelWorktime.setText("Work Time :");
        getContentPane().add(jLabelWorktime);
        jLabelWorktime.setBounds(588, 190, 100, 30);
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(708, 188, 118, 30);
        
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
        
        lblApproved = new JLabel("Approved :");
        lblApproved.setFont(new Font("Candara", Font.BOLD, 14));
        lblApproved.setBounds(588, 483, 85, 30);
        getContentPane().add(lblApproved);
        
        rdbtnYes = new JRadioButton("Yes");
        rdbtnYes.setBackground(new Color(128, 255, 255));
        rdbtnYes.setBounds(679, 485, 58, 23);
        getContentPane().add(rdbtnYes);
        
        rdbtnNo = new JRadioButton("No");
        rdbtnNo.setBackground(new Color(128, 255, 255));
        rdbtnNo.setBounds(771, 485, 58, 23);
        getContentPane().add(rdbtnNo);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(588, 271, 300, 175);
        getContentPane().add(textField);
        
        lblReason_1 = new JLabel("Reason :");
        lblReason_1.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason_1.setBounds(588, 244, 103, 16);
        getContentPane().add(lblReason_1);
        
        Employee_ID = new JLabel();
        Employee_ID.setText("Employee ID :");
        Employee_ID.setForeground(Color.BLACK);
        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
        Employee_ID.setBounds(588, 108, 110, 30);
        getContentPane().add(Employee_ID);
        
        textField_empID = new JLabel();
        textField_empID.setForeground(Color.BLACK);
        textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
        textField_empID.setBounds(679, 108, 118, 30);
        getContentPane().add(textField_empID);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 108, 442, 405);
        getContentPane().add(scrollPane);
        
        tableEmployee = new JTable();
        scrollPane.setViewportView(tableEmployee);
        
        btnPrevious = new JButton("Previous");
        btnPrevious.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnPreviousActionPerformed(e);
        	}
        });
        btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPrevious.setBounds(76, 522, 103, 33);
        getContentPane().add(btnPrevious);
        
        lblStatusPage = new JLabel("1/3");
        lblStatusPage.setBounds(285, 532, 35, 14);
        getContentPane().add(lblStatusPage);
        
        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNextActionPerformed(e);
        	}
        });
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNext.setBounds(413, 524, 103, 33);
        getContentPane().add(btnNext);
        
        Emp_Name = new JLabel();
        Emp_Name.setText("Employee Name :");
        Emp_Name.setForeground(Color.BLACK);
        Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
        Emp_Name.setBounds(588, 149, 110, 30);
        getContentPane().add(Emp_Name);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_1.setBounds(708, 149, 180, 30);
        getContentPane().add(textField_1);

        setBounds(0, 0, 1025, 629);
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelWorktime;
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
    private JLabel lblApproved;
    private JRadioButton rdbtnYes;
    private JRadioButton rdbtnNo;
    private JTextField textField;
    private JLabel lblReason_1;
    private JLabel Employee_ID;
    private JLabel textField_empID;
    private JScrollPane scrollPane;
    private JTable tableEmployee;
    private JButton btnPrevious;
    private JLabel lblStatusPage;
    private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
    private JButton btnNext;
    private JLabel Emp_Name;
    private JTextField textField_1;
    public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Employee Name");
		model.addColumn("Position");
		model.addColumn("Birthday");
		model.addColumn("Gender");
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		dao.selectPaginateEmp(firstPage, rowOfPage).stream().forEach(emp -> {
			String gender = emp.getGender() ? "Male" : "Female";
			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
					emp.getBirthday(), gender });
		});
//		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		tableEmployee.setModel(model);
	}
    protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		EmployeeDAO dao = new EmployeeDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		if (firstPage < totalPage) {
			firstPage++;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();

	}
	
}
