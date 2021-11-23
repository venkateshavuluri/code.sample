package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Customer;
import com.example.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	/**
	 * To save the customer info
	 * 
	 * @param customer
	 * @return
	 */
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	/**
	 * 
	 * @return list of customers
	 */
	@GetMapping("/getCustomers")
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}

	// To do ::
	// /getCustomer(id)
	@GetMapping("/getCustomers/{customerid}")
	public Customer getCustomer(@PathVariable("customerid") int customerid) {
		return customerService.getBooksById(customerid);
	}

	// deleteCustomer(id)
	@DeleteMapping("/deleteCustomer/{customerid}")
	private void deleteCustomer(@PathVariable("customerid") int customerid) {
		customerService.delete(customerid);
	}

	// updateCustomer(@RequestBody Customer customer)
	@PutMapping("/updateCustomer/{customerid}")
	private ResponseEntity<?> update(@RequestBody Customer customers, @PathVariable("customerid") Integer customerid)
			throws Exception {

		try {
			return new ResponseEntity<>(customerService.Update(customers, customerid), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}
}
