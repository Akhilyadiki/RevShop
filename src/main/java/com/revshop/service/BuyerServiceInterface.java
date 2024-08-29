package com.revshop.service;

import java.util.List;

import com.revshop.entity.Bill;
import com.revshop.entity.Category;
import com.revshop.entity.Order;
import com.revshop.entity.OrderDetails;
import com.revshop.entity.Item;
import com.revshop.entity.RateReview;

public interface BuyerServiceInterface {
	Item viewProductDetails();
	List<Item> browseProductsByCategory();
	String addProductsToCart();
	String removeProductsToCart();
	Bill checkout();
	String getEmailNotifications();
	List<Order> viewOrderHistory();
	RateReview rateAndReviewProducts();
	String complaintAgainstTheSeller();
	String returnADefectiveProduct();
	String saveProductAsFavorite();
	OrderDetails generateInvoice();
	String makeaymentUsingThePaymentGateway();
	List<Item> getFeaturedItems();
	List<Category> getCategories();
	List<Item> getItemsByCategory(String categoryName);

}













