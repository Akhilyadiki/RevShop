package com.revshop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.service.AdminServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

/**
 * Servlet implementation class AdminActionServlet
 */
public class AdminActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface	asi;
	public void init(ServletConfig config) throws ServletException {
		
		asi = RevShopServiceFactory.createObjectforAdminService("admin");
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		System.out.println(userId+" <- this is ID "+ request.getParameter("action"));
        String action = request.getParameter("action");

        boolean success;
        if ("block".equals(action)) {
            
            success = asi.blockUser(userId) ;
        } else if ("unblock".equals(action)) {
            
            success = asi.unblockUser(userId);
        } else {
            success = false;
        }

        // Return a JSON response
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"success\":" + success + "}");
        out.flush();
	}

}
