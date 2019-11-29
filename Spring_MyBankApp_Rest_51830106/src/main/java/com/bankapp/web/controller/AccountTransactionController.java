package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountForm;
import com.bankapp.model.entities.MoneyForm;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.repo.TransactionLogRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.TransactionNotFoundException;

@RestController
@RequestMapping(path="/api/transaction")
public class AccountTransactionController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TransactionLogService tnxService;
	
	@Autowired
	private TransactionLogRepository tnxRepo;
	
	
	private AccountService accService;
	
	@Autowired
	public AccountTransactionController(AccountService accService){
		this.accService=accService;
	}
	@PostMapping(path="transfer",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>transferAccount(@RequestBody AccountForm accountform){
		
		accService.transfer(accountform.getFromAccount(),accountform.getToAccount(),accountform.getAmount());
		
		return new ResponseEntity<Account>(HttpStatus.OK) ;
		
		
	}
	@PostMapping(path="deposit",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>depoiteAccount(@RequestBody MoneyForm form){
		
		accService.deposit(form.getFromAccount(), form.getAmount());
		
		return new ResponseEntity<Account>(HttpStatus.OK) ;
		
		
	}
	@PostMapping(path="withdraw",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>withdrawAmount(@RequestBody MoneyForm form){
		
		accService.withdraw(form.getFromAccount(), form.getAmount());
		
		return new ResponseEntity<Account>(HttpStatus.OK) ;
		
		
	}
	
	@GetMapping(path="alltransaction",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionLog>getAllTransaction(){
		return tnxService.getAllTransaction();
		
	}
	@GetMapping(path="alltransaction/{fromAccount}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>>getAllTransactionById(
			@PathVariable(name="fromAccount")Long fromAccount){
		
		return new ResponseEntity<List<TransactionLog>>(tnxService.findByfromAccount(fromAccount),HttpStatus.OK);
		
	}
}
