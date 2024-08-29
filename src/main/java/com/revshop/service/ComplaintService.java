package com.revshop.service;

import java.util.ArrayList;
import java.util.List;

import com.revshop.dao.AdminDAOInterface;
import com.revshop.entity.Complaint;
import com.revshop.utility.RevShopDAOFactory;

public class ComplaintService implements ComplaintServiceInterface{

	 public List<Complaint> getAllComplaints() {
	        // Replace this with actual database retrieval logic
	        AdminDAOInterface adi = RevShopDAOFactory.createObjectAdmin("admin");
	        
	        List<Complaint> complaints = adi.viewComplaintsDAO();
	        return complaints;
	    }

	    // Method to delete a complaint by ID
	    public void deleteComplaint(int complaintId) {
	        // Add logic to delete the complaint from the database
	    }
}
