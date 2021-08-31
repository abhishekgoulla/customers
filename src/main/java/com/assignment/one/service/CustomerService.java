package com.assignment.one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.one.Customer.Customer;
import com.assignment.one.repo.CustomerDao;



@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao customerdao;
	
	
	
	
	public List<Customer> getCustomer(){
		return (List<Customer>) customerdao.findAll();
		
	}
	
	public void addCustomer(Customer customer) {
		customerdao.save(customer);
		
	}
	
	public void updateCustomer(Customer customer) {
		customerdao.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerdao.deleteById(id);
	}

	public Optional<Customer> getCustomerbyId(int id) {
		return customerdao.findById(id);
		
		
	}

	
	
	
	
	
	

}
