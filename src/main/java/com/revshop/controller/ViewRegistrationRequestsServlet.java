package com.revshop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.entity.User;
import com.revshop.service.AdminServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-registration-requests")
public class ViewRegistrationRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface asi;

    @Override
    public void init() throws ServletException {
    	asi = RevShopServiceFactory.createObjectforAdminService("admin");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch registration requests from the database
    	List<User> registrationRequests = asi.getRetailerRequests();

        // Set registration requests as a request attribute
        request.setAttribute("registrationRequests", registrationRequests);

        // Forward to the JSP page
        request.getRequestDispatcher("view-registration-requests.jsp").forward(request, response);
    }
}
