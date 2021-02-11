package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.MenteeAndMentorService;
import Eckford.services.PersonService;
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

public class MenteeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField FNameField;
	private JTextField LNameField;
	private JTextField PhoneField;
	private JTextField emailField;
	private JTextField RaceField;
	private JTextField NationalityField;
	private JTextField EthnicityField;
	private JTextField LGBTField;
	private JTextField SexField;

	private DatabaseConnectionService dbService;

	public MenteeDialog(DatabaseConnectionService dbService) {
		this.dbService = dbService;
		setTitle("Add Mentee");
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
			JLabel EmailLabel = new JLabel("Email");
			EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_EmailLabel = new GridBagConstraints();
			gbc_EmailLabel.anchor = GridBagConstraints.EAST;
			gbc_EmailLabel.insets = new Insets(0, 0, 5, 5);
			gbc_EmailLabel.gridx = 0;
			gbc_EmailLabel.gridy = 3;
			contentPanel.add(EmailLabel, gbc_EmailLabel);
		}
		{
			emailField = new JTextField();
			GridBagConstraints gbc_emailField = new GridBagConstraints();
			gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailField.insets = new Insets(0, 0, 5, 0);
			gbc_emailField.gridx = 1;
			gbc_emailField.gridy = 3;
			contentPanel.add(emailField, gbc_emailField);
			emailField.setColumns(10);
		}
		{
			JLabel RaceLabel = new JLabel("Race");
			RaceLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_RaceLabel = new GridBagConstraints();
			gbc_RaceLabel.anchor = GridBagConstraints.EAST;
			gbc_RaceLabel.insets = new Insets(0, 0, 5, 5);
			gbc_RaceLabel.gridx = 0;
			gbc_RaceLabel.gridy = 4;
			contentPanel.add(RaceLabel, gbc_RaceLabel);
		}
		{
			RaceField = new JTextField();
			GridBagConstraints gbc_RaceField = new GridBagConstraints();
			gbc_RaceField.fill = GridBagConstraints.HORIZONTAL;
			gbc_RaceField.insets = new Insets(0, 0, 5, 0);
			gbc_RaceField.gridx = 1;
			gbc_RaceField.gridy = 4;
			contentPanel.add(RaceField, gbc_RaceField);
			RaceField.setColumns(10);
		}
		{
			JLabel NationalityLabel = new JLabel("Nationality");
			NationalityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_NationalityLabel = new GridBagConstraints();
			gbc_NationalityLabel.anchor = GridBagConstraints.EAST;
			gbc_NationalityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_NationalityLabel.gridx = 0;
			gbc_NationalityLabel.gridy = 5;
			contentPanel.add(NationalityLabel, gbc_NationalityLabel);
		}
		{
			NationalityField = new JTextField();
			GridBagConstraints gbc_NationalityField = new GridBagConstraints();
			gbc_NationalityField.insets = new Insets(0, 0, 5, 0);
			gbc_NationalityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_NationalityField.gridx = 1;
			gbc_NationalityField.gridy = 5;
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
			gbc_EthnicityLabel_1.gridy = 6;
			contentPanel.add(EthnicityLabel_1, gbc_EthnicityLabel_1);
		}
		{
			EthnicityField = new JTextField();
			GridBagConstraints gbc_EthnicityField = new GridBagConstraints();
			gbc_EthnicityField.insets = new Insets(0, 0, 5, 0);
			gbc_EthnicityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_EthnicityField.gridx = 1;
			gbc_EthnicityField.gridy = 6;
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
			gbc_LGBTLabel.gridy = 7;
			contentPanel.add(LGBTLabel, gbc_LGBTLabel);
		}
		{
			LGBTField = new JTextField();
			GridBagConstraints gbc_LGBTField = new GridBagConstraints();
			gbc_LGBTField.insets = new Insets(0, 0, 5, 0);
			gbc_LGBTField.fill = GridBagConstraints.HORIZONTAL;
			gbc_LGBTField.gridx = 1;
			gbc_LGBTField.gridy = 7;
			contentPanel.add(LGBTField, gbc_LGBTField);
			LGBTField.setColumns(10);
		}
		{
			JLabel SexLabel = new JLabel("Sex");
			SexLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_SexLabel = new GridBagConstraints();
			gbc_SexLabel.anchor = GridBagConstraints.EAST;
			gbc_SexLabel.insets = new Insets(0, 0, 5, 5);
			gbc_SexLabel.gridx = 0;
			gbc_SexLabel.gridy = 8;
			contentPanel.add(SexLabel, gbc_SexLabel);
		}
		{
			SexField = new JTextField();
			GridBagConstraints gbc_SexField = new GridBagConstraints();
			gbc_SexField.insets = new Insets(0, 0, 5, 0);
			gbc_SexField.fill = GridBagConstraints.HORIZONTAL;
			gbc_SexField.gridx = 1;
			gbc_SexField.gridy = 8;
			contentPanel.add(SexField, gbc_SexField);
			SexField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Next");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						savePerson();
						new PreferenceDialog(dbService); 
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

	protected void savePerson() {
		Person p = new Person();
		p.Fname = FNameField.getText();
		p.Lname = LNameField.getText();
		p.PhoneNumber = PhoneField.getText();
		p.Email = emailField.getText();
		p.Nationality = NationalityField.getText();
		p.Race = RaceField.getText();
		p.Ethnicity = EthnicityField.getText();
		p.Sex = SexField.getText();
		p.LGBT = LGBTField.getText();
		

		// TODO: Add more checks for invalid input
		try {

			if (p.Fname.trim().length() > 0 && p.Lname.trim().length() > 0) {
				new MenteeAndMentorService(dbService).addMentee(p); 
			} else {
				JOptionPane.showMessageDialog(MenteeDialog.this, "Did not enter in first name or last name", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			setVisible(false);
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
