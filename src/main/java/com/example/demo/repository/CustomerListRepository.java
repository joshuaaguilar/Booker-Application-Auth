package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CustomerList;

public interface CustomerListRepository extends CrudRepository<CustomerList, Integer> {

}
