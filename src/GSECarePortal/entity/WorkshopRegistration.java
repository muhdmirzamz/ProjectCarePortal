package GSECarePortal.entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import GSECarePortal.controller.DBController;
public class WorkshopRegistration {

	private String nric, fName, emailAdd, MNo, Hno;
	
	//createsWorkshopRegistrationRecord()
   public WorkshopRegistration(String nric,  String fName, String emailAdd, String MNo, String HNo) {
	   this.nric = nric;
	   this.fName = fName;
	   this.emailAdd = emailAdd;
	   this.MNo = MNo;
	   this.Hno = HNo;
   }
   
   public ArrayList<WorkshopRegistration> retrieveRegistration(){
	   
	// declare local variables
	ArrayList<WorkshopRegistration> list = new ArrayList<WorkshopRegistration>();
	ResultSet rs = null;
	DBController db = new DBController();
	String dbQuery;
	PreparedStatement pstmt;

	// step 1 - connect to database
	db.getConnection();

	// step 2 - declare the SQL statement
	dbQuery = "SELECT * FROM workshopregistration";
	pstmt = db.getPreparedStatement(dbQuery);

	// step 3 - execute query
	try {
		rs = pstmt.executeQuery();
		while (rs.next()) {
			WorkshopRegistration wr = convertToWorkshopRegistration(rs);
			list.add(wr);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	// step 4 - close connection
	db.terminate();

	return list;
   }
   
   public static boolean createWorkshopRegistrationRecord(String nric,  String fName, String emailAdd, String MNo, String HNo) {
	   boolean success = false;
	   
	   DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;
		ResultSet rs = null;
	   
		db.getConnection();
		
		dbQuery = "INSERT INTO workshopregistration(nric, fName, emailAdd, mNo, hNo) VALUES(?, ?, ?, ?, ?)";
		pstmt = db.getPreparedStatement(dbQuery);

		try {
			pstmt.setString(1, nric);
			pstmt.setString(2, fName);
			pstmt.setString(3, emailAdd);
			pstmt.setString(4, MNo);
			pstmt.setString(5, HNo);
			
			if (pstmt.executeUpdate() == 1)
				success = true;

			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		db.terminate();
	   
	   return success;
   }
   
   public String getNric() {
	return nric;
}

public void setNric(String nric) {
	this.nric = nric;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getEmailAdd() {
	return emailAdd;
}

public void setEmailAdd(String emailAdd) {
	this.emailAdd = emailAdd;
}

public String getMNo() {
	return MNo;
}

public void setMNo(String mNo) {
	MNo = mNo;
}

public String getHno() {
	return Hno;
}

public void setHno(String hno) {
	Hno = hno;
}

private static WorkshopRegistration convertToWorkshopRegistration(ResultSet rs) throws SQLException {
		WorkshopRegistration wr;
		String nric = rs.getString("nric");
		String fName = rs.getString("fName");
		String emailAdd = rs.getString("emailAdd");
		String MNo = rs.getString("MNo");
		String Hno = rs.getString("Hno");
		wr = new WorkshopRegistration(nric,fName, emailAdd, MNo, Hno);

		return wr;
	}
   

   public boolean updateRegistrationStatus(){
	   
	   return true;
   }
	
   
   public boolean checkWorkshopRegistration() {
	   
	   return true;
   }

   public boolean delWorkshopReg(){
	   
	   return true;
   }
}
