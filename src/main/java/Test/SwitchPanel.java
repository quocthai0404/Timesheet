package Test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SwitchPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton btnSwitchToPanel2;
	private CardLayout cardLayout;
	private JPanel panelContainer;
	private JButton btnSwitchToPanel1;
	private JButton btnSwitchToPanel3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwitchPanel frame = new SwitchPanel();
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
	public SwitchPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		cardLayout = new CardLayout();
		panelContainer = new JPanel();
		panelContainer.setLayout(cardLayout);

		setContentPane(contentPane);
		contentPane.add(panelContainer);

		panel1 = new JPanel();
		panel1.setBackground(Color.CYAN);

		btnSwitchToPanel2 = new JButton("Switch To Panel 2");
		btnSwitchToPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});

		btnSwitchToPanel3 = new JButton("Switch To Panel 3");
		btnSwitchToPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSwitchToPanel3ActionPerformed(e);
			}
		});
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1
						.createSequentialGroup().addGap(147).addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSwitchToPanel3).addComponent(btnSwitchToPanel2))
						.addContainerGap(177, Short.MAX_VALUE)));
		gl_panel1.setVerticalGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup().addGap(90).addComponent(btnSwitchToPanel2).addGap(34)
						.addComponent(btnSwitchToPanel3).addContainerGap(81, Short.MAX_VALUE)));
		panel1.setLayout(gl_panel1);

		panel2 = new JPanel();
		panel2.setBackground(Color.RED);
		panelContainer.add(panel1, "Panel1");
		panelContainer.add(panel2, "Panel2");

		btnSwitchToPanel1 = new JButton("Switch To Panel 1");
		btnSwitchToPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSwitchToPanel1ActionPerformed(e);
			}
		});
		panel2.add(btnSwitchToPanel1);

		panel3 = new JPanel();
		panel3.setBackground(Color.GREEN);
		panelContainer.add(panel3, "Panel3");

	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		cardLayout.show(panelContainer, "Panel2");

	}

	protected void btnSwitchToPanel1ActionPerformed(ActionEvent e) {
		cardLayout.show(panelContainer, "Panel1");
	}

	protected void btnSwitchToPanel3ActionPerformed(ActionEvent e) {
		cardLayout.show(panelContainer, "Panel3");
	}
}
