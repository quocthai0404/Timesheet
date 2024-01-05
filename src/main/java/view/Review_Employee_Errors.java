/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.EmployeeDAO;
import DAO.Salary_deductionDAO;

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
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Review_Employee_Errors extends javax.swing.JInternalFrame {

    public Review_Employee_Errors() {
    	getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle ("Admin");
        loadData();
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelWorktime = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(990, 550));
        setMinimumSize(new java.awt.Dimension(990, 550));
        setPreferredSize(new java.awt.Dimension(990, 550));
        getContentPane().setLayout(null);

        jLabelWorktime.setFont(new Font("Candara", Font.BOLD, 14)); // NOI18N
        jLabelWorktime.setForeground(new Color(0, 0, 0));
        jLabelWorktime.setText("Reason");
        getContentPane().add(jLabelWorktime);
        jLabelWorktime.setBounds(573, 244, 100, 30);
        
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
        
        lblNewLabel_1 = new JLabel("Employee Mistake");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(271, 22, 425, 54);
        panel.add(lblNewLabel_1);
        
        Employee_ID = new JLabel();
        Employee_ID.setText("Employee ID :");
        Employee_ID.setForeground(Color.BLACK);
        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
        Employee_ID.setBounds(573, 158, 110, 30);
        getContentPane().add(Employee_ID);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(76, 158, 442, 274);
        getContentPane().add(scrollPane);
        
        tableEmployee = new JTable();
        tableEmployee.setRowHeight(30);
        tableEmployee.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableEmployeeMouseClicked(e);
        	}
        });
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
        
        textFieldEmpName = new JTextField();
        textFieldEmpName.setEditable(false);
        textFieldEmpName.setFont(new Font("Calibri", Font.BOLD, 14));
        textFieldEmpName.setBounds(708, 203, 180, 30);
        getContentPane().add(textFieldEmpName);
        
        lblReason = new JLabel("Count Error :");
        lblReason.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason.setBounds(573, 285, 103, 30);
        getContentPane().add(lblReason);
        
        textField_CountError = new JTextField();
        textField_CountError.setEditable(false);
        textField_CountError.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_CountError.setBounds(708, 285, 180, 30);
        getContentPane().add(textField_CountError);
        
        btnUpdateError = new JButton();
        btnUpdateError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnUpdateErrorActionPerformed(e);
        	}
        });
        btnUpdateError.setIcon(new ImageIcon(Review_Employee_Errors.class.getResource("/update.png")));
        btnUpdateError.setFont(new Font("Candara", Font.BOLD, 12));
        btnUpdateError.setBorderPainted(false);
        btnUpdateError.setBorder(null);
        btnUpdateError.setBounds(573, 466, 110, 30);
        getContentPane().add(btnUpdateError);
        
        textField_SearchID = new JTextField();
        textField_SearchID.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_SearchID.setBounds(189, 108, 180, 33);
        getContentPane().add(textField_SearchID);
        
        ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
		JButton jButtonSearch = new JButton();
		jButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonSearchActionPerformed(e);
			}
		});
		
		jButtonSearch.setIcon(new ImageIcon(Review_Employee_Errors.class.getResource("/view.png")));
		jButtonSearch.setFont(new Font("Candara", Font.BOLD, 12));
		jButtonSearch.setBorderPainted(false);
		jButtonSearch.setBorder(null);
		jButtonSearch.setBounds(379, 108, 30, 30); 
        getContentPane().add(jButtonSearch);
        
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
		btnRefresh.setBounds(422, 108, 32, 30); //
        getContentPane().add(btnRefresh);
        
        lblNewLabel = new JLabel("Employee ID:");
        lblNewLabel.setBounds(76, 116, 103, 13);
        getContentPane().add(lblNewLabel);
        
        textField_empID = new JTextField();
        textField_empID.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_empID.setBounds(708, 158, 180, 30);
        getContentPane().add(textField_empID);
        
        deduction = new JLabel();
        deduction.setText("Deduction amount:");
        deduction.setForeground(Color.BLACK);
        deduction.setFont(new Font("Candara", Font.BOLD, 14));
        deduction.setBounds(573, 328, 127, 30);
        getContentPane().add(deduction);
        
        textField_amount = new JTextField();
        textField_amount.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_amount.setBounds(708, 325, 180, 30);
        getContentPane().add(textField_amount);
        
        textField_reason = new JTextField();
        textField_reason.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_reason.setBounds(708, 248, 180, 30);
        getContentPane().add(textField_reason);
        
        lblDate = new JLabel();
        lblDate.setText("Date:");
        lblDate.setForeground(Color.BLACK);
        lblDate.setFont(new Font("Candara", Font.BOLD, 14));
        lblDate.setBounds(573, 371, 127, 30);
        getContentPane().add(lblDate);
        
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setBounds(708, 371, 183, 30);
        getContentPane().add(dateChooser);
        
        jButtonSearchLoadEmp = new JButton();
        jButtonSearchLoadEmp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jButtonSearchLoadEmpActionPerformed(e);
        	}
        });
        jButtonSearchLoadEmp.setIcon(new ImageIcon(Review_Employee_Errors.class.getResource("/view.png")));
        
        jButtonSearchLoadEmp.setFont(new Font("Candara", Font.BOLD, 12));
        jButtonSearchLoadEmp.setBorderPainted(false);
        jButtonSearchLoadEmp.setBorder(null);
        jButtonSearchLoadEmp.setBounds(898, 158, 30, 30);
        getContentPane().add(jButtonSearchLoadEmp);
        
        btnAddError = new JButton();
        btnAddError.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnAddErrorActionPerformed(e);
        	}
        });
        btnAddError.setIcon(new ImageIcon(Review_Employee_Errors.class.getResource("/add.png")));
        btnAddError.setFont(new Font("Candara", Font.BOLD, 12));
        btnAddError.setBorderPainted(false);
        btnAddError.setBorder(null);
        btnAddError.setBounds(708, 466, 110, 30);
        getContentPane().add(btnAddError);
        
        SD_id = new JTextField();
        SD_id.setVisible(false);
        SD_id.setFont(new Font("Calibri", Font.BOLD, 14));
        SD_id.setBounds(708, 113, 180, 30);
        getContentPane().add(SD_id);

        setBounds(0, 0, 927, 589);
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JLabel jLabelWorktime;
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
    private JLabel Employee_ID;
    private JScrollPane scrollPane;
    private JTable tableEmployee;
    private JButton btnPrevious;
    private JLabel lblStatusPage;
    private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
    private JButton btnNext;
    private JLabel Emp_Name;
    private JTextField textFieldEmpName;
    private JLabel lblReason;
    private JTextField textField_CountError;
    private JButton btnUpdateError;
    private JTextField textField_SearchID;
    private JButton jButtonFind;
    private JButton btnRefresh;
    private JLabel lblNewLabel;
    private JTextField textField_empID;
    private JLabel deduction;
    private JTextField textField_amount;
    private JTextField textField_reason;
    private JLabel lblDate;
    private JDateChooser dateChooser;
    private JButton jButtonSearchLoadEmp;
    private JButton btnAddError;
    private JTextField SD_id;
    public void loadData() {
    	DefaultTableModel model = new DefaultTableModel();
    	model.addColumn("ID");
    	model.addColumn("Employee ID");
    	model.addColumn("Reason");
    	model.addColumn("Amount");
    	model.addColumn("Date");
    	Salary_deductionDAO dao = new Salary_deductionDAO();
    	totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
    	dao.selectPaginateEmp(firstPage, rowOfPage).stream().forEach(sal -> {
    		model.addRow(new Object[] { sal.getSalary_deduction_id(), sal.getEmployee_id(), sal.getDeduction_reason(),
    			sal.getDeduction_amount(), sal.getDeduction_date()	});
    	});
    	lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
    	tableEmployee.setModel(model);

    }
    
    
	protected void btnNextActionPerformed(ActionEvent e) {
		Salary_deductionDAO dao = new Salary_deductionDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		if (firstPage < totalPage) {
			firstPage++;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}
	protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}
	protected void tableEmployeeMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = tableEmployee.getSelectedRow();
			SD_id.setText(tableEmployee.getValueAt(row, 0).toString());
			textField_empID.setText(tableEmployee.getValueAt(row, 1).toString());
			textField_reason.setText(tableEmployee.getValueAt(row, 2).toString());
			textField_amount.setText(tableEmployee.getValueAt(row, 3).toString());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = df.parse(tableEmployee.getValueAt(row, 4).toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			Salary_deductionDAO dao = new Salary_deductionDAO();
			dateChooser.setDate(date);
			int id = Integer.parseInt(tableEmployee.getValueAt(row, 1).toString());
			textFieldEmpName.setText(
					dao.getEmpNameByID(
							id)
					.getEmployee_name());
			textField_CountError.setText(String.valueOf(dao.countError(id)));

		}
	}
	protected void jButtonSearchActionPerformed(ActionEvent e) {
		if(textField_SearchID.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "please input the id of employee");
			return;
		}
		DefaultTableModel model = new DefaultTableModel();
    	model.addColumn("ID");
    	model.addColumn("Employee ID");
    	model.addColumn("Reason");
    	model.addColumn("Amount");
    	model.addColumn("Date");
		Salary_deductionDAO dao = new Salary_deductionDAO();
    	dao.searchByid(Integer.parseInt(textField_SearchID.getText())).stream().forEach(sal -> {
    		model.addRow(new Object[] { sal.getSalary_deduction_id(), sal.getEmployee_id(), sal.getDeduction_reason(),
    			sal.getDeduction_amount(), sal.getDeduction_date()	});
    	});
    	lblStatusPage.setText("");
    	tableEmployee.setModel(model);
    	textFieldEmpName.setText(
				dao.getEmpNameByID(
						Integer.parseInt(textField_SearchID.getText()))
				.getEmployee_name());
		textField_CountError.setText(String.valueOf(dao.countError(Integer.parseInt(textField_SearchID.getText()))));
	}
	protected void jButtonSearchLoadEmpActionPerformed(ActionEvent e) {
		if(textField_empID.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "please input the id of employee");
			return;
		}
		Salary_deductionDAO dao = new Salary_deductionDAO();
		textFieldEmpName.setText(
				dao.getEmpNameByID(
						Integer.parseInt(textField_empID.getText()))
				.getEmployee_name());
		textField_CountError.setText(String.valueOf(dao.countError(Integer.parseInt(textField_empID.getText()))));
		
		DefaultTableModel model = new DefaultTableModel();
    	model.addColumn("ID");
    	model.addColumn("Employee ID");
    	model.addColumn("Reason");
    	model.addColumn("Amount");
    	model.addColumn("Date");
    	dao.searchByid(Integer.parseInt(textField_empID.getText())).stream().forEach(sal -> {
    		model.addRow(new Object[] { sal.getSalary_deduction_id(), sal.getEmployee_id(), sal.getDeduction_reason(),
    			sal.getDeduction_amount(), sal.getDeduction_date()	});
    	});
    	lblStatusPage.setText("");
    	tableEmployee.setModel(model);
	}
	public void refresh() {
		textField_SearchID.setText("");
		textField_empID.setText("");
		textFieldEmpName.setText("");
		textField_reason.setText("");
		textField_CountError.setText("");
		textField_amount.setText("");
		dateChooser.setDate(null);
		loadData();
	}
	protected void btnRefreshActionPerformed(ActionEvent e) {
		refresh();
	}
	
	protected void btnUpdateErrorActionPerformed(ActionEvent e) {
		Salary_deductionDAO dao = new Salary_deductionDAO();
		int sd_id = Integer.parseInt(SD_id.getText());
		int emp_id = Integer.parseInt(textField_empID.getText());
		String reason = textField_reason.getText();
		Double amount = Double.parseDouble(textField_amount.getText());
		Date date = dateChooser.getDate();
		dao.update(sd_id, emp_id, reason, amount, date);
		refresh();
	}
	protected void btnAddErrorActionPerformed(ActionEvent e) {
		Salary_deductionDAO dao = new Salary_deductionDAO();
		int sd_id = Integer.parseInt(SD_id.getText());
		int emp_id = Integer.parseInt(textField_empID.getText());
		String reason = textField_reason.getText();
		Double amount = Double.parseDouble(textField_amount.getText());
		Date date = dateChooser.getDate();
		dao.add(emp_id, reason, amount, date);
		refresh();
	}
}
