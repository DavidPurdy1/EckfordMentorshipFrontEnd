package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.PersonService;
import Eckford.services.UserService;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameField;
	private JTextField PasswordField;
	private UserService loginService;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserLogin frame = new UserLogin();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public UserLogin(DatabaseConnectionService dbService) {

		try {
			loginService = new UserService(dbService);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Eckford Database Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel UserNameLabel = new JLabel("User Name");
		UserNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_UserNameLabel = new GridBagConstraints();
		gbc_UserNameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_UserNameLabel.anchor = GridBagConstraints.EAST;
		gbc_UserNameLabel.gridx = 2;
		gbc_UserNameLabel.gridy = 1;
		contentPane.add(UserNameLabel, gbc_UserNameLabel);

		UserNameField = new JTextField();
		GridBagConstraints gbc_UserNameField = new GridBagConstraints();
		gbc_UserNameField.insets = new Insets(0, 0, 5, 0);
		gbc_UserNameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_UserNameField.gridx = 3;
		gbc_UserNameField.gridy = 1;
		contentPane.add(UserNameField, gbc_UserNameField);
		UserNameField.setColumns(10);

		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_PasswordLabel = new GridBagConstraints();
		gbc_PasswordLabel.anchor = GridBagConstraints.EAST;
		gbc_PasswordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_PasswordLabel.gridx = 2;
		gbc_PasswordLabel.gridy = 3;
		contentPane.add(PasswordLabel, gbc_PasswordLabel);

		PasswordField = new JTextField();
		GridBagConstraints gbc_PasswordField = new GridBagConstraints();
		gbc_PasswordField.insets = new Insets(0, 0, 5, 0);
		gbc_PasswordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_PasswordField.gridx = 3;
		gbc_PasswordField.gridy = 3;
		contentPane.add(PasswordField, gbc_PasswordField);
		PasswordField.setColumns(10);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// TODO: add verification service
				String user = UserNameField.getText();
				String pass = PasswordField.getText();
				if (user != null && user.trim().length() > 0 && pass != null && pass.trim().length() > 0) {
					if (loginService.login(user, pass)) {
						UserInterface ui = new UserInterface(dbService);
						ui.setVisible(true);
						setVisible(false);
						dispose();
					}
				} else
					JOptionPane.showMessageDialog(null, "User or Password cannot be blank");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = UserNameField.getText();
				String pass = PasswordField.getText();
				// TODO: Add registration
				if (user != null && user.trim().length() > 0 && pass != null && pass.trim().length() > 0) {
					if (loginService.register(user, pass)) {
						// TODO: add success
					}
				}else
					JOptionPane.showMessageDialog(null, "User or Password cannot be blank");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 7;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
	}

}
