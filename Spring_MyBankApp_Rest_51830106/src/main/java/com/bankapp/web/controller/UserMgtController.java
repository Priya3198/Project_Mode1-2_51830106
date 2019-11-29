package com.bankapp.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.AppUser;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.UserService;

@RestController
@RequestMapping(path="/api/user")
public class UserMgtController {

	@Autowired
	private UserService userService;
	
	
	
	
	@GetMapping(path="allusers",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<AppUser> getAlluser(){
		return userService.findAll();
		
	}
	@PostMapping(path="/adduser",consumes=MediaType.APPLICATION_JSON_VALUE
			,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AppUser> addProduct(@RequestBody AppUser user){
			return new ResponseEntity<AppUser>(userService.addUser(user),HttpStatus.OK);
			}
}
