package com.revshop.service;

import java.util.List;

import com.revshop.entity.User;
import com.revshop.entity.Complaint;
//import com.revshop.entity.Retailer;

public interface AdminServiceInterface {
	List<User> ViewAllUsers();
	
	List<User> manageUsers(User u);
	
	List<Complaint> viewComplaints();
	
	List<User> viewAllTheRegistrationRequestsSubmittedByTheSellers();

	int getUserCount();

	int getComplaintCount();

	int getRequestCount();
	
	boolean blockUser(int userId);
	boolean unblockUser(int userId);

	List<User> getRetailerRequests();

}
