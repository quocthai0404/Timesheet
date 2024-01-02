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
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class Employee_Request extends javax.swing.JInternalFrame {

    public Employee_Request() {
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
        panel.setBounds(0, 0, 891, 76);
        getContentPane().add(panel);
        
        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(Employee_Request.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);
        
        lblNewLabel_1 = new JLabel("Request Here");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(243, 11, 356, 54);
        panel.add(lblNewLabel_1);
        
        lblReason = new JLabel("Reason :");
        lblReason.setFont(new Font("Candara", Font.PLAIN, 22));
        lblReason.setBounds(98, 161, 145, 30);
        getContentPane().add(lblReason);
        
        textAreaReason = new JTextArea();
        textAreaReason.setFont(new Font("Candara", Font.BOLD, 14));
        textAreaReason.setBounds(98, 222, 474, 196);
        getContentPane().add(textAreaReason);
        
        btnSend = new JButton("Send");
        btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSend.setBounds(98, 438, 118, 42);
        getContentPane().add(btnSend);
        
        lblLeaveType = new JLabel("Work Type :");
        lblLeaveType.setFont(new Font("Candara", Font.PLAIN, 22));
        lblLeaveType.setBounds(98, 114, 145, 30);
        getContentPane().add(lblLeaveType);
        
        jComboBox1 = new JComboBox<String>();
        jComboBox1.setBounds(245, 113, 327, 30);
        getContentPane().add(jComboBox1);
        
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
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
    private JButton jButtonFind;
    private JButton btnRefresh;
    private JLabel lblReason;
    private JTextArea textAreaReason;
    private JButton btnSend;
    private JLabel lblLeaveType;
    private JComboBox<String> jComboBox1;
}
