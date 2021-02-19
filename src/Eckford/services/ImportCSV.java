package Eckford.services;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Tables.Address;
import Tables.Person;
import Tables.Preference;

public class ImportCSV extends JFrame {

	private JPanel contentPane;
	private JTextArea fileName;
	JFileChooser fc;
	JTextArea log;
	PersonService pService;
	Person p;
	String role;

	public ImportCSV(DatabaseConnectionService dbService) {
		setTitle("Import Data");
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

		JLabel lblNewLabel = new JLabel("Select a File");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		fileName = new JTextArea();
		panel.add(fileName);
		fileName.setColumns(10);

		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		fc = new JFileChooser();

		JButton btnNewButton = new JButton("Import");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (fc.showOpenDialog(ImportCSV.this) == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					fileName.insert(file.getName(), 0);
					log.append("Opening: " + file.getName() + ".");
					Scanner sc;
					String line;
					int index = 0;
					try {
						BufferedReader reader = new BufferedReader(new FileReader(file));
						while ((line = reader.readLine()) != null) {
							Person p = new Person();
							Address a = new Address();
							Preference p2 = new Preference();
							sc = new Scanner(line);
							sc.useDelimiter(",");
							while (sc.hasNext()) {
								String data = sc.next();
								if (index == 0)
									p.Fname = data;
								else if (index == 1)
									p.Lname = data;
								else if (index == 2)
									p.PhoneNumber = data;
								else if (index == 3)
									p.Email = data;
								else if (index == 4)
									p.Race = data;
								else if (index == 5)
									p.Nationality = data;
								else if (index == 6)
									p.Ethnicity = data;
								else if (index == 7)
									p.LGBT = data;
								else if (index == 8)
									p.Sex = data;
								else if (index == 9)
									p.Position = data;
								else if (index == 10)
									p.Seniority = data;
								else if (index == 11)
									p.Field = data;
								else if (index == 12)
									a.Address = data;
								else if (index == 13)
									a.Zip= data;
								else if (index == 14)
									a.UnitNumber = data;
								else if (index == 15)
									a.State = data;
								else if (index == 16)
									a.City = data;
								else if (index == 17) {
									role = data;
									new MiscServices(dbService).addAddress(a);
									if(data.equals("Mentor")) {
										new MenteeAndMentorService(dbService).addMentor(p);
									}
									else {
										new MenteeAndMentorService(dbService).addMentee(p);
									}
								}
								else
									System.out.println("invalid data::" + data);
								if(role == "Mentee") {
									if(index == 18)
										p2.Sex = data;
									else if(index == 19)
										p2.LGBT = data;
									else if(index == 20)
										p2.Field = data;
									else if(index == 21)
										p2.City = data;
									else if(index == 22)
										p2.State = data;
									else if(index == 23) {
										p2.Seniority = data;
										new PreferenceService(dbService).addPreference(p2);
									}
									else
										System.out.println("invalid data::" + data);
								}		
								
								index++;
							}
							sc.close();
							index = 0;
						}
						reader.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		panel.add(btnNewButton);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
	}

}
