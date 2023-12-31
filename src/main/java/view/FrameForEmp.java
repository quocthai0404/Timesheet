package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
	private Attendence Attendence;
//	private JPanel panelView_Attendence_History;
	private Attendance_History panelAttendanceHistory;
//	private JPanel panelLeaveRequest;
	private Work_Schedule panelWorkSchedule;
	private Request_Leave panelRequestLeave;
	

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
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		btnAttendence = new JButton("Attendence");
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
		categoryPanel.add(btnAttendence);

		btnWork_Schedule.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnWork_Schedule);
		btnView_Attendance_History = new JButton("View Attendance History");
		btnView_Attendance_History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnView_Attendance_History.setMinimumSize(new Dimension(10000, 70));
		btnView_Attendance_History.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnView_Attendance_History);
		
		btnLeaveRequest = new JButton("<html>Leave Request</html>");
		btnLeaveRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});

		btnLeaveRequest.setMaximumSize(new Dimension(10000, 70));

		btnLeaveRequest.setMinimumSize(new Dimension(10000, 70));
		categoryPanel.add(btnLeaveRequest);
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		// right
		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);
		panelContainer.setBorder(new LineBorder(new Color(0, 0, 0)));

		contentPane.add(categoryPanel, BorderLayout.WEST);

		
		contentPane.add(panelContainer, BorderLayout.CENTER);

		
		

		

		Attendence = new Attendence();
		panelContainer.add(Attendence, "panelAttendence");
		

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
