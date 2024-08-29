package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Bill;
import com.revshop.entity.Category;
import com.revshop.entity.Order;
import com.revshop.entity.OrderDetails;
import com.revshop.entity.Item;
import com.revshop.entity.RateReview;

public interface BuyerDAOInterface {
	Item viewProductDetailsDAO();
	List<Item> browseProductsByCategoryDAO();
	String addProductsToCartDAO();
	String removeProductsToCartDAO();
	Bill checkoutDAO();
	String getEmailNotificationsDAO();
	List<Order> viewOrderHistoryDAO();
	RateReview rateAndReviewProductsDAO();
	String complaintAgainstTheSellerDAO();
	String returnADefectiveProductDAO();
	String saveProductAsFavoriteDAO();
	OrderDetails generateInvoiceDAO();
	String makeaymentUsingThePaymentGatewayDAO();
	List<Item> getFeaturedItems();
	List<Category> getFeaturedCategory();
	List<Item> getItemsByCategory(String string);
}
