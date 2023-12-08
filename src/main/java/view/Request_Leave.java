package view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;

import DAO.AccountDAO;
import DAO.EmployeeDAO;
import DAO.LeaveDao;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class Request_Leave extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbAddNV5;
	private JPanel panel;
	private JLabel lblStartDate;
	private JDateChooser dateLeave;
	private JLabel lblNumsOfDate;
	private JTextField txtNod;
	private JLabel lblReason;
	private JButton btnSend;
	private JTable tableRequest;
	private JTextArea textAreaReason;
	private int numberOfRequests = 0;
	private LocalDate lastSentDate = LocalDate.now();
	private Map<String, AccountInfo> accountInfoMap = new HashMap<>();
	
	public Request_Leave() {
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		
		lblStartDate = new JLabel("Leave Start");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		dateLeave = new JDateChooser();
		dateLeave.setMinimumSize(new Dimension(10, 10));
		dateLeave.setMaximumSize(new Dimension(2047483634, 2047483634));
		
		lblNumsOfDate = new JLabel("Nums of Date");
		lblNumsOfDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		txtNod = new JTextField();
		txtNod.setFont(new Font("Segoe UI", Font.BOLD, 11));
		txtNod.setColumns(10);
		
		lblReason = new JLabel("Reason");
		lblReason.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSendActionPerformed(e);
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textAreaReason = new JTextArea();
		textAreaReason.setFont(new Font("Segoe UI", Font.BOLD, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(132)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textAreaReason, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblReason, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNumsOfDate, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblStartDate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtNod)
									.addComponent(dateLeave, GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))))
					.addContainerGap(147, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dateLeave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNumsOfDate, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNod, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblReason, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAreaReason, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
		);
		
		lbAddNV5 = new JLabel();
		lbAddNV5.setText("Request For Leave");
		lbAddNV5.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddNV5.setForeground(new Color(255, 255, 255));
		lbAddNV5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbAddNV5.setBackground(Color.BLACK);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbAddNV5, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lbAddNV5, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		loadData();

	}
	
	public void loadData() {
		DefaultTableModel model = new DefaultTableModel();
	    model.addColumn("Start Date");
	    model.addColumn("Number of Days");
	    model.addColumn("Reason");
	    EmployeeDAO dao = new EmployeeDAO();

	    LeaveDao dao1 = new LeaveDao();

	    dao1.selectLeave().forEach(leave -> {
	        model.addRow(new Object[]{leave.getStartdate(), leave.getNumber_of_days(), leave.getReason()});
	    });

	    model.getDataVector().forEach(System.out::println);
	}
	
	 protected void btnSendActionPerformed(ActionEvent e) {
	        String username = getName(); // Thay thế bằng cách lấy tên đăng nhập từ đối tượng tương ứng

	        // Kiểm tra xem tài khoản đã tồn tại trong map hay chưa
	        if (!accountInfoMap.containsKey(username)) {
	            accountInfoMap.put(username, new AccountInfo());
	        }

	        AccountInfo accountInfo = accountInfoMap.get(username);

	        // Kiểm tra xem ngày hiện tại có phải là ngày mới hay không
	        LocalDate currentDate = LocalDate.now();
	        if (!currentDate.isEqual(accountInfo.getLastSentDate())) {
	            // Nếu là ngày mới, reset số lần và cập nhật ngày cuối cùng gửi
	            accountInfo.setNumberOfRequests(0);
	            accountInfo.setLastSentDate(currentDate);
	        }

	        // Kiểm tra số lần được gửi, nếu đã đạt tới giới hạn là 3, hiển thị thông báo và không thực hiện gửi yêu cầu
	        if (accountInfo.getNumberOfRequests() >= 3) {
	            JOptionPane.showMessageDialog(this, "Bạn đã đạt tới số lần gửi tối đa trong tuần.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        // Thực hiện gửi yêu cầu nghỉ phép
	        LeaveDao leaveDao = new LeaveDao();
	        leaveDao.addLeaveRequest(dateLeave.getDate(), txtNod.getText(), textAreaReason.getText());

	        // Tăng số lần được gửi của tài khoản
	        accountInfo.setNumberOfRequests(accountInfo.getNumberOfRequests() + 1);

	        JOptionPane.showMessageDialog(this, "Leave request sent successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

	        dateLeave.setDate(null);
	        txtNod.setText("");
	        textAreaReason.setText("");

	        loadData();
	    }

	    // Định nghĩa class để lưu trữ thông tin về số lần yêu cầu và ngày cuối cùng gửi của mỗi tài khoản
	    private static class AccountInfo {
	        private int numberOfRequests = 0;
	        private LocalDate lastSentDate = LocalDate.now();

	        public int getNumberOfRequests() {
	            return numberOfRequests;
	        }

	        public void setNumberOfRequests(int numberOfRequests) {
	            this.numberOfRequests = numberOfRequests;
	        }

	        public LocalDate getLastSentDate() {
	            return lastSentDate;
	        }

	        public void setLastSentDate(LocalDate lastSentDate) {
	            this.lastSentDate = lastSentDate;
	        }
	    }
}
