package com.example.service;

import java.util.List;

import com.example.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer getBooksById(int customerid);

	void delete(int customerid);

	Customer Update(Customer customer, Integer customerid) throws Exception;

}
