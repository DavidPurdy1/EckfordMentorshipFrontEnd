package Eckford.services;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import Tables.Address;
import Tables.Company;
import Tables.Person;

public class MiscServices {

	private DatabaseConnectionService dbService;

	public MiscServices(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	public boolean addAddress(Address a) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_address(?, ?, ?, ?, ?, ?)}");
			cs.setString(2, a.Address);
			cs.setString(3, a.Zip);
			cs.setString(4, a.UnitNumber);
			cs.setString(5, a.State);
			cs.setString(6, a.City);
			cs.setString(7, dbService.getConnectedUserEmail());
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			// TODO: Add error handling
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addCompanyInfo(Company c) {
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call insert_address(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cs.setString(2, c.CompanyName);
			cs.setString(3, c.PhoneNumber);
			cs.setString(4, c.Email);
			cs.setString(5, c.address.Address);
			cs.setString(6, c.address.Zip);
			cs.setString(7, c.address.UnitNumber);
			cs.setString(8, c.address.State);
			cs.setString(9, c.address.City);
			cs.setString(10, dbService.getConnectedUserEmail());
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			// TODO: Add error handling
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String[] getCompanies() {
		String query = "{call get_all_companies}";
		ArrayList<String> companies = new ArrayList<String>();
		try {
			PreparedStatement ps = this.dbService.getConnection().prepareCall(query);
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();
			while (rs.next()) {
				companies.add(rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] s = new String[companies.size()]; 
		for (int i = 0; i < companies.size(); i++) {
			s[i] = companies.get(i); 
		}
		return s;
	}
	
	public ArrayList<String> getAddresses() {
		String query = "{call get_all_companies}";
		ArrayList<String> companies = new ArrayList<String>();
		try {
			PreparedStatement ps = this.dbService.getConnection().prepareCall(query);
			ResultSet rs = ps.executeQuery();
			this.dbService.getConnection().commit();
			while (rs.next()) {
				companies.add(rs.getString("Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return companies;
	}

	
}
