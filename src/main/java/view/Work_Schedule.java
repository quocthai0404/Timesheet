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
import DAO.Work_scheduleDAO;
import DAO.emprequestDAO;
import entity.EmployeeAfterLogin;

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
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Work_Schedule extends javax.swing.JInternalFrame {

    public Work_Schedule() {
    	getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle ("Employee");
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMaximumSize(new java.awt.Dimension(990, 550));
        setMinimumSize(new java.awt.Dimension(990, 550));
        setPreferredSize(new java.awt.Dimension(990, 550));
        getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 974, 76);
        getContentPane().add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Work_Schedule.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblNewLabel_1 = new JLabel("Work Schedule");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(271, 22, 356, 54);
        panel.add(lblNewLabel_1);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(29, 129, 382, 280);
        getContentPane().add(scrollPane);
        
        tableWork = new JTable();
        tableWork.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableWorkMouseClicked(e);
        	}
        });
        scrollPane.setViewportView(tableWork);
        
        btnPrevious = new JButton("Previous");
        btnPrevious.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnPreviousActionPerformed(e);
        	}
        });
        btnPrevious.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnPrevious.setBounds(29, 420, 103, 33);
        getContentPane().add(btnPrevious);
        
        btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNextActionPerformed(e);
        	}
        });
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnNext.setBounds(308, 420, 103, 33);
        getContentPane().add(btnNext);
        
        lblStatusPage = new JLabel("1/3");
        lblStatusPage.setBounds(202, 430, 35, 14);
        getContentPane().add(lblStatusPage);
        
        Work_Schedule_Id = new JLabel();
        Work_Schedule_Id.setText("Work schedule id   :");
        Work_Schedule_Id.setForeground(Color.BLACK);
        Work_Schedule_Id.setFont(new Font("Candara", Font.BOLD, 14));
        Work_Schedule_Id.setBounds(478, 130, 121, 30);
        getContentPane().add(Work_Schedule_Id);
        
        Work_Date = new JLabel();
        Work_Date.setText("Work date :");
        Work_Date.setForeground(Color.BLACK);
        Work_Date.setFont(new Font("Candara", Font.BOLD, 14));
        Work_Date.setBounds(478, 182, 110, 30);
        getContentPane().add(Work_Date);
        
        Work_Shift = new JLabel();
        Work_Shift.setText("Work shift :");
        Work_Shift.setForeground(Color.BLACK);
        Work_Shift.setFont(new Font("Candara", Font.BOLD, 14));
        Work_Shift.setBounds(478, 232, 110, 30);
        getContentPane().add(Work_Shift);
        
        textFieldWork_Schedule_Id = new JTextField();
        textFieldWork_Schedule_Id.setEditable(false);
        textFieldWork_Schedule_Id.setFont(new Font("Calibri", Font.BOLD, 14));
        textFieldWork_Schedule_Id.setBounds(609, 127, 249, 30);
        getContentPane().add(textFieldWork_Schedule_Id);
        
        dateChooserWork_Date = new JDateChooser();
        dateChooserWork_Date.setDateFormatString("yyyy-MM-dd");
        dateChooserWork_Date.setBounds(609, 182, 249, 33);
        getContentPane().add(dateChooserWork_Date);
        
        TextBoxReason = new JTextField();
        TextBoxReason.setColumns(10);
        TextBoxReason.setBounds(477, 310, 381, 99);
        getContentPane().add(TextBoxReason);
        
        Reason = new JLabel();
        Reason.setText("Reason :");
        Reason.setForeground(Color.BLACK);
        Reason.setFont(new Font("Candara", Font.BOLD, 14));
        Reason.setBounds(478, 273, 110, 30);
        getContentPane().add(Reason);
        
        btnNewButton = new JButton("Send");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnNewButtonActionPerformed(e);
        	}
        });
        btnNewButton.setBounds(738, 420, 121, 33);
        getContentPane().add(btnNewButton);
        
        btnRequest = new JButton("Request Change Schedule");
        btnRequest.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnRequestActionPerformed(e);
        	}
        });
        btnRequest.setBounds(478, 420, 187, 33);
        getContentPane().add(btnRequest);
        
        String descr[] = { "8h-12h", "13h-17h", "18h-22h", 
                "22h-6h"};
        comboBoxWorkShift = new JComboBox(descr);
        comboBoxWorkShift.setBounds(609, 232, 252, 30);
        getContentPane().add(comboBoxWorkShift);
        
        ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
        
        ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
		Image refreshImg = refreshIcon.getImage();
		Image newRefreshImg = refreshImg.getScaledInstance(32, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);

        setBounds(0, 0, 927, 589);
        hideAll();
        loadData();
    }// </editor-fold>//GEN-END:initComponents
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
    private JButton jButtonFind;
    private JButton btnRefresh;
    private JScrollPane scrollPane;
    private JButton btnPrevious;
    private JButton btnNext;
	private int firstPage = 1;
	private int rowOfPage = 10;
	private Double totalPage;
    private JLabel lblStatusPage;
    private JTable tableWork;
    private JLabel Work_Schedule_Id;
    private JLabel Work_Date;
    private JLabel Work_Shift;
    private JTextField textFieldWork_Schedule_Id;
    private JDateChooser dateChooserWork_Date;
    private JTextField TextBoxReason;
    private JLabel Reason;
    private JButton btnNewButton;
    private JButton btnRequest;
    private JComboBox comboBoxWorkShift;
    public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("WScheduleID");
		model.addColumn("EmpID");
		model.addColumn("WorkDate");
		model.addColumn("WShiftID");
		model.addColumn("Descr");
		model.addColumn("WType");
		Work_scheduleDAO dao = new Work_scheduleDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
