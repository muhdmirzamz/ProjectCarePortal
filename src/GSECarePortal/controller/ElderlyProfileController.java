package GSECarePortal.controller;

import java.util.ArrayList;

import GSECarePortal.entity.Elderly;

public class ElderlyProfileController {
			
		private Elderly elderly;
		
		public ElderlyProfileController() {
			
		}
	
		
		public static boolean createElderly(String accPassword, String accStatus, String fname, String lname, String elderlyID, int phoneNum, String gender, String address) {
			boolean success = false;
			
			if (Elderly.createElderly(accPassword, accStatus, fname, lname, elderlyID, phoneNum, gender, address)) {
				success = true;
			}
			
			return success;
		}
		
		public Elderly retrieveElderlyDetails(String elderlyID, String accPassword) {
			elderly = new Elderly();
			
			return elderly.getElderlyDetails(elderlyID, accPassword);
		}
		
		// might need elderly el in arguments
		public boolean updateDetails(Elderly el, String elderlyID) {	
			elderly = new Elderly();
			
			return elderly.updateDetails(el, elderlyID);
		}
		
		public boolean processDelete(Elderly el) {
			return el.setStatusInactive();
		}


		

}
		
