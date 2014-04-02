package com.fm.atomikos.dao;

import com.fm.atomikos.exception.StoreException;
import com.fm.atomikos.model.Customer;

public interface CustomerDAO {

	// jpa
	void persist(Customer customer);
	
	// jdbc
	Customer get(Integer id);
	
	void save(String name);
	
	void incrementOrders(Integer customerId);
	
	void incrementOrdersWithException(Integer customerId) throws StoreException;

}
