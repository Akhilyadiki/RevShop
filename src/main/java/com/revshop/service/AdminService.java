package com.revshop.service;

import java.util.List;
import com.revshop.dao.*;
import com.revshop.entity.Complaint;
import com.revshop.entity.User;
import com.revshop.utility.RevShopDAOFactory;
//import com.revshop.entity.Retailer;

public class AdminService implements AdminServiceInterface{
	
	private AdminDAOInterface adi;
	@Override
	public List<User> ViewAllUsers() {
		
		new RevShopDAOFactory();
		adi = RevShopDAOFactory.createObjectAdmin("admin");
		List<User> users = adi.ViewAllUsersDAO();
		return users;
	}



	@Override
	public List<User> manageUsers(User u) {
		new RevShopDAOFactory();
		adi = RevShopDAOFactory.createObjectAdmin("admin");
		return null;
	}


	@Override
	public List<Complaint> viewComplaints() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<User> viewAllTheRegistrationRequestsSubmittedByTheSellers() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int getUserCount() {
		adi = new AdminDAO();
		return adi.getUserCount();
	}



	@Override
	public int getComplaintCount() {
		adi = new AdminDAO();
		return adi.getComplaintCount();
	}



	@Override
	public int getRequestCount() {
		adi = new AdminDAO();
		return adi.getRequestCount();
	}
	


	@Override
	public boolean blockUser(int userId) {
		
		adi = new AdminDAO();
		return  adi.blockUser(userId);
	
		
	}



	@Override
	public boolean unblockUser(int userId) {
		
		adi = new AdminDAO();
		return  adi.unblockUser(userId);
		
	}



	@Override
	public List<User> getRetailerRequests() {
		new RevShopDAOFactory();
		adi = RevShopDAOFactory.createObjectAdmin("admin");
		List<User> users = adi.getSellerRequest();
		return users;
	}

	
	
}
