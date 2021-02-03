package main;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

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
			FileInputStream fis = null;
			Properties prop = null;
			try {
				fis = new FileInputStream("Eckford.properties");
				prop = new Properties();
				prop.load(fis);
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				fis.close();
			}

			connection = new DatabaseConnectionService(prop.getProperty("databaseName"),
					prop.getProperty("serverName"));

			if (!connection.connect(prop.getProperty("serverName"), prop.getProperty("serverPassword"))) {
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
