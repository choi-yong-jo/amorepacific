package com.sptek.demo.user.service;

import java.util.List;

import com.sptek.demo.user.model.Users;

public interface UserService {
	Users createUser(Users users);
	
	void deleteUser(Long id);
	
	List<Users> getAllUsers();

}
