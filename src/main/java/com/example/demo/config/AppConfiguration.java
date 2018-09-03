package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.AuthenticationRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ServiceRepository;
import com.example.demo.repository.TravelPackageRepository;
import com.example.demo.repository.TravelPackageServiceRepository;
import com.example.demo.service.CustomerService;
import com.example.demo.service.TravelPackageService;
import com.example.demo.service.TravelPackageServiceService;

@Configuration
public class AppConfiguration {

	@Bean
	public CustomerService customerService(CustomerRepository customerRepository,
			AuthenticationRepository authenticationRepository) {
		return new CustomerService(customerRepository, authenticationRepository);
	}

	@Bean
	public TravelPackageService travelPackageService(TravelPackageRepository travelPackageRepository,
			ImageRepository imageRepository, ServiceRepository serviceRepository) {
		return new TravelPackageService(travelPackageRepository, imageRepository, serviceRepository);
	}

	@Bean
	public TravelPackageServiceService travelPackageServiceService(
			TravelPackageServiceRepository travelPackageServiceRepository,
			TravelPackageRepository travelPackageRepository) {
		return new TravelPackageServiceService(travelPackageServiceRepository, travelPackageRepository);
	}

}
