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
import javax.swing.JCheckBox;

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField UserNameField;
	private JTextField PasswordField;
	private UserService loginService;

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

		JLabel UserNameLabel = new JLabel("Email");
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

				String user = UserNameField.getText();
				String pass = PasswordField.getText();

				// Verify that is a valid password and username in the database
				
				if (user != null && user.trim().length() > 0 && pass != null && pass.trim().length() > 0 && user.contains("@")) {
					if (loginService.login(user, pass)) {

						// once logged in get the track the user logged in and get their role
						String role = loginService.getRole(user);
						dbService.setConnectedUserEmailRole(user, role);

						if (role.equals("Mentor")) {
							// Launch Mentor UI
							MentorInterface ui = new MentorInterface(dbService);
							ui.setVisible(true);

						} else if (role.equals("Admin")) {

							// Admin can only be added to the database manually that way people using the
							// front end can't set themselves as an admin
							AdminInterface ai = new AdminInterface(dbService);
							ai.setVisible(true);
							
						} else if (role.equals("Mentee")) {
							// Launch Mentee Ui
							MenteeInterface ui = new MenteeInterface(dbService);
							ui.setVisible(true);
						}
						setVisible(false);
						dispose();
					}
				} else
					JOptionPane.showMessageDialog(null, "User or Password cannot be blank");
			}
		});

		JCheckBox chckbxNewCheckBox = new JCheckBox("Registering as a mentor?");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.gridwidth = 2;
		gbc_chckbxNewCheckBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 2;
		gbc_chckbxNewCheckBox.gridy = 5;
		contentPane.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
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
				String mentorOrMentee = null;

				// check whether or not it is a mentor or mentee
				if (chckbxNewCheckBox.isSelected()) {
					mentorOrMentee = "Mentor";
				} else {
					mentorOrMentee = "Mentee";
				}

				// Runs register stored procedure
				if (user != null && user.trim().length() > 0 && pass != null && pass.trim().length() > 0) {
					if (loginService.register(user, pass, mentorOrMentee)) {
						JOptionPane.showMessageDialog(null, "Registration Successful !");
					}
				} else
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
