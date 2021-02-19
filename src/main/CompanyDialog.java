package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eckford.services.DatabaseConnectionService;
import Tables.Company;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;

public class CompanyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField CompanyField;
	private JTextField PhoneField;
	private JTextField EmailField;

	public CompanyDialog(DatabaseConnectionService dbService) {
		setBounds(100, 100, 449, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
			CompanyField = new JTextField();
			GridBagConstraints gbc_CompanyField = new GridBagConstraints();
			gbc_CompanyField.gridwidth = 3;
			gbc_CompanyField.insets = new Insets(0, 0, 5, 0);
			gbc_CompanyField.fill = GridBagConstraints.HORIZONTAL;
			gbc_CompanyField.gridx = 1;
			gbc_CompanyField.gridy = 1;
			contentPanel.add(CompanyField, gbc_CompanyField);
			CompanyField.setColumns(10);
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
			gbc_EmailLabel.insets = new Insets(0, 0, 0, 5);
			gbc_EmailLabel.gridx = 0;
			gbc_EmailLabel.gridy = 3;
			contentPanel.add(EmailLabel, gbc_EmailLabel);
		}
		{
			EmailField = new JTextField();
			GridBagConstraints gbc_EmailField = new GridBagConstraints();
			gbc_EmailField.gridwidth = 3;
			gbc_EmailField.fill = GridBagConstraints.HORIZONTAL;
			gbc_EmailField.gridx = 1;
			gbc_EmailField.gridy = 3;
			contentPanel.add(EmailField, gbc_EmailField);
			EmailField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Company co = new Company(); 
						
						
						
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
