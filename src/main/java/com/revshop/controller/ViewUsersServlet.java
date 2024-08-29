package com.revshop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.revshop.utility.*;
import com.revshop.entity.User;
import com.revshop.service.AdminServiceInterface;

import java.io.IOException;
import java.util.List;

public class ViewUsersServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
    private AdminServiceInterface asi;

    @Override
    public void init() throws ServletException {
        new RevShopServiceFactory();
        asi = RevShopServiceFactory.createObjectforAdminService("admin");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<User> users = asi.ViewAllUsers();
        request.setAttribute("users", users);

        // Forward to the JSP page
        request.getRequestDispatcher("view-users.jsp").forward(request, response);
    }
}