package Eckford.services;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import Tables.Address;
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
			//TODO: Add error handling
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
}