//		dao.selectPaginateEmp(firstPage, rowOfPage).stream().forEach(emp -> {
//			String gender = emp.getGender() ? "Male" : "Female";
//			model.addRow(new Object[] { emp.getEmployee_id(), emp.getEmployee_name(), emp.getPosition(),
//					emp.getBirthday(), gender });
//		});
		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		ResultSet rs = dao.selectPaginateEWS(firstPage, rowOfPage);
		try {
			while(rs.next()) {
				model.addRow(new Object[] { rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4),
						rs.getString(5), rs.getString(6) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableWork.setModel(model);
	}
    protected void btnPreviousActionPerformed(ActionEvent e) {
		if (firstPage > 1) {
			firstPage--;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();
	}
	protected void btnNextActionPerformed(ActionEvent e) {
		Work_scheduleDAO dao = new Work_scheduleDAO();
		totalPage = Math.ceil(dao.countRow() / Double.valueOf(rowOfPage));
		if (firstPage < totalPage) {
			firstPage++;
		}

		lblStatusPage.setText(firstPage + "/" + totalPage.intValue());
		loadData();

	}
	public void hideAll() {
		Work_Schedule_Id.setVisible(false);
		textFieldWork_Schedule_Id.setVisible(false);
		Work_Date.setVisible(false);
		dateChooserWork_Date.setVisible(false);
		Work_Shift.setVisible(false);
		Reason.setVisible(false);
		TextBoxReason.setVisible(false);
		btnNewButton.setVisible(false);
		comboBoxWorkShift.setVisible(false);
		textFieldWork_Schedule_Id.setText("");
		dateChooserWork_Date.setDate(null);
		TextBoxReason.setText("");
		comboBoxWorkShift.setSelectedIndex(-1);
		
	}
	public void display() {
		Work_Schedule_Id.setVisible(true);
		textFieldWork_Schedule_Id.setVisible(true);
		Work_Date.setVisible(true);
		dateChooserWork_Date.setVisible(true);
		Work_Shift.setVisible(true);
		comboBoxWorkShift.setVisible(true);
		Reason.setVisible(true);
		TextBoxReason.setVisible(true);
		btnNewButton.setVisible(true);
		
	}
	protected void btnRequestActionPerformed(ActionEvent e) {
		if(textFieldWork_Schedule_Id.getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"please choose the work schedule want change");
		}else {
			display();
		}
	}
	protected void tableWorkMouseClicked(MouseEvent e) {
		
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = tableWork.getSelectedRow();
			textFieldWork_Schedule_Id.setText(tableWork.getValueAt(row, 0).toString());
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = df.parse(tableWork.getValueAt(row, 2).toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			dateChooserWork_Date.setDate(date);
			int workShiftID = Integer.parseInt(tableWork.getValueAt(row, 3).toString());
			comboBoxWorkShift.setSelectedIndex(workShiftID-1);
			
			

		}
	}
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		int w_sche_id = Integer.parseInt(textFieldWork_Schedule_Id.getText());
		Date work_date = dateChooserWork_Date.getDate();
		int work_shift_id = comboBoxWorkShift.getSelectedIndex()+1;
		String reason = TextBoxReason.getText();
		emprequestDAO dao = new emprequestDAO();
		dao.insert(w_sche_id, work_date, work_shift_id, reason, EmployeeAfterLogin.employeeID, EmployeeAfterLogin.employeeName);
		hideAll();
	}
}
