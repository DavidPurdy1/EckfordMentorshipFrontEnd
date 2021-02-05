package Eckford.services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;


public class UserService {
	private static final Random RANDOM = new SecureRandom();
	private static final Base64.Encoder enc = Base64.getEncoder();
	private static final Base64.Decoder dec = Base64.getDecoder();
	private DatabaseConnectionService dbService = null;

	public UserService(DatabaseConnectionService dbService) {
		this.dbService = dbService;
	}

	public boolean useApplicationLogins() {
		return true;
	}

	public boolean login(String username, String password) {
		String query = "Select PasswordSalt, PasswordHash, [Role] from [User] where Email = ?";
		try {
			// returns the salt and hash from the user table
			PreparedStatement stmt = this.dbService.getConnection().prepareCall(query);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			this.dbService.getConnection().commit();
			// checks if hashing the password entered using the salt retrieved equals the
			// hash retrieved
			if (rs.next()) {
				if (hashPassword(rs.getBytes("PasswordSalt"), password).equals(rs.getString("PasswordHash"))) {
					return true;
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Login Failed");
			e.printStackTrace();
			return false;
		}

		return false;
	}

	public boolean register(String username, String password, String role) {
		byte[] salt = getNewSalt();
		String hash = hashPassword(salt, password);
		CallableStatement cs = null;
		try {
			cs = this.dbService.getConnection().prepareCall("{? = call Register(?, ?, ?, ?)}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setString(2, username);
			cs.setBytes(3, salt);
			cs.setString(4, hash);
			cs.setString(5, role);
			cs.execute();
			//TODO: Add something for more error messages 	
			if (cs.getInt(1) != 0) {
				JOptionPane.showMessageDialog(null, "Registration Failed");
				return false;
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public byte[] getNewSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return salt;
	}

	public String getStringFromBytes(byte[] data) {
		return enc.encodeToString(data);
	}

	public String hashPassword(byte[] salt, String password) {

		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
		SecretKeyFactory f;
		byte[] hash = null;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			hash = f.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException e) {
			JOptionPane.showMessageDialog(null, "An error occurred during password hashing. See stack trace.");
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			JOptionPane.showMessageDialog(null, "An error occurred during password hashing. See stack trace.");
			e.printStackTrace();
		}
		return getStringFromBytes(hash);
	}

}
