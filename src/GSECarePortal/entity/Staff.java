package GSECarePortal.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import GSECarePortal.controller.DBController;

public class Staff {
	private String username;
	private String password;
	
	public Staff() {
		
	}
	
	public Staff(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	// needed to convert from database data to customer data
	private static Staff convertToStaff(ResultSet rs) throws SQLException {
		Staff staff;
		
		String username = rs.getString("username");
		String password = rs.getString("password");
		
		staff = new Staff(username, password);

		return staff;
	}
	
	public Staff getStaffDetails(String username, String password) {
		
		Staff staff = null;
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;
		
		// step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM Staff WHERE username = ? AND password = ?";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - execute query
		try {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { // first record found
				staff = convertToStaff(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return staff;
	}
}
