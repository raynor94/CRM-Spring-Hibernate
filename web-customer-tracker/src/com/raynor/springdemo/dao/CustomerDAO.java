package com.raynor.springdemo.dao;

import java.util.List;

import com.raynor.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers(); 
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void delete(int id);
}
