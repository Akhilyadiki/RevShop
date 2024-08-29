package com.revshop.service;

import java.util.List;

import com.revshop.dao.AdminDAOInterface;
import com.revshop.dao.BuyerDAOInterface;
import com.revshop.entity.Bill;
import com.revshop.entity.Category;
import com.revshop.entity.Order;
import com.revshop.entity.OrderDetails;
import com.revshop.entity.Item;
import com.revshop.entity.RateReview;
import com.revshop.utility.RevShopDAOFactory;

public class BuyerService implements BuyerServiceInterface{
	
	private BuyerDAOInterface bdi;

	@Override
	public Item viewProductDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> browseProductsByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProductsToCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProductsToCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill checkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailNotifications() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewOrderHistory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RateReview rateAndReviewProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String complaintAgainstTheSeller() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnADefectiveProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveProductAsFavorite() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails generateInvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeaymentUsingThePaymentGateway() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getFeaturedItems() {
		 bdi = RevShopDAOFactory.createObjectBuyer("buyer");
		return bdi.getFeaturedItems();
	}

	@Override
	public List<Category> getCategories() {
		bdi = RevShopDAOFactory.createObjectBuyer("buyer");
		return bdi.getFeaturedCategory();
	}

	@Override
	public List<Item> getItemsByCategory(String categoryName) {
		bdi = RevShopDAOFactory.createObjectBuyer("buyer");
		return bdi.getItemsByCategory(categoryName);
	}

}
