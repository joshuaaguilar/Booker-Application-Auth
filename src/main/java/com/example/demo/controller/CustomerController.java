package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
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
	public void delete(@PathVariable("deleteId") int id) {
		customerService.delete(id);
	}

	@PutMapping("/{updateId}")
	public Customer updateCustomer(@PathVariable("updateId") int id, @RequestBody Customer customer) {
		customer.setCustomerId(id);
		return customerService.save(customer);

	}

	@GetMapping
	public List<Customer> getAll() {
		return customerService.gellAllListOfCustomer();
	}

	@PostMapping
	public List<Customer> saveList(@RequestBody List<Customer> customerList) {
		return customerService.saveList(customerList);
	}

	@DeleteMapping
	public void deleteList(@RequestParam("customerId") int[] ids) {
		customerService.deleteList(ids);
	}

	@PostMapping("login")
	public String Login(@RequestBody Customer customer) {
		return customerService.Login(customer);
	}
}
