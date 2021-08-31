package com.assignment.one.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.one.Customer.Customer;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{

List<Customer> findByname(String name);
List<Customer> findByMobile(long mobile);
List<Customer> findByCity(String city);
List<Customer> findByEmail(String email);
}
