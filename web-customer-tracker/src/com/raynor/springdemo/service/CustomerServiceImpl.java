package com.raynor.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raynor.springdemo.dao.CustomerDAO;
import com.raynor.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerDAO.saveCustomer(customer);
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		
		return customerDAO.getCustomer(id);
	}
	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		customerDAO.delete(id);
		
	}

}
