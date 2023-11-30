package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel panelContainer;
	private JPanel categoryPanel;
	private JButton btnEmployee_management;
	private JButton btnCreate_employee_account;
	private JButton btnEmp_work_schedule;
	private JButton btnReview_leave_reqs;
	private JButton btnTimekeeping_info;
	private JPanel panel_employee_management;
	private JPanel panel_create_emp_acc;
	private JPanel panel_emp_work_schedule;
	private JPanel panel_review_leave_reqs;
	private JPanel panel_timekeeping_info;
	
	
	public MainJFrame() {
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
		
		btnEmployee_management = new JButton("Employee Management");
		btnEmployee_management.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
			
		});
		
		btnEmployee_management.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(btnEmployee_management);
		btnCreate_employee_account = new JButton("<html>Create Employee<br>&nbsp &nbsp &nbsp Account</html>");
		btnCreate_employee_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});
		btnCreate_employee_account.setHorizontalTextPosition(SwingConstants.CENTER);
		
		btnCreate_employee_account.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnCreate_employee_account);
		btnEmp_work_schedule = new JButton("<html>Manage Employee <br>&nbsp Work Schedule</html>");
		btnEmp_work_schedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});
		
		btnEmp_work_schedule.setMinimumSize(new Dimension(10000, 70));
		btnEmp_work_schedule.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnEmp_work_schedule);
		btnReview_leave_reqs = new JButton("<html>Review Leave Requests </html>");
		btnReview_leave_reqs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});
		
		btnReview_leave_reqs.setMaximumSize(new Dimension(10000, 70));
		
		btnReview_leave_reqs.setMinimumSize(new Dimension(10000, 70));
		categoryPanel.add(btnReview_leave_reqs);
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		//right
		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);
		panelContainer.setBorder(new LineBorder(new Color(0, 0, 0)));
	

		
		contentPane.add(categoryPanel, BorderLayout.WEST);
		
		btnTimekeeping_info = new JButton("Timekeeping information");
		btnTimekeeping_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClickSwitchPanel(e);
			}
		});
		btnTimekeeping_info.setMinimumSize(new Dimension(10000, 70));
		btnTimekeeping_info.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(btnTimekeeping_info);
		contentPane.add(panelContainer, BorderLayout.CENTER);
		
		
		
		panel_employee_management = new JPanel();
		panelContainer.add(panel_employee_management, "panel_employee_management");
		
		panel_create_emp_acc = new JPanel();
		panelContainer.add(panel_create_emp_acc, "panel_create_emp_acc");
		
		panel_emp_work_schedule = new JPanel();
		panelContainer.add(panel_emp_work_schedule, "panel_emp_work_schedule");
		
		panel_review_leave_reqs = new JPanel();
		panelContainer.add(panel_review_leave_reqs, "panel_review_leave_reqs");
		
		panel_timekeeping_info = new JPanel();
		panelContainer.add(panel_timekeeping_info, "panel_timekeeping_info");
		
		
		
		setPreferredSize(new Dimension(1250, 800));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void btnClickSwitchPanel(ActionEvent e) {
		Object src = e.getSource();
		if(src.equals(btnEmployee_management)) {
			cardLayout.show(panelContainer, "panel_employee_management");
		}else if(src.equals(btnCreate_employee_account)) {
			cardLayout.show(panelContainer, "panel_create_emp_acc");
		}else if(src.equals(btnEmp_work_schedule)) {
			cardLayout.show(panelContainer, "panel_emp_work_schedule");
		}else if(src.equals(btnReview_leave_reqs)) {
			cardLayout.show(panelContainer, "panel_review_leave_reqs");
		}else {
			cardLayout.show(panelContainer, "panel_timekeeping_info");
		}
		
	}
	
}
