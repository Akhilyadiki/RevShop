package com.revshop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revshop.entity.User;
import com.revshop.service.GlobalServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

/**
 * Servlet implementation class GlobalServlet
 */
public class GlobalServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String taskType = request.getParameter("taskType");

		if (taskType.equals("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User();
			user.setEmail(email);
			user.setPassword(password);

			GlobalServiceInterface gService = RevShopServiceFactory.createObject("global");
			User b = gService.signinService(user);
			if(b!=null) {
				
				HttpSession session=request.getSession(true);
				session.setAttribute("email", email);
				Cookie ck=new Cookie("userId",""+b.getUserId());//creating cookie object  
				response.addCookie(ck);
			System.out.println(b.isIsblocked());
			if(b.isIsblocked()) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/account-suspended.jsp");
				rd.forward(request, response);
			}else 	
			if (b.getRole().equals("admin")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/adminHomepage.jsp");
				rd.forward(request, response);
			}else
			if (b.getRole().equals("retailer")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/retailerHomepage.jsp");
				rd.forward(request, response);
			}else
			if (b.getRole().equals("buyer")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/buyerHomepage.jsp");
				rd.forward(request, response);
			}
			}
		}
		if (taskType.equals("signup")) {
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			String address = request.getParameter("address");
			String fullName = request.getParameter("fullname");
			String pincode = request.getParameter("pincode");
			String role = request.getParameter("userType");
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setAddress(address);
			user.setFullName(fullName);
			user.setPincode(pincode);
			user.setRole(role);

			GlobalServiceInterface gService = RevShopServiceFactory.createObject("global");
			User b = gService.signupService(user);
			Cookie ck= new Cookie("userId",""+b.getUserId());//creating cookie object  
			response.addCookie(ck);
			if(!b.isIsblocked()) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/account-suspended.jsp");
				rd.forward(request, response);
			}else
			if(b!=null) {
				
				HttpSession session=request.getSession(true);
				session.setAttribute("email", email);
			
			if (b.getRole().equals("retailer")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/retailerHomepage.jsp");
				rd.forward(request, response);
			}else
			if (b.getRole().equals("buyer")) {
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/buyerHomepage.jsp");
				rd.forward(request, response);
			}
			}
		}
		if (taskType.equals("validateEmail")) {
			
			String str="Valid Email";
			
			String email=request.getParameter("email");
			User b=new User();
			b.setEmail(email);
			
			GlobalServiceInterface gService = RevShopServiceFactory.createObject("global");
			boolean b1 = gService.validateEmailService(b);
			
			if(b1) {
				str="Email Already Register with This website";
			}
			request.setAttribute("result", str);
			System.out.println(str);
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/emailresult.jsp");
			rd.forward(request, response);
		}
	}

}













