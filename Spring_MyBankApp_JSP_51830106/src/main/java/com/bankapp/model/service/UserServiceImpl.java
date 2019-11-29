package com.bankapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.repo.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public AppUser findByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

	@Override
	public void addUser(AppUser user) {
		userRepo.save(user);
		
	}

	@Override
	public List<AppUser> findAll() {
		
		return userRepo.findAll();
	}

	@Override
	public void blockUser(Long userId) {
	
		
	}

	@Override
	public void deleteUser(Long userId) {
		userRepo.deleteById(userId);
		
	}

	@Override
	public AppUser updateUser(AppUser user) {
		return userRepo.save(user);
		
	}

}
