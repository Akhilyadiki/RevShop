package com.revshop.service;

import com.revshop.dao.GlobalDAOInterface;
import com.revshop.entity.User;
import com.revshop.utility.RevShopDAOFactory;

public class GlobalService implements GlobalServiceInterface {

	@Override
	public User signinService(User user) {
		GlobalDAOInterface gDao=RevShopDAOFactory.createObject("global");
		
		return gDao.signInDAO(user);
	}

	@Override
	public boolean validateEmailService(User b) {
GlobalDAOInterface gDao=RevShopDAOFactory.createObject("global");
		
		return gDao.validateEmailDAO(b);
	}

	@Override
	public User signupService(User user) {
		GlobalDAOInterface gDao=RevShopDAOFactory.createObject("global");
		
		return gDao.signupDAO(user);
	}

}