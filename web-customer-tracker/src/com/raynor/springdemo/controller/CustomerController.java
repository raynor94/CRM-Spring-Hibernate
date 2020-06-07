package com.raynor.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.raynor.springdemo.entity.Customer;
import com.raynor.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//need to inject DAO
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		//get customers from DAO
		List<Customer> theCustomers = customerService.getCustomers();
		//System.out.println(theCustomers.toString());
		//add customers to spring MVC model
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		Customer customer = customerService.getCustomer(theId);
		model.addAttribute("customer", customer);
		return "customer-form";
		
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId, Model model) {
		customerService.delete(theId);
		return "redirect:/customer/list";
	}
}
