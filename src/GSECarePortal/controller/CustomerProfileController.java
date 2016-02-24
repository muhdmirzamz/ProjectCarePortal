/*
 * CustomerProfileController.java
 * This is the controller for customer profile
 * 
 * Author: Muhd Mirza
 * Admin No: 141811Q
 */

package GSECarePortal.controller;

import java.util.ArrayList;

import GSECarePortal.entity.Customer;

public class CustomerProfileController {
	
	private Customer customer;
	
	public CustomerProfileController() {
		
	}
	
	/*
	public CustomerProfileController(String firstName, String lastName, String username, String password,
	        String address, String expiryDate, String reason, String status) {
		// createAccount()
		Customer.createCustomer(firstName, lastName, username, password, address, expiryDate, reason, status);
	}
	*/
	
	public static boolean createCustomer(String firstName, String lastName, String username, String password,
	        String address, String reason, String status) {
		boolean success = false;
		
		if (Customer.createCustomer(firstName, lastName, username, password, address, reason, status)) {
			success = true;
		}
		
		return success;
	}
	
	// might need Customer c in arguments
	public Customer retrieveCustomerDetails(String username) {
		customer = new Customer();
		
		return customer.getCustomerDetails(username);
	}
	
	// might need Customer c in arguments
	public boolean updateDetails(Customer c, String username) {
		return c.updateDetails(c, username);
	}
	
	public boolean processDelete(Customer c, String reason) {
		return c.setStatusInactive(reason);
	}
}
