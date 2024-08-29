package com.revshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revshop.service.*;
import com.revshop.utility.RevShopServiceFactory;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private  AdminServiceInterface asi;
	
	 @Override
	    public void init() throws ServletException {
	        new RevShopServiceFactory();
		// Initialize services
		 asi = RevShopServiceFactory.createObjectforAdminService("admin");
	    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String taskType = request.getParameter("taskType");

		if (taskType.equals("dashboardData")) {
			
			int userCount = asi.getUserCount();
			int complaintCount = asi.getComplaintCount();
			int requestCount = asi.getRequestCount();
			
			AdminData data = new AdminData(userCount, complaintCount, requestCount);
			 String json = new Gson().toJson(data);
			 
		    // Set response type to JSON and write the JSON data
		    response.setContentType("application/json");
		    response.getWriter().write(json);
		}
	
	}
	 // Data class to hold the counts
    private class AdminData {
		int userCount;
        int complaintCount;
        int registrationRequestCount;

        public AdminData(int userCount, int complaintCount, int registrationRequestCount) {
            this.userCount = userCount;
            this.complaintCount = complaintCount;
            this.registrationRequestCount = registrationRequestCount;
        }
    }

}

