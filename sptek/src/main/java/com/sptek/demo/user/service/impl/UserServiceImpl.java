package com.sptek.demo.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sptek.demo.user.model.Users;
import com.sptek.demo.user.repository.UserRepository;
import com.sptek.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	@Override
	public Users createUser(Users users) {
		// TODO Auto-generated method stub
		return userRepository.save(users);
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
}
