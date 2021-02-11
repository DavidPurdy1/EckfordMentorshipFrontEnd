package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.MiscServices;
import Tables.Address;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddressDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField streetField;
	private JTextField zipField;
	private JTextField unitField;
	private JTextField cityField;
	private JComboBox stateBox;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			AddressDialog dialog = new AddressDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public AddressDialog(DatabaseConnectionService dbService) {
		setTitle("Address");
		setBounds(100, 100, 431, 317);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel streetLabel = new JLabel("Street Address");
			streetLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_streetLabel = new GridBagConstraints();
			gbc_streetLabel.insets = new Insets(0, 0, 5, 5);
			gbc_streetLabel.gridx = 0;
			gbc_streetLabel.gridy = 1;
			contentPanel.add(streetLabel, gbc_streetLabel);
		}
		{
			streetField = new JTextField();
			GridBagConstraints gbc_streetField = new GridBagConstraints();
			gbc_streetField.insets = new Insets(0, 0, 5, 0);
			gbc_streetField.fill = GridBagConstraints.HORIZONTAL;
			gbc_streetField.gridx = 2;
			gbc_streetField.gridy = 1;
			contentPanel.add(streetField, gbc_streetField);
			streetField.setColumns(10);
		}
		{
			JLabel zipLabel = new JLabel("Zip Code");
			zipLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_zipLabel = new GridBagConstraints();
			gbc_zipLabel.insets = new Insets(0, 0, 5, 5);
			gbc_zipLabel.gridx = 0;
			gbc_zipLabel.gridy = 2;
			contentPanel.add(zipLabel, gbc_zipLabel);
		}
		{
			zipField = new JTextField();
			GridBagConstraints gbc_zipField = new GridBagConstraints();
			gbc_zipField.insets = new Insets(0, 0, 5, 0);
			gbc_zipField.fill = GridBagConstraints.HORIZONTAL;
			gbc_zipField.gridx = 2;
			gbc_zipField.gridy = 2;
			contentPanel.add(zipField, gbc_zipField);
			zipField.setColumns(10);
		}
		{
			JLabel unitLabel = new JLabel("Unit Number");
			unitLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_unitLabel = new GridBagConstraints();
			gbc_unitLabel.insets = new Insets(0, 0, 5, 5);
			gbc_unitLabel.gridx = 0;
			gbc_unitLabel.gridy = 3;
			contentPanel.add(unitLabel, gbc_unitLabel);
		}
		{
			unitField = new JTextField();
			GridBagConstraints gbc_unitField = new GridBagConstraints();
			gbc_unitField.fill = GridBagConstraints.HORIZONTAL;
			gbc_unitField.insets = new Insets(0, 0, 5, 0);
			gbc_unitField.gridx = 2;
			gbc_unitField.gridy = 3;
			contentPanel.add(unitField, gbc_unitField);
			unitField.setColumns(10);
		}
		{
			JLabel stateLabel = new JLabel("State");
			stateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_stateLabel = new GridBagConstraints();
			gbc_stateLabel.insets = new Insets(0, 0, 5, 5);
			gbc_stateLabel.gridx = 0;
			gbc_stateLabel.gridy = 4;
			contentPanel.add(stateLabel, gbc_stateLabel);
		}
		{
			stateBox = new JComboBox();
			stateBox.setModel(new DefaultComboBoxModel(new String[] { "", "AL", "AK", "AZ", "AR", "CA", "CO", "CT",
					"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
					"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
					"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
			GridBagConstraints gbc_stateBox = new GridBagConstraints();
			gbc_stateBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_stateBox.insets = new Insets(0, 0, 5, 0);
			gbc_stateBox.gridx = 2;
			gbc_stateBox.gridy = 4;
			contentPanel.add(stateBox, gbc_stateBox);
		}
		{
			JLabel CityLabel = new JLabel("City");
			CityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_CityLabel = new GridBagConstraints();
			gbc_CityLabel.insets = new Insets(0, 0, 0, 5);
			gbc_CityLabel.gridx = 0;
			gbc_CityLabel.gridy = 5;
			contentPanel.add(CityLabel, gbc_CityLabel);
		}
		{
			cityField = new JTextField();
			GridBagConstraints gbc_cityField = new GridBagConstraints();
			gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cityField.gridx = 2;
			gbc_cityField.gridy = 5;
			contentPanel.add(cityField, gbc_cityField);
			cityField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Next");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Address a = new Address();
						a.Address = streetField.getText();
						a.City = cityField.getText();
						a.State = (String) stateBox.getSelectedItem();
						a.Zip = zipField.getText();
						a.UnitNumber = unitField.getText();
						new MiscServices(dbService).addAddress(a);

						// TODO: Add next page here and dispose of this page
						// TODO: Add to person table here
						
						new PreferenceDialog(dbService); 
						
						dispose();
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
