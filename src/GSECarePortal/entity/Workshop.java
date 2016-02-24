package GSECarePortal.entity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.*;
import javax.swing.*;

import GSECarePortal.controller.DBController;
import GSECarePortal.ui.SignUpWorkshopPanel;

public class Workshop {
//ATTRIBUTES
	
	private int wsId;
	private String wsTitle;	
	private String wsDescription;
	private String wsDate;
	private String wsVenue;
	private String sTime;
	private String eTime;
	private String closingRegDate;
	private int maxCap;
	
//CONSTRUCTOR
	public Workshop() {

	}

	public Workshop(String wsTitle, String wsDescription, String wsDate, String wsVenue, String sTime, String eTime, String closingRegDate, int maxCap) {
		super();
		this.wsTitle = wsTitle;
		this.wsDescription = wsDescription;
		this.wsDate = wsDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.closingRegDate = closingRegDate;
		this.maxCap = maxCap;
	}
	
	public Workshop(int wsId,String wsTitle, String wsDescription, String wsVenue, String wsDate, String sTime, String eTime, String closingRegDate, int maxCap) {
		super();
		this.wsTitle = wsTitle;
		this.wsDescription = wsDescription;
		this.wsDate = wsDate;
		this.sTime = sTime;
		this.eTime = eTime;
		this.closingRegDate = closingRegDate;
		this.maxCap = maxCap;
	}

   
	
	
   private static Workshop convertToWorkshop(ResultSet rs) throws SQLException {
		Workshop w;
		int wsId = rs.getInt("wsId"); 
		String wsTitle = rs.getString("wsTitle");
		String wsDescription = rs.getString("wsDescription");
		String wsDate = rs.getString("wsDate");
		String wsVenue = rs.getString("wsVenue");
		String sTime = rs.getString("sTime");
		String eTime = rs.getString("eTime");
		String closingRegDate = rs.getString("closingRegDate");
		int maxCap = rs.getInt("maxCap");
		
		w = new Workshop(wsId, wsTitle, wsDescription, wsDate, wsVenue, sTime, eTime, closingRegDate, maxCap);
		return w;
	}

