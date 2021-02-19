package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Eckford.services.MiscServices;
import Tables.Company;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;

public class CompanyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField PhoneField;
	private JTextField EmailField;
	private JComboBox CompanyNameBox;
	private JTextField AddressField;
	private JTextField ZipField;
	private JTextField UnitNumberField;
	private JTextField CityField;
	private JComboBox StateBox;

	public CompanyDialog(DatabaseConnectionService dbService) {
		setBounds(100, 100, 449, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel CompanyNameLabel = new JLabel("Company Name");
			CompanyNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_CompanyNameLabel = new GridBagConstraints();
			gbc_CompanyNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_CompanyNameLabel.gridx = 0;
			gbc_CompanyNameLabel.gridy = 1;
			contentPanel.add(CompanyNameLabel, gbc_CompanyNameLabel);
		}
		{
			CompanyNameBox = new JComboBox();
			CompanyNameBox.setModel(new DefaultComboBoxModel(new MiscServices(dbService).getCompanies()));
			CompanyNameBox.setEditable(true);
			GridBagConstraints gbc_CompanyNameBox = new GridBagConstraints();
			gbc_CompanyNameBox.gridwidth = 3;
			gbc_CompanyNameBox.insets = new Insets(0, 0, 5, 0);
			gbc_CompanyNameBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_CompanyNameBox.gridx = 1;
			gbc_CompanyNameBox.gridy = 1;
			contentPanel.add(CompanyNameBox, gbc_CompanyNameBox);
		}
		{
			JLabel PhoneLabel = new JLabel("Phone\r\n");
			PhoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_PhoneLabel = new GridBagConstraints();
			gbc_PhoneLabel.insets = new Insets(0, 0, 5, 5);
			gbc_PhoneLabel.gridx = 0;
			gbc_PhoneLabel.gridy = 2;
			contentPanel.add(PhoneLabel, gbc_PhoneLabel);
		}
		{
			PhoneField = new JTextField();
			GridBagConstraints gbc_PhoneField = new GridBagConstraints();
			gbc_PhoneField.gridwidth = 3;
			gbc_PhoneField.insets = new Insets(0, 0, 5, 0);
			gbc_PhoneField.fill = GridBagConstraints.HORIZONTAL;
			gbc_PhoneField.gridx = 1;
			gbc_PhoneField.gridy = 2;
			contentPanel.add(PhoneField, gbc_PhoneField);
			PhoneField.setColumns(10);
		}
		{
			JLabel EmailLabel = new JLabel("Company Contact Email");
			EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_EmailLabel = new GridBagConstraints();
			gbc_EmailLabel.insets = new Insets(0, 0, 5, 5);
			gbc_EmailLabel.gridx = 0;
			gbc_EmailLabel.gridy = 3;
			contentPanel.add(EmailLabel, gbc_EmailLabel);
		}
		{
			EmailField = new JTextField();
			GridBagConstraints gbc_EmailField = new GridBagConstraints();
			gbc_EmailField.insets = new Insets(0, 0, 5, 0);
			gbc_EmailField.gridwidth = 3;
			gbc_EmailField.fill = GridBagConstraints.HORIZONTAL;
			gbc_EmailField.gridx = 1;
			gbc_EmailField.gridy = 3;
			contentPanel.add(EmailField, gbc_EmailField);
			EmailField.setColumns(10);
		}
		{
			JLabel CompanyAddrLabel = new JLabel("Company Address");
			CompanyAddrLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_CompanyAddrLabel = new GridBagConstraints();
			gbc_CompanyAddrLabel.insets = new Insets(0, 0, 5, 5);
			gbc_CompanyAddrLabel.gridx = 0;
			gbc_CompanyAddrLabel.gridy = 4;
			contentPanel.add(CompanyAddrLabel, gbc_CompanyAddrLabel);
		}
		{
			AddressField = new JTextField();
			GridBagConstraints gbc_AddressField = new GridBagConstraints();
			gbc_AddressField.gridwidth = 3;
			gbc_AddressField.insets = new Insets(0, 0, 5, 0);
			gbc_AddressField.fill = GridBagConstraints.HORIZONTAL;
			gbc_AddressField.gridx = 1;
			gbc_AddressField.gridy = 4;
			contentPanel.add(AddressField, gbc_AddressField);
			AddressField.setColumns(10);
		}
		{
			JLabel ZipLabel = new JLabel("CompanyZip");
			ZipLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_ZipLabel = new GridBagConstraints();
			gbc_ZipLabel.insets = new Insets(0, 0, 5, 5);
			gbc_ZipLabel.gridx = 0;
			gbc_ZipLabel.gridy = 5;
			contentPanel.add(ZipLabel, gbc_ZipLabel);
		}
		{
			ZipField = new JTextField();
			GridBagConstraints gbc_ZipField = new GridBagConstraints();
			gbc_ZipField.insets = new Insets(0, 0, 5, 0);
			gbc_ZipField.gridwidth = 3;
			gbc_ZipField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ZipField.gridx = 1;
			gbc_ZipField.gridy = 5;
			contentPanel.add(ZipField, gbc_ZipField);
			ZipField.setColumns(10);
		}
		{
			JLabel BuildingNumberLabel = new JLabel("Company Office Number");
			BuildingNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_BuildingNumberLabel = new GridBagConstraints();
			gbc_BuildingNumberLabel.insets = new Insets(0, 0, 5, 5);
			gbc_BuildingNumberLabel.gridx = 0;
			gbc_BuildingNumberLabel.gridy = 6;
			contentPanel.add(BuildingNumberLabel, gbc_BuildingNumberLabel);
		}
		{
			UnitNumberField = new JTextField();
			GridBagConstraints gbc_UnitNumberField = new GridBagConstraints();
			gbc_UnitNumberField.insets = new Insets(0, 0, 5, 0);
			gbc_UnitNumberField.gridwidth = 3;
			gbc_UnitNumberField.fill = GridBagConstraints.HORIZONTAL;
			gbc_UnitNumberField.gridx = 1;
			gbc_UnitNumberField.gridy = 6;
			contentPanel.add(UnitNumberField, gbc_UnitNumberField);
			UnitNumberField.setColumns(10);
		}
		{
			JLabel CityLabel = new JLabel("City");
			CityLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_CityLabel = new GridBagConstraints();
			gbc_CityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_CityLabel.gridx = 0;
			gbc_CityLabel.gridy = 7;
			contentPanel.add(CityLabel, gbc_CityLabel);
		}
		{
			CityField = new JTextField();
			GridBagConstraints gbc_CityField = new GridBagConstraints();
			gbc_CityField.insets = new Insets(0, 0, 5, 0);
			gbc_CityField.gridwidth = 3;
			gbc_CityField.fill = GridBagConstraints.HORIZONTAL;
			gbc_CityField.gridx = 1;
			gbc_CityField.gridy = 7;
			contentPanel.add(CityField, gbc_CityField);
			CityField.setColumns(10);
		}
		{
			JLabel StateLabel = new JLabel("State");
			StateLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_StateLabel = new GridBagConstraints();
			gbc_StateLabel.insets = new Insets(0, 0, 0, 5);
			gbc_StateLabel.gridx = 0;
			gbc_StateLabel.gridy = 8;
			contentPanel.add(StateLabel, gbc_StateLabel);
		}
		{
			StateBox = new JComboBox();
			StateBox.setModel(new DefaultComboBoxModel(new String[] { "", "AL", "AK", "AZ", "AR", "CA", "CO", "CT",
					"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
					"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
					"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" }));
			GridBagConstraints gbc_StateBox = new GridBagConstraints();
			gbc_StateBox.gridwidth = 3;
			gbc_StateBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_StateBox.gridx = 1;
			gbc_StateBox.gridy = 8;
			contentPanel.add(StateBox, gbc_StateBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Company c = new Company();
						c.CompanyName = (String) CompanyNameBox.getSelectedItem();
						c.Email = EmailField.getText();
						c.PhoneNumber = PhoneField.getText();
						c.address.Address = AddressField.getText();
						c.address.Zip = ZipField.getText();
						c.address.UnitNumber = UnitNumberField.getText();
						c.address.State = (String) StateBox.getSelectedItem();
						c.address.City = CityField.getText();

						if (new MiscServices(dbService).addCompanyInfo(c)) {
							JOptionPane.showMessageDialog(null, "Insert Successful");
							dispose();
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(CompanyDialog.this, "Error:", "Error on company insert",
									JOptionPane.ERROR_MESSAGE);
						}
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
