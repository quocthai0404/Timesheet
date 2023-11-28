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

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private CardLayout cardLayout;
	private JPanel panelContainer;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
//	private JButton btnLchLmNv;
//	private JButton btnThngTinChm;
//	private JButton btnQunLNhn;
	
	public MainJFrame() {
		setTitle("Manager Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout());
//		
//		panel_2 = new JPanel();
//		contentPane.add(panel_2, BorderLayout.CENTER);
//		
//		panel = new JPanel();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Tạo thanh category bên trái
		JPanel categoryPanel = new JPanel();
		categoryPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		categoryPanel.setLayout(new BoxLayout(categoryPanel, BoxLayout.Y_AXIS));
		
		JButton btnQunLNhn = new JButton("Quản Lý Nhân Viên");
		btnQunLNhn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnQunLNhnActionPerformed(e);
			}
		});
		btnQunLNhn.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(btnQunLNhn);
		JButton btnToTiKhon = new JButton("Tạo Tài Khoản NV");
		btnToTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnToTiKhonActionPerformed(e);
			}
		});
		btnToTiKhon.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnToTiKhon);
		JButton btnLchLmNv = new JButton("Lịch Làm NV");
		btnLchLmNv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLchLmNvActionPerformed(e);
			}
		});
		btnLchLmNv.setMinimumSize(new Dimension(10000, 70));
		btnLchLmNv.setMaximumSize(new Dimension(1000000, 70));
		categoryPanel.add(btnLchLmNv);
		JButton btnYuCuNgh = new JButton("Yêu Cầu Nghỉ Phép");
		btnYuCuNgh.setMaximumSize(new Dimension(10000, 70));
		
		btnYuCuNgh.setMinimumSize(new Dimension(10000, 70));
		categoryPanel.add(btnYuCuNgh);
		categoryPanel.setPreferredSize(new Dimension(150, 0)); // Đặt chiều rộng tùy chỉnh cho thanh category

		//right
		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);
		panelContainer.setBorder(new LineBorder(new Color(0, 0, 0)));
	

		
		contentPane.add(categoryPanel, BorderLayout.WEST);
		
		JButton btnThngTinChm = new JButton("Thông tin chấm công");
		btnThngTinChm.setMinimumSize(new Dimension(10000, 70));
		btnThngTinChm.setMaximumSize(new Dimension(10000, 70));
		categoryPanel.add(btnThngTinChm);
		contentPane.add(panelContainer, BorderLayout.CENTER);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panelContainer.add(panel_1, "panel_1");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panelContainer.add(panel_3, "panel_3");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.MAGENTA);
		panelContainer.add(panel_4, "panel_4");
		
		
		
		setPreferredSize(new Dimension(1250, 800));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	protected void btnQunLNhnActionPerformed(ActionEvent e) {
		cardLayout.show(panelContainer, "panel_4");
	}
	protected void btnToTiKhonActionPerformed(ActionEvent e) {
		cardLayout.show(panelContainer, "panel_1");
	}
	protected void btnLchLmNvActionPerformed(ActionEvent e) {
		cardLayout.show(panelContainer, "panel_3");
	}
}
