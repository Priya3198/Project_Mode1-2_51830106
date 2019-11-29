package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.model.entities.AppUser;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.UserNotFountException;
@Service
public class DetailService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	AppUser user= userService.findByEmail(email);
	if(user==null)
	throw new UserNotFountException();
		return new User(user.getEmail(),user.getPassword(),AuthorityUtils.createAuthorityList(user.getRoles()));
	}

}
