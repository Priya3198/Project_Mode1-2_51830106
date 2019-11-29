package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;

public interface AccountService {
	public List<Account> getAllAccount();
	public List<Customer> getAllCustomer();
	void blockAccount(Long accountNumber);
	 void removeCustomer(Long id);
	 Customer updateCustomer(Customer customer);
	Account createAccount(Account account );
	Customer getCustomerById(Long id);
	Account getAccountById(Long id);
    void deposit(Long accountNumber, double amount);
    void withdraw(Long accountNumber, double amount);
    void transfer(Long fromAccNumber, Long toAccNumber, double amount);
}
