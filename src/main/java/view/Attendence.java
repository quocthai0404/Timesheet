package view;

import javax.swing.JPanel;

import entity.W_scheduleJoinWShift;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Attendence extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCheckIn;
	private JButton btnCheckOut;
	private JLabel lblToday;
	private W_scheduleJoinWShift wsDao = new W_scheduleJoinWShift();
	private ArrayList<W_scheduleJoinWShift> list = new ArrayList<>();
	public Attendence() {
		
		btnCheckIn = new JButton("CheckIn");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckInActionPerformed(e);
			}
		});
		
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
	protected void btnCheckInActionPerformed(ActionEvent e) {
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		
		list=wsDao.listJoin(date);
		for (W_scheduleJoinWShift i : list) {
			System.out.println(i);
		}
		
	}
}
