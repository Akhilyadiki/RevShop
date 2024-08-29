package com.revshop.utility;

import com.revshop.dao.AdminDAO;
import com.revshop.dao.AdminDAOInterface;
import com.revshop.dao.BuyerDAO;
import com.revshop.dao.BuyerDAOInterface;
import com.revshop.dao.GlobalDAO;
import com.revshop.dao.GlobalDAOInterface;
import com.revshop.dao.RetailerDAO;
import com.revshop.dao.RetailerDAOInterface;


public class RevShopDAOFactory {

	public static GlobalDAOInterface createObject(String daoType) {
		if(daoType.equals("global")) {
			return new GlobalDAO();
		}
		return null;
	}
	public static AdminDAOInterface createObjectAdmin(String daoType) {
		if(daoType.equals("admin")) {
			return new AdminDAO();
		}
		return null;
	}
	public static BuyerDAOInterface createObjectBuyer(String daoType) {
		if(daoType.equals("buyer")) {
			return new BuyerDAO();
		}
		return null;
	}
	public static RetailerDAOInterface createObjectSeller(String daoType) {
		if(daoType.equals("seller")) {
			return new RetailerDAO();
		}
		return null;
	}

}
