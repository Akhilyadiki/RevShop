package com.revshop.service;

import com.revshop.entity.User;

public interface GlobalServiceInterface {

	User signinService(User user);
	User signupService(User user);
	boolean validateEmailService(User b);

}