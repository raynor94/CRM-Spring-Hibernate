package com.raynor.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.raynor.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Customer> getCustomers() {
		//get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		//create query
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query
		List<Customer> customers = theQuery.getResultList();
		//return result
		return customers;
	}
	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}
	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer customer = getCustomer(id);
		session.delete(customer);
		
	}

}
