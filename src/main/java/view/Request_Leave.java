package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.Month;

import DAO.AccountDAO;
import DAO.EmployeeDAO;
import DAO.LeaveDao;
import database.JdbcUlti;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class Request_Leave extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblStartDate;
	private JDateChooser dateLeave;
	private JLabel lblNumsOfDate;
	private JTextField txtNod;
	private JLabel lblReason;
	private JButton btnSend;
	private JTextArea textAreaReason;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel lbAddNV5;
	
	public Request_Leave() {
		setBackground(new Color(0, 255, 255));
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendActionPerformed(e);
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 128));
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		lbAddNV5 = new JLabel();
		lbAddNV5.setText("Request For Leave");
		lbAddNV5.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddNV5.setForeground(Color.WHITE);
		lbAddNV5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbAddNV5.setBackground(Color.BLACK);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 509, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbAddNV5, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 65, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE))
					.addGap(357))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(69))
		);
		
		lblStartDate = new JLabel("Leave Start");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		dateLeave = new JDateChooser();
		dateLeave.setMinimumSize(new Dimension(10, 10));
		dateLeave.setMaximumSize(new Dimension(2047483634, 2047483634));
		
		lblNumsOfDate = new JLabel("Nums of Date");
		lblNumsOfDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtNod = new JTextField();
		txtNod.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtNod.setColumns(10);
		
		lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		textAreaReason = new JTextArea();
		textAreaReason.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblStartDate)
									.addGap(37)
									.addComponent(dateLeave, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNumsOfDate, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNod)))
							.addContainerGap(19, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblReason, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(332, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(textAreaReason, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStartDate)
						.addComponent(dateLeave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumsOfDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblReason, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textAreaReason, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);


	}
	
	
	
   
    protected void btnSendActionPerformed(ActionEvent e) {
    	
        LeaveDao leaveDao = new LeaveDao();
        int nod = Integer.parseInt(txtNod.getText());
        if(leaveDao.getDayOff(dateLeave.getDate(), nod)) {
        	leaveDao.addLeaveRequest(dateLeave.getDate(), txtNod.getText(), textAreaReason.getText());
        }
//        else {
//        	JOptionPane.showMessageDialog(null, "You have asked for leave more than 3 days/month or 12 days/year");
//        }
        
        dateLeave.setDate(null);
        txtNod.setText("");
        textAreaReason.setText("");

        
    }


    
    
}
