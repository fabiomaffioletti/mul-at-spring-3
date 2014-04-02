package com.fm.atomikos.dao;

import com.fm.atomikos.model.Order;

public interface OrderDAO {
	
	//jpa
	void persist(Order order) throws Exception;
	
	//jdbc
	Order get(Integer id);

	void save(Order order);
}