	//get workshop list()
	public ArrayList<Workshop> setWorkshopList() {
    	
		// declare local variables
		ArrayList<Workshop> list = new ArrayList<Workshop>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM workshop";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - execute query
		try {
			pstmt.setInt(1, wsId);
			pstmt.setString(2, wsTitle);
			pstmt.setString(3, wsDescription);
			pstmt.setString(4, wsDate);
			pstmt.setString(5, wsVenue);
			pstmt.setString(6, sTime);
			pstmt.setString(7, eTime);
			pstmt.setString(8, closingRegDate);
			pstmt.setInt(9, maxCap);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Workshop wr = convertToWorkshop(rs);
				list.add(wr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return list;
    }
	
	
    
	public int getWsId() {
		return wsId;
	}

	public void setWsId(int wsId) {
		this.wsId = wsId;
	}

	public String getWsTitle() {
		return wsTitle;
	}

	public void setWsTitle(String wsTitle) {
		this.wsTitle = wsTitle;
	}

	public String getWsDescription() {
		return wsDescription;
	}

	public void setWsDescription(String wsDescription) {
		this.wsDescription = wsDescription;
	}

	public String getWsDate() {
		return wsDate;
	}

	public void setWsDate(String wsDate) {
		this.wsDate = wsDate;
	}

	public String getWsVenue() {
		return wsVenue;
	}

	public void setWsVenue(String wsVenue) {
		this.wsVenue = wsVenue;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String geteTime() {
		return eTime;
	}

	public void seteTime(String eTime) {
		this.eTime = eTime;
	}

	public String getClosingRegDate() {
		return closingRegDate;
	}

	public void setClosingRegDate(String closingRegDate) {
		this.closingRegDate = closingRegDate;
	}

	public int getMaxCap() {
		return maxCap;
	}

	public void setMaxCap(int maxCap) {
		this.maxCap = maxCap;
	}

       
    //used to increment id in database;
    //used in createWorkshop()
    public static int retrieveWorkshopList(){
    	//declare local variables
    	ResultSet rs = null;
    	DBController db = new DBController();
    	String dbQuery;
    	PreparedStatement pstmt;
    	int noOfEntry = 0;
    	
    	//step 1 - connect to database
    	db.getConnection();
    	
    	//step 2 - declare the SQL statement
    	dbQuery = "SELECT COUNT(*) FROM workshop";
    	pstmt = db.getPreparedStatement(dbQuery);

    	//step 3 - execute query
        try {
        	rs = pstmt.executeQuery();            

        	while (rs.next()) {
        		noOfEntry = rs.getInt(1);
        	}
        	
        	System.out.println("No of entry: " + noOfEntry);
        }   catch (Exception e) {
        	e.printStackTrace();
        }
    	
        //step 4 - close connection
        db.terminate();
        
        return noOfEntry;
    }
    
    
    public boolean createWorkshop(String wsTitle, String wsDescription, String wsDate, String wsVenue, String sTime, String eTime, String closingRegDate, int maxCap)
    {   
    	boolean success = false;
    	DBController db = new DBController();
    	String dbQuery;
    	PreparedStatement pstmt;
     	//establish connection to database
    	db.getConnection();
    	
    	int noOfEntry = retrieveWorkshopList();
    	
    	int id = 0;
    	
    	//declare SQL statement
    	dbQuery = "INSERT INTO workshop (wsId, wsTitle, wsDescription, wsDate, wsVenue, sTime, eTime, closingRegDate, maxCap) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    	pstmt = db.getPreparedStatement(dbQuery);
    	 if (noOfEntry == 0)  { 
    	       id = 1;
        }  else{
        	  id = noOfEntry +1;
        }
        
    		try{
    			pstmt.setInt(1, id);
    			pstmt.setString(2, wsTitle);
    			pstmt.setString(3, wsDescription);
    			pstmt.setString(4, wsDate);
    			pstmt.setString(5, wsVenue);
    			pstmt.setString(6, sTime);
    			pstmt.setString(7, eTime);
    			pstmt.setString(8, closingRegDate);
    			pstmt.setInt(9, maxCap);
    			
    			if (pstmt.executeUpdate() == 1)
    				success = true;
    			pstmt.close();			
    		} catch (Exception e)
    		{
    		  e.printStackTrace();
    		} 
    		  
    	 //step 4 - close connection
    		db.terminate();
    		return success;
    		
    	
    }
    
    
    public static ArrayList<Workshop> getWorkshopDetails(){
    	//declare local variables
    	ArrayList<Workshop> list = new ArrayList<Workshop>();
    	ResultSet rs = null;
    	DBController db = new DBController();
    	String dbQuery;
    	
    	//Connect to database
    	db.getConnection();
    	
    	//Declare SQL statement
    	dbQuery= "SELECT * FROM workshop";

		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		
		try {
			while (rs.next()) {
				Workshop w = convertToWorkshop(rs);
				list.add(w);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    	//close connection
    	db.terminate();
    	
    	return list;
  
    }
    
    public static Workshop getWorkshopDetails(String title){
    	//declare local variables
    	ResultSet rs = null;
    	DBController db = new DBController();
    	String dbQuery;
    	PreparedStatement pstmt;
    	Workshop w = null;
    	
    	//Connect to database
    	db.getConnection();
    	
    	//Declare SQL statement
    	dbQuery= "SELECT * FROM workshop WHERE wsTitle = ?";
    	pstmt = db.getPreparedStatement(dbQuery);

		
		try{
			pstmt.setString(1, title);
			rs = pstmt.executeQuery();            
			
        	if (rs.next()) {
        		w = convertToWorkshop(rs);
        	}
			pstmt.setString(1, title);

			pstmt.close();			
		} catch (Exception e)
		{
		  e.printStackTrace();
		} 
		
    	//close connection
    	db.terminate();
    	
    	return w;
  
    }
}