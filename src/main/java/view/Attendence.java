package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class Attendence extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCheckIn;
	private JButton btnCheckOut;

	public Attendence() {
		
		btnCheckIn = new JButton("CheckIn");
		
		btnCheckOut = new JButton("Check Out");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(233)
					.addComponent(btnCheckIn)
					.addGap(161)
					.addComponent(btnCheckOut)
					.addContainerGap(273, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(263)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCheckOut)
						.addComponent(btnCheckIn))
					.addContainerGap(281, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
