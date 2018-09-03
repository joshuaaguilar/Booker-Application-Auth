package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
	public Customer getAllCustomers(@RequestHeader String token, @PathVariable("customerId") int id) {
		return customerService.findById(id);
	}

	@DeleteMapping("/{deleteId}")
	public void delete(@RequestHeader String token, @PathVariable("deleteId") int id) {
		customerService.delete(id);
	}

	@PutMapping("/{updateId}")
	public Customer updateCustomer(@RequestHeader String token, @PathVariable("updateId") int id,
			@RequestBody Customer customer) {
		customer.setCustomerId(id);
		return customerService.save(customer);

	}

	@GetMapping
	public List<Customer> getAll(@RequestHeader String token) {
		return customerService.gellAllListOfCustomer();
	}

	@PostMapping
	public List<Customer> saveList(@RequestHeader String token, @RequestBody List<Customer> customerList) {
		return customerService.saveList(customerList);
	}

	@DeleteMapping
	public void deleteList(@RequestHeader String token, @RequestParam("customerId") int[] ids) {
		customerService.deleteList(ids);
	}

	@PostMapping("login")
	public String Login(@RequestBody Customer customer) {
		return customerService.Login(customer);
	}

	@DeleteMapping("Logout")
	public void Logout(@RequestHeader String token) {
		customerService.logout(token);
	}
}
