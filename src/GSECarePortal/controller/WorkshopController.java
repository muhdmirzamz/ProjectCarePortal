package GSECarePortal.controller;

import java.util.ArrayList;

import GSECarePortal.entity.Workshop;
import GSECarePortal.entity.WorkshopRegistration;

import java.util.Date;
import java.awt.Event;
import java.text.SimpleDateFormat;


public class WorkshopController {
   /*private Workshop workshop;
   private WorkshopRegistration workshopReg;
   private Attendance attendance;
   private Feedback feedback;
   private Question question;
   */
 
	
	Date today = new Date();
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyy");
	String date = DATE_FORMAT.format(today);
	
    public boolean processCreateWorkshop(String wsTitle, String desc, String date, String venue ){
	   
	   return true;
   }
   
 
   //Provide Feedback + Application Workshop //current date from the system
   public ArrayList<Workshop> retrieveWorkshopListForProcessing(){
	   
	   return new ArrayList<Workshop>();
   }
	
   
   //Sign-up Workshop
   
   public static ArrayList <Workshop> getWorkshopDetails(){  //retrive ws on current date from system
	   
	   return Workshop.getWorkshopDetails();
	  
   }
   
   public boolean displayWorkshopAvailable(){
	   
	   return true;
   }
   
   //Sign-Up Workshop + Application Workshop
   public boolean processRegistration(String elderlyName, String elderlyNRIC, String wsTitle, String wsID){
	   
	   return true;
   }

   // retrieving
   public static Workshop retrieveRegistration(String title){
	   return Workshop.getWorkshopDetails(title);
	   
   }
 
  //Publish Workshop
   public boolean createWorkshop(String wsTitle, String wsDescription, String wsDate, String wsVenue, String sTime, String eTime, String closingRegDate, int maxCap)
  {
	  boolean success = false;
	
	  if(!success){
		  Workshop create = new Workshop (wsTitle, wsDescription, wsDate, wsVenue, sTime, eTime, closingRegDate, maxCap);
	         success = create.createWorkshop(wsTitle, wsDescription, wsDate, wsVenue, sTime, eTime, closingRegDate, maxCap);
	  }
	  else {
		  success = false;
	  }
	  return success;
   }
   
   public boolean createWorkshopRegistrationRecord(String nric,  String fName, String emailAdd, String MNo, String HNo)
  {
	 
	  return WorkshopRegistration.createWorkshopRegistrationRecord(nric,  fName, emailAdd, MNo, HNo);
   }
   
   

}

   
