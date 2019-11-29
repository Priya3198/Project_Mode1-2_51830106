package com.bankapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountForm;
import com.bankapp.model.entities.AccountFormBean;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.entities.MoneyForm;
import com.bankapp.model.entities.AppUser;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.UserService;
import com.bankapp.model.service.exceptions.CustomerNotFoundException;

@RestController
@RequestMapping(path="/api/account/")
public class AccountRestController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserService userService;
	
	
	private AccountService accService;
	
	@Autowired
	public AccountRestController(AccountService accService){
		this.accService=accService;
	}
	
	@GetMapping(path="allaccount",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Account>getAllaccounts(){
		return accService.getAllAccount();
		
	}
	
	@GetMapping(path="allcustomer",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer>getAllcustomer(){
		return accService.getAllCustomer();
		
	}
	
	
	@GetMapping(path="customerbyid/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer>getCustomerById(@PathVariable Long id){
		Customer customer= customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
		return new  ResponseEntity<Customer>(customer,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(path="delete/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void>removeCustomer(@PathVariable(name="id") Long id){
		accService.removeCustomer(id);
		return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	@PostMapping(path="addaccount",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>addAccount(@RequestBody AccountFormBean accountform){
		
		Customer customer=new Customer(accountform.getName(),accountform.getEmail(),accountform.getPhone(),accountform.getAddress(),accountform.getCity(),accountform.getCountry());
		Account account=new Account(accountform.getBalance(),customer,accountform.isBlocked());
		customer.setAccount(account);
		return new ResponseEntity<Account>(accService.createAccount(account),HttpStatus.OK) ;
		
	}
	
	@PutMapping(path="update/{accountNumber}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account>updateAccount(@RequestBody AccountFormBean accountform,@PathVariable(name="accountNumber") Long id){
		
		Customer customer=accService.getCustomerById(id );
		customer.setName(accountform.getName());
		customer.setAddress(accountform.getAddress());
		customer.setPhone(accountform.getPhone());
		customer.setCity(accountform.getCity());
		customer.setCountry(accountform.getCountry());
		customer.setEmail(accountform.getEmail());
		Account account=accService.getAccountById(id);
		account.setBalance(accountform.getBalance());
		account.setBlocked(accountform.isBlocked());
		customer.setAccount(account);
		account.setCustomer(customer);
		return new ResponseEntity<Account>(accService.createAccount(account),HttpStatus.OK) ;
		
		
	}
	
	/*@GetMapping(path="hello")
	public String hello(){
		return "hello to rest";
		
	}*/
	

}
