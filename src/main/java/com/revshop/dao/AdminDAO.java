package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revshop.entity.User;
import com.revshop.utility.DatabaseConnection;
import com.revshop.entity.Complaint;
//import com.revshop.entity.Retailer;

public class AdminDAO implements AdminDAOInterface{

	@Override
	public List<User> ViewAllUsersDAO() {
	    List<User> b1 = new ArrayList<>();
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from users");
	        ResultSet i = ps.executeQuery();
	        while (i.next()) {
	            User b = new User();
	            b.setUserId(i.getInt("id"));
	            b.setAddress(i.getString("address"));
	            b.setFullName(i.getString("name"));
	            b.setPassword(i.getString("password"));
	            b.setEmail(i.getString("email"));
	            b.setPincode(i.getString("pincode"));
	            b.setCreatedTime(i.getString("created_at"));
	            b.setUpdatedTime(i.getString("updated_at"));
	            b.setIsblocked(i.getBoolean("isblocked"));
	            b.setRole(i.getString("usertype"));
	            b1.add(b);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return b1;
	}

	@Override
	public List<User> manageUsersDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Complaint> viewComplaintsDAO() {
		List<Complaint> b1 = new ArrayList<>();
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from complaint");
	        ResultSet i = ps.executeQuery();
	        while (i.next()) {
	            Complaint c = new Complaint( );
	            c.setId(i.getInt("c_id"));
	            c.setMessage(i.getString("message"));
	            c.setUserId(i.getInt("userId"));
	            b1.add(c);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return b1;
		
	}

	@Override
	public int getUserCount() {
		int userCount = 0;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("select count(*) from users");
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				userCount = i.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return userCount;
	}

	@Override
	public int getComplaintCount() {
		int complaintCount = 0;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("select count(*) from complaint");
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				complaintCount = i.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return complaintCount;
	}

	@Override
	public int getRequestCount() {
		int requestCount = 0;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("select count(*) from users where usertype = ? and isblocked = true");
		   ps.setString(1, "seller");
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				requestCount = i.getInt(1);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return requestCount;
	}

	@Override
	public boolean blockUser(int userId) {
		
		int i = 0;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("update users set isBlocked = true where id = ?");
		   ps.setInt(1,userId);
		    i =ps.executeUpdate();
		    if(i>0) return true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean unblockUser(int userId) {
	    try (Connection con = DatabaseConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement("update users set isBlocked = false where id = ?")) {
	        ps.setInt(1, userId);
	        return ps.executeUpdate() > 0;
	    }  catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getSellerRequest() {
		List<User> b1 = new ArrayList<>();
	    try {
	        Connection con = DatabaseConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement("select * from users where usertype =? and isblocked = true");
	        ps.setString(1,"seller");
	        ResultSet i = ps.executeQuery();
	        while (i.next()) {
	            User s = new User();
	            s.setUserId(i.getInt("id"));
	            s.setAddress(i.getString("address"));
	            s.setFullName(i.getString("name"));
	            s.setEmail(i.getString("email"));
	            s.setPincode(i.getString("pincode"));
	            s.setCreatedTime(i.getString("created_at"));
	            s.setUpdatedTime(i.getString("updated_at"));
	            s.setIsblocked(i.getBoolean("isblocked"));
	            s.setRole(i.getString("usertype"));
	            b1.add(s);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return b1;
		
	}


}
