package com.customer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;

import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuItem;
import javax.swing.JList;
import java.awt.Choice;

public class CustomerDetails {

	private JFrame frame;
	private Choice choice;
	private List<Customer> list;
	private JScrollPane scrollPane;
	private JTable table;
	private JTable table_1;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CustomerDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		frame.setSize(1366, 719);
		frame.setMaximizedBounds(new Rectangle(0, 0, 500, 500));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("                                 Customer Details");
		lblNewLabel.setBounds(-93, 23, 1350, 56);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 57));
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(190, 100, 89, 23);
		btnNewButton.addActionListener(new previous_action(frame));
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Add Customer");
		btnNewButton_1.addActionListener(new AddCustomer(frame));
		btnNewButton_1.setBounds(65, 100, 111, 23);
		frame.getContentPane().add(btnNewButton_1);

		String[] columnNames = { "Name", "Address", "Phone", "Booking Date", "Delivery Date", "Type", "Height", "Chest",
				"Stomach", "Seat", "Bicep", "Front Chest", "Front Stomach", "Front Seat", "Kata Height", "Waist",
				"Mandi", "Stand Collar", "Other" };
		list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tailer", "root", "Alase8888@me");

			String query = " Select * from  Customer";

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
					list.get(i).getBicep(), list.get(i).getFrontChest(), list.get(i).getFrontStomach(),
					list.get(i).getFrontSeat(), list.get(i).getKataHeight(), list.get(i).getWaist(),
					list.get(i).getMandi(), list.get(i).getStandCollar(), list.get(i).getOther() };
		}
		table = new JTable(data1, columnNames);
		table.setRowHeight(25);
		table.setEnabled(false);
		scrollPane = new JScrollPane(table);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setLocation(10, 134);
		scrollPane.setSize(1340, 462);
		frame.getContentPane().add(scrollPane);

		choice = new Choice();
		choice.setBounds(411, 99, 247, 24);
		frame.getContentPane().add(choice);
		choice.add("----Select----");
		choice.add("Shirt");
		choice.add("Pant");
		choice.add("Kurta");
		choice.add("Salwar");
		choice.add("Blazer");
		choice.add("Jodhapuri");
		choice.add("Sherwani");
		choice.add("V-Jacket");
		choice.add("Modi-Jacket");
		choice.addItemListener(new listListner());

		JLabel lblNewLabel_1 = new JLabel("Type:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(313, 104, 66, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		table_1 = new JTable();
		table_1.setBounds(193, 566, 319, -100);
		frame.getContentPane().add(table_1);

	}

	public class listListner implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if(choice.getSelectedItem().equals("Shirt")) {
				ShirtDetails s= new ShirtDetails();
				s.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Pant")) {
				PantDetails p = new PantDetails();
				p.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Kurta")) {
				KurtaDetails k = new KurtaDetails();
				k.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Salwar")) {
				SalwarDetails s = new SalwarDetails();
				s.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Suit") || choice.getSelectedItem().equals("Blazer")) {
				SuitBlazerDetails s = new SuitBlazerDetails();
				s.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Jodhapuri")) {
				JodhapuriDetails j = new JodhapuriDetails();
				j.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Sherwani")) {
				SherwaniDetails s = new SherwaniDetails();
				s.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("V-Jacket")) {
				VJacketDetails v = new VJacketDetails();
				v.getFrame().setVisible(true);
			}
			else if(choice.getSelectedItem().equals("Modi-Jacket")) {
				ModiJacket m = new ModiJacket();
				m.getFrame().setVisible(true);
			}
		
			
		}
	}

	public class previous_action implements ActionListener {
		private JFrame frame;

		public previous_action(JFrame frame) {
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent t) {
			this.frame.setVisible(false);
		}
	}

	public class AddCustomer implements ActionListener {
		private JFrame frame;

		public AddCustomer(JFrame frame) {
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent t) {
			this.frame.setVisible(false);
			InputDetailsForm input = new InputDetailsForm();
			input.getFrame().setVisible(true);
		}
	}
}
