package Test;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Testcombobox extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testcombobox frame = new Testcombobox();
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
	public Testcombobox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		String city[] = { "Ha Noi", "Vinh Phuc", "Da Nang", 
                "TP. Ho Chi Minh", "Nha Trang" };
		comboBox = new JComboBox(city);
		
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		
		
		

        // Tạo một JComboBox
        
        
        
        
        
        
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(183)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btnNewButton)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		System.out.println(comboBox.getSelectedIndex()+1);
	}
}
