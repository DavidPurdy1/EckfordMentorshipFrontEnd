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

public class PersonService {

	private DatabaseConnectionService dbService;

	public PersonService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	//add handling for address
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

	// add pattern matching in the query and stored proc for getting and searching
	public ArrayList<Person> searchPerson(String name) {
		String query = "select * from [Person] where LName = ?";
		ArrayList<Person> people = new ArrayList<Person>();
		try {
			PreparedStatement ps = this.dbService.getConnection().prepareCall(query);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();
			while (rs.next()) {
				Person p = new Person();
				p.Fname = rs.getString("Fname");
				p.Lname = rs.getString("Lname");
				p.ID = rs.getString("ID");
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
		String query = "SELECT * from Person";
		try (Statement stmt = dbService.getConnection().createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Person p = new Person();
				p.Fname = rs.getString("Fname");
				p.Lname = rs.getString("Lname");
				p.ID = rs.getString("ID");
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
