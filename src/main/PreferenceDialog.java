package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.PreferenceService;
import Tables.Preference;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PreferenceDialog extends JDialog {
	private DatabaseConnectionService dbService;
	private final JPanel contentPanel = new JPanel();
	private JTextField CityField;
	private JTextField NationalityField;
	private JTextField EthnicityField;
	private JTextField LGBTField;
	private JComboBox fieldBox;
	private JComboBox sexBox;
	private JComboBox raceBox;
	private JComboBox stateBox;
	private JComboBox experienceBox;

	public PreferenceDialog(DatabaseConnectionService dbService) {
		this.dbService = dbService;
		setTitle("Add Preference");
		setBounds(100, 100, 392, 414);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 105, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel StateLabel = new JLabel("State");
			StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_StateLabel = new GridBagConstraints();
			gbc_StateLabel.anchor = GridBagConstraints.EAST;
			gbc_StateLabel.insets = new Insets(0, 0, 5, 5);
			gbc_StateLabel.gridx = 0;
			gbc_StateLabel.gridy = 1;
			contentPanel.add(StateLabel, gbc_StateLabel);
		}
		{
			stateBox = new JComboBox();
			stateBox.setModel(new DefaultComboBoxModel(new String[] { "", "AL", "AK", "AZ", "AR", "CA", "CO", "CT",
					"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
					"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
					"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
			GridBagConstraints gbc_stateBox = new GridBagConstraints();
			gbc_stateBox.insets = new Insets(0, 0, 5, 0);
			gbc_stateBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_stateBox.gridx = 1;
			gbc_stateBox.gridy = 1;
			contentPanel.add(stateBox, gbc_stateBox);
		}
		{
			JLabel CityLabel = new JLabel("City");
			CityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_CityLabel = new GridBagConstraints();
			gbc_CityLabel.anchor = GridBagConstraints.EAST;
			gbc_CityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_CityLabel.gridx = 0;
			gbc_CityLabel.gridy = 2;
			contentPanel.add(CityLabel, gbc_CityLabel);
		}
		{
			CityField = new JTextField();
			GridBagConstraints gbc_CityField = new GridBagConstraints();
			gbc_CityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_CityField.insets = new Insets(0, 0, 5, 0);
			gbc_CityField.gridx = 1;
			gbc_CityField.gridy = 2;
			contentPanel.add(CityField, gbc_CityField);
			CityField.setColumns(10);
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
			GridBagConstraints gbc_racebox = new GridBagConstraints();
			gbc_racebox.insets = new Insets(0, 0, 5, 0);
			gbc_racebox.fill = GridBagConstraints.HORIZONTAL;
			gbc_racebox.gridx = 1;
			gbc_racebox.gridy = 3;
			contentPanel.add(raceBox, gbc_racebox);

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
			LGBTField = new JTextField();
			GridBagConstraints gbc_LGBTField = new GridBagConstraints();
			gbc_LGBTField.insets = new Insets(0, 0, 5, 0);
			gbc_LGBTField.fill = GridBagConstraints.HORIZONTAL;
			gbc_LGBTField.gridx = 1;
			gbc_LGBTField.gridy = 6;
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
			gbc_SexLabel.gridy = 7;
			contentPanel.add(SexLabel, gbc_SexLabel);
		}
		{
			sexBox = new JComboBox();
			sexBox.setModel(new DefaultComboBoxModel(
					new String[] { "", "Male", "Female", "Genderqueer/Non-Binary", "Prefer not to say" }));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 7;
			contentPanel.add(sexBox, gbc_comboBox);
		}
		{
			JLabel FieldLabel = new JLabel("Field of Work");
			FieldLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_FieldLabel = new GridBagConstraints();
			gbc_FieldLabel.anchor = GridBagConstraints.EAST;
			gbc_FieldLabel.insets = new Insets(0, 0, 5, 5);
			gbc_FieldLabel.gridx = 0;
			gbc_FieldLabel.gridy = 8;
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
			gbc_fieldBox.gridy = 8;
			contentPanel.add(fieldBox, gbc_fieldBox);

		}
		{
			JLabel SeniorityLabel = new JLabel("Years of Experience");
			SeniorityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_SeniorityLabel = new GridBagConstraints();
			gbc_SeniorityLabel.anchor = GridBagConstraints.EAST;
			gbc_SeniorityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_SeniorityLabel.gridx = 0;
			gbc_SeniorityLabel.gridy = 9;
			contentPanel.add(SeniorityLabel, gbc_SeniorityLabel);
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("Save");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Preference p = new Preference();
						p.City = CityField.getText();
						p.Nationality = NationalityField.getText();
						p.Ethnicity = EthnicityField.getText();
						p.Field = (String) fieldBox.getSelectedItem();
						p.LGBT = LGBTField.getText();
						// TODO: Fix this to be an integer value. Right now it only gets the first value of experience field
						p.Seniority = Integer.parseInt((String) experienceBox.getSelectedItem(), 0);
						p.Sex = (String) sexBox.getSelectedItem();
						p.State = (String) stateBox.getSelectedItem();

						// TODO: Fix this in the table and the preference dialog. Kinda a silly thing to
						// put in the preference form
						p.Position = "Any";

						// TODO: Change how the mentee service works so you have to enter in a
						// preference and then
						PreferenceService prefService = new PreferenceService(dbService);
						if (prefService.addPreference(p)) {
							JOptionPane.showMessageDialog(null, "Preference entered successfully");
							// TODO: Update mentee with preferenceID

						} else {
							JOptionPane.showMessageDialog(null, "Preference entered failed");
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

}
