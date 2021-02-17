package Eckford.services;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Tables.Person;

public class ImportCSV extends JFrame {

	private JPanel contentPane;
	private JTextArea fileName;
	JFileChooser fc;
	JTextArea log;
	PersonService pService;
	Person p;

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

					try {
						Scanner sc = new Scanner(file);
						sc.useDelimiter(",");
						while (sc.hasNext()) {
							System.out.print(sc.next());
						}
						sc.close();
					} catch (FileNotFoundException e1) {
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
