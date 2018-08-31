package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ServiceModel;

public interface ServiceRepository extends CrudRepository<ServiceModel, Integer> {

}
