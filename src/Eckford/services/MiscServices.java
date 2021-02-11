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
		System.out.println("Not IMplemented");

		// CallableStatement cs = null;
//		try {
//			cs = this.dbService.getConnection()
//					.prepareCall("{? = call insert_mentor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
//			cs.setString(2, a.Address);
//			
//			
//			cs.registerOutParameter(1, Types.INTEGER);
//			cs.execute();
//			return true;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return false;
	}
}
