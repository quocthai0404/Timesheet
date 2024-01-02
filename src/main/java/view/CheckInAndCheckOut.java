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
        panel.setBounds(0, 0, 891, 76);
        getContentPane().add(panel);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(CheckInAndCheckOut.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);

        lblNewLabel_1 = new JLabel("CheckIn And CheckOut");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(174, 11, 648, 54);
        panel.add(lblNewLabel_1);

        ImageIcon icon1 = new ImageIcon(AdminFrame.class.getResource("/search.png"));
        Image img1 = icon1.getImage();
        Image newImg1 = img1.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon newIcon1 = new ImageIcon(newImg1);

        ImageIcon refreshIcon = new ImageIcon(AdminFrame.class.getResource("/refresh-page-option.png"));
        Image refreshImg = refreshIcon.getImage();
        Image newRefreshImg = refreshImg.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon newRefreshIcon = new ImageIcon(newRefreshImg);

        setBounds(0, 0, 927, 589);

        btnCheckIn = new JButton("");
        btnCheckIn.setIcon(new ImageIcon(CheckInAndCheckOut.class.getResource("/checkIn.png")));
        btnCheckIn.setFont(new Font("Candara", Font.BOLD, 14));
        btnCheckIn.setBounds(105, 103, 239, 173);  // Điều chỉnh kích thước tại đây
        getContentPane().add(btnCheckIn);

        btnCheckOut = new JButton("");
        btnCheckOut.setIcon(new ImageIcon(CheckInAndCheckOut.class.getResource("/checkOut.png")));
        btnCheckOut.setBounds(98, 295, 246, 176);  // Điều chỉnh kích thước tại đây
        getContentPane().add(btnCheckOut);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CheckInAndCheckOut().setVisible(true);
        });
    }
}
