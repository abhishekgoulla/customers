package com.assignment.one.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.one.Customer.Customer;
import com.assignment.one.repo.CustomerDao;
import com.assignment.one.service.CustomerService;




@RestController
public class CustomerController {
	
	@Autowired
	private CustomerDao customerdao;
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/Customers")
	public ResponseEntity<List<Customer>> getCustomer(){
		List<Customer> customers=customerservice.getCustomer();
		 return   ResponseEntity.ok(customers);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> getCustomerbyId(@PathVariable int id){
	    Optional<Customer> customer=   customerservice.getCustomerbyId(id);	
	
		 return   ResponseEntity.ok(customer);
		
	}
	
	
	
	@PostMapping("/join")
	
	public ResponseEntity<String> addCustomer(@RequestBody Customer c) {
		customerservice.addCustomer(c);
		List<Customer> customers=customerservice.getCustomer();
		return ResponseEntity.ok("Successfully Added\n"+customers);
	}
	
	@PutMapping("/change")
	public ResponseEntity<String> updateCustomer(Customer c) {
		if(!customerdao.existsById(c.getId()))throw new DataIntegrityViolationException("Customer not found to update");
		customerservice.updateCustomer(c);
		List<Customer> customers=customerservice.getCustomer();
		return ResponseEntity.ok("Successfully Updated\n"+customers);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeCustomer(@PathVariable int id) {
		 if(!customerdao.existsById(id))throw new EmptyResultDataAccessException("Customer not found", id);
		customerdao.deleteById(id);
		List<Customer> customers=customerservice.getCustomer();
		return ResponseEntity.ok("Successfully Deleted\n"+customers);
	}
	
	
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Customer>> byname(@PathVariable String name) {
	return new ResponseEntity<List<Customer>>(customerdao.findByname(name), HttpStatus.OK);
	}
	@GetMapping("/mobile/{mobile}")
	public ResponseEntity<List<Customer>> bymobile(@PathVariable long moblie) {
		return new ResponseEntity<List<Customer>>(customerdao.findByMobile(moblie), HttpStatus.OK);
}
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Customer>> bycity(@PathVariable String city) {
		return new ResponseEntity<List<Customer>>(customerdao.findByCity(city), HttpStatus.OK);
	}
	@GetMapping("/email/{email}")
	public ResponseEntity<List<Customer>> byemail(@PathVariable String email) {
		return new ResponseEntity<List<Customer>>(customerdao.findByEmail(email), HttpStatus.OK);
	}

}
