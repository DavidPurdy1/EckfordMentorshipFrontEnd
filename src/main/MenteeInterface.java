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

public class MenteeInterface extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JTable table;
	PersonService pService;
	Person p;

	public MenteeInterface(DatabaseConnectionService dbService) {
		try {
			pService = new PersonService(dbService);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Mentee Interface");
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

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

		// Adds user's information to front table
		// System.out.println(dbService.getConnectedUserEmail());
		ArrayList<Person> people = pService.searchPerson(dbService.getConnectedUserEmail());
		table.setModel(new PersonTableModel(people));

		// TODO: IF THEY DO NOT EXIST IN THE MENTEE TABLE THEN IT WILL TRY TO FIND THE
		// MATCHES RIGHT AT THE BEGINNING
		// table.setModel(new MatchTableModel(new
		// PreferenceService(dbService).findMatches()));

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton AddPersonButton = new JButton("Add Person");
		AddPersonButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AddPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenteeDialog addPerson = new MenteeDialog(dbService);
				addPerson.setVisible(true);
			}
		});

		JButton AddPreference = new JButton("Add Preference");
		AddPreference.setFont(new Font("Tahoma", Font.PLAIN, 14));
		AddPreference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreferenceDialog pd = new PreferenceDialog(dbService);
				pd.setVisible(true);
			}
		});

		JButton FindMatchesButton = new JButton("Find Matches");
		FindMatchesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PreferenceService ps = new PreferenceService(dbService);
				ps.findMatches();
				System.out.println("found all matches");
			}
		});

		FindMatchesButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonPanel.add(FindMatchesButton);
		buttonPanel.add(AddPreference);
		buttonPanel.add(AddPersonButton);
	}
}
