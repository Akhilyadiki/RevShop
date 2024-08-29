package com.revshop.dao;

import java.util.List;

import com.revshop.entity.User;
import com.revshop.entity.Complaint;
//import com.revshop.entity.Retailer;

public interface AdminDAOInterface {
	List<User> ViewAllUsersDAO();
//	List<Retailer> viewAllretailersDAO();
	List<User> manageUsersDAO();
//	List<Retailer> manageRetailersDAO();
	List<Complaint> viewComplaintsDAO();
	//List<Retailer> viewAllTheRegistrationRequestsSubmittedByTheSellersDAO();
	int getUserCount();
	int getComplaintCount();
	int getRequestCount();
	boolean blockUser(int userId);
	boolean unblockUser(int userId);
	List<User> getSellerRequest();
}
