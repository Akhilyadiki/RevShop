package com.revshop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.service.ComplaintService;
import com.revshop.service.ComplaintServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete-complaint")
public class DeleteComplaintServlet extends HttpServlet {
    private ComplaintServiceInterface complaintService;

    @Override
    public void init() throws ServletException {
        complaintService = new ComplaintService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int complaintId = Integer.parseInt(request.getParameter("complaintId"));

        boolean success;
        try {
            complaintService.deleteComplaint(complaintId);
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
