package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.MenteeAndMentorService;
import Tables.Person;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class MentorDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField FNameField;
	private JTextField LNameField;
	private JTextField PhoneField;
	private JTextField NationalityField;
	private JTextField EthnicityField;
	private JComboBox raceBox;
	private JComboBox experienceBox;
	private JComboBox fieldBox;
	private JComboBox sexBox;
	private JComboBox LGBTBox;
	private DatabaseConnectionService dbService;
	private JTextField posField;

	public MentorDialog(DatabaseConnectionService dbService) {
		this.dbService = dbService;
		setTitle("Add Mentor");
		setBounds(100, 100, 392, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 105, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel FNameLabel = new JLabel("First Name");
			FNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_FNameLabel = new GridBagConstraints();
			gbc_FNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_FNameLabel.anchor = GridBagConstraints.EAST;
			gbc_FNameLabel.gridx = 0;
			gbc_FNameLabel.gridy = 0;
			contentPanel.add(FNameLabel, gbc_FNameLabel);
		}
		{
			FNameField = new JTextField();
			GridBagConstraints gbc_FNameField = new GridBagConstraints();
			gbc_FNameField.fill = GridBagConstraints.HORIZONTAL;
			gbc_FNameField.insets = new Insets(0, 0, 5, 0);
			gbc_FNameField.gridx = 1;
			gbc_FNameField.gridy = 0;
			contentPanel.add(FNameField, gbc_FNameField);
			FNameField.setColumns(10);
		}
		{
			JLabel LNameLabel = new JLabel("Last Name");
			LNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_LNameLabel = new GridBagConstraints();
			gbc_LNameLabel.anchor = GridBagConstraints.EAST;
			gbc_LNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_LNameLabel.gridx = 0;
			gbc_LNameLabel.gridy = 1;
			contentPanel.add(LNameLabel, gbc_LNameLabel);
		}
		{
			LNameField = new JTextField();
			GridBagConstraints gbc_LNameField = new GridBagConstraints();
			gbc_LNameField.fill = GridBagConstraints.HORIZONTAL;
			gbc_LNameField.insets = new Insets(0, 0, 5, 0);
			gbc_LNameField.gridx = 1;
			gbc_LNameField.gridy = 1;
			contentPanel.add(LNameField, gbc_LNameField);
			LNameField.setColumns(10);
		}
		{
			JLabel PhoneLabel = new JLabel("Phone Number");
			PhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_PhoneLabel = new GridBagConstraints();
			gbc_PhoneLabel.anchor = GridBagConstraints.EAST;
			gbc_PhoneLabel.insets = new Insets(0, 0, 5, 5);
			gbc_PhoneLabel.gridx = 0;
			gbc_PhoneLabel.gridy = 2;
			contentPanel.add(PhoneLabel, gbc_PhoneLabel);
		}
		{
			PhoneField = new JTextField();
			GridBagConstraints gbc_PhoneField = new GridBagConstraints();
			gbc_PhoneField.fill = GridBagConstraints.HORIZONTAL;
			gbc_PhoneField.insets = new Insets(0, 0, 5, 0);
			gbc_PhoneField.gridx = 1;
			gbc_PhoneField.gridy = 2;
			contentPanel.add(PhoneField, gbc_PhoneField);
			PhoneField.setColumns(10);
		}
		{
			JLabel RaceLabel = new JLabel("Race");
			RaceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_RaceLabel = new GridBagConstraints();
			gbc_RaceLabel.anchor = GridBagConstraints.EAST;
			gbc_RaceLabel.insets = new Insets(0, 0, 5, 5);
			gbc_RaceLabel.gridx = 0;
			gbc_RaceLabel.gridy = 3;
			contentPanel.add(RaceLabel, gbc_RaceLabel);
		}
		{
			raceBox = new JComboBox();
			raceBox.setModel(new DefaultComboBoxModel(
					new String[] { "", "American Indian or Alaskan Native", "Asian", "Black or African American",
							"Native Hawaiian or Other Pacific Islander", "White Hispanic", "White Non-Hispanic" }));
			GridBagConstraints gbc_raceBox = new GridBagConstraints();
			gbc_raceBox.insets = new Insets(0, 0, 5, 0);
			gbc_raceBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_raceBox.gridx = 1;
			gbc_raceBox.gridy = 3;
			contentPanel.add(raceBox, gbc_raceBox);
		}
		{
			JLabel NationalityLabel = new JLabel("Nationality");
			NationalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_NationalityLabel = new GridBagConstraints();
			gbc_NationalityLabel.anchor = GridBagConstraints.EAST;
			gbc_NationalityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_NationalityLabel.gridx = 0;
			gbc_NationalityLabel.gridy = 4;
			contentPanel.add(NationalityLabel, gbc_NationalityLabel);
		}
		{
			NationalityField = new JTextField();
			GridBagConstraints gbc_NationalityField = new GridBagConstraints();
			gbc_NationalityField.insets = new Insets(0, 0, 5, 0);
			gbc_NationalityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_NationalityField.gridx = 1;
			gbc_NationalityField.gridy = 4;
			contentPanel.add(NationalityField, gbc_NationalityField);
			NationalityField.setColumns(10);
		}
		{
			JLabel EthnicityLabel_1 = new JLabel("Ethnicity");
			EthnicityLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_EthnicityLabel_1 = new GridBagConstraints();
			gbc_EthnicityLabel_1.anchor = GridBagConstraints.EAST;
			gbc_EthnicityLabel_1.insets = new Insets(0, 0, 5, 5);
			gbc_EthnicityLabel_1.gridx = 0;
			gbc_EthnicityLabel_1.gridy = 5;
			contentPanel.add(EthnicityLabel_1, gbc_EthnicityLabel_1);
		}
		{
			EthnicityField = new JTextField();
			GridBagConstraints gbc_EthnicityField = new GridBagConstraints();
			gbc_EthnicityField.insets = new Insets(0, 0, 5, 0);
			gbc_EthnicityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_EthnicityField.gridx = 1;
			gbc_EthnicityField.gridy = 5;
			contentPanel.add(EthnicityField, gbc_EthnicityField);
			EthnicityField.setColumns(10);
		}
		{
			JLabel LGBTLabel = new JLabel("LGBT");
			LGBTLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_LGBTLabel = new GridBagConstraints();
			gbc_LGBTLabel.anchor = GridBagConstraints.EAST;
			gbc_LGBTLabel.insets = new Insets(0, 0, 5, 5);
			gbc_LGBTLabel.gridx = 0;
			gbc_LGBTLabel.gridy = 6;
			contentPanel.add(LGBTLabel, gbc_LGBTLabel);
		}
		{
			LGBTBox = new JComboBox();
			LGBTBox.setModel(new DefaultComboBoxModel(new String[] { "", "Yes", "No", "Prefer not to say" }));
			GridBagConstraints gbc_LGBTBox = new GridBagConstraints();
			gbc_LGBTBox.insets = new Insets(0, 0, 5, 0);
			gbc_LGBTBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_LGBTBox.gridx = 1;
			gbc_LGBTBox.gridy = 6;
			contentPanel.add(LGBTBox, gbc_LGBTBox);
		}
		{
			JLabel SexLabel = new JLabel("Sex");
			SexLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_SexLabel = new GridBagConstraints();
			gbc_SexLabel.anchor = GridBagConstraints.EAST;
			gbc_SexLabel.insets = new Insets(0, 0, 5, 5);
			gbc_SexLabel.gridx = 0;
			gbc_SexLabel.gridy = 7;
			contentPanel.add(SexLabel, gbc_SexLabel);
		}
		{
			sexBox = new JComboBox();
			sexBox.setModel(new DefaultComboBoxModel(
					new String[] { "", "Male", "Female", "Genderqueer/Non-Binary", "Prefer not to say" }));
			GridBagConstraints gbc_sexBox = new GridBagConstraints();
			gbc_sexBox.insets = new Insets(0, 0, 5, 0);
			gbc_sexBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_sexBox.gridx = 1;
			gbc_sexBox.gridy = 7;
			contentPanel.add(sexBox, gbc_sexBox);
		}
		{
			JLabel posLabel = new JLabel("Position");
			posLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_posLabel = new GridBagConstraints();
			gbc_posLabel.anchor = GridBagConstraints.EAST;
			gbc_posLabel.insets = new Insets(0, 0, 5, 5);
			gbc_posLabel.gridx = 0;
			gbc_posLabel.gridy = 8;
			contentPanel.add(posLabel, gbc_posLabel);
		}
		{
			posField = new JTextField();
			GridBagConstraints gbc_posField = new GridBagConstraints();
			gbc_posField.insets = new Insets(0, 0, 5, 0);
			gbc_posField.fill = GridBagConstraints.HORIZONTAL;
			gbc_posField.gridx = 1;
			gbc_posField.gridy = 8;
			contentPanel.add(posField, gbc_posField);
			posField.setColumns(10);
		}
		{
			JLabel senLabel = new JLabel("Years of Experience");
			senLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_senLabel = new GridBagConstraints();
			gbc_senLabel.anchor = GridBagConstraints.EAST;
			gbc_senLabel.insets = new Insets(0, 0, 5, 5);
			gbc_senLabel.gridx = 0;
			gbc_senLabel.gridy = 9;
			contentPanel.add(senLabel, gbc_senLabel);
		}
		{
			experienceBox = new JComboBox();
			experienceBox.setModel(new DefaultComboBoxModel(new String[] { "", "0-1 years", "1-2 years", "3-4 years",
					"4-6 years", "6-10 years", "10+ years" }));
			GridBagConstraints gbc_experienceBox = new GridBagConstraints();
			gbc_experienceBox.insets = new Insets(0, 0, 5, 0);
			gbc_experienceBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_experienceBox.gridx = 1;
			gbc_experienceBox.gridy = 9;
			contentPanel.add(experienceBox, gbc_experienceBox);
		}
		{
			JLabel FieldLabel = new JLabel("Field");
			FieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_FieldLabel = new GridBagConstraints();
			gbc_FieldLabel.anchor = GridBagConstraints.EAST;
			gbc_FieldLabel.insets = new Insets(0, 0, 5, 5);
			gbc_FieldLabel.gridx = 0;
			gbc_FieldLabel.gridy = 10;
			contentPanel.add(FieldLabel, gbc_FieldLabel);
		}
		{
			fieldBox = new JComboBox();
			fieldBox.setModel(new DefaultComboBoxModel(new String[] { "", "Accounting",
					"Architecture and Civil Engineering", "Business, Management, and Administration", "Communications",
					"Computer and Electrical Engineering", "Computer Science and Software Engineering",
					"Health and Medicine", "Law and Public Policy", "Mechanical Engineering", "Math and Science" }));
			GridBagConstraints gbc_fieldBox = new GridBagConstraints();
			gbc_fieldBox.insets = new Insets(0, 0, 5, 0);
			gbc_fieldBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_fieldBox.gridx = 1;
			gbc_fieldBox.gridy = 10;
			contentPanel.add(fieldBox, gbc_fieldBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Next");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (savePerson()) {
							AddressDialog ad = new AddressDialog(dbService);
							ad.setVisible(true);
						}
					}
				});
				saveButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
				saveButton.setActionCommand("OK");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							setVisible(false);
							dispose();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private boolean savePerson() {
		Person p = new Person();
		p.Fname = FNameField.getText();
		p.Lname = LNameField.getText();
		p.PhoneNumber = PhoneField.getText();
		p.Email = dbService.getConnectedUserEmail();
		p.Nationality = NationalityField.getText();
		p.Race = (String) raceBox.getSelectedItem();
		p.Ethnicity = EthnicityField.getText();
		p.Sex = (String) sexBox.getSelectedItem(); 
		p.LGBT = (String) LGBTBox.getSelectedItem(); 
		p.Seniority =(String)experienceBox.getSelectedItem();
		p.Field = (String) fieldBox.getSelectedItem();
		p.Position = posField.getText();
		
		if(p.Fname.trim().length() == 0 || p.Lname.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
				"Invalid Name Length", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(p.PhoneNumber.trim().length() != 7 && p.PhoneNumber.trim().length() != 10) {
			JOptionPane.showMessageDialog(MentorDialog.this,
				"Invalid Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (!p.Email.contains("@")) {
			JOptionPane.showMessageDialog(MentorDialog.this,
				"Invalid Email Address", "Error", JOptionPane.ERROR_MESSAGE);
		} 
		else if (p.Nationality.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid Nationality", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (p.Race.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid Race", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (p.Ethnicity.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid Ethnicity", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (p.Sex.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid Sex", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (p.LGBT.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid LGBT Option", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (p.Field.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid Field", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (p.Position.trim().length() == 0) {
			JOptionPane.showMessageDialog(MentorDialog.this,
					"Invalid Position Specificed", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if(new MenteeAndMentorService(dbService).addMentor(p)) {
			// create address input screen
			AddressDialog ad = new AddressDialog(dbService);
			ad.setVisible(true);
			// get rid of the unfocused window
			setVisible(false);
			dispose();
		}
		return false;
	}

}
