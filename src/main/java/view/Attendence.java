package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Attendence extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCheckIn;
	private JButton btnCheckOut;
	private JLabel lblToday;

	public Attendence() {
		
		btnCheckIn = new JButton("CheckIn");
		
		btnCheckOut = new JButton("Check Out");
		
		lblToday = new JLabel("Today");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(233)
					.addComponent(btnCheckIn)
					.addGap(161)
					.addComponent(btnCheckOut)
					.addContainerGap(344, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(338, Short.MAX_VALUE)
					.addComponent(lblToday, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addGap(312))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(134)
					.addComponent(lblToday)
					.addGap(115)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCheckOut)
						.addComponent(btnCheckIn))
					.addContainerGap(281, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
