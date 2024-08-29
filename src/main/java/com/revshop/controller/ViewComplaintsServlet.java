package com.revshop.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.entity.Complaint;
import com.revshop.service.ComplaintService;
import com.revshop.service.ComplaintServiceInterface;

import java.io.IOException;
import java.util.List;

@WebServlet("/view-complaints")
public class ViewComplaintsServlet extends HttpServlet {
    private ComplaintServiceInterface complaintService;

    @Override
    public void init() throws ServletException {
        complaintService = new ComplaintService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch complaints from the database
        List<Complaint> complaints = complaintService.getAllComplaints();

        // Set complaints as a request attribute
        request.setAttribute("complaints", complaints);

        // Forward to the JSP page
        request.getRequestDispatcher("view-complaints.jsp").forward(request, response);
    }
}
