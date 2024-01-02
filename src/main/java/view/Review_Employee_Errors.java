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
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Review_Employee_Errors extends javax.swing.JInternalFrame {

    public Review_Employee_Errors() {
    	getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle ("Admin");
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWorktime = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox1.setModel(new DefaultComboBoxModel(new String[] {""}));

        setMaximumSize(new java.awt.Dimension(990, 550));
        setMinimumSize(new java.awt.Dimension(990, 550));
        setPreferredSize(new java.awt.Dimension(990, 550));
        getContentPane().setLayout(null);

        jLabelWorktime.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
        jLabelWorktime.setForeground(new Color(0, 0, 0));
        jLabelWorktime.setText("Error Type :");
        getContentPane().add(jLabelWorktime);
        jLabelWorktime.setBounds(573, 244, 100, 30);
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(708, 244, 180, 30);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 891, 76);
        getContentPane().add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Review_Employee_Errors.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblNewLabel_1 = new JLabel("Employee Error And Leave");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(174, 11, 648, 54);
        panel.add(lblNewLabel_1);
        
        lblReason_1 = new JLabel("Leave Days :");
        lblReason_1.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason_1.setBounds(573, 326, 103, 27);
        getContentPane().add(lblReason_1);
        
        Employee_ID = new JLabel();
        Employee_ID.setText("Employee ID :");
        Employee_ID.setForeground(Color.BLACK);
        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
        Employee_ID.setBounds(573, 158, 110, 30);
        getContentPane().add(Employee_ID);
        
        textField_empID = new JLabel();
        textField_empID.setForeground(Color.BLACK);
        textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
        textField_empID.setBounds(708, 158, 118, 30);
        getContentPane().add(textField_empID);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 158, 442, 274);
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
        btnPrevious.setBounds(76, 466, 103, 33);
        getContentPane().add(btnPrevious);
        
        lblStatusPage = new JLabel("1/3");
        lblStatusPage.setBounds(269, 476, 35, 14);
        getContentPane().add(lblStatusPage);
        
        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNextActionPerformed(e);
        	}
        });
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNext.setBounds(415, 466, 103, 33);
        getContentPane().add(btnNext);
        
        Emp_Name = new JLabel();
        Emp_Name.setText("Employee Name :");
        Emp_Name.setForeground(Color.BLACK);
        Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
        Emp_Name.setBounds(573, 203, 110, 30);
        getContentPane().add(Emp_Name);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_1.setBounds(708, 203, 180, 30);
        getContentPane().add(textField_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Calibri", Font.BOLD, 14));
        textField.setBounds(708, 324, 180, 30);
        getContentPane().add(textField);
        
        lblReason = new JLabel("Count Error :");
        lblReason.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason.setBounds(573, 285, 103, 30);
        getContentPane().add(lblReason);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_2.setBounds(708, 285, 180, 30);
        getContentPane().add(textField_2);
        
        btnUpdateEmp = new JButton();
        btnUpdateEmp.setIcon(new ImageIcon(Review_Employee_Errors.class.getResource("/update.png")));
        btnUpdateEmp.setFont(new Font("Candara", Font.BOLD, 12));
        btnUpdateEmp.setBorderPainted(false);
        btnUpdateEmp.setBorder(null);
        btnUpdateEmp.setBounds(573, 466, 110, 30);
        getContentPane().add(btnUpdateEmp);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_3.setBounds(121, 108, 180, 33);
        getContentPane().add(textField_3);
        
        ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
		JButton jButtonFind = new JButton();
		jButtonFind.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        jButtonFindActionPerformed(e);
		    }
		});
		jButtonFind.setIcon(newIcon1);
		jButtonFind.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonFind.setBorderPainted(false);
		jButtonFind.setBorder(null);
		jButtonFind.setBounds(311, 108, 30, 30); 
        getContentPane().add(jButtonFind);
        
        ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
		Image refreshImg = refreshIcon.getImage();
		Image newRefreshImg = refreshImg.getScaledInstance(32, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);

		JButton btnRefresh = new JButton();
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRefreshActionPerformed(e);
			}
		});
		
		btnRefresh.setIcon(newRefreshIcon);
		btnRefresh.setFont(new Font("Candara", Font.BOLD, 12));
		btnRefresh.setBorderPainted(false);
		btnRefresh.setBorder(null);
		btnRefresh.setBounds(76, 108, 32, 30); //
        getContentPane().add(btnRefresh);

        setBounds(0, 0, 927, 589);
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelWorktime;
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
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
    private JTextField textField;
    private JLabel lblReason;
    private JTextField textField_2;
    private JButton btnUpdateEmp;
    private JTextField textField_3;
    private JButton jButtonFind;
    private JButton btnRefresh;
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
	protected void jButtonFindActionPerformed(ActionEvent e) {
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
	}
}
