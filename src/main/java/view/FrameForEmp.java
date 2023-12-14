package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class FrameForEmp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel categoryPanel;
	private JButton btnWork_Schedule;
	private JButton btnAttendence;
	private JButton btnView_Attendance_History;
	private JButton btnLeaveRequest;
	private JPanel panelContainer;
	private CardLayout cardLayout;
	
//	private JPanel panelAttendence;
	private Attendance Attendance;
//	private JPanel panelView_Attendence_History;
	private Attendance_History panelAttendanceHistory;
//	private JPanel panelLeaveRequest;
	private Work_Schedule panelWorkSchedule;
	private Request_Leave panelRequestLeave;
	private JPanel panel;
	private JLabel lblLogo;
	

	public FrameForEmp() {
		setTitle("Manager Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Tạo thanh category bên trái
		categoryPanel = new JPanel();
		categoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAttendence = new JButton("Attendance");
		btnAttendence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnWork_Schedule = new JButton("Work Schedule");
		btnWork_Schedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}

		});

		btnAttendence.setMaximumSize(new Dimension(10000, 70));

		btnWork_Schedule.setMaximumSize(new Dimension(1000000, 70));
		btnView_Attendance_History = new JButton("View Attendance History");
		btnView_Attendance_History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnView_Attendance_History.setMinimumSize(new Dimension(10000, 70));
		btnView_Attendance_History.setMaximumSize(new Dimension(1000000, 70));
		
		btnLeaveRequest = new JButton("<html>Leave Request</html>");
		btnLeaveRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnLeaveRequest.setMaximumSize(new Dimension(10000, 70));

		btnLeaveRequest.setMinimumSize(new Dimension(10000, 70));
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		// right
		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);
		panelContainer.setBorder(new LineBorder(new Color(0, 0, 0)));

		contentPane.add(categoryPanel, BorderLayout.WEST);
		
		panel = new JPanel();
		
		lblLogo = new JLabel("");
		ImageIcon logoIcon = new ImageIcon("C:\\Users\\Admin\\git\\Timesheet\\lib\\EMPLOYEE.png");

		// Resize the logo to your preferred dimensions (e.g., 128x128)
		Image img = logoIcon.getImage().getScaledInstance(128, 128, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(img);

		lblLogo.setIcon(logoIcon);
		lblLogo.setPreferredSize(new Dimension(128, 128));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 148, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 70, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		GroupLayout gl_categoryPanel = new GroupLayout(categoryPanel);
		gl_categoryPanel.setHorizontalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addGroup(gl_categoryPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLeaveRequest, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnView_Attendance_History, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnWork_Schedule, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAttendence, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_categoryPanel.setVerticalGroup(
			gl_categoryPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_categoryPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnAttendence, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnWork_Schedule, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnView_Attendance_History, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLeaveRequest, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(314))
		);
		categoryPanel.setLayout(gl_categoryPanel);

		
		contentPane.add(panelContainer, BorderLayout.CENTER);

		
		

		

		Attendance = new Attendance();
		panelContainer.add(Attendance, "panelAttendence");
		

		panelWorkSchedule = new Work_Schedule();
		panelContainer.add(panelWorkSchedule, "panelWorkSchedule");
		
		
		
		

		panelAttendanceHistory = new Attendance_History();
		panelContainer.add(panelAttendanceHistory, "panelAttendanceHistory");



		panelRequestLeave = new Request_Leave();
		panelContainer.add(panelRequestLeave, "panelLeaveRequest");
		


		setPreferredSize(new Dimension(1250, 800));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void btnClickSwitchPanel(ActionEvent e) {
		Object src = e.getSource();
		if (src.equals(btnWork_Schedule)) {
			cardLayout.show(panelContainer, "panelWorkSchedule");
		} else if (src.equals(btnAttendence)) {
			cardLayout.show(panelContainer, "panelAttendence");
		} else if (src.equals(btnView_Attendance_History)) {
			cardLayout.show(panelContainer, "panelAttendanceHistory");
		} else{
			cardLayout.show(panelContainer, "panelLeaveRequest");
		}
	}

}
