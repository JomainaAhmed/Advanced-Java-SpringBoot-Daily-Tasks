package com.example.security2.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security2.entity.Customer;
import com.example.security2.repository.CustomerRepo;

@Service
public class CustomerService {
	
	private final CustomerRepo customerRepo;
	private final PasswordEncoder passwordEncoder;
	
	//constructor injection as its safest
	public CustomerService(CustomerRepo customerRepo, PasswordEncoder passwordEncoder) {
		super();
		this.customerRepo = customerRepo;
		this.passwordEncoder = passwordEncoder;
	}

	
	
	//response entity bhi le sakte ho
	public Customer register(Customer customer) {
		String encodedPass = passwordEncoder.encode(customer.getPassword());
		customer.setPassword(encodedPass);
		return customerRepo.save(customer);
	}
	
	public List<Customer> getAllCustomers(){
	    return customerRepo.findAll();
	}
	
}
