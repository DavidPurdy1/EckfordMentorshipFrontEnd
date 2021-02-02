package main;

import java.awt.EventQueue;

import Eckford.services.DatabaseConnectionService;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabaseConnectionService dbService = connect(); 
					UserLogin frame = new UserLogin(dbService);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static DatabaseConnectionService connect() {
		DatabaseConnectionService connection = null;
		try {
//			FileInputStream fis = null;
//			Properties prop = null;
//			try {
//				fis = new FileInputStream("Eckford.properties");
//				prop = new Properties();
//				prop.load(fis);
//			} catch (FileNotFoundException fnfe) {
//				fnfe.printStackTrace();
//			} catch (IOException ioe) {
//				ioe.printStackTrace();
//			} finally {
//				fis.close();
//			}

			connection = new DatabaseConnectionService("titan.csse.rose-hulman.edu",
					"Eckford_Mentorship_Management_System");

			if (!connection.connect("EckfordApplicationUser", "EckfordApplicationUserPass123")) {
				System.out.println("Failure on connect");
			}
		} catch (Exception e) {
			// JOptionPane.showMessageDialog(UserInterface.this, "Error: " + e, "Error",
			// JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return connection;
	}
}
