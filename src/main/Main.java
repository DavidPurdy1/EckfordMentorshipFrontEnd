package main;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.InputStream;
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

		String filePath = "Eckford.properties";
		Properties prop = new Properties();

		try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filePath)) {

			// Loading the properties.
			prop.load(inputStream);

			// Getting properties and connecting to the database
			connection = new DatabaseConnectionService(prop.getProperty("serverName"),
					prop.getProperty("databaseName"));
			if (!connection.connect(prop.getProperty("serverUsername"), prop.getProperty("serverPassword"))) {
				System.out.println("Failure on connecting to the database");
			}
		} catch (IOException ex) {
			System.out.println("Problem occurs when reading file !");
			ex.printStackTrace();
		}

		return connection;
	}
}
