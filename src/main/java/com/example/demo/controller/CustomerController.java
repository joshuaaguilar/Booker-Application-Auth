package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{customerId}")
	public Customer getAllCustomers(@PathVariable("customerId") int id) {
		return customerService.findById(id);
	}

	@DeleteMapping("/{deleteId}")
	public List<Customer> delete(@PathVariable("deleteId") int id) {
		customerService.delete(id);
		return customerService.gellAllListOfCustomer();
	}

	@PutMapping("/{updateId}")
	public List<Customer> updateCustomer(@PathVariable("updateId") int id, @RequestBody Customer customer) {
		customer.setCustomerId(id);
		customerService.saveListOfCustomer(customer);
		return customerService.gellAllListOfCustomer();
	}

	@GetMapping
	public List<CustomerList> getAll() {
		return customerService.getAllList();
	}

	@PostMapping
	public CustomerList saveList(@RequestBody CustomerList customerList) {
		return customerService.saveList(customerList);
	}

	@DeleteMapping("/{customerIdList}")
	public List<CustomerList> deleteList(@PathVariable("customerIdList") int[] ids) {
		return customerService.deleteList(ids);
	}
}
