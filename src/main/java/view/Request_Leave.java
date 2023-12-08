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
import java.time.Month;

import DAO.AccountDAO;
import DAO.EmployeeDAO;
import DAO.LeaveDao;
import database.JdbcUlti;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String username = getName();

        // Kiểm tra xem nhân viên đã tồn tại trong map hay chưa
        if (!accountInfoMap.containsKey(username)) {
            accountInfoMap.put(username, new AccountInfo());
        }

        AccountInfo accountInfo = accountInfoMap.get(username);

        // Kiểm tra xem tháng hiện tại có phải là tháng mới hay không
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();

        if (!currentMonth.equals(accountInfo.getLastSentMonth())) {
            accountInfo.setNumberOfRequests(0);
            accountInfo.setLastSentMonth(currentMonth);
        }

        // Kiểm tra số lần được gửi, nếu đã đạt tới giới hạn là 3, hiển thị thông báo và không thực hiện gửi yêu cầu
        if (accountInfo.getNumberOfRequests() >= 3) {
            JOptionPane.showMessageDialog(this, "Bạn đã đạt tới số lần gửi tối đa trong tháng.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int employeeId = getEmployeeId(username);

        // Kiểm tra số lần yêu cầu đã gửi trong tháng của nhân viên từ cơ sở dữ liệu
        if (countLeaveRequestsForMonth(employeeId, currentMonth) >= 3) {
            JOptionPane.showMessageDialog(this, "Bạn đã gửi đủ 3 yêu cầu trong tháng này.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Thực hiện gửi yêu cầu nghỉ phép
        LeaveDao leaveDao = new LeaveDao();
        leaveDao.addLeaveRequest(dateLeave.getDate(), txtNod.getText(), textAreaReason.getText());

        // Increment the count in the database
        incrementRequestCount(employeeId);


        // Thực hiện gửi yêu cầu nghỉ phép
        leaveDao.addLeaveRequest(dateLeave.getDate(), txtNod.getText(), textAreaReason.getText());

        // Tăng số lần được gửi của nhân viên
        accountInfo.setNumberOfRequests(accountInfo.getNumberOfRequests() + 1);

        JOptionPane.showMessageDialog(this, "Leave request sent successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        dateLeave.setDate(null);
        txtNod.setText("");
        textAreaReason.setText("");

        loadData();
    }

    // ... (các phương thức khác)

    // Lớp để lưu trữ thông tin về số lần yêu cầu và tháng cuối cùng gửi của mỗi nhân viên
    class AccountInfo {
        private int numberOfRequests;
        private Month lastSentMonth;

        public AccountInfo() {
            this.numberOfRequests = 0;
            this.lastSentMonth = null;
        }

        public int getNumberOfRequests() {
            return numberOfRequests;
        }

        public void setNumberOfRequests(int numberOfRequests) {
            this.numberOfRequests = numberOfRequests;
        }

        public Month getLastSentMonth() {
            return lastSentMonth;
        }

        public void setLastSentMonth(Month lastSentMonth) {
            this.lastSentMonth = lastSentMonth;
        }
    }
    public int countLeaveRequestsForMonth(int employeeId, Month month) {
        int count = 0;

        String sql = "SELECT COUNT(*) FROM leave WHERE employee_id = ? AND MONTH(startdate) = ?";

        try (Connection connection = JdbcUlti.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameters for the SQL query
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setInt(2, month.getValue());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException as needed
        }

        return count;
    }

    public int getEmployeeId(String username) {
        int employeeId = -1;  // Default value if employee ID is not found

        String sql = "SELECT employee_id FROM account WHERE username = ?";

        try (Connection connection = JdbcUlti.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the username parameter in the SQL query
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Check if the result set has a row
                if (resultSet.next()) {
                    // Retrieve the employee ID from the result set
                    employeeId = resultSet.getInt("employee_id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the SQLException as needed
        }

        return employeeId;
    }
    private void incrementRequestCount(int employeeId) {
        String sql = "UPDATE employee SET request_count = request_count + 1 WHERE employee_id = ?";

        try (Connection connection = JdbcUlti.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the parameter for the SQL query
            preparedStatement.setInt(1, employeeId);

            // Execute the update
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle the SQLException as needed
        }
    }
}
