package com.login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.customer.CustomerDetails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Rectangle;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class TellerBuilder {

	public JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private static final String username = "Omkar";
	private static final String password = "Omkar@123";
	JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TellerBuilder window = new TellerBuilder();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean passwordCheck(String username, char[] pass) {
		if (pass.length != TellerBuilder.password.length())
			return false;
		for (int i = 0; i < pass.length; i++) {
			if (pass[i] != TellerBuilder.password.charAt(i))
				return false;
		}
		if (username.equals(TellerBuilder.username)) {
			return true;
		}
		return false;
	}

	/**
	 * Create the application.
	 */

	public TellerBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login!!!");
		frmLogin.getContentPane().setBackground(SystemColor.activeCaption);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 17));
		frmLogin.setSize(483,
				253);
		frmLogin.setMaximizedBounds(new Rectangle(0, 0, 500, 500));
		frmLogin.setVisible(true);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Omkar\\Downloads\\WhatsApp Image 2021-06-30 at 3.20.30 PM.jpg"));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(171, 11, 217, 42);
		frmLogin.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(162, 64, 169, 20);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(90, 67, 62, 14);
		frmLogin.getContentPane().add(lblNewLabel_1);

		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.menu);
		passwordField.setBounds(162, 95, 169, 20);
		frmLogin.getContentPane().add(passwordField);

		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(90, 98, 62, 14);
		frmLogin.getContentPane().add(lblNewLabel_2);

		btnNewButton = new JButton("Login!!!");
		btnNewButton.setBounds(162, 141, 108, 20);
		frmLogin.getContentPane().add(btnNewButton);

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(162, 186, 169, 30);
		frmLogin.getContentPane().add(lblNewLabel_3);
		btnNewButton.addActionListener(new ButtonClickListener());
	}

	private class ButtonClickListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (new TellerBuilder().passwordCheck(textField.getText(), passwordField.getPassword())) {
				CustomerDetails success = new CustomerDetails();
				success.getFrame().setVisible(true);
				frmLogin.setVisible(false);
			} else {
				frmLogin.setVisible(false);
				JOptionPane.showMessageDialog(frmLogin, "Wrong Credentiaals....");


			}

		}
	}
}
