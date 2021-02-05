package Eckford.services;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.JOptionPane;

import Tables.Person;

public class MenteeAndMentorService {

	private DatabaseConnectionService dbService; 
	
	public MenteeAndMentorService(DatabaseConnectionService dbService) {
		this.dbService = dbService; 
	}
	
	public boolean addMentee(Person p) {
		
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_mentee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, p.Email);
			cs.setString(3, p.Fname);
			cs.setString(4, p.Lname);
			cs.setString(8, p.PhoneNumber);
			cs.setString(9, p.LGBT);
			cs.setString(10, p.Race);
			cs.setString(11, p.Nationality);
			cs.setString(12, p.Sex);
			cs.setString(13, p.Ethnicity);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int result = cs.getInt(1);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Person already Exists");
				return false;
			} else if (result == 2) {
				JOptionPane.showMessageDialog(null, "There is already an address with this id");
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addMentor() {
		return false;
	}
	
	
	
}
