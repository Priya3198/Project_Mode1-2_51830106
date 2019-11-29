package com.bankapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.UserService;

@Controller
@RequestMapping(path="clerk")
public class ClerkAccountController {
	
	@Autowired
	private AccountService accService;
	
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "allaccounts_view", method = RequestMethod.GET)
	public ModelAndView allAccounts(ModelAndView mv) {
		mv.setViewName("allaccounts_view");
		mv.addObject("accounts", accService.getAllAccount());
		return mv;

	}
	
	
	@RequestMapping("/allappusers")
	public ModelAndView getAllAppUsers(ModelAndView mv){
		mv.setViewName("allappusers_view");
		mv.addObject("users", userService.findAll());
		return mv;
	}
	
	/*@RequestMapping("/logout")
	public String logout(){
		return "redirect:login";
	}
	*/
	

}
