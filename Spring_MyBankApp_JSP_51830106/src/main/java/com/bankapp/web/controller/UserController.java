package com.bankapp.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.formbean.UserFormBean;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;



@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/allusers")
	public ModelAndView getAllAppUsers(ModelAndView mv){
		mv.setViewName("all_appusers");
		mv.addObject("users", userService.findAll());
		return mv;
	}
//	@RequestMapping(value="adduser",method=RequestMethod.GET)
//	 public String addUser(@ModelAttribute(name="formbean") UserFormBean formbean){
//	     AppUser user=new AppUser(formbean.getName(),formbean.getPassword(),formbean.getEmail(),formbean.getPhone(),formbean.getAddress(),formbean.getRoles().split(""),formbean.isActive());
//	     userService.addUser(user);
//		 return "redirect:all_users";
//		 
//	 }
	
	/*
	@ModelAttribute(value="rolesUser")
	public List<String>getRoles(){
		return Arrays.asList("ROLE_ADMIN","ROLE_MGR","ROLE_CLERK");
		
	}*/
	
	
	@RequestMapping(value="addappuser",method=RequestMethod.GET)
	public String addAppUserGet(ModelMap map){
		
		map.addAttribute("appuser",new AppUser());
		return "addappuser";
	}
	@RequestMapping(value="addappuser",method=RequestMethod.POST)
	public String addAccountUpdatePost(AppUser user){
		//mm.addAttribute("appuser",new AppUser());
		userService.addUser(user);
		return "redirect:/admin/allusers";
		

	}
	
}
