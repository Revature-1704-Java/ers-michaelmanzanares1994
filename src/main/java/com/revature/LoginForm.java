package com.revature;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revature.util.ConnectionUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class LoginForm extends JFrame {
	private LoginForm instance;
	
	private JPanel contentPane;
	private JTextField username_field;
	private JTextField password_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public LoginForm() {
		
		instance = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username_field = new JTextField();
		username_field.setBounds(205, 61, 86, 20);
		contentPane.add(username_field);
		username_field.setColumns(10);
		
		password_field = new JTextField();
		password_field.setBounds(205, 135, 86, 20);
		contentPane.add(password_field);
		password_field.setColumns(10);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(43, 64, 93, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(49, 138, 87, 14);
		contentPane.add(lblPassword);
		
		JCheckBox chckbxManager = new JCheckBox("Manager");
		chckbxManager.setBounds(133, 176, 97, 23);
		contentPane.add(chckbxManager);

		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create connection
				try {
					Connection conn = ConnectionUtil.getConnection();
					 JOptionPane.showMessageDialog(null, "connection successful");

					// get data from text field(user input)
					String name = username_field.getText();
					String password = password_field.getText();
					
					// get data from database!
					String query = "SELECT * FROM LOGIN WHERE USERNAME = ? AND PASSWORD = ?";
					PreparedStatement stmt = conn.prepareStatement(query);
					stmt.setString(1, name);
					stmt.setString(2, password);
					
					ResultSet set = stmt.executeQuery();
					if(set.next()) {

						if(chckbxManager.isSelected()) {
							instance.setVisible(false);
							ManagerView.main(null);
							
						}else {
							instance.setVisible(false);
							ReimbursmentForm.main(null);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					}
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(43, 209, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username_field.setText(null);
				password_field.setText(null);
			}
		});
		btnReset.setBounds(187, 209, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLogin.setBounds(153, 11, 138, 39);
		contentPane.add(lblLogin);
	}
}
