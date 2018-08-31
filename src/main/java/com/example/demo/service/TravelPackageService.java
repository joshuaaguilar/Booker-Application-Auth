package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Travelpackage;
import com.example.demo.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;

	public TravelPackageService(TravelPackageRepository travelPackageRepository) {
		this.travelPackageRepository = travelPackageRepository;
	}

	public Travelpackage findById(int id) {
		return travelPackageRepository.findById(id).get();
	}

	public Travelpackage save(Travelpackage travelpackage) {
		return travelPackageRepository.save(travelpackage);
	}

	public List<Travelpackage> delete(int id) {
		travelPackageRepository.delete(findById(id));
		return (List<Travelpackage>) travelPackageRepository.findAll();
	}

	public List<Travelpackage> findAll() {
		return (List<Travelpackage>) travelPackageRepository.findAll();

	}

}
