package com.revshop.service;

import java.util.List;

import com.revshop.entity.Item;

public interface RetailerServiceInterface {
	int registerSeller();
	//• ReceiveAnEmailRegardingRegistrationStatus();
	 List<Item> manageInventoryAndProductDetails();
	int addProducts(Item product);
	 List<Item> placedOrders();
	//• Receive email notifications when a user places an order.
	String discounts();
	List<Item> graphicalDashboard();
	String getNotificationWhenUserSubmitsAReview();
	List<Item> lowStockInventory();
}
