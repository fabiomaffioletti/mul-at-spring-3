package com.fm.atomikos.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fm.atomikos.dao.CustomerDAO;
import com.fm.atomikos.dao.OrderDAO;
import com.fm.atomikos.exception.StoreException;
import com.fm.atomikos.jms.JmsProducer;
import com.fm.atomikos.manager.StoreManager;
import com.fm.atomikos.model.Customer;
import com.fm.atomikos.model.Order;

@Service(value = "storeManager")
public class StoreManagerImpl implements StoreManager {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private JmsProducer jmsProducer;

	@Transactional
	public void saveNewOrder(Integer customerId, Integer qty) {
		Order order = new Order();
		order.setCode(customerId);
		order.setQuantity(qty);
		orderDAO.save(order);
		customerDAO.incrementOrders(customerId);
	}

	@Transactional(rollbackFor = StoreException.class)
	public void saveNewOrderWithException(Integer customerId, Integer qty) throws StoreException {
		Order order = new Order();
		order.setCode(customerId);
		order.setQuantity(qty);
		orderDAO.save(order);
		customerDAO.incrementOrdersWithException(customerId);
		throw new StoreException();
	}

	@Transactional(rollbackFor = Exception.class)
	public void persistBoth(Customer customer, Order order) throws Exception {
		customerDAO.persist(customer);
		jmsProducer.sendMessage("enqueuing message...");
		orderDAO.persist(order);
	}

}
