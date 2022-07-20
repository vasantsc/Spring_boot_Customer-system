package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustRepo;
@Service
public class CustService {
	
	@Autowired
	private CustRepo repo;
	
	public void addCust(Customer c) {
		repo.save(c);
	}
	public List<Customer> getAllCust(){
		return repo.findAll();
	}
	
	public Customer getCustById(int id)
	{
		Optional<Customer> c=repo.findById(id);
		if(c.isPresent())
		{
			return c.get();
		}
		return null;	
		}	
	}

