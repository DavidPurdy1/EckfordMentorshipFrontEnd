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

public class PreferenceService {
	private DatabaseConnectionService dbService;

	public PreferenceService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	public boolean addPreference(Preference p) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_Preference(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, p.Sex);
			cs.setString(3, p.LGBT);
			cs.setString(4, p.Field);
			cs.setString(5, p.Position);
			cs.setString(6, p.Seniority);
			cs.setString(7, p.City);
			cs.setString(8, p.State);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
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

	public ArrayList<Match> match(String email) {
		// TODO: Use find matches sproc
		// System.out.println("Not implemented");
		ArrayList<Match> matches = new ArrayList<Match>();
		String query = "{call find_mentee_matches(?)}";

		PreparedStatement ps;
		try {
			ps = this.dbService.getConnection().prepareCall(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();

			while (rs.next()) {
				Match m = new Match(); 
				m.Fname = rs.getString("Fname");
				m.Lname = rs.getString("Lname"); 
				System.out.println(m.Fname + " " + m.Lname);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		CallableStatement cs = null;
//		try {
//			cs = this.dbService.getConnection().prepareCall("{? = call find_mentee_matches(?)}");
//			cs.setString(2, email);
//			cs.registerOutParameter(1, Types.INTEGER);
//			cs.execute();
//			int result = cs.getInt(1);
//			// TODO: Add error printing
//			if (result == 1) {
//				JOptionPane.showMessageDialog(null, "Preference already Exists");
//				return false;
//			}
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//		
//		return false;	
		return null;
	}

}