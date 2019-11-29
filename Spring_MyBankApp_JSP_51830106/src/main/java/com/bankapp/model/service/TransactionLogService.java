package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.TransactionLog;

public interface TransactionLogService {
	List<TransactionLog> getAllTransaction();
	List<TransactionLog> findByfromAccount(Long fromAccount);

}
