package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entity.User;

public interface UserServices {

	
	User saveUser(User user);
	
	List<User> getAllUSer();
	
	
	User getUser(String userId);
}
