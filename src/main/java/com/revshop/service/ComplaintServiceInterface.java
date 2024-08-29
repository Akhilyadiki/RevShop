package com.revshop.service;

import java.util.List;

import com.revshop.entity.Complaint;


public interface ComplaintServiceInterface {

	List<Complaint> getAllComplaints();

	void deleteComplaint(int complaintId);

}
