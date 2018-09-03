package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.model.Authentication;
import com.example.demo.model.Customer;
import com.example.demo.repository.AuthenticationRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.util.TokenCreator;

public class CustomerService {

	private CustomerRepository customerRepository;
	private AuthenticationRepository authenticationRepository;

	public CustomerService(CustomerRepository customerRepository, AuthenticationRepository authenticationRepository) {
		this.customerRepository = customerRepository;
		this.authenticationRepository = authenticationRepository;

	}

	public List<Customer> gellAllListOfCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer save(Customer customer) {
		return customerRepository.save(customer);

	}

	public Customer findById(int id) {
		return customerRepository.findById(id).get();

	}

	public void delete(int id) {

		customerRepository.deleteById(id);

	}

	public List<Customer> saveList(List<Customer> customerList) {

		return (List<Customer>) customerRepository.saveAll(customerList);

	}

	public void deleteList(int[] customerListId) {
		for (int customerId : customerListId) {
			customerRepository.deleteById(customerId);
		}
	}

	@Transactional
	public String Login(Customer customer) {
		TokenCreator tokenCreator = new TokenCreator();
		Authentication authentication = new Authentication();
		String token = "";

		if (customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword()) != null) {
			customer = customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
			token = tokenCreator.encode(customer);
			authentication.setCustomer(customer);
			authentication.setToken(token);
			authenticationRepository.save(authentication);
		} else {
			throw new RuntimeException("Customers should exist first");

		}
		return token;

	}

	public void logout(String token) {

		authenticationRepository.delete(authenticationRepository.findByToken(token));

	}
}
