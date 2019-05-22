package com.group.motor.services.imp;

import org.springframework.security.core.context.SecurityContextHolder;

import com.group.motor.security.UserSS;
import com.group.motor.services.UserService;

public class UserServiceImp implements UserService{

	@Override
	public UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
