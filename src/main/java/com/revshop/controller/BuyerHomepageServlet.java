package com.revshop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.entity.Category;
import com.revshop.entity.Item;
import com.revshop.service.BuyerServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/buyer-homepage")
public class BuyerHomepageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BuyerServiceInterface bsi;

    @Override
    public void init() throws ServletException {
        bsi = RevShopServiceFactory.createObjectforBuyerService("buyer");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Item> featuredItems = bsi.getFeaturedItems();
        List<Category> categories = bsi.getCategories();
        if(featuredItems!=null)	System.out.println("I am called");
        // Set the items and categories as request attributes
        request.setAttribute("featuredItems", featuredItems);
        request.setAttribute("categories", categories);

        // Forward to the JSP page
        request.getRequestDispatcher("BuyerHomepage.jsp").forward(request, response);
    }
}
