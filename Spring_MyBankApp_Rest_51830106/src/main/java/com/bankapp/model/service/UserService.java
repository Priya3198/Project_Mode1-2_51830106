package com.bankapp.model.service;
import java.util.*;
import com.bankapp.model.entities.AppUser;

public interface UserService {
	public AppUser findByEmail(String email);
	public AppUser addUser(AppUser user);
	public List<AppUser> findAll();
	public void blockUser(Long userId);
	public void deleteUser(Long userId);
}
