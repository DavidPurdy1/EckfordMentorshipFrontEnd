package Eckford.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionService {

	private final String SampleURL = "jdbc:sqlserver://${dbServer};databaseName=${dbName};user=${user};password= {${pass}}";

	private Connection connection = null;
	// ONCE CONNECTED WE WANT TO KNOW THE USER EMAIL AND TRACK IT AS WELL AS THEIR
	// ROLE
	private String role;
	private String userEmail;
	private String databaseName;
	private String serverName;

	public DatabaseConnectionService(String serverName, String databaseName) {
		this.serverName = serverName;
		this.databaseName = databaseName;
	}

	public boolean connect(String user, String pass) {
		String fullUrl = SampleURL.replace("${dbServer}", serverName).replace("${dbName}", databaseName)
				.replace("${user}", user).replace("${pass}", pass);
		try {
			connection = DriverManager.getConnection(fullUrl);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Connection getConnection() {
		return this.connection;
	}

	public String getConnectedUserEmail() {
		return userEmail;
	}

	public String getConnectedUserRole() {
		return role;
	}

	public void setConnectedUserEmailRole(String userEmail, String role) {
		this.userEmail = userEmail;
		this.role = role;
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
