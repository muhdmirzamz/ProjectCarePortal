/*
 * Customer.java
 * Customer class
 * 
 * Author: Muhd Mirza
 * Admin No: 141811Q
 */

package GSECarePortal.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import GSECarePortal.controller.*;

public class Customer {
	
	private String firstName;
	private String lastName;
	
	private String username;
	private String password;
	
	private String address;
	
	private String reason;
	private String status;
	
	public Customer() {	
	}
	
	// for retrieving details
	public Customer(String firstName, String lastName, String username, String password,
	        String address, String reason, String status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.reason = reason;
		this.status = status;
	}
	
	public Customer(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/*
	// coming from controller
	public Customer(String firstName, String lastName, String username, String password,
			        String address, String expiryDate, String reason, String status) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.address = address;
		this.expiryDate = expiryDate;
		this.reason = reason;
		this.status = status;
	}
	*/
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static boolean createCustomer(String firstName, String lastName, String username, String password,
	        String address, String reason, String status) {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;
		ResultSet rs = null;
		
		// do all of the operations below in a single connection
		// check for duplicate username-------------------------------------------
		int size = 0;
		
		db.getConnection();

		dbQuery = "SELECT COUNT(*) FROM Application.Customer WHERE username = ?";
		pstmt = db.getPreparedStatement(dbQuery);
		
		try {
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				size = rs.getInt(1);
			}
			
			System.out.println("Size= " + size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (size > 0) { // if there are at least one, there are duplicates
			db.terminate(); // don't forget to close
			
			success = false;
			
			return success;
		}
		
		// get total number of records and create record-------------------------------------------
		int noOfEntry = 0;
	
		dbQuery = "SELECT COUNT(*) FROM Application.Customer";
		pstmt = db.getPreparedStatement(dbQuery);

		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				noOfEntry = rs.getInt(1);
			}
			
			System.out.println("No of entry: " + noOfEntry);
		} catch (Exception e) {
			e.printStackTrace();
		}

		dbQuery = "INSERT INTO Customer(fName, lName, username, password, address, "
				+ "reason, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
		pstmt = db.getPreparedStatement(dbQuery);

		try {
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, username);
			pstmt.setString(4, password);
			pstmt.setString(5, address);
			pstmt.setString(6, reason);
			pstmt.setString(7, status);
			
			if (pstmt.executeUpdate() == 1)
				success = true;

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		db.terminate();

		return success;
	}
	
	/**
	 * Purpose:	This method converts a ResultSet object into a
	 * 			Customer object
	 * Input:	ResultSet object
	 * Return:	Customer object
	 */
	// needed to convert from database data to customer data
	private static Customer convertToCustomer(ResultSet rs) throws SQLException {
		Customer customer;
		
		String firstName = rs.getString("fName");
		String lastName = rs.getString("lName");
		String username = rs.getString("username");
		String password = rs.getString("password");
		String address = rs.getString("address");		
		String reason = rs.getString("reason");
		String status = rs.getString("status");
		
		customer = new Customer(firstName, lastName, username, password, address, 
				 reason, status);

		return customer;
	}
	
	public Customer getCustomerDetails(String username) {
		
		Customer customer = null;
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;
		
		// step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM Customer WHERE username = ?";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - execute query
		try {
			pstmt.setString(1, username);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { // first record found
				customer = convertToCustomer(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return customer;
	}
	
	// update status and set inactive
	public boolean setStatusInactive(String reason) {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		PreparedStatement pstmt;

		// establish connection to database
		db.getConnection();		

		// update status ------------------------------------------------
		dbQuery = "UPDATE Customer SET status = ?, reason = ? WHERE username = ?";
		pstmt = db.getPreparedStatement(dbQuery);
		
		try {
			pstmt.setString(1, "Inactive");
			pstmt.setString(2, reason);
			pstmt.setString(3, username);
			
			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//step 4 - close connection
		db.terminate();

		return success;
	}
	
	public boolean updateDetails(Customer c, String username) {
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;	
		PreparedStatement pstmt;
		
		//step 1 - establish connection to database
		db.getConnection();		

		//step 2 - declare the SQL statement
		dbQuery = "UPDATE Customer SET fName = ?, lName = ?, username = ?, password = ?, address = ? WHERE username = ?";
		pstmt = db.getPreparedStatement(dbQuery);
		
		//step 3 - to update record using executeUpdate method
		try {
			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, this.username);
			pstmt.setString(4, password);
			pstmt.setString(5, address);
			pstmt.setString(6, username); // use this to search for old account
			
			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(success);
		
	    //step 4 - close connection
		db.terminate();
		
		return success;
	}
}
