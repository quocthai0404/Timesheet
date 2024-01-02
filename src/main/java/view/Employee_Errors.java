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

public class Employee_Errors extends javax.swing.JInternalFrame {

    public Employee_Errors() {
    	getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle ("Employee");
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
        jLabelWorktime.setBounds(82, 246, 100, 30);
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(195, 244, 180, 30);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 891, 76);
        getContentPane().add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Employee_Errors.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblNewLabel_1 = new JLabel("Error And Leave");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(174, 11, 648, 54);
        panel.add(lblNewLabel_1);
        
        lblReason_1 = new JLabel("Leave Days :");
        lblReason_1.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason_1.setBounds(82, 326, 103, 27);
        getContentPane().add(lblReason_1);
        
        Employee_ID = new JLabel();
        Employee_ID.setText("Employee ID :");
        Employee_ID.setForeground(Color.BLACK);
        Employee_ID.setFont(new Font("Candara", Font.BOLD, 14));
        Employee_ID.setBounds(82, 158, 110, 30);
        getContentPane().add(Employee_ID);
        
        textField_empID = new JLabel();
        textField_empID.setForeground(Color.BLACK);
        textField_empID.setFont(new Font("Candara", Font.BOLD, 14));
        textField_empID.setBounds(203, 158, 172, 30);
        getContentPane().add(textField_empID);
        
        Emp_Name = new JLabel();
        Emp_Name.setText("Employee Name :");
        Emp_Name.setForeground(Color.BLACK);
        Emp_Name.setFont(new Font("Candara", Font.BOLD, 14));
        Emp_Name.setBounds(82, 203, 110, 30);
        getContentPane().add(Emp_Name);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_1.setBounds(195, 203, 180, 30);
        getContentPane().add(textField_1);
        
        textField = new JTextField();
        textField.setFont(new Font("Calibri", Font.BOLD, 14));
        textField.setBounds(195, 324, 180, 30);
        getContentPane().add(textField);
        
        lblReason = new JLabel("Count Error :");
        lblReason.setFont(new Font("Candara", Font.BOLD, 14));
        lblReason.setBounds(82, 285, 103, 30);
        getContentPane().add(lblReason);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Calibri", Font.BOLD, 14));
        textField_2.setBounds(195, 285, 180, 30);
        getContentPane().add(textField_2);
        
        ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
        
        ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
		Image refreshImg = refreshIcon.getImage();
		Image newRefreshImg = refreshImg.getScaledInstance(32, 30, java.awt.Image.SCALE_SMOOTH);
		ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);

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
    private JLabel Emp_Name;
    private JTextField textField_1;
    private JTextField textField;
    private JLabel lblReason;
    private JTextField textField_2;
    private JButton jButtonFind;
    private JButton btnRefresh;
   
}
