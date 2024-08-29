package com.revshop.dao;

import com.revshop.entity.User;

public interface GlobalDAOInterface {

	User signInDAO(User user);

	boolean validateEmailDAO(User b);

	User signupDAO(User user);

}