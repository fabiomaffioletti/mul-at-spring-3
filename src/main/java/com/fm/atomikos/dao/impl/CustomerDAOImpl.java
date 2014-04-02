package com.fm.atomikos.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fm.atomikos.dao.CustomerDAO;
import com.fm.atomikos.exception.StoreException;
import com.fm.atomikos.mapper.CustomerRowMapper;
import com.fm.atomikos.model.Customer;

@Repository(value = "customerDAO")
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private JdbcTemplate jdbcTemplateCustomer;

	@PersistenceContext(unitName = "PersistenceUnitA")
	private EntityManager entityManager;

	public Customer get(Integer id) {
		return jdbcTemplateCustomer.queryForObject("SELECT * FROM customer WHERE id = " + id, new CustomerRowMapper());
	}

	public void save(String name) {
		jdbcTemplateCustomer.update("INSERT INTO customer (name, age) VALUES (?, 0)", name);
	}

	public void incrementOrders(Integer customerId) {
		jdbcTemplateCustomer.update("UPDATE customer SET age = age + 1 WHERE id = ?", customerId);
	}

	public void incrementOrdersWithException(Integer customerId) throws StoreException {
		throw new StoreException();
	}

	public void persist(Customer customer) {
		entityManager.persist(customer);
	}

}
