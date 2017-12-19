package com.revature;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revature.util.ConnectionUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ReimbursmentForm extends JFrame {

	private JPanel contentPane;
	private JTextField e_id;
	private JTextField r_amt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReimbursmentForm frame = new ReimbursmentForm();
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
	public ReimbursmentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpId = new JLabel("Employee ID");
		lblEmpId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmpId.setBounds(26, 22, 151, 25);
		contentPane.add(lblEmpId);
		
		JLabel lblReimbursmentAmout = new JLabel("Reimbursment Amount");
		lblReimbursmentAmout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReimbursmentAmout.setBounds(26, 109, 199, 14);
		contentPane.add(lblReimbursmentAmout);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create connection
				try {
					Connection conn = ConnectionUtil.getConnection();
					// test connection
					// JOptionPane.showMessageDialog(null, "connection successful");
					String query = "INSERT INTO FORM VALUES(?, ?)";
					PreparedStatement stmt = conn.prepareStatement(query);
					stmt.setString(1, e_id.getText());
					stmt.setString(2, r_amt.getText());
					
					stmt.execute();
					
					// display message if data entered correctly
					JOptionPane.showMessageDialog(null, "Data entered successfully");

					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
				e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(251, 167, 89, 23);
		contentPane.add(btnSubmit);
		
		e_id = new JTextField();
		e_id.setBounds(251, 26, 86, 20);
		contentPane.add(e_id);
		e_id.setColumns(10);
		
		r_amt = new JTextField();
		r_amt.setBounds(251, 108, 86, 20);
		contentPane.add(r_amt);
		r_amt.setColumns(10);
	}
}
