package com.raynor.springdemo.service;

import java.util.List;

import com.raynor.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public void saveCustomer(Customer customer);
	public Customer getCustomer(int id);
	public void delete(int id);

}
