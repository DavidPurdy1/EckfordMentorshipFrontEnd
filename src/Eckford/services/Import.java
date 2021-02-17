//package Eckford.services;
//
//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import java.awt.Font;
//import java.awt.Insets;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextArea;
//import javax.swing.border.EmptyBorder;
//
//import Eckford.services.DatabaseConnectionService;
//import Eckford.services.MenteeAndMentorService;
//import Eckford.services.PersonService;
//import Tables.Person;
//import Tables.PersonTableModel;
//
//import java.io.File;
//
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
//import jxl.write.Label;
//import jxl.write.WriteException;
//
//public class Import extends JFrame {
//
//	private JPanel contentPane;
//	private JTextArea fileName;
//	JFileChooser fc;
//	JTextArea log;
//	PersonService pService;
//	Person p;
//
//	public Import(DatabaseConnectionService dbService) {
//		setTitle("Import Data");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 725, 455);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//
//		JPanel panel = new JPanel();
//		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
//		flowLayout.setAlignment(FlowLayout.LEFT);
//		contentPane.add(panel, BorderLayout.NORTH);
//
//		JLabel lblNewLabel = new JLabel("Select a File");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		panel.add(lblNewLabel);
//
//		fileName = new JTextArea();
//		panel.add(fileName);
//		fileName.setColumns(10);
//
//		log = new JTextArea(5, 20);
//		log.setMargin(new Insets(5, 5, 5, 5));
//		log.setEditable(false);
//		JScrollPane logScrollPane = new JScrollPane(log);
//		fc = new JFileChooser();
//
//		JButton btnNewButton = new JButton("Import");
//		btnNewButton.addActionListener(new ActionListener() {
//
//			// This is for searching for items in the table
//			public void actionPerformed(ActionEvent e) {
////				if (e.getSource() == btnNewButton) {
////					int returnVal = fc.showOpenDialog(Import.this);
////
////					if (returnVal == JFileChooser.APPROVE_OPTION) {
////						File file = fc.getSelectedFile();
////						fileName.insert(file.getName(), 0);
////						log.append("Opening: " + file.getName() + ".");
////						excelRead(dbService, file);
////					} else {
////						log.append("Open command cancelled by user.");
////					}
////					log.setCaretPosition(log.getDocument().getLength());
////				}
//
//			}
//		});
//		panel.add(btnNewButton);
//
//		JScrollPane scrollPane = new JScrollPane();
//		contentPane.add(scrollPane, BorderLayout.CENTER);
//
//	}
//}
