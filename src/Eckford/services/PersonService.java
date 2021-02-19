package Eckford.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Tables.Address;
import Tables.Person;
import Tables.Preference;

public class PersonService {

	private DatabaseConnectionService dbService;

	public PersonService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	public boolean addPerson(Person p) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_person(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, p.PhoneNumber);
			cs.setString(3, p.LGBT);
			cs.setString(4, p.Fname);
			cs.setString(5, p.Lname);
			cs.setString(6, p.Email);
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
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	//TODO FEELS UNSAFE RIGHT NOW IF THE PERSON IS NOT IN THE TABLE WILL RETURN 1 NEED A CHECK FOR THAT 
	public ArrayList<Person> searchPerson(String email) {
		String query = "{call get_person(?)}";
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
	
	public ArrayList<Address> findAddress(String email) {
		String query = "{call get_address(?)}";
		ArrayList<Address> address = new ArrayList<Address>();
		try {
			PreparedStatement ps = this.dbService.getConnection().prepareCall(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();
			
			
			while (rs.next()) {
				Address a = new Address();
				a.State = rs.getString("State");
				a.City = rs.getString("City");
				a.Address = rs.getString("StreetAddress");
				a.UnitNumber = rs.getString("UnitNumber");
				a.Zip = rs.getString("Zip");
				address.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return address;
	}
	
	public ArrayList<Preference> getPreference(String email) {
		String query = "{call get_preference(?)}";
		ArrayList<Preference> preferences = new ArrayList<Preference>();
		try {
			PreparedStatement ps = this.dbService.getConnection().prepareCall(query);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();
			
			
			while (rs.next()) {
				Preference p = new Preference();
				p.State = rs.getString("State");
				p.City = rs.getString("City");
				p.Field = rs.getString("Field");
				p.Seniority = rs.getString("Seniority");
				p.Sex = rs.getString("Sex");
				p.LGBT = rs.getString("LGBT");
				preferences.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preferences;
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
