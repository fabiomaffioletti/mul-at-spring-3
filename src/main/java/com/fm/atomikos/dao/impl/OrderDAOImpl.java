package com.fm.atomikos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fm.atomikos.dao.OrderDAO;
import com.fm.atomikos.mapper.OrderRowMapper;
import com.fm.atomikos.model.Order;

@Repository(value = "orderDAO")
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplateOrder;

	@PersistenceContext(unitName = "PersistenceUnitB")
	private EntityManager entityManager;

	public Order get(Integer id) {
		return jdbcTemplateOrder.queryForObject("SELECT * FROM orders WHERE id = " + id, new OrderRowMapper());
	}

	public void save(Order order) {
		jdbcTemplateOrder.update("insert into orders(code, quantity) values (?, ?)", order.getCode(), order.getQuantity());
	}

	public void persist(Order order) throws Exception {
		entityManager.persist(order);
//		throw new Exception();
	}

}
