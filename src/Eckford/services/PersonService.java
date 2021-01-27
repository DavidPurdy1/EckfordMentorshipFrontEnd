package Eckford.services;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class PersonService {

	private DatabaseConnectionService dbService;

	public PersonService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}
	
//	public boolean addPerson(String restName, String addr, String contact) {
//		CallableStatement cs = null;
//		try {
//			cs = this.dbService.getConnection().prepareCall("{? = call AddRestaurant(?, ?, ?)}");
//			cs.setString(2, restName);
//			cs.setString(3, addr);
//			cs.setString(4, contact);
//			cs.registerOutParameter(1, Types.INTEGER);
//			cs.execute(); 
//			int result = cs.getInt(1); 
//			if(result == 1) {
//				JOptionPane.showMessageDialog(null, "Restaurant Name is null or empty");
//				return false;
//			}else if(result == 2) {
//				JOptionPane.showMessageDialog(null, "Cannot add a Restaurant with a name that already exists");
//				return false;
//			}
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	
	public ArrayList<String> getAllPerson() {
		ArrayList<String> people = new ArrayList<String>();
		String query = "SELECT FName from Person";
		try (Statement stmt = dbService.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				people.add(rs.getString("FName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}
}
