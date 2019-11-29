package com.bankapp.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;

import com.bankapp.model.entities.Customer;
import com.bankapp.model.formbean.AccountForm;
import com.bankapp.model.formbean.AccountFormBean;
import com.bankapp.model.formbean.MoneyForm;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;



@Controller
@RequestMapping("mgr")
public class AccountController {
	
	@Autowired
	private AccountService accService;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionLogService tnxService;
	
	/*
	@RequestMapping(value="/")
	public ModelAndView getAccount(ModelAndView mvn){
		mvn.setViewName("all_account");
		mvn.addObject("info", "welcome to spring security");
		return mvn;
		
	}*/

	@RequestMapping(value = "all_accounts", method = RequestMethod.GET)
	public ModelAndView allAccounts(ModelAndView mv) {
		mv.setViewName("all_accounts");
		mv.addObject("accounts", accService.getAllAccount());
		return mv;

	}
	@RequestMapping(value = "transfer", method = RequestMethod.GET)
	public String transferGet(Model model) {
		model.addAttribute("accountForm", new AccountForm());
		return "fund_transfer";

	}
	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public String transferPost(
			@Valid @ModelAttribute(value = "accountForm") AccountForm accountForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "fund_transfer";
		}
		accService.transfer(accountForm.getFromAccount(),
				accountForm.getToAccount(), accountForm.getAmount());
		return "redirect:all_accounts";

	}
	@RequestMapping(value = "deposit", method = RequestMethod.GET)
	public String depositGet(Model model) {
		model.addAttribute("moneyForm", new MoneyForm());
		return "deposit_form";

	}
	@RequestMapping(value = "deposit", method = RequestMethod.POST)
	public String depositPost(
			@Valid @ModelAttribute(value = "moneyForm") MoneyForm moneyForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "deposit_form";
		}
		accService.deposit(moneyForm.getFromAccount(),moneyForm.getAmount());

		return "redirect:all_accounts";
	}
	@RequestMapping(value = "withdraw", method = RequestMethod.GET)
	public String withdrawGet(Model model) {
		model.addAttribute("moneyForm", new MoneyForm());
		return "withdraw_form";

	}

	@RequestMapping(value = "withdraw", method = RequestMethod.POST)
	public String withdrawPost(
			@Valid @ModelAttribute(value = "moneyForm") MoneyForm moneyForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "withdraw_form";
		}
		accService.withdraw(moneyForm.getFromAccount(),moneyForm.getAmount());

		return "redirect:all_accounts";
	}
	@RequestMapping(value="addaccount",method=RequestMethod.GET)
	 public String addAccount(Model model){
		 model.addAttribute("account",new AccountFormBean());
		 return "addaccount";
		 
	 }
	 @PostMapping(path="addaccount")
	 public String addAccountPost(AccountFormBean accountform){
	 Customer customer=new Customer(accountform.getName(),
	 accountform.getEmail(),
	 accountform.getPhone(), accountform.getAddress(),
	 accountform.getCity(), accountform.getCountry());
	 Account account=new Account(accountform.getBalance(), customer, accountform.isBlocked());
	 customer.setAccount(account);
	 accService.createAccount(account);
	 return "redirect:/mgr/all_accounts";

	 }

	@RequestMapping(value = "alltransaction", method = RequestMethod.GET)
	public ModelAndView allTransaction(ModelAndView mv) {
		mv.setViewName("all_transaction");
		mv.addObject("transactions", tnxService.getAllTransaction());
		return mv;

	}

	
	

}
