package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revshop.entity.User;
import com.revshop.utility.DatabaseConnection;

public class GlobalDAO implements GlobalDAOInterface {

	@Override
	public User signInDAO(User user) {
		User b=null;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1,user.getEmail() );
			ps.setString(2, user.getPassword());
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				b=new User();
				b.setFullName(i.getString("name"));
				b.setEmail(i.getString("email"));
				b.setUserId(i.getInt("id"));
				b.setRole(i.getString("usertype"));
				b.setIsblocked(i.getBoolean("isblocked"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean validateEmailDAO(User b) {
		boolean b1=false;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("select * from users where email=?");
			ps.setString(1,b.getEmail() );
			
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				b1=true;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b1;
	}

	@Override
	public User signupDAO(User user) {
	//	User b=null;
		try {
		   Connection con=	DatabaseConnection.getConnection();
		   PreparedStatement ps=con.prepareStatement("insert into users(name, email,password,address,pincode,usertype , isblocked) values(?,?,?,?,?,?,?)");
			ps.setString(1,user.getFullName() );
			ps.setString(2,user.getEmail() );
			ps.setString(3, user.getPassword());
			ps.setString(4,user.getAddress() );
			ps.setString(5,user.getPincode());
			ps.setString(6,user.getRole() );
			if(user.getRole().equals("seller"))
				ps.setBoolean(7, true);
			else ps.setBoolean(7, false);
			ResultSet i=ps.executeQuery();
			if(i.next()) {
				return user;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}