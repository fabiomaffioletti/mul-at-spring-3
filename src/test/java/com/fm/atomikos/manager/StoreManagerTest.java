package com.fm.atomikos.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fm.atomikos.dao.CustomerDAO;
import com.fm.atomikos.dao.OrderDAO;
import com.fm.atomikos.model.Customer;
import com.fm.atomikos.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:spring-context.xml" })
public class StoreManagerTest {

	@Autowired
	private StoreManager storeManager;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private OrderDAO orderDAO;
	
	@Test
	public void testPersistBoth() throws Exception {
		Order order = new Order();
		order.setQuantity(7);
		order.setCode(1);
		Customer customer = new Customer();
		customer.setName("test-name");
		customer.setAge(30);
		storeManager.persistBoth(customer , order);
	}
}
