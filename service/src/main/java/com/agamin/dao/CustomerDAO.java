package com.agamin.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.agamin.model.Customer;

@Repository
public class CustomerDAO {
	
	@Autowired
	private CassandraOperations template ;

	public Customer getCustomerForEmail(String email) {
		List<Customer> customer = template.select("select * from customer where email ='"+email+"'", Customer.class);
		if(customer.size() == 0) {
			return null;
		}
		return customer.get(0);
	}
	
	public Customer getCustomerForMobile(String mobile) {
		List<Customer> customer = template.select("select * from customer where mobile ='"+mobile+"'", Customer.class);
		if(customer.size() == 0) {
			return null;
		}
		return customer.get(0);
	}

	public void addCustomer(Customer customer) {
		customer.setCustomerid(UUID.randomUUID());
		template.insert(customer);
	}
}
