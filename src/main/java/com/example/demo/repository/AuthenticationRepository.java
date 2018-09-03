package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Authentication;
import com.example.demo.model.Customer;

public interface AuthenticationRepository extends CrudRepository<Authentication, Integer> {

	public Authentication findByToken(String token);

	public Authentication findByCustomer(Customer customer);
}
