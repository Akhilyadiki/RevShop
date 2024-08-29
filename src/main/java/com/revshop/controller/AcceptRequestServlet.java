package com.revshop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.service.AdminServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/accept-request")
public class AcceptRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminServiceInterface asi;

    @Override
    public void init() throws ServletException {
        asi = RevShopServiceFactory.createObjectforAdminService("admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        boolean success;
        try {
            asi.unblockUser(userId);
            success = true;
        } catch (Exception e) {
            success = false;
        }

        // Return a JSON response
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print("{\"success\":" + success + "}");
        out.flush();
    }
}
