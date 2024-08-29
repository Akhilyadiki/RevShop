package com.revshop.dao;

import java.util.List;

import com.revshop.entity.Item;

public interface RetailerDAOInterface {
	int registerSeller();
	//• ReceiveAnEmailRegardingRegistrationStatus();
	 List<Item> manageInventoryAndProductDetailsDAO();
	int addProductsDAO(Item product);
	 List<Item> placedOrdersDAO();
	//• Receive email notifications when a user places an order.
	String discountsDAO();
	List<Item> graphicalDashboardDAO();
	String getNotificationWhenUserSubmitsAReviewDAO();
	List<Item> lowStockInventoryDAO();
}
