package com.fm.atomikos.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fm.atomikos.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:spring-context.xml" })
public class OrderDAOTest {
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Test
	public void testGet() {
		Order order = orderDAO.get(1);
		Assert.assertNotNull(order);
		Assert.assertEquals(1, order.getCode().intValue());
		Assert.assertEquals(10, order.getQuantity().intValue());
	}		

	@Test
	public void testSave() {
		Order order = new Order();
		order.setCode(1);
		order.setQuantity(15);
		orderDAO.save(order);
	}
}
