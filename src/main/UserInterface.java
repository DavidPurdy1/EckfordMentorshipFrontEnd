package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.Person;
import Eckford.services.PersonService;
import Eckford.services.PersonTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField LastNametextField;
	private JTable table;
	PersonService pService;
	Person p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {

		// get the information from the Eckford.properties and creates a new connection
		DatabaseConnectionService connection = connect();
		try {
			pService = new PersonService(connection);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("User Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Enter Last Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		LastNametextField = new JTextField();
		panel.add(LastNametextField);
		LastNametextField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {

			// This is for searching for items in the table
			public void actionPerformed(ActionEvent e) {
				try {
					String lastName = LastNametextField.getText();
					ArrayList<Person> people = null;
					if (lastName != null && lastName.trim().length() > 0) {
						people = pService.searchPerson(lastName);
					} else {
						people = pService.getAllPerson();
					}
					table.setModel(new PersonTableModel(people));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(UserInterface.this, "Error: " + ex, "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new PersonTableModel(pService.getAllPerson()));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton AddPersonButton = new JButton("Add Person");
		AddPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPersonDialog addPerson = new AddPersonDialog(connection);
				addPerson.setVisible(true);
			}
		});
		buttonPanel.add(AddPersonButton);
	}

	public static DatabaseConnectionService connect() {
		DatabaseConnectionService connection = null;
		try {
//			FileInputStream fis = null;
//			Properties prop = null;
//			try {
//				fis = new FileInputStream("Eckford.properties");
//				prop = new Properties();
//				prop.load(fis);
//			} catch (FileNotFoundException fnfe) {
//				fnfe.printStackTrace();
//			} catch (IOException ioe) {
//				ioe.printStackTrace();
//			} finally {
//				fis.close();
//			}

			connection = new DatabaseConnectionService("titan.csse.rose-hulman.edu",
					"Eckford_Mentorship_Management_System");

			if (!connection.connect("EckfordApplicationUser", "EckfordApplicationUserPass123")) {
				System.out.println("Failure on connect");
			}
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(UserInterface.this, "Error: " + e, "Error",
			// JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return connection;
	}

}
