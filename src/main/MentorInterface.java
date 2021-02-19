package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.PersonService;
import Tables.Address;
import Tables.AddressTableModel;
import Tables.Person;
import Tables.PersonTableModel;
import Tables.Preference;
import Tables.PreferenceTableModel;

public class MentorInterface extends JFrame{

	private JPanel contentPane;
	private JTable personTable;
	private JTable addressTable;
	PersonService pService;
	Person p;

	public MentorInterface(DatabaseConnectionService dbService) {
		
		try {
			pService = new PersonService(dbService);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
		}

		setTitle("Mentor Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

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
		
		ArrayList<Person> people = pService.searchPerson(dbService.getConnectedUserEmail());
		if(!people.isEmpty()) {
			personTable.setModel(new PersonTableModel(people));
			if(people.get(0).AddressID != null) {
				ArrayList<Address> address = pService.findAddress(dbService.getConnectedUserEmail());
				addressTable.setModel(new AddressTableModel(address));
			}
		}
		
		

		JPanel buttonPanel = new JPanel();
		contentPane.add(buttonPanel, BorderLayout.SOUTH);

		JButton AddPersonButton = new JButton("Add Person");
		AddPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MentorDialog addPerson = new MentorDialog(dbService);
				addPerson.setVisible(true);
			}
		});
		
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
				}
			}
		});
		buttonPanel.add(AddPersonButton);
		buttonPanel.add(refreshButton);

	}

}
