package com.revshop.utility;

import com.revshop.service.AdminService;
import com.revshop.service.AdminServiceInterface;
import com.revshop.service.BuyerService;
import com.revshop.service.BuyerServiceInterface;
import com.revshop.service.GlobalService;
import com.revshop.service.GlobalServiceInterface;
import com.revshop.service.RetailerService;
import com.revshop.service.RetailerServiceInterface;

public class RevShopServiceFactory {

	public static GlobalServiceInterface createObject(String serviceType) {
		if(serviceType.equals("global")) {
			return new GlobalService();
		}
		
		return null;
	}
	
	public static AdminServiceInterface createObjectforAdminService(String serviceType) {
		if(serviceType.equals("admin")) {
			return new AdminService();
		}
		
		return null;
	}
	
	public static BuyerServiceInterface createObjectforBuyerService(String serviceType) {
		if(serviceType.equals("buyer")) {
			return new BuyerService();
		}
		
		return null;
	}
	
	public static RetailerServiceInterface createObjectforRetailerService(String serviceType) {
		if(serviceType.equals("retailer")) {
			return new RetailerService();
		}
		
		return null;
	}

}
