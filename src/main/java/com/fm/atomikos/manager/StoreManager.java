package com.fm.atomikos.manager;

import com.fm.atomikos.model.Customer;
import com.fm.atomikos.model.Order;

public interface StoreManager {

	void saveNewOrder(Integer customerId, Integer qty);

	void saveNewOrderWithException(Integer customerId, Integer qty) throws Exception;

	void persistBoth(Customer customer, Order order) throws Exception;

}
