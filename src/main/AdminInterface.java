package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.ImportCSV;
import Eckford.services.MenteeAndMentorService;
import Eckford.services.PersonService;
import Eckford.services.PreferenceService;
import Tables.Match;
import Tables.MatchTableModel;
import Tables.Person;
import Tables.PersonTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class AdminInterface extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JTable table;
	PersonService pService;
	Person p;

	public AdminInterface(DatabaseConnectionService dbService) {
		try {
			pService = new PersonService(dbService);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Admin Interface");
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

		JLabel lblNewLabel = new JLabel("Enter Email Address");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		emailField = new JTextField();
		panel.add(emailField);
		emailField.setColumns(10);

		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {

			// This is for searching for items in the table
			public void actionPerformed(ActionEvent e) {
				try {
					String Email = emailField.getText();
					ArrayList<Person> people = null;
					if (Email != null && Email.trim().length() > 0) {
						people = pService.searchPerson(Email);
					} else {
						people = pService.getAllPerson();
					}
					table.setModel(new PersonTableModel(people));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(AdminInterface.this, "Error: " + ex, "Searching failed",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		panel.add(btnNewButton);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton FindMatchesButton = new JButton("Find Matches");
		panel.add(FindMatchesButton);
		FindMatchesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferenceService ps = new PreferenceService(dbService);
				String Email = emailField.getText();
				if (Email != null && Email.trim().length() > 0) {
					ArrayList<Match> m = ps.findMatches(Email);
					System.out.println("found all matches");
					if (m.size() > 0) {
						table.setModel(new MatchTableModel(m));
					} else {
						JOptionPane.showMessageDialog(AdminInterface.this, "Error: ",
								"No matching mentors with preference", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		FindMatchesButton.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton Import = new JButton("Import");
		buttonPanel.add(Import);
	}
}
