package com.customer;

import java.awt.Font;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.Choice;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;

import javax.swing.UIManager;

public class InputDetailsForm {

	private JFrame frame;
	private Customer c;
	private JTextField name;
	private JTextField address;
	private JTextField phone;
	private JFormattedTextField textField;
	private Choice choice;
	private JDateChooser dateChooser;
	private JTextField hight;
	private JTextField chest;
	private JTextField stomach;
	private JTextField seat;
	private JTextField sholder;
	private JTextField handLength;
	private JTextField caugh;
	private JTextField bicep;
	private JTextField frontChest;
	private JTextField frontStomach;
	private JTextField frontSeat;
	private JTextField kataHeight;
	private JTextField waist;
	private JTextField mandi;
	private JTextField elbow;
	private JTextField underline;
	private JTextField collar;
	private JTextField standCollar;
	private JTextField other;
	private JTextField bottom;
	private JTextField count;
	private JTextField price;
	private JTextField totalAmount;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	/**
	 * Create the application.
	 */
	public InputDetailsForm() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		frame.setSize(1366, 645);
		frame.setMaximizedBounds(new Rectangle(0, 0, 500, 500));
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Please fill the details:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(50, 45, 564, 57);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Customer Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 136, 150, 23);
		frame.getContentPane().add(lblNewLabel_1);

		name = new JTextField();
		name.setBounds(236, 139, 247, 20);
		frame.getContentPane().add(name);

		JLabel lblNewLabel_1_1 = new JLabel("Customer Address:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(50, 170, 163, 23);
		frame.getContentPane().add(lblNewLabel_1_1);

		address = new JTextField();
		address.setBounds(236, 170, 247, 20);
		frame.getContentPane().add(address);

		JLabel lblNewLabel_1_1_1 = new JLabel("Phone No.:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(50, 204, 163, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		phone = new JTextField();
		phone.setBounds(236, 201, 247, 20);
		frame.getContentPane().add(phone);

		JButton btnNewButton = new JButton("Submit!!");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(583, 557, 97, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new Submit(frame, name.getText(), address.getText(), phone.getText()));

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(UIManager.getColor("Button.darkShadow"));
		btnNewButton_1.setBounds(50, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Booking Date:");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(50, 238, 163, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");
		textField = new JFormattedTextField(dateFormat);
		textField.setBounds(236, 241, 247, 20);
		textField.setValue(new Date());
		textField.setEditable(false);
		frame.getContentPane().add(textField);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Delivery Date:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(50, 277, 163, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);

		choice = new Choice();
		choice.setBounds(236, 320, 247, 24);
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
		choice.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				
				// TODO Auto-generated method stub
				waist.setEditable(false);
				waist.setText("0.0");
				seat.setEditable(false);
				seat.setText("0.0");
				hight.setEditable(false);
				hight.setText("0.0");
				caugh.setEditable(false);
				caugh.setText("0.0");
				seat.setEditable(false);
				seat.setText("0.0");
				elbow.setEditable(false);
				elbow.setText("0.0");
				underline.setEditable(false);
				underline.setText("0.0");
				frontSeat.setEditable(false);
				frontSeat.setText("0.0");
				chest.setEditable(false);
				chest.setText("0.0");
				stomach.setEditable(false);
				stomach.setText("0.0");
				bicep.setEditable(false);
				bicep.setText("0.0");
				frontChest.setEditable(false);
				frontChest.setText("0.0");
				frontStomach.setEditable(false);
				frontStomach.setText("0.0");
				standCollar.setEditable(false);
				standCollar.setText("0.0");
				other.setEditable(false);
				other.setText("0.0");
				handLength.setEditable(false);
				handLength.setText("0.0");
				kataHeight.setEditable(false);
				kataHeight.setText("0.0");
				sholder.setEditable(false);
				sholder.setText("0.0");
				
				if (choice.getSelectedItem().equals("Shirt")) {

					seat.setEditable(true);
					frontSeat.setEditable(true);
					chest.setEditable(true);
					sholder.setEditable(true);
					stomach.setEditable(true);
					caugh.setEditable(true);
					bicep.setEditable(true);
					frontChest.setEditable(true);
					frontStomach.setEditable(true);
					handLength.setEditable(true);
					seat.setEditable(true);
					frontSeat.setEditable(true);
					hight.setEditable(true);
					kataHeight.setEditable(true);
					
					standCollar.setEditable(false);
					standCollar.setText("0.0");
					elbow.setEditable(false);
					elbow.setText("0.0");
					bottom.setEditable(false);
					bottom.setText("0.0");
					waist.setEditable(false);
					waist.setText("0.0");
					underline.setText("0.0");
					underline.setEditable(false);
					mandi.setEditable(false);
					mandi.setText("0.0");
					other.setText("0.0");

				} else if (choice.getSelectedItem().equals("Pant")) {

					waist.setEditable(true);
					seat.setEditable(true);
					hight.setEditable(true);
					elbow.setEditable(true);
					underline.setEditable(true);
					bottom.setEditable(true);
					mandi.setEditable(true);

					caugh.setEditable(false);
					frontSeat.setEditable(false);
					handLength.setEditable(false);
					standCollar.setEditable(false);
					collar.setEditable(false);
					chest.setEditable(false);
					sholder.setEditable(false);
					stomach.setEditable(false);
					bicep.setEditable(false);
					frontChest.setEditable(false);
					frontStomach.setEditable(false);
					standCollar.setEditable(false);
					kataHeight.setEditable(false);

				} else if (choice.getSelectedItem().equals("Kurta")) {

					seat.setEditable(true);
					sholder.setEditable(true);
					chest.setEditable(true);
					handLength.setEditable(true);
					stomach.setEditable(true);
					frontSeat.setEditable(true);
					hight.setEditable(true);
					caugh.setEditable(true);
					collar.setEditable(true);

					elbow.setEditable(false);
					bottom.setEditable(false);
					bicep.setEditable(false);
					frontChest.setEditable(false);
					frontStomach.setEditable(false);
					standCollar.setEditable(false);
					frontSeat.setEditable(false);
					waist.setEditable(false);
					underline.setEditable(false);
					kataHeight.setEditable(false);
					mandi.setEditable(false);

				}  else if (choice.getSelectedItem().equals("Suit") || choice.getSelectedItem().equals("Blazer")) {

					seat.setEditable(true);
					sholder.setEditable(true);
					chest.setEditable(true);
					handLength.setEditable(true);
					stomach.setEditable(true);
					hight.setEditable(true);
					
					frontSeat.setEditable(false);
					caugh.setEditable(false);
					collar.setEditable(false);
					elbow.setEditable(false);
					bottom.setEditable(false);
					bicep.setEditable(false);
					frontChest.setEditable(false);
					frontStomach.setEditable(false);
					standCollar.setEditable(false);
					frontSeat.setEditable(false);
					kataHeight.setEditable(false);
					waist.setEditable(false);
					underline.setEditable(false);
					mandi.setEditable(false);

				} 
				 else if (choice.getSelectedItem().equals("Jodhapuri") ) {

						seat.setEditable(true);
						sholder.setEditable(true);
						chest.setEditable(true);
						handLength.setEditable(true);
						stomach.setEditable(true);
						hight.setEditable(true);
						standCollar.setEditable(true);
						
						frontSeat.setEditable(false);
						caugh.setEditable(false);
						collar.setEditable(false);
						elbow.setEditable(false);
						bottom.setEditable(false);
						bicep.setEditable(false);
						frontChest.setEditable(false);
						frontStomach.setEditable(false);
						frontSeat.setEditable(false);
						waist.setEditable(false);
						underline.setEditable(false);
						mandi.setEditable(false);
						kataHeight.setEditable(false);

					} 
				 else if (choice.getSelectedItem().equals("Sherwani") ) {

						seat.setEditable(true);
						sholder.setEditable(true);
						chest.setEditable(true);
						handLength.setEditable(true);
						stomach.setEditable(true);
						hight.setEditable(true);
						collar.setEditable(true);
						caugh.setEditable(true);
						
						frontSeat.setEditable(false);
						standCollar.setEditable(false);
						elbow.setEditable(false);
						bottom.setEditable(false);
						bicep.setEditable(false);
						frontChest.setEditable(false);
						frontStomach.setEditable(false);
						frontSeat.setEditable(false);
						waist.setEditable(false);
						kataHeight.setEditable(false);
						underline.setEditable(false);
						mandi.setEditable(false);

					} 
				 else if (choice.getSelectedItem().equals("V-Jacket") ) {

						seat.setEditable(true);
						sholder.setEditable(true);
						chest.setEditable(true);
						stomach.setEditable(true);
						hight.setEditable(true);
						
						handLength.setEditable(false);
						collar.setEditable(false);
						caugh.setEditable(false);
						frontSeat.setEditable(false);
						standCollar.setEditable(false);
						elbow.setEditable(false);
						bottom.setEditable(false);
						bicep.setEditable(false);
						frontChest.setEditable(false);
						frontStomach.setEditable(false);
						frontSeat.setEditable(false);
						waist.setEditable(false);
						underline.setEditable(false);
						mandi.setEditable(false);
						kataHeight.setEditable(false);

					}
				 else if (choice.getSelectedItem().equals("Modi-Jacket") ) {

						seat.setEditable(true);
						sholder.setEditable(true);
						chest.setEditable(true);
						stomach.setEditable(true);
						hight.setEditable(true);
						collar.setEditable(true);
						
						handLength.setEditable(false);
						caugh.setEditable(false);
						frontSeat.setEditable(false);
						standCollar.setEditable(false);
						elbow.setEditable(false);
						bottom.setEditable(false);
						bicep.setEditable(false);
						frontChest.setEditable(false);
						frontStomach.setEditable(false);
						frontSeat.setEditable(false);
						waist.setEditable(false);
						kataHeight.setEditable(false);
						underline.setEditable(false);
						mandi.setEditable(false);

					} 
				else if (choice.getSelectedItem().equals("Salwar")) {

					waist.setEditable(true);
					seat.setEditable(true);
					elbow.setEditable(true);
					bottom.setEditable(true);
					mandi.setEditable(true);

					underline.setEditable(false);
					hight.setEditable(false);
					caugh.setEditable(false);
					frontSeat.setEditable(false);
					handLength.setEditable(false);
					standCollar.setEditable(false);
					collar.setEditable(false);
					chest.setEditable(false);
					sholder.setEditable(false);
					stomach.setEditable(false);
					bicep.setEditable(false);
					frontChest.setEditable(false);
					frontStomach.setEditable(false);
					standCollar.setEditable(false);
				}else {
					waist.setEditable(false);
					seat.setEditable(false);
					hight.setEditable(false);
					caugh.setEditable(false);
					seat.setEditable(false);
					elbow.setEditable(false);
					underline.setEditable(false);
					frontSeat.setEditable(false);
					chest.setEditable(false);
					stomach.setEditable(false);
					bicep.setEditable(false);
					frontChest.setEditable(false);
					frontStomach.setEditable(false);
					standCollar.setEditable(false);
					other.setEditable(false);
					handLength.setEditable(false);
					kataHeight.setEditable(false);
					sholder.setEditable(false);
				}

			}
		});
		frame.getContentPane().add(choice);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Type:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(50, 321, 163, 23);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(236, 280, 247, 20);
		frame.getContentPane().add(dateChooser);

		JLabel lblNewLabel_2 = new JLabel("Height:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(50, 366, 82, 14);
		frame.getContentPane().add(lblNewLabel_2);

		hight = new JTextField();
		hight.setText("0.0");
		hight.setBounds(236, 365, 247, 20);
		frame.getContentPane().add(hight);
		hight.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Chest:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(50, 404, 82, 14);
		frame.getContentPane().add(lblNewLabel_3);

		chest = new JTextField();
		chest.setText("0.0");
		chest.setBounds(236, 403, 247, 20);
		frame.getContentPane().add(chest);
		chest.setColumns(10);

		JLabel stomachLable = new JLabel("Stomach:");
		stomachLable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		stomachLable.setBounds(52, 441, 89, 14);
		frame.getContentPane().add(stomachLable);

		stomach = new JTextField();
		stomach.setText("0.0");
		stomach.setBounds(236, 440, 247, 20);
		frame.getContentPane().add(stomach);
		stomach.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Seat:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(52, 481, 80, 14);
		frame.getContentPane().add(lblNewLabel_4);

		seat = new JTextField();
		seat.setText("0.0");
		seat.setBounds(236, 480, 247, 20);
		frame.getContentPane().add(seat);
		seat.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Sholder:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(590, 140, 108, 14);
		frame.getContentPane().add(lblNewLabel_5);

		sholder = new JTextField();
		sholder.setText("0.0");
		sholder.setBounds(723, 139, 189, 20);
		frame.getContentPane().add(sholder);
		sholder.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Hand Length:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(590, 172, 108, 19);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Caugh:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(590, 204, 108, 19);
		frame.getContentPane().add(lblNewLabel_7);

		handLength = new JTextField();
		handLength.setText("0.0");
		handLength.setBounds(723, 173, 189, 20);
		frame.getContentPane().add(handLength);
		handLength.setColumns(10);

		caugh = new JTextField();
		caugh.setText("0.0");
		caugh.setBounds(723, 207, 189, 20);
		frame.getContentPane().add(caugh);
		caugh.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Bicep:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(590, 238, 108, 23);
		frame.getContentPane().add(lblNewLabel_8);

		bicep = new JTextField();
		bicep.setText("0.0");
		bicep.setBounds(723, 241, 189, 20);
		frame.getContentPane().add(bicep);
		bicep.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Front Chest:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(590, 281, 108, 14);
		frame.getContentPane().add(lblNewLabel_9);

		frontChest = new JTextField();
		frontChest.setText("0.0");
		frontChest.setBounds(723, 280, 189, 20);
		frame.getContentPane().add(frontChest);
		frontChest.setColumns(10);

		JLabel lblNewLabel_9_1 = new JLabel("Front Stomach:");
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1.setBounds(590, 320, 132, 14);
		frame.getContentPane().add(lblNewLabel_9_1);

		frontStomach = new JTextField();
		frontStomach.setText("0.0");
		frontStomach.setBounds(723, 320, 189, 20);
		frame.getContentPane().add(frontStomach);
		frontStomach.setColumns(10);

		JLabel lblNewLabel_9_1_1 = new JLabel("Front Seat:");
		lblNewLabel_9_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1.setBounds(590, 366, 132, 14);
		frame.getContentPane().add(lblNewLabel_9_1_1);

		frontSeat = new JTextField();
		frontSeat.setText("0.0");
		frontSeat.setBounds(723, 365, 189, 20);
		frame.getContentPane().add(frontSeat);
		frontSeat.setColumns(10);

		JLabel lblNewLabel_9_1_1_1 = new JLabel("Kata Height:");
		lblNewLabel_9_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1.setBounds(590, 403, 132, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1);

		kataHeight = new JTextField();
		kataHeight.setText("0.0");
		kataHeight.setBounds(723, 403, 189, 20);
		frame.getContentPane().add(kataHeight);
		kataHeight.setColumns(10);

		JLabel lblNewLabel_9_1_1_1_1 = new JLabel("Waist:");
		lblNewLabel_9_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1.setBounds(590, 443, 132, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1);

		waist = new JTextField();
		waist.setText("0.0");
		waist.setBounds(723, 440, 189, 20);
		frame.getContentPane().add(waist);
		waist.setColumns(10);

		JLabel lblNewLabel_9_1_1_1_1_1 = new JLabel("Mandi:");
		lblNewLabel_9_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_1.setBounds(590, 481, 132, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_1);

		mandi = new JTextField();
		mandi.setText("0.0");
		mandi.setBounds(723, 480, 189, 20);
		frame.getContentPane().add(mandi);
		mandi.setColumns(10);

		JLabel lblNewLabel_9_1_1_1_1_2 = new JLabel("Elbow:");
		lblNewLabel_9_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_2.setBounds(991, 142, 132, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_2);

		elbow = new JTextField();
		elbow.setText("0.0");
		elbow.setBounds(1116, 139, 173, 20);
		frame.getContentPane().add(elbow);
		elbow.setColumns(10);

		JLabel lblNewLabel_9_1_1_1_1_3 = new JLabel("Underline:");
		lblNewLabel_9_1_1_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3.setBounds(991, 176, 89, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3);

		underline = new JTextField();
		underline.setText("0.0");
		underline.setBounds(1116, 173, 173, 20);
		frame.getContentPane().add(underline);
		underline.setColumns(10);

		JLabel lblNewLabel_9_1_1_1_1_3_1 = new JLabel("Collar:");
		lblNewLabel_9_1_1_1_1_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1.setBounds(991, 210, 89, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1);

		collar = new JTextField();
		collar.setText("0.0");
		collar.setBounds(1116, 207, 173, 20);
		frame.getContentPane().add(collar);
		collar.setColumns(10);

		standCollar = new JTextField();
		standCollar.setText("0.0");
		standCollar.setBounds(1116, 241, 173, 20);
		frame.getContentPane().add(standCollar);
		standCollar.setColumns(10);

		JLabel lblNewLabel_9_1_1_1_1_3_1_1 = new JLabel("Stand Collar:");
		lblNewLabel_9_1_1_1_1_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1_1.setBounds(991, 244, 108, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1_1);

		JLabel lblNewLabel_9_1_1_1_1_3_1_2 = new JLabel("Other:");
		lblNewLabel_9_1_1_1_1_3_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1_2.setBounds(991, 320, 89, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1_2);

		other = new JTextField();
		other.setText("0.0");
		other.setBounds(1116, 320, 173, 20);
		frame.getContentPane().add(other);
		other.setColumns(10);
		
		JLabel lblNewLabel_9_1_1_1_1_3_1_2_1 = new JLabel("Bottom:");
		lblNewLabel_9_1_1_1_1_3_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1_2_1.setBounds(991, 280, 89, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1_2_1);
		
		bottom = new JTextField();
		bottom.setText("0.0");
		bottom.setBounds(1116, 280, 173, 20);
		frame.getContentPane().add(bottom);
		bottom.setColumns(10);
		
		JLabel lblNewLabel_9_1_1_1_1_3_1_2_2 = new JLabel("Qty:");
		lblNewLabel_9_1_1_1_1_3_1_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1_2_2.setBounds(991, 368, 89, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1_2_2);
		
		count = new JTextField();
		count.setBounds(1116, 365, 173, 20);
		frame.getContentPane().add(count);
		count.setColumns(10);
		
		JLabel lblNewLabel_9_1_1_1_1_3_1_2_3 = new JLabel("Price(Qty:1):");
		lblNewLabel_9_1_1_1_1_3_1_2_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1_2_3.setBounds(991, 404, 108, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1_2_3);
		
		price = new JTextField();
		price.setBounds(1116, 403, 173, 20);
		frame.getContentPane().add(price);
		price.setColumns(10);
		price.setText("0.0");
		price.addKeyListener(new Price());
		
		JLabel lblNewLabel_9_1_1_1_1_3_1_2_2_1 = new JLabel("Total Amount:");
		lblNewLabel_9_1_1_1_1_3_1_2_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9_1_1_1_1_3_1_2_2_1.setBounds(991, 483, 119, 17);
		frame.getContentPane().add(lblNewLabel_9_1_1_1_1_3_1_2_2_1);
		
		totalAmount = new JTextField();
		totalAmount.setBounds(1116, 480, 119, 20);
		frame.getContentPane().add(totalAmount);
		totalAmount.setColumns(10);
		totalAmount.setEditable(false);
		btnNewButton_1.addActionListener(new Back(frame));

	}

	public class Back implements ActionListener {
		private JFrame frame;

		public Back(JFrame frame) {
			this.frame = frame;
		}

		public void actionPerformed(ActionEvent t) {
			this.frame.setVisible(false);
			CustomerDetails cust = new CustomerDetails();
			cust.getFrame().setVisible(true);
		}
	}
	
	public class Price implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			Double d;
			if(price.getText().equals(null)) {
				d=0.0;
				System.out.println("In");
				d*=Double.parseDouble(count.getText());
				totalAmount.setText("Rs."+d.toString());
			}
			else {
				try {
					d=Double.parseDouble(price.getText());
					d*=Double.parseDouble(count.getText());
					totalAmount.setText("Rs."+d.toString());
				}
				catch(Exception ex) {
					d=0.0;
					d*=Double.parseDouble(count.getText());
					totalAmount.setText("Rs."+d.toString());
				}
		
			}
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			Double d;
			if(price.getText().equals(null)) {
				d=0.0;
				System.out.println("In");
				d*=Double.parseDouble(count.getText());
				totalAmount.setText("Rs."+d.toString());
			}
			else {
				try {
					d=Double.parseDouble(price.getText());
					d*=Double.parseDouble(count.getText());
					totalAmount.setText("Rs."+d.toString());
				}
				catch(Exception ex) {
					d=0.0;
					d*=Double.parseDouble(count.getText());
					totalAmount.setText("Rs."+d.toString());
				}
		
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			Double d;
			if(price.getText().equals(null)) {
				d=0.0;
				System.out.println("In");
				d*=Double.parseDouble(count.getText());
				totalAmount.setText("Rs."+d.toString());
			}
			else {
				try {
					d=Double.parseDouble(price.getText());
					d*=Double.parseDouble(count.getText());
					totalAmount.setText("Rs."+d.toString());
				}
				catch(Exception ex) {
					d=0.0;
					d*=Double.parseDouble(count.getText());
					totalAmount.setText("Rs."+d.toString());
				}
		
			}
			
		}

		
	}

	private class Submit implements ActionListener {
		private JFrame frame;

		public Submit(JFrame frame, String name, String address, String phone) {

			this.frame = frame;
		}

		public void actionPerformed(ActionEvent t) {
			c = new Customer();
			try {
				c.setName(name.getText());
				c.setAddress(address.getText());
				c.setPhoneNumber(phone.getText());
				c.setBookingDate((Date) textField.getValue());
				c.setDeliveryDate(dateChooser.getDate());
				c.setType(choice.getSelectedItem());
				c.setHeight(Double.parseDouble(hight.getText()));
				c.setChest(Double.parseDouble(chest.getText()));
				c.setStomach(Double.parseDouble(stomach.getText()));
				c.setSeat(Double.parseDouble(seat.getText()));
				c.setBicep(Double.parseDouble(bicep.getText()));
				c.setFrontChest(Double.parseDouble(frontChest.getText()));
				c.setFrontStomach(Double.parseDouble(frontStomach.getText()));
				c.setFrontSeat(Double.parseDouble(frontSeat.getText()));
				c.setKataHeight(Double.parseDouble(kataHeight.getText()));
				c.setWaist(Double.parseDouble(waist.getText()));
				c.setMandi(Double.parseDouble(mandi.getText()));
				c.setStandCollar(Double.parseDouble(standCollar.getText()));
				c.setOther(Double.parseDouble(other.getText()));

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tailer", "root",
						"Alase8888@me");

				java.sql.Date D = new java.sql.Date(c.getDeliveryDate().getTime());
				java.sql.Date B = new java.sql.Date(c.getBookingDate().getTime());
				System.out.println(D);
				System.out.println(B);
				String query = " insert into Customer (name, address, phone, bookingdate, deliverydate,type,height,chest,stomach,seat,bicep,front_chest,front_stomach,front_seat,kata_height,waist,mandi,stand_collar,other)"
						+ " values (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, c.getName());
				preparedStmt.setString(2, c.getAddress());
				preparedStmt.setString(3, c.getPhoneNumber());
				preparedStmt.setDate(4, B);
				preparedStmt.setDate(5, D);
				preparedStmt.setString(6, c.getType());
				preparedStmt.setDouble(7, c.getHeight());
				preparedStmt.setDouble(8, c.getChest());
				preparedStmt.setDouble(9, c.getStomach());
				preparedStmt.setDouble(10, c.getSeat());
				preparedStmt.setDouble(11, c.getBicep());
				preparedStmt.setDouble(12, c.getFrontChest());
				preparedStmt.setDouble(13, c.getFrontStomach());
				preparedStmt.setDouble(14, c.getFrontSeat());
				preparedStmt.setDouble(15, c.getKataHeight());
				preparedStmt.setDouble(16, c.getWaist());
				preparedStmt.setDouble(17, c.getMandi());
				preparedStmt.setDouble(18, c.getStandCollar());
				preparedStmt.setDouble(19, c.getOther());
				preparedStmt.execute();
				con.close();
				JOptionPane.showMessageDialog(frame, "Successfully Inserted a Record!!!!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame, "Please fill required fields!!!");
				System.out.println(e);
			}

		}
	}
}
