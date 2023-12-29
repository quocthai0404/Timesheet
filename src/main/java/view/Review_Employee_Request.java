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
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
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

        jLabelWorktime.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabelWorktime.setForeground(new Color(0, 0, 0));
        jLabelWorktime.setText("Work Time");
        getContentPane().add(jLabelWorktime);
        jLabelWorktime.setBounds(71, 221, 100, 30);
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(181, 220, 108, 30);
        
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

        setBounds(0, 0, 990, 550);
    }// </editor-fold>//GEN-END:initComponents
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabelWorktime;
    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
}
