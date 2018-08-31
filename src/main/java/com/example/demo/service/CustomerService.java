package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;

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

}
