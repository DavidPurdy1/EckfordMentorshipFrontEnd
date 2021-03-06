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
			cs = this.dbService.getConnection().prepareCall("{? = call insert_mentee(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, p.Email);
			cs.setString(3, p.Fname);
			cs.setString(4, p.Lname);
			cs.setString(5, p.PhoneNumber);
			cs.setString(6, p.LGBT);
			cs.setString(7, p.Race);
			cs.setString(8, p.Nationality);
			cs.setString(9, p.Sex);
			cs.setString(10, p.Ethnicity);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			int result = cs.getInt(1);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Already added a mentee entry into the database with this email");
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean addMentor(Person p) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection()
					.prepareCall("{? = call insert_mentor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, p.Seniority);
			cs.setString(3, p.Position);
			cs.setString(4, p.Field);
			cs.setString(5, p.PhoneNumber);
			cs.setString(6, p.LGBT);
			cs.setString(7, p.Fname);
			cs.setString(8, p.Lname);
			cs.setString(9, p.Email);
			cs.setString(10, p.Race);
			cs.setString(11, p.Nationality);
			cs.setString(12, p.Sex);
			cs.setString(13, p.Ethnicity);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			
			int result = cs.getInt(1);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Already added a mentor entry into the database with this email");
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
