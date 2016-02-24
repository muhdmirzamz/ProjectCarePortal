package GSECarePortal.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import GSECarePortal.controller.DBController;

public class Elderly {
	

	private String accPassword;
	private String accStatus;
	private String fname;
	private String lname;
	private String elderlyID;
	private int phoneNum;
	private String gender;
	private String address;
		public Elderly() {	
		}
		
		// for retrieving details
		public Elderly(String accPassword, String accStatus, String fname, String lname, String elderlyID, int phoneNum, String gender, String address) {
			super();
			this.accPassword = accPassword;
			this.accStatus = accStatus;
			this.fname = fname;
			this.lname = lname;
			this.elderlyID = elderlyID;
			this.phoneNum = phoneNum;
			this.gender = gender;
			this.address = address;
		}
		
		public Elderly(String elderlyID, String accPassword) {
			this.elderlyID = elderlyID;
			this.accPassword = accPassword;
		}
		
		public String getAccPassword() {
			return accPassword;
		}

		public void setAccPassword(String accPassword) {
			this.accPassword = accPassword;
		}

		public String getAccStatus() {
			return accStatus;
		}

		public void setAccStatus(String accStatus) {
			this.accStatus = accStatus;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getLname() {
			return lname;
		}

		public void setLname(String lname) {
			this.lname = lname;
		}

		public String getElderlyID() {
			return elderlyID;
		}

		public void setElderlyID(String elderlyID) {
			this.elderlyID = elderlyID;
		}

		public int getPhoneNum() {
			return phoneNum;
		}

		public void setPhoneNum(int phoneNum) {
			this.phoneNum = phoneNum;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		/*
		// coming from controller
		public Elderly(String accPassword, String accStatus, String fname, String lname, 
		String elderlyID, int phoneNum, String gender, String address) {
			this.accPassword = accPassword;
			this.accStatus = accStatus;
			this.fname = fname;
			this.lname = lname;
			this.elderlyID = elderlyID;
			this.phoneNum = phoneNum;
			this.gender = gender;
			this.address = address;
		}
		*/
		
		
		
		public static boolean createElderly(String accPassword, String accStatus, String fname, String lname, 
				String elderlyID, int phoneNum, String gender, String address) {
			// declare local variables
			boolean success = false;
			DBController db = new DBController();
			String dbQuery;
			PreparedStatement pstmt;
			ResultSet rs = null;
			
			if (duplicateUsernameExist(elderlyID)) {
				success = false;
				
				return success;
			}
			
			int noOfEntry = retrieveElderlyList();
			int id = 0;

			// step 1 - establish connection to database
			db.getConnection();

			// step 2 - declare the SQL statement
			dbQuery = "INSERT INTO elderly(accPassword, accStatus, fname, lname, elderlyID, phoneNum, gender, address) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = db.getPreparedStatement(dbQuery);
			if (noOfEntry == 0) {
				id = 1;
			} else {
				id = noOfEntry + 1; 
			}
			
			// step 3 - to insert record using executeUpdate method
			try {
				pstmt.setInt(1, id);
				pstmt.setString(2, accPassword);
				pstmt.setString(3, accStatus);
				pstmt.setString(4, fname);
				pstmt.setString(5, lname);
				pstmt.setString(6, elderlyID);
				pstmt.setInt(7, phoneNum);
				pstmt.setString(8, gender);
				pstmt.setString(9, address);				
				
				if (pstmt.executeUpdate() == 1)
					success = true;

				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			// step 4 - close connection
			db.terminate();

			return success;
		}
		

		// needed to convert from database data to elderly data
		private static Elderly convertToElderly(ResultSet rs) throws SQLException {
			Elderly elderly;
			
			String accPassword = rs.getString("accPassword");
			String accStatus = rs.getString("accStatus");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String elderlyID = rs.getString("elderlyID");
			int phoneNum = rs.getInt("phoneNum");
			String gender = rs.getString("gender");
			String address = rs.getString("address");
		
			elderly = new Elderly(accPassword, accStatus, fname, lname, elderlyID, phoneNum, gender, address);

			return elderly;
		}
		
		public Elderly getElderlyDetails(String username){
			
			Elderly elderly = null;
			ResultSet rs = null;
			DBController db = new DBController();
			String dbQuery;
			PreparedStatement pstmt;
			
			//connect to database
			db.getConnection();
			
			//sql statement
			dbQuery = "SELECT * FROM elderly WHERE elderlyID = ?";
			pstmt = db.getPreparedStatement(dbQuery);
			
			//execute query
			try {
				pstmt.setString(5, elderlyID);
				
				rs = pstmt.executeQuery();
				if (rs.next()) { // first record found
					elderly = convertToElderly(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// step 4 - close connection
			db.terminate();

			return elderly;
			}
		
		
		public boolean updateDetails(Elderly el, String elderlyID) {
			boolean success = false;
			DBController db = new DBController();
			String dbQuery;	
			PreparedStatement pstmt;
			
			//step 1 - establish connection to database
			db.getConnection();		

			//step 2 - declare the SQL statement
			dbQuery = "UPDATE elderly SET fname = ?, lname = ?, accPassword = ?, address = ? WHERE elderlyID = ?";
			pstmt = db.getPreparedStatement(dbQuery);
			
			//step 3 - to update record using executeUpdate method
			try {
				pstmt.setString(1, el.getFname());
				pstmt.setString(2, el.getLname());
				pstmt.setString(3, el.getAccPassword());
				pstmt.setString(4, el.getAddress());
				pstmt.setString(5, elderlyID); // use this to search for old account
				
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
		// used to increment id in database
		// used in createElderly()
		public static int retrieveElderlyList() {
			// declare local variables
			ResultSet rs = null;
			DBController db = new DBController();
			String dbQuery;
			PreparedStatement pstmt;
			int noOfEntry = 0;
			
			// step 1 - connect to database
			db.getConnection();

			// step 2 - declare the SQL statement
			dbQuery = "SELECT COUNT(*) FROM Application.elderly";
			pstmt = db.getPreparedStatement(dbQuery);

			// step 3 - execute query
			try {
				rs = pstmt.executeQuery();
				while (rs.next()) {
					noOfEntry = rs.getInt(1);
				}
				
				System.out.println("No of entry: " + noOfEntry);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// step 4 - close connection
			db.terminate();

			return noOfEntry;
		}
		
		// used to check for duplicate usernames in database
		// used in createElderly()
		public static boolean duplicateUsernameExist(String elderlyID) {
			// declare local variables
			ResultSet rs = null;
			DBController db = new DBController();
			String dbQuery;
			PreparedStatement pstmt;
			int size = 0;
			
			// step 1 - connect to database
			db.getConnection();

			// step 2 - declare the SQL statement
			dbQuery = "SELECT COUNT(*) FROM Application.elderly WHERE elderlyID = ?";
			pstmt = db.getPreparedStatement(dbQuery);
			
			// step 3 - execute query
			try {
				pstmt.setString(1, elderlyID);
				
				rs = pstmt.executeQuery();
				while (rs.next()) {
					size = rs.getInt(1);
				}
				
				System.out.println("Size= " + size);
			} catch (Exception e) {
				e.printStackTrace();
			}

			// step 4 - close connection
			db.terminate();
			
			if (size > 0) { // if there are at least one, there are duplicates
				return true;
			} 
			
			return false;
		}
		
		public Elderly getElderlyDetails(String elderlyID, String accPassword) {
			
			Elderly elderly = null;
			ResultSet rs = null;
			DBController db = new DBController();
			String dbQuery;
			PreparedStatement pstmt;
			
			// step 1 - connect to database
			db.getConnection();

			// step 2 - declare the SQL statement
			dbQuery = "SELECT * FROM elderly WHERE elderlyID = ? AND accPassword = ?";
			pstmt = db.getPreparedStatement(dbQuery);

			// step 3 - execute query
			try {
				pstmt.setString(1, elderlyID);
				pstmt.setString(2, accPassword);
				rs = pstmt.executeQuery();
				if (rs.next()) { // first record found
					elderly = convertToElderly(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			// step 4 - close connection
			db.terminate();

			return elderly;
		}

		public boolean setStatusInactive() {
			boolean success = false;
			DBController db = new DBController();
			String dbQuery;	
			PreparedStatement pstmt;

			// establish connection to database
			db.getConnection();		

			// update status ------------------------------------------------
			dbQuery = "UPDATE elderly SET status = ? WHERE elderlyID = ?";
			pstmt = db.getPreparedStatement(dbQuery);
			
			try {
				pstmt.setString(1, "Inactive");
				pstmt.setString(2, elderlyID);
				
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
	}		
	

