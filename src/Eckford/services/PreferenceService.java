package Eckford.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tables.Match;
import Tables.Person;
import Tables.Preference;
import main.MenteeInterface;

public class PreferenceService {
	private DatabaseConnectionService dbService;
	public Integer preferenceID; 
	public PreferenceService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	public boolean addPreference(Preference p) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_Preference(?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, p.Sex);
			cs.setString(3, p.LGBT);
			cs.setString(4, p.Field);
			cs.setString(5, p.Position);
			cs.setInt(6, p.Seniority);
			cs.setString(7, p.City);
			cs.setString(8, p.State);
			cs.registerOutParameter(9, Types.INTEGER);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			preferenceID = cs.getInt(9);
			int result = cs.getInt(1);
			// TODO: Add error printing
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "Preference already Exists");
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Match> findMatches() {
		// TODO: Use find matches sproc fix this it doesn't work
		ArrayList<Match> matches = new ArrayList<Match>();
		String query = "{call find_mentee_matches(?)}";

		PreparedStatement ps;
		try {
			ps = this.dbService.getConnection().prepareCall(query);
			ps.setString(1, dbService.userEmail);
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();

			while (rs.next()) {
				Match m = new Match(); 
				m.Fname = rs.getString("Fname");
				m.Lname = rs.getString("Lname"); 
				System.out.println(m.Fname + " " + m.Lname);
				matches.add(m); 
			}
			return matches; 
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e, "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}	
		return null;
	}

}
