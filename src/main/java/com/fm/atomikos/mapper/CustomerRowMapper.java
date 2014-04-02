package com.fm.atomikos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.fm.atomikos.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setName(rs.getString("name"));
		customer.setAge(rs.getInt("age"));
		return customer;
	}

}
