/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

public class CheckInAndCheckOut extends javax.swing.JInternalFrame {

    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
    private JButton jButtonFind;
    private JButton btnRefresh;
    private JButton btnCheckIn;
    private JButton btnCheckOut;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnNewButton;

    public CheckInAndCheckOut() {
        getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle("Employee");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setMaximumSize(new Dimension(990, 550));
        setMinimumSize(new Dimension(990, 550));
        setPreferredSize(new Dimension(990, 550));
        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 974, 76);
        getContentPane().add(panel);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(CheckInAndCheckOut.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);

        lblNewLabel_1 = new JLabel("CheckIn And CheckOut");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(270, 11, 648, 54);
        panel.add(lblNewLabel_1);

       

        setBounds(0, 0, 927, 589);

        btnCheckIn = new JButton("");
        btnCheckIn.setBounds(105, 103, 200, 132);  // Adjust width and height accordingly
        getContentPane().add(btnCheckIn);

        btnCheckOut = new JButton("");
        btnCheckOut.setBounds(669, 103, 200, 132); // Adjust width and height accordingly
        getContentPane().add(btnCheckOut);

        // Set images for buttons with adjusted sizes
        ImageIcon checkInIcon = new ImageIcon(CheckInAndCheckOut.class.getResource("/checkIn.png"));
        Image checkInImg = checkInIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        btnCheckIn.setIcon(new ImageIcon(checkInImg));

        ImageIcon checkOutIcon = new ImageIcon(CheckInAndCheckOut.class.getResource("/checkOut.png"));
        Image checkOutImg = checkOutIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        btnCheckOut.setIcon(new ImageIcon(checkOutImg));
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(105, 246, 764, 209);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        btnNewButton = new JButton("OK");
        btnNewButton.setBounds(105, 466, 144, 44);
        getContentPane().add(btnNewButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CheckInAndCheckOut().setVisible(true);
        });
    }
}
