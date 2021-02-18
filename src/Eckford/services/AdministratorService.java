package Eckford.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tables.Person;


public class AdministratorService {

	private DatabaseConnectionService dbService; 
	
	public AdministratorService(DatabaseConnectionService dbService) {
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
	
	public boolean addMentor(Person p, Integer sen, String pos, String field) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_mentor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setInt(2, sen);
			cs.setString(3, pos);
			cs.setString(4, field);
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
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Person> searchPerson(String email) {
		String query = "call get_person(?)";
		ArrayList<Person> people = new ArrayList<Person>();
		try {
			PreparedStatement ps = this.dbService.getConnection().prepareCall(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();
			while (rs.next()) {
				Person p = new Person();
				p.Fname = rs.getString("Fname");
				p.Lname = rs.getString("Lname");
				p.PhoneNumber = rs.getString("PhoneNumber");
				p.Email = rs.getString("Email");
				p.Nationality = rs.getString("Nationality");
				p.AddressID = rs.getString("AddressID");
				p.Race = rs.getString("Race");
				p.Ethnicity = rs.getString("Ethnicity");
				p.Sex = rs.getString("Sex");
				p.LGBT = rs.getString("LGBT");
				people.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}

	public ArrayList<Person> getAllPerson() {
		ArrayList<Person> people = new ArrayList<Person>();
		String query = "call all_person";
		try (Statement stmt = dbService.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Person p = new Person();
				p.Fname = rs.getString("Fname");
				p.Lname = rs.getString("Lname");
				p.PhoneNumber = rs.getString("PhoneNumber");
				p.Email = rs.getString("Email");
				p.Nationality = rs.getString("Nationality");
				p.AddressID = rs.getString("AddressID");
				p.Race = rs.getString("Race");
				p.Ethnicity = rs.getString("Ethnicity");
				p.Sex = rs.getString("Sex");
				p.LGBT = rs.getString("LGBT");
				people.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return people;
	}
	
	
}