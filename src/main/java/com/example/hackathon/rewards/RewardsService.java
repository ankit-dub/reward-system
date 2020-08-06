package com.example.hackathon.rewards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hackathon.model.Customer;

@Service
public class RewardsService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public List<Customer> getCustomerAll() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(Integer customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}




}
