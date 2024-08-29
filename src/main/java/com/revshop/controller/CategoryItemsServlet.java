package com.revshop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revshop.entity.Item;
import com.revshop.service.BuyerServiceInterface;
import com.revshop.utility.RevShopServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet("/category-items")
public class CategoryItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BuyerServiceInterface bsi;

    @Override
    public void init() throws ServletException {
        bsi = RevShopServiceFactory.createObjectforBuyerService("buyer");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoryName = request.getParameter("category");

        // Get items for the selected category
        List<Item> items = bsi.getItemsByCategory(categoryName);

        // Set items as a request attribute
        request.setAttribute("items", items);

        // Forward to the JSP page
        request.getRequestDispatcher("category-items.jsp").forward(request, response);
    }
}
