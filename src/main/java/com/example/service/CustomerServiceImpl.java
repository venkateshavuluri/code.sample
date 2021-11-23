package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repository.save(customer);
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Customer getBooksById(int customerid) {
		// TODO Auto-generated method stub
		return repository.findById(customerid).get();
	}

	@Override
	public void delete(int customerid) {
		// TODO Auto-generated method stub
		repository.deleteById(customerid);
	}

	@Override
	public Customer Update(Customer customer, Integer customerid) throws Exception {
		// TODO Auto-generated method stub
		Customer customerResult = null;

		Optional<Customer> optionalObject = repository.findById(customerid);
		if (optionalObject.isPresent()) {
			Customer customerObj = optionalObject.get();
			customerObj.setCustomerName(customer.getCustomerName());
			customerObj.setCustomerId(customerid);
			customerResult = repository.save(customerObj);
		} else {
			throw new Exception("ID Not found exception");
		}
		return customerResult;
	}

}
