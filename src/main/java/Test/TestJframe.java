package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TestJframe extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestJframe frame = new TestJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Tạo thanh category bên trái
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));

		JButton button = new JButton("Quản Lý Giảng Viên");
		button.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(button);
		JButton button_1 = new JButton("Trang Chủ");
		button_1.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(button_1);
		JButton button_2 = new JButton("Quản Lý Sinh Viên");
		button_2.setMinimumSize(new Dimension(10000, 70));
		button_2.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(button_2);
		JButton button_3 = new JButton("Thống Kê Giảng Dạy");
		button_3.setMaximumSize(new Dimension(10000, 70));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_button_3_actionPerformed(e);
			}
		});
		button_3.setMinimumSize(new Dimension(10000, 70));
		categoryPanel.add(button_3);
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		// Tạo nội dung bên phải
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setLayout(new BorderLayout());
		// Thêm nội dung vào contentPanel tại đây

		// Thêm categoryPanel và contentPanel vào contentPane
		contentPane.add(categoryPanel, BorderLayout.WEST);
		contentPane.add(contentPanel, BorderLayout.CENTER);
	}

	protected void do_button_3_actionPerformed(ActionEvent e) {
	}
}