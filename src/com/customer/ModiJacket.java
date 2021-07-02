package com.customer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class ModiJacket {

	private JFrame frame;
	private List<Customer> list;
	private JTable table;
	

	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public List<Customer> getList() {
		return list;
	}

	public void setList(List<Customer> list) {
		this.list = list;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ModiJacket() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		frame.setSize(1366, 719);
		frame.setMaximizedBounds(new Rectangle(0, 0, 500, 500));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Modi-Jacket Category");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 56));
		lblNewLabel.setBounds(425, 11, 566, 61);
		frame.getContentPane().add(lblNewLabel);

		String[] columnNames = { "Name", "Address", "Phone", "Booking Date", "Delivery Date", "Type", "Height", "Chest",
				"Stomach", "Seat", "Sholder","Collar"};
		list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tailer", "root", "Alase8888@me");

			String query = " Select * from  Customer where type='Modi-Jacket'";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			ResultSet rs = preparedStmt.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setName(rs.getString("name"));
				c.setAddress(rs.getString("address"));
				c.setPhoneNumber(rs.getString("phone"));
				c.setBookingDate(rs.getDate("bookingdate"));
				c.setDeliveryDate(rs.getDate("deliverydate"));
				c.setType(rs.getString("type"));
				c.setChest(rs.getDouble("chest"));
				c.setHeight(rs.getDouble("height"));
				c.setStomach(rs.getDouble("stomach"));
				c.setSeat(rs.getDouble("seat"));
				c.setBicep(rs.getDouble("bicep"));
				c.setFrontChest(rs.getDouble("front_chest"));
				c.setFrontStomach(rs.getDouble("front_stomach"));
				c.setFrontSeat(rs.getDouble("front_seat"));
				c.setKataHeight(rs.getDouble("kata_height"));
				c.setWaist(rs.getDouble("waist"));
				c.setMandi(rs.getDouble("mandi"));
				c.setStandCollar(rs.getDouble("stand_collar"));
				c.setOther(rs.getDouble("other"));

				list.add(c);
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		Object[][] data1 = new Object[list.size()][];
		for (int i = 0; i < data1.length; i++) {
			System.out.println(list.get(i));
			data1[i] = new Object[] { list.get(i).getName(), list.get(i).getAddress(), list.get(i).getPhoneNumber(),
					list.get(i).getBookingDate(), list.get(i).getDeliveryDate(), list.get(i).getType(),
					list.get(i).getHeight(), list.get(i).getChest(), list.get(i).getStomach(), list.get(i).getSeat(),
					list.get(i).getSholder(),list.get(i).getCollar()};
		}
		table = new JTable(data1, columnNames);
		table.setRowHeight(25);
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 102, 1340, 462);
		frame.getContentPane().add(scrollPane);
	}


}
