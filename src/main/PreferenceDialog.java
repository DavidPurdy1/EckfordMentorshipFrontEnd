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
import Eckford.services.MenteeAndMentorService;
import Eckford.services.PreferenceService;
import Tables.Match;
import Tables.Preference;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PreferenceDialog extends JDialog {
	private DatabaseConnectionService dbService;
	private final JPanel contentPanel = new JPanel();
	private JTextField CityField;
	private JTextField RaceField;
	private JTextField NationalityField;
	private JTextField EthnicityField;
	private JTextField LGBTField;
	private JTextField SexField;
	private JTextField StateField;
	private JTextField FieldField;
	private JTextField SeniorityField;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			PreferenceDialog dialog = new PreferenceDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
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
			StateField = new JTextField();
			GridBagConstraints gbc_StateField = new GridBagConstraints();
			gbc_StateField.insets = new Insets(0, 0, 5, 0);
			gbc_StateField.fill = GridBagConstraints.HORIZONTAL;
			gbc_StateField.gridx = 1;
			gbc_StateField.gridy = 1;
			contentPanel.add(StateField, gbc_StateField);
			StateField.setColumns(10);
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
			RaceField = new JTextField();
			GridBagConstraints gbc_RaceField = new GridBagConstraints();
			gbc_RaceField.fill = GridBagConstraints.HORIZONTAL;
			gbc_RaceField.insets = new Insets(0, 0, 5, 0);
			gbc_RaceField.gridx = 1;
			gbc_RaceField.gridy = 3;
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
			SexField = new JTextField();
			GridBagConstraints gbc_SexField = new GridBagConstraints();
			gbc_SexField.insets = new Insets(0, 0, 5, 0);
			gbc_SexField.fill = GridBagConstraints.HORIZONTAL;
			gbc_SexField.gridx = 1;
			gbc_SexField.gridy = 7;
			contentPanel.add(SexField, gbc_SexField);
			SexField.setColumns(10);
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
			FieldField = new JTextField();
			GridBagConstraints gbc_FieldField = new GridBagConstraints();
			gbc_FieldField.insets = new Insets(0, 0, 5, 0);
			gbc_FieldField.fill = GridBagConstraints.HORIZONTAL;
			gbc_FieldField.gridx = 1;
			gbc_FieldField.gridy = 8;
			contentPanel.add(FieldField, gbc_FieldField);
			FieldField.setColumns(10);
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
			SeniorityField = new JTextField();
			GridBagConstraints gbc_SeniorityField = new GridBagConstraints();
			gbc_SeniorityField.insets = new Insets(0, 0, 5, 0);
			gbc_SeniorityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_SeniorityField.gridx = 1;
			gbc_SeniorityField.gridy = 9;
			contentPanel.add(SeniorityField, gbc_SeniorityField);
			SeniorityField.setColumns(10);
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
						p.Field = FieldField.getText();
						p.LGBT = LGBTField.getText();
						p.Seniority = Integer.parseInt(SeniorityField.getText());
						p.Sex = SexField.getText();
						p.State = StateField.getText();

						// TODO: Fix this in the table and the preference dialog. Kinda a silly thing to
						// put in the preference form
						p.Position = "N/A";
						
						//TODO: Change how the mentee service works so you have to enter in a preference and then 
						PreferenceService prefService = new PreferenceService(dbService);
						prefService.addPreference(p);
						JOptionPane.showMessageDialog(null, "Preference entered successfully");

						MenteeAndMentorService mmService = new MenteeAndMentorService(dbService);
						// TODO: Find match for a mentee,
						// once they are matched use its email to add in a mentee entry
						
						// TODO: HOW DO I GET EMAIL TF
//						ArrayList<Match> match = prefService.match(); 
//						
//						for(Match m : match) {
//							// m.Email
//						}
						// TODO: Add to the mentee table

						mmService.addMentee();
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
