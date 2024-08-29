package com.revshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.entity.User;
import com.revshop.service.AdminService;
import com.revshop.service.AdminServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

public class ManageUsersServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface asi;
	
	public void init() {
		asi = RevShopServiceFactory.createObjectforAdminService("admin");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<User> users = asi.ViewAllUsers();

			request.setAttribute("users", users);

			request.getRequestDispatcher("manage-users.jsp").forward(request, response);
		} catch (Exception e) {
			// Handle exception
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching users");
		}
	}
}