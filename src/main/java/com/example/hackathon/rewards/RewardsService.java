package com.example.hackathon.rewards;

import java.util.List;
import java.util.Optional;

import com.example.hackathon.Exception.RecordNotFoundException;
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
	
	public  Customer getCustomerById(Integer customerId) throws RecordNotFoundException {
		Optional<Customer> customer=customerRepository.findById(customerId);
		if(customer.isPresent()){
			return customer.get();
		}else {
			throw new RecordNotFoundException("No expense exist for given id");
		}
	}




}
