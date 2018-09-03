package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ServiceModel;
import com.example.demo.model.Travelpackage;

@Repository
public interface TravelPackageServiceRepository extends CrudRepository<ServiceModel, Integer> {

	List<ServiceModel> findByTravelpackage(Travelpackage TravelPackage);
}
