/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.healthmarketscience.jackcess.impl.query.QueryImpl.Row;

import DAO.Work_scheduleDAO;
import entity.EmployeeAfterLogin;
import entity.RowClicked;
import entity.wSche_join_wShift;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckInAndCheckOut extends javax.swing.JInternalFrame {

    private JPanel panel;
    private JLabel lblLogo;
    private JLabel lblNewLabel_1;
    private JButton jButtonFind;
    private JButton btnRefresh;
    private JButton btnCheckIn;
    private JButton btnCheckOut;
    private JScrollPane scrollPane;
    private JTable table;
    private JLabel lblNewLabel;
    private Map<Integer, String> mapIn;
    private Map<Integer, String> mapOut;
    public CheckInAndCheckOut() {
        getContentPane().setBackground(new Color(128, 255, 255));
        initComponents();
        setTitle("Employee");
        loadData();
        mapIn = new HashMap<>();
        mapOut = new HashMap<>();
        mapIn.put(1, "08:00:00");
        mapIn.put(2, "13:00:00");
        mapIn.put(3, "18:00:00");
        mapIn.put(4, "22:00:00");
        mapOut.put(1, "12:00:00");
        mapOut.put(2, "17:00:00");
        mapOut.put(3, "22:00:00");
        mapOut.put(4, "06:00:00");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setMaximumSize(new Dimension(990, 550));
        setMinimumSize(new Dimension(990, 550));
        setPreferredSize(new Dimension(990, 550));
        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 974, 76);
        getContentPane().add(panel);

        lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon(CheckInAndCheckOut.class.getResource("/aptech_logo.png")));
        lblLogo.setBounds(10, 0, 154, 76);
        panel.add(lblLogo);

        lblNewLabel_1 = new JLabel("CheckIn And CheckOut");
        lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 48));
        lblNewLabel_1.setBounds(271, 22, 648, 54);
        panel.add(lblNewLabel_1);

       

        setBounds(0, 0, 927, 589);

        btnCheckIn = new JButton("");
        btnCheckIn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnCheckInActionPerformed(e);
        	}
        });
        btnCheckIn.setBounds(106, 369, 200, 132);  // Adjust width and height accordingly
        getContentPane().add(btnCheckIn);

        btnCheckOut = new JButton("");
        btnCheckOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnCheckOutActionPerformed(e);
        	}
        });
        btnCheckOut.setBounds(670, 369, 200, 132); // Adjust width and height accordingly
        getContentPane().add(btnCheckOut);

        // Set images for buttons with adjusted sizes
        ImageIcon checkInIcon = new ImageIcon(CheckInAndCheckOut.class.getResource("/checkIn.png"));
        Image checkInImg = checkInIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        btnCheckIn.setIcon(new ImageIcon(checkInImg));

        ImageIcon checkOutIcon = new ImageIcon(CheckInAndCheckOut.class.getResource("/checkOut.png"));
        Image checkOutImg = checkOutIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        btnCheckOut.setIcon(new ImageIcon(checkOutImg));
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(106, 150, 764, 209);
        getContentPane().add(scrollPane);
        
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		tableMouseClicked(e);
        	}
        });
        table.setRowHeight(30);
        scrollPane.setViewportView(table);
        
        lblNewLabel = new JLabel("YOUR WORK SCHEDULE TODAY: ");
        lblNewLabel.setFont(new Font("Candara", Font.BOLD, 30));
        lblNewLabel.setBounds(106, 86, 705, 54);
        getContentPane().add(lblNewLabel);
    }
    public void loadData() {
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	Date currentDate = new Date();
    	Work_scheduleDAO dao = new Work_scheduleDAO();
    	List<wSche_join_wShift> list = new ArrayList<>();
    	list= dao.getListSchedule(currentDate);
    	if(list.size()==0) {
    		JOptionPane.showMessageDialog(null, "You don't have work scheduled today");
    		return;
    	}else {
    		JOptionPane.showMessageDialog(null, "You have "+list.size()+" work schedule today");
    	}
    	
    	DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Work_sche_id");
		model.addColumn("Date");
		model.addColumn("WorkShift");
		model.addColumn("Time");
		model.addColumn("Work Type");
		list.forEach(item -> {
			String date = formatter.format(item.getWork_date());
			model.addRow(new Object[] { item.getWork_schedule_id(), date, item.getWork_shift_id(),
					item.getDescription(), item.getWork_type()});
			System.out.println(item);
		});
		table.setModel(model);
		
    	
    	
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CheckInAndCheckOut().setVisible(true);
        });
    }
	protected void tableMouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			int row = table.getSelectedRow();
			RowClicked.work_schedule_id=Integer.parseInt(table.getValueAt(row, 0).toString());

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				RowClicked.work_date = df.parse(table.getValueAt(row, 1).toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			RowClicked.work_shift_id= Integer.parseInt(table.getValueAt(row, 2).toString());
			RowClicked.description = table.getValueAt(row, 3).toString();
			RowClicked.work_type = table.getValueAt(row, 4).toString();
			SimpleDateFormat newdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(RowClicked.work_shift_id==4) {
				String work_date = df.format(RowClicked.work_date);
				String sMustIn = work_date + " " + mapIn.get(4);
				Date nextDate = new java.util.Date(RowClicked.work_date.getTime() + 86400000);
				String work_date_out = df.format(nextDate);
				String sMustOut = work_date_out+ " "+ mapOut.get(4);
				
				try {
					RowClicked.dateWorkIn = newdf.parse(sMustIn);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					RowClicked.dateWorkOut = newdf.parse(sMustOut);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				RowClicked.dateCanCheckIn = new java.util.Date(RowClicked.dateWorkIn.getTime() - 3600000);
				RowClicked.dateMaxOut = new java.util.Date(RowClicked.dateWorkOut.getTime() + 3600000);
				System.out.println("gio vao ca: "+ newdf.format(RowClicked.dateWorkIn));
				System.out.println("gio ra ca: "+ newdf.format(RowClicked.dateWorkOut));
				System.out.println("gio duoc check in : "+ newdf.format(RowClicked.dateCanCheckIn));
				System.out.println("gio duoc check out : "+ newdf.format(RowClicked.dateMaxOut));
			}else {
				String work_date = df.format(RowClicked.work_date);
				String sMustIn = work_date + " " + mapIn.get(RowClicked.work_shift_id);
				String sMustOut = work_date + " " + mapOut.get(RowClicked.work_shift_id);
				try {
					RowClicked.dateWorkIn = newdf.parse(sMustIn);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				try {
					RowClicked.dateWorkOut = newdf.parse(sMustOut);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				RowClicked.dateCanCheckIn = new java.util.Date(RowClicked.dateWorkIn.getTime() - 3600000);
				RowClicked.dateMaxOut = new java.util.Date(RowClicked.dateWorkOut.getTime() + 3600000);
				System.out.println("gio vao ca: "+ newdf.format(RowClicked.dateWorkIn));
				System.out.println("gio ra ca: "+ newdf.format(RowClicked.dateWorkOut));
				System.out.println("gio duoc check in : "+ newdf.format(RowClicked.dateCanCheckIn));
				System.out.println("gio duoc check out : "+ newdf.format(RowClicked.dateMaxOut));
			}
		}
	}
	protected void btnCheckInActionPerformed(ActionEvent e) {
		Work_scheduleDAO dao = new Work_scheduleDAO();
		if(dao.checkExistsAttendance(RowClicked.work_schedule_id)) {
			System.out.println(RowClicked.work_shift_id);
			long now = System.currentTimeMillis();
			if(now<RowClicked.dateWorkIn.getTime() && now >RowClicked.dateCanCheckIn.getTime()) {
//				System.out.println("check in chuan gio");
				dao.checkIn();
			
			}else if(now< RowClicked.dateCanCheckIn.getTime()){
				System.out.println("check in som hon gio quy dinh");
				JOptionPane.showMessageDialog(null, "You can't check in before work in time");
			}else {
//				System.out.println("di tre");
				dao.lateForWork();
				dao.checkIn();
				
				
			}
		}else {
			JOptionPane.showMessageDialog(null, "You Can't Check In!");
		}
		
	}
	protected void btnCheckOutActionPerformed(ActionEvent e) {
		Work_scheduleDAO dao = new Work_scheduleDAO();
		long now = System.currentTimeMillis();
		if(dao.checkExistsAttendance(RowClicked.work_schedule_id)) {
			JOptionPane.showMessageDialog(null, "You Can't Check Out!");
		}else {
			if(now<RowClicked.dateWorkOut.getTime()) {
				JOptionPane.showMessageDialog(null, "You check out before the work out time");
				dao.checkOutBefore();
				dao.setIsHide();
				loadData();
			}else if(now<RowClicked.dateMaxOut.getTime()&& now > RowClicked.dateWorkOut.getTime()) {
				//JOptionPane.showMessageDialog(null, "Check out dung gio");
				dao.checkOutRightTime();
				dao.setIsHide();
				loadData();
			}else {
				JOptionPane.showMessageDialog(null, "Check Out Wrong Time ");
				dao.checkOutWrongTime();
				dao.addUnpaidLeave();
				dao.setIsHide();
				loadData();
			}
		}
	}
}
