package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;
import com.example.demo.repository.CustomerListRepository;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private CustomerListRepository customerListRepository;

	public CustomerService(CustomerRepository customerRepository, CustomerListRepository customerListRepository) {
		this.customerRepository = customerRepository;
		this.customerListRepository = customerListRepository;
	}

	public List<Customer> gellAllListOfCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}

	public List<Customer> saveListOfCustomer(Customer customer) {
		customerRepository.save(customer);
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer findById(int id) {
		return customerRepository.findById(id).get();

	}

	public List<Customer> delete(int id) {

		customerRepository.deleteById(id);

		return (List<Customer>) customerRepository.findAll();
	}

	public CustomerList saveList(CustomerList customerList) {
		for (Customer customer : customerList.getCustomerlist()) {
			customer.setCustomerList(customerList);
			customerRepository.save(customer);
		}
		return customerListRepository.save(customerList);

	}

	public List<CustomerList> deleteList(int[] customerListId) {
		for (int listid : customerListId) {
			customerListRepository.deleteById(listid);
		}
		return (List<CustomerList>) customerListRepository.findAll();
	}

	public List<CustomerList> getAllList() {
		return (List<CustomerList>) customerListRepository.findAll();
	}

}
