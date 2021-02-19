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
import Tables.Address;
import Tables.AddressTableModel;
import Tables.MatchTableModel;
import Tables.Person;
import Tables.PersonTableModel;
import Tables.Preference;
import Tables.PreferenceTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class MenteeInterface extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JTable personTable;
	private JTable addressTable;
	private JTable preferenceTable;
	private JLabel match;
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
		contentPane.add(panel, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createTitledBorder ("Person Info"));
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBorder(BorderFactory.createTitledBorder ("Address Info"));
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBorder(BorderFactory.createTitledBorder ("Preference Info"));
		panel.add(scrollPane);
		panel.add(scrollPane2);
		panel.add(scrollPane3);


		personTable = new JTable();
		scrollPane.setViewportView(personTable);
		addressTable = new JTable();
		scrollPane2.setViewportView(addressTable);
		preferenceTable = new JTable();
		scrollPane3.setViewportView(preferenceTable);
		
		ArrayList<Person> people = pService.searchPerson(dbService.getConnectedUserEmail());
		ArrayList<Preference> preferences = pService.getPreference(dbService.getConnectedUserEmail());
		if(!people.isEmpty()) {
			personTable.setModel(new PersonTableModel(people));
			if(people.get(0).AddressID != null) {
				ArrayList<Address> address = pService.findAddress(dbService.getConnectedUserEmail());
				addressTable.setModel(new AddressTableModel(address));
			}
			if(!preferences.isEmpty()) {
				preferenceTable.setModel(new PreferenceTableModel(preferences));
			}
			
		}
		// TODO: IF THEY DO NOT EXIST IN THE MENTEE TABLE THEN IT WILL TRY TO FIND THE
		// MATCHES RIGHT AT THE BEGINNING
		// table.setModel(new MatchTableModel(new3
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
		
		JButton refreshButton = new JButton("Refresh Table");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Person> people = pService.searchPerson(dbService.getConnectedUserEmail());
				if(!people.isEmpty()) {
					personTable.setModel(new PersonTableModel(people));
					if(people.get(0).AddressID != null) {
						ArrayList<Address> address = pService.findAddress(dbService.getConnectedUserEmail());
						addressTable.setModel(new AddressTableModel(address));
					}
					ArrayList<Preference> preferences = pService.getPreference(dbService.getConnectedUserEmail());
					if(!preferences.isEmpty()) {
						preferenceTable.setModel(new PreferenceTableModel(preferences));
					}
				}
			}
		});

		FindMatchesButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonPanel.add(FindMatchesButton);
		buttonPanel.add(AddPreference);
		buttonPanel.add(AddPersonButton);
		buttonPanel.add(refreshButton);
	}
}
